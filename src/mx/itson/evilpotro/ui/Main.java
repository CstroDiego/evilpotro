package mx.itson.evilpotro.ui;

import mx.itson.evilpotro.entidades.Alumno;


public class Main {
    public static void main(String[] args) {
    Alumno.obtenerTodos().forEach(System.out::println);
    }
}
