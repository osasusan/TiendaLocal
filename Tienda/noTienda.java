package Tienda;

import Productos.Accesorios;
import Productos.Game;
import Productos.Herramientas;
import Productos.Home;
import Productos.Ropa;
import Usuarios.Admin;
import Usuarios.Cliente;
import Usuarios.Usuario;
import java.util.Map;

public class noTienda {

    public static void main(String[] args) {
        ListLister listLister = new ListLister();
        //Games
        listLister.getProductos().add(new Game("Kingdom hearts", 20.0, 3));
        listLister.getProductos().add(new Game("Final Fantasy", 30.0, 2));
        listLister.getProductos().add(new Game("Megaman", 30.0, 50));
        listLister.getProductos().add(new Game("Zelda", 50.0, 1));

        //Herramientas
        listLister.getProductos().add(new Herramientas("Destornillador", 8.0, 25));
        listLister.getProductos().add(new Herramientas("Martillo", 15.0, 10));
        listLister.getProductos().add(new Herramientas("Alicates", 12.0, 15));
        listLister.getProductos().add(new Herramientas("Sierra", 22.0, 5));
        listLister.getProductos().add(new Herramientas("Taladro", 45.0, 2));

        //Home
        listLister.getProductos().add(new Home("Sofa", 300.0, 5));
        listLister.getProductos().add(new Home("Mesa", 150.0, 10));
        listLister.getProductos().add(new Home("Silla", 75.0, 20));
        listLister.getProductos().add(new Home("Cama", 500.0, 2));
        listLister.getProductos().add(new Home("Escritorio", 200.0, 8));

        //Ropa
        listLister.getProductos().add(new Ropa("Camisa", 30.0, 10));
        listLister.getProductos().add(new Ropa("Pantalones", 50.0, 5));
        listLister.getProductos().add(new Ropa("Chaqueta", 100.0, 2));
        listLister.getProductos().add(new Ropa("Zapatos", 80.0, 8));
        listLister.getProductos().add(new Ropa("Gorro", 15.0, 20));

        //Accesorios 
        listLister.getProductos().add(new Accesorios("Reloj", 100.0, 5));
        listLister.getProductos().add(new Accesorios("Pulsera", 50.0, 10));
        listLister.getProductos().add(new Accesorios("Collar", 75.0, 8));
        listLister.getProductos().add(new Accesorios("Gafas", 150.0, 3));
        listLister.getProductos().add(new Accesorios("Sombrero", 30.0, 12));

        listLister.getCupones().put("ABCD", 30.0);
        listLister.getCupones().put("1234", 30.0);
        listLister.getCupones().put("PaPa", 30.0);
        listLister.getCupones().put("MaMa", 30.0);

        listLister.getUsers().put("admin@.es", new Admin());

        Atajos.imprimir("¡Bienvenido a la tienda!");
        Atajos.imprimirSeparador();

        //Atajos.getTexto();
        boolean condition = false;
        while (!condition) {
           for (Map.Entry<String, Usuario> listUsEntry: listLister.getUsers().entrySet()){
                    String username =  listUsEntry.getKey();
                    Usuario usuario = listUsEntry.getValue();
                    Atajos.imprimir("Usuario: " + username + " " + usuario.showData());
                  }
            Atajos.mostrarMenu(new String[]{"iniciar sesion", "Registrarse", "Continuar como invitado"});
            int opMenu = Atajos.getNum();

            switch (opMenu) {
                case 1 -> {
                    Atajos.imprimirSeparador();
                    Atajos.imprimir("Ingrese su correo de usuario:");
                    String email = Atajos.getEmaill();
                    Atajos.imprimir("Ingrese su contraseña:");
                    String password = Atajos.getTexto();
                    Atajos.imprimirSeparador();

                    if (listLister.getUsers().containsKey(email) && listLister.getUsers().get(email).getPassword().equals(password)) {
                        Atajos.imprimir("¡Inicio de sesión exitoso!");
                        Atajos.imprimir("Bienvenido " + listLister.getUsers().get(email).getName());
                        Atajos.imprimirSeparador();
                        if (listLister.getUsers().get(email) instanceof Admin) {
                            MenuAdmin.menuAdmin(listLister);
                        } else {
                            MenuCliente.menuCliente(listLister,true);
                        }
                    } else {
                        Atajos.imprimir("Nombre de usuario o contraseña incorrectos.");
                    }

                    Atajos.imprimir5ProductosAleatorios(listLister.getProductos());

                }
                case 2 -> {
                    Atajos.imprimir("¡Bienvenido al Registro!");
                    String correo = "";

                    boolean correoValido = false;
                    while (!correoValido) {
                        try {
                            Atajos.imprimir("Ingrese su correo:");
                            correo = Atajos.getEmaill();
                            if (correo.isEmpty() || listLister.getUsers().containsKey(correo)) {
                                Atajos.imprimir("Correo inválido o ya registrado, intente de nuevo.");
                            } else {
                                listLister.getUsers().put(correo, new Cliente());
                                correoValido = true;
                            }
                        } catch (Exception e) {
                            Atajos.imprimir("Correo inválido, intente de nuevo.");
                        }
                    }
                    Atajos.imprimir("¡Registro exitoso!");

                    Atajos.imprimir("Bienvenido " + listLister.getUsers().get(correo).getName());
                    Atajos.imprimirSeparador();
                    MenuCliente.menuCliente(listLister,true);

                }

                case 3 -> {
                    Atajos.imprimir("Continuar como invitado en desarrollo.");
                    MenuCliente.menuCliente(listLister,false);
                }
                case 4 -> {
                    Atajos.imprimir("Hasta la próxima.");
                    condition = true;
                }
                default ->
                    Atajos.imprimir("Opción no válida.");
            }
        }
    }

}
