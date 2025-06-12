package src;

public class Universidad {
    private String nombre;
    private Profesor[] profesores;
    private Asignatura asignatura;
    private Examen examen;

    public Universidad(String nombre) {
        this.nombre = nombre;
        this.profesores = new Profesor[2];
    }

    public void iniciar() {
        profesores[0] = new Profesor("Juan Pérez", "12345678A");
        profesores[1] = new Profesor("Ana López", "87654321B");

        asignatura = new Asignatura();
        asignatura.setName("Programación II");
        asignatura.setCreditos(6);

        Profesor[] ids = {profesores[0]};
        asignatura.setProfesor(ids);

        String[] preguntas = {
            "Vista pública de clases",
            "Vista púbica de objetsos",
            "Vista privada de clases"
        };
        examen = new Examen(preguntas, preguntas.length);

        System.out.println("Universidad: " + nombre);
        System.out.println("Profesor que imparte: " + profesores[0].getName() + " con DNI " + profesores[0].getDNI());
        System.out.println("Asignatura: " + asignatura.getName() + " con " + asignatura.getCreditos() + " créditos.");
        System.out.println("Examen: " + examen.getTipoExamen());
        System.out.println("Vigilado por: " + profesores[1].getName() + " con DNI " + profesores[1].getDNI());
        System.out.println("Pregunta 1: " + examen.getPreguntas()[0]);
        System.out.println("Pregunta 2: " + examen.getPreguntas()[1]);
        System.out.println("Pregunta 3: " + examen.getPreguntas()[2]);
    }
}