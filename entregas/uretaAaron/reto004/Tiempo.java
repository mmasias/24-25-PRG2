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

    private boolean esHoraValida(int hora) {
        return hora >= 0 && hora < 24;
    }

    private boolean esMinutoValido(int minuto) {
        return minuto >= 0 && minuto < 60;
    }

    private boolean esSegundoValido(int segundo) {
        return segundo >= 0 && segundo < 60;
    }


    public boolean equals(Tiempo tiempo) {
        return this.horas == tiempo.horas && this.minutos == tiempo.minutos && this.segundos == tiempo.segundos;
    }


    public boolean antesQue(Tiempo tiempo) {
        if (this.horas < tiempo.horas) return true;
        if (this.horas == tiempo.horas && this.minutos < tiempo.minutos) return true;
        if (this.horas == tiempo.horas && this.minutos == tiempo.minutos && this.segundos < tiempo.segundos)
            return true;
        return false;
    }


    public boolean despuesDe(Tiempo tiempo) {
        return !antesQue(tiempo) && !equals(tiempo);
    }

    
    public int compareTo(Tiempo tiempo) {
        if (antesQue(tiempo)) return -1;
        if (equals(tiempo)) return 0;
        return 1;
    }

   
    public Tiempo next() {
        int nuevoSegundo = this.segundos + 1;
        int nuevoMinuto = this.minutos;
        int nuevaHora = this.horas;

        if (nuevoSegundo >= 60) {
            nuevoSegundo = 0;
            nuevoMinuto++;
            if (nuevoMinuto >= 60) {
                nuevoMinuto = 0;
                nuevaHora++;
                if (nuevaHora >= 24) {
                    nuevaHora = 0; 
                }
            }
        }

        return new Tiempo(nuevaHora, nuevoMinuto, nuevoSegundo);
    }


    public Tiempo sumar(Tiempo tiempo) {
        int totalSegundos = this.segundos + tiempo.segundos;
        int totalMinutos = this.minutos + tiempo.minutos + totalSegundos / 60;
        int totalHoras = this.horas + tiempo.horas + totalMinutos / 60;

        totalSegundos %= 60;
        totalMinutos %= 60;
        totalHoras %= 24; 

        return new Tiempo(totalHoras, totalMinutos, totalSegundos);
    }

 
    @Override
    public String toString() {
        return String.format("%02d:%02d:%02d", horas, minutos, segundos);
    }

    public static void main(String[] args) {
        Tiempo tiempo1 = new Tiempo(23, 59, 59);
        Tiempo tiempo2 = new Tiempo(2, 30, 15);

        System.out.println("Tiempo 1: " + tiempo1);
        System.out.println("Tiempo 2: " + tiempo2);

        System.out.println("¿Tiempo1 es igual a Tiempo2? " + tiempo1.equals(tiempo2));
        System.out.println("¿Tiempo1 es antes que Tiempo2? " + tiempo1.antesQue(tiempo2));
        System.out.println("¿Tiempo1 es después de Tiempo2? " + tiempo1.despuesDe(tiempo2));

        System.out.println("Comparación de tiempos: " + tiempo1.compareTo(tiempo2));
        System.out.println("Segundo siguiente de Tiempo1: " + tiempo1.next());

        Tiempo suma = tiempo1.sumar(tiempo2);
        System.out.println("Suma de Tiempo1 y Tiempo2: " + suma);
    }
}
