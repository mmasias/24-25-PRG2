// Universidad.java
public class Universidad {
    private String nombre;
    private RecursosHumanos recursos;

    public Universidad(String nombre) {
        this.nombre = nombre;
        this.recursos = new RecursosHumanos();
    }

    public Asignatura definirAsignatura(String nombre) {
        return new Asignatura(nombre, "PRG2", 6);
    }

    public RecursosHumanos getRecursosHumanos() {
        return recursos;
    }

    public String getNombre() {
        return nombre;
    }
}
