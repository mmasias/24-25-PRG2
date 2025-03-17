public class Fecha {
    private int dia, mes, anio;

    public Fecha(int anio, int mes, int dia) {
        if (!esMesValido(mes) || !esDiaValido(dia)) {
            throw new IllegalArgumentException("Fecha inválida");
        }
        this.anio = anio;
        this.mes = mes;
        this.dia = dia;
    }

    public boolean equals(Fecha f) {
        return anio == f.anio && mes == f.mes && dia == f.dia;
    }

    public boolean antesQue(Fecha f) {
        return compareTo(f) < 0;
    }

    public boolean despuesDe(Fecha f) {
        return compareTo(f) > 0;
    }

    public int compareTo(Fecha f) {
        return (anio != f.anio) ? anio - f.anio : (mes != f.mes) ? mes - f.mes : dia - f.dia;
    }

    public Fecha siguiente() {
        return new Fecha(anio, mes, dia % 30 + 1 + (dia == 30 ? (mes % 12 == 0 ? 1 : 0) : 0), mes % 12 + (dia == 30 ? 1 : 0));
    }

    public String toString() {
        return String.format("%04d-%02d-%02d", anio, mes, dia);
    }

    public static boolean esMesValido(int mes) {
        return mes >= 1 && mes <= 12;
    }

    public static boolean esDiaValido(int dia) {
        return dia >= 1 && dia <= 30;
    }
}
