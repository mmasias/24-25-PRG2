package entregas.vaqueroSara.reto004;

public class Tiempo {

    private int horas;
    private int minutos;
    private int segundos;

    public Tiempo(int horas, int minutos, int segundos) {
        this.horas = horas;
        this.minutos = minutos;
        this.segundos = segundos;
    }

    public boolean equals(Tiempo tiempo) {
        if (tiempo == null) {
            return false;
        }
        return this.horas == tiempo.horas
                && this.minutos == tiempo.minutos
                && this.segundos == tiempo.segundos;
    }

    public boolean antesQue(Tiempo tiempo) {
        if (tiempo == null) {
            throw new IllegalArgumentException("El tiempo no puede ser nulo.");
        }
        return this.horas < tiempo.horas || 
               (this.horas == tiempo.horas && this.minutos < tiempo.minutos) || 
               (this.horas == tiempo.horas && this.minutos == tiempo.minutos && this.segundos < tiempo.segundos);
    }

    public boolean despuesDe(Tiempo tiempo) {
        if (tiempo == null) {
            throw new IllegalArgumentException("El tiempo no puede ser nulo.");
        }
        return this.horas > tiempo.horas || 
               (this.horas == tiempo.horas && this.minutos > tiempo.minutos) || 
               (this.horas == tiempo.horas && this.minutos == tiempo.minutos && this.segundos > tiempo.segundos);
    }

    public Tiempo next() {
        int nuevoHoras = this.horas;
        int nuevoMinutos = this.minutos;
        int nuevoSegundos = this.segundos + 1;

        if (nuevoSegundos == 60) {
            nuevoSegundos = 0;
            nuevoMinutos++;
        }
        if (nuevoMinutos == 60) {
            nuevoMinutos = 0;
            nuevoHoras++;
        }
        if (nuevoHoras == 24) {
            nuevoHoras = 0;
        }

        return new Tiempo(nuevoHoras, nuevoMinutos, nuevoSegundos);
    }

    @Override
    public String toString() {
        return String.format("%02d:%02d:%02d", horas, minutos, segundos);
    }

    public Tiempo sumar(Tiempo tiempo) {
        if (tiempo == null) {
            throw new IllegalArgumentException("El tiempo no puede ser nulo.");
        }

        int nuevoHoras = this.horas + tiempo.horas;
        int nuevoMinutos = this.minutos + tiempo.minutos;
        int nuevoSegundos = this.segundos + tiempo.segundos;

        if (nuevoSegundos >= 60) { 
            nuevoSegundos -= 60;
            nuevoMinutos++;
        }
        if (nuevoMinutos >= 60) { 
            nuevoMinutos -= 60;
            nuevoHoras++;
        }
        if (nuevoHoras >= 24) { 
            nuevoHoras %= 24;
        }

        return new Tiempo(nuevoHoras, nuevoMinutos, nuevoSegundos);
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
