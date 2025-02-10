/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.sql.*;

/**
 *
 * @author TuKK
 */
public class dbConnection {

    static String url = "jdbc:mysql://localhost:3306/sistema_ticket";
    static String user = "UserSistemaTicket";
    static String pass = "1234";

    public static Connection conectar() {
        Connection con = null;
        try {
            con = DriverManager.getConnection(url, user, pass);
            System.out.println("Conexion exitosa");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }
}
