package entregas.calderonJimena.reto004;

public class Tiempo {

    private int horas;
    private int minutos;
    private int segundos;

    public Tiempo(int horas, int minutos, int segundos) {
        assert horas >= 0 && horas < 24;
        assert minutos >= 0 && minutos < 60;
        assert segundos >= 0 && segundos < 60;
        this.horas = horas;
        this.minutos = minutos;
        this.segundos = segundos;
    }

    public boolean equals(Tiempo tiempo) {
        return this.horas == tiempo.horas && this.minutos == tiempo.minutos && this.segundos == tiempo.segundos;
    }

    public boolean antesQue(Tiempo tiempo) {
        if (this.horas < tiempo.horas) {
            return true;
        } else if (this.horas == tiempo.horas) {
            if (this.minutos < tiempo.minutos) {
                return true;
            } else if (this.minutos == tiempo.minutos) {
                return this.segundos < tiempo.segundos;
            }
        }
        return false;
    }

    public boolean despuesQue(Tiempo tiempo) {
        return !this.antesQue(tiempo) && !this.equals(tiempo);
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

    public Tiempo next () {
        int segundos = this.segundos;
        int minutos = this.minutos;
        int horas = this.horas;
        if (segundos == 59) {
            segundos = 0;
            if (minutos == 59) {
                minutos = 0;
                if (horas == 23) {
                    horas = 0;
                } else {
                    horas++;
                }
            } else {
                minutos++;
            }
        } else {
            segundos++;
        }
        return new Tiempo(horas, minutos, segundos);
    }

    public String toString() {
        return this.horas + ":" + this.minutos + ":" + this.segundos;
    }

    public Tiempo sumar (Tiempo tiempo) {
        int segundos = this.segundos + tiempo.segundos;
        int minutos = this.minutos + tiempo.minutos;
        int horas = this.horas + tiempo.horas;
        if (segundos >= 60) {
            segundos -= 60;
            minutos++;
        }
        if (minutos >= 60) {
            minutos -= 60;
            horas++;
        }
        if (horas >= 24) {
            horas -= 24;
        }
        return new Tiempo(horas, minutos, segundos);
    }

    public boolean esHoraValida(int hora) {
        return this.horas >= 0 && this.horas < 24;
    }

    public boolean esMinutoValido(int minuto) {
        return this.minutos >= 0 && this.minutos < 60;
    }

    public boolean esSegundoValido(int segundo) {
        return this.segundos >= 0 && this.segundos < 60;
    }

}
