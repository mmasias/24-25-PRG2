public class Fecha {
    private int año, mes, dia;

    public Fecha(int año, int mes, int dia) {
        if (esMesValido(mes) && esDiaValido(dia)) {
            this.año = año;
            this.mes = mes;
            this.dia = dia;
        } else {
            this.año = 2000;
            this.mes = 1;
            this.dia = 1;
        }
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
        if (this.año != fecha.año) {
            return this.año - fecha.año;
        } else if (this.mes != fecha.mes) {
            return this.mes - fecha.mes;
        } else {
            return this.dia - fecha.dia;
        }
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

    public boolean esMesValido(int mes) {
        return mes >= 1 && mes <= 12;
    }

    public boolean esDiaValido(int dia) {
        return dia >= 1 && dia <= 30;
    }

    public String toString() {
        return dia + "/" + mes + "/" + año;
    }

    public static void main(String[] args) {
        Fecha fecha1 = new Fecha(2025, 3, 14);
        Fecha fecha2 = new Fecha(2025, 3, 15);
        
        System.out.println("Fecha 1: " + fecha1);
        System.out.println("Fecha 2: " + fecha2);
        System.out.println("¿Fecha 1 es antes que Fecha 2? " + fecha1.antesQue(fecha2));
        System.out.println("¿Fecha 1 es después de Fecha 2? " + fecha1.despuesDe(fecha2));
        System.out.println("Día siguiente de Fecha 1: " + fecha1.siguiente());
    }
}
