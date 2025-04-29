# Rúbrica

## 1. Obtención de solución inicial (15%)

|Nivel|Descripción|
|-|-|
|Bien|Formuló una (o varias) consulta(s) clara(s) y específica(s) al modelo, obteniendo una solución inicial completa y funcional. Documentó la consulta realizada y explicó su razonamiento para formularla así.|13-15|
|Incompleto|Obtuvo una solución funcional pero la consulta pudo ser más específica. Documentación básica de la interacción con el modelo.|10-12|
|Mal|La solución obtenida es incompleta o tiene errores significativos debido a una consulta ambigua. Documentación mínima.|6-9|
|Nada|No logró obtener una solución útil o no documentó el proceso de obtención.|0-5|

## 2. Crítica formal de la solución propuesta por el modelo (25%)

|Nivel|Descripción|
|-|-|
|Bien|Identifica con precisión cómo la solución implementa o viola los conceptos fundamentales vistos en clase (abstracción, encapsulamiento, modularización, vistas públicas/privadas). Señala problemas específicos con ejemplos concretos del código y propone alternativas conceptuales.|21-25|
|Incompleto|Identifica la mayoría de los aspectos relevantes en el diseño e implementación según los conceptos vistos en clase, con algunos ejemplos concretos.|16-20|
|Mal|Identifica problemas superficiales pero no profundiza en cómo se relacionan con los conceptos fundamentales vistos en clase.|10-15|
|Nada|Crítica superficial sin identificación clara de conceptos fundamentales.|0-9|

## 3. Contextualización con conceptos de clase (30%)

|Nivel|Descripción|
|-|-|
|Bien|Relaciona explícitamente la solución con conceptos específicos vistos en clase como: vistas públicas y privadas de clases/objetos, definición de atributos, referencias a objetos, paso de mensajes, constructores, referencia this, etc. Cita ejemplos concretos del código para cada concepto y relaciona cómo estos conceptos contribuyen a la calidad del diseño orientado a objetos.|25-30|
|Incompleto|Establece conexiones válidas entre el código y los conceptos específicos vistos en clase, aunque algunas relaciones podrían ser más detalladas.|19-24|
|Mal|Menciona algunos conceptos vistos en clase, pero las conexiones con el código son superficiales o incompletas.|12-18|
|Nada|Escasa o incorrecta relación entre el código y los conceptos teóricos específicos vistos en clase.|0-11|

## 4. Refactorización justificada (30%)

|Nivel|Descripción|
|-|-|
|Bien|Implementa cambios que mejoran notablemente el diseño aplicando correctamente los conceptos fundamentales vistos en clase. Justifica cada modificación explicando cómo mejora la implementación de estos conceptos. La solución refactorizada muestra un código limpio, con adecuado reparto de responsabilidades y clara gestión de estados.|25-30|
|Incompleto|Realiza mejoras importantes con justificaciones adecuadas basadas en los conceptos vistos en clase. La solución final representa una mejora clara sobre la original en términos de claridad y estructura.|19-24|
|Mal|Implementa algunos cambios positivos pero mantiene problemas en la aplicación de conceptos básicos. Justificaciones correctas pero incompletas.|12-18|
|Nada|Cambios mínimos o inadecuados. Justificaciones ausentes o no relacionadas con los conceptos del curso.|0-11|

## Conceptos específicos a evaluar según el temario

|Mecanismos para abordar sistemas complejos|Clases y objetos|Elementos de implementación|
|-|-|-|
|Abstracción|Vista pública de las clases (interfaz)|Definición adecuada de atributos (privados)|
|Encapsulación|Vista privada de las clases (implementación)|Implementación de constructores|
|Modularización|Vista pública de los objetos (creación, referencia, interacción)|Uso correcto de la referencia this|
|Jerarquización|Vista privada de los objetos (desencadenamiento de instanciaciones y mensajes)|Definición e implementación de métodos públicos y privados|
|||Manejo de referencias y paso de mensajes|

## Formato para la entrega

1. **README.md**:
   - Descripción del problema
   - Enlace a la sesión con el modelo de lenguaje utilizada para generar la solución propuesta por el modelo de lenguaje.
   - Enlace a la crítica formal
   - Enlace a los conceptos aplicados para la refactorización
   - Enlace a la solución refactorizada
   - Reflexión final sobre el proceso
1. **Códigos en /src**:
   - Solución original generada por el modelo de lenguaje
   - Solución refactorizada
     - Proceso de refactorización ***adecuadamente comentado***
1. **Documentación adicional en /documents**:
   - Crítica formal: análisis detallado de la solución de la IA.
   - Conceptos aplicados en la refactorización
   - Diagramas que ilustren la estructura de clases (opcional pero recomendado)
   - Comparativa visual entre la solución original y la refactorizada (si aplica)
