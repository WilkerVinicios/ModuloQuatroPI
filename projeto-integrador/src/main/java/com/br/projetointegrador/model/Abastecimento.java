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
    private String odo;

    @Column(name = "litros")
    private double litros;

    @Column(name = "total_pago")
    private double total_pago;

    @Column(name = "nome_posto")
    private String nome_posto;

    @Column(name = "tipo_combustivel")
    private String tipo_combustivel;

    @Column(name = "data")
    private Date data;

    @ManyToOne
    @JoinColumn(name = "id_veiculo")
    private Veiculos veiculos;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOdo() {
        return odo;
    }

    public void setOdo(String odo) {
        this.odo = odo;
    }

    public double getLitros() {
        return litros;
    }

    public void setLitros(double litros) {
        this.litros = litros;
    }

    public double getTotal_pago() {
        return total_pago;
    }

    public void setTotal_pago(double total_pago) {
        this.total_pago = total_pago;
    }

    public String getNome_posto() {
        return nome_posto;
    }

    public void setNome_posto(String nome_posto) {
        this.nome_posto = nome_posto;
    }

    public String getTipo_combustivel() {
        return tipo_combustivel;
    }

    public void setTipo_combustivel(String tipo_combustivel) {
        this.tipo_combustivel = tipo_combustivel;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Veiculos getVeiculos() {
        return veiculos;
    }

    public void setVeiculos(Veiculos veiculos) {
        this.veiculos = veiculos;
    }
}