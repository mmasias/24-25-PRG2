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