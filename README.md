# 👨‍💻 Programación II · Proyecto Entrega

Repositorio de entrega para el proyecto de la asignatura **Programación II** del [Grado en Ingeniería Informática](https://www.uneatlantico.es/escuela-politecnica-superior/estudios-grado-oficial-en-ingenieria-informatica) en la [Universidad Europea del Atlántico](https://www.uneatlantico.es).


### 📁 [Examen](entregas/src)

Contiene las siguientes clases:

- **`Asignatura.java`**  
  Define el objeto `Asignatura` con su nombre. Es la materia asignada al profesor. En el examen con los nervios se me olvido explicarla, pero si que esta la creacion de esta en el apartado de universidad

- **`Examen.java`**  
  Clase que contiene un conjunto de preguntas y la asignatura correspondiente. 

- **`Profesor.java`**  
  Define al profesor: su nombre, DNI, asignatura que imparte, y el examen que puede crear o vigilar. Controla la entrega del examen a otro profesor para su vigilancia. Aqui mi problema fue que se me olvido poner el metodo de ue a la hora de hacer el examen sea teniendo en cuanta la asignatura que se le ha asignado 

- **`Universidad.java`**  
  Simula la institución. Encargada de dirigir el proceso de creación y vigilancia de un examen con los objetos anteriores.

- **`Main.java`**  
  Punto de entrada de la aplicación. Crea una universidad y ejecuta el proceso completo (asignación, creación y vigilancia del examen). No puse la existencia de ella pensado que era un dato que se sabia de normal, fallo mio cuando siempre nos dices que tenemos que explicarlo como si no supieras nada de nada.


## 📋 Ejemplo de salida por consola

```text
Universidad: Universidad Nacional de Ingeniería
Profesor: Laura Martínez (12345678A)
Asignatura: Programación Orientada a Objetos
Examen final
Vigilado por: Carlos Pérez (87654321B)
Pregunta 1: ¿Qué es la encapsulación en POO?
Pregunta 2: ¿Diferencia entre herencia y composición?
Pregunta 3: Explica el principio de responsabilidad única.

