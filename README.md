# Examen Final Programación 2

Durante el desarrollo del examen (a papel y boli), asumí que con solo cuatro clases (`Universidad`, `Profesor`, `Asignatura`, `ProfesorExterno`) sería suficiente para resolver el problema. Sin embargo, mientras iba escribiendo, me di cuenta de que esa estructura se me quedaba corta para modelar correctamente todo lo que se pedía.

Por ejemplo, faltó una clase `Examen` que represente de forma independiente el examen con sus preguntas y la asignatura a la que pertenece. Esto habría permitido separar responsabilidades y evitar que la clase `Profesor` tuviera que manejar cosas que no le correspondían directamente. También se habría podido incluir una clase `Pregunta`, en lugar de usar un simple array de `String`, para hacer que cada pregunta fuese un objeto con su propia lógica o formato.

Si el diseño hubiese sido más flexible, podrían haberse usado otras clases como:

- `Examen`: para manejar título, asignatura y preguntas.
- `Pregunta`: para encapsular el contenido de cada pregunta.
- `Vigilancia` : para representar la relación entre el examen y el profesor externo que lo vigila.

También pude haber creado constructores adicionales, por ejemplo:

- Un constructor para `Profesor` que ya reciba la asignatura directamente.
- Un constructor para `Examen` con las tres preguntas ya cargadas.
- Un constructor para `Pregunta` con el texto como parámetro.

Esto me habría permitido construir objetos de manera más limpia y directa desde el `main` o desde `Universidad`.

Tengo que practicar más, ya sea con diagramas UML para tener un pensamiento más abierto y entender mejor la vista pública y los objetos.
