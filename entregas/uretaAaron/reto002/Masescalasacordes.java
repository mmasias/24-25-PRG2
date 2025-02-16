
class Masescalasacordes {

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

    public static void main(String[] args) {
        String notaBase = solicitarNota();
        int[] escalaSeleccionada = solicitarEscala();
        String[] escala = generarEscala(notaBase, escalaSeleccionada);
        String[] acorde = generarAcorde(escala);
        System.out.println("Escala en " + notaBase + ":");
        mostrarNotas(escala);
        System.out.println("Acorde:");
        mostrarNotas(acorde);

        private static void mostrarNotas(String[] notas) {
            for (String nota : notas) {
                System.out.print("[" + nota + "] ");
            }
            System.out.println();
        }
        private static String[] generarAcorde(String[] escala) {
            return new String[]{escala[0], escala[2], escala[4]};
        }
        private static String[] generarEscala(String nota, int[] intervalos) {
            int indiceNota = obtenerIndiceNota(nota);
            String[] escala = new String[intervalos.length + 1];
            
            for (int i = 0; i < escala.length; i++) {
                escala[i] = NOTAS[indiceNota];
                if (i < intervalos.length) {
                    indiceNota = (indiceNota + intervalos[i]) % NOTAS.length;
                }
            }
            return escala;
        }
    

    }
