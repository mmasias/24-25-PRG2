package valdesCarlos;

public class Alumno {
    private String nombre;

    public Alumno(String nombre) {
        this.nombre = nombre;
    }

    public void hacerExamen(Examen examen) {
        System.out.println(nombre + " está haciendo el examen con " + examen.getTotalPreguntas() + " preguntas.");
    }
}
