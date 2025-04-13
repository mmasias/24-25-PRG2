package entregas.Restaurante;

import java.util.Scanner;

public class Gestion {

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

        Mesas[][] mesa = new Mesas[4][4];
        int contadorMesas = 01;

        for (int i = 0; i < mesa.length; i++) {
            for (int j = 0; j < mesa[i].length; j++) {
                mesa[i][j] = new Mesas();
                mesa[i][j].setNumeroMesa(contadorMesas);
                mesa[i][j].setOcupada(false);
                contadorMesas++;

                if (contadorMesas <= 7) {
                    mesa[i][j].setLugarMesa("terraza");
                    mesa[i][j].setCapacidadeMesa(2);
                    System.out.print("MT" + mesa[i][j].getNumeroMesa() + "||");
                } else {
                    mesa[i][j].setLugarMesa("interior");
                    mesa[i][j].setCapacidadeMesa(6);
                    System.out.print("MI" + mesa[i][j].getNumeroMesa() + "||");
                }
                
            }
            System.out.println();
        }

    }

}
