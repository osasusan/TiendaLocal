package Usuarios;



public class Admin extends Usuario {


    @Override
     void userLog() {
        name = "Admin";
        password = "admin123";
    }

}
