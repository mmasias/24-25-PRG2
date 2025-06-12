public class Main {
    public static void main(String[] args) {
        Universidad UNEATLANTICO = new Universidad("Universidad Europea del Atlántico");

        Asignatura prog2 = UNEATLANTICO.creaAsignatura("Programación II", "PRG2", "6 créditos");

        Profesor manuel = UNEATLANTICO.contrataProfesor("Manuel Masías", "24445555X");

        manuel.asignarAsignatura(prog2);

        Supervisor diego = new Supervisor("Diego Alonso Díaz", "72201026R");

        Examen examen = manuel.crearExamen();

        manuel.entregaExamenAl(examen, diego);

        System.out.println(UNEATLANTICO.mostrar());
        System.out.println(prog2.mostrar());
    }
}
