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

    public boolean equals(Fecha fecha) {
        return this.año == fecha.año && this.mes == fecha.mes && this.dia == fecha.dia;
    }

    public boolean antesQue(Fecha fecha) {
        if (this.año < fecha.año) return true;
        if (this.año == fecha.año && this.mes < fecha.mes) return true;
        return this.año == fecha.año && this.mes == fecha.mes && this.dia < fecha.dia;
    }

    public boolean despuesDe(Fecha fecha) {
        return !antesQue(fecha) && !equals(fecha);
    }

    public int compareTo(Fecha fecha) {
        if (equals(fecha)) return 0;
        return antesQue(fecha) ? -1 : 1;
    }

    public Fecha siguiente() {
        int nuevoDia = this.dia + 1;
        int nuevoMes = this.mes;
        int nuevoAño = this.año;

        if (!esDiaValido(nuevoDia)) {
            nuevoDia = 1;
            nuevoMes++;
            if (!esMesValido(nuevoMes)) {
                nuevoMes = 1;
                nuevoAño++;
            }
        }
        return new Fecha(nuevoAño, nuevoMes, nuevoDia);
    }

    @Override
    public String toString() {
        return this.año + "-" + this.mes + "-" + this.dia;
    }

    private boolean esMesValido(int mes) {
        return mes >= 1 && mes <= 12;
    }

    private boolean esDiaValido(int dia) {

        return dia >= 1 && dia <= 30;
    }
}

public class Tiempo {
    private int horas;
    private int minutos;
    private int segundos;

    public Tiempo(int horas, int minutos, int segundos) {
        if (esHoraValida(horas) && esMinutoValido(minutos) && esSegundoValido(segundos)) {
            this.horas = horas;
            this.minutos = minutos;
            this.segundos = segundos;
        } else {
            throw new IllegalArgumentException("Tiempo inválido");
        }
    }

    public boolean equals(Tiempo tiempo) {
        return this.horas == tiempo.horas && this.minutos == tiempo.minutos && this.segundos == tiempo.segundos;
    }

    public boolean antesQue(Tiempo tiempo) {
        if (this.horas < tiempo.horas) return true;
        if (this.horas == tiempo.horas && this.minutos < tiempo.minutos) return true;
        return this.horas == tiempo.horas && this.minutos == tiempo.minutos && this.segundos < tiempo.segundos;
    }

    public boolean despuesDe(Tiempo tiempo) {
        return !antesQue(tiempo) && !equals(tiempo);
    }

    public int compareTo(Tiempo tiempo) {
        if (equals(tiempo)) return 0;
        return antesQue(tiempo) ? -1 : 1;
    }

    public Tiempo next() {
        int nuevoSegundos = this.segundos + 1;
        int nuevoMinutos = this.minutos;
        int nuevasHoras = this.horas;

        if (!esSegundoValido(nuevoSegundos)) {
            nuevoSegundos = 0;
            nuevoMinutos++;
            if (!esMinutoValido(nuevoMinutos)) {
                nuevoMinutos = 0;
                nuevasHoras++;
                if (!esHoraValida(nuevasHoras)) {
                    nuevasHoras = 0;
                }
            }
        }
        return new Tiempo(nuevasHoras, nuevoMinutos, nuevoSegundos);
    }

    public String toString() {
        return this.horas + ":" + this.minutos + ":" + this.segundos;
    }

    public Tiempo sumar(Tiempo tiempo) {
        int totalSegundos = this.segundos + tiempo.segundos;
        int totalMinutos = this.minutos + tiempo.minutos + totalSegundos / 60;
        int totalHoras = this.horas + tiempo.horas + totalMinutos / 60;

        return new Tiempo(totalHoras % 24, totalMinutos % 60, totalSegundos % 60);
    }

    private boolean esHoraValida(int hora) {
        return hora >= 0 && hora <= 24;
    }

    private boolean esMinutoValido(int minuto) {
        return minuto >= 0 && minuto <= 60;
    }

    private boolean esSegundoValido(int segundo) {
        return segundo >= 0 && segundo <= 60;
    }
}
