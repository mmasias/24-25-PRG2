package entregas.valdesCarlos.reto004;

public class Fecha {
    private int año, mes, dia;

    public Fecha(int año, int mes, int dia) {
        assert año > 0 : "Año inválido";
        assert esMesValido(mes) : "Mes inválido";
        assert esDiaValido(dia) : "Día inválido";
        
        this.año = año;
        this.mes = mes;
        this.dia = dia;
    }

    public boolean equals(Fecha fecha) {
        return this.año == fecha.año && this.mes == fecha.mes && this.dia == fecha.dia;
    }

    public boolean antesQue(Fecha fecha) {
        return compareTo(fecha) < 0;
    }

    public boolean despuesDe(Fecha fecha) {
        return compareTo(fecha) > 0;
    }

    public int compareTo(Fecha fecha) {
        if (this.año != fecha.año) return Integer.compare(this.año, fecha.año);
        if (this.mes != fecha.mes) return Integer.compare(this.mes, fecha.mes);
        return Integer.compare(this.dia, fecha.dia);
    }

    public Fecha siguiente() {
        int nuevoDia = this.dia + 1;
        int nuevoMes = this.mes;
        int nuevoAño = this.año;

        if (!esDiaValido(nuevoDia)) {
            nuevoDia = 1;
            nuevoMes++;
            if (!esMesValido(nuevoMes)) {
                nuevoMes = 1;
                nuevoAño++;
            }
        }
        return new Fecha(nuevoAño, nuevoMes, nuevoDia);
    }

    public String toString() {
        return this.dia + "/" + this.mes + "/" + this.año;
    }

    private boolean esMesValido(int mes) {
        return mes >= 1 && mes <= 12;
    }

    private boolean esDiaValido(int dia) {
        return dia >= 1 && dia <= 30;
    }
}
