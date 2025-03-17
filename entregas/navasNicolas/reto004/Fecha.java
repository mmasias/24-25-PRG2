package entregas.navasNicolas.reto004;

public class Fecha {
    private int year;
    private int mes;
    private int dia;

    public Fecha(int year, int mes, int dia) {
        assert esMesValido(mes) || esDiaValido(dia) : "Fecha no válido";

        this.year = year;
        this.mes = mes;
        this.dia = dia;
    }

    public boolean equals(Fecha fecha) {
        return this.year == fecha.year && this.mes == fecha.mes && this.dia == fecha.dia;
    }

    public boolean antesQue(Fecha fecha) {
        return compareTo(fecha) < 0;
    }

    public boolean despuesDe(Fecha fecha) {
        return compareTo(fecha) > 0;
    }

    public int compareTo(Fecha fecha) {
        if ((this.year < fecha.year) || (this.year == fecha.year && this.mes < fecha.mes) ||
                (this.year == fecha.year && this.mes == fecha.mes && this.dia < fecha.dia)) {
            return -1;
        } else if ((this.year > fecha.year) || (this.year == fecha.year && this.mes > fecha.mes) ||
                (this.year == fecha.year && this.mes == fecha.mes && this.dia > fecha.dia)) {
            return 1;
        } else {
            return 0;
        }
    }

    public Fecha siguiente() {
        int nuevoDia = dia + 1;
        int nuevoMes = mes;
        int nuevoyear = year;

        if (nuevoDia > 30) {
            nuevoDia = 1;
            nuevoMes++;
            if (nuevoMes > 12) {
                nuevoMes = 1;
                nuevoyear++;
            }
        }
        return new Fecha(nuevoyear, nuevoMes, nuevoDia);
    }

    public String toString() {
        return year + "-" + mes + "-" + dia;
    }

    public boolean esMesValido(int mes) {
        return mes >= 1 && mes <= 12;
    }

    public boolean esDiaValido(int dia) {
        return dia >= 1 && dia <= 30;
    }

}