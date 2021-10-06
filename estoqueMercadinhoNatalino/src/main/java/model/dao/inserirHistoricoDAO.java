/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.bean.inserirHistorico;

/**
 *
 * @author Aluno
 */
public class inserirHistoricoDAO {

    public void create(inserirHistorico h) {

        try {
            Connection con = ConnectionFactory.getConnection();
            PreparedStatement stmt = null;

            stmt = con.prepareStatement("INSERT INTO historico (idProduto,idOperacao,quantidade,Data) VALUES ((SELECT idProduto FROM produto WHERE descricaoProduto = ?),(SELECT idOperacao FROM operacao WHERE descricaoOperacao = ?),?,?)");

            stmt.setString(1, h.getIdProduto());
            stmt.setString(2, h.getIdOperacao());
            stmt.setInt(3, h.getQuantidade());
            stmt.setString(4, h.getData());

            stmt.execute();

        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            //ConnectionFactory.closeConnection(con, stmt);

        }
    }
}
