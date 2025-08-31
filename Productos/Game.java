package Productos;

import Tienda.Atajos;

public class Game extends Producto{
    public String genre;

    public Game(String name, double price, int stock) {
        super(name, price, stock);
    }

    public Game() {
       
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
        return "Juego";
    }
}
