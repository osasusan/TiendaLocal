//package Productos;
package Productos;


import Tienda.Atajos;

public class Home extends Producto {

    public Home(String name, double price, int stock) {
        super(name, price, stock);
    }

    public Home(){
        
    }

    @Override
    String typeProducto() {
        return "Home";
    }

    @Override
    int getStock() {
        Atajos.imprimir("El stock de " + name + " es: " + stock);
        stock = Atajos.getNum();
        Atajos.imprimir("Stock actualizado a: " + stock);
        return stock;
    }

}
