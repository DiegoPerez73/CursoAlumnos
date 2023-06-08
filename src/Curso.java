import java.util.*;

public class Curso {

    private List<Alumno> alumnos = new ArrayList<>();

    public Curso(){

    }
    public Curso(Alumno alumno) {
        this.alumnos.add(alumno);
    }

    //--------- Métodos de Curso--------

    //---Añadir alumnos---
    public void addAlumnos(Alumno alumno) {
        this.alumnos.add(alumno);
    }

    //---Borrar alumnos---


    //---Mostrar Informacion completa (desordenada)---
    public void mostrarInformacion() {
        alumnos.forEach(alumno -> {
            System.out.println("\tNombre y apellido: " + alumno.getName() + " " + alumno.getLastName() +
                    "\n\tEdad: " + alumno.getAge() + "\n\tAdeuda materia? " + alumno.getAdeudaMateria() +
                    "\n\tNota: " + alumno.getNota() + "\n\tAbonó? " + alumno.getAbono() + "\n");
        });
    }

    //---Mostrar informacion ordenada por apellido---
    public void mostrarAlumnosOrdenadosPorApellido() {
        Collections.sort(alumnos);
        for (Alumno alumno : alumnos) {
            System.out.println(alumno.getLastName() + " " +  alumno.getName() + "\t - " + alumno.getAge());
        }
    }

//El método Collections.sort() requiere que los objetos en la lista implementen la interfaz Comparable

//Al implementar Comparable en la clase Alumno y proporcionar una implementación del método compareTo(), los objetos Alumno
//se vuelven comparables y se puede utilizar Collections.sort() para ordenar la lista según el orden natural definido en compareTo().

//Cuando llamas a Collections.sort(alumnos), el método sort() ordena la lista alumnos en su lugar, es decir, modifica la lista
//original en lugar de crear una nueva lista ordenada. Utiliza el algoritmo de ordenación "merge sort" para realizar la ordenación.


    //---Mostrar el promedio de edad---

    public void calcularPromedioEdades() {
        int totalEdades = 0;

        for (Alumno alumno : alumnos) {
            totalEdades += alumno.getAge();
        }

        double promedio = (double) totalEdades / alumnos.size();

        System.out.println("\nEl promedio de las edades de los alumnos es: " + promedio);
    }

    //---Mostrar el numero de alumnos que adeudan materias---

    public void adeudaMaterias(){

        int materiasAdeudadas = 0;

        for (Alumno alumno : alumnos){
            if(alumno.getAdeudaMateria()){
                materiasAdeudadas ++;
            }
        }
        if(materiasAdeudadas == 0){
            System.out.println("\nNingun alumno adeuda materias");
        } else if (materiasAdeudadas>0) {
            System.out.println("\nLa cantidad de alunmos que adeudan materia es: " + materiasAdeudadas);
        }
    }

    //---Mostrar alumno con nota mas alta---

        public void notaMasAlta(){

            int notaMasAlta = 0;

            int cantidadAlumnosConNotaMasAlta = 0;

            int alumnosDesaprobados = 0;

            for (Alumno alumno : alumnos) {

                if (alumno.getNota() > notaMasAlta) {
                    notaMasAlta = alumno.getNota();
                    cantidadAlumnosConNotaMasAlta = 1;

                } else if (alumno.getNota() == notaMasAlta) {
                    cantidadAlumnosConNotaMasAlta++;
                }else if(alumno.getNota()<=6){
                    alumnosDesaprobados++;
                }
            }


            System.out.println("\nLa nota mas alta de los alumnos es: " + notaMasAlta);
            System.out.println("Hay " + cantidadAlumnosConNotaMasAlta + " Con esa nota");
            System.out.println("Hay " + alumnosDesaprobados + " alumnos desaprobados");
        }

    //---Mostrar si algun alumno no abono la matricula---

    public void mostrarSiAbonoMatricula(){

        int alumnosSinAbonar = 0;

        for (Alumno alumno : alumnos){
            if(alumno.getAdeudaMateria()){
                System.out.println("\nEl alumno " + alumno.getName() + " No abono la materia");
                alumnosSinAbonar++;
            }
        }
        if(alumnosSinAbonar>0){
            System.out.println("\n" + alumnosSinAbonar + " alumnos no abonaron la materia");
        } else if (alumnosSinAbonar == 0) {
            System.out.println("\nTodos los alumnos abonaron");
        }
    }

    //---Eliminar un alumno---

    public void eliminarAlumnoPorApellido(String aBorrar){

        String lastNameABorrar = null;

        for(Alumno alumno : alumnos){
            if(alumno.getLastName().equals(aBorrar)){
                lastNameABorrar = aBorrar;
            }
        }

        System.out.println("\nVas a borrar a " + lastNameABorrar);

        alumnos.removeIf(alumno -> alumno.getLastName().equals(aBorrar));   //El metodo .removeIf(elemento -> (si esto da "True", lo ELIMINA))

        System.out.println("\nAlumno " + lastNameABorrar + " BORRADO\n");
    }

}
