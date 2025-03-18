package entregas.solarAdrian.reto004;

public class Tiempo {
    private int horas, minutos, segundos;

    public Tiempo(int horas, int minutos, int segundos) {
        assert esHoraValida(horas) : "Hora inválida";
        assert esMinutoValido(minutos) : "Minuto inválido";
        assert esSegundoValido(segundos) : "Segundo inválido";

        this.horas = horas;
        this.minutos = minutos;
        this.segundos = segundos;
    }

    public boolean equals(Tiempo tiempo) {
        return this.horas == tiempo.horas && this.minutos == tiempo.minutos && this.segundos == tiempo.segundos;
    }

    public boolean antesQue(Tiempo tiempo) {
        return compareTo(tiempo) < 0;
    }

    public boolean despuesDe(Tiempo tiempo) {
        return compareTo(tiempo) > 0;
    }

    public int compareTo(Tiempo tiempo) {
        if (this.horas != tiempo.horas) return Integer.compare(this.horas, tiempo.horas);
        if (this.minutos != tiempo.minutos) return Integer.compare(this.minutos, tiempo.minutos);
        return Integer.compare(this.segundos, tiempo.segundos);
    }

    public Tiempo next() {
        int nuevoHoras = this.horas;
        int nuevoMinutos = this.minutos;
        int nuevoSegundos = this.segundos + 1;

        if (!esSegundoValido(nuevoSegundos)) {
            nuevoSegundos = 0;
            nuevoMinutos++;
            if (!esMinutoValido(nuevoMinutos)) {
                nuevoMinutos = 0;
                nuevoHoras = (nuevoHoras + 1) % 24;
            }
        }
        return new Tiempo(nuevoHoras, nuevoMinutos, nuevoSegundos);
    }

    public Tiempo sumar(Tiempo tiempo) {
        int totalSegundos = this.segundos + tiempo.segundos;
        int totalMinutos = this.minutos + tiempo.minutos + totalSegundos / 60;
        int totalHoras = (this.horas + tiempo.horas + totalMinutos / 60) % 24;
        return new Tiempo(totalHoras, totalMinutos % 60, totalSegundos % 60);
    }

    public String toString() {
        return horas + ":" + minutos + ":" + segundos;
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
