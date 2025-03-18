package entregas.perozoDiego.reto004;

public class Tiempo {
    private int horas, minutos, segundos;

    public Tiempo(int horas, int minutos, int segundos){
        assert horas <= 24 : "El valor de las horas no puede ser mayor que 24";
        assert minutos <= 60 : "El valor de los minutos no puede ser mayor que 60";
        assert segundos <= 60 : "El valor de los segundos no puede ser mayor que 60";

        this.horas = horas;
        this.minutos = minutos;
        this.segundos = segundos;
    }

    public boolean equals (Tiempo tiempo){
        if (this.horas == tiempo.horas && this.minutos == tiempo.minutos && this.segundos == tiempo.segundos) {
            return true;
        }else{
            return false;
        }
    }

    public boolean antesQue(Tiempo tiempo){
        if (this.horas >= tiempo.horas && this.minutos >= tiempo.minutos && this.segundos > tiempo.segundos) {
            return true;
        }else{
            return false;
        }
    }

    public boolean despuesDe(Tiempo tiempo){
        if (this.horas <= tiempo.horas && this.minutos <= tiempo.minutos && this.segundos < tiempo.segundos) {
            return true;
        }else{
            return false;
        }
    }

    public int compareTo(Tiempo tiempo){
        if (equals(tiempo)){
            return 0;
        }else if(despuesDe(tiempo)){
            return 1;
        }else{
            return -1;
        }
    }

    public Tiempo next(){
        return new Tiempo(this.horas, this.minutos, (this.segundos + 1));
    }

    public String toString(){
        return "La hora es: " + horas + ":" + minutos + ":" + segundos;
    }

    public Tiempo sumar(Tiempo tiempo){
        return new Tiempo((this.horas + tiempo.horas),(this.minutos + tiempo.minutos),(this.segundos + tiempo.segundos));
    }

    public void esHoraValida(int hora){
        assert this.horas + hora <= 24 : "La hora instrucida no puede ser procesada";
    }

    public void esMinutoValido(int minuto){
        assert this.minutos + minuto <= 60 : "Los minutos introducidos no pueden ser procesados";
    }

    public void esSegundoValido(int segundo){
        assert this.segundos + segundo <= 60 : "Los segundos nop pueden ser procesados";
    }

}