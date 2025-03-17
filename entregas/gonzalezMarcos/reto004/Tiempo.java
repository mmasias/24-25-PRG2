package entregas.gonzalezMarcos.reto004;

public class Tiempo {
    private int horas;
    private int minutos;
    private int segundos;

    public Tiempo(int horas, int minutos, int segundos) {
        if (!esHoraValida(horas) || !esMinutoValido(minutos) || !esSegundoValido(segundos)) {
            System.out.println("Tiempo no válido");
        }
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
        if (this.horas != tiempo.horas) {
            return this.horas < tiempo.horas ? -1 : 1;
        }
        if (this.minutos != tiempo.minutos) {
            return this.minutos < tiempo.minutos ? -1 : 1;
        }
        return this.segundos < tiempo.segundos ? -1 : (this.segundos > tiempo.segundos ? 1 : 0);
    }

    public Tiempo next() {
        int nuevoSegundos = this.segundos + 1;
        int nuevoMinutos = this.minutos;
        int nuevaHora = this.horas;

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

    public Tiempo sumar(Tiempo tiempo) {
        int totalSegundos = this.segundos + tiempo.segundos;
        int totalMinutos = this.minutos + tiempo.minutos + (totalSegundos / 60);
        int totalHoras = this.horas + tiempo.horas + (totalMinutos / 60);
        return new Tiempo(totalHoras % 24, totalMinutos % 60, totalSegundos % 60);
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
