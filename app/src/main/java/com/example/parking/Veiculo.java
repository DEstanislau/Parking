package com.example.parking;

import java.io.Serializable;

public class Veiculo implements Serializable {

    private Integer id;
    private String tipo;
    private String nome;
    private String marca;
    private String cor;
    private String ano;
    private String dataE;
    private String dataS;
    private String horarioE;
    private String horarioS;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipo(){
        return tipo;
    }

    public void setTipo(String tipo){
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getDataE() {
        return dataE;
    }

    public void setDataE(String dataE) {
        this.dataE = dataE;
    }

    public String getDataS() {
        return dataS;
    }

    public void setDataS(String dataS) {
        this.dataS = dataS;
    }

    public String getHorarioE() {
        return horarioE;
    }

    public void setHorarioE(String horarioE) {
        this.horarioE = horarioE;
    }

    public String getHorarioS() {
        return horarioS;
    }

    public void setHorarioS(String horarioS) {
        this.horarioS = horarioS;
    }

    @Override
    public String toString(){
        return nome;
    }
}
