class Universidad {
    private String nombreUnversidad;
    private Examen[] examenes;
    private Profesor profesor1;
    private Profesor profesor2;

    public Universidad(String nombreUnversidad) {
        this.nombreUnversidad = nombreUnversidad;
        this.examenes = new Examen[1]; 
    }
    public static void main(String[] args) {
        Universidad universidad = new Universidad("Universidad Europea del Atlántico");

        universidad.profesor1 = new Profesor("Ibuprofeno del Jesús", "Fernández Gomez de la Piedra y Cansado", "244455555X");
        universidad.profesor2 = new Profesor("Dalsy Piedad de los Remedios", "Albornoz del Campo", "666456665X");

        Asignatura asignatura = new Asignatura("Programación 2", 6);

        universidad.asignarPuesto(universidad.profesor1, asignatura);

        Examen examen = universidad.profesor1.crearExamen();
        examen.crearPreguntas();
        universidad.examenes[0] = examen;

        universidad.profesor1.darExamen(universidad.profesor2);

        universidad.darDatos();
    }


    void asignarPuesto(Profesor profesor, Asignatura asignatura) {
        profesor.asignatura = asignatura;
    }

    void comprobarImpartiendo(Profesor profesor) {
        if (profesor.asignatura == null) {
            System.out.println("El profesor no está impartiendo ninguna asignatura.");
        }
    }

    void darDatos() {
        System.out.println("Universidad: " + nombreUnversidad);
        System.out.println("Profesor: " + profesor1.nombreUnversidad + " " + profesor1.apellido + " / DNI " + profesor1.Dni);
        System.out.println("   Asignatura: " + profesor1.asignatura.nombreUnversidad + " - PRG2 - " + profesor1.asignatura.creditos + " créditos");
        System.out.println("      Examen: " + profesor1.examenCreado.nombre);
        System.out.println("        Vigilado por: " + profesor2.nombreUnversidad + " " + profesor2.apellido + " / DNI " + profesor2.Dni);
        for (int i = 0; i < profesor1.examenCreado.numero_pregutas; i++) {
            System.out.println("        Pregunta " + (i + 1) + ": \"" + profesor1.examenCreado.ExamenProgra[i] + "\"");
        }
    }

    
}
