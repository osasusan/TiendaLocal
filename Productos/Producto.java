package Productos;

import Tienda.Atajos;

public abstract  class Producto {
    public String name;
    public double price;
    public int stock;

    public Producto (String name, double price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }
    abstract int getStock();
    abstract String typeProducto();

    public Producto() {
        nProducto();
    }
    private void nProducto() {
        Atajos.imprimir("Ingrese el nombre del producto:");
        name = Atajos.getTexto();
        Atajos.imprimir("Ingrese el precio del producto:");
        price = Atajos.getDouble();
        getStock();
    }

}
