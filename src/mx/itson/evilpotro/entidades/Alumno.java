package mx.itson.evilpotro.entidades;

import mx.itson.evilpotro.persistencia.Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Contiene los metos y atributos de la clase Alumno
 *
 * @author Julio Blanco
 * @author Alejandra Medina
 * @author Diego Castro
 */
public class Alumno {

    private int id;
    private String nombre;
    private String apellidos;
    private String email;
    private Long telefono;
    private String campus;
    private Date fechaInscripcion;
    private String carrera;

    /**
     * Crea una lista de alumnos con todos los registros de la base de datos
     *
     * @return La lista de alumnos
     */
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
                alumno.setFechaInscripcion(resultSet.getDate("fechaInscripcion"));
                alumno.setCarrera(resultSet.getString("carrera"));
                alumnos.add(alumno);
            }
            conexion.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return alumnos;
    }

    /**
     * Obtener por id alumno.
     *
     * @param id the id es el numero asignado para el alumno Este metodo obtendra todos los datos del alumno
     *           seleccionado
     *
     * @return El alumno encontrado
     */
    public static Alumno obtenerPorId(int id) {
        Alumno alumno = new Alumno();
        try {
            Connection conexion = Conexion.obtener();
            String consulta = "SELECT * FROM alumno WHERE id = ?";
            PreparedStatement statement = conexion.prepareStatement(consulta);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                alumno.setNombre(resultSet.getString("nombre"));
                alumno.setApellidos(resultSet.getString("apellidos"));
                alumno.setEmail(resultSet.getString("email"));
                alumno.setTelefono(resultSet.getLong("telefono"));
                alumno.setCampus(resultSet.getString("campus"));
                alumno.setFechaInscripcion(resultSet.getDate("fechaInscripcion"));
                alumno.setCarrera(resultSet.getString("carrera"));
            }
            conexion.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return alumno;
    }

    /**
     * Actualiza los registros de un alumno con base en su id
     *
     * @param id              id es un numero entero asignado para el alumno
     * @param nombre          nombre es una cadena de texto con el nombre del alumno
     * @param apellidos       apellidos es una cadena de texto con el apellido del alumno
     * @param email           email es una cadena de texto con el email del alumno
     * @param telefono        telefono es un tipo de dato entero que dara el telefono del alumno
     * @param campus          campus es una cadena de texto que dara el nombre del campus
     * @param fechaInscripcion fecha nacimiento es una cadena de texto que dara la fecha de nacimiento del alumno
     * @param carrera         carrera es una cadena de texto que dara el nombre de la carrera que cursa el alumno
     *
     * @return true si se actualizo correctamente, false si no
     */
    public static boolean editar(int id, String nombre, String apellidos, String email, Long telefono, String campus, String fechaInscripcion, String carrera) {
        boolean resultado = false;
        try {
            Connection conexion = Conexion.obtener();
            String consulta = "UPDATE alumno SET nombre = ?, apellidos = ?, email = ?, telefono = ?, campus = ?, fechaInscripcion = ?, carrera = ? WHERE id = ?";
            PreparedStatement statement = conexion.prepareStatement(consulta);
            statement.setString(1, nombre);
            statement.setString(2, apellidos);
            statement.setString(3, email);
            statement.setLong(4, telefono);
            statement.setString(5, campus);
            statement.setString(6, fechaInscripcion);
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

    /**
     * Obtiene la carrera del alumno con base en su id
     *
     * @param id id es un numero entero asignado para el alumno Este metodo obtendra la carrera del alumno
     *
     * @return La carrera del alumno
     */
    public static String obtenerCarrera(int id) {
        String carrera = "";
        try {
            Connection conexion = Conexion.obtener();
            String consulta = "SELECT carrera FROM alumno WHERE id = ?";
            PreparedStatement statement = conexion.prepareStatement(consulta);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                carrera = resultSet.getString("carrera");
            }
            conexion.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return carrera;
    }

    /**
     * Obtiene el campus del alumno con base en su id
     *
     * @return El campus del alumno
     */
    public int getId() {
        return id;
    }

    /**
     * Obtiene el nombre del alumno con base en su id
     *
     * @param id El valor a asignar a id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre del alumno
     *
     * @return El nombre del alumno
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Asigna el valor del nombre del alumno
     *
     * @param nombre El valor a asignar a nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el apellido del alumno
     *
     * @return El valor de apellidos
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * Asigna el valor del apellido del alumno
     *
     * @param apellidos El valor a asignar a apellidos
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * Obtiene el email del alumno
     *
     * @return El valor de email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Asigna el valor del email del alumno
     *
     * @param email El valor a asignar a email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Obtiene el telefono del alumno
     *
     * @return El valor de telefono
     */
    public long getTelefono() {
        return telefono;
    }

    /**
     * Asigna el valor del telefono del alumno
     *
     * @param telefono El valor a asignar a telefono
     */
    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    /**
     * Obtiene el campus del alumno
     *
     * @return El valor de campus
     */
    public String getCampus() {
        return campus;
    }

    /**
     * Asigna el valor del campus del alumno
     *
     * @param campus El valor a asignar a campus
     */
    public void setCampus(String campus) {
        this.campus = campus;
    }

    /**
     * Obtiene la fecha de nacimiento del alumno
     *
     * @return El valor de fechaInscripcion
     */
    public Date getFechaInscripcion() {
        return fechaInscripcion;
    }

    /**
     * Asigna el valor de la fecha de nacimiento del alumno
     *
     * @param fechaInscripcion El valor a asignar a fechaInscripcion
     */
    public void setFechaInscripcion(Date fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }

    /**
     * Obtiene la carrera del alumno
     *
     * @return El valor de carrera
     */
    public String getCarrera() {
        return carrera;
    }

    /**
     * Asigna el valor de la carrera del alumno
     *
     * @param carrera El valor a asignar a carrera
     */
    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

}
