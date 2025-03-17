package entregas.rivasMiguel.reto004;

public class Tiempo {
public static void main(String[] args) {
    Tiempo t1 = new Tiempo(22, 28, 57);
    Tiempo t2 = new Tiempo(23, 28, 57);
    Tiempo t3 = new Tiempo(22, 28, 57);

    System.out.println("Tiempo: " + t1);
    System.out.println("equals: " + t1.equals(t2));
    System.out.println("antesQue: " + t1.antesQue(t2));
    System.out.println("despuesDe: " + t1.despuesDe(t2));
    System.out.println("compareTo: " + t1.compareTo(t2));
    System.out.println("next: " + t1.next());
    System.out.println("sumar: " + t1.sumar(t2));
    System.out.println("Es hora valida: " + t1.esHoraValida(14));
    System.out.println("Es minuto valido: " + t1.esMinutoValido(60));
    System.out.println("Es segundo valido: " + t1.esSegundoValido(59));
}

    private int horas;
    private int minutos;
    private int segundos;

    public Tiempo(int horas, int minutos, int segundos) {
        if (!esHoraValida(horas)) {
            throw new IllegalArgumentException("Hora inválida");
        }
        if (!esMinutoValido(minutos)) {
            throw new IllegalArgumentException("Minuto inválido");
        }
        if (!esSegundoValido(segundos)) {
            throw new IllegalArgumentException("Segundo inválido");
        }
        this.horas = horas;
        this.minutos = minutos;
        this.segundos = segundos;
    }

    public boolean equals(Tiempo tiempo) {
        return this.horas == tiempo.horas && this.minutos == tiempo.minutos && this.segundos == tiempo.segundos;
    }

    public boolean antesQue(Tiempo tiempo) {
        if (this.horas < tiempo.horas) {
            return true;
        } else if (this.horas == tiempo.horas) {
            if (this.minutos < tiempo.minutos) {
                return true;
            } else if (this.minutos == tiempo.minutos) {
                return this.segundos < tiempo.segundos;
            }
        }
        return false;
    }

    public boolean despuesDe(Tiempo tiempo) {
        return !antesQue(tiempo) && !equals(tiempo);
    }

    public int compareTo(Tiempo tiempo) {
        if (antesQue(tiempo)) {
            return -1;
        } else if (equals(tiempo)) {
            return 0;
        } else {
            return 1;
        }
    }

    public Tiempo next() {
        int segundoSiguiente = segundos + 1;
        int minutoSiguiente = minutos;
        int horaSiguiente = horas;

        if (segundoSiguiente == 60) {
            segundoSiguiente = 0;
            minutoSiguiente++;
        }
        if (minutoSiguiente == 60) {
            minutoSiguiente = 0;
            horaSiguiente++;
        }
        if (horaSiguiente == 24) {
            horaSiguiente = 0;
        }

        return new Tiempo(horaSiguiente, minutoSiguiente, segundoSiguiente);
    }

    public String toString() {
        return String.format("%02d:%02d:%02d", horas, minutos, segundos);
    }

    public Tiempo sumar(Tiempo tiempo) {
        int totalSegundos = this.horas * 3600 + this.minutos * 60 + this.segundos + 
                            tiempo.horas * 3600 + tiempo.minutos * 60 + tiempo.segundos;

        int horasSumadas = totalSegundos / 3600;
        totalSegundos %= 3600;
        int minutosSumados = totalSegundos / 60;
        int segundosSumados = totalSegundos % 60;

        return new Tiempo(horasSumadas % 24, minutosSumados, segundosSumados);
    }

    public boolean esHoraValida(int hora) {
        return hora >= 0 && hora < 24;
    }

    public boolean esMinutoValido(int minuto) {
        return minuto >= 0 && minuto < 60;
    }

    public boolean esSegundoValido(int segundo) {
        return segundo >= 0 && segundo < 60;
    }
}
