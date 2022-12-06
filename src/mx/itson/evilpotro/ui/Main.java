package mx.itson.evilpotro.ui;

import mx.itson.evilpotro.entidades.Alumno;


/**
 * Clase principal de la aplicacion
 *
 * @author Julio Blanco
 * @author Alejandra Medina
 * @author Diego Castro
 * @deprecated
 */
public class Main {
    /**
     * Metodo principal de la aplicacion
     *
     * @param args Los argumentos de la linea de comandos
     */
    public static void main(String[] args) {
        Alumno.obtenerTodos().forEach(System.out::println);
    }
}
