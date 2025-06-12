class Examen{
    private String nombreExamen;
    private Profesor profesorVigilando;
    private String[] preguntas = new String[3];

    public Examen(String nombreExamen, Profesor profesorVigilando, String[] preguntas){
        this.nombreExamen = nombreExamen;
        this.profesorVigilando = profesorVigilando;
        this.preguntas = preguntas;
    }

    public void DarPreguntas(){
        for (String pregunta : preguntas) {
            System.out.println(pregunta);
        }
    }

    

}