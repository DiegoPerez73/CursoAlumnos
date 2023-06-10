

//En Java, la interfaz Comparable se utiliza para proporcionar una forma de comparar objetos de una clase y determinar
// su orden natural. Al implementar la interfaz Comparable en una clase, estás indicando que los objetos de esa clase
// son comparables entre sí.

//se utiliza implements Comparable<Alumno> para indicar que los objetos Alumno pueden ser comparados entre sí. Esto significa
// que la clase Alumno debe proporcionar una implementación del método compareTo() definido en la interfaz Comparable.

public class Alumno {

    private static int contadorId = 0;

    private final int id;
    private String name;
    private String lastName;
    private int age;
    private boolean adeudaMateria;
    private int nota;
    private boolean abono;

    public Alumno(String name, String lastName, int age, boolean adeudaMateria, int nota, boolean abono) {
        this.id = ++contadorId;
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.adeudaMateria = adeudaMateria;
        this.nota = nota;
        this.abono = abono;
    }

    public int getId(){
        return id;
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

}