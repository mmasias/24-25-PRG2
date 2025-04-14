package puenteSergio;

public class App {

    public static void main(String[] args) {

        try {
            Persona p = new Persona(nombre: "Sergio", apellidos: "Puente Martinez", edad: 18);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}