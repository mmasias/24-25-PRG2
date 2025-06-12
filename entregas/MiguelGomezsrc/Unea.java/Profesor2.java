import java.util.List;

public class Profesor2 {

    public Profesor2() {

    }

    public void ejecutarExamen(Examen examen) {
        List<String> preguntas = examen.getPreguntas();
        List<String> respuestas = examen.getRespuestas();

        System.out.println("======= EXAMEN DE CULTURA GENERAL =======\n");

        for (int i = 0; i < preguntas.size(); i++) {
            System.out.println((i + 1) + ". " + preguntas.get(i));
            System.out.println("   Respuesta: " + respuestas.get(i));
            System.out.println();
        }

        System.out.println("=========== FIN DEL EXAMEN ===========");
    }
}
