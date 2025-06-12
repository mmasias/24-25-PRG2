class Examen{
    private String nombreExamen;
    private Profesor profesorVigilando;
    private String[] preguntas = new String[3];

    public Examen(String nombreExamen, Profesor profesorVigilando, String[] preguntas){
        this.nombreExamen = nombreExamen;
        Vigilar(profesorVigilando);
        this.preguntas = preguntas;
    }

    public String NombreExamen(){
        return nombreExamen;
    }

    public String ProfesorVigilando(){
        return profesorVigilando.Nombre();
    }

    public void DarPreguntas(){
        for (String pregunta : preguntas) {
            System.out.println(pregunta);
        }
    }

    private void Vigilar(Profesor profesor){
        this.profesorVigilando = profesor;
        assert profesor.Imparte() == true;
    }

}