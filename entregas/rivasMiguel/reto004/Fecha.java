package entregas.rivasMiguel.reto004;

public class Fecha {
public static void main(String[] args) {
    Fecha f1 = new Fecha(2025, 3, 17);
    Fecha f2 = new Fecha(2025, 3, 18);
    Fecha f3 = new Fecha(2025, 3, 17);

    System.out.println("Fecha: " + f1);
    System.out.println("equals: " + f1.equals(f2));
    System.out.println("antesQue: " + f1.antesQue(f2));
    System.out.println("despuesDe: " + f1.despuesDe(f2));
    System.out.println("compareTo: " + f1.compareTo(f2));
    System.out.println("siguiente: " + f1.siguiente());
    System.out.println("Es mes valido (3): " + f1.esMesValido(3));
    System.out.println("Es dia valido (17, 3, 2025): " + f1.esDiaValido(17, 3, 2025));
    System.out.println("Es dia valido (32, 3, 2025): " + f1.esDiaValido(32, 3, 2025));

    System.out.println("equals f1 y f3: " + f1.equals(f3));
}
    private int año;
    private int mes;
    private int dia;

    public Fecha(int año, int mes, int dia) {
        if (!esMesValido(mes)) {
            throw new IllegalArgumentException("Mes inválido");
        }
        if (!esDiaValido(dia, mes, año)) {
            throw new IllegalArgumentException("Día inválido");
        }
        this.año = año;
        this.mes = mes;
        this.dia = dia;
    }

    public boolean equals(Fecha fecha) {
        return this.año == fecha.año && this.mes == fecha.mes && this.dia == fecha.dia;
    }

    public boolean antesQue(Fecha fecha) {
        if (this.año < fecha.año) {
            return true;
        } else if (this.año == fecha.año) {
            if (this.mes < fecha.mes) {
                return true;
            } else if (this.mes == fecha.mes) {
                return this.dia < fecha.dia;
            }
        }
        return false;
    }

    public boolean despuesDe(Fecha fecha) {
        return !antesQue(fecha) && !equals(fecha);
    }

    public int compareTo(Fecha fecha) {
        if (antesQue(fecha)) {
            return -1;
        } else if (equals(fecha)) {
            return 0;
        } else {
            return 1;
        }
    }

    public Fecha siguiente() {
        int diaSiguiente = dia + 1;
        int mesSiguiente = mes;
        int añoSiguiente = año;

        if (mes == 2) {
            if ((esBisiesto() && diaSiguiente > 29) || (!esBisiesto() && diaSiguiente > 28)) {
                diaSiguiente = 1;
                mesSiguiente++;
            }
        } else if ((mes == 4 || mes == 6 || mes == 9 || mes == 11) && diaSiguiente > 30) {
            diaSiguiente = 1;
            mesSiguiente++;
        } else if (diaSiguiente > 31) {
            diaSiguiente = 1;
            mesSiguiente++;
        }

        if (mesSiguiente > 12) {
            mesSiguiente = 1;
            añoSiguiente++;
        }

        return new Fecha(añoSiguiente, mesSiguiente, diaSiguiente);
    }

    public String toString() {
        return dia + "/" + mes + "/" + año;
    }

    public boolean esMesValido(int mes) {
        return mes >= 1 && mes <= 12;
    }

    public boolean esDiaValido(int dia, int mes, int año) {
        if (dia < 1) {
            return false;
        }

        if (mes == 2) {
            if (esBisiesto()) {
                return dia <= 29;
            } else {
                return dia <= 28;
            }
        } else if (mes == 4 || mes == 6 || mes == 9 || mes == 11) {
            return dia <= 30;
        } else {
            return dia <= 31;
        }
    }

    private boolean esBisiesto() {
        return (año % 4 == 0 && (año % 100 != 0 || año % 400 == 0));
    }
}
