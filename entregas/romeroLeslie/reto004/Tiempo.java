package entregas.romeroLeslie.reto004;


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
        return this.compareTo(tiempo) > 0;
    }
    
    public int compareTo(Tiempo tiempo) {
        int resultado = Integer.compare(this.horas, tiempo.horas);
        if (resultado == 0) {
            resultado = Integer.compare(this.minutos, tiempo.minutos);
            if (resultado == 0) {
                resultado = Integer.compare(this.segundos, tiempo.segundos);
            }
        }
        return resultado;
    }

    public Tiempo next() {
        int segundos = (this.segundos + 1) % 60;
        int minutos = this.minutos;
        int horas = this.horas;
        
        if (segundos == 0) {
            minutos = (minutos + 1) % 60;
            if (minutos == 0) {
                horas = (horas + 1) % 24;
            }
        }
        
        return new Tiempo(horas, minutos, segundos);
    }

    public String toString() {
        return this.horas + ":" + this.minutos + ":" + this.segundos;
    }

    public Tiempo sumar(Tiempo tiempo) {
        int totalSegundos = this.segundos + tiempo.segundos;
        int totalMinutos = this.minutos + tiempo.minutos + totalSegundos / 60;
        int totalHoras = (this.horas + tiempo.horas + totalMinutos / 60) % 24;
        
        int segundos = totalSegundos % 60;
        int minutos = totalMinutos % 60;
        
        return new Tiempo(totalHoras, minutos, segundos);
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

