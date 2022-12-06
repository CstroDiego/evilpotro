/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson.evilpotro.entidades;

import mx.itson.evilpotro.persistencia.Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Contiene los metodos y atributos de la clase Curso
 *
 * @author Julio Blanco
 * @author Alejandra Medina
 * @author Diego Castro
 */
public class RegistroAcademico {

    private Alumno alumno;
    private Curso curso;
    private int calificacion;
    private String cicloLectivo;

    /**
     * Obtiene un registro de curso por su id
     *
     * @param id Es un numero entero asignado para el alumno Este metodo obtendra los datos del alumno relacionados con
     *           su progreso academico
     *
     * @return La lista de registros obtenidos con el id especificado.
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
     * Calcula el promedio de un alumno.
     *
     * @param id Es un numero entero asignado para el alumno Este metodo obtiene el promedio del alumno
     *
     * @return El promedio del alumno.
     */
    public static double calcularPromedio(int id) {
        double promedio = 0;
        double suma = 0;
        double contador = 0;
        DecimalFormat df = new DecimalFormat("#.00");
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
        return Double.parseDouble(df.format(promedio));
    }

    /**
     * Calcula el progreso academico de un alumno
     *
     * @param id Es un número entero asignado para el alumno Este método obtiene el progreso total del alumno
     *
     * @return El progreso total del alumno.
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
     * Calcula la cantidad de materias reprobadas de un alumno
     *
     * @param id Es un numero entero asignado para el alumno Este metodo obtiene el total de reprobadas
     *
     * @return El total de reprobadas del alumno.
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
     * Obtiene el valor del atributo alumno
     *
     * @return El valor del atributo alumno
     */
    public Alumno getAlumno() {
        return alumno;
    }

    /**
     * Asigna un valor al atributo alumno
     *
     * @param alumno Es un objeto de tipo Alumno
     */
    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    /**
     * Obtiene el valor del atributo curso
     *
     * @return El valor del atributo curso
     */
    public Curso getCurso() {
        return curso;
    }

    /**
     * Asigna un valor al atributo curso
     *
     * @param curso Es un objeto de tipo Curso
     */
    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    /**
     * Obtiene el valor del atributo calificacion
     *
     * @return El valor del atributo calificacion
     */
    public int getCalificacion() {
        return calificacion;
    }

    /**
     * Asigna un valor al atributo calificacion
     *
     * @param calificacion El valor del atributo calificacion
     */
    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    /**
     * Obtiene el valor del atributo cicloLectivo
     *
     * @return El valor del atributo cicloLectivo
     */
    public String getCicloLectivo() {
        return cicloLectivo;
    }

    /**
     * Asigna un valor al atributo cicloLectivo
     *
     * @param cicloLectivo El valor del atributo cicloLectivo
     */
    public void setCicloLectivo(String cicloLectivo) {
        this.cicloLectivo = cicloLectivo;
    }
}
