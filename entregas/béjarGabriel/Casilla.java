public class Casilla {
    private boolean mina;
    private boolean revelada;
    private boolean marcada;

    public Casilla() {
        mina = false;
        revelada = false;
        marcada = false;
    }

    public boolean isMina() {
        return mina;
    }

    public void setMina(boolean mina) {
        this.mina = mina;
    }

    public boolean isRevelada() {
        return revelada;
    }

    public void setRevelada(boolean revelada) {
        this.revelada = revelada;
    }

    public boolean isMarcada() {
        return marcada;
    }

    public void setMarcada(boolean marcada) {
        this.marcada = marcada;
    }
}