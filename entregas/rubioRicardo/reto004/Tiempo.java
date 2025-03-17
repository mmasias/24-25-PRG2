package entregas.rubioRicardo.reto004;

class Tiempo {
    private int hora;
    private int minuto;
    private int segundo;

    public Tiempo(int hora, int minuto, int segundo){
        assert esHoraValida(hora) && esMinutoValido(minuto) && esSegundoValido(segundo): "No es valido este Tiempo";

        this.hora = esHoraValida(hora) ? hora : 0;
        this.minuto = esMinutoValido(minuto) ? minuto : 1;
        this.segundo = esSegundoValido(segundo) ? segundo : 1;
    }

    public boolean equals(Tiempo tiempo){
        return this.hora == tiempo.hora && this.minuto == tiempo.minuto && this.segundo == tiempo.segundo;
    }

    public boolean antesQue(Tiempo tiempo){
        if (this.hora < tiempo.hora) return true;
        else if (this.hora == tiempo.hora && this.minuto < tiempo.minuto) return true;
        else if (this.hora == tiempo.hora && this.minuto == tiempo.minuto && this.segundo < tiempo.segundo) return true; 
        else return false;
    }

    public boolean despuesDe(Tiempo tiempo){
        return !antesQue(tiempo) && !equals(tiempo);
    }

    public int compareTo(Tiempo tiempo){
        return equals(tiempo) ? 0 : (this.despuesDe(tiempo) ? 1 : -1);
    }

    public Tiempo next() {
        int horaNueva = this.hora;
        int minutoNuevo = this.minuto;
        int segundoNuevo = this.segundo + 1;


        if (segundoNuevo > 59) {
            segundoNuevo = 0;
            minutoNuevo++;
        }else if (minutoNuevo > 59) {
            minutoNuevo = 0;
            horaNueva++;
        }else if (horaNueva > 23) {
            horaNueva = 0;
        }

        return new Tiempo(horaNueva, minutoNuevo, segundoNuevo);
    }

    public String toString() {
        return hora+":"+minuto+":"+segundo;
    }

    public Tiempo sumar(Tiempo tiempo) {
        int sumaSegundos = this.segundo + tiempo.segundo;
        int sumaMinutos = this.minuto + tiempo.minuto + (sumaSegundos / 60);
        int sumaHoras = this.hora + tiempo.hora + (sumaMinutos / 60);


        sumaSegundos %= 60;
        sumaMinutos %= 60;
        sumaHoras %= 24;

        return new Tiempo(sumaHoras, sumaMinutos, sumaSegundos);
    }

    public boolean esHoraValida(int hora){
        return hora >= 0 && hora <= 23;
    }

    public boolean esMinutoValido(int minuto){
        return minuto >= 1 && minuto <= 59;
    }

    public boolean esSegundoValido(int segundo){
        return segundo >= 1 && segundo <= 59;
    }

}