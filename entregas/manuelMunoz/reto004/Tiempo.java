package entregas.manuelMunoz.reto004;

public class Tiempo {
    private int horas;
    private int minutos;
    private int segundos;

    public Tiempo(int horas, int minutos, int segundos){
        assert horas > 24 : "Las horas no pueden ser mas de 24 horas";
        assert minutos > 60 : "Los minutos no pueden ser mas de 60 minutos";
        assert segundos > 60 : "Los segundos no pueden ser mas de 60 segundos";

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
        return new Tiempo(esHoraValida(this.horas + tiempo.horas),esMinutoValido(this.minutos + tiempo.minutos),esSegundoValido(this.segundos + tiempo.segundos));
    }

    public int esHoraValida(int hora){
        assert this.horas + hora < 24 : "La hora insertada no es valida";
        return this.horas += hora;
    }

    public int esMinutoValido(int minuto){
        assert this.minutos + minuto < 60 : "Los minutos ingresados no son validos";
        return this.minutos += minuto;
    }

    public int esSegundoValido(int segundo){
        assert this.segundos + segundo < 60 : "Los segundos ingresados no son validos";
        return this.segundos += segundo;
    }

}
