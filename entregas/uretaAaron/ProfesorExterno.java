package entregas.uretaAaron;

public class ProfesorExterno {
        private String nombre;
        private String dni;
        private String[] examenVigilado;
        private boolean vigila;
    
        public ProfesorExterno(String nombre, String dni) {
            this.nombre = nombre;
            this.dni = dni;
            this.vigila = false;
        }
    
        public void importarExamen(String[] examen) {
            this.examenVigilado = examen;
            this.vigila = true;
        }
    
        public boolean vigilaAsignatura() {
            return vigila;
        }
    
        public String getNombre() {
            return nombre;
        }
    
        public String getDni() {
            return dni;
        }
    }

