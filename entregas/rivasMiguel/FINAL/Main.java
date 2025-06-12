package rivasMiguel;

public class Main {
    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        System.out.print("Nombre de la universidad: ");
        String uniName = sc.nextLine();
        Universidad uni = new Universidad(uniName);
        uni.administrarUniversidad();
    }
}
