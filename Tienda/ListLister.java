
package Tienda;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import Productos.Producto;
import Usuarios.Usuario;



public class ListLister {

 List<Producto> productos;
 HashMap<String, Integer> cupones;
 HashMap<String, Usuario> users;
 List<Producto> carrito;

    /**
     * Constructs a new ListLister instance with the specified shopping cart, coupons, products, and users.
     *
     * @param carrito   the list of products currently in the shopping cart
     * @param cupones   a map of coupon codes to their corresponding discount values
     * @param productos the list of all available products
     * @param users     a map of usernames to their corresponding Usuario objects
     */
    public ListLister(List<Producto> carrito, HashMap<String, Integer> cupones, List<Producto> productos, HashMap<String, Usuario> users) {
        this.carrito = carrito;
        this.cupones = cupones;
        this.productos = productos;
        this.users = users;
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

    public HashMap<String, Integer> getCupones() {
        return cupones;
    }

    public void setCupones(HashMap<String, Integer> cupones) {
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


}