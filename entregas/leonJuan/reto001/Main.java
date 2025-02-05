package entregas.leonJuan.reto001;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Introduce un número según la nota musical que quieras obtener:");
        System.out.println("0. DO\n1. DO#\n2. RE\n3. RE#\n4. MI\n5. FA\n6. FA#\n7. SOL\n8. SOL#\n9. LA\n10. LA#\n11. SI");
        
        int notaSeleccionada = scanner.nextInt();
        scanner.close();

        String semitono = subirSemitono(notaSeleccionada);
        String tono = subirTono(notaSeleccionada);
        String escala = generarEscalaMayor(notaSeleccionada);
        String acorde = generarAcordeMayor(notaSeleccionada);

        System.out.println("Nota Seleccionada " + notasMusicales[notaSeleccionada]);
        System.out.println("Siguiente semitono: " + semitono);
        System.out.println("Siguiente tono: " + tono);
        System.out.println("Escala mayor: " + escala);
        System.out.println("Acorde mayor: " + acorde);
    }

    public static String[] notasMusicales = {
        "DO", "DO#", "RE", "RE#", "MI", "FA",
        "FA#", "SOL", "SOL#", "LA", "LA#", "SI"
    };

    public static String subirSemitono(int notaSeleccionada) {
        if (notaSeleccionada >= 0 && notaSeleccionada <= 12) {
            return notasMusicales[(notaSeleccionada + 1) % 12];  // Asegura que vuelva a 0 si supera 11
        } else {
            return "Nota no válida";
        }
    }

    public static String subirTono(int notaSeleccionada) {
        if (notaSeleccionada >= 0 && notaSeleccionada <= 12) {
            return notasMusicales[(notaSeleccionada + 2) % 12];  // Asegura que no se salga del rango
        } else {
            return "Nota no válida";
        }
    }

    public static String generarEscalaMayor(int notaSeleccionada) {
        if (notaSeleccionada >= 0 && notaSeleccionada <= 12 && notaSeleccionada == 1 || notaSeleccionada == 3 || notaSeleccionada == 6 || notaSeleccionada == 8 || notaSeleccionada == 10) {
            return notasMusicales[notaSeleccionada-1] + "-" + subirTono(notaSeleccionada-1) + "-" + subirTono((notaSeleccionada + 1) % 12) + "-" + subirSemitono((notaSeleccionada + 3) % 12) + "-" + subirTono((notaSeleccionada + 4) % 12) + "-" + subirTono((notaSeleccionada + 6) % 12) + "-" + subirTono((notaSeleccionada + 8) % 12) + "-" + subirSemitono((notaSeleccionada + 10) % 12);
        } else {
            return notasMusicales[notaSeleccionada] + "-" + subirTono(notaSeleccionada) + "-" + subirTono((notaSeleccionada + 2) % 12) + "-" + subirSemitono((notaSeleccionada + 4) % 12) + "-" + subirTono((notaSeleccionada + 5) % 12) + "-" + subirTono((notaSeleccionada + 7) % 12) + "-" + subirTono((notaSeleccionada + 9) % 12) + "-" + subirSemitono((notaSeleccionada + 11) % 12);
        }
    }

    public static String generarAcordeMayor(int notaSeleccionada) {
        if (notaSeleccionada >= 0 && notaSeleccionada <= 12 && notaSeleccionada == 1 || notaSeleccionada == 3 || notaSeleccionada == 6 || notaSeleccionada == 8 || notaSeleccionada == 10) {
            return notasMusicales[notaSeleccionada-1] + "-" + subirSemitono((notaSeleccionada + 2) % 12) + "-" + subirSemitono((notaSeleccionada + 5) % 12);
        } else {
            return notasMusicales[notaSeleccionada] + "-" + subirSemitono((notaSeleccionada + 3) % 12) + "-" + subirSemitono((notaSeleccionada + 6) % 12);
        }
    }
}
