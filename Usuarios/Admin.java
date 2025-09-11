package Usuarios;

public class Admin extends Usuario {

    @Override
     void userLog() {
        setName("Admin");
        setPassword("admin123") ;
    }

}
