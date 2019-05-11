/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import java.sql.ResultSet;

/**
 *
 * @author Ricardo
 */
public class TestDB {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try{
            System.out.println("Iniciando...");
            PostgreSQL psql = new PostgreSQL();
            ResultSet rs = psql.ejecutaQuery("Select * from alumno");
            while(rs.next()){
                System.out.println(rs.getString("tx_nombre"));
            }                    
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
           
    }
    
}
