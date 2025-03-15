package entregas.doaltoBienvenido.reto004;

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
    // public boolean antesQue(Fecha fecha){

    // }
    // public boolean despuesDe(Fecha date){

    // }
    //public int compareTo(Fecha date){

    //}

    public void siguiente() {
        this.dia +=1;
    }

    public String toString() {
        return dia + "/" + mes + "/" + año;
    }
    public boolean esMesValido(int mes){
        return mes >= 1 && mes <=12;
    }

    public boolean esDiaValido(int dia){
        return dia >= 1 && dia <= 30;
    }
}
