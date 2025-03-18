package entregas.solarAdrian.reto004;

public class Fraccion {
    private int numerador;
    private int denominador;

    public Fraccion(int numerador, int denominador) {
        if (denominador == 0) {
            denominador = 1;
        }
        this.numerador = numerador;
        this.denominador = denominador;
    }

    public Fraccion(int numerador) {
        this(numerador, 1);
    }

    public Fraccion() {
        this(0, 1);
    }

    public Fraccion sumar(Fraccion fraccion) {
        int numeradorResultado = this.numerador * fraccion.denominador + fraccion.numerador * this.denominador;
        int denominadorResultado = this.denominador * fraccion.denominador;
        return new Fraccion(numeradorResultado, denominadorResultado);
    }

    public Fraccion sumar(int entero) {
        return sumar(new Fraccion(entero));
    }

    public Fraccion oponer() {
        return new Fraccion(-this.numerador, this.denominador);
    }

    public Fraccion restar(Fraccion fraccion) {
        int numeradorResultado = this.numerador * fraccion.denominador - fraccion.numerador * this.denominador;
        int denominadorResultado = this.denominador * fraccion.denominador;
        return new Fraccion(numeradorResultado, denominadorResultado);
    }

    public Fraccion restar(int entero) {
        return restar(new Fraccion(entero));
    }

    public Fraccion multiplicar(Fraccion fraccion) {
        int numeradorResultado = this.numerador * fraccion.numerador;
        int denominadorResultado = this.denominador * fraccion.denominador;
        return new Fraccion(numeradorResultado, denominadorResultado);
    }

    public Fraccion multiplicar(int entero) {
        return new Fraccion(this.numerador * entero, this.denominador);
    }

    public Fraccion invertir() {
        if (this.numerador == 0) {
            return new Fraccion(1, 0);
        }
        return new Fraccion(this.denominador, this.numerador);
    }

    public Fraccion dividir(Fraccion fraccion) {
        return multiplicar(fraccion.invertir());
    }

    public Fraccion dividir(int entero) {
        if (entero == 0) {
            return new Fraccion(0, 1);
        }
        return new Fraccion(this.numerador, this.denominador * entero);
    }

    public Fraccion elevar(int exponente) {
        int numeradorResultado = (int) Math.pow(this.numerador, exponente);
        int denominadorResultado = (int) Math.pow(this.denominador, exponente);
        return new Fraccion(numeradorResultado, denominadorResultado);
    }

    public int numerador() {
        return this.numerador;
    }

    public int denominador() {
        return this.denominador;
    }

    public boolean esMenor(Fraccion fraccion) {
        return this.compareTo(fraccion) < 0;
    }

    public boolean esMayor(Fraccion fraccion) {
        return this.compareTo(fraccion) > 0;
    }

    public boolean esIgual(Fraccion fraccion) {
        return this.compareTo(fraccion) == 0;
    }

    public double valueOf() {
        return (double) this.numerador / this.denominador;
    }

    public int compareTo(Fraccion fraccion) {
        int resultado1 = this.numerador * fraccion.denominador;
        int resultado2 = this.denominador * fraccion.numerador;
        if (resultado1 < resultado2) return -1;
        if (resultado1 > resultado2) return 1;
        return 0;
    }

    public String toString() {
        return this.numerador + "/" + this.denominador;
    }

    public Fraccion clone() {
        return new Fraccion(this.numerador, this.denominador);
    }
}

public class Fecha {
    private int anio, mes, dia;

    public Fecha(int anio, int mes, int dia) {
        if (!esMesValido(mes)) mes = 1;
        if (!esDiaValido(dia)) dia = 1;
        this.anio = anio;
        this.mes = mes;
        this.dia = dia;
    }

    public boolean equals(Fecha fecha) {
        return this.anio == fecha.anio && this.mes == fecha.mes && this.dia == fecha.dia;
    }

    public boolean antesQue(Fecha fecha) {
        return compareTo(fecha) < 0;
    }

    public boolean despuesDe(Fecha fecha) {
        return compareTo(fecha) > 0;
    }

    public int compareTo(Fecha fecha) {
        if (this.anio != fecha.anio) return Integer.compare(this.anio, fecha.anio);
        if (this.mes != fecha.mes) return Integer.compare(this.mes, fecha.mes);
        return Integer.compare(this.dia, fecha.dia);
    }

    public Fecha siguiente() {
        return new Fecha(anio, mes, dia + 1);
    }

    public String toString() {
        return anio + "-" + mes + "-" + dia;
    }

    public boolean esMesValido(int mes) {
        return mes >= 1 && mes <= 12;
    }

    public boolean esDiaValido(int dia) {
        return dia >= 1 && dia <= 30;
    }
}

public class Tiempo {
    private int horas, minutos, segundos;

    public Tiempo(int horas, int minutos, int segundos) {
        if (!esHoraValida(horas)) horas = 0;
        if (!esMinutoValido(minutos)) minutos = 0;
        if (!esSegundoValido(segundos)) segundos = 0;
        this.horas = horas;
        this.minutos = minutos;
        this.segundos = segundos;
    }

    public boolean equals(Tiempo tiempo) {
        return this.horas == tiempo.horas && this.minutos == tiempo.minutos && this.segundos == tiempo.segundos;
    }

    public boolean antesQue(Tiempo tiempo) {
        return compareTo(tiempo) < 0;
    }

    public boolean despuesDe(Tiempo tiempo) {
        return compareTo(tiempo) > 0;
    }

    public int compareTo(Tiempo tiempo) {
        if (this.horas != tiempo.horas) return Integer.compare(this.horas, tiempo.horas);
        if (this.minutos != tiempo.minutos) return Integer.compare(this.minutos, tiempo.minutos);
        return Integer.compare(this.segundos, tiempo.segundos);
    }
}
