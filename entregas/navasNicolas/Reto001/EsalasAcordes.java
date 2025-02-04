    import java.util.Scanner;

    class EsalasAcordes {
        public static void main(String[] args) {
            String[] notes = {"Do", "Do#", "Re", "Re#", "Mi", "Fa", "Fa#", "Sol", "Sol#", "La", "La#", "Si"}; 
            System.out.println(notes[0]);

        };
        static int askNumber(){
            Scanner entrada = new Scanner(System.in);
            System.out.println("Dime la nota a la que quieres sacar escala");
            String input = scanner.nextLine();
            return input;
        }

    };