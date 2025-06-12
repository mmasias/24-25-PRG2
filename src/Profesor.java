class Profesor {
    private String nombre;
    private String dNI;
    private Asignatura asignatura;
    private boolean imparte;

    public Profesor(String nombre, String dNI, Asignatura asignatura){
        this.nombre = nombre;
        this.dNI = dNI;
        this.asignatura = asignatura;
        imparte = asignatura != null ? true : false;
    }

    public String Datos(){
        return nombre + " / " + dNI;
    }

    public boolean Imparte(){
        return imparte;
    }

}
