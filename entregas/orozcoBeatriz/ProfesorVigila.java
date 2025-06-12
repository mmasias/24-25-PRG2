package entregas.orozcoBeatriz;

public class ProfesorVigila extends Profesor{
     private Examen examenVigilado;

    public ProfesorVigila(String nombre) {
        super(nombre);
    }

    public void recibirExamen(Examen examen) {
        this.examenVigilado = examen;
    }

    public void vigilarExamen() {
        if (examenVigilado != null) {
            examenVigilado.mostrarExamen();
        }
    }
}
