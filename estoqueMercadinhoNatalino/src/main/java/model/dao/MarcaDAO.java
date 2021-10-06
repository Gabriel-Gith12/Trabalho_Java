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
import model.bean.Marca;

/**
 *
 * @author Aluno
 */
public class MarcaDAO {

    private Connection con;

    public MarcaDAO() {
        this.con = new ConnectionFactory().getConnection();
    }

    public List<Marca> listarMarca() {

        try {
            List<Marca> lista = new ArrayList<>();

            String sql = "SELECT * FROM marca;";

            PreparedStatement stmt = con.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Marca obj = new Marca();

                obj.setIdMarca(rs.getInt("idMarca"));
                obj.setMarcaProduto(rs.getString("marcaProduto"));
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