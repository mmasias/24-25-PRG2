package entregas.alonsoDiego.reto004;

public class Tiempo {
    
    private int hora;
    private int minuto;
    private int segundo;

    public Tiempo(int horas, int minutos, int segundos) {
        assert esHoraValida(hora) && esMinutoValido(minuto) && esSegundoValido(segundo) : "El tiempo no es válido";

        this.hora = horas;
        this.minuto = minutos;
        this.segundo = segundos;
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

    public boolean despuesQue(Tiempo tiempo) {
        return !this.antesQue(tiempo) && !this.equals(tiempo);
    }

    public int compareTo(Tiempo tiempo) {
        return this.antesQue(tiempo) ? -1 : this.equals(tiempo) ? 0 : 1;
    }

    public Tiempo next() {
        int nuevoSegundo = this.segundo + 1;
        int nuevoMinuto = this.minuto;
        int nuevaHora = this.hora;

        if (nuevoSegundo == 60) {
            nuevoSegundo = 0;
            nuevoMinuto++;
        }

        if (nuevoMinuto == 60) {
            nuevoMinuto = 0;
            nuevaHora++;
        }

        if (nuevaHora == 24) {
            nuevaHora = 0;
        }

        return new Tiempo(nuevaHora, nuevoMinuto, nuevoSegundo);
    }

    public String toString() {
        return hora + ":" + minuto + ":" + segundo;
    }

    public Tiempo sumar(Tiempo tiempo) {
        int nuevoSegundo = this.segundo + tiempo.segundo;
        int nuevoMinuto = this.minuto + tiempo.minuto;
        int nuevaHora = this.hora + tiempo.hora;

        if (nuevoSegundo >= 60) {
            nuevoSegundo -= 60;
            nuevoMinuto++;
        }

        if (nuevoMinuto >= 60) {
            nuevoMinuto -= 60;
            nuevaHora++;
        }

        if (nuevaHora >= 24) {
            nuevaHora -= 24;
        }

        return new Tiempo(nuevaHora, nuevoMinuto, nuevoSegundo);
    }

    public boolean esHoraValida(int hora) {
        return hora >= 0 && hora < 24;
    }

    public boolean esMinutoValido(int minuto) {
        return minuto >= 0 && minuto < 60;
    }

    public boolean esSegundoValido(int segundo) {
        return segundo >= 0 && segundo < 60;
    }
}

