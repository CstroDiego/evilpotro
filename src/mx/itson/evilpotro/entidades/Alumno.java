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
 * The type Alumno.
 */
public class Alumno {

    private int id;
    private String nombre;
    private String apellidos;
    private String email;
    private Long telefono;
    private String campus;
    private Date fechaNacimiento;
    private String carrera;

    /**
     * Obtener todos list.
     *
     * @return the list
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
                alumno.setFechaNacimiento(resultSet.getDate("fechaNacimiento"));
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
     * @param id the id
     *
     * @return the alumno
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
                alumno.setFechaNacimiento(resultSet.getDate("fechaNacimiento"));
                alumno.setCarrera(resultSet.getString("carrera"));
            }
            conexion.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return alumno;
    }

    /**
     * Editar boolean.
     *
     * @param id              the id
     * @param nombre          the nombre
     * @param apellidos       the apellidos
     * @param email           the email
     * @param telefono        the telefono
     * @param campus          the campus
     * @param fechaNacimiento the fecha nacimiento
     * @param carrera         the carrera
     *
     * @return the boolean
     */
    public static boolean editar(int id, String nombre, String apellidos, String email, Long telefono, String campus, String fechaNacimiento, String carrera) {
        boolean resultado = false;
        try {
            Connection conexion = Conexion.obtener();
            String consulta = "UPDATE alumno SET nombre = ?, apellidos = ?, email = ?, telefono = ?, campus = ?, fechaNacimiento = ?, carrera = ? WHERE id = ?";
            PreparedStatement statement = conexion.prepareStatement(consulta);
            statement.setString(1, nombre);
            statement.setString(2, apellidos);
            statement.setString(3, email);
            statement.setLong(4, telefono);
            statement.setString(5, campus);
            statement.setString(6, fechaNacimiento);
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
     * Obtener carrera string.
     *
     * @param id the id
     *
     * @return the string
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
     * Gets nombre.
     *
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Sets nombre.
     *
     * @param nombre the nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Gets apellidos.
     *
     * @return the apellidos
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * Sets apellidos.
     *
     * @param apellidos the apellidos
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * Gets email.
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets email.
     *
     * @param email the email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets telefono.
     *
     * @return the telefono
     */
    public long getTelefono() {
        return telefono;
    }

    /**
     * Sets telefono.
     *
     * @param telefono the telefono
     */
    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    /**
     * Gets campus.
     *
     * @return the campus
     */
    public String getCampus() {
        return campus;
    }

    /**
     * Sets campus.
     *
     * @param campus the campus
     */
    public void setCampus(String campus) {
        this.campus = campus;
    }

    /**
     * Gets fecha nacimiento.
     *
     * @return the fecha nacimiento
     */
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * Sets fecha nacimiento.
     *
     * @param fechaNacimiento the fecha nacimiento
     */
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
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
