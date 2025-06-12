import java.util.Scanner;

class Asignatura {
    String nombre

    public Asignatura(String nombre) {
        this.nombre = nombre;
    }
}

class Examen {
    Asignatura asignatura;
    Profesor creador;
    Profesor vigilante;

    public Examen(Asignatura asignatura, Profesor creador, Profesor vigilante) {
        this.asignatura = asignatura;
        this.creador = creador;
        this.vigilante = vigilante;
    }

    public void infoExamen() {
        System.out.println("Profesor: " + creador.getNombre());
        System.out.println("Asignatura: " + asignatura.nombre)
        System.out.println("Vigilado por : " + vigilante.getNombre())
    }
}      

class Profesor {
    private String nombre;
    private Asignatura asignatura;

    public Profesor(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean tieneAsignatura() {
        return asignatura != null;
    }

    public void asignarAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
        System.out.println(nombre + " imparte la asignatura de: " + asignatura.nombre);
    }

    public Examen crearExamen(profesor vigilante) {
        if (!this.tieneAsignatura()) {
            System.out.println(nombre + " no puede crear examen, no tiene asignatura asignada");
            return null;
        }

        if (vigilante.tieneAsignatura()) {
        System.out.println(vigilante.getNombre() + " no puede vigilar el examen, ya tiene asignatura asignada");
        return null;
        }

        Examen examen = new Examen(this.asignatura, this, vigilante);
        System.out.println(nombre + " ha creado un examen de " + asignatura.nombre + " y lo entregó a " + vigilante.getNombre() + " para vigilar");
        return examen;
   }
}