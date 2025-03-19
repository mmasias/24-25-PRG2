public class Fecha {
    private int año;
    private int mes;
    private int dia;

    public Fecha(int año, int mes, int dia) {
        assert esMesValido(mes) && esDiaValido(año, mes, dia) : "No es valida esa fecha";

        this.año = año;
        this.mes = esMesValido(mes) ? mes : 1;
        this.dia = esDiaValido(año, mes, dia) ? dia : 1;

    }

    public boolean equals(Fecha fecha) {
        return this.año == fecha.año && this.mes == fecha.mes && this.dia == fecha.dia;
    }

    public boolean antesQue(Fecha fecha) {
        if (this.año < fecha.año)
            return true;
        else if (this.año == fecha.año && this.mes < fecha.mes)
            return true;
        else if (this.año == fecha.año && this.mes == fecha.mes && this.dia < fecha.dia)
            return true;
        else
            return false;
    }

    public boolean despuesDe(Fecha fecha) {
        return !antesQue(fecha) && !equals(fecha);
    }

    public int compareTo(Fecha fecha) {
        return equals(fecha) ? 0 : (this.despuesDe(fecha) ? 1 : -1);
    }

    public Fecha siguiente() {
        int diaNuevo = this.dia + 1;
        int mesNuevo = this.mes;
        int añoNuevo = this.año;

        if (!esDiaValido(añoNuevo, mesNuevo , diaNuevo)) {
            diaNuevo = 1;
            mesNuevo++;
            if (!esMesValido(mesNuevo)) {
                mesNuevo = 1;
                añoNuevo++;
            }
        }
        return new Fecha(diaNuevo, mesNuevo, añoNuevo);
    }

    public String toString() {
        return dia + "/" + mes + "/" + año;
    }

    public boolean esMesValido(int mes) {
        return mes >= 1 && mes <= 12;
    }

    private boolean esBisiesto(int año) {
        return año % 4 == 0 && año % 100 != 0 || año % 400 == 0;
    }

    public boolean esDiaValido(int año, int mes, int dia) {
        int diasMes;
        if (mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12) {
            diasMes = 31;
        } else if (mes == 2) {
            diasMes = esBisiesto(año) ? 29 : 28;
        } else {
            diasMes = 30;
        }

        return dia >= 1 && dia <= diasMes;
    }
}