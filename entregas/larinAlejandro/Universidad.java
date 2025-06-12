package entregas.larinAlejandro;

public class Universidad {
    private String nombreDeLaUniversidad;
    private static final int MAX_PROFESORES = 2; // Limite de profesores
    private Profesor[] profesores;

    public Universidad(String nombreDeLaUniversidad) {
        this.nombreDeLaUniversidad = nombreDeLaUniversidad;
        this.profesores = new Profesor[MAX_PROFESORES-1];
    }


    public String crearAsignatura(String nombre, int creditos) {
        Asignatura asignatura = getAsignatura(nombre, creditos);
        return asignatura.getNombre();
    }
    
    public Profesor contratarProfesor(String nombre, String dni) {
        Profesor profesor = getProfesor(nombre, dni);
        addProfesor(profesor);
        return profesor;
    }

    public void asignarProfesor(String asignatura, Profesor profesor) {
        profesor.asignarASignatura(asignatura);
    }
    

    private Asignatura getAsignatura(String nombre, int creditos) {
        return new Asignatura(nombre, creditos);
    }

    private void addProfesor(Profesor profesor) {
        if (profesores[0] == null) {
            profesores[0] = profesor;
        } else {
            Profesor[] nuevosProfesores = new Profesor[profesores.length + 1];
            System.arraycopy(profesores, 0, nuevosProfesores, 0, profesores.length);
            nuevosProfesores[profesores.length] = profesor;
            profesores = nuevosProfesores;
        }
    }

    private Profesor getProfesor(String nombre, String dni) {
        return new Profesor(nombre, dni);
    }


    public void mostrarEsenario() {
        System.out.println("Universidad: " + nombreDeLaUniversidad);
        System.out.println("Profesores contratados:");
        Profesor profesor= profesores[0];
        Profesor profesorVigia= profesores[0];
        profesor.entregarExamen(profesorVigia);
        if (profesor != null) {
            System.out.println("Profesor: " + profesor.getNombre() + "/" + profesor.getDni());
            System.out.println("Asignatura: " + profesor.getAsignatura());
        } 

        profesor.mostrarExamen();
    }


}
