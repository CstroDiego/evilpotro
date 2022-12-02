/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson.evilpotro.entidades;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import mx.itson.evilpotro.persistencia.Conexion;

/**
 *
 * @author julio
 */
public class RegistroAcademico {

    private Alumno alumno;
    private Curso curso;
    private int calificacion;
    private String cicloLectivo;
    
    public static List<RegistroAcademico> obtenerPorId(int id) {
        List<RegistroAcademico> registrosAcademicos = new ArrayList<>();
        try {
            Connection conexion = Conexion.obtener();
            String consulta = "SELECT * FROM alumno WHERE id = ?";
            PreparedStatement statement = conexion.prepareStatement(consulta);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                RegistroAcademico registroAcademico = new RegistroAcademico();
                registroAcademico.getAlumno().setId(resultSet.getInt("id"));
                registroAcademico.getCurso().setTitulo(resultSet.getNString("cursos"));
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
     * @return the alumno
     */
    public Alumno getAlumno() {
        return alumno;
    }

    /**
     * @param alumno the alumno to set
     */
    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    /**
     * @return the curso
     */
    public Curso getCurso() {
        return curso;
    }

    /**
     * @param curso the curso to set
     */
    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    /**
     * @return the calificacion
     */
    public int getCalificacion() {
        return calificacion;
    }

    /**
     * @param calificacion the calificacion to set
     */
    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    /**
     * @return the cicloLectivo
     */
    public String getCicloLectivo() {
        return cicloLectivo;
    }

    /**
     * @param cicloLectivo the cicloLectivo to set
     */
    public void setCicloLectivo(String cicloLectivo) {
        this.cicloLectivo = cicloLectivo;
    }


}
