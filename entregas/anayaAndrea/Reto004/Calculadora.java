package entregas.anayaAndrea.reto004;

public class Fraccion {

    private int numerador;
    private int denominador;

    public Fraccion(int numerador, int denominador) {
        assert denominador != 0 : "El denominador no puede ser CERO!";
        if (denominador < 0) {
            numerador = -numerador;
            denominador = -denominador;
        }

        int mcd = mcd(Math.abs(numerador), denominador);
        this.numerador = numerador / mcd;
        this.denominador = denominador / mcd;
    }

    private int mcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public Fraccion sumar(Fraccion fraccion) {
        int nuevoNumerador = this.numerador * fraccion.denominador + fraccion.numerador * this.denominador;
        int nuevoDenominador = this.denominador * fraccion.denominador;
        return new Fraccion(nuevoNumerador, nuevoDenominador);
    }

    public Fraccion sumar(int entero) {
        return sumar(new Fraccion(entero, 1));
    }

    public Fraccion oponer() {
        return new Fraccion(-numerador, denominador);
    }

    public Fraccion restar(Fraccion fraccion) {
        return sumar(fraccion.oponer());
    }

    public Fraccion restar(int entero) {
        return restar(new Fraccion(entero, 1));
    }

    public Fraccion multiplicar(Fraccion fraccion) {
        int nuevoNumerador = this.numerador * fraccion.numerador;
        int nuevoDenominador = this.denominador * fraccion.denominador;
        return new Fraccion(nuevoNumerador, nuevoDenominador);
    }

    public Fraccion multiplicar(int entero) {
        return multiplicar(new Fraccion(entero, 1));
    }

    public Fraccion invertir() {
        assert numerador != 0 : "No se puede invertir una fracción con numerador 0";
        return new Fraccion(denominador, numerador);
    }

    public Fraccion dividir(Fraccion fraccion) {
        return multiplicar(fraccion.invertir());
    }

    public Fraccion dividir(int entero) {
        return dividir(new Fraccion(entero, 1));
    }

    public Fraccion elevar(int exponente) {
        return new Fraccion((int) Math.pow(numerador, exponente), (int) Math.pow(denominador, exponente));
    }

    public int numerador() {
        return numerador;
    }

    public int denominador() {
        return denominador;
    }

    public boolean esMenor(Fraccion fraccion) {
        return this.numerador * fraccion.denominador < fraccion.numerador * this.denominador;
    }

    public boolean esMayor(Fraccion fraccion) {
        return this.numerador * fraccion.denominador > fraccion.numerador * this.denominador;
    }

    public boolean esIgual(Fraccion fraccion) {
        return this.numerador * fraccion.denominador == fraccion.numerador * this.denominador;
    }

    public double valueOf() {
        return (double) numerador / denominador;
    }

    public int compareTo(Fraccion fraccion) {
        if (esIgual(fraccion)) {
            return 0;
        } else if (esMayor(fraccion)) {
            return 1;
        } else {
            return -1;
        }
    }

    public String toString() {
        if (denominador == 1) {
            return "" + numerador;
        } else {
            return numerador + "\n-\n" + denominador;
        }
    }

    public Fraccion clone() {
        return new Fraccion(numerador, denominador);
    }
}

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
