package 24-25-PRG2.entregas.src.ExamenUniversidad;

public class ExamenUniversidad {
    private Universidad universidad;
    private Profesor[] profesor;

    public ExamenUniversidad(){
        this.universidad= new Universidad();
        this.profesor = new Profesor[2];
        profesor[0] = new Profesor();
        profesor[1] = new Profesor();
    }
    public void realizarExamen(){
        universidad.crear();
        universidad.creaAsignatura();
        universidad.contrataProfesores();
        profesor[0].creaExamen();
        profesor[0].entregaExamen(profesor[1]);
    }
}
