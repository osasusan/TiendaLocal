package Productos;

import Tienda.Atajos;

public class Accesorios extends Producto {

    public Accesorios(String name, double price, int stock) {
        super(name, price, stock);
    }

    public Accesorios() {

    }

    @Override
    String typeProducto() {
        return "Accesorios";
    }

    @Override
    int getCantidad() {
        Atajos.imprimir("El stock de " + getName() + " es: " + getStock());
        setStock(Atajos.getNum());
        Atajos.imprimir("Stock actualizado a: " + getStock());
        return getStock();
    }

}
