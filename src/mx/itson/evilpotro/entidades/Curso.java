/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson.evilpotro.entidades;

import mx.itson.evilpotro.persistencia.Conexion;

import java.sql.Connection;
import java.sql.ResultSet;

/**
 * Contiene los metodos y atributos de la clase Curso
 *
 * @author Julio Blanco
 * @author Alejandra Medina
 * @author Diego Castro
 */
public class Curso {

    private int id;
    private String titulo;
    private int semestre;
    private String bloque;
    private String carrera;

    /**
     * Obtiene un registro de curso por su id
     *
     * @param id El id del curso
     *
     * @return El registro obtenido con el id especificado.
     */
    public static Curso obtenerPorId(int id) {
        Curso curso = new Curso();
        try {
            Connection conexion = Conexion.obtener();
            String consulta = "SELECT * FROM curso WHERE id = ?";
            java.sql.PreparedStatement statement = conexion.prepareStatement(consulta);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                curso.setId(resultSet.getInt("id"));
                curso.setTitulo(resultSet.getString("titulo"));
                curso.setSemestre(resultSet.getInt("semestre"));
                curso.setBloque(resultSet.getString("bloque"));
                curso.setCarrera(resultSet.getString("carrera"));
            }
            conexion.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return curso;
    }

    /**
     * Obtiene el total de materias registradas en la base de datos que coincidan con la carrera especificada.
     *
     * @param carrera La carrera de la que se quieren obtener el total de las materias registradas.
     *
     * @return El total de materias encontradas
     */
    public static int obtenerTotalMaterias(String carrera) {
        int totalMaterias = 0;
        try {
            Connection conexion = Conexion.obtener();
            String consulta = "SELECT COUNT(*) AS total FROM curso WHERE carrera = ?";
            java.sql.PreparedStatement statement = conexion.prepareStatement(consulta);
            statement.setString(1, carrera);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                totalMaterias = resultSet.getInt("total");
            }
            conexion.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return totalMaterias;
    }

    /**
     * Obtiene el valor del atributo id
     *
     * @return El valor del atributo id
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el valor del atributo id
     *
     * @param id El valor a establecer
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene el valor del atributo titulo
     *
     * @return El valor del atributo titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Establece el valor del atributo titulo
     *
     * @param titulo El valor a establecer
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Obtiene el valor del atributo semestre
     *
     * @return El valor del atributo semestre
     */
    public int getSemestre() {
        return semestre;
    }

    /**
     * Establece el valor del atributo semestre
     *
     * @param semestre El valor a establecer
     */
    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    /**
     * Obtiene el valor del atributo bloque
     *
     * @return El valor del atributo bloque
     */
    public String getBloque() {
        return bloque;
    }

    /**
     * Establece el valor del atributo bloque
     *
     * @param bloque El valor a establecer
     */
    public void setBloque(String bloque) {
        this.bloque = bloque;
    }

    /**
     * Obtiene el valor del atributo carrera
     *
     * @return El valor del atributo carrera
     */
    public String getCarrera() {
        return carrera;
    }

    /**
     * Establece el valor del atributo carrera
     *
     * @param carrera El valor a establecer
     */
    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

}
