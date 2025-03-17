package entregas.arceMarina.reto004;

public class Fecha {
    private int año;
    private int mes;
    private int dia;

    public Fecha(int año, int mes, int dia) {
        assert esMesValido(mes) && esDiaValido(dia, mes, año): "No es valida esa fecha";
        this.año = año;
        this.mes = mes;
        this.dia = dia;
    }
}
    