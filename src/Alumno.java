

//En Java, la interfaz Comparable se utiliza para proporcionar una forma de comparar objetos de una clase y determinar
// su orden natural. Al implementar la interfaz Comparable en una clase, estás indicando que los objetos de esa clase
// son comparables entre sí.

//se utiliza implements Comparable<Alumno> para indicar que los objetos Alumno pueden ser comparados entre sí. Esto significa
// que la clase Alumno debe proporcionar una implementación del método compareTo() definido en la interfaz Comparable.

public class Alumno implements Comparable<Alumno> {
    private String name;
    private String lastName;
    private int age;
    private boolean adeudaMateria;
    private int nota;
    private boolean abono;

    public Alumno(String name, String lastName, int age, boolean adeudaMateria, int nota, boolean abono) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.adeudaMateria = adeudaMateria;
        this.nota = nota;
        this.abono = abono;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean getAdeudaMateria() {
        return adeudaMateria;
    }

    public void setAdeudaMateria(boolean adeudaMateria) {
        this.adeudaMateria = adeudaMateria;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public boolean getAbono() {
        return abono;
    }

    public void setAbono(boolean abono) {
        this.abono = abono;
    }

//El método compareTo() es el método clave que se debe implementar al usar Comparable. Este método compara el objeto
// actual con otro objeto del mismo tipo y devuelve un valor entero que indica su orden relativo. La implementación del
// método compareTo() debe seguir la siguiente convención:
    // * Si el objeto actual es menor que el objeto pasado como argumento, debe devolver un número negativo.
    // * Si el objeto actual es igual al objeto pasado como argumento, debe devolver 0.
    // * Si el objeto actual es mayor que el objeto pasado como argumento, debe devolver un número positivo.
    @Override
    public int compareTo(Alumno otro) {
        return this.lastName.compareTo(otro.getLastName());
    }

//En este caso, se utiliza this.lastName.compareTo(otro.getLastName()) para comparar los apellidos de dos objetos Alumno.
//El método compareTo() de la clase String devuelve un número negativo si el apellido actual es menor alfabéticamente
// que el apellido pasado como argumento, 0 si son iguales y un número positivo si el apellido actual es mayor.

//Al implementar Comparable y proporcionar una implementación adecuada del método compareTo(), puedes ordenar los objetos
//Alumno en colecciones utilizando métodos como Collections.sort() (Es lo que utilizo en Curso)



}