package entregas.larinAlejandro;

public class Asignatura {
    private String nombre;
    private int creditos;

    public Asignatura(String nombre, int creaditos) {
        this.nombre = nombre;
        this.creditos = creaditos;
      
    }

    public String getNombre() {
        
        return this.nombre;
        
    }
    public int getCreditos() {
        return this.creditos;
    }

}
