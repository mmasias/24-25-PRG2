package magos.models;

public class Vida {

    private static final int VIDA_INICIAL = 100;
    private int puntos;

    public Vida() {
        this.puntos = VIDA_INICIAL;
    }

    public void reducir(int danio) {
        this.puntos -= danio;
    }

    public boolean estaViva() {
        return this.puntos > 0;
    }

    public int puntos() {
        return Math.max(this.puntos, 0);
    }
}
