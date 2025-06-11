

import java.util.Random;

public class Juego {
    private Marco marco;
    private Madre madre;
    private double distancia;
    private int dia;

    public Juego() {
        this.marco = new Marco();
        this.madre = new Madre();
        this.distancia = 350.0;
        this.dia = 1;
    }

    public void iniciar() {
        System.out.println("DIARIO DEL VIAJE DE MARCO\n=========================");
        while (distancia > 0) {
            System.out.println("DIA " + dia);
            double avanceMarco = marco.avanzar();
            double avanceMadre = madre.avanzar();
            distancia += avanceMadre - avanceMarco;
            if (distancia < 0) distancia = 0;

            System.out.printf("Al final del día %d la distancia entre Marco y su Madre es de %.2f Km\n", dia, distancia);
            System.out.println("-".repeat(65));
            dia++;
        }
        System.out.println("************************************************************");
        System.out.println("Al final del día " + (dia - 1) + " Marco encuentra a su madre!!!");
        System.out.println("************************************************************");
    }

    public static void main(String[] args) {
        new Juego().iniciar();
    }
}

class Marco {
    private Mono amedio;
    private Random rnd;

    public Marco() {
        this.amedio = new Mono();
        this.rnd = new Random();
    }

    public double avanzar() {
        double velocidad = randomEntre(10, 15);
        double horas = randomEntre(8, 10);

        String clima = Clima.generar();
        if (clima.equals("lluvia fuerte")) {
            velocidad *= 0.25;
            System.out.println("¡Ha llovido muchísimo!");
        } else if (clima.equals("lluvia")) {
            velocidad *= 0.75;
            System.out.println("Ha llovido un poco");
        } else {
            System.out.println("Ha hecho un buen día");
        }

        boolean escapa = amedio.escapa();
        boolean cansado = amedio.cansado();

        if (escapa) {
            horas -= 2;
            System.out.println("¡He perdido tiempo buscando a Amedio!");
        }
        if (cansado) {
            velocidad *= 0.9;
        }

        double avance = velocidad * horas;
        System.out.printf("Avance %.2f horas a %.2f Km/h recorriendo %.2f Km\n", horas, velocidad, avance);
        return avance;
    }

    private double randomEntre(int min, int max) {
        return min + rnd.nextDouble() * (max - min);
    }
}

class Madre {
    private Random rnd;

    public Madre() {
        this.rnd = new Random();
    }

    public double avanzar() {
        double velocidad = randomEntre(6, 9);
        double horas = randomEntre(6, 9);

        String clima = Clima.generar();
        if (clima.equals("lluvia fuerte")) {
            velocidad *= 0.5;
            System.out.println("A mamá le ha llovido muchísimo");
        } else if (clima.equals("lluvia")) {
            velocidad *= 0.75;
            System.out.println("A mamá le ha llovido un poco");
        } else {
            System.out.println("A mamá le ha hecho un buen día");
        }

        double avance = velocidad * horas;
        System.out.printf("Mama pudo avanzar %.2f horas a %.2f Km/h recorriendo %.2f Km\n", horas, velocidad, avance);
        return avance;
    }

    private double randomEntre(int min, int max) {
        return min + rnd.nextDouble() * (max - min);
    }
}

class Mono {
    private Random rnd;

    public Mono() {
        this.rnd = new Random();
    }

    public boolean escapa() {
        return rnd.nextDouble() < 0.15;
    }

    public boolean cansado() {
        return rnd.nextDouble() < 0.25;
    }
}

class Clima {
    private static Random rnd = new Random();

    public static String generar() {
        double prob = rnd.nextDouble();
        if (prob < 0.10) return "lluvia fuerte";
        if (prob < 0.40) return "lluvia";
        return "bueno";
    }
}