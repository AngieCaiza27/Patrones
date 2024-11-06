
package appinscripcion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConexion {//CLASE PUBLICA QUE GESTIONA LA CONEXION A LA BASE DE DATOS
    
    //atributos
    private static DatabaseConexion instance;
    private Connection conexion;
    private String url="jdbc:mysql://localhost:3306/incripcioncurso";
    private String username="root";
    private String passworrd ="";
    
    
    
    //constructores

    public DatabaseConexion() throws SQLException{
       try{
           Class.forName("com.mysql.cj.jdbc.Driver");
           this.conexion=DriverManager.getConnection(url,username,passworrd);
           
       }catch(ClassNotFoundException e){
           System.out.println("Error"+e.getMessage());
       }
    }
    
    public Connection getConnection(){
        return conexion;
    }
    
    //Metodos
    
    public static DatabaseConexion getInstance() throws SQLException{
        if(instance ==null){
            instance =new DatabaseConexion();
        }else if (instance.getConnection().isClosed()){
            instance =new DatabaseConexion();
        }
        return instance;
    }
}
