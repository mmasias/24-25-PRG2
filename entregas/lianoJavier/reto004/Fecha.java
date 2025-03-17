package entregas.lianoJavier.reto004;

public class Fecha {
    private int año, mes, dia;

    public Fecha(int año, int mes, int dia) {
        validarFecha(año, mes, dia);

        this.año = año;
        this.mes = mes;
        this.dia = dia;
    }

    private void validarFecha(int año, int mes, int dia) {
        assert año > 0 : "El año no puede ser negativo";
        assert esMesValido(mes) : "El mes debe estar entre 1 y 12";
        assert esDiaValido(dia) : "El día debe estar entre 1 y 31";
    }

    public boolean esMesValido(int mes) {
        return mes >= 1 && mes <= 12;
    }

    public boolean esDiaValido(int dia) {
        return dia >= 1 && dia <= 31;
    }

    public boolean equals(Fecha fecha) {
        return año == fecha.año && mes == fecha.mes && dia == fecha.dia;
    }

    public boolean antesQue(Fecha fecha) {
        if (año < fecha.año) return true;
        if (mes < fecha.mes) return true;
        if (dia < fecha.dia) return true;
        return false;
    }

    public boolean despuesQue(Fecha fecha) {
        if (año > fecha.año) return true;
        if (mes > fecha.mes) return true;
        if (dia > fecha.dia) return true;
        return false;
    }

    public int compareTo(Fecha fecha) {
        if (antesQue(fecha)) return -1;
        if (despuesQue(fecha)) return 1;
        return 0;
    }

    public Fecha siguiente() {
        return new Fecha(año, mes, dia + 1);
    }

    public String toString() {
        return año + "/" + mes + "/" + dia;
    }
}
