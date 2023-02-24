package com.anthonyponte.wallet.model;

public class Cuenta {
    private Integer id;
    private String descripcion;
    private double total;

    public Cuenta() {
    }

    public Cuenta(Integer id, String descripcion, double total) {
        this.id = id;
        this.descripcion = descripcion;
        this.total = total;
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

    public double getTotal() {
        return this.total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", descripcion='" + getDescripcion() + "'" +
                ", total='" + getTotal() + "'" +
                "}";
    }
}
