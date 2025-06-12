En la clase Universidad.java he añadido esto:
 public void gestionarExamen() {
        examen = profesores[0].crearExamen();
        profesores[0].entregar(examen);
        profesores[1].vigilar(examen);
    }

En la clase Profesor.java he añadido esto:
 public String getNombre() {
        return nombre;
    }