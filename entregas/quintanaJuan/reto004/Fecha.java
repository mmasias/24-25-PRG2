package entregas.quintanaJuan.reto004;

public class Fecha {
    private int año;
    private int mes;
    private int dia;

    public Fecha(int año, int mes, int dia) {
        if (!esMesValido(mes) || !esDiaValido(dia)) {
            throw new IllegalArgumentException("Fecha invalida");
        }
        this.año = año;
        this.mes = mes;
        this.dia = dia;
    }

    public boolean equals(Fecha fecha) {
        return this.año == fecha.año && this.mes == fecha.mes && this.dia == fecha.dia;
    }

    public boolean antesQue(Fecha fecha) {
        return this.compareTo(fecha) < 0;
    }

    public boolean despuesDe(Fecha fecha) {
        return this.compareTo(fecha) > 0;
    }

    public int compareTo(Fecha fecha) {
        if (this.año != fecha.año) {
            return this.año - fecha.año;
        } else if (this.mes != fecha.mes) {
            return this.mes - fecha.mes;
        } else {
            return this.dia - fecha.dia;
        }
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
        return String.format("%04d-%02d-%02d", año, mes, dia);
    }

    private boolean esMesValido(int mes) {
        return mes >= 1 && mes <= 12;
    }

    private boolean esDiaValido(int dia) {
        return dia >= 1 && dia <= 30;
    }
}