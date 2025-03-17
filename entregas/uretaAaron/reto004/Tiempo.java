class Tiempo {
    private int segundos;
    private int minutos; 
    private int horas;
}
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
