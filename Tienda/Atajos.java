/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author osasusan
 */

package Tienda;

import java.util.Scanner;

public class Atajos{
private static final Scanner scanner = new Scanner(System.in);
    public static void imprimir(String texto) { // imprime un texto en consola
        System.out.println(texto);

    }

public static void mostrarMenu(String[] opciones) {
    for (int i = 0; i < opciones.length; i++) {
        System.out.println((i + 1) + ". " + opciones[i]);
    }
}

    public static String getTexto() {
        String textInput = "";
        do {
            try {
                textInput = scanner.nextLine();
            } catch (Exception e) {
                errorAtajo("texto");
            }
        } while (textInput.isEmpty());
        return textInput;
    }

    public static void imprimirSeparador() { // imprime una linea separadora
        imprimir("--------------------");
    }

    public static int getNum() { // recojer un numero INT desde consola 
        int num = -1;
        do {
            try {
                num = scanner.nextInt();
            } catch (Exception e) {
                errorAtajo("numero");
            }
        } while (num == -1);
        return num;
    }

    public static double getDouble() { // recojer un numero DOUBLE desde consola
        double num = -0.00;
        do {
            try {
                num = scanner.nextDouble();
            } catch (Exception e) {
                errorAtajo("numero");
            }
        } while (num == -1);
        return num;
    }
    public static float getFloat() { // recojer un numero FLOAT desde consola
        float num =  0.0f;
        do {
            try{ 
             num = scanner.nextFloat();
            } catch (Exception e) {
                errorAtajo("numero");
            }
        } while (num == 0.0f);
        return num;
    }

    public static void get5Random(){
        for (int i = 0; i < 5; i++) {
            System.out.println(Math.random());
        }
    }

    private static void errorAtajo(String property) { // metodo para manejar errores
        imprimir(" Error a la hora de obtener un " + property + " ,\nPor favor, intentalo de nuevo.");
    }
}
