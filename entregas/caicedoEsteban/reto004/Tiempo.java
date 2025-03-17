package caicedoEsteban.reto004;

public class Tiempo {
    private int hora;
    private int minuto;
    private int segundo;

    public Tiempo(int horas, int minutos, int segundos) {
        assert esHoraValida(horas) && esMinutoValido(minutos) && esSegundoValido(segundos) : "No es valida esa hora";

        this.hora = esHoraValida(horas) ? horas : 0;
        this.minuto = esMinutoValido(minutos) ? minutos : 0;
        this.segundo = esSegundoValido(segundos) ? segundos : 0;
    }

    public boolean equals(Tiempo tiempo) {
        return this.hora == tiempo.hora && this.minuto == tiempo.minuto && this.segundo == tiempo.segundo;
    }

    public boolean antesQue(Tiempo tiempo) {
        if (this.hora < tiempo.hora) {
            return true;
        } else if (this.hora == tiempo.hora) {
            if (this.minuto < tiempo.minuto) {
                return true;
            } else if (this.minuto == tiempo.minuto) {
                return this.segundo < tiempo.segundo;
            }
        }
        return false;
    }

    public boolean despuesDe(Tiempo tiempo) {
        return !antesQue(tiempo);
    }

    public int compareTo(Tiempo tiempo) {
        if (this.antesQue(tiempo)) {
            return -1;
        } else if (this.equals(tiempo)) {
            return 0;
        } else {
            return 1;
        }
    }

    public Tiempo next() {
        int horaNueva = this.hora;
        int minutoNuevo = this.minuto;
        int segundoNuevo = this.segundo;

        if (segundoNuevo > 59) {
            segundoNuevo = 0;
            minutoNuevo++;
        } else if (minutoNuevo > 59) {
            minutoNuevo = 0;
            horaNueva++;
        } else if (horaNueva > 23) {
            horaNueva = 0;
        }
        return new Tiempo(horaNueva, minutoNuevo, segundoNuevo);
    }

    public String toString() {
        return String.format("%02d:%02d:%02d", this.hora, this.minuto, this.segundo);
    }

    public Tiempo sumar(Tiempo tiempo) {
        int horaNueva = this.hora + tiempo.hora;
        int minutoNuevo = this.minuto + tiempo.minuto;
        int segundoNuevo = this.segundo + tiempo.segundo;

        if (segundoNuevo > 59) {
            segundoNuevo -= 60;
            minutoNuevo++;
        } else if (minutoNuevo > 59) {
            minutoNuevo -= 60;
            horaNueva++;
        } else if (horaNueva > 23) {
            horaNueva -= 24;
        }
        return new Tiempo(horaNueva, minutoNuevo, segundoNuevo);
    }

    public boolean esHoraValida(int hora) {
        return hora >= 0 && hora <= 23;
    }

    public boolean esMinutoValido(int minuto) {
        return minuto >= 0 && minuto <= 59;
    }

    public boolean esSegundoValido(int segundo) {
        return segundo >= 0 && segundo <= 59;
    }
}
