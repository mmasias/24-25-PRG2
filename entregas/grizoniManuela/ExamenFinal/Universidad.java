package entregas.grizoniManuela;

public class Universidad{
    private String nombreUni; 

    public Universidad(String nombreUni){
        this.nombreUni = nombreUni; 
    }

    public void setNombreUni(String nombreUni){
        this.nombreUni = nombreUni; 
    }
    public String getNombreUni(){
        return nombreUni; 
    }

    @Override
    public String toString() {
        return "Universidad: " + nombreUni;
    }

}




    

