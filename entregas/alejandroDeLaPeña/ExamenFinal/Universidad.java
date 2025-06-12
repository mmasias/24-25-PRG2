package entregas.alejandroDeLaPeña.ExamenFinal;

public class Universidad {

    private String nombreUniversidad;
    Profesor[] profesores = new Profesor[2];
    Asignatura[] asignaturas = new Asignatura[1];

    public Universidad(String nombreUniversidad) {
        this.nombreUniversidad = nombreUniversidad;
    }

    public void mostrarContenido() {
        System.out.println("Universidad: " + nombreUniversidad);
        System.out.println("--- Profesores ---");
        for (Profesor p : profesores) {
            if (p != null) {
                System.out.println(p.getNombreCompleto());
            }
        }
        System.out.println("--- Asignaturas ---");
        for (Asignatura a : asignaturas) {
            if (a != null) {
                a.mostrarAsignatura();
            }
        }
    }
}

