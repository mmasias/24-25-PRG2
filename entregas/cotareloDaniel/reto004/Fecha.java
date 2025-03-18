package entregas.cotareloDaniel.reto004;

public class Fecha {
    private int año;
    private int mes;
    private int dia;

    public Fecha(int año, int mes, int dia) {
        assert (esMesValido(mes) && esDiaValido(dia)) : "Fecha no válida";

        this.año = año;
        this.mes = mes;
        this.dia = dia;
    }

    public boolean equals(Fecha fecha) {
        return this.año == fecha.año && this.mes == fecha.mes && this.dia == fecha.dia;
    }

    public boolean antesQue(Fecha date) {
        if (this.año < date.año)
            return true;
        if (this.año == date.año && this.mes < date.mes)
            return true;
        return this.año == date.año && this.mes == date.mes && this.dia < date.dia;
    }

    public boolean despuesDe(Fecha date) {
        if (this.año > date.año)
            return true;
        if (this.año == date.año && this.mes > date.mes)
            return true;
        return this.año == date.año && this.mes == date.mes && this.dia > date.dia;
    }

    public int compareTo(Fecha fecha) {
        if (this.antesQue(fecha))
            return -1;
        if (this.despuesDe(fecha))
            return 1;
        return 0;
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

    public String toString() {
        return año + "-" + (mes < 10 ? "0" + mes : mes) + "-" + (dia < 10 ? "0" + dia : dia);
    }

    private boolean esMesValido(int mes) {
        return mes >= 1 && mes <= 12;
    }

    private boolean esDiaValido(int dia) {
        return dia >= 1 && dia <= 30;
    }
}
