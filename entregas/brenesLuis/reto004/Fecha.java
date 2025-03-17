package entregas.brenesLuis.reto004;

public class Fecha {

    private int año;
    private int mes;
    private int dia;

    public Fecha(int año, int mes, int dia) {
        assert año > 0 : "El año no puede ser negativo";
        assert mes > 0 && mes < 13 : "El mes debe estar entre 1 y 12";
        assert dia > 0 && dia < 32 : "El día debe estar entre 1 y 31";
    }

    public boolean equals(Fecha fecha) {
        return this.año == fecha.año && this.mes == fecha.mes && this.dia == fecha.dia;
    }

    public boolean antesQue(Fecha fecha) {
        if (this.año < fecha.año) {
            return true;
        } else if (this.año == fecha.año) {
            if (this.mes < fecha.mes) {
                return true;
            } else if (this.mes == fecha.mes) {
                if (this.dia < fecha.dia) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean despuesDe(Fecha fecha) {
        return !this.antesQue(fecha) && !this.equals(fecha);
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

    public Fecha siguiente() {
        int nuevoDia = this.dia + 1;
        int nuevoMes = this.mes;
        int nuevoAño = this.año;
        if (nuevoDia > 31) {
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
        return this.año + "/" + this.mes + "/" + this.dia;
    }

    public boolean esMesValido(int mes) {
        return mes > 0 && mes < 13;
    }

    public boolean esDiaValido(int dia) {
        return dia > 0 && dia < 32;
    }
}
