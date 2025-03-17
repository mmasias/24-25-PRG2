package entregas.coboIsmael.reto004;

public class Fecha {
    private int año, mes, dia;

    public Fecha(int año, int mes, int dia) {
        assert esMesValido(mes) : "Mes no válido";
        assert esDiaValido(dia) : "Día no válido";
        
        this.año = año;
        this.mes = mes;
        this.dia = dia;
    }

    public boolean equals(Fecha fecha) {
        return this.año == fecha.año && this.mes == fecha.mes && this.dia == fecha.dia;
    }

    public boolean antesQue(Fecha fecha) {
        return (this.año < fecha.año) || (this.año == fecha.año && this.mes < fecha.mes) ||
               (this.año == fecha.año && this.mes == fecha.mes && this.dia < fecha.dia);
    }

    public boolean despuesDe(Fecha fecha) {
        return (this.año > fecha.año) || (this.año == fecha.año && this.mes > fecha.mes) ||
               (this.año == fecha.año && this.mes == fecha.mes && this.dia > fecha.dia);
    }

    public int compareTo(Fecha fecha) {
        if (antesQue(fecha)) {
            return -1;
        } else if (equals(fecha)) {
            return 0;
        } else {
            return 1;
        }
    }

    public Fecha siguiente() {
        int nuevoDia = this.dia + 1;
        int nuevoMes = this.mes;
        int nuevoAño = this.año;

        if (nuevoDia > 30) {
            nuevoDia = 1;
            nuevoMes++;
        }

        if (nuevoMes > 12) {
            nuevoMes = 1;
            nuevoAño++;
        }

        return new Fecha(nuevoAño, nuevoMes, nuevoDia);
    }

    public String toString() {
        return año + "-" + mes + "-" + dia;
    }

    public static boolean esMesValido(int mes) {
        return mes >= 1 && mes <= 12;
    }

    public static boolean esDiaValido(int dia) {
        return dia >= 1 && dia <= 30;
    }
}