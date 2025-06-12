# Estructurando el universo de código

## ¿Por qué?

||||
|-|-|-|
|A medida que un proyecto de software crece, la organización del código se vuelve cada vez más desafiante. Se enfrentan problemas como la proliferación de clases, la dificultad para encontrar componentes específicos, y las colisiones de nombres entre elementos que cumplen funciones similares pero en contextos diferentes. |La complejidad aumenta exponencialmente cuando múltiples desarrolladores trabajan en el mismo código base, y la falta de una estructura clara dificulta el mantenimiento, la reutilización y la comprensión del sistema.|Además, sin una forma de agrupar lógicamente las clases relacionadas, se vuelve imposible aplicar diferentes niveles de visibilidad o controlar adecuadamente qué partes del código son accesibles desde diferentes secciones del programa.

## ¿Qué?

La organización jerárquica del código es un enfoque que permite agrupar elementos relacionados bajo una estructura lógica de espacios de nombres. Este concepto introduce la idea de contenedores o directorios lógicos que pueden anidarse, formando un árbol de componentes relacionados. Cada espacio de nombres proporciona un contexto único para los elementos que contiene, permitiendo que elementos con nombres idénticos coexistan en diferentes espacios sin conflictos. Esta organización facilita también el establecimiento de barreras de acceso y la implementación de principios fundamentales de la programación orientada a objetos como la modularidad, la encapsulación y la abstracción.

## ¿Para qué?

La implementación de una estructura jerárquica de código ofrece múltiples beneficios:

|||
|-|-|
|Claridad organizativa|Se facilita la navegación y localización de componentes específicos dentro de una base de código extensa.|
|Prevención de conflictos de nombres|Al proporcionar espacios de nombres separados, se evitan colisiones entre clases que comparten el mismo nombre pero pertenecen a diferentes contextos funcionales.|
|Control de acceso granular|Se permite definir qué elementos son visibles fuera de su grupo lógico y cuáles permanecen como detalles de implementación internos.|
|Reutilización mejorada|La agrupación lógica facilita la identificación y reutilización de componentes relacionados en diferentes proyectos.|
|Distribución simplificada|Se puede empaquetar y distribuir grupos coherentes de funcionalidad como bibliotecas independientes.|
|Trabajo en equipo efectivo|Los equipos pueden trabajar en diferentes áreas del sistema con menor riesgo de interferencia.|

## ¿Cómo?

En Java, esta organización se implementa mediante el sistema de paquetes. Un paquete es un mecanismo que proporciona un espacio de nombres para organizar clases e interfaces relacionadas.

Para declarar una clase dentro de un paquete:
```java
package org.uneatlantico.matematicas;

public class Calculadora {
    // Implementación de la clase
}
```

En el sistema de archivos, la estructura de paquetes se refleja directamente en la jerarquía de directorios:

```
proyecto/
  └── src/
      └── com/
          └── uneatlantico/
              └── matematicas/
                  └── Calculadora.java
```

<div align=center>

|Para utilizar clases de otros paquetes|Para importar todas las clases de un paquete|
|-|-|
|`import com.uneatlantico.matematicas.Calculadora;`|`import com.uneatlantico.matematicas.*;`|

</div>

### Dos propuestas alternativas

<div align=center>
<table>
<tr><th></th><th></th></tr>
<tr><td valign=top>

```
src/
  ├── com/
  │   └── uneatlantico/
  │       ├── utils/
  │       │   └── Calculadora.java
  │       └── cliente/
  │           └── ClienteCalculadora.java
  └── README.md
```
</td><td valign=top>

```
src/
  ├── clases/
  │   └── Calculadora.java
  ├── aplicacion/
  │   └── ClienteCalculadora.java
  └── README.md
```
</td></tr>
</table>
</div>

Al diseñar una estructura de paquetes eficaz, deben seguirse estas prácticas:

1. Los nombres de paquetes deben ser en minúsculas
1. Se recomienda seguir la convención de dominio inverso (com.empresa.proyecto)
1. La agrupación debe basarse en funcionalidad o dominio, no en tipo de componente
1. La jerarquía debe reflejar relaciones lógicas significativas
1. Es importante minimizar las dependencias entre paquetes

Los niveles de acceso en Java interactúan con los paquetes:

- `public`: Accesible desde cualquier lugar
- `protected`: Accesible dentro del mismo paquete y subclases
- Sin modificador (default): Accesible solo dentro del mismo paquete
- `private`: Accesible solo dentro de la misma clase

## ¿Y ahora qué?

El dominio del sistema de paquetes en Java constituye solo el inicio para crear código bien organizado. A partir de aquí, puede profundizarse en:

- El sistema de módulos de Java (introducido en Java 9), que extiende el concepto de paquetes
- Principios de diseño como la cohesión alta y el acoplamiento bajo
- Patrones arquitectónicos como la arquitectura por capas, hexagonal o Clean Architecture
- Herramientas de construcción como Maven o Gradle, que facilitan la gestión de dependencias
- Técnicas avanzadas de control de dependencias como la inyección de dependencias

La estructura adecuada del código mediante paquetes establece una base sólida para construir sistemas mantenibles, escalables y comprensibles.
