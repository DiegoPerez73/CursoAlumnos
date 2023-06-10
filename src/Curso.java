import java.util.*;

public class Curso {

    private final List<Alumno> alumnos = new ArrayList<>();

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
        alumnos.forEach(alumno -> System.out.println("\tNombre y apellido: " + alumno.getName() + " " + alumno.getLastName() +
                    "\n\tEdad: " + alumno.getAge() + "\n\tAdeuda materia? " + alumno.getAdeudaMateria() +
                    "\n\tNota: " + alumno.getNota() + "\n\tAbonó? " + alumno.getAbono() + "\n"));
    }

    //---Mostrar informacion ordenada de alumnos por apellido ---
    public void mostrarAlumnosOrdenadosPorApellido() {
        alumnos.sort((alumno1, alumno2) -> alumno1.getLastName().compareTo(alumno2.getLastName()));

        alumnos.forEach(alumno -> System.out.printf("ID %d, %s %s\t - %d años\n",alumno.getId(), alumno.getLastName(), alumno.getName(), alumno.getAge()));
    }

    //Utilizo el alumnos.sort(), y lo ordena automaticamente. Le paso por parametro las dos variables que va a comparar, alumno 1
    //y alumno 2. Despues le digo que a alumno1, le haga el getLastName() (getter), y con .compareTo(Aca le pongo con el otro
    // nombre que va a comparar.)


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


        alumnos.sort(Comparator.comparing(Alumno::getName));    //Los ordeno por nombre

        for (Alumno alumno : alumnos){
            if(alumno.getAdeudaMateria()) System.out.printf("%s %s adeuda materias\n",alumno.getName(), alumno.getLastName());
        }

        long cantidad = alumnos.stream().filter(Alumno::getAdeudaMateria).count();

        if (cantidad>0)System.out.printf("\n%d alumnos adeudan materias\n", cantidad);
        if(cantidad == 0)System.out.println("\nNingun alumno adeuda materias");
    }

    //---Mostrar alumno con nota mas alta---

    public void notaMasAlta(){

        alumnos.sort(Comparator.comparingInt(Alumno::getNota).reversed());

        int notaMasAlta = alumnos.get(0).getNota();

        List<Alumno> notaMasAltaList = alumnos.stream().filter(alumno -> alumno.getNota() == notaMasAlta).toList();

        System.out.printf("La nota mas alta es %d.\n", notaMasAlta);

        if(notaMasAltaList.size()>1){
            System.out.printf("Hay %d alumnos con la nota mas alta.\n",notaMasAltaList.size());
            notaMasAltaList.forEach(alumno -> System.out.printf("%s %s\n", alumno.getName(), alumno.getLastName()));
        }else {
            System.out.printf("El alumno es: %s %s", notaMasAltaList.get(0).getName(), notaMasAltaList.get(0).getName());
        }
    }

    //---Mostrar si algun alumno no abono la matricula---

    public void mostrarSiAbonoMatricula(){


        List<Alumno> noAbonaron = alumnos.stream().filter(alumno -> !alumno.getAbono()).toList();
        int cantNoAbono = noAbonaron.size();
        if(cantNoAbono>1){
            System.out.printf("%d alumnos no abonaron la matricula\n", cantNoAbono);
            noAbonaron.forEach(alumno -> System.out.printf("%s %s\n", alumno.getName(), alumno.getLastName()));
        } else if (cantNoAbono == 0) {
            System.out.println("Todos los alumnos abonaron!");
        } else if (cantNoAbono == 1) {
            System.out.printf("%s %s no abonó la matrícula", noAbonaron.get(0).getName(), noAbonaron.get(0).getName());
        }
    }


    //---Mostrar un alumno por ID (Lo hago para reutilizar en varios metodos ---
    public void mostrarId(int id){
        alumnos.stream()
                .filter(alumno -> alumno.getId() == id)
                .toList()
                .forEach(alumno ->System.out.printf("ID: %d, %s %s\n",alumno.getId(),alumno.getName(),alumno.getLastName()) );
    }

    //---Retornar alumno por ID---
    public Alumno getAlumnoId(int id){

        return alumnos.stream().filter(alumno -> alumno.getId() == id).toList().get(0);
    }

    //---Eliminar un alumno---
    public void eliminarAlumnoPorId(int id){

        Alumno alumnoBorrado = getAlumnoId(id);

        alumnos.remove(alumnoBorrado);

        //  alumnos.removeIf(alumno -> alumno.getId() == id);       //Con removeIf(Si esto da TRUE, lo elimina)

        System.out.printf("Alumno %s %s ELIMINADO\n",alumnoBorrado.getName(), alumnoBorrado.getLastName());
    }

}
