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
import model.bean.Operacao;

/**
 *
 * @author Aluno
 */
public class OperacaoDAO {

    private Connection con;

    public OperacaoDAO() {
        this.con = new ConnectionFactory().getConnection();
    }

    public List<Operacao> listarOperacao() {

        try {
            List<Operacao> lista = new ArrayList<>();

            String sql = "SELECT * FROM operacao;";

            PreparedStatement stmt = con.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Operacao obj = new Operacao();

                obj.setIdOperacao(rs.getInt("idOperacao"));
                obj.setDescricaoOperacao(rs.getString("descricaoOperacao"));
                /// obj.setMarcaProduto(rs.getString("idMarca"));

                lista.add(obj);
            }

            return lista;

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro" + erro);
            return null;
        }
    }
}
