# Exame final Progarmación 2

Este proyecto simula un sistema universitario básico utilizando programación orientada a objetos en Java. Se representan entidades como universidades, profesores, asignaturas y exámenes, y se gestionan sus relaciones.

##  Estructura del Proyecto

El código se encuentra dentro del paquete `martinezDiego.Final`, con las siguientes clases:

---

### `App.java`

```java
public static void main(String[] args) {
    Universidad universidad = new Universidad();
    universidad.imprimirDatos();
}
```
Función:
Es el punto de entrada del programa.
➡️ Crea una universidad y llama a imprimirDatos().



### `Universidad.java`

```java
public class Universidad {

    private String nombre = "Universidad Europea del Atlántico";

    Asignatura asignatura = new Asignatura("Estructura de datos y algoritmos", 4, "EDA");
    Asignatura asignatura2 = new Asignatura("lenguajes de programacion", 4, "LP");

    Profesor profesor = new Profesor("manuel", 3564636, asignatura.getNombreCorto());
    Profesor profesor2 = new Profesor("ibuprofeno", 356, asignatura2.getNombreCorto());

    public void gestionarAsignaturas() {

    }

    public void imprimirDatos() {

        System.out.println("Universidad: " + nombre);
        System.out.println("Profesor: " + profesor.getNombre());
        System.out.println("Asignatura de  " + profesor.getNombre() + " -> " + profesor.getAsignatura() + "||"
                + " creditos: " + asignatura.getCreditos());
        System.out.println("Examen: " + profesor.examen1.getTipo());
        System.out.println("Vigilado por: " + profesor.asignarExamen(profesor2));
        System.out.println("Preguntas: " + profesor.examen1.getPreguntas());

    }

}
```
Función:
Representa la universidad.
➡️Contiene profesores y asignaturas.
➡️ Muestra los datos generales (nombre, profesor, asignatura, examen, vigilante...).

### `Asignatura.java`

```java
package martinezDiego.Final;

public class Asignatura {

    private String nombre;
    private int creditos;
    private String nombreCorto;

    public void asignarProfesor() {

    }

    public Asignatura(String nombre, int creditos, String nombreCorto) {
        this.nombre = nombre;
        this.creditos = creditos;
        this.nombreCorto = nombreCorto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public String getNombreCorto() {
        return nombreCorto;
    }

    public void setNombreCorto(String nombreCorto) {
        this.nombreCorto = nombreCorto;
    }

}

```
Función:
Define una asignatura.
➡️ Tiene nombre, créditos y nombre corto.
➡️ Relacionada con profesores.

### `Profesor.java`


```java
package martinezDiego.Final;

public class Profesor {

    private String nombre;
    private int dni;
    private String asignatura;

    Examen examen1 = new Examen("final", "Pregunta 1: vista publica || pregunta 2: vista privada");

    public String asignarExamen(Profesor profesor2) {

        String profesorVigilante = profesor2.getNombre();
        return profesorVigilante;
    }

    public Profesor(String nombre, int dni, String asignatura) {
        this.nombre = nombre;
        this.dni = dni;
        this.asignatura = asignatura;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(String asignatura) {
        this.asignatura = asignatura;
    }

}
```
Función:
Representa un profesor.
➡️ Tiene nombre, DNI, asignatura, y un examen.
➡️ Puede asignar otro profesor como vigilante de examen.

### `Examen.java`

```java
package martinezDiego.Final;

public class Examen {
    
    private String tipo;

    private String preguntas;

    public void creadoPor(){
        
    }

    

    public Examen(String tipo, String preguntas) {
        this.tipo = tipo;
        this.preguntas = preguntas;
    }



    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getPreguntas() {
        return preguntas;
    }

    public void setPreguntas(String preguntas) {
        this.preguntas = preguntas;
    }

    
    
}
```
Función:
Define un examen.
➡️ Tiene tipo (final, etc.) y preguntas.
➡️ Está asociado a un profesor.


### Observaciones: 
Hay metodos sin definir ya que inicialmete los iba a utilizar para pasar datos de un objeto a otro pero una vez programando no me hicieron falta.









