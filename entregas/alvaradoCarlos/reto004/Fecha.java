package entregas.alvaradoCarlos.reto004;

public class Fecha {

    final int AÑO, MES, DIA;

    public static void main(String[] args) {
        Fecha fecha = new Fecha(2025, 3, 29);
        Fecha fecha2 = new Fecha(2025, 3, 29);
        System.out.println(new Fecha(2020, 2, 28).siguiente());
    }

    public Fecha(int año, int mes, int dia) {

        assert año > 0: "El año debe ser mayor a 0";
        assert mes >= 1 && mes <= 12: "El mes debe estar entre 1 y 12";
        assert dia >= 1 && dia <= diasEnMes(año, mes): "El día no es válido para el mes y año especificados";

        this.AÑO = año;
        this.MES = mes;
        this.DIA = dia;
    }

    private int diasEnMes(int año, int mes) {
        if (mes == 4 || mes == 6 || mes == 9 || mes == 11) return 30; 
        return mes == 2 ? esBisiesto(año) ? 29 : 28 : 31;
    }

    private boolean esBisiesto(int año) {
        return (año % 4 == 0 && año % 100 != 0) || año % 400 == 0;
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

    public boolean esMesValido(int mes) {
        return mes >= 1 && mes <= 12;
    }

    public boolean esDiaValido(int dia) {
        return dia >= 1 && dia <= diasEnMes(this.AÑO, this.MES);
    }

    public String toString() {
        return this.DIA + "/" + this.MES + "/" + this.AÑO;
    }
}
