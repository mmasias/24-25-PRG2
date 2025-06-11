package magos;

import magos.models.Hechizo;
import magos.models.HechizoTipo;
import magos.models.Mago;
import magos.utils.Console;

public class Juego {

    private final Mago magoUno;
    private final Mago magoDos;
    private final Console console;

    public Juego() {
        HechizoTipo[] hechizos = HechizoTipo.values();
        this.magoUno = new Mago("Merlín", hechizos);
        this.magoDos = new Mago("Morgana", hechizos);
        this.console = Console.getInstance();
    }

    public void jugar() {
        this.console.writeln("Batalla de Magos");
        while (this.magoUno.estaVivo() && this.magoDos.estaVivo()) {
            this.turno(this.magoUno, this.magoDos);
            if (this.magoDos.estaVivo()) {
                this.turno(this.magoDos, this.magoUno);
            }
            this.console.writeln("-----------------------");
        }
        this.mostrarGanador();
    }

    private void turno(Mago atacante, Mago defensor) {
        Hechizo hechizo = atacante.lanzarHechizo();
        defensor.recibirDanio(hechizo.danio());
        this.console.writeln(atacante.nombre() + " lanza " + hechizo.nombre());
        this.console.writeln(defensor.nombre() + " pierde " + hechizo.danio() + " de vida");
        this.console.writeln("Vida de " + defensor.nombre() + ": " + defensor.vida());
    }

    private void mostrarGanador() {
        Mago ganador = this.magoUno.estaVivo() ? this.magoUno : this.magoDos;
        this.console.writeln("Gana " + ganador.nombre() + " con " + ganador.vida() + " de vida restante");
    }
}
