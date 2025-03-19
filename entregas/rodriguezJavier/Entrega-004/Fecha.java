public class Fecha {

    private int year;
    private int month;
    private int day;

    public Fecha(int year, int month, int day) {
        assert validarMes(month) && validarDia(day) : "Fecha no válida";
        
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public boolean esIgual(Fecha otra) {
        return this.year == otra.year && this.month == otra.month && this.day == otra.day;
    }

    public boolean esAnterior(Fecha otra) {
        return this.comparar(otra) < 0;
    }

    public boolean esPosterior(Fecha otra) {
        return this.comparar(otra) > 0;
    }

    public int comparar(Fecha otra) {
        if (this.year != otra.year) return Integer.compare(this.year, otra.year);
        if (this.month != otra.month) return Integer.compare(this.month, otra.month);
        return Integer.compare(this.day, otra.day);
    }

    public Fecha siguienteDia() {
        int nuevoDia = day + 1;
        int nuevoMes = month;
        int nuevoYear = year;

        if (nuevoDia > 30) {
            nuevoDia = 1;
            nuevoMes++;
            if (nuevoMes > 12) {
                nuevoMes = 1;
                nuevoYear++;
            }
        }
        return new Fecha(nuevoYear, nuevoMes, nuevoDia);
    }

    private boolean validarMes(int month) {
        return month >= 1 && month <= 12;
    }

    private boolean validarDia(int day) {
        return day >= 1 && day <= 30;
    }
}