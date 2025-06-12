package LomoJaime;

public class Universidad {
    private String nombre;

    public Universidad(String nombre) {
        this.nombre = nombre;
    }

    public void ejecutarProceso() {
      
        Asignatura asignatura = new Asignatura("Programación Orientada a Objetos");

   
        Profesor profesorCreador = new Profesor("Laura Martínez", "12345678A");
        profesorCreador.asignarAsignatura(asignatura);
        profesorCreador.crearExamen();

        
        Profesor profesorVigilante = new Profesor("Carlos Pérez", "87654321B");

       
        profesorCreador.entregarExamen(profesorVigilante);

        
        System.out.println();
        System.out.println("Universidad: " + nombre);
        System.out.println("Profesor: " + profesorCreador);
        System.out.println("Asignatura: " + asignatura.getNombre());
        System.out.println("Examen final");
        System.out.println("Vigilado por: " + profesorVigilante);
        profesorVigilante.mostrarExamenVigilado();
    }
}

