package entregas.leonJuan.reto002;

import java.util.Scanner;

public class EscalasAcordesCompleto {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Introduce un número según la nota musical que quieras obtener:");
    System.out.println("1. DO\n2. DO#\n3. RE\n4. RE#\n5. MI\n6. FA\n7. FA#\n8. SOL\n9. SOL#\n10. LA\n11. LA#\n12. SI");

    int notaSeleccionada = scanner.nextInt() - 1;

    System.out.println("Introduce un número según la escala que quieras obtener:");
    for (int i = 0; i < nombresEscalas.length; i++) {
      System.out.println((i + 1) + ". " + nombresEscalas[i]);
    }

    int escalaSeleccionada = scanner.nextInt() - 1;
    scanner.close();

    if (escalaSeleccionada >= 0 && escalaSeleccionada < Escalas.length) {
      String escala = generarEscala(notaSeleccionada, Escalas[escalaSeleccionada]);
      String acorde = generarAcorde(notaSeleccionada, Escalas[escalaSeleccionada]);
      System.out.println("Escala " + nombresEscalas[escalaSeleccionada] + ": " + escala);
      System.out.println("Acorde " + nombresEscalas[escalaSeleccionada] + ": " + acorde);
    } else {
      System.out.println("Selección de escala no válida.");
    }
  }

  public static String[] notasMusicales = {
      "DO", "DO#", "RE", "RE#", "MI", "FA",
      "FA#", "SOL", "SOL#", "LA", "LA#", "SI"
  };

  public final static int SEMITONO = 1, TONO = 2, TONO_Y_SEMITONO = 3;

  public final static int[][] Escalas = {
    {TONO, TONO, SEMITONO, TONO, TONO, TONO, SEMITONO},
    {TONO, SEMITONO, TONO, TONO, SEMITONO, TONO, TONO},
    {TONO, SEMITONO, TONO, TONO, SEMITONO, TONO_Y_SEMITONO, SEMITONO},
    {TONO, SEMITONO, TONO, TONO, TONO, TONO, SEMITONO},
    {TONO, TONO, TONO_Y_SEMITONO, TONO, TONO_Y_SEMITONO},
    {TONO_Y_SEMITONO, TONO, TONO, TONO_Y_SEMITONO, TONO},
    {TONO, SEMITONO, TONO, TONO, TONO, SEMITONO, TONO},
    {SEMITONO, TONO, TONO, TONO, SEMITONO, TONO, TONO},
    {TONO, TONO, TONO, SEMITONO, TONO, TONO, SEMITONO},
    {TONO, TONO, SEMITONO, TONO, TONO, SEMITONO, TONO},
    {SEMITONO, TONO, TONO, SEMITONO, TONO, TONO, TONO},
    {TONO, TONO, TONO, TONO, TONO, TONO}
  };

  public final static String[] nombresEscalas = {
    "Mayor", "Menor natural", "Menor armónica", "Menor melódica", "Pentatónica mayor", "Pentatónica menor",
    "Dórica", "Frigia", "Lidia", "Mixolidia", "Locria", "Por tonos"
  };

  public static String generarEscala(int notaSeleccionada, int[] intervalos) {
    StringBuilder escala = new StringBuilder(notasMusicales[notaSeleccionada]);
    int notaActual = notaSeleccionada;
    for (int intervalo : intervalos) {
      notaActual = (notaActual + intervalo) % 12;
      escala.append("-").append(notasMusicales[notaActual]);
    }
    return escala.toString();
  }

  public static String generarAcorde(int notaSeleccionada, int[] intervalos) {
    int tercera = (notaSeleccionada + intervalos[0] + intervalos[1]) % 12;
    int quinta = (notaSeleccionada + intervalos[0] + intervalos[1] + intervalos[2] + intervalos[3]) % 12;
    return notasMusicales[notaSeleccionada] + "-" + notasMusicales[tercera] + "-" + notasMusicales[quinta];
  }
}