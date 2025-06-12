package entregas.alejandroDeLaPeña.ExamenFinal;

public class Universidad {
    private String nombreUniversidad;
    Profesor[] profesores = new Profesor[2];
    Asignatura[] asignaturas = new Asignatura[1];

    public Universidad(String nombreUniversidad) {
        this.nombreUniversidad = nombreUniversidad;
    }

    public void mostrarContenido() {
        System.out.println("Nombre de la Universidad: " + nombreUniversidad);

        System.out.println("\nProfesores:");
        for (Profesor p : profesores) {
            if (p != null) p.mostrarProfesor();
        }

        System.out.println("\nAsignaturas:");
        for (Asignatura a : asignaturas) {
            if (a != null) {
                a.mostrarAsignatura();
                System.out.println();
            }
        }
    }
}

