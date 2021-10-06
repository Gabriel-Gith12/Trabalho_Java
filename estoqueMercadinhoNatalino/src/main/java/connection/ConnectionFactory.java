/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Aluno
 */
public class ConnectionFactory {

    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/estoquemercadinho";
    private static final String USER = "root";
    private static final String PASS = "";

    public static Connection getConnection() {

        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USER, PASS);

        } catch (ClassNotFoundException | SQLException ex) {

            throw new RuntimeException("Erro ", ex);
        }
    }

    /**
     *
     * @param con
     * @param stmt
     * @param rs
     */
    public static void closeConnection(Connection con, PreparedStatement stmt) {

        closeConnection(con, stmt);
        try {
            if (stmt != null) {
                stmt.close();
            }

        } catch (SQLException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
