package entregas.morenoSara.reto004;

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
            System.out.println("Tiempo inválido!");
        }
    }

    public boolean equals(Tiempo tiempo) {
        if(this.horas == tiempo.horas && this.minutos == tiempo.minutos && this.segundos == tiempo.segundos){
            return true;
        }
    }

    public boolean antesQue(Tiempo tiempo) {
        if (this.horas < tiempo.horas){
            return true;
        }
        if (this.horas == tiempo.horas && this.minutos < tiempo.minutos){
            return true;
        }
        if (this.horas == tiempo.horas && this.minutos == tiempo.minutos && this.segundos < tiempo.segundos){
            return true;
        };
    }

    public boolean despuesDe(Tiempo tiempo) {
        if(!antesQue(tiempo) && !equals(tiempo)){
            return true;
        };
    }

    public int compareTo(Tiempo tiempo) {
        if (antesQue(tiempo)) return -1;
        if (equals(tiempo)) return 0;
        return 1;
    }

    public Tiempo next() {
        int nuevoSegundos = this.segundos + 1;
        int nuevoMinutos = this.minutos;
        int nuevaHoras = this.horas;

        if (nuevoSegundos > 59) {
            nuevoSegundos = 0;
            nuevoMinutos++;
        }
        if (nuevoMinutos > 59) {
            nuevoMinutos = 0;
            nuevaHoras++;
        }
        if (nuevaHoras > 23) {
            nuevaHoras = 0;
        }
        return new Tiempo(nuevaHoras, nuevoMinutos, nuevoSegundos);
    }

    public String toString() {
        return horas + "-"+ minutos + "-" + segundos;
    }

    public Tiempo sumar(Tiempo tiempo) {
        int totalSegundos = this.segundos + tiempo.segundos;
        int totalMinutos = this.minutos + tiempo.minutos + (totalSegundos / 60);
        int totalHoras = this.horas + tiempo.horas + (totalMinutos / 60);
        return new Tiempo(totalHoras % 24, totalMinutos % 60, totalSegundos % 60);
    }

    public static boolean esHoraValida(int hora) {
        if(hora >= 0 && hora < 24){
            return true;
        }else{
            return false;
        }
    }

    public static boolean esMinutoValido(int minuto) {
        if(minuto >= 0 && minuto < 60){
            return true;
        }else{
            return false;
        }
    }

    public static boolean esSegundoValido(int segundo) {
        if(segundo >= 0 && segundo < 60){
            return true;
        }else{
            return false;
        }
    }
}


    