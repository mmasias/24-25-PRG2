public class Fecha {

    private int año;
    private int mes;
    private int dia;

    public Fecha(int año, int mes, int dia) {
        if (esMesValido(mes) && esDiaValido(dia, mes, año)) {
            this.año = año;
            this.mes = mes;
            this.dia = dia;
        } else {
            throw new IllegalArgumentException("Fecha inválida");
        }
    }

    private boolean esMesValido(int mes) {
        return mes >= 1 && mes <= 12;
    }

    private boolean esDiaValido(int dia, int mes, int año) {
        int[] diasPorMes = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        if (mes == 2 && esBisiesto(año)) {
            diasPorMes[2] = 29;
        }

        return dia >= 1 && dia <= diasPorMes[mes];
    }

    private boolean esBisiesto(int año) {
        return (año % 4 == 0 && año % 100 != 0) || (año % 400 == 0);
    }

    public boolean equals(Fecha fecha) {
        return this.año == fecha.año && this.mes == fecha.mes && this.dia == fecha.dia;
    }

    public boolean antesQue(Fecha fecha) {
        if (this.año < fecha.año) return true;
        if (this.año == fecha.año && this.mes < fecha.mes) return true;
        if (this.año == fecha.año && this.mes == fecha.mes && this.dia < fecha.dia) return true;
        return false;
    }

    public boolean despuesDe(Fecha fecha) {
        return !antesQue(fecha) && !equals(fecha);
    }

    public int compareTo(Fecha fecha) {
        if (antesQue(fecha)) return -1;
        if (equals(fecha)) return 0;
        return 1;
    }

    public Fecha siguiente() {
        int nuevoDia = this.dia + 1;
        int nuevoMes = this.mes;
        int nuevoAño = this.año;

        int[] diasPorMes = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        if (nuevoMes == 2 && esBisiesto(nuevoAño)) {
            diasPorMes[2] = 29;
        }

        if (nuevoDia > diasPorMes[this.mes]) { 
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
        return año + "-" + (mes < 10 ? "0" + mes : mes) + "-" + (dia < 10 ? "0" + dia : dia);
    }

    public static void main(String[] args) {
        Fecha fecha1 = new Fecha(2025, 3, 17);
        Fecha fecha2 = new Fecha(2025, 3, 18);

        System.out.println("Fecha 1: " + fecha1);
        System.out.println("Fecha 2: " + fecha2);

        System.out.println("¿Fecha1 es igual a Fecha2? " + fecha1.equals(fecha2));
        System.out.println("¿Fecha1 es antes que Fecha2? " + fecha1.antesQue(fecha2));
        System.out.println("¿Fecha1 es después de Fecha2? " + fecha1.despuesDe(fecha2));

        System.out.println("Comparación de fechas: " + fecha1.compareTo(fecha2));
        System.out.println("Día siguiente de Fecha1: " + fecha1.siguiente());
    }
}
