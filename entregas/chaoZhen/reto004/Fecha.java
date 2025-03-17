package chaoZhen.reto004;

public class Fecha {

    private int año; 
    private int mes; 
    private int dia; 

    public Fecha(int año, int mes, int dia){
        assert esMesValido(mes) : "Los meses no pueden ser más de 12 ni menores de 1";
        assert esDiaValido(dia, mes, año) : "El día no es válido para el mes y año proporcionados";
        
        this.año = año;
        this.mes = mes;
        this.dia = dia;
    }

    public boolean equals(Fecha fecha){
        assert fecha != null : "Es nulo,valor invalido ";

        return this.año == fecha.año && 
        this.mes == fecha.mes && 
        this.dia==fecha.dia;

    }

    public boolean antesQue(Fecha fecha) {
        assert fecha != null : "Es nulo, valor inválido";

        if (this.año < fecha.año) {
            return true;
        } else if (this.año == fecha.año) {
            if (this.mes < fecha.mes) {
                return true;
            } else if (this.mes == fecha.mes) {
                return this.dia < fecha.dia;
            }
        }
        return false;
    }

    public boolean despuesDe(Fecha date){
       assert date != null : "La fecha no puede ser nula";

        return date.antesQue(this);
    }

    public boolean compareTo(Fecha date){
        assert date != null : "La fecha no puede ser nula";

        if (this.antesQue(date)) return -1;
        if (this.equals(date)) return 0;
        return 1;
    }

    public Fecha siguiente() {
        int nuevoDia = this.dia + 1;
        int nuevoMes = this.mes;
        int nuevoAño = this.año;

            if (nuevoDia > 30) {
            nuevoDia = 1;
            nuevoMes++;
            if (nuevoMes > 12) {
                nuevoMes = 1;
                nuevoAño++;
            }
        }

        return new Fecha(nuevoAño, nuevoMes, nuevoDia);
    
    }

   
    public boolean esMesValido(int mes) {
        return mes >= 1 && mes <= 12;
    }

    
    public boolean esDiaValido(int dia) {
        return dia >= 1 && dia <= 30;
    }

    
    
    public String toString() {
        return String.format("%04d-%02d-%02d", año, mes, dia);
    }
    

}