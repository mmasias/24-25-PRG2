package entregas.puenteSergio.reto004;


public class Fecha {

    private int año;
    private int mes;
    private int dia;

    public Fecha(int año, int mes, int dia) {
        if (!esFechaValida(año, mes, dia)) {
            throw new IllegalArgumentException("Fecha no válida");
        }
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
        int[] diasPorMes = { 31, esBisiesto(año) ? 29 : 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        return dia >= 1 && dia <= diasPorMes[mes - 1];
    }

    private boolean esBisiesto(int año) {
        return (año % 4 == 0 && añp % 100 != 0) || (año % 400 == 0);
    }

    public boolean esIgualA(Fecha otraFecha) {
        return this.año == otraFecha.año && this.mes == otraFecha.mes && this.dia == otraFecha.dia;
    }

    public boolean esAnteriorA(Fecha otraFecha) {
        return this.compareTo(otraFecha) < 0;
    }

    public boolean esPosteriorA(Fecha otraFecha) {
        return this.compareTo(otraFecha) > 0;
    }

    public int compareTo(Fecha otraFecha) {
        if (this.año != otraFecha.año) {
            return Integer.compare(this.año, otraFecha.año);
        }
        if (this.mes != otraFecha.mes) {
            return Integer.compare(this.mes, otraFecha.mes);
        }
        return Integer.compare(this.dia, otraFecha.dia);
    }

    public Fecha obtenerSiguiente() {
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

    @Override
    public String toString() {
        return String.format("%04d/%02d/%02d", año, mes, dia);
    }
}
