public class Profesor {
    private String miNombre;
    private boolean imparto;
    private String miAsignatura;

    public Profesor(String nombre, boolean imparte,String asignacion) {
        this.miNombre=nombre;
        this.imparto=imparte;
        this.miAsignatura=asignacion;
    }

    public String nombre(){
        return miNombre;
    }
    public String asignacion(){
        return miAsignatura;
    }

    public boolean imparte(){
        return imparto;
    }

    public void asignar(Asignatura asignaturas){
        miAsignatura=asignaturas;
    }


}
