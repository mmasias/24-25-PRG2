package src;
public class Examen{
    private String Preguntas[];
    private int NumeroPreguntas;
    private String tipoExamen = "Examen Final";

    public Examen(String Preguntas[], int NumeroPreguntas) {
        this.Preguntas = Preguntas;
        this.NumeroPreguntas = NumeroPreguntas;
        this.tipoExamen = "Examen Final";
    }

    public String[] getPreguntas() {
        return Preguntas;
    }
    public void setPreguntas(String[] preguntas) {
        this.Preguntas = preguntas;
    }

    public int getNumeroPreguntas() {
        return NumeroPreguntas;
    }
    public void setNumeroPreguntas(int numeroPreguntas) {
        this.NumeroPreguntas = numeroPreguntas;
    }
    public String getTipoExamen() {
        return tipoExamen;
    }   
    public void setTipoExamen(String tipoExamen) {
        this.tipoExamen = tipoExamen;
    }


}