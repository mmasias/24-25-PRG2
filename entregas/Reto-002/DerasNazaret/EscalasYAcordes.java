import java.util.Scanner;

public class EscalasYAcordes {

    private static final int SEMITONO = 1;
    private static final int TONO = SEMITONO + SEMITONO;
    private static final int TONO_MEDIO = 3;

    private static final String[] ESCALA = {"DO", "DO#", "RE", "RE#", "MI", "FA", "FA#", "SOL", "SOL#", "LA", "LA#", "SI"};

    public static void main(String[] args) {
        Scanner entradaUsuario = new Scanner(System.in);

        int eleccionUsuario = preguntarEscalaUsuario(entradaUsuario);
        int notaBase = seleccionarNotaBase(entradaUsuario);

        if (eleccionUsuario < 1 || eleccionUsuario > 4) {
            System.out.println("Opción no válida");
        }

        int[] intervalos = obtenerIntervalos(eleccionUsuario);
        String[] escalaConstruida = construirEscala(notaBase, intervalos);

        escala(escalaConstruida);
        acorde(escalaConstruida);
    }
