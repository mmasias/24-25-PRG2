package entregas.Restaurante;

import java.util.Random;

public class Clientes {

    private String[] nombres = { "Carlos", "Laura", "David", "Ana", "José", "Marta", "Luis", "Sofia", "Miguel",
            "Isabel" };
    private String[] apellidos = { "González", "Rodríguez", "Martínez", "López", "Pérez", "Sánchez", "Gómez", "Díaz",
            "Moreno", "Fernández" };

    private String nombreCompleto;
    private int numeroComensales;
    private final int NUMERO_MINIMO_COMENSALES = 1;
    private final int NUMERO_MAXIMO_COMENSALES = 10;

    private int hora;
    private final int HORA_MINIMA = 13;
    private final int HORA_MAXIMA = 16;

    private int minuto;
    private final int MINUTO_MINIMO = 0;
    private final int MINUTO_MAXIMO = 60;

    public void generarCliente() {
        Random aleatorio = new Random();

        String nombreAleatorio = nombres[aleatorio.nextInt(nombres.length)];
        String apellidoAleatorio = apellidos[aleatorio.nextInt(apellidos.length)];
        this.nombreCompleto = nombreAleatorio + " " + apellidoAleatorio;

        numeroComensales = aleatorio.nextInt(NUMERO_MAXIMO_COMENSALES - NUMERO_MINIMO_COMENSALES + 1)
                + NUMERO_MINIMO_COMENSALES;

        hora = aleatorio.nextInt(HORA_MAXIMA - HORA_MINIMA + 1) + HORA_MINIMA;

        minuto = aleatorio.nextInt(MINUTO_MAXIMO);

        System.out.println("NUEVO CLIENTE" + "||" + "nombre: " + nombreCompleto + "||" + "numero de comensales: "
                + numeroComensales + "||" + "hora: " + hora + " : " + minuto);
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public int getNumeroComensales() {
        return numeroComensales;
    }

    public void setNumeroComensales(int numeroComensales) {
        this.numeroComensales = numeroComensales;
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public int getMinuto() {
        return minuto;
    }

    public void setMinuto(int minuto) {
        this.minuto = minuto;
    }
}
