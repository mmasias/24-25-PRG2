# EXAMEN FINAL

### Errores Parte 1 y Parte 2: 

- El DNI lo he puesto como int y deberia ser string por tener una letra al final.

        private String dni;

- Falta de atributos como examenVigilado

        public Examenes getExamenVigilado() {
            return examenVigilado;
        }
- Falta de metodos como puedeVigilar o vigilarExamen

        public boolean puedeVigilar() {
            return asignatura == null;
        }
- Modificar nombres

        public void asignarProfesores(Profesores p1, Profesores p2) {
            this.profesor1 = p1;
            this.profesor2 = p2;
        }
        
### [Parte 3: vista privada de clases y objetos](entregas/maderoCarla/src)
