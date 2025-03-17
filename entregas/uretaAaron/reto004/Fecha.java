public class Fecha {

    private int año;
    private int mes;
    private int dia;

    public Fecha(int año, int mes, int dia) {
        if (esMesValido(mes) && esDiaValido(dia)) {
            this.año = año;
            this.mes = mes;
            this.dia = dia;
        } else {
            throw new IllegalArgumentException("Fecha inválida");
        }
    }