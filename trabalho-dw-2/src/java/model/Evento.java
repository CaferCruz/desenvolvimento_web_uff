/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Romulo
 */

public class Evento {
    
    private int id;
    private String nome;
    private String descricao;
    private String data; // muda para Date?
    private String hora; // muda para Date?
    private String imagem;
    private Endereco local;    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getData() {
        return this.data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public Endereco getLocal() {
        return local;
    }

    public void setLocal(Endereco local) {
        this.local = local;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    @Override
    public String toString() {
        return "Cod: " + getId() + "\n" +
                "Nome: " + getNome() + "\n" +
                "Descrição: " + getDescricao() + "\n" +
                "Data: " + getData() + "\n" +
                "Hora: " + getHora() + "\n" +
                "Local: " + getLocal() + "\n";
    }
}
