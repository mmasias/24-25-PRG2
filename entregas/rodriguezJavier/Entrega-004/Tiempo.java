public class Tiempo {
    private static final int MINUTOS_HORA = 60;
    private static final int HORAS_DIA = 24;
    private static final int SEGUNDOS_MINUTO = 60;

    private int horas, minutos, segundos;

    public Tiempo(int horas, int minutos, int segundos) {
        assert validarHora(horas) && validarMinuto(minutos) && validarSegundo(segundos) : "Tiempo no válido";
        this.horas = horas;
        this.minutos = minutos;
        this.segundos = segundos;
    }

    public Tiempo siguienteSegundo() {
        int nuevoSegundos = segundos + 1;
        int nuevoMinutos = minutos;
        int nuevaHora = horas;
        if (nuevoSegundos == SEGUNDOS_MINUTO) {
            nuevoSegundos = 0;
            nuevoMinutos++;
            if (nuevoMinutos == MINUTOS_HORA) {
                nuevoMinutos = 0;
                nuevaHora++;
                if (nuevaHora == HORAS_DIA) {
                    nuevaHora = 0;
                }
            }
        }
        return new Tiempo(nuevaHora, nuevoMinutos, nuevoSegundos);
    }

    private boolean validarHora(int hora) {
        return hora >= 0 && hora < HORAS_DIA;
    }

    private boolean validarMinuto(int minuto) {
        return minuto >= 0 && minuto < MINUTOS_HORA;
    }

    private boolean validarSegundo(int segundo) {
        return segundo >= 0 && segundo < SEGUNDOS_MINUTO;
    }
}
