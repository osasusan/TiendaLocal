package Usuarios;

public abstract class Usuario {

    private String name = "";
    private String password = "";

    abstract void userLog();

    public Usuario() {
        userLog();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String showData() {

    return "Nombre: "  + getName();
        
    }
}
