package entregas.quintanaJuan.reto004;

public class Tiempo {

    private int horas;
    private int minutos;
    private int segundos;

    public Tiempo(int horas, int minutos, int segundos) {
        if (!esHoraValida(horas) || !esMinutoValido(minutos) || !esSegundoValido(segundos)) {
            throw new IllegalArgumentException("Tiempo invalido");
        }
        this.horas = horas;
        this.minutos = minutos;
        this.segundos = segundos;
    }

    public boolean equals(Tiempo tiempo) {
        return this.horas == tiempo.horas && this.minutos == tiempo.minutos && this.segundos == tiempo.segundos;
    }

    public boolean antesQue(Tiempo tiempo) {
        return this.compareTo(tiempo) < 0;
    }

    public boolean despuesDe(Tiempo tiempo) {
        return this.compareTo(tiempo) > 0;
    }

    public int compareTo(Tiempo tiempo) {
        if (this.horas != tiempo.horas) {
            return this.horas - tiempo.horas;
        } else if (this.minutos != tiempo.minutos) {
            return this.minutos - tiempo.minutos;
        } else {
            return this.segundos - tiempo.segundos;
        }
    }

    public Tiempo next() {
        int nuevoSegundos = this.segundos + 1;
        int nuevoMinutos = this.minutos;
        int nuevoHoras = this.horas;

        if (nuevoSegundos >= 60) {
            nuevoSegundos = 0;
            nuevoMinutos++;
            if (nuevoMinutos >= 60) {
                nuevoMinutos = 0;
                nuevoHoras++;
                if (nuevoHoras >= 24) {
                    nuevoHoras = 0;
                }
            }
        }

        return new Tiempo(nuevoHoras, nuevoMinutos, nuevoSegundos);
    }

    public String toString() {
        return String.format("%02d:%02d:%02d", horas, minutos, segundos);
    }

    public Tiempo sumar(Tiempo tiempo) {
        int totalSegundos = this.segundos + tiempo.segundos;
        int totalMinutos = this.minutos + tiempo.minutos + totalSegundos / 60;
        int totalHoras = this.horas + tiempo.horas + totalMinutos / 60;

        totalSegundos %= 60;
        totalMinutos %= 60;
        totalHoras %= 24;

        return new Tiempo(totalHoras, totalMinutos, totalSegundos);
    }

    private boolean esHoraValida(int hora) {
        return hora >= 0 && hora < 24;
    }

    private boolean esMinutoValido(int minuto) {
        return minuto >= 0 && minuto < 60;
    }

    private boolean esSegundoValido(int segundo) {
        return segundo >= 0 && segundo < 60;
    }
}
