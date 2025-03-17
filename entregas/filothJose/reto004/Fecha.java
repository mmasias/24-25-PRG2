package.entregas.filothJose.reto004;

class Fecha {
    private int año;
    private int mes;
    private int dia;

    public Fecha(int año, int mes, int dia) {
        assert esMesValido(mes) && esDiaValido(dia): "No es valida esa fecha";

        this.año = año;
        this.mes = esMesValido(mes) ? mes : 1;
        this.dia = esDiaValido(dia) ? dia : 1;

    }

    public boolean equals(Fecha fecha){
        return this.año == fecha.año && this.mes == fecha.mes && this.dia == fecha.dia;
    }

    public boolean antesQue(Fecha fecha){
        if (this.año < fecha.año) return true;
        else if (this.año == fecha.año && this.mes < fecha.mes) return true;
        else if (this.año == fecha.año && this.mes == fecha.mes && this.dia < fecha.dia) return true; 
        else return false;
    }

    public boolean despuesDe(Fecha fecha){
        return !antesQue(fecha) && !equals(fecha);
    }

    public int compareTo(Fecha fecha){
        return equals(fecha) ? 0 : (this.despuesDe(fecha) ? 1 : -1);
    }

    public Fecha siguiente() {
        int diaNuevo = this.dia +1;
        int mesNuevo = this.mes;
        int añoNuevo = this.año;

        if (!esDiaValido(diaNuevo)) {
            diaNuevo = 1;
            mesNuevo++;
            if (!esMesValido(mesNuevo)) {
                mesNuevo = 1;
                añoNuevo++;
            }
        }
        return new Fecha(diaNuevo,mesNuevo,añoNuevo);
    }

    public String toString() {
        return dia + "/" + mes + "/" + año;
    }
    public boolean esMesValido(int mes){
        return mes >= 1 && mes <= 12;
    }

    public boolean esDiaValido(int dia){
        return dia >= 1 && dia <= 31;
    }
}