class Profesor {
    String nombreUnversidad;
    String apellido;
    String Dni;
    Asignatura asignatura;
    Examen examenCreado;

    public Profesor(String nombreUnversidad, String apellido, String dni) {
        this.nombreUnversidad = nombreUnversidad;
        this.apellido = apellido;
        this.Dni = dni;
    }

    Examen crearExamen() {
        if (asignatura == null) {
            System.out.println("No se puede crear examen sin asignatura.");
            return null;
        }
        examenCreado = new Examen("Examen Final");
        return examenCreado;
    }

    void darExamen(Profesor vigilante) {
        if (vigilante.asignatura == null && examenCreado != null) {
            examenCreado.vigilante = vigilante;
        }
    }
}



