package magos.models;

import magos.utils.Dado;

public class Mago {

    private final String nombre;
    private final Vida vida;
    private final HechizoTipo[] libroDeHechizos;
    private final Dado dado;

    public Mago(String nombre, HechizoTipo[] hechizos) {
        this.nombre = nombre;
        this.vida = new Vida();
        this.libroDeHechizos = hechizos;
        this.dado = new Dado();
    }

    public Hechizo lanzarHechizo() {
        int indice = this.dado.tirar(this.libroDeHechizos.length);
        return new Hechizo(this.libroDeHechizos[indice]);
    }

    public void recibirDanio(int danio) {
        this.vida.reducir(danio);
    }

    public boolean estaVivo() {
        return this.vida.estaViva();
    }

    public int vida() {
        return this.vida.puntos();
    }

    public String nombre() {
        return this.nombre;
    }
}
