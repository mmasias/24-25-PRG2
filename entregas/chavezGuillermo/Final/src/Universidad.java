class Universidad{
    public Asignatura[] asignaturas;
    public Profesor[] profesores;
    
    public Universidad{
        asignaturas=new Asignatura[1];
        asignaturas[0]=new Asignatura("Matematica");
        profesores=new Profesor[2];
        profesores[0]=new Profesor("Guillermo Chavez",true,"null");
        profesores[1]=new Profesor("Jonathan Doberic",false,"null");
    }

         
    public void gerencia{
        profesores[0].asignar(asignaturas[0]);
        profesores[0].hacerExamen();
        profesores[0].entregarExamen();
    }
}