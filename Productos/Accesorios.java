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
    int getStock() {

        Atajos.imprimir("El stock de " + name + " es: " + stock);
        stock = Atajos.getNum();
        Atajos.imprimir("Stock actualizado a: " + stock);
        return stock;
    }

}
