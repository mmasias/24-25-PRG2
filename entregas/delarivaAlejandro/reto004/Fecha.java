package entregas.delarivaAlejandro.reto004;

public class Fecha {
    private int año, mes, dia;

    public Fecha(int año, int mes, int dia) {
        if (!esMesValido(mes)) {
            throw new IllegalArgumentException("Mes no válido");
        }
        if (!esDiaValido(dia)) {
            throw new IllegalArgumentException("Día no válido");
        }

        this.año = año;
        this.mes = mes;
        this.dia = dia;
    }

    public boolean equals(Fecha otraFecha) {
        if (this == otraFecha) return true;
        if (otraFecha == null) return false;
        return this.año == otraFecha.año && this.mes == otraFecha.mes && this.dia == otraFecha.dia;
    }

    public boolean esAntesDe(Fecha otraFecha) {
        if (this.año != otraFecha.año) {
            return this.año < otraFecha.año;
        } else if (this.mes != otraFecha.mes) {
            return this.mes < otraFecha.mes;
        } else {
            return this.dia < otraFecha.dia;
        }
    }

    public boolean esDespuesDe(Fecha otraFecha) {
        return !equals(otraFecha) && !esAntesDe(otraFecha);
    }

    public int compararCon(Fecha otraFecha) {
        if (esAntesDe(otraFecha)) {
            return -1;
        } else if (equals(otraFecha)) {
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
