
package appinscripcion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;


public class Alumno {

    private int id;
    private String nombre;
    private int edad;

    public Alumno(int id, String nombre, int edad) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
    }
    public Alumno(){
        
    }

    public void crearAlumno() {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = DatabaseConexion.getInstance().getConnection();
            ps = con.prepareStatement("insert into alumno (id, nombre, edad) values(?,?,?)");
            ps.setInt(1, this.id);
            ps.setString(2, this.nombre);
            ps.setInt(3, this.edad);
            ps.executeUpdate();
            System.out.println("Se creo el alumno");
        } catch (SQLException e) {
            System.out.println("Error " + e.getMessage());
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    con.close();  // Importante cerrar la conexión
                }
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }

    }

    public void borrarAlumno(int idAlumno) {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = DatabaseConexion.getInstance().getConnection();
            ps = con.prepareStatement("delete from alumno where id=?");
            ps.setInt(1, idAlumno);
            int rs = ps.executeUpdate();
            if (rs > 0) {
                System.out.println("Se elimino el alumno");
            }
        } catch (SQLException e) {
            System.out.println("Error " + e.getMessage());
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    con.close();  // Importante cerrar la conexión
                }
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }

    }

   
}
