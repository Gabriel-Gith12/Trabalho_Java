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
import model.bean.Produto;

/**
 *
 * @author Aluno
 */
public class ProdutoDAO {
    
    public void create(Produto p){
    
        try {
            Connection con = ConnectionFactory.getConnection();
            PreparedStatement stmt = null;
            
            stmt =  con.prepareStatement("INSERT INTO produto (codigoProduto,descricaoProduto,idMarca,idCor,precoUnitProduto) VALUES (?,?,(SELECT idMarca FROM marca WHERE marcaProduto = ?),(SELECT idCor FROM cor WHERE corProduto = ?),?)");
           
            stmt.setInt(1,p.getCodigoProduto());
            stmt.setString(2,p.getDescricaoProduto());
            stmt.setString(3,p.getIdMarca());
            stmt.setString(4,p.getIdCor());
            stmt.setDouble(5,p.getPrecoUnitProduto());
            
            stmt.execute();
            
                    
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{            
            //ConnectionFactory.closeConnection(con, stmt);
        
        }
    }
}