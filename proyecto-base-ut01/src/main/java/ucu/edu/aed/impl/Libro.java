package ucu.edu.aed.impl;

public class Libro {
    private String titulo;
    private String codigo;
    private double precio;
    private int stock;

    public Libro(String titulo, String codigo, double precio, int stock) {
        this.titulo = titulo;
        this.codigo = codigo;
        this.precio = precio;
        this.stock = stock;
    }

    public Libro getLibro() {
        return this;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getCodigo() {
        return codigo;
    }

    public double getPrecio() {
        return precio;
    }

    public int getStock() {
        return stock;
    }

    public void agregarEjemplar() {
        this.stock += 1;
    }


}
