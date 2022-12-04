/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson.evilpotro.entidades;

import mx.itson.evilpotro.persistencia.Conexion;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Curso.
 */
public class Curso {

    private int id;
    private String titulo;
    private int semestre;
    private String bloque;
    private String carrera;

    /**
     * Obtener por id curso.
     *
     * @param id the id
     *
     * @return the curso
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
     * Obtener total materias int.
     *
     * @param carrera the carrera
     *
     * @return the int
     */
    public static int obtenerTotalMaterias(String carrera){
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
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets titulo.
     *
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Sets titulo.
     *
     * @param titulo the titulo
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Gets semestre.
     *
     * @return the semestre
     */
    public int getSemestre() {
        return semestre;
    }

    /**
     * Sets semestre.
     *
     * @param semestre the semestre
     */
    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    /**
     * Gets bloque.
     *
     * @return the bloque
     */
    public String getBloque() {
        return bloque;
    }

    /**
     * Sets bloque.
     *
     * @param bloque the bloque
     */
    public void setBloque(String bloque) {
        this.bloque = bloque;
    }

    /**
     * Gets carrera.
     *
     * @return the carrera
     */
    public String getCarrera() {
        return carrera;
    }

    /**
     * Sets carrera.
     *
     * @param carrera the carrera
     */
    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

}
