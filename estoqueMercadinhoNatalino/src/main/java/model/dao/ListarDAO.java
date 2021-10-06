/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.bean.Historico;

/**
 *
 * @author Aluno
 */
public class ListarDAO {

    private Connection con;

    public List<Historico> read() {

        List<Historico> historicos = new ArrayList<>();

        try {
            Connection con = ConnectionFactory.getConnection();
            PreparedStatement stmt = null;
            
            stmt = con.prepareStatement("SELECT * FROM produto;");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                Historico historico = new Historico();

                historico.setDescricaoProduto(rs.getString("descricaoProduto"));
                
                historicos.add(historico);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{            
            //ConnectionFactory.closeConnection(con, stmt);       
        }
        return historicos;
    }
    
}
