package entregas.calderonJimena.reto004;

public class Fecha {

    private int año;
    private int mes;
    private int dia;

    public Fecha(int año, int mes, int dia) {
        assert esMesValido(mes) : "El mes no es válido";
        assert esDiaValido(dia) : "El día no es válido";
        this.año = año;
        this.mes = mes;
        this.dia = dia;
    }

    public boolean equals(Fecha fecha) {
        return this.año == fecha.año && this.mes == fecha.mes && this.dia == fecha.dia;
    }

    public boolean antesQue (Fecha date) {
        if (this.año < date.año) {
            return true;
        } else if (this.año == date.año) {
            if (this.mes < date.mes) {
                return true;
            } else if (this.mes == date.mes) {
                return this.dia < date.dia;
            }
        }
        return false;
    }

    public boolean despuesQue (Fecha date) {
        return !this.antesQue(date) && !this.equals(date);
    }

    public int compareTo(Fecha fecha) {
        if (this.antesQue(fecha)) {
            return -1;
        } else if (this.equals(fecha)) {
            return 0;
        } else {
            return 1;
        }
    }

    public  Fecha siguiente() {
        int dia = this.dia;
        int mes = this.mes;
        int año = this.año;
        if (dia == 31) {
            dia = 1;
            if (mes == 12) {
                mes = 1;
                año++;
            } else {
                mes++;
            }
        } else {
            dia++;
        }
        return new Fecha(año, mes, dia);
    }

    public String toString() {
        return this.año + "/" + this.mes + "/" + this.dia;
    }   

    public boolean esMesValido(int mes) {
        return mes > 0 && mes < 13;
    }

    public boolean esDiaValido(int dia) {
        return dia > 0 && dia < 32;
    }
}
