/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

/**
 *
 * @author Aluno
 */
public class Produto {

    private int idProduto;
    private int codigoProduto;
    private String descricaoProduto;
    private String idMarca;
    private String idCor;
    private double precoUnitProduto;
    private int Saldo;

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public int getSaldo() {
        return Saldo;
    }

    public void setSaldo(int Saldo) {
        this.Saldo = Saldo;
    }

    public int getCodigoProduto() {
        return codigoProduto;
    }

    public void setCodigoProduto(int codigoProduto) {
        this.codigoProduto = codigoProduto;
    }

    public String getDescricaoProduto() {
        return descricaoProduto;
    }

    public void setDescricaoProduto(String descricaoProduto) {
        this.descricaoProduto = descricaoProduto;
    }

    public String getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(String idMarca) {
        this.idMarca = idMarca;
    }

    public String getIdCor() {
        return idCor;
    }

    public void setIdCor(String idCor) {
        this.idCor = idCor;
    }

    public double getPrecoUnitProduto() {
        return precoUnitProduto;
    }

    public void setPrecoUnitProduto(double precoUnitProduto) {
        this.precoUnitProduto = precoUnitProduto;
    }



}
