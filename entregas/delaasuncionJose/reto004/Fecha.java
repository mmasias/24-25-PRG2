package entregas.delaasuncionJose.reto004;

public class Fecha {
    private int año;
    private int mes;
    private int dia;

    public Fecha(int año, int mes, int dia) {
        this.año = año;
        this.mes = mes;
        this.dia = dia;
    }

    public boolean diaValido() {
        return dia <=30 && dia > 0;
    }

    public boolean mesValido() {
        return mes <=12 && mes > 0;
    }

    public Fecha siguiente() {
        if (dia+1 <=30) {
            return new Fecha(año,mes,dia+1);
        } else if (mes+1 <=12) {
            return new Fecha(año,mes+1,1);
        }
        return new Fecha(año+1,1,1);
    }

    public boolean antesQue(Fecha fecha) {
        return año < fecha.año || (año == fecha.año && (mes < fecha.mes || (mes == fecha.mes && dia < fecha.dia)));
    }

    public boolean equals(Fecha fecha) {
        return año == fecha.año && mes == fecha.mes &&  dia == fecha.dia;
    }

    public boolean despuesDe(Fecha fecha) {
        return año > fecha.año || (año == fecha.año && (mes > fecha.mes || (mes == fecha.mes && dia > fecha.dia)));
    }

    public int compareTo(Fecha fecha) {
        return antesQue(fecha) ? 1 : equals(fecha) ? 0 : -1;
    }

    public String toString() {
        return dia + "/" + mes + "/" + año;
    }
}