public class Profesor {
    private String nombre;
    private String dni;
    private Asignatura asignatura;
    private String[] examen;

    public Profesor(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
    }

    public void SetAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    }

    public void crearExamen() {
        if (this.asignatura == null) {
            System.out.println(nombre + " no tiene asignatura asignada. No puede crear examen.");
            return;
        }
        examen = new String[3];
        examen[0] = "Vista publica clases";
        examen[1] = " Vista publica de objetos";
        examen[2] = "Vista privada de clases";
    }

    public void entregarExamen(Profesor otroProfesor) {
        if (this.examen == null || this.asignatura == null || otroProfesor.asignatura == null) {
            System.out.println("No se puede entregar el examen.");
            return;
        }

        System.out.println("Universidad: Universidad europea del Atlantico");
        System.out.println("Profesor: " + this.nombre + " / DNI " + this.dni);
        System.out.println(asignatura.getDescripcion());
        System.out.println("  Examen: Examen Final");
        System.out.println("    Vigilado por: " + otroProfesor.nombre + " / DNI " + otroProfesor.dni);
        for (int i = 0; i < examen.length; i++) {
            System.out.println("       pregunta " + (i + 1) + ": \"" + examen[i] + "\"");
        }
    }
}
