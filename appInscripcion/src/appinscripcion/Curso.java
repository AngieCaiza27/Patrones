
package appinscripcion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Curso {
    private int id;
    private String nombreCurso;

    public Curso(int id, String nombreCurso) {
        this.id = id;
        this.nombreCurso = nombreCurso;
    }

    public Curso() {
    }
    
   public void crearCurso(){
        Connection con=null;
         PreparedStatement ps = null;
         try{
             con = DatabaseConexion.getInstance().getConnection();
             ps = con.prepareStatement("insert into curso (id, nombreCurso) values(?,?)");
             ps.setInt(1, this.id);
             ps.setString(2, this.nombreCurso);
             ps.executeUpdate();
             System.out.println("Se creo el curso");
         }catch(SQLException e){
             System.out.println("Error " + e.getMessage());
         }finally {
            try {
                if (ps != null) ps.close();
                if (con!= null) con.close();  
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
        
    }
    public void borrarCurso(int idCurso) {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = DatabaseConexion.getInstance().getConnection();
            ps = con.prepareStatement("delete from curso where id=?");
            ps.setInt(1, idCurso);
            int rs = ps.executeUpdate();
            if (rs > 0) {
                System.out.println("Se elimino el curso");
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
