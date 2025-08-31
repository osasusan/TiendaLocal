package Productos;

import Tienda.Atajos;

public class Ropa extends Producto {

    public Ropa(String name, double price, int stock) {
        super(name, price, stock);
    }

    public Ropa() {
     
    }

    @Override
    int getStock() {
        Atajos.imprimir("El stock de " + name + " es: " + stock);
        stock = Atajos.getNum();
        Atajos.imprimir("Stock actualizado a: " + stock);
        return stock;
    }

    @Override
    String typeProducto() {
        return "Ropa";
    }
}
