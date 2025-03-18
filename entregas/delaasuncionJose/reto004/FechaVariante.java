package entregas.delaasuncionJose.reto004;

public class FechaVariante {
    public int año;
    public int mes;
    public int dia;

    public FechaVariante(int año, int mes, int dia) {
        assert fechaInvalida(año, mes, dia) : "Fecha invalida, introduzca una fecha valida.";

        this.año = año;
        this.mes = mes;
        this.dia = dia;
    }

    private boolean fechaInvalida(int año, int mes, int dia) {
        if (año < 0 || mes < 1 || mes > 12) {
            return true;
        }
        int[] diasMeses = {31, (añoBisiesto(año) ? 29 : 28), 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        return dia < 1 || dia > diasMeses[mes - 1];
    }

    public boolean añoBisiesto(int año) {
        return (año % 4 == 0 && (año % 100 != 0 || año % 400 == 0));
    }

    public FechaVariante siguiente() {
        if (!fechaInvalida(año,mes,dia+1)) {
            return new FechaVariante(año,mes,dia+1);
        } else if (!fechaInvalida(año,mes+1,1)) {
            return new FechaVariante(año,mes+1,1);
        } else {
            return new FechaVariante(año+1,1,1);
        }
    }

    public boolean antesQue(FechaVariante fecha) {
        return año < fecha.año || (año == fecha.año && (mes < fecha.mes || (mes == fecha.mes && dia < fecha.dia)));
    }

    public boolean equals(FechaVariante fecha) {
        return año == fecha.año && mes == fecha.mes &&  dia == fecha.dia;
    }

    public boolean despuesDe(FechaVariante fecha) {
        return año > fecha.año || (año == fecha.año && (mes > fecha.mes || (mes == fecha.mes && dia > fecha.dia)));
    }

    public int compareTo(FechaVariante fecha) {
        return antesQue(fecha) ? 1 : equals(fecha) ? 0 : -1;
    }

    public String toString() {
        return dia + "/" + mes + "/" + año;
    }
}