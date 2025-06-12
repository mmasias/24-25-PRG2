package entregas.uretaAaron;
public class Profesor {
        private String nombre;
        private String dni;
        private Asignatura asignatura;
        private String[] examen;
        private int cantidadPreguntas;
        private ProfesorExterno vigilante;
    
        public Profesor(String nombre, String dni) {
            this.nombre = nombre;
            this.dni = dni;
            this.examen = new String[3];
            this.cantidadPreguntas = 0;
        }
    
        public void asignarAsignatura(Asignatura asignatura) {
            this.asignatura = asignatura;
        }
    
        public void crearExamen() {
            if (asignatura != null) {
                agregarPregunta("Vista pública de clases");
                agregarPregunta("Vista pública de objetos");
                agregarPregunta("Vista privada de clases");
            } else {
                System.out.println("No puede crear examen, no imparte asignatura");
            }
        }
    
        private void agregarPregunta(String pregunta) {
            if (cantidadPreguntas < 3) {
                examen[cantidadPreguntas] = pregunta;
                cantidadPreguntas++;
            }
        }
    
        public void entregarExamen(ProfesorExterno externo) {
            if (asignatura != null && cantidadPreguntas == 3 && !externo.vigilaAsignatura()) {
                externo.importarExamen(examen);
                this.vigilante = externo;
            }
        }
    
        public void imprimirInformacion() {
            System.out.println("PROFESOR: " + nombre + " / DNI: " + dni);
            if (asignatura != null) {
                System.out.print("ASIGNATURA: ");
                asignatura.imprimirInformacion();
            }
            if (vigilante != null) {
                System.out.println("EXAMEN: EXAMEN FINAL: VIGILADO POR " + vigilante.getNombre() + " / DNI: " + vigilante.getDni());
                for (int i = 0; i < cantidadPreguntas; i++) {
                    System.out.println("PREGUNTA " + (i + 1) + ": " + examen[i]);
                }
            }
        }
    }

