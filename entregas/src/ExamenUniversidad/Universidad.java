package 24-25-PRG2.entregas.src.ExamenUniversidad;

public class Universidad {
    String centroUniversitario;
    String asignatura;
    Profesor[] profesores;

    public Universidad() {
        this.centroUniversitario = "Universidad Europea del Atlántico";
        this.asignatura = "PRG2";
    }

    public void setProfesores(Profesor[] profesores) {
        this.profesores = profesores;
    }

    public void crear() {
        System.out.println("Universidad: " + centroUniversitario);
    }

    public void creaAsignatura() {
        System.out.println("Asignatura: " + asignatura);
    }

    public void contrataProfesores() {
        System.out.println(profesores[0] + " es el profesor contratado para crear el examen y " + profesores[1] + " lo corregirá.");
    }

}