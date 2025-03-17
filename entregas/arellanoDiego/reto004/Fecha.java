package entregas.arellanoDiego.reto004;

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
            System.out.println("Fecha inválida, asignando fecha por defecto.");
            this.año = 2000;
            this.mes = 1;
            this.dia = 1;        }
    }

    public boolean igualQue(Fecha fecha) {
        return this.año == fecha.año && this.mes == fecha.mes && this.dia == fecha.dia;
    }

    public boolean antesQue(Fecha fecha) {
        if (this.año < fecha.año) return true;
        if (this.año == fecha.año && this.mes < fecha.mes) return true;
        return this.año == fecha.año && this.mes == fecha.mes && this.dia < fecha.dia;
    }

    public int compareTo(Fecha fecha) {
        if (this.igualQue(fecha)) return 0;
        return this.antesQue(fecha) ? -1 : 1;
    }

    public Fecha siguiente() {
        int nuevoDia = dia + 1;
        int nuevoMes = mes;
        int nuevoAño = año;

        if (!esDiaValido(nuevoDia, mes, año)) {
            nuevoDia = 1;
            nuevoMes++;
            if (!esMesValido(nuevoMes)) {
                nuevoMes = 1;
                nuevoAño++;
            }
        }

        return new Fecha(nuevoAño, nuevoMes, nuevoDia);
    }

    public String toString() {
        return String.format("%04d-%02d-%02d", año, mes, dia);
    }

    public static boolean esMesValido(int mes) {
        return mes >= 1 && mes <= 12;
    }

    public static boolean esDiaValido(int dia, int mes, int año) {
        int[] diasPorMes = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

        if (mes == 2 && esBisiesto(año)) {
            return dia >= 1 && dia <= 29;
        }

        return dia >= 1 && dia <= diasPorMes[mes - 1];
    }

    private static boolean esBisiesto(int año) {
        return (año % 4 == 0 && año % 100 != 0) || (año % 400 == 0);
    }
}
