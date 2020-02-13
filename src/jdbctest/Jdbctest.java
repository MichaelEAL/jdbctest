/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbctest;

import java.sql.*;
/**
 *
 * @author Michael
 */
public class Jdbctest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String user = "root";
        String password = "1234";
        final String connectionString = 
                "jdbc:mysql://localhost:3306/sakila?serverTimezone=UTC";
        
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        
        try {
            connection = DriverManager
                    .getConnection(connectionString,
                            user,
                            password);
            statement = connection.createStatement();
            
            resultSet = statement.executeQuery("SELECT * FROM `prueba`.`videogames`;");
            
            while (resultSet.next()) {
                System.out.print("Film ID: ");
                System.out.print(resultSet.getInt("film_id"));
                System.out.print("\tFilm Title: ");
                System.out.println(resultSet.getString("title"));
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            // Clean up
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException ex) {}
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {}
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {}
            }
        }
    }
    
}
