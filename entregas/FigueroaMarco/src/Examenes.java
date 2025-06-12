public class Examenes {
    private int idExamen;
    private String nombreExamen;
    private String[] preguntasExamen;
    private int idAsignatura;

    public Examenes(int idExamen, String nombreExamen, String[] preguntasExamen, int idAsignatura) {
        this.idExamen = idExamen;
        this.nombreExamen = nombreExamen;
        this.preguntasExamen = preguntasExamen;
        this.idAsignatura = idAsignatura;
    }

    @Override
    public String toString() {
        return "Examenes{" +
                "idExamen=" + idExamen +
                ", nombreExamen='" + nombreExamen + '\'' +
                ", preguntasExamen=" + java.util.Arrays.toString(preguntasExamen) +
                ", idAsignatura=" + idAsignatura +
                '}';
    }
}