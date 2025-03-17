package entregas.alvaradoCarlos.reto004;

public class Fecha {

    private int AÑO, MES, DIA;

    public Fecha(int año, int mes, int dia) {

        assert año > 0: "El año debe ser mayor a 0";
        assert esMesValido(mes): "El mes debe estar entre 1 y 12";
        assert esDiaValido(dia): "El día no es válido para el mes y año especificados";

        this.AÑO = año;
        this.MES = mes;
        this.DIA = dia;
    }

    private boolean esBisiesto(int año) {
        return (año % 4 == 0 && año % 100 != 0) || año % 400 == 0;
    }

    private int diasEnMes(int año, int mes) {
        if (mes == 4 || mes == 6 || mes == 9 || mes == 11) return 30; 
        return mes == 2 ? esBisiesto(año) ? 29 : 28 : 31;
    }

    private boolean esDiaValido(int dia) {
        return dia >= 1 && dia <= diasEnMes(this.AÑO, this.MES);
    }
    
    private boolean esMesValido(int mes) {
        return mes >= 1 && mes <= 12;
    }
    
    public boolean equals(Fecha fecha) {
        return this.AÑO == fecha.AÑO && this.MES == fecha.MES && this.DIA == fecha.DIA;
    }

    public boolean antesQue(Fecha fecha) {
        return this.AÑO < fecha.AÑO || this.MES < fecha.MES || this.DIA < fecha.DIA;
    }

    public boolean despuesDe(Fecha fecha) {
        if (this.equals(fecha)) return false;
        return !this.antesQue(fecha);
    }
    
    public int compareTo(Fecha fecha) {
        if (this.equals(fecha)) return 0;
        return this.antesQue(fecha) ? -1 : 1;
    }

    public Fecha siguiente() {
        return new Fecha(this.AÑO, this.MES, this.DIA + 1);
    }

    public String toString() {
        return this.DIA + "/" + this.MES + "/" + this.AÑO;
    }
}
