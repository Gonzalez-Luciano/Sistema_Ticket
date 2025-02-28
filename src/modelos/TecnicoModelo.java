/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import Clases.Mensaje;
import Clases.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author ramir
 */
public class TecnicoModelo {
    
    public void actualizarTecnico(Usuario tecnico, int marca, int falla){
        String sql = "UPDATE tecnicos SET marcas=? WHERE usuario_id=?;\n"+
                     "UPDATE tecnicos SET fallas=? WHERE usuario_id=?;";
        int tecnicoId = tecnico.getLegajo() -99;
        try(Connection conn = dbConnection.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1,marca);
            stmt.setInt(2, tecnicoId);
            stmt.setInt(3, falla);
            stmt.setInt(4, tecnicoId);
            if(stmt.execute()){
                System.out.println(Mensaje.EXITO);
            }else{
                System.out.println("stmt.execute() -> FALSE");
                
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public void bloquearTecnico(Usuario tecnico){
        String sql = "UPDATE usuarios SET estado='bloqueado' WHERE usuario_id=?;";
        int tecnicoId = tecnico.getLegajo() -99;
        try(Connection conn = dbConnection.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1,tecnicoId);
          
            stmt.execute(); 
            
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    
    
}
