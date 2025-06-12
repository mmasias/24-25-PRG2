# Final Progra

El metodo iniciar solo se indico en Main, no en universidad.
La clase examen al final no extiende de ninguna otra.

## Resumen

En definitiva, el main instancia a Universidad, esta se encarga de todas las operaciones y metodos necesarios, las clases profesor, asignatura y Examen no poseen metodos, unicamente un constructor parametrizado además de lso getters y setter.

### ¿Cómo funciona?
Constructor
```java
public Examen(String Preguntas[], int NumeroPreguntas) {
        this.Preguntas = Preguntas;
        this.NumeroPreguntas = NumeroPreguntas;
        this.tipoExamen = "Examen Final";
    }
```

### Asignatura

Constructor in parametros
```java
public Asignatura(){
        this.Name = "";
        this.Creditos = 0;
        this.Profesor = new Profesor[2];
    }
```

### Profesor
Constructor
```java
public Profesor(String Name, String DNI) {
        this.Name = Name;
        this.DNI = DNI;
    }
```

### Universidad
Constructor
```java
public Universidad(String nombre) {
        this.nombre = nombre;
        this.profesores = new Profesor[2];
    }
```
Metodo iniciar, se encarga de la logica del programa y muestra el resultado (podria manejarse en otro método llamado mostrar)
```java
public void iniciar() {
        profesores[0] = new Profesor("Juan Pérez", "12345678A");
        profesores[1] = new Profesor("Ana López", "87654321B");

        asignatura = new Asignatura();
        asignatura.setName("Programación II");
        asignatura.setCreditos(6);

        Profesor[] ids = {profesores[0]};
        asignatura.setProfesor(ids);

        String[] preguntas = {
            "¿Qué es una clase en Java?",
            "Explica el concepto de herencia.",
            "¿Para qué sirve una interfaz?"
        };
        examen = new Examen(preguntas, preguntas.length);

        System.out.println("Profesor que imparte: " + profesores[0].getName() + " con DNI " + profesores[0].getDNI());
        System.out.println("Asignatura: " + asignatura.getName() + " con " + asignatura.getCreditos() + " créditos.");
        System.out.println("Examen:" + examen.getTipoExamen());
        System.out.println("Vigilado por: " + profesores[0].getName() + " con DNI " + profesores[0].getDNI());
        System.out.println("Pregunta 1: " + examen.getPreguntas()[0]);
        System.out.println("Pregunta 2: " + examen.getPreguntas()[1]);
        System.out.println("Pregunta 3: " + examen.getPreguntas()[2]);
    }
```

### Main
Instncia a universidad
```java
Universidad universidad = new Universidad("Universidad Europea del Atlántico");
        universidad.iniciar();
```
