package mx.itson.evilpotro.entidades;

import mx.itson.evilpotro.persistencia.Conexion;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.util.Date;
//hola

public class Alumno {

 
    private int id;
    private String nombre;
    private String apellidos;
    private String email;
    private Long telefono;
    private String campus;
    private Date fechaNacimiento;
    private String carrera;
    

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

    public static Alumno obtenerPorId(int id) {
        Alumno alumno = new Alumno();
        try {
            Connection conexion = Conexion.obtener();
            String consulta = "SELECT * FROM alumno WHERE id = ?";
            PreparedStatement statement = conexion.prepareStatement(consulta);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                alumno.setId(resultSet.getInt("id"));
                alumno.setNombre(resultSet.getString("nombre"));
                alumno.setApellidos(resultSet.getString("apellidos"));
                alumno.setEmail(resultSet.getString("email"));
                alumno.setCampus(resultSet.getString("campus"));
                alumno.setTelefono(resultSet.getLong("telefono"));
            }
            conexion.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return alumno;
    }

    public boolean editar(int id, String nombre, String apellidos, String email, Long telefono, String campus, Date fechaNacimiento, String carrera ) {
        boolean resultado = false;
        try {
            Connection conexion = new Conexion().obtener();
            String consulta = "UPDATE alumno SET nombre = ?, apellidos = ?, email = ?, telefono = ?, campus = ?, fechaNacimiento = ?, carrera = ? WHERE id = ?";
            PreparedStatement statement = conexion.prepareStatement(consulta);
            statement.setString(1, nombre);
            statement.setString(2, apellidos);
            statement.setString(3, email);
            statement.setLong(4, telefono);
            statement.setString(5,campus);
            statement.setDate(6, (java.sql.Date) fechaNacimiento);
            statement.setString(7, carrera);
            statement.setInt(8, id);
            statement.execute();

            resultado = statement.getUpdateCount() > 0;
            conexion.close();

        } catch (Exception ex) {
            System.err.println("Ocurrió un error: " + ex.getMessage());

        }
        return resultado;
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
       /**
     * @return the fechaNacimiento
     */
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * @param fechaNacimiento the fechaNacimiento to set
     */
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * @return the carrera
     */
    public String getCarrera() {
        return carrera;
    }

    /**
     * @param carrera the carrera to set
     */
    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

}
