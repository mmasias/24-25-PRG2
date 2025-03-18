package entregas.puenteSergio.reto004;

public class Tiempo {
    private int horas;
    private int minutos;
    private int segundos;

    public Tiempo(int horas, int minutos, int segundos) {
        if (!esTiempoValido(horas, minutos, segundos)) {
            throw new IllegalArgumentException("Tiempo no válido");
        }
        this.horas = horas;
        this.minutos = minutos;
        this.segundos = segundos;
    }

    private boolean esTiempoValido(int horas, int minutos, int segundos) {
        return esHoraValida(horas) && esMinutoValido(minutos) && esSegundoValido(segundos);
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

    public boolean esIgualA(Tiempo otroTiempo) {
        return this.horas == otroTiempo.horas && this.minutos == otroTiempo.minutos && this.segundos == otroTiempo.segundos;
    }

    public boolean esAnteriorA(Tiempo otroTiempo) {
        return this.compareTo(otroTiempo) < 0;
    }

    public boolean esPosteriorA(Tiempo otroTiempo) {
        return this.compareTo(otroTiempo) > 0;
    }

    public int compareTo(Tiempo otroTiempo) {
        if (this.horas != otroTiempo.horas) {
            return Integer.compare(this.horas, otroTiempo.horas);
        }
        if (this.minutos != otroTiempo.minutos) {
            return Integer.compare(this.minutos, otroTiempo.minutos);
        }
        return Integer.compare(this.segundos, otroTiempo.segundos);
    }

    public Tiempo obtenerSiguiente() {
        int nuevoSegundos = this.segundos + 1;
        int nuevoMinutos = this.minutos;
        int nuevaHora = this.horas;

        if (nuevoSegundos == 60) {
            nuevoSegundos = 0;
            nuevoMinutos++;
            if (nuevoMinutos == 60) {
                nuevoMinutos = 0;
                nuevaHora = (nuevaHora + 1) % 24;
            }
        }
        return new Tiempo(nuevaHora, nuevoMinutos, nuevoSegundos);
    }

    public Tiempo sumar(Tiempo otroTiempo) {
        int totalSegundos = this.segundos + otroTiempo.segundos;
        int totalMinutos = this.minutos + otroTiempo.minutos + (totalSegundos / 60);
        int totalHoras = this.horas + otroTiempo.horas + (totalMinutos / 60);
        return new Tiempo(totalHoras % 24, totalMinutos % 60, totalSegundos % 60);
    }

    
    public String toString() {
        return String.format("%02d:%02d:%02d", horas, minutos, segundos);
    }
}
