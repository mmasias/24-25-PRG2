package entregas.delaasuncionJose.Final;

public class Universidad {
    private String nombre;
    private Profesor[] profesores = new Profesor[2];
    private Asignatura[] asignaturas = new Asignatura[1];
    public Universidad(String nombre) {
        this.nombre = nombre;
        asignaturas[0] = new Asignatura("Programacion II",6);
        profesores[0] = new Profesor("Rigoberto Disousa","29021955A",new Asignatura[] {asignaturas[0]});
        profesores[0].escribirExamen(asignaturas[0]);
        profesores[1] = new Profesor("Paquito Paco", "88161724X", null);
        profesores[1].vigilar(profesores[0].pasarExamen());
    }

    public void mostrar() {
        System.out.println("Universidad: " + nombre);
        for (Profesor profesor : profesores) {
            profesor.mostrar();
        }
    }
}
