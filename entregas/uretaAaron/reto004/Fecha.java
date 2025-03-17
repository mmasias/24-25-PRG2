
public class Fecha {

    private int año;
    private int mes;
    private int dia;

    public Fecha(int año, int mes, int dia) {
        if (esMesValido(mes) && esDiaValido(dia)) {
            this.año = año;
            this.mes = mes;
            this.dia = dia;
        } else {
            throw new IllegalArgumentException("Fecha inválida");
        }
    }
    private boolean esMesValido(int mes) {
        return mes  >= 1 && mes <= 12;
    }
   private boolean esDiaValido (int dia)
   return dia >= 1 && mes <= 30;
    }
    public boolean equals(Fecha fecha) {
        return this.año == fecha.año && this.mes == fecha.mes && this.dia == fecha.dia;
    }
    public boolean antesQue(Fecha fecha) {
        if (this.año < fecha.año) return true;
        if (this.año == fecha.año && this.mes < fecha.mes) return true;
        if (this.año == fecha.año && this.mes == fecha.mes && this.dia < fecha.dia) return true;
        return false;
    }
     public boolean despuesDe (Fecha fecha) {
    return !antesQue (fecha) && !equals(fecha);
}

public int compareTo(Fecha fecha) {
    if (antesQue(fecha)) return -1;
    if (equals(fecha)) return 0;
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

