package entregas.morenoSara.reto004;

public class Fecha {
    private int año;
    private int mes;
    private int dia;

    public Fecha(int año, int mes, int dia) {
        if (esAñoValido(año) && esMesValido(mes) && esDiaValido(dia) ) {
            this.año = año;
            this.mes = mes;
            this.dia = dia;
        } else{
            System.out.println("Fecha inválida!");
        }
    }

    public boolean equals(Fecha fecha) {
        if(this.año == fecha.año && this.mes == fecha.mes && this.dia == fecha.dia){
            return true;
        }
    }

    public boolean antesQue(Fecha fecha) {
        if (this.año < fecha.año || this.año == fecha.año && this.mes < fecha.mes ){
            return true;
        }
        if (this.año == fecha.año && this.mes < fecha.mes){
            return true;
        }
        if (this.año == fecha.año && this.mes == fecha.mes && this.dia < fecha.dia){
            return true;
        }
    }

    public boolean despuesDe(Fecha fecha) {
        if(!antesQue(fecha) && !equals(fecha)){
            return true;
        }
    }

    public int compareTo(Fecha fecha) {
        if (antesQue(fecha)) return -1;
        if (despuesQue(fecha)) return 1;
        return 0;
    }

    public Fecha siguiente() {
        int nuevoDia = this.dia + 1;
        int nuevoMes = this.mes;
        int nuevoAño = this.año;
        
        if (nuevoDia > 30) { 
            nuevoDia = 1;
            nuevoMes++;
        }
        if (nuevoMes > 12) {
            nuevoMes = 1;
            nuevoAño++;
        }
        
        return new Fecha(nuevoAño, nuevoMes, nuevoDia);
    }

    public String toString() {
        return año + "-" + mes + "-" + dia;
    }

    public static boolean esAñoValido(int año) {
        if(año > 0){
            return true;
        }else{
            return false;
        }
    }

    public static boolean esMesValido(int mes) {
        if(mes >= 1 && mes <= 12){
            return true;
        }else{
            return false;
        }
    }

    public static boolean esDiaValido(int dia) {
        if(dia >= 1 && dia <= 31){
            return true;
        }else{
            return false;
        }
    }
}