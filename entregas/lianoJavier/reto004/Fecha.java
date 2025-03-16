package entregas.lianoJavier.reto004;

public class Fecha {
    private int año, mes, dia;

    public Fecha(int año, int mes, int dia) {
        assert año > 0 : "El año no puede ser negativo";
        assert mes > 0 && mes <= 12 : "El mes debe estar entre 1 y 12";
        assert dia > 0 && dia <= 31 : "El día debe estar entre 1 y 31";

        this.año = año;
        this.mes = mes;
        this.dia = dia;
    }

    public boolean equals(Fecha fecha) {
        return this.año == fecha.año && this.mes == fecha.mes && this.dia == fecha.dia;
    }

    public boolean antesQue(Fecha fecha) {
        if (this.año < fecha.año) return true;
        if (this.mes < fecha.mes) return true;
        if (this.dia < fecha.dia) return true;
        return false;
    }

    public boolean despuesQue(Fecha fecha) {
        if (this.año > fecha.año) return true;
        if (this.mes > fecha.mes) return true;
        if (this.dia > fecha.dia) return true;
        return false;
    }

    public int compareTo(Fecha fecha) {
        if (this.antesQue(fecha)) return -1;
        if (this.despuesQue(fecha)) return 1;
        return 0;
    }

    public Fecha siguiente() {
        return new Fecha(año, mes, dia + 1);
    }

    public String toString() {
        return año + "/" + mes + "/" + dia;
    }

}
