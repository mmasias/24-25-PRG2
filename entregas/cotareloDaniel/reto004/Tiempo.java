package entregas.cotareloDaniel.reto004;

public class Tiempo {
    private int horas;
    private int minutos;
    private int segundos;

    public Tiempo(int horas, int minutos, int segundos) {
        assert (esHoraValida(horas) || esMinutoValido(minutos) || esSegundoValido(segundos)) : "Tiempo no válido";

        this.horas = horas;
        this.minutos = minutos;
        this.segundos = segundos;
    }

    public boolean equals(Tiempo tiempo) {
        return this.horas == tiempo.horas && this.minutos == tiempo.minutos && this.segundos == tiempo.segundos;
    }

    public boolean antesQue(Tiempo tiempo) {
        if (this.horas < tiempo.horas)
            return true;
        if (this.horas == tiempo.horas && this.minutos < tiempo.minutos)
            return true;
        return this.horas == tiempo.horas && this.minutos == tiempo.minutos && this.segundos < tiempo.segundos;
    }

    public boolean despuesDe(Tiempo tiempo) {
        if (this.horas > tiempo.horas)
            return true;
        if (this.horas == tiempo.horas && this.minutos > tiempo.minutos)
            return true;
        return this.horas == tiempo.horas && this.minutos == tiempo.minutos && this.segundos > tiempo.segundos;
    }

    public int compareTo(Tiempo tiempo) {
        if (this.antesQue(tiempo))
            return -1;
        if (this.despuesDe(tiempo))
            return 1;
        return 0;
    }

    public Tiempo next() {
        int nuevoHoras = this.horas;
        int nuevoMinutos = this.minutos;
        int nuevoSegundos = this.segundos + 1;

        if (nuevoSegundos == 60) {
            nuevoSegundos = 0;
            nuevoMinutos++;

            if (nuevoMinutos == 60) {
                nuevoMinutos = 0;
                nuevoHoras++;

                if (nuevoHoras == 24) {
                    nuevoHoras = 0;
                }
            }
        }

        return new Tiempo(nuevoHoras, nuevoMinutos, nuevoSegundos);
    }

    public String toString() {
        String h = (horas < 10) ? "0" + horas : "" + horas;
        String m = (minutos < 10) ? "0" + minutos : "" + minutos;
        String s = (segundos < 10) ? "0" + segundos : "" + segundos;

        return h + ":" + m + ":" + s;
    }

    public Tiempo sumar(Tiempo tiempo) {
        int totalSegundos = this.segundos + tiempo.segundos;
        int totalMinutos = this.minutos + tiempo.minutos + (totalSegundos / 60);
        int totalHoras = this.horas + tiempo.horas + (totalMinutos / 60);

        if (totalSegundos >= 60) {
            totalMinutos += totalSegundos / 60;
            totalSegundos = totalSegundos % 60;
        }

        if (totalMinutos >= 60) {
            totalHoras += totalMinutos / 60;
            totalMinutos = totalMinutos % 60;
        }

        if (totalHoras >= 24) {
            totalHoras = totalHoras % 24;
        }

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