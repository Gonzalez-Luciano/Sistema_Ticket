/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema_ticket;

import modelos.dbConnection;

/**
 *
 * @author TuKK
 */
public class Sistema_Ticket {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        dbConnection dbc = new dbConnection();
        dbc.conectar();
    }
    
}
