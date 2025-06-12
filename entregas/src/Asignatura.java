package src;
public class Asignatura {
    private String Name;
    private int Creditos;
    private Profesor Profesor[];

    public Asignatura(){
        this.Name = "";
        this.Creditos = 0;
        this.Profesor = new Profesor[2];
    }

    public String getName() {
        return Name;
    }
    public void setName(String name) {
        this.Name = name;
    }
    public int getCreditos() {
        return Creditos;
    }
    public void setCreditos(int creditos) {
        this.Creditos = creditos;
    }
    public Profesor[] getProfesor() {
        return Profesor;
    }
    public void setProfesor(Profesor[] profesor) {
        this.Profesor = profesor;
    }    
}