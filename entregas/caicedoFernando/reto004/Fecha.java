package entregas.caicedoFernando.reto004;

public class Fecha {
    private  int dia;
    private  int mes;
    private  int anio;

    public Fecha(int dia, int mes, int año) {
        assert año > 0 : "No hay años negativos :)";
        assert esMesValido(mes) : "El mes no es valido";
        assert esDiaValido(dia, mes) : "El dia no es valido";
    
        this.dia = dia;
        this.mes = mes;
        this.anio = año;}
    
    public boolean equals(Fecha fecha){
        return dia == fecha.dia && mes == fecha.mes && anio == fecha.anio;
    }

    public boolean antesQue(Fecha fecha){
        if(anio < fecha.anio)
            return true;

        if(mes < fecha.mes)
            return true;

        if(dia < fecha.dia)
            return true;

        return false;
    }

    public boolean despuesQue(Fecha fecha){
        if(anio > fecha.anio)
            return true;
        if(mes > fecha.mes)
            return true;
        if(dia > fecha.dia)
            return true;
        return false;
    }

    public int compareTo(Fecha fecha){
        if(antesQue(fecha))
            return -1;
        if(despuesQue(fecha))
            return 1;
        return 0;
    }

    public Fecha siguiente(){
        return new Fecha (dia, mes, anio + 1);
    }

    public String toString(){
        return dia + "/" + mes + "/" + anio;
    }

    public boolean esMesValido(int mes){
        return mes >= 1 && mes <= 12;
    }

    public boolean esDiaValido(int dia, int mes){
        if(mes == 2){
            return dia >= 1 && dia <= 28;
        }
        if(mes != 2){
            return dia >= 1 && dia <= 30;
        }
        return true;
    }
}


