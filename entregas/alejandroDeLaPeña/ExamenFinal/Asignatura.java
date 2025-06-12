package entregas.alejandroDeLaPeña.ExamenFinal;

public class Asignatura {
    private String nombreAsignatura;
    private Profesor profesorImparte;
    private int credito;

    public Asignatura(String nombreAsignatura, Profesor profesorImparte, int credito) {
        this.nombreAsignatura = nombreAsignatura;
        this.profesorImparte = profesorImparte;
        this.credito = credito;

        // Asociar esta asignatura al profesor
        this.profesorImparte.setAsignaturaImpartida(this);
    }

    public boolean imparteProfesor(Profesor profesor) {
        return this.profesorImparte.getDni().equals(profesor.getDni());
    }

    public Profesor getProfesorImparte() {
        return profesorImparte;
    }

    public String getNombreAsignatura() {
        return nombreAsignatura;
    }

    public void mostrarAsignatura() {
        System.out.println("Asignatura: " + nombreAsignatura);
        System.out.println("Créditos: " + credito);
        System.out.println("Impartida por: " + profesorImparte.getNombreCompleto());
    }
}

