public class Asignatura {
    public static Asignatura asignarAsignatura() {
        System.out.println("Asignatura asignada.");
        return new Asignatura();
    }

    public void mostrar() {
        System.out.println("Asignatura: Programación 2 / Créditos: 6");
    }

    public String getNombre() {
        return "Programación 2";
    }
}


