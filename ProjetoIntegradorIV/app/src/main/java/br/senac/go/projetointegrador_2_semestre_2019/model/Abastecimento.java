package br.senac.go.projetointegrador_2_semestre_2019.model;

import java.util.Objects;

public class Abastecimento {
    private Long id;
    private float odo;
    private float litros;
    private float totalPago;
    private String nomePosto;
    private String tipoCombustivel;
    private String placaVeiculo;
    private String data;

    @Override
    public String toString() {
        return "Abastecimento{" +
                "id=" + id +
                ", odo=" + odo +
                ", litros=" + litros +
                ", totalPago=" + totalPago +
                ", nomePosto='" + nomePosto + '\'' +
                ", tipoCombustivel='" + tipoCombustivel + '\'' +
                ", placaVeiculo='" + placaVeiculo + '\'' +
                ", data=" + data +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Abastecimento that = (Abastecimento) o;
        return Float.compare(that.odo, odo) == 0 &&
                Float.compare(that.litros, litros) == 0 &&
                Float.compare(that.totalPago, totalPago) == 0 &&
                Objects.equals(id, that.id) &&
                Objects.equals(nomePosto, that.nomePosto) &&
                Objects.equals(tipoCombustivel, that.tipoCombustivel) &&
                Objects.equals(placaVeiculo, that.placaVeiculo) &&
                Objects.equals(data, that.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, odo, litros, totalPago, nomePosto, tipoCombustivel, placaVeiculo, data);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public float getOdo() {
        return odo;
    }

    public void setOdo(float odo) {
        this.odo = odo;
    }

    public float getLitros() {
        return litros;
    }

    public void setLitros(float litros) {
        this.litros = litros;
    }

    public float getTotalPago() {
        return totalPago;
    }

    public void setTotalPago(float totalPago) {
        this.totalPago = totalPago;
    }

    public String getNomePosto() {
        return nomePosto;
    }

    public void setNomePosto(String nomePosto) {
        this.nomePosto = nomePosto;
    }

    public String getTipoCombustivel() {
        return tipoCombustivel;
    }

    public void setTipoCombustivel(String tipoCombustivel) {
        this.tipoCombustivel = tipoCombustivel;
    }

    public String getPlacaVeiculo() {
        return placaVeiculo;
    }

    public void setPlacaVeiculo(String placaVeiculo) {
        this.placaVeiculo = placaVeiculo;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
