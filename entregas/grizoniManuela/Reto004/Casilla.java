package entregas.grizoniManuela.Reto004;

public class Casilla {
    private boolean mina;
    private boolean revelada;
    private boolean marcada;

    public Casilla(){

    }

    public boolean isMina(){
        return mina;
    }

    public void setMina(boolean mina){
        this.mina = mina; 
    }

    public boolean isRevelada(){
        return revelada;
    }

    public boolean isMarcada(){
        return marcada; 
    }
}
