package alvaradoCarlos;
public class Examen {

    private String tipo;
    private Asignatura asignatura;
    private boolean vigilado;

    public Examen(String tipo, Asignatura asignatura) {
        this.tipo = tipo;
        this.asignatura = asignatura;
        vigilado = false;
    }

    public boolean esVigilado(){
        return vigilado;
    }

    public void asociarAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
        vigilado = true;
    }

    public String toString() {
        return tipo + asignatura.toString();
    }
    
}
