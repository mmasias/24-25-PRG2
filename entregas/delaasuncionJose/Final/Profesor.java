package entregas.delaasuncionJose.Final;

public class Profesor {
    private String nombre;
    private String dni;
    private Asignatura[] asignaturas;
    private Examen[] examenes = new Examen[5];
    private int examenesAlmacenados = 0;

    public Profesor(String nombre, String dni, Asignatura[] asignaturas) {
        this.nombre = nombre;
        this.dni = dni;
        this.asignaturas = asignaturas;
    }

    public void escribirExamen(Asignatura asignatura) {
        examenesAlmacenados++;
        boolean imparte=false;

        for (Asignatura asignaturaComparacion : asignaturas) {
            if (asignaturaComparacion==asignatura) {
                imparte=true;
            }
        }

        if (examenesAlmacenados<=5 && imparte) {
            examenes[examenesAlmacenados-1] = new Examen(asignatura);
        } else {
            System.out.println("ERROR: No se pueden crear mas examenes, memoria llena.");
        }
    }

    public Examen pasarExamen() {
        Examen examen = examenes[examenesAlmacenados-1];
        examenes[examenesAlmacenados-1] = null;
        examenesAlmacenados--;
        return examen;
    }

    public void vigilar(Examen examen) {
        boolean imparte=false;

        if (asignaturas != null) {
            for (Asignatura asignaturaComparacion : asignaturas) {
                if (asignaturaComparacion==examen.getAsignatura()) {
                    imparte=true;
                }  
            }
        }
        
        if (!imparte) {
            examenes[examenesAlmacenados]=examen;
            examen.vigilado(nombre + " / " + dni);
            examenesAlmacenados++;
        } else {
            System.out.println("ERROR: Examen impartido y vigilado por el mismo profesor, examen destruido");
        }
    }

    public void mostrar() {
        if (examenesAlmacenados>0) {
            for (int i = 0; i < examenesAlmacenados; i++) {
                examenes[i].mostrar();
            }
        } else {
            System.out.println("Profesor: " + nombre + " / " + dni);
        }
    }
}
