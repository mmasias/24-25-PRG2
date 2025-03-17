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
