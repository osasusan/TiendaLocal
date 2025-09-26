
package Tienda;


import Productos.Producto;
import Usuarios.Usuario;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;



public class ListLister {

 List<Producto> productos;
 HashMap<String, Double> cupones;
 HashMap<String, Usuario> users;
 List<Producto> carrito;
 double recaudado = 0;

    

    /**
     * Constructs a new ListLister instance with the specified shopping cart, coupons, products, and users.
     *
     * @param carrito   the list of products currently in the shopping cart
     * @param cupones   a map of coupon codes to their corresponding discount values
     * @param productos the list of all available products
     * @param users     a map of usernames to their corresponding Usuario objects
     */
    public ListLister(List<Producto> carrito, HashMap<String, Double> cupones, List<Producto> productos, HashMap<String, Usuario> users, double  recaudado) {
        this.carrito = carrito;
        this.cupones = cupones;
        this.productos = productos;
        this.users = users;
        this.recaudado = recaudado;
    }

    public ListLister() {
        this.carrito = new ArrayList<>();
        this.cupones = new HashMap<>();
        this.productos = new ArrayList<>();
        this.users = new HashMap<>();

    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public HashMap<String, Double> getCupones() {
        return cupones;
    }

    public void setCupones(HashMap<String, Double> cupones) {
        this.cupones = cupones;
    }

    public HashMap<String, Usuario> getUsers() {
        return users;
    }

    public void setUsers(HashMap<String, Usuario> users) {
        this.users = users;
    }

    public List<Producto> getCarrito() {
        return carrito;
    }

    public void setCarrito(List<Producto> carrito) {
        this.carrito = carrito;
    }

    public double  getRecaudado() {
        return recaudado;
    }

    public void setRecaudado(double  recaudado) {
        this.recaudado = recaudado;
    }


}