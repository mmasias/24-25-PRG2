public class EscalasYAcordes {
    public static void main(String[] args) {
        static final String[] NOTAS = {"Do", "Do#", "Re", "Re#", "Mi", "Fa", "Fa#", "Sol", "Sol#", "La", "La#", "Si"};
        static final String[] NOMBRES_ESCALAS = {"Mayor", "Menor natural", "Menor armónica", "Menor melódica", "Pentatónica mayor", "Pentatónica menor", "Dórica", "Frigia", "Lidia", "Mixolidia", "Locria", "Por tonos"};
        static final int SEMITONO = 1, TONO = SEMITONO + SEMITONO, TONOYMEDIO = TONO + SEMITONO;
        static final int[][] PATRONES = {
            {TONO, TONO, SEMITONO, TONO, TONO, TONO, SEMITONO},
            {TONO, SEMITONO, TONO, TONO, SEMITONO, TONO, TONO},
            {TONO, SEMITONO, TONO, TONO, SEMITONO, TONOYMEDIO, SEMITONO},
            {TONO, SEMITONO, TONO, TONO, TONO, TONO, SEMITONO},
            {TONO, TONO, TONOYMEDIO, TONO, TONOYMEDIO},
            {TONOYMEDIO, TONO, TONO, TONOYMEDIO, TONO},  
            {TONO, SEMITONO, TONO, TONO, TONO, SEMITONO, TONO},
            {SEMITONO, TONO, TONO, TONO, SEMITONO, TONO, TONO},
            {TONO, TONO, TONO, SEMITONO, TONO, TONO, SEMITONO},
            {TONO, TONO, SEMITONO, TONO, TONO, SEMITONO, TONO},
            {SEMITONO, TONO, TONO, SEMITONO, TONO, TONO, TONO},
            {TONO, TONO, TONO, TONO, TONO, TONO}
        };