package src.calderonJimena.Gato;

public class Jugador {

    private char color;

    public Jugador(char color) {
        this.color = color;
    }

    public void ponerFicha(Tablero tablero) {
        Coordenada coordenada = new Coordenada();
        do {
            coordenada.pedir();
        } while (!coordenada.esValida() || tablero.estaOcupdo(coordenada));
        tablero.ponerFicha(coordenada, color);
    }

    public void moverFicha(Tablero tablero) {
        Coordenada coordenada = new Coordenada();
        do {
            coordenada.pedir();
        } while (!coordenada.esValida() || tablero.estaVacio(coordenada));
        tablero.sacarFicha(coordenada);
        this.ponerFicha(tablero);
    }

    public void celebrar() {
        System.out.println("Hemos ganado los" + color);
    }

    public char color() {
        return color;
    }

}
