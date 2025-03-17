package entregas.arceMarina.reto004;

class Fecha {
    private int año;
    private int mes;
    private int dia;

    public Fecha(int año, int mes, int dia) {
        assert esMesValido(mes) : "Mes no válido: " + mes;
        assert esDiaValido(dia, mes, año) : "Día no válido: " + dia + " para el mes: " + mes + " y año: " + año;
        
        this.año = año;
        this.mes = mes;
        this.dia = dia;
    }

    public boolean equals(Fecha fecha){
        if (fecha == null) return false;
        return this.año == fecha.año && this.mes == fecha.mes && this.dia == fecha.dia;
    }

    public boolean antesQue(Fecha fecha) {
        if (this.año < fecha.año) return true;
        if (this.año == fecha.año && this.mes < fecha.mes) return true;
        return this.año == fecha.año && this.mes == fecha.mes && this.dia < fecha.dia;
    }

    public boolean despuesDe(Fecha fecha){
        return !antesQue(fecha) && !equals(fecha);
    }

    public int compareTo(Fecha fecha){
        if (this.antesQue(fecha)) return -1;
        if (this.equals(fecha)) return 0;
        return 1;
    }

    public Fecha siguiente() {
        int diaNuevo = this.dia +1;
        int mesNuevo = this.mes;
        int añoNuevo = this.año;

        if (!esDiaValido(diaNuevo, mesNuevo, añoNuevo)) {
            diaNuevo = 1;
            mesNuevo++;
            if (!esMesValido(mesNuevo)) {
                mesNuevo = 1;
                añoNuevo++;
            }
        }
        return new Fecha(añoNuevo, mesNuevo, diaNuevo);
    }

    public String toString() {
        return dia + "/" + mes + "/" + año;
    }
    
    public boolean esMesValido(int mes){
        return mes >= 1 && mes <= 12;
    }

    public boolean esDiaValido(int dia, int mes, int año){
        if (dia < 1 || dia > 31) return false; 

        if (mes == 2) {
            return dia <= (esBisiesto(año) ? 29 : 28); 
        } else if (mes == 4 || mes == 6 || mes == 9 || mes == 11) {
            return dia <= 30; 
        } else {
            return true; 
        }
    }

    private boolean esBisiesto(int año) {
        return (año % 4 == 0 && año % 100 != 0) || (año % 400 == 0);
    }
}
    