
class Masescalasacordes {

    public static void main(String[] args) {
    private static final string[] NOTAS = {"Do", "Do#", "Re", "Re#", "Mi", "Fa", "Fa#", "Sol", "Sol#", "La", "La#", "Si"};
    private static final int SEMITONO = 1, TONO = SEMITONO * 2 TONO_Y_MEDIO  = SEMITONO + TONO
    private static final int[][] ESCALAS = {
        {TONO, TONO, SEMITONO, TONO, TONO, TONO, SEMITONO},
        {TONO, SEMITONO, TONO, TONO, SEMITONO, TONO, TONO},
        {TONO, SEMITONO, TONO, TONO, SEMITONO, TONO_Y_MEDIO, SEMITONO},
        {TONO, SEMITONO, TONO, TONO, TONO, TONO, SEMITONO},
        {TONO, TONO, TONO_Y_MEDIO, TONO, TONO_Y_MEDIO},
        {TONO_Y_MEDIO, TONO, TONO, TONO_Y_MEDIO, TONO},
        {TONO, SEMITONO, TONO, TONO, TONO, SEMITONO, TONO},
        {SEMITONO, TONO, TONO, TONO, SEMITONO, TONO, TONO},
        {TONO, TONO, TONO, SEMITONO, TONO, TONO, SEMITONO},
        {TONO, TONO, SEMITONO, TONO, TONO, SEMITONO, TONO},
        {SEMITONO, TONO, TONO, SEMITONO, TONO, TONO, TONO},
        {TONO, TONO, TONO, TONO, TONO, TONO}
    };
    String notaBase = solicitarNota();
    int[] escalaSeleccionada = solicitarEscala();
    String[] escala = generarEscala(notaBase, escalaSeleccionada);
    String[] acorde = generarAcorde(escala);

    System.out.println (

    "Escala en " + notaBase + ":");
    mostrarNotas(escala);

    System.out.println (

    "Acorde:");
    mostrarNotas(acorde);

}
