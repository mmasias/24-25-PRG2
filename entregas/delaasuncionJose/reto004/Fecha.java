package entregas.delaasuncionJose.reto004;

public class Fecha {
    private int año;
    private int mes;
    private int dia;

    public Fecha(int año, int mes, int dia) {
        assert fechaInvalida(año, mes, dia) : "Fecha invalida, introduzca una fecha valida.";
    }

    private boolean fechaInvalida(int año, int mes, int dia) {
        
    }
}
