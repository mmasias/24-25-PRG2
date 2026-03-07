package entregas.Restaurante;

public class Mesas {

    private int numeroMesa;
    private int capacidadMesa;
    private boolean ocupada;
    private String lugarMesa;

    public int getNumeroMesa() {
        return numeroMesa;
    }

    public void setNumeroMesa(int numeroMesa) {
        this.numeroMesa = numeroMesa;
    }

    public int getCapacidaMesa() {
        return capacidadMesa;
    }

    public void setCapacidaMesa(int capacidadMesa) {
        this.capacidadMesa = capacidadMesa;
    }

    public boolean isOcupada() {
        return ocupada;
    }

    public void setOcupada(boolean ocupada) {
        this.ocupada = ocupada;
    }

    public String getLugarMesa() {
        return lugarMesa;
    }

    public void setLugarMesa(String lugarMesa) {
        this.lugarMesa = lugarMesa;
    }

}
