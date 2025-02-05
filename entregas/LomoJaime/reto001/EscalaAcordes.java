package entregas.LomoJaime.reto001;
import java.util.Scanner;
class EscalaAcordes {
    public static void main(String[] args) {
        int notaTrabajar = pedirNota();
        String[]escala = creaEscala(notaTrabajar);
        String[]acorde = creaAcorde(escala);
        imprimeEscala(notaTrabajar, escala);
        imprimeAcorde(notaTrabajar, acorde);
        }
            static String[] getNotas() {
            return new String[] { "Do", "Do#", "Re", "Re#", "Mi", "Fa", "Fa#", "Sol", "Sol#", "La", "La#", "Si" };
            }

            static int pedirNota() {
                System.out.println("Añada la nota que quiera: 1:Do, 2:Do#, 3:Re, 4:Re#, 5:Mi, 6:Fa, 7:Fa#, 8:Sol, ...");
                Scanner read = new Scanner(System.in);
                int notaTrabajar = read.nextInt() - 1;
                read.close();
                String[] notas = getNotas();
                System.out.println("Has elegido " + notas[notaTrabajar]);
                return notaTrabajar;
            }
            static String[] creaEscala(int notaTrabajar) {
                String[]escala = new String[8];
                String[]notas = getNotas();
                int[]posiciones = { 0, 2, 4, 5, 7, 9, 11, 12 };
                int LongitudEscala = escala.length;
                int LongitudNotas = notas.length;
                for (int i = 0; i < LongitudEscala; i++) {
                    escala[i] = notas[(notaTrabajar + posiciones[i]) % LongitudNotas];
                }
                 return escala;
            }
            static String[] creaAcorde(String[] escala) {
                String[]acorde = new String[3];
                int[]posiciones = { 0, 2, 4 };
                int LongitudAcorde = acorde.length;
                for (int i = 0; i < LongitudAcorde; i++) {
                    acorde[i] = escala[posiciones[i]];
                }
                return acorde;
            }
            static void imprimeEscala(int notaTrabajar, String[] escala) {
                    String[]notas = getNotas();
                    System.out.print("El acorde de " + notas[notaTrabajar] + " Mayor es: ");
                    for (int i = 0; i < escala.length; i++) {
                        System.out.print("[" + escala[i] + "]");
                            if (i < escala.length - 1){
                                System.out.print(" / ");
                            }
                    }
                    System.out.println();
        
            }
            static void imprimeAcorde(int notaTrabajar, String[] acorde) {
                    String[]notas = getNotas();
                    System.out.print("La escala de " + notas[notaTrabajar] + " Mayor es: ");
                        for (int i = 0; i < acorde.length; i++) {
                            System.out.print("[" + acorde[i] + "]");
                                if (i < acorde.length - 1){
                                    System.out.print(" / ");
                                }
                    }
                    System.out.println();
            }
            
        }
    
       
    
    