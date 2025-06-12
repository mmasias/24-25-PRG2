# README – Diferencias entre la Parte 1-2 y el Reto Final
Este informe resume las principales variaciones entre el planteamiento manual llevado a cabo a lo largo del examen (Partes 1 y 2) y la implementación codificada en Java al final.

En el primer diseño, se postulaba un modelo en que la clase Universidad era la controladora principal del escenario. A través de operaciones como añadirAsignatura() o mostrarEscenario(), centrábamos las comunicaiones entre asignaturas, profes, y exámenes. Todas las clases contaban con métodos públicos verbales, centrándonos en la encapsulación sin regalar detalles internos (sacando vida en la Parte 3).

En su lugar, el código implementado reordena la organización alrededor de una clase específica llamada EscenarioFinal, que contiene toda la lógica de presentación y preparación de los datos. La clase actúa como fachada y orquestadora del sistema.

Otra diferencia importante es el hecho de utilizar un enum Pregunta en la solución definitiva, que permite representar más expressivamente las preguntas del examen, incluyendo como sí llevan o no espacio ante los dos puntos. En la implementación escrita, por su parte, las preguntas están presentes como cadenas literal directas.

También se destaca la implementación de un clase abstracta Persona, que es heredada por Profesor y Vigilante, promoviendo reutilización y simplificación del código. Ese acercamiento no había sido explícitamene planificado en la Parte 1, en que cada clase era implementada por su cuenta al no haber herencia.

Finalmente, la clase Console se ha dejado como parte independiente para agrupar toda la impresión por consola, pero en la implementación correspondiente se ha manejado mediante un patrón singleton (Console.getInstance()), mejorando el control sobre la impresión. En resumen, el código final es más robusto, más modular, y alinea más con el enfoque de diseño jerárquico descendente (HOOD) requerido por el profesor. La refactorización de clases, el uso de enum y el uso de herencia lo hacen más que justificable que evolucione del diseño original hasta ser más profesional y mantenible.







