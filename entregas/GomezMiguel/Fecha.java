package entregas.GomezMiguel;

class Fecha {
    private int año;
    private int mes;
    private int dia;

    public Fecha(int año, int mes, int dia) {
        if (!esMesValido(mes)) throw new IllegalArgumentException("Mes no válido: " + mes);
        if (!esDiaValido(dia, mes, año)) throw new IllegalArgumentException("Día no válido: " + dia + " para el mes: " + mes + " y año: " + año);

        this.año = año;
        this.mes = mes;
        this.dia = dia;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Fecha)) return false;
        Fecha fecha = (Fecha) obj;
        return año == fecha.año && mes == fecha.mes && dia == fecha.dia;
    }

    @Override
    public int hashCode() {
        return 31 * año + 31 * mes + dia;
    }

    public boolean antesQue(Fecha fecha) {
        return (año < fecha.año) || (año == fecha.año && (mes < fecha.mes || (mes == fecha.mes && dia < fecha.dia)));
    }

    public boolean despuesDe(Fecha fecha) {
        return !antesQue(fecha) && !equals(fecha);
    }

    public int compareTo(Fecha fecha) {
        return this.antesQue(fecha) ? -1 : (this.equals(fecha) ? 0 : 1);
    }

    public Fecha siguiente() {
        int diaNuevo = dia + 1;
        int mesNuevo = mes;
        int añoNuevo = año;

        if (!esDiaValido(diaNuevo, mesNuevo, añoNuevo)) {
            diaNuevo = 1;
            mesNuevo++;
            if (!esMesValido(mesNuevo)) {
                mesNuevo = 1;
                añoNuevo++;
            }
        }
        return new Fecha(añoNuevo, mesNuevo, diaNuevo);
    }

    @Override
    public String toString() {
        return String.format("%02d/%02d/%d", dia, mes, año);
    }

    private boolean esMesValido(int mes) {
        return mes >= 1 && mes <= 12;
    }

    private boolean esDiaValido(int dia, int mes, int año) {
        if (dia < 1 || dia > 31) return false;
        if (mes == 2) return dia <= (esBisiesto(año) ? 29 : 28);
        if (mes == 4 || mes == 6 || mes == 9 || mes == 11) return dia <= 30;
        return true;
    }

    private boolean esBisiesto(int año) {
        return (año % 4 == 0 && año % 100 != 0) || (año % 400 == 0);
    }
}