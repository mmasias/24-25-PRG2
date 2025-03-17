package entregas.béjarGabriel;

public class Fecha {
    private int año;
    private int mes;
    private int dia;

    public Fecha(int año, int mes, int dia) {
        assert esFechaValida(año, mes, dia) : "Fecha no válida";
        this.año = año;
        this.mes = mes;
        this.dia = dia;
    }

    private boolean esFechaValida(int año, int mes, int dia) {
        return esMesValido(mes) && esDiaValido(dia, mes, año);
    }

    private boolean esMesValido(int mes) {
        return mes >= 1 && mes <= 12;
    }

    private boolean esDiaValido(int dia, int mes, int año) {
        if (dia < 1) return false;
        if (mes == 2) {
            return dia <= (esAñoBisiesto(año) ? 29 : 28);
        }
        return dia <= (mesTiene30Dias(mes) ? 30 : 31);
    }

    private boolean mesTiene30Dias(int mes) {
        return mes == 4 || mes == 6 || mes == 9 || mes == 11;
    }

    private boolean esAñoBisiesto(int año) {
        return (año % 4 == 0 && año % 100 != 0) || (año % 400 == 0);
    }

    public boolean equals(Fecha fecha) {
        return this.año == fecha.año && this.mes == fecha.mes && this.dia == fecha.dia;
    }

    public boolean antesQue(Fecha fecha) {
        return compareTo(fecha) < 0;
    }

    public boolean despuesDe(Fecha fecha) {
        return compareTo(fecha) > 0;
    }

    public int compareTo(Fecha fecha) {
        if (this.año != fecha.año) {
            return Integer.compare(this.año, fecha.año);
        }
        if (this.mes != fecha.mes) {
            return Integer.compare(this.mes, fecha.mes);
        }
        return Integer.compare(this.dia, fecha.dia);
    }

    public Fecha siguiente() {
        int nuevoDia = this.dia + 1;
        int nuevoMes = this.mes;
        int nuevoAño = this.año;

        if (!esDiaValido(nuevoDia, nuevoMes, nuevoAño)) {
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
}