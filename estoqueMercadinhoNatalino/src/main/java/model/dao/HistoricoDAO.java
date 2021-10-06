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
import javax.swing.JOptionPane;
import model.bean.Historico;

/**
 *
 * @author Aluno
 */
public class HistoricoDAO {

    private Connection con;

    public HistoricoDAO() {
        this.con = new ConnectionFactory().getConnection();
    }

    public List<Historico> listarHistorico() {

        try {
            List<Historico> lista = new ArrayList<>();

            String sql = "SELECT * FROM produto;";

            PreparedStatement stmt = con.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Historico obj = new Historico();

                obj.setIdProduto(rs.getInt("idProduto"));
                obj.setDescricaoProduto(rs.getString("descricaoProduto"));
                /// obj.setDescricaoProduto(rs.getString("idProduto"));

                lista.add(obj);
            }

            return lista;

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro" + erro);
            return null;
        }
    }
}
