package com.br.projetointegrador.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="abastecimento")
public class Abastecimento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    private Long id;

    @Column(name = "odo")
    private int odo;

    @Column(name = "litros")
    private double litros;

    @Column(name = "preco_litro")
    private double preco_litro;

    @Column(name = "nome_posto")
    private String nome_posto;

    @Column(name = "data")
    private Date data;

    @Column(name = "tipo_combustivel")
    private String tipo_combustivel;

    @ManyToOne
    @JoinColumn(name = "id_veiculo")
    private Veiculo veiculo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getOdo() {
        return odo;
    }

    public void setOdo(int odo) {
        this.odo = odo;
    }

    public double getLitros() {
        return litros;
    }

    public void setLitros(double litros) {
        this.litros = litros;
    }

    public double getPreco_litro() {
        return preco_litro;
    }

    public void setPreco_litro(double preco_litro) {
        this.preco_litro = preco_litro;
    }

    public String getNome_posto() {
        return nome_posto;
    }

    public void setNome_posto(String nome_posto) {
        this.nome_posto = nome_posto;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getTipo_combustivel() {
        return tipo_combustivel;
    }

    public void setTipo_combustivel(String tipo_combustivel) {
        this.tipo_combustivel = tipo_combustivel;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }
}