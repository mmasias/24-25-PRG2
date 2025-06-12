public class Universidad {

    public String nombreUniversidad[];
    public String nombreAsignatura[];
    public String profesor[] = Profesores.profesores; 
    public Profesores[] profesorAsignadoAExamen;

    public Universidad(String[] nombreUniversidad, String[] nombreAsignatura) {
        public String nombreUniversidad[];
        public String nombreAsignatura[];
        public String profesor[] = Profesores.profesores; 
        public Profesores[] profesorAsignadoAExamen;
    }

    public void asignarAsignaturaAProfesor(String asignatura, String nombreProfesor) {
        for (int i = 0; i < nombreAsignatura.length; i++) {
            if (nombreAsignatura[i].equals(asignatura)) {
                profesorAsignadoAExamen[i] = new Profesores(nombreProfesor);
                System.out.println("Asignatura '" + asignatura + "' asignada a " + nombreProfesor);
                return;
            }
        }
        System.out.println("Asignatura no encontrada.");
    }

   
    public void contratarProfesor(String nuevoNombre) {
        String[] nuevos = new String[profesor.length + 1];
        System.arraycopy(profesor, 0, nuevos, 0, profesor.length);
        nuevos[profesor.length] = nuevoNombre;
        profesor = nuevos;
        System.out.println("Profesor contratado: " + nuevoNombre);
    }

    public void contratarVigilantes(String nombreVigilante) {
        System.out.println("Vigilante contratado: " + nombreVigilante);
    }
}
