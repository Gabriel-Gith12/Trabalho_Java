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
public class Operacao {

    private int idOperacao;
    private String descricaoOperacao;

    public int getIdOperacao() {
        return idOperacao;
    }

    public void setIdOperacao(int idOperacao) {
        this.idOperacao = idOperacao;
    }

    public String getDescricaoOperacao() {
        return descricaoOperacao;
    }

    public void setDescricaoOperacao(String descricaoOperacao) {
        this.descricaoOperacao = descricaoOperacao;
    }

    @Override
    public String toString() {
        return this.getDescricaoOperacao(); //To change body of generated methods, choose Tools | Templates.
    }

}
