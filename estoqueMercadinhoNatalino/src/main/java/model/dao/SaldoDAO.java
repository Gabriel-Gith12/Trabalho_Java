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
import model.bean.Produto;

/**
 *
 * @author Aluno
 */
public class SaldoDAO {
    
    private Connection con;

    public List<Produto> read() {

        List<Produto> saldo = new ArrayList<>();

        try {
            Connection con = ConnectionFactory.getConnection();
            PreparedStatement stmt = null;
            
            stmt = con.prepareStatement("SELECT P.idProduto AS idProduto, P.descricaoProduto AS descricaoProduto,( IFNULL ((SELECT SUM(quantidade) from historico WHERE idOperacao = '1' AND idProduto = P.idProduto ),0) - IFNULL ((SELECT SUM(quantidade) from historico WHERE idOperacao = '2' AND idProduto = P.idProduto ),0)) AS Saldo FROM produto P;");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                Produto saldoProduto = new Produto();

                saldoProduto.setDescricaoProduto(rs.getString("descricaoProduto"));
                saldoProduto.setSaldo(rs.getInt("Saldo"));
                
                saldo.add(saldoProduto);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SaldoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{            
            //ConnectionFactory.closeConnection(con, stmt);       
        }
        return saldo;
    }
}