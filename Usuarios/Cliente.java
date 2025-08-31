package Usuarios;

import Tienda.Atajos;

public class Cliente extends Usuario {

    @Override
    public void userLog() {
        Atajos.imprimir("Ingrese su nombre:");
        name = Atajos.getTexto();
        Atajos.imprimir("Ingrese su contraseña:");
        password = Atajos.getTexto();
        // Aquí puedes agregar la lógica de autenticación
    }
}
