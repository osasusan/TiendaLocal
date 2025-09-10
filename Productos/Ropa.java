package Productos;

import Tienda.Atajos;

public class Ropa extends Producto {

    public Ropa(String name, double price, int stock) {
        super(name, price, stock);
    }

    public Ropa() {
     
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
        return "Ropa";
    }

   
}
