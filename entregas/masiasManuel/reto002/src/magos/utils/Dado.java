package magos.utils;

import java.util.Random;

public class Dado {

    private final Random random;

    public Dado() {
        this.random = new Random();
    }

    public int tirar(int limite) {
        return this.random.nextInt(limite);
    }
}
