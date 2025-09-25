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
    public String typeProducto() {
        return "Home";
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

}
