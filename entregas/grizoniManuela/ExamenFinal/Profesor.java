package entregas.grizoniManuela;

public class Profesor{
    private String nombre; 
    private String dni; 

    public Profesor(String nombre, String dni){
        this.nombre = nombre; 
        this.dni = dni; 
    }
      public void setNombre(String nombre){
        this.nombre = nombre; 
    }
      public void setDni(String dni){
        this.dni = dni; 
    }
    public String getDni(){
        return dni; 
    }

    public String getNombre(){
        return nombre; 
    }

     @Override
    public String toString() {
        return "Profesor: " + nombre + " / DNI " + dni;
    }
}





 
   

   
   
