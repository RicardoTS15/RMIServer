/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author Ricardo
 */
public class PostgreSQL {
    private final Connection con;
    public PostgreSQL() throws SQLException, ClassNotFoundException{
        Class.forName("org.postgresql.Driver");
        con = DriverManager.getConnection("jdbc:postgresql://localhost:30000/DSD","postgres"," ");
    }
    
    public ResultSet ejecutaQuery(String query) throws SQLException{
        PreparedStatement stmt = con.prepareStatement(query);
        return stmt.executeQuery();
    }
}
