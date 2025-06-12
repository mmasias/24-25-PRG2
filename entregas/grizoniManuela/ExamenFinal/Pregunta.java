package entregas.grizoniManuela;

public class Pregunta{
    private String enunciado;  

    public Pregunta(String enunciado){
        this.enunciado = enunciado; 
    }
      public void setEnunciado(String enunciado){
        this.enunciado = enunciado; 
    }
   
    public String getEnunciado(){
        return enunciado; 
    }

    @Override
    public String toString() {
        return "\"" + enunciado + "\"";
    }

}


   
    