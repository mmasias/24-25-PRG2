Universidad u = new Universidad("UNEAT");
Asignatura a = u.crearAsignatura("PGR 2");
Profesor p1 = u.contratarProfesor("Ibuprofeno del Jesús Fernández Gómez de la Piedra y Cansado");
p1.impartirAsignatura(a);
Examen ex = p1.crearExamen();
Profesor p2 = u.contratarProfesor("Dalay Piedad de los Remedios Albornoz del Campo");
p1.entregarExamenA(ex, p2);

System.out.println("Universidad: " + u.getNombre());
