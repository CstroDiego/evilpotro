package mx.itson.evilpotro.entidades;

import mx.itson.evilpotro.persistencia.Conexion;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Alumno {
    private int id;
    private String nombre;
    private String apellidos;
    private String email;
    private long telefono;
    private String campus;

    public static List<Alumno> obtenerTodos() {
        List<Alumno> alumnos = new ArrayList<>();
        try {
            Connection conexion = Conexion.obtener();
            Statement statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM alumno");

            while (resultSet.next()) {
                Alumno alumno = new Alumno();
                alumno.setId(resultSet.getInt("id"));
                alumno.setNombre(resultSet.getString("nombre"));
                alumno.setApellidos(resultSet.getString("apellidos"));
                alumno.setEmail(resultSet.getString("email"));
                alumno.setTelefono(resultSet.getLong("telefono"));
                alumno.setCampus(resultSet.getString("campus"));
                alumnos.add(alumno);
            }
            conexion.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return alumnos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    public String getCampus() {
        return campus;
    }

    public void setCampus(String campus) {
        this.campus = campus;
    }
}
