public class Unea {
    public static void main(String[] args) {
        CulturaGeneral cultura = new CulturaGeneral();
        Profesor1 profesor1 = new Profesor1();
        Examen examen = profesor1.generarExamen(cultura);

        Profesor2 profesor2 = new Profesor2();
        profesor2.ejecutarExamen(examen);
    }
}
