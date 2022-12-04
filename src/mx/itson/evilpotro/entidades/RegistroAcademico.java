/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson.evilpotro.entidades;

import mx.itson.evilpotro.persistencia.Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Registro academico.
 */
public class RegistroAcademico {

    private Alumno alumno;
    private Curso curso;
    private int calificacion;
    private String cicloLectivo;

    /**
     * Obtener clases por id list.
     *
     * @param id the id
     *
     * @return the list
     */
    public static List<RegistroAcademico> obtenerClasesPorId(int id) {
        List<RegistroAcademico> registrosAcademicos = new ArrayList<>();
        try {
            Connection conexion = Conexion.obtener();
            String consulta = "SELECT * FROM registroAcademico WHERE idAlumno = ?";
            PreparedStatement statement = conexion.prepareStatement(consulta);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                RegistroAcademico registroAcademico = new RegistroAcademico();
                registroAcademico.setAlumno(Alumno.obtenerPorId(resultSet.getInt("idAlumno")));
                registroAcademico.setCurso(Curso.obtenerPorId(resultSet.getInt("idCurso")));
                registroAcademico.setCalificacion(resultSet.getInt("calificacion"));
                registroAcademico.setCicloLectivo(resultSet.getString("cicloLectivo"));
                registrosAcademicos.add(registroAcademico);
            }
            conexion.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return registrosAcademicos;
    }

    /**
     * Calcular promedio double.
     *
     * @param id the id
     *
     * @return the double
     */
    public static double calcularPromedio(int id) {
        double promedio = 0;
        double suma = 0;
        double contador = 0;
        try {
            Connection conexion = Conexion.obtener();
            String consulta = "SELECT calificacion FROM registroAcademico WHERE idAlumno = ?";
            PreparedStatement statement = conexion.prepareStatement(consulta);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                if (resultSet.getInt("calificacion") >= 7) {
                    suma += resultSet.getInt("calificacion");
                    contador++;
                }
            }
            promedio = suma / contador;
            conexion.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return promedio;
    }

    /**
     * Calcular progreso double.
     *
     * @param id the id
     *
     * @return the double
     */
    public static double calcularProgreso(int id) {
        double progreso = 0;
        int suma = 0;
        int contador = Curso.obtenerTotalMaterias(Alumno.obtenerCarrera(id));
        try {
            Connection conexion = Conexion.obtener();
            String consulta = "SELECT calificacion FROM registroAcademico WHERE idAlumno = ?";
            PreparedStatement statement = conexion.prepareStatement(consulta);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                if (resultSet.getInt("calificacion") >= 7) {
                    suma++;
                }
            }
            progreso = (suma * 100) / contador;
            conexion.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return progreso;
    }

    /**
     * Calcular reprobadas int.
     *
     * @param id the id
     *
     * @return the int
     */
    public static int calcularReprobadas(int id) {
        int reprobadas = 0;
        try {
            Connection conexion = Conexion.obtener();
            String consulta = "SELECT calificacion FROM registroAcademico WHERE idAlumno = ?";
            PreparedStatement statement = conexion.prepareStatement(consulta);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                if (resultSet.getInt("calificacion") < 7) {
                    reprobadas++;
                }
            }
            conexion.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return reprobadas;
    }

    /**
     * Gets alumno.
     *
     * @return the alumno
     */
    public Alumno getAlumno() {
        return alumno;
    }

    /**
     * Sets alumno.
     *
     * @param alumno the alumno
     */
    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    /**
     * Gets curso.
     *
     * @return the curso
     */
    public Curso getCurso() {
        return curso;
    }

    /**
     * Sets curso.
     *
     * @param curso the curso
     */
    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    /**
     * Gets calificacion.
     *
     * @return the calificacion
     */
    public int getCalificacion() {
        return calificacion;
    }

    /**
     * Sets calificacion.
     *
     * @param calificacion the calificacion
     */
    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    /**
     * Gets ciclo lectivo.
     *
     * @return the ciclo lectivo
     */
    public String getCicloLectivo() {
        return cicloLectivo;
    }

    /**
     * Sets ciclo lectivo.
     *
     * @param cicloLectivo the ciclo lectivo
     */
    public void setCicloLectivo(String cicloLectivo) {
        this.cicloLectivo = cicloLectivo;
    }


}
