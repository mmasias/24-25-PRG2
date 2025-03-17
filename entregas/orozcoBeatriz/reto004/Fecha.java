package entregas.orozcoBeatriz.reto004;

public class Fecha {

    private int anio;
    private int mes;
    private int dia;

    public Fecha(int anio, int mes, int dia) {
        this.anio = anio;
        this.mes = mes;
        this.dia = dia;
    }

    public boolean equals(Fecha fecha) {
        return this.anio == fecha.anio && this.mes == fecha.mes && this.dia == fecha.dia;
    }

    public boolean antesQue(Fecha fecha) {
        return compareTo(fecha) < 0;
    }

    public boolean despuesDe(Fecha fecha) {
        return compareTo(fecha) > 0;
    }

    public int compareTo(Fecha fecha) {
        if ((this.anio < fecha.anio) || (this.anio == fecha.anio && this.mes < fecha.mes) || (this.anio == fecha.anio && this.mes == fecha.mes && this.dia < fecha.dia)) {
            return -1;
        } else if ((this.anio > fecha.anio) || (this.anio == fecha.anio && this.mes > fecha.mes) || (this.anio == fecha.anio && this.mes == fecha.mes && this.dia > fecha.dia)) {
            return 1;
        } else {
            return 0;
        }
    }

    public Fecha siguiente() {
        int nuevoDia = dia + 1;
        int nuevoMes = mes;
        int nuevoAnio = anio;

        if (nuevoDia > 30) {
            nuevoDia = 1;
            nuevoMes++;
            if (nuevoMes > 12) {
                nuevoMes = 1;
                nuevoAnio++;
            }
        }
        return new Fecha(nuevoAnio, nuevoMes, nuevoDia);
    }

    public String toString() {
        return anio + "-" + mes + "-" + dia;
    }

    public boolean esMesValido(int mes) {
        return mes >= 1 && mes <= 12;
    }

    public boolean esDiaValido(int dia) {
        return dia >= 1 && dia <= 30;
    }

}