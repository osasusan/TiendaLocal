package Usuarios;



public class Admin extends Usuario {

    public Admin(String admin, String string) {
    }


    @Override
     void userLog() {
        name = "Admin";
        password = "admin123";
    }

}
