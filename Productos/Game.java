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
    public 
    int getCantidad() {
        Atajos.imprimir("El stock de " + getName() + " es: " + getStock());
        Atajos.imprimir("indica cual es el nuevo stock");
        setStock(Atajos.getNum());
        Atajos.imprimir("Stock actualizado a: " + getStock());
        return getStock();
    }

    @Override
    public
    String typeProducto() {
        return "Juego";
    }
}
