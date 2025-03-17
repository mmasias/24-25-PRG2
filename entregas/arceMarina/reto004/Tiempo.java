package entregas.arceMarina.reto004;

class Tiempo {
    private int hora;
    private int minuto;
    private int segundo;
    
    public Tiempo(int hora, int minuto, int segundo){
        assert esHoraValida(hora) && esMinutoValido(minuto) && esSegundoValido(segundo) : "No es valido este Tiempo";
        
        this.hora = hora;
        this.minuto = minuto;
        this.segundo = segundo;
    }
    
    public boolean equals(Tiempo tiempo){
        if (tiempo == null) return false;
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
        int segundoNuevo = this.segundo + 1;
        int minutoNuevo = this.minuto;
        int horaNueva = this.hora;
            
        if (segundoNuevo > 59) {
            segundoNuevo = 0;
            minutoNuevo++;
        }
        if (minutoNuevo > 59) {
            minutoNuevo = 0;
            horaNueva++;
        }
        if (horaNueva > 23) {
            horaNueva = 0;
        }
    
        return new Tiempo(horaNueva, minutoNuevo, segundoNuevo);
    }
    
    public String toString() {
        String horaCadena = (hora < 10 ? "0" + hora : "" + hora);
        String minutoCadena = (minuto < 10 ? "0" + minuto : "" + minuto);
        String segundoCadena = (segundo < 10 ? "0" + segundo : "" + segundo);
        return horaCadena + ":" + minutoCadena + ":" + segundoCadena;
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
        return minuto >= 0 && minuto <= 59;
    }
    
    public boolean esSegundoValido(int segundo){
        return segundo >= 0 && segundo <= 59;
    }   
}


