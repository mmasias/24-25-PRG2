package entregas.orozcoBeatriz.reto004;

public class Tiempo {
    private static final int MINUTOS = 60;
    private static final int HORAS = 24;
    private static final int SEGUNDOS = 60;

    private int horas;
    private int minutos;
    private int segundos;

    public Tiempo(int horas, int minutos, int segundos) {
        assert esHoraValida(horas) : "Hora no válida";
        assert esMinutoValido(minutos) : "Minuto no válido";
        assert esSegundoValido(segundos) : "Segundo no válido";

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
        if (this.horas < tiempo.horas || (this.horas == tiempo.horas && this.minutos < tiempo.minutos) ||
        (this.horas == tiempo.horas && this.minutos == tiempo.minutos && this.segundos < tiempo.segundos)) {
            return -1;
        } else if (this.horas > tiempo.horas || (this.horas == tiempo.horas && this.minutos > tiempo.minutos) ||
        (this.horas == tiempo.horas && this.minutos == tiempo.minutos && this.segundos > tiempo.segundos)) {
            return 1;
        } else {
            return 0;
        }
    }

    public Tiempo siguiente() {
        int nuevosSegundos = segundos + 1;
        int nuevosMinutos = minutos;
        int nuevaHora = horas;
        if (nuevosSegundos == SEGUNDOS) {
            nuevosSegundos = 0;
            nuevosMinutos = minutos + 1;
            if (nuevosMinutos == MINUTOS) {
                nuevosMinutos = 0;
                nuevaHora = horas + 1;
                if (nuevaHora == HORAS) {
                    nuevaHora = 0;
                }
            }
        }
        return new Tiempo(nuevaHora, nuevosMinutos, nuevosSegundos);
    }

    public String toString() { 
        return horas + ":" + minutos + ":" + segundos;
    }

    public Tiempo sumar(Tiempo tiempo) {
        int totalSegundos = this.segundos + tiempo.segundos;
        int totalMinutos = this.minutos + tiempo.minutos + (totalSegundos / 60);
        int totalHoras = this.horas + tiempo.horas + (totalMinutos / 60);
        return new Tiempo(totalHoras % HORAS, totalMinutos % MINUTOS, totalSegundos % SEGUNDOS);
    }

    public boolean esHoraValida(int hora) {
        return hora >= 0 && hora < HORAS;
    }

    public boolean esMinutoValido(int minuto) {
        return minuto >= 0 && minuto < MINUTOS;
    }

    public boolean esSegundoValido(int segundo) {
        return segundo >= 0 && segundo < SEGUNDOS;
    }
}
