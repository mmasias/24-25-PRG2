package entregas.caicedoEsteban.reto004;

public class Fecha {
    private int dia;
    private int mes;
    private int año;

    public Fecha(int año, int mes, int dia) {
        assert esMesValido(mes) && esDiaValido(dia) : "No es valida esa fecha";

        this.año = año;
        this.mes = esMesValido(mes) ? mes : 1;
        this.dia = esDiaValido(dia) ? dia : 1;
    }

    public boolean equals(Fecha otraFecha) {
        return this.año == otraFecha.año && this.mes == otraFecha.mes && this.dia == otraFecha.dia;
    }

    public boolean antesQue(Fecha fecha) {
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

    public boolean despuesDe(Fecha date) {
        return !antesQue(date);
    }

    public int compareTo(Fecha date) {
        if (this.antesQue(date)) {
            return -1;
        } else if (this.equals(date)) {
            return 0;
        } else {
            return 1;
        }
    }

    public Fecha siguiente() {
        int dia = this.dia;
        int mes = this.mes;
        int año = this.año;

        if (esDiaValido(dia + 1)) {
            return new Fecha(año, mes, dia + 1);
        } else if (esMesValido(mes + 1)) {
            return new Fecha(año, mes + 1, 1);
        } else {
            return new Fecha(año + 1, 1, 1);
        }
    }

    public String toString() {
        return this.dia + "/" + this.mes + "/" + this.año;
    }

    public boolean esMesValido(int mes) {
        return mes >= 1 && mes <= 12;
    }

    public boolean esDiaValido(int dia) {
        return dia >= 1 && dia <= 31;
    }

}
