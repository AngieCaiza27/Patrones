
import appinscripcion.Alumno;
import appinscripcion.Curso;
import appinscripcion.Inscripcion;
import java.util.Scanner;

public class AppInscripcion {

    public static void main(String[] args) {
   
        Scanner leer = new Scanner(System.in);
        int opcion = 0;
            System.out.println("----Inscripciones----");
            System.out.println("1. Crear alumno");
            System.out.println("2. Borrar alumno");
            System.out.println("3. Crear Curso");
            System.out.println("4. Eliminar Curso");
            System.out.println("5. Inscribir");
            System.out.println("6. Borrar inscripcion");
            System.out.println("7. Salir");
            opcion = leer.nextInt();
            leer.nextLine(); // Limpiar buffer antes del switch
            switch (opcion) {
                case 1:
                    System.out.println("Ingrese el id del alumno");
                    int idAlumno = leer.nextInt();
                    leer.nextLine(); // Limpiar buffer después de leer idAlumno
                    System.out.println("Ingrese el nombre del alumno");
                    String nombre = leer.nextLine(); // Leer el nombre correctamente
                    System.out.println("Ingrese la edad del alumno");
                    int edad = leer.nextInt();
                    Alumno a = new Alumno(idAlumno, nombre, edad);
                    a.crearAlumno();
                    break;
                case 2: 
                    System.out.println("Ingrese el id del alumno que desee eliminar");
                    int idBorrar = leer.nextInt();
                    Alumno al= new Alumno();
                    al.borrarAlumno(idBorrar);
                    break;
                case 3:
                    System.out.println("Ingrese el id del curso");
                    int idCur= leer.nextInt();
                    leer.nextLine(); // Limpiar buffer antes de leer el nombre del curso
                    System.out.println("Ingrese el nombre del curso");
                    String nomCur= leer.nextLine();
                    Curso curso= new Curso(idCur, nomCur);
                    curso.crearCurso();
                    break;
                case 4:
                    System.out.println("Ingresa el id del curso que desea eliminar");
                    int idCurso= leer.nextInt();
                    Curso cur=new Curso(); 
                    cur.borrarCurso(idCurso);
                    break;
                case 5:
                    System.out.println("Ingrese el id del alumno que desee inscribir");
                    int idAlumnos= leer.nextInt();
                    System.out.println("Ingrese el id del curso que desee inscribir");
                    int idCursos= leer.nextInt();
                    Inscripcion inscripcion= new Inscripcion(idAlumnos, idCursos);
                    inscripcion.inscripciones();
                    break;
                case 6:
                    System.out.println("Ingrese el id del alumno que desee inscribir");
                    int idAlum= leer.nextInt();
                    System.out.println("Ingrese el id del curso que desee inscribir");
                    int idCurs= leer.nextInt();
                    Inscripcion inscrip= new Inscripcion();
                    inscrip.borrarInscripciones(idAlum, idCurs);
                    break;
                case 7:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    throw new AssertionError();
            }
    }
}
