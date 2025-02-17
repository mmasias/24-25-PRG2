import java.util.Scanner;

public class EscalaAcordes {
    static final String[] TONOS = {
            "Do", "Do#", "Re", "Re#", "Mi", "Fa", "Fa#", "Sol", "Sol#", "La", "La#", "Si"
    };
    static final int SEMITONO = 1;
    static final int TONO = 2 * SEMITONO;
    static final int TONO_Y_MEDIO = TONO + SEMITONO;

    static final int[][] ESCALAS = {
            { TONO, TONO, SEMITONO, TONO, TONO, TONO, SEMITONO }, 
            { TONO, SEMITONO, TONO, TONO, SEMITONO, TONO, TONO },
            { TONO, SEMITONO, TONO, TONO, SEMITONO, TONO_Y_MEDIO, SEMITONO },
            { TONO, SEMITONO, TONO, TONO, TONO, TONO, SEMITONO }, 
            { TONO, TONO, TONO_Y_MEDIO, TONO, TONO_Y_MEDIO },
            { TONO_Y_MEDIO, TONO, TONO, TONO_Y_MEDIO, TONO },
            { TONO, SEMITONO, TONO, TONO, TONO, SEMITONO, TONO }, 
            { SEMITONO, TONO, TONO, TONO, SEMITONO, TONO, TONO },
            { TONO, TONO, TONO, SEMITONO, TONO, TONO, SEMITONO }, 
            { TONO, TONO, SEMITONO, TONO, TONO, SEMITONO, TONO },            
            { SEMITONO, TONO, TONO, SEMITONO, TONO, TONO, TONO }, 
            { TONO, TONO, TONO, TONO, TONO, TONO }
    };
}