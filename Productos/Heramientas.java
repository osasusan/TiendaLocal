package Productos;

import Tienda.Atajos;

public class Heramientas extends Producto {

    public Heramientas(String name, double price, int stock) {
        super(name, price, stock);
    }

    public Heramientas() {

    }

    @Override
    int getCantidad() {
        Atajos.imprimir("El stock de " + getName() + " es: " + getStock());
        setStock(Atajos.getNum());
        Atajos.imprimir("Stock actualizado a: " + getStock());
        return getStock();
    }

    @Override
    String typeProducto() {
        return "Herramientas";
    }
}
