package Productos;

import Tienda.Atajos;

public abstract  class Producto {
    private String name;
    private double price;
    private int stock;

   
    public Producto (String name, double price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }
    public abstract int getCantidad();
    public
    abstract String typeProducto();

    public Producto(){
        nProducto();
    }
    private void nProducto() {
      

        Atajos.imprimir("Ingrese el nombre del producto:");
        name = Atajos.getTexto();
        Atajos.imprimir("Ingrese el precio del producto:");
        price = Atajos.getDouble();
        
        getCantidad();
        
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    public String showData(int posicion){
        return   posicion + " - Nombre: " + name + ", Precio: " + price + "€  , Stock: " + stock;
    }

}
