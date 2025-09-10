package Tienda;

import Productos.Accesorios;
import Productos.Game;
import Productos.Heramientas;
import Productos.Home;
import Productos.Producto;
import Productos.Ropa;
import Usuarios.Admin;

public class noTienda {
  
  public static void main(String[] args) {
    ListLister listListter = new ListLister();
        //Games
      listListter.getProductos().add(new Game("Kingdom hearts", 20.0, 3));
      listListter.getProductos().add(new Game("Final Fantasy", 30.0, 2));
      listListter.getProductos().add(new Game("Megaman", 30.0, 50));
      listListter.getProductos().add(new Game("Zelda", 50.0, 1));

        //Herramientas
      listListter.getProductos().add(new Heramientas("Martillo", 15.0, 10));
      listListter.getProductos().add(new Heramientas("Destornillador", 8.0, 25));
      listListter.getProductos().add(new Heramientas("Alicates", 12.0, 15));
      listListter.getProductos().add(new Heramientas("Sierra", 22.0, 5));
      listListter.getProductos().add(new Heramientas("Taladro", 45.0, 2));

      //Home
      listListter.getProductos().add(new Home("Sofa", 300.0, 5));
      listListter.getProductos().add(new Home("Mesa", 150.0, 10));
      listListter.getProductos().add(new Home("Silla", 75.0, 20));
      listListter.getProductos().add(new Home("Cama", 500.0, 2));
      listListter.getProductos().add(new Home("Escritorio", 200.0, 8));

      //Ropa
      listListter.getProductos().add(new Ropa("Camisa", 30.0, 10));
      listListter.getProductos().add(new Ropa("Pantalones", 50.0, 5));
      listListter.getProductos().add(new Ropa("Chaqueta", 100.0, 2));
      listListter.getProductos().add(new Ropa("Zapatos", 80.0, 8));
      listListter.getProductos().add(new Ropa("Gorro", 15.0, 20));

      //Accesorios 
      listListter.getProductos().add(new Accesorios("Reloj", 100.0, 5));
      listListter.getProductos().add(new Accesorios("Pulsera", 50.0, 10));
      listListter.getProductos().add(new Accesorios("Collar", 75.0, 8));
      listListter.getProductos().add(new Accesorios("Gafas", 150.0, 3));
      listListter.getProductos().add(new Accesorios("Sombrero", 30.0, 12));

      listListter.getUsers().put("admin", new Admin("admin", "1234"));

      Atajos.imprimir("¡Bienvenido a la tienda!");
      Atajos.imprimirSeparador();

      Atajos.getTexto();
      Atajos.mostrarMenu(new String[]{"Productos destacados", "Agregar al carrito", "Realizar compra"});
      int opMenu = Atajos.getNum();

      switch (opMenu) {
          case 1 -> {
              Atajos.imprimir("Productos destacados:");
              for (int i = 0; i < 5; i++) {
                  Producto p = listListter.getProductos().get(i);
                  Atajos.imprimir((i + 1) + ". " + p.getName() + " - $" + p.getPrice());
              }
          }
          case 2 ->
              Atajos.imprimir("Funcionalidad de agregar al carrito en desarrollo.");
          case 3 ->
              Atajos.imprimir("Funcionalidad de realizar compra en desarrollo.");
          default ->
              Atajos.imprimir("Opción no válida.");
      }
  }
}

  


    



