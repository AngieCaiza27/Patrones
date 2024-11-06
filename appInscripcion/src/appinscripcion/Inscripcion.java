
package appinscripcion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class Inscripcion {

    private int idAlumno;
    private int idCurso;

    public Inscripcion(int idAlumno, int idCurso) {
        this.idAlumno = idAlumno;
        this.idCurso = idCurso;
    }
    public Inscripcion(){
        
    }

    public void inscripciones() {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = DatabaseConexion.getInstance().getConnection();
            ps = con.prepareStatement("insert into inscripcion (idAlumno, idCurso) values (?,?)");
            ps.setInt(1, this.idAlumno);
            ps.setInt(2, this.idCurso);
            ps.executeUpdate();
            System.out.println("Se inscribio al alumno a su correspondiente curso");

        } catch (SQLException e) {
            e.printStackTrace();
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

    public void borrarInscripciones(int idAlumno, int idCurso) {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = DatabaseConexion.getInstance().getConnection();
            ps = con.prepareStatement("delete from inscripcion where idAlumno=? and idCurso=?");
            ps.setInt(1, idAlumno);
            ps.setInt(2, idCurso);
            int rs = ps.executeUpdate();
            if (rs > 0) {
                System.out.println("Se elimino la inscripcion al alumno a su correspondiente curso");

            }else{
                System.out.println("No se pudo eliminar la inscripcion");
            }

        } catch (SQLException e) {
            e.printStackTrace();
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
