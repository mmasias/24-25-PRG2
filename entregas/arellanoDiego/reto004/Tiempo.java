package entregas.arellanoDiego.reto004;

public class Tiempo {
    private int horas;
    private int minutos;
    private int segundos;

    public Tiempo(int horas, int minutos, int segundos) {
        if (esHoraValida(horas) && esMinutoValido(minutos) && esSegundoValido(segundos)) {
            this.horas = horas;
            this.minutos = minutos;
            this.segundos = segundos;
        } else {
            throw new IllegalArgumentException("Tiempo inválido");
        }
    }

    public boolean equals(Tiempo tiempo) {
        return this.horas == tiempo.horas && this.minutos == tiempo.minutos && this.segundos == tiempo.segundos;
    }

    public boolean antesQue(Tiempo tiempo) {
        if (this.horas < tiempo.horas) return true;
        if (this.horas == tiempo.horas && this.minutos < tiempo.minutos) return true;
        return this.horas == tiempo.horas && this.minutos == tiempo.minutos && this.segundos < tiempo.segundos;
    }

    public boolean despuesDe(Tiempo tiempo) {
        return !this.antesQue(tiempo) && !this.equals(tiempo);
    }

    public int compareTo(Tiempo tiempo) {
        if (this.equals(tiempo)) return 0;
        return this.antesQue(tiempo) ? -1 : 1;
    }

    public Tiempo next() {
        int nuevoSegundos = segundos + 1;
        int nuevoMinutos = minutos;
        int nuevaHora = horas;

        if (!esSegundoValido(nuevoSegundos)) {
            nuevoSegundos = 0;
            nuevoMinutos++;

            if (!esMinutoValido(nuevoMinutos)) {
                nuevoMinutos = 0;
                nuevaHora++;

                if (!esHoraValida(nuevaHora)) {
                    nuevaHora = 0;
                }
            }
        }

        return new Tiempo(nuevaHora, nuevoMinutos, nuevoSegundos);
    }

    public String toString() {
        return String.format("%02d:%02d:%02d", horas, minutos, segundos);
    }

    public int sumar(Tiempo tiempo) {
        int totalSegundos = this.aHorasASegundos() + tiempo.aHorasASegundos();
        return totalSegundos;
    }

    private int aHorasASegundos() {
        return horas * 3600 + minutos * 60 + segundos;
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
}
