package entregas.caicedoFernando.reto004;

class Tiempo {
    private int horas, minutos, segundos;
    private final int HORAS_POR_DIA = 24;
    private final int MINUTOS_POR_HORA = 60;
    private final int SEGUNDOS_POR_MINUTO = 60;

    Tiempo(int horas, int minutos, int segundos){    
        this.horas = horas;
        this.minutos = minutos;
        this.segundos = segundos;        
    }

    public boolean equals(Tiempo tiempo){
        return this.horas == tiempo.horas && this.minutos == tiempo.minutos && this.segundos == tiempo.segundos;
    }

    public boolean antesQue(Tiempo tiempo){
        if(horas < tiempo.horas)
            return true;
        if(minutos < tiempo.minutos)
            return true;
        if(segundos < tiempo.segundos)
            return true;
        return false;
    }

    public boolean despuesQue(Tiempo tiempo){
        if(horas > tiempo.horas)
            return true;
        if(minutos > tiempo.minutos)
            return true;
        if(segundos > tiempo.segundos)
            return true;
        return false;
    }

    public int compareTo(Tiempo tiempo){
        if(antesQue(tiempo))
            return -1;
        if(despuesQue(tiempo))
            return 1;
        return 0;
    }

    private Tiempo sumarSegundos (int segundos){
        this.segundos += segundos;
        reiniciarReloj();
        validarTiempo("Sumar segundos");
        return this;
    }

    private Tiempo sumarMinutos(int minutos){
        this.minutos += minutos;
        reiniciarReloj();
        validarTiempo("Sumar minutos");
        return this;
    }

    private Tiempo sumarHoras(int horas){
        this.horas += horas;
        reiniciarReloj();
        validarTiempo("Sumar horas");
        return this;
    }

    private void reiniciarMinutos(){
        if(minutos >= MINUTOS_POR_HORA){
            horas += minutos / MINUTOS_POR_HORA;
            minutos = minutos % MINUTOS_POR_HORA;
        }
    }

    private void reiniciarSegundos(){
        if(segundos >= SEGUNDOS_POR_MINUTO){
            minutos += segundos / SEGUNDOS_POR_MINUTO;
            segundos = segundos % SEGUNDOS_POR_MINUTO;
        }
    }

    private void reiniciarReloj(){
        reiniciarMinutos();
        reiniciarSegundos();
    }

    public Tiempo sumar(Tiempo tiempo){
        sumarSegundos(tiempo.segundos);
        sumarMinutos(tiempo.minutos);
        sumarHoras(tiempo.horas);
        return this;
    }

    public Tiempo next(){
        return sumarSegundos(1);
    }

    public String toString(){
        return "El tiempo [horas: " + horas + ", minutos: " + minutos + ", segundos: " + segundos + "]";
    }

    public boolean esHoraValida(int horas){
        return horas >= 0 && horas < HORAS_POR_DIA;
    }

    public boolean esMinutoValido(int minutos){
        return minutos >= 0 && minutos < MINUTOS_POR_HORA;
    }

    public boolean esSegundoValido(int segundos){
        return segundos >= 0 && segundos < SEGUNDOS_POR_MINUTO;
    }

    private void validarTiempo(String contexto){
       assert esHoraValida(horas) : contexto + " - Horas no válidas";
       assert esMinutoValido(minutos) : contexto + " - Minutos no válidos";
       assert esSegundoValido(segundos) : contexto + " - Segundos no válidos";
    }
}
    

