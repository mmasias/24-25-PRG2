# Examen Final Programación 2

Durante el desarrollo del examen (a papel y boli), asumí que con solo cuatro clases (`Universidad`, `Profesor`, `Asignatura`, `ProfesorExterno`) sería suficiente para resolver el problema. Sin embargo, mientras iba escribiendo, me di cuenta de que esa estructura se me quedaba corta para modelar correctamente todo lo que se pedía.

Por ejemplo, faltó una clase `Examen` que represente de forma independiente el examen con sus preguntas y la asignatura a la que pertenece. Esto habría permitido separar responsabilidades y evitar que la clase `Profesor` tuviera que manejar cosas que no le correspondían directamente. También se habría podido incluir una clase `Pregunta`, en lugar de usar un simple array de `String`, para hacer que cada pregunta fuese un objeto con su propia lógica o formato.

Si el diseño hubiese sido más flexible, podrían haberse usado otras clases como:

- `Examen`: para manejar título, asignatura y preguntas.
- `Pregunta`: para encapsular el contenido de cada pregunta.
- `Vigilancia` (opcional): para representar la relación entre el examen y el profesor externo que lo vigila.

Por haber limitado el diseño a lo mínimo, terminé mezclando responsabilidades dentro de una sola clase y resolviendo a la fuerza lo que con más tiempo y más clases habría quedado más claro, limpio y mantenible. En resumen, el examen me ayudó a entender lo importante que es planificar bien las clases antes de empezar a escribir, incluso cuando se hace en papel.
