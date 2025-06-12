
public class TresEnRaya {

    private Tablero tablero;
    private Jugador[] jugadores;
    private Turno turno;

    public TresEnRaya() {
        tablero = new Tablero();
        jugadores = new Jugador[2];
        jugador[0] = new Jugador( 'x' );
        jugador[1] = new Jugador( 'o' );
        turno = new Turno();
    }

    public void jugar() {

        do {
            tablero.mostrar();
            if (!tablero.estaCompleto(jugadores[turno.leToca( )])){
                jugadores[turno.leToca()].ponerFicha(tablero);
            } else {
                jugadores[turno.leToca()].moverFicha(tablero);
            }
            turno.cambiar();
        } while(!tablero.hayTresEnRaya());
        jugadores[turno.noLeToca()].celebrar();
    }
}