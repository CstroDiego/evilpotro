package mx.itson.evilpotro.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {

    /**
     * Obtiene una conexión a la base de datos utilizando los parametros de conexión
     *
     * @return La conexión a la base de datos
     */
    public static Connection obtener() {
        Connection conexion = null;
        try {
            conexion = DriverManager.getConnection("jdbc:mysql://evilpotro.c8bvuwsq3sjd.us-west-2.rds.amazonaws.com:3306/evilpotrodb", "potro", "5j8jqgBha2AOAt58T5Qa");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return conexion;
    }
}
