package entregas.masiasManuel.reto004;

import entregas.romeroLeslie.reto004.Fraccion;

public class ClienteFraccion {
    public static void main(String[] args) {

        
         System.out.print("Constructor & .toString(): ");
         Fraccion fraccion = new Fraccion(2, 3);
         System.out.println(fraccion);
         System.out.println("Numerador:   [" + fraccion.numerador() + "]");
         System.out.println("Denominador: [" + fraccion.denominador() + "]");
         
         System.out.print("Sumar: ");
         System.out.println(fraccion.sumar(new Fraccion(2,3)));
         System.out.println(fraccion.sumar(3));
         
         System.out.print("Oponer: ");
         System.out.println(new Fraccion(2,3).oponer());
         
         System.out.print("Restar: ");
         System.out.println(fraccion.restar(new Fraccion(2,3)));
         System.out.println(fraccion.restar(1));
         
         System.out.print("Multiplicar: " );
         System.out.println(fraccion.multiplicar(new Fraccion(2, 3)));
         System.out.println(fraccion.multiplicar(2));
        
         System.out.print("Invertir: ");
         System.out.println(fraccion.invertir());
         
         System.out.print("Dividir: ");
         System.out.println(fraccion.dividir(new Fraccion(2, 3)));
         System.out.println(fraccion.dividir(3));
         
         System.out.print("Elevar: ");
         System.out.println(fraccion.elevar(3));
         
         System.out.print("Es mayor: ");
         
         System.out.println(fraccion.esMayor(new Fraccion(2, 3)));
         
         System.out.print("Es menor: ");
         System.out.println(fraccion.esMenor(new Fraccion(2, 3)));
         
         System.out.print("Es igual: ");
         System.out.println(fraccion.esIgual(new Fraccion(2, 3)));
         
         System.out.print(".compareTo(): ");
         System.out.println(fraccion.compareTo(new Fraccion(2, 3)));
         
         System.out.print("valueOf(): ");
         System.out.println(fraccion.valueOf());
        
         System.out.print("clone(): ");
         System.out.println(fraccion.clone());
         
    }
}
