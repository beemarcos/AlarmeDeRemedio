package com.example.marcos.myapplication;

/**
 * Created by Pantufa on 18/10/2016.
 */
public class Medicamento {
    private long id;
    private String nome;
    private String tipo_dosagem; // comprimido ou líquido
    private String tempo_tratamento; // dias ou indefinido(contínuo)
    private int dose;
    private int intervalo;
    private int quantidade;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo_dosagem() {
        return tipo_dosagem;
    }

    public void setTipo_dosagem(String tipo_dosagem) {
        this.tipo_dosagem = tipo_dosagem;
    }

    public String getTempo_tratamento() {
        return tempo_tratamento;
    }

    public void setTempo_tratamento(String tempo_tratamento) {
        this.tempo_tratamento = tempo_tratamento;
    }

    public int getDose() {
        return dose;
    }

    public void setDose(int dose) {
        this.dose = dose;
    }

    public int getIntervalo() {
        return intervalo;
    }

    public void setIntervalo(int intervalo) {
        this.intervalo = intervalo;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
