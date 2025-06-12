class Asignatura { 
    private String nombre;
    private int creditos;
    private String nombreCorto;


    public Asignatura(String nombre, int creditos, String nombreCorto){
        this.nombre = nombre;
        this.creditos = creditos;
        this.nombreCorto = nombreCorto;
    }

    public String Titulo(){
        return nombre + " - " + nombreCorto +  " - " + creditos + " creditos";
    }
    
}
