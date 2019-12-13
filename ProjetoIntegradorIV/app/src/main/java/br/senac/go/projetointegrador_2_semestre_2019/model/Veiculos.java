package br.senac.go.projetointegrador_2_semestre_2019.model;

import android.widget.EditText;
import android.widget.RadioButton;

import java.util.Objects;

public class Veiculos {
    private Long id;
    private String placa;
    private String tipo;

    public Veiculos() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Veiculos veiculos = (Veiculos) o;
        return Objects.equals(id, veiculos.id) &&
                Objects.equals(placa, veiculos.placa) &&
                Objects.equals(tipo, veiculos.tipo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, placa, tipo);
    }

    @Override
    public String toString() {
        return "Veiculos{" +
                "id=" + id +
                ", placa='" + placa + '\'' +
                ", tipo='" + tipo + '\'' +
                '}';
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Veiculos(String toString, CharSequence text) {
    }

    public Long getId() {
        return id;
    }

    public String getPlaca() {
        return placa;
    }

    public String getTipo() {
        return tipo;
    }
}
