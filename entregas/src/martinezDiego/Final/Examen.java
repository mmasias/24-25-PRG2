package martinezDiego.Final;

public class Examen {
    
    private String tipo;

    private String preguntas;

    public void creadoPor(){
        
    }

    

    public Examen(String tipo, String preguntas) {
        this.tipo = tipo;
        this.preguntas = preguntas;
    }



    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getPreguntas() {
        return preguntas;
    }

    public void setPreguntas(String preguntas) {
        this.preguntas = preguntas;
    }

    
    
}
