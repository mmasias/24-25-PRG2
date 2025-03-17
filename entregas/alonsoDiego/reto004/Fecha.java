package entregas.alonsoDiego.reto004;

public class Fecha {

    private int año;
    private int mes;
    private int dia;

    public Fecha(int año, int mes, int dia) {
        assert esMesValido(mes) && esDiaValido(dia, mes, año) : "No es válida esa fecha";
    
        this.año = año;
        this.mes = mes;
        this.dia = dia;
    }
    
    public boolean esDiaValido(int dia, int mes, int año) {
        int[] diasPorMes = { 31, esBisiesto(año) ? 29 : 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        return dia > 0 && dia <= diasPorMes[mes - 1];
    }
    public boolean esBisiesto(int año) {
        return (año % 4 == 0 && año % 100 != 0) || (año % 400 == 0);
    }
        
    

    public boolean equals(Fecha fecha) {
        return this.año == fecha.año && this.mes == fecha.mes && this.dia == fecha.dia;
    }

    public boolean antesQue(Fecha fecha) {
        if (this.año < fecha.año) {
            return true;
        } else if (this.año == fecha.año) {
            if (this.mes < fecha.mes) {
                return true;
            } else if (this.mes == fecha.mes) {
                if (this.dia < fecha.dia) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean despuesDe(Fecha fecha) {
        return !this.antesQue(fecha) && !this.equals(fecha);
    }

    public int compareTo(Fecha fecha) {
        if (this.antesQue(fecha)) {
            return -1;
        } else if (this.equals(fecha)) {
            return 0;
        } else {
            return 1;
        }
    }

    public Fecha siguiente() {
        int nuevoDia = this.dia + 1;
        int nuevoMes = this.mes;
        int nuevoAño = this.año;
    
        if (!esDiaValido(nuevoDia, nuevoMes, nuevoAño)) {
            nuevoDia = 1;
            nuevoMes++;
            if (nuevoMes > 12) {
                nuevoMes = 1;
                nuevoAño++;
            }
        }
    
        return new Fecha(nuevoAño, nuevoMes, nuevoDia);
    }
    

    public String toString() {
        return this.año + "/" + this.mes + "/" + this.dia;
    }

    public boolean esMesValido(int mes) {
        return mes > 0 && mes < 13;
    }

    public boolean esDiaValido(int dia) {
        return dia > 0 && dia < 32;
    }
}
