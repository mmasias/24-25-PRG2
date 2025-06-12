public class CrearExamen {
    public String pregunta1;
    public String pregunta2;
    public String pregunta3;

    public CrearExamen(String p1, String p2, String p3) {
        this.pregunta1 = p1;
        this.pregunta2 = p2;
        this.pregunta3 = p3;
    }

    public static CrearExamen contenidoExamen(String p1, String p2, String p3) {
        return new CrearExamen(p1, p2, p3);
    }
}
