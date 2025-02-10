/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import Clases.Administrador;
import Clases.AuthResponse;
import Clases.Mensaje;
import Clases.Tecnico;
import Clases.Trabajador;
import Clases.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author TuKK
 */
public class UsuarioModelo {

    public Mensaje crearUsuario(Usuario usuario) {
        String query = "CALL crearUsuario(?, ?, ?, ?)";
        try (Connection conn = dbConnection.conectar();
                PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, usuario.getNombre());
            stmt.setString(2, usuario.getTipo());
            stmt.setString(3, usuario.getDNI());
            String hashedPassword = BCrypt.hashpw(usuario.getContrasena(), BCrypt.gensalt());
            stmt.setString(4, hashedPassword);
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0 ? Mensaje.EXITO : Mensaje.ERROR;
        } catch (SQLIntegrityConstraintViolationException e) {
            e.printStackTrace();
            return Mensaje.ERROR_DNI_REPETIDO;
        } catch (SQLException e) {
            e.printStackTrace();
            return Mensaje.ERROR;
        }
    }

    public AuthResponse validarUsuario(String dni, String contrasena) {
        String sql = "SELECT u.*, t.fallas, t.marcas "
                + "FROM usuarios u "
                + "LEFT JOIN tecnicos t ON u.usuario_id = t.usuario_id "
                + "WHERE u.dni = ?";

        try (Connection conn = dbConnection.conectar();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, dni);
            ResultSet rs = stmt.executeQuery();

            //El usuario no se encontro
            if (!rs.next()) {
                return new AuthResponse(null, Mensaje.USUARIO_NO_ENCONTRADO);
            }

            String hashedPassword = rs.getString("contrasena");

            //Se encontro el usuario pero la contraseña es incorrecta
            if (!BCrypt.checkpw(contrasena, hashedPassword)) {
                return new AuthResponse(null, Mensaje.ERROR_DATO_INCORRECTO);
            }

            String tipo = rs.getString("tipo");
            Usuario usuario = null;

            // Crear el usuario correcto según el tipo
            switch (tipo.toLowerCase()) {
                case "administrador":
                    usuario = new Administrador(rs.getString("nombre"), dni, rs.getInt("legajo"), contrasena, rs.getString("estado"));
                    break;
                case "tecnico":
                    int fallas = rs.getInt("fallas");
                    int marcas = rs.getInt("marcas");
                    usuario = new Tecnico(rs.getString("nombre"), dni, rs.getInt("legajo"), contrasena, rs.getString("estado"), fallas, marcas);
                    break;
                case "trabajador":
                    usuario = new Trabajador(rs.getString("nombre"), dni, rs.getInt("legajo"), contrasena, rs.getString("estado"));
                    break;
                default:
                    return new AuthResponse(null, Mensaje.USUARIO_NO_ENCONTRADO);
            }

            return new AuthResponse(usuario, Mensaje.EXITO);

        } catch (SQLException e) {
            e.printStackTrace();
            return new AuthResponse(null, Mensaje.ERROR_CONEXION);
        }
    }

    public List<Usuario> obtenerTodosLosUsuarios(Usuario usuarioNoDeseado) {
        List<Usuario> usuarios = new ArrayList<>();
        String sql = "SELECT u.*, t.fallas, t.marcas "
                + "FROM usuarios u "
                + "LEFT JOIN tecnicos t ON u.usuario_id = t.usuario_id";

        try (Connection conn = dbConnection.conectar();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                String tipo = rs.getString("tipo");
                Usuario usuario = null;

                switch (tipo.toLowerCase()) {
                    case "administrador":
                        usuario = new Administrador(
                                rs.getString("nombre"),
                                rs.getString("dni"),
                                rs.getInt("legajo"),
                                rs.getString("contrasena"),
                                rs.getString("estado")
                        );
                        break;
                    case "tecnico":
                        usuario = new Tecnico(
                                rs.getString("nombre"),
                                rs.getString("dni"),
                                rs.getInt("legajo"),
                                rs.getString("contrasena"),
                                rs.getString("estado"),
                                rs.getInt("fallas"),
                                rs.getInt("marcas")
                        );
                        break;
                    case "trabajador":
                        usuario = new Trabajador(
                                rs.getString("nombre"),
                                rs.getString("dni"),
                                rs.getInt("legajo"),
                                rs.getString("contrasena"),
                                rs.getString("estado")
                        );
                        break;
                }

                if (usuario != null && !usuario.equals(usuarioNoDeseado)) {
                    usuarios.add(usuario);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return usuarios;
    }

	public Mensaje modificarContrasenia(String dni, String antiguaContrasena, String nuevaContrasena){
        
        // valido la existencia del usuario
        String sql = "SELECT u.* "
                + " FROM usuarios u "
                + " WHERE u.dni = ? ";

        try (Connection conn = dbConnection.conectar();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, dni);
            ResultSet rs = stmt.executeQuery();

            //El usuario no se encontro
            if (!rs.next()) {
                return Mensaje.USUARIO_NO_ENCONTRADO;
            } else {
                System.out.println("Usuario encontrado\n");
            }

            String hashedPassword = rs.getString("contrasena");

            //Se encontro el usuario pero la contraseña es incorrecta
            if (!BCrypt.checkpw(antiguaContrasena, hashedPassword)) {
                return Mensaje.ERROR_DATO_INCORRECTO;
            } else {
                System.out.println("Contraseña correcta: "+antiguaContrasena+"\n");
            }

            String idStr = rs.getString("usuario_id");
            
            //La contraseña es igual al ID del usuario
            if (nuevaContrasena.equals(idStr)) {
                return Mensaje.ERROR_DATO_INCORRECTO;
            } else {
                System.out.println("Contraseña valida: "+nuevaContrasena+"\n");
            }
            
            String query = "UPDATE usuarios "
                    + " SET contrasena = ? "
                    + " WHERE dni = ? ";
            
            //no es posible reasignar una instancia de PreparedStatement
            PreparedStatement stmt2 = conn.prepareStatement(query);
            
            // reutilizo la variable que utilzamos para validar la password
            hashedPassword = BCrypt.hashpw(nuevaContrasena, BCrypt.gensalt());
            
            stmt2.setString(1, hashedPassword);
            stmt2.setString(2, dni);
            
            int rowsAffected = stmt2.executeUpdate();
            return rowsAffected > 0 ? Mensaje.EXITO : Mensaje.ERROR;
            
        } catch (SQLIntegrityConstraintViolationException e) {
            e.printStackTrace();
            return Mensaje.ERROR_DNI_REPETIDO;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return Mensaje.ERROR;
        }
    }}
