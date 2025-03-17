package entregas.coboIsmael.reto004;

public class Tiempo {
    private int horas, minutos, segundos;

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
        return (this.horas < tiempo.horas) || (this.horas == tiempo.horas && this.minutos < tiempo.minutos) ||
               (this.horas == tiempo.horas && this.minutos == tiempo.minutos && this.segundos < tiempo.segundos);
    }

    public boolean despuesDe(Tiempo tiempo) {
        return (this.horas > tiempo.horas) || (this.horas == tiempo.horas && this.minutos > tiempo.minutos) ||
               (this.horas == tiempo.horas && this.minutos == tiempo.minutos && this.segundos > tiempo.segundos);
    }

    public int compareTo(Tiempo tiempo) {
        if (antesQue(tiempo)) {
            return -1;
        } else if (equals(tiempo)) {
            return 0;
        } else {
            return 1;
        }
    }

    public Tiempo next() {
        int nuevoSegundos = this.segundos + 1;
        int nuevoMinutos = this.minutos;
        int nuevaHora = this.horas;

        if (nuevoSegundos >= 60) {
            nuevoSegundos = 0;
            nuevoMinutos++;
        }
        if (nuevoMinutos >= 60) {
            nuevoMinutos = 0;
            nuevaHora++;
        }
        if (nuevaHora >= 24) {
            nuevaHora = 0;
        }
        return new Tiempo(nuevaHora, nuevoMinutos, nuevoSegundos);
    }

    public Tiempo sumar(Tiempo tiempo) {
        int nuevoSegundos = this.segundos + tiempo.segundos;
        int nuevoMinutos = this.minutos + tiempo.minutos;
        int nuevaHora = this.horas + tiempo.horas;

        if (nuevoSegundos >= 60) {
            nuevoSegundos -= 60;
            nuevoMinutos++;
        }
        if (nuevoMinutos >= 60) {
            nuevoMinutos -= 60;
            nuevaHora++;
        }
        if (nuevaHora >= 24) {
            nuevaHora -= 24;
        }

        return new Tiempo(nuevaHora, nuevoMinutos, nuevoSegundos);
    }

    public String toString() {
        return horas + ":" + minutos + ":" + segundos;
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