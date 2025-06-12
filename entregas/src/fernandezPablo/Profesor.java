package entregas.src.fernandezPablo;

public class Profesor {
    private String nombre;
    private boolean programacion; 
    private String asignatura;

    public Profesor(String nombre, boolean programacion) {
        this.nombre = nombre;
        this.programacion = programacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void asignar(String asignatura) {
        this.asignatura = asignatura;
    }

    public Examen crearExamen() {
        if (programacion && asignatura != null && asignatura.equals("Programación")) {
            System.out.println(nombre + " está creando el examen de programación...");
            Examen examen = new Examen();
            examen.asignar("¿Qué es la herencia?");
            examen.asignar("Explica el concepto de encapsulamiento.");
            examen.asignar("¿Qué significa abstracción en POO?");
            return examen;
        } else {
            System.out.println(nombre + " no puede crear el examen.");
            return null;
        }
    }
    
    public void entregar(Examen examen) {
        if (examen != null) {
            System.out.println(nombre + " ha entregado el examen.");
        }
    }

    public void vigilar(Examen examen) {
        if (!programacion && examen != null) {
            System.out.println(nombre + " está vigilando el examen.");
        } else {
            System.out.println(nombre + " no puede vigilar el examen que ha creado.");
        }
    }
}
