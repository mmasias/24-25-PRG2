public class Tiempo {
    private int horas, minutos, segundos;

    public Tiempo(int horas, int minutos, int segundos) {
        if (!esHoraValida(horas) || !esMinutoValido(minutos) || !esSegundoValido(segundos)) {
            throw new IllegalArgumentException("Tiempo inválido");
        }
        this.horas = horas;
        this.minutos = minutos;
        this.segundos = segundos;
    }

    public boolean equals(Tiempo t) {
        return horas == t.horas && minutos == t.minutos && segundos == t.segundos;
    }

    public boolean antesQue(Tiempo t) {
        return compareTo(t) < 0;
    }

    public boolean despuesDe(Tiempo t) {
        return compareTo(t) > 0;
    }

    public int compareTo(Tiempo t) {
        return (horas * 3600 + minutos * 60 + segundos) - (t.horas * 3600 + t.minutos * 60 + t.segundos);
    }

    public Tiempo next() {
        return sumar(new Tiempo(0, 0, 1));
    }

    public Tiempo sumar(Tiempo t) {
        int totalSegundos = horas * 3600 + minutos * 60 + segundos + t.horas * 3600 + t.minutos * 60 + t.segundos;
        return new Tiempo((totalSegundos / 3600) % 24, (totalSegundos / 60) % 60, totalSegundos % 60);
    }

    public static boolean esHoraValida(int hora) {
        return hora >= 0 && hora < 24;
    }

    public static boolean esMinutoValido(int minuto) {
        return minuto >= 0 && minuto < 60;
    }

    public static boolean esSegundoValido(int segundo) {
        return segundo >= 0 && segundo < 60;
    }

    public String toString() {
        return String.format("%02d:%02d:%02d", horas, minutos, segundos);
    }
}
