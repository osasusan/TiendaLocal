package Usuarios;

public abstract class Usuario {

    public String name = "";
    public String password = "";

    abstract void userLog();

    public Usuario() {
        userLog();
    }
}
