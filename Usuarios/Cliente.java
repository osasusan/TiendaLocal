package Usuarios;

import Tienda.Atajos;

public class Cliente extends Usuario {

    @Override
    public void userLog() {
        Atajos.imprimir("Ingrese su nombre:");
        setName(Atajos.getTexto());
        Atajos.imprimir("Ingrese su contraseña:");
        setPassword(Atajos.getTexto());
        // Aquí puedes agregar la lógica de autenticación
    }
}
