package mx.itson.evilpotro.ui;

import mx.itson.evilpotro.entidades.Alumno;


/**
 * The type Main.
 */
public class Main {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
    Alumno.obtenerTodos().forEach(System.out::println);
    }
}
