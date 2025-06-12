package entregas.grizoniManuela;

public class Asignatura{
    private String titulo; 
    private String codigo;
    private int credito;  

    public Asignatura(String titulo, String codigo, int credito){
        this.titulo = titulo; 
        this.codigo = codigo;
        this.credito = credito;  
    }
      public void setTitulo(String titulo){
        this.titulo = titulo; 
    }
      public void setCodigo(String codigo){
        this.codigo = codigo; 
    }
    public void setCredito(int credito){
        this.credito = credito; 
    }

    public String getTitulo(){
        return titulo; 
    }

    public String getCodigo(){
        return codigo; 
    }

     public int getCredito(){
        return credito; 
    }

      @Override
    public String toString() {
        return titulo + " - " + codigo + " - " + credito + " créditos";
    }


}


    

  
