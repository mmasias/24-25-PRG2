public class Universidad {
    private String nombre;
    private GestorUniversidad gestor;

    public Universidad() {
        nombre = "Universidad Técnica de Innovación";
        gestor = new GestorUniversidad();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nuevoNombre) {
        nombre = nuevoNombre;
    }

    public GestorUniversidad getGestor() {
        return gestor;
    }

    public void setGestor(GestorUniversidad nuevoGestor) {
        gestor = nuevoGestor;
    }

    public void ejecutarUniversidad() {
        gestor.crearAsignatura("Diseño de Software", 5);
        gestor.crearProfesor("Aurelio Márquez López", "12345678A");
        gestor.asignarAsignaturaAProfesor();
        gestor.crearPreguntasExamen();
        gestor.crearExamen();
        gestor.crearProfesorVigilante("Marina Ruiz Delgado", "98765432B");
        gestor.entregarExamenAProfesorVigilante();
        System.out.println(nombre);
        System.out.println();
        gestor.mostrarEscenario();
    }

    @Override
    public String toString() {
        return nombre + " con " + gestor.toString();
    }
}
