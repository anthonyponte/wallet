package com.anthonyponte.wallet.model;

public class Tipo {
    private Integer id;
    private String descripcion;

    public Tipo() {
    }

    public Tipo(Integer id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", descripcion='" + getDescripcion() + "'" +
                "}";
    }
}
