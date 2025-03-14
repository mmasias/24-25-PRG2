public class Fecha {
    private int año, mes, dia;

    public Fecha(int año, int mes, int dia) {
        if (esMesValido(mes) && esDiaValido(dia)) {
            this.año = año;
            this.mes = mes;
            this.dia = dia;
        } else {
            this.año = 2000;
            this.mes = 1;
            this.dia = 1;
        }
    }