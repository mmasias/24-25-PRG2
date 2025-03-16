package entregas.vaqueroSara.reto004;

public class Fecha {
    
    private int dia;
    private int mes;
    private int año;

    public Fecha(int año, int mes, int dia) {
        this.año = año;
        this.mes = mes;
        this.dia = dia;
    }

    public String toString() {
        return String.format("%02d/%02d/%d", this.dia, this.mes, this.año);
    }

    public boolean equals(Fecha fecha) {
        if (fecha == null) {
            return false;
        }
        return this.año == fecha.año && this.mes == fecha.mes && this.dia == fecha.dia;
    }

    public boolean antesQue(Fecha fecha) {
        if (fecha == null) {
            throw new IllegalArgumentException("La fecha no puede ser nula.");
        }
        return this.año < fecha.año || 
               (this.año == fecha.año && this.mes < fecha.mes) || 
               (this.año == fecha.año && this.mes == fecha.mes && this.dia < fecha.dia);
    }

    public boolean despuesDe(Fecha fecha) {
        if (fecha == null) {
            throw new IllegalArgumentException("La fecha no puede ser nula.");
        }
        return this.año > fecha.año || 
               (this.año == fecha.año && this.mes > fecha.mes) || 
               (this.año == fecha.año && this.mes == fecha.mes && this.dia > fecha.dia);
    }

    public Fecha siguiente() {
        int siguienteDia = this.dia + 1;
        int siguienteMes = this.mes;
        int siguienteAño = this.año;

        if (siguienteDia > obtenerDiasDelMes(siguienteMes, siguienteAño)) {
            siguienteDia = 1;
            siguienteMes++;

            if (siguienteMes > 12) {
                siguienteMes = 1;
                siguienteAño++;
            }
        }

        return new Fecha(siguienteAño, siguienteMes, siguienteDia);
    }

    public boolean esMesValido(int mes) {
        return mes >= 1 && mes <= 12;
    }

    public boolean esDiaValido(int dia) {
        return dia >= 1 && dia <= 30;
    }

    private int obtenerDiasDelMes(int mes, int año) {
        int[] diasPorMes = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        if (esBisiesto(año) && mes == 2) {
            return 29;
        }

        return diasPorMes[mes - 1];
    }

    private boolean esBisiesto(int año) {
        return (año % 4 == 0 && (año % 100 != 0 || año % 400 == 0));
    }
}
