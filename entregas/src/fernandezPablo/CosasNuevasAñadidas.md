# En la clase Universidad.java he añadido:
 public void gestionarExamen() {
        examen = profesores[0].crearExamen();
        profesores[0].entregar(examen);
        profesores[1].vigilar(examen);
    }

# En la clase Profesor.java he añadido:
 public String getNombre() {
        return nombre;
    }

# En la clase Examen.java he añadido:
 public String[] getPreguntas() {
        return preguntas;
    }