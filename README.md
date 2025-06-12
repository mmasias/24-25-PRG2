# Sistema de Universidad en Java

##  Clases del sistema

### 1. Universidad
```java
public class Universidad
```
- Representa a la universidad.
- Tiene como atributo su nombre.
- Se crea con un constructor que recibe el nombre de la universidad.

### 2. Asignatura 
```java
public class Asignatura
```
- Representa una materia académica.

Contiene:

 - Nombre de la asignatura.

 - Créditos que vale (Me había Faltado)

- Se usa para asignar al profesor que crea el examen.


### 3. Examen
```java
public class Examen
```
Contiene:

- Tipo de examen: Parcial o Final (Me había faltado)

- Asignatura asociada

- Lista de 3 preguntas 

### 4. Profesor
```java
public class Profesor
```
Contiene:

- Nombre y DNI. (Me había faltado el DNI)

- Una asignatura (si imparte clase).

- Estado de vigilante y el examen que vigila.

Métodos principales:

- crearExamen(): Crea un examen si el profesor tiene asignatura y no es vigilante.

- vigilarExamen(): Permite asignar al profesor como vigilante si no tiene asignatura.

Este método le había puesto otro nombre
- asignarAsignatura(): Asigna una materia al profesor si no es vigilante.

Este método lo había puesto en la clase incorrecta
- entregarExamen(): Permite al profesor de la asignatura entregar el examen a otro profesor vigilante, actualizando los datos.