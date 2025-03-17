package entregas.alvaradoCarlos.reto004;

public class Tiempo {

    private int HORAS, MINUTOS, SEGUNDOS;

    public Tiempo(int horas, int minutos, int segundos) {

        assert esHoraValida(horas): "Error: las horas deben estar entre 0 y 23";
        assert esMinutoValido(minutos): "Error: los minutos deben estar entre 0 y 59";
        assert esSegundoValido(segundos): "Error: los segundos deben estar entre 0 y 59";

        minutos += segundos / 60;
        segundos = segundos % 60;

        horas += minutos / 60;
        minutos = minutos % 60;

        horas = horas % 24;

        this.HORAS = horas;
        this.MINUTOS = minutos;
        this.SEGUNDOS = segundos;
    }

    public boolean equals(Tiempo tiempo) {
        return this.HORAS == tiempo.HORAS &&
               this.MINUTOS == tiempo.MINUTOS &&
               this.SEGUNDOS == tiempo.SEGUNDOS;
    }
    
    public boolean antesQue(Tiempo tiempo) {
        if (this.HORAS < tiempo.HORAS) return true;
        if (this.HORAS == tiempo.HORAS && this.MINUTOS < tiempo.MINUTOS) return true;
        if (this.HORAS == tiempo.HORAS && this.MINUTOS == tiempo.MINUTOS && this.SEGUNDOS < tiempo.SEGUNDOS) return true;
        return false;
    }
    
    public boolean despuesDe(Tiempo tiempo) {
        if (this.equals(tiempo)) return false;
        return !this.antesQue(tiempo);
    }
    
    public int compareTo(Tiempo tiempo) {
        if (this.equals(tiempo)) return 0;
        return this.antesQue(tiempo) ? -1 : 1;
    }
    
    public Tiempo sumar(Tiempo tiempo) {
        int totalSegundos = this.SEGUNDOS + tiempo.SEGUNDOS;
        int totalMinutos = this.MINUTOS + tiempo.MINUTOS + totalSegundos / 60;
        int totalHoras = this.HORAS + tiempo.HORAS + totalMinutos / 60;
    
        totalSegundos %= 60;
        totalMinutos %= 60;
        totalHoras %= 24;
    
        return new Tiempo(totalHoras, totalMinutos, totalSegundos);
    }

    private boolean esHoraValida(int horas) {
        return horas >= 0 && horas < 24;
    }
    
    private boolean esMinutoValido(int minutos) {
        return minutos >= 0 && minutos < 60;
    }
    
    private boolean esSegundoValido(int segundos) {
        return segundos >= 0 && segundos < 60;
    }

    public String toString() {
        return this.HORAS + ":" + this.MINUTOS + ":" + this.SEGUNDOS;
    }

}
