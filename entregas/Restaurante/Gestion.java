package entregas.Restaurante;

import java.util.Scanner;

public class Gestion {
    private Mesas[][] mesa = new Mesas[4][4];

    public void servicioActivo() {
        simularTiempo();

    }

    public void simularTiempo() {
        Scanner scanner = new Scanner(System.in);
        int hora = 13;
        int minutos = 00;

        final int INTERVALO_MINUTOS = 10;
        final int INTERVALO_HORAS = 1;

        final int HORA_MAXIMA = 16;

        boolean detenerTiempo = false;

        while (!detenerTiempo) {
            scanner.nextLine();

            System.out.println("HORA: " + hora + ":" + minutos);
            gestionarClientes();
            System.out.println();
            System.out.println("Mesas:");
            iniciarMesas();

            minutos = minutos + INTERVALO_MINUTOS;

            if (minutos == 60) {
                hora = hora + INTERVALO_HORAS;
                minutos = 0;
            }
            if (hora == HORA_MAXIMA) {
                detenerTiempo = true;
                System.out.println("FIN");
            }
        }
        scanner.close();

    }

    public void gestionarClientes() {

        Clientes cliente = new Clientes();
        cliente.generarCliente();
        cliente.getNombreCompleto();
        cliente.getHora();
        cliente.getMinuto();
        cliente.getNumeroComensales();

    }

    public void iniciarMesas() {

        int contadorMesas = 1;

        for (int i = 0; i < mesa.length; i++) {
            for (int j = 0; j < mesa[i].length; j++) {
                mesa[i][j] = new Mesas();
                mesa[i][j].setNumeroMesa(contadorMesas);
                mesa[i][j].setOcupada(false);
                contadorMesas++;

                if (contadorMesas <= 7) {
                    mesa[i][j].setLugarMesa("terraza");
                    mesa[i][j].setCapacidaMesa(2);
                    System.out.print("MT" + mesa[i][j].getNumeroMesa() + "||");
                } else {
                    mesa[i][j].setLugarMesa("interior");
                    mesa[i][j].setCapacidaMesa(6);
                    System.out.print("MI" + mesa[i][j].getNumeroMesa() + "||");
                }

            }
            System.out.println();
        }
    }


    public void asignarMesa(){
        
    }

    public void gestionarMesas() {

        boolean mesaAsignada = false;

        for (int i = 0; i < mesa.length; i++) {
            for (int j = 0; j < mesa[i].length; j++) {
                Mesas posicionMesa = mesa[i][j];
            }
        }
    }

}
