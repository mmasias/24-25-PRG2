package entregas.delarivaAlejandro.reto004;

public class Tiempo {
    private int horas, minutos, segundos;

    public Tiempo(int horas, int minutos, int segundos) {
        if (!esHoraValida(horas)) {
            throw new IllegalArgumentException("Hora no válida");
        }
        if (!esMinutoValido(minutos)) {
            throw new IllegalArgumentException("Minuto no válido");
        }
        if (!esSegundoValido(segundos)) {
            throw new IllegalArgumentException("Segundo no válido");
        }

        this.horas = horas;
        this.minutos = minutos;
        this.segundos = segundos;
    }

    public boolean equals(Tiempo otroTiempo) {
        if (this == otroTiempo) return true;
        if (otroTiempo == null) return false;
        return this.horas == otroTiempo.horas && this.minutos == otroTiempo.minutos && this.segundos == otroTiempo.segundos;
    }

    public boolean esAntesDe(Tiempo otroTiempo) {
        if (this.horas != otroTiempo.horas) {
            return this.horas < otroTiempo.horas;
        } else if (this.minutos != otroTiempo.minutos) {
            return this.minutos < otroTiempo.minutos;
        } else {
            return this.segundos < otroTiempo.segundos;
        }
    }

    public boolean esDespuesDe(Tiempo otroTiempo) {
        return !equals(otroTiempo) && !esAntesDe(otroTiempo);
    }

    public int compararCon(Tiempo otroTiempo) {
        if (esAntesDe(otroTiempo)) {
            return -1;
        } else if (equals(otroTiempo)) {
            return 0;
        } else {
            return 1;
        }
    }

    public Tiempo siguiente() {
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

    public Tiempo sumar(Tiempo otroTiempo) {
        int nuevoSegundos = this.segundos + otroTiempo.segundos;
        int nuevoMinutos = this.minutos + otroTiempo.minutos;
        int nuevaHora = this.horas + otroTiempo.horas;

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

    @Override
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
