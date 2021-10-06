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
import model.bean.Cor;

/**
 *
 * @author Aluno
 */
public class CorDAO {

    private Connection con;

    public CorDAO() {
        this.con = new ConnectionFactory().getConnection();
    }

    public List<Cor> listarCor() {

        try {
            List<Cor> lista = new ArrayList<>();

            String sql = "SELECT * FROM cor;";

            PreparedStatement stmt = con.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Cor obj = new Cor();
                
                obj.setIdCor(rs.getInt("idCor"));
                obj.setCorProduto(rs.getString("corProduto"));
                /// obj.setCorProduto(rs.getString("idCor"));

                lista.add(obj);
            }

            return lista;

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro" + erro);
            return null;
        }
    }
}
