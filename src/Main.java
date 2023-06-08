import java.nio.MappedByteBuffer;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

//Supongamos que tenemos una clase Alumno que modela los participantes de un curso de programación.
//El programa debe permitir realizar las siguientes consultas:

//a. Mostrar el listado de alumnos ordenados alfabéticamente de forma decreciente según el apellido.
//b. Obtener el promedio de edad de todos los alumnos.
//c. Informar los alumnos que adeudan materias de la secundaria.
//d. Encontrar el alumno con la nota más alta en el curso de ingreso.
//e. Informar si algún alumno no abonó la matricula del curso.
//f. Agregar un nuevo alumno al curso.
//g. Dar de baja a un alumno.
//h. Modificar los datos de un alumno.
//
//Indicaciones:
//a. El formato para mostrar la información del alumno es: Berterreche, Mai [tabulación] - 32 años.
//b. El programa debe permitir realizar las acciones hasta que se le indique que finalice.
//c. Agregar validaciones. Si el usuario ingresa una opción no válida, mostrar un mensaje que indique cuál fue el error.

        Curso cursoIntegracion = new Curso();

        Alumno a1 = new Alumno("Natalia", "Romeo", 30, false, 9, false);
        Alumno a2 = new Alumno("Diego", "Vazquez", 25, true, 9, true);
        Alumno a3 = new Alumno("Roberto", "Corbera", 18, false, 8, true);
        Alumno a4 = new Alumno("Gaston", "Gonzalez", 22, true, 9, false);
        Alumno a5 = new Alumno("Sandra", "Gomez", 31, false, 8, true);
        Alumno a6 = new Alumno("Agustin", "Perez", 29, true, 7, false);

        cursoIntegracion.addAlumnos(a1);
        cursoIntegracion.addAlumnos(a2);
        cursoIntegracion.addAlumnos(a3);
        cursoIntegracion.addAlumnos(a4);
        cursoIntegracion.addAlumnos(a5);
        cursoIntegracion.addAlumnos(a6);

        Scanner scanner = new Scanner(System.in);


        int accion;
        do {

            System.out.println("Que quiere hacer?\n\t1-Mostrar la informacion de alumnos\n\t2-Mostrar la informacion ordenada" +
                    "\n\t3-Calcular el promedio de edades\n\t4-Saber si los alumnos adeudan materias\n\t5-Mostrar la nota mas alta" +
                    "\n\t6-Mostrar si abonaron la matricula\n\t7-Añadir un alumno\n\t8-Eliminar un alumno\n\t9-SALIR");

            accion = scanner.nextInt();

            switch (accion) {
                case 1 -> cursoIntegracion.mostrarInformacion();
                case 2 -> cursoIntegracion.mostrarAlumnosOrdenadosPorApellido();
                case 3 -> cursoIntegracion.calcularPromedioEdades();
                case 4 -> cursoIntegracion.adeudaMaterias();
                case 5 -> cursoIntegracion.notaMasAlta();
                case 6 -> cursoIntegracion.mostrarSiAbonoMatricula();
                case 7 -> {
                    System.out.println("Ingrese el nombre");
                    String nombre = scanner.next();         //Si tiraba .nextLine() me tiraba dos opciones juntas, o no se guardaba el nombre no se por que!

                    System.out.println("Ingrese el apellido");
                    String apellido = scanner.next();       //Si tiraba .nextLine() me tiraba dos opciones juntas, o no se guardaba el nombre no se por que!

                    System.out.println("Ingrese la edad");
                    int edad = scanner.nextInt();

                    System.out.println("Adeuda materia? Responda true o false");
                    boolean adeuda = scanner.nextBoolean();

                    System.out.println("Ingrese la nota");
                    int nota = scanner.nextInt();

                    System.out.println("Abono el curso?");
                    boolean abono = scanner.nextBoolean();



                    cursoIntegracion.addAlumnos(new Alumno(nombre, apellido, edad, adeuda, nota, abono));
                    System.out.println("Alumno " + nombre + " " + apellido + " creado!");

                }
                case 8 -> {
                    System.out.println("Ingrese el apellido del alumno que quiere borrar");
                    String apellidoABorrar = scanner.next();
                    System.out.println("Esta seguro que quiere borrarlo?\n\t1-Si\n\t2-No");
                    int estaSeguro = scanner.nextInt();

                    if (estaSeguro == 1) {
                        cursoIntegracion.eliminarAlumnoPorApellido(apellidoABorrar);
                        System.out.println("\nAsi quedo la lista despues de borrar a su alumno: ");
                        cursoIntegracion.mostrarAlumnosOrdenadosPorApellido();
                    } else if (estaSeguro == 2) {
                        System.out.println("Ok, vuelva a empezar el proceso");
                    }
                }

                case 9 -> System.out.println("Gracias por utilizar el programa de Diego Perez 2023 :)");
            }
        } while (accion != 9);


//        cursoIntegracion.mostrarInformacion();
//        cursoIntegracion.mostrarAlumnosOrdenadosPorApellido();
//        cursoIntegracion.calcularPromedioEdades();
//        cursoIntegracion.adeudaMaterias();
//        cursoIntegracion.notaMasAlta();
//        cursoIntegracion.mostrarSiAbonoMatricula();
//        cursoIntegracion.addAlumnos(new Alumno("Ester", "Esposito", 20, false, 7, true));
//
//        cursoIntegracion.eliminarAlumnoPorApellido("Esposito");
//        cursoIntegracion.mostrarAlumnosOrdenadosPorApellido();


    }
}
