package entregas.GomezMiguel;

class Tiempo {
    private int hora;
    private int minuto;
    private int segundo;

    public Tiempo(int hora, int minuto, int segundo) {
        if (!esHoraValida(hora) || !esMinutoValido(minuto) || !esSegundoValido(segundo)) {
            throw new IllegalArgumentException("No es válido este Tiempo");
        }
        this.hora = hora;
        this.minuto = minuto;
        this.segundo = segundo;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Tiempo)) return false;
        Tiempo tiempo = (Tiempo) obj;
        return hora == tiempo.hora && minuto == tiempo.minuto && segundo == tiempo.segundo;
    }

    @Override
    public int hashCode() {
        return 31 * hora + 31 * minuto + segundo;
    }

    public boolean antesQue(Tiempo tiempo) {
        return (hora < tiempo.hora) || (hora == tiempo.hora && (minuto < tiempo.minuto || (minuto == tiempo.minuto && segundo < tiempo.segundo)));
    }

    public boolean despuesDe(Tiempo tiempo) {
        return !antesQue(tiempo) && !equals(tiempo);
    }

    public int compareTo(Tiempo tiempo) {
        return this.antesQue(tiempo) ? -1 : (this.equals(tiempo) ? 0 : 1);
    }

    public Tiempo next() {
        int segundoNuevo = segundo + 1;
        int minutoNuevo = minuto;
        int horaNueva = hora;

        if (segundoNuevo >= 60) {
            segundoNuevo = 0;
            minutoNuevo++;
        }
        if (minutoNuevo >= 60) {
            minutoNuevo = 0;
            horaNueva++;
        }
        if (horaNueva >= 24) {
            horaNueva = 0;
        }

        return new Tiempo(horaNueva, minutoNuevo, segundoNuevo);
    }

    @Override
    public String toString() {
        return String.format("%02d:%02d:%02d", hora, minuto, segundo);
    }

    private boolean esHoraValida(int hora) {
        return hora >= 0 && hora < 24;
    }

    private boolean esMinutoValido(int minuto) {
        return minuto >= 0 && minuto < 60;
    }

    private boolean esSegundoValido(int segundo) {
        return segundo >= 0 && segundo < 60;
    }

    public Tiempo sumar(Tiempo tiempo) {
        int sumaSegundos = segundo + tiempo.segundo;
        int sumaMinutos = minuto + tiempo.minuto + sumaSegundos / 60;
        int sumaHoras = hora + tiempo.hora + sumaMinutos / 60;

        return new Tiempo(sumaHoras % 24, sumaMinutos % 60, sumaSegundos % 60);
    }
}
