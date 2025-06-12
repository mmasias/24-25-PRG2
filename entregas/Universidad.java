public class Universidad {
    private String nombre;

    public Universidad(String nombre) {
        this.nombre = nombre;
        System.out.println("Universidad creada: " + nombre);
    }

    public Profesor ContratarProfesor(String nombre) {
        System.out.println("Contratando al profesor: " + nombre);
        return new Profesor(nombre);
    }

    public static void main(String[] args) {
        Universidad universidad = new Universidad("Universidad Europea del Atlántico");

        Profesor ibuprofeno = universidad.ContratarProfesor("Ibuprofeno del Jesús Fernández Gómez de la Piedra y Cansado");
        Profesor dalsy = universidad.ContratarProfesor("Dalsy Piedad de los Remedios Albornoz del Campo");

        ibuprofeno.crearAsignatura("Programación 2 - PRG - 6 créditos");

        Asignatura poo = new Asignatura("Programación 2 - PRG - 6 créditos");
        ibuprofeno.AsociarAsignatura(poo);

        Examen examen = ibuprofeno.CrearExamen();

        if (examen != null) {
            poo.AsociarExamen(examen);
            ibuprofeno.EntregarExamen(examen, dalsy);
        }
    }
}
    
