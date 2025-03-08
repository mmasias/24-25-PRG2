# Reto003: Calculadora

## ¿Por qué?

Además de la programación, la organización adecuada del código es fundamental para facilitar la interoperabilidad entre diferentes componentes. Además de la estructura interna (respetar la vista pública de una clase), la estructura de paquetes en Java es fundamental para evitar conflictos de nombres, gestionar la visibilidad de las clases y permitir que el código sea probado de manera sistemática. Es imprescindible mantener una disciplina estricta en la estructura de directorios para que los diferentes módulos de una aplicación puedan encontrarse y comunicarse entre sí correctamente.

## ¿Qué?

El reto consiste en la implementación de la clase respetando la vista publica de la interfaz planteada.

El código debe estar en su sitio, porque será revisado automáticamente:

La estructura que debe ser respetada es la siguiente:

```
24-25-PRG2/
├── entregas/
│   ├── Cliente.java                # NO DEBE SER MODIFICADO
│   ├── apellidoNombre/             # YA DEBERIA EXISTIR
│   │   └── reto003/                # DEBE SER CREADO
│   │       └── Calculadora.java    # DEBE SER IMPLEMENTADO
```

</div>

## ¿Para qué?

La correcta implementación de este reto permite:

1. La evaluación automática del código mediante scripts que dependen de la estructura de paquetes adecuada.
1. La comprensión práctica de cómo diferentes componentes de software pueden interactuar entre sí manteniendo una interfaz común.
1. La introducción a conceptos de pruebas unitarias donde un mismo cliente puede probar diferentes implementaciones que cumplen con la misma interfaz.
1. El aprendizaje de principios fundamentales de diseño como la inversión de dependencias, donde un componente (Cliente) depende de abstracciones (la interfaz de Calculadora) y no de concreciones específicas.

## ¿Cómo?

### Rama de trabajo

Cree la rama de trabajo entrega-003 a partir de la rama que está ubicada en el repositorio de la asignatura mmasias/24-25-PRG2

### Directorios

Dentro de la carpeta `entregas`, en principio su directorio de trabajo ya existe: dentro de ella debe crear `reto003`. Y dento de esta carpeta, crear su clase Calculadora.java. Es decir:

```
24-25-PRG2/entregas/apellidoNombre/reto003/Calculadora.java
```

### Paquetes

Para que ecosistema ubique adecuadamente el archivo `Calculadora.java` es necesario comenzar con la declaración correcta del paquete:

```java
package entregas.apellidoNombre.reto003;
```

Donde `apellidoNombre` es el nombre de su carpeta de trabajo.

Esta declaración debe ser la primera línea del archivo (antes de cualquier import o definición de clase) y debe coincidir **exactamente** con la estructura de directorios donde se encuentra el archivo.

### Implementación

La clase `Calculadora` debe implementar los métodos especificados en la vista pública que se indica a continuación:

### Interfaz pública por implementar

| |Firma del método|Descripción|
|-|-|-|
|✅|`public Calculadora()`|Constructor por defecto que inicializa una calculadora con capacidad para 10 números|
|✅|`public Calculadora(int capacidad)`|Constructor que inicializa una calculadora con la capacidad especificada|
|🔲|`public Calculadora(double valorInicial)`|Constructor que inicializa una calculadora e ingresa un valor inicial|
|🔲|`public Calculadora(double[] valoresIniciales)`|Constructor que inicializa una calculadora con un arreglo de valores iniciales|
|✅|`public void ingresarNumero(double valor)`|Ingresa un número a la calculadora|
|✅|`public String mostrar()`|Devuelve el último valor ingresado o el mensaje de error|
|✅|`public String mostrarTodo()`|Devuelve todos los valores almacenados o el mensaje de error|
|✅|`public void limpiar()`|Reinicia la calculadora, eliminando valores y errores|
|✅|`public void sumar()`|Suma los dos últimos valores ingresados|
|✅|`public void restar()`|Resta el último valor del penúltimo|
|✅|`public void multiplicar()`|Multiplica los dos últimos valores ingresados|
|✅|`public void dividir()`|Divide el penúltimo valor por el último|
|✅|`public void invertir()`|Cambia el signo del último valor ingresado|
|✅|`public void calcularMedia()`|Calcula la media de todos los valores almacenados|
|✅|`public void calcularSumatoria()`|Calcula la suma de todos los valores almacenados|
|🔲|`public void calcularPorcentaje()`|Calcula el porcentaje del penúltimo valor según el último|
|🔲|`public void calcularFactorial()`|Calcula el factorial del último valor|
|🔲|`public void calcularMaximo()`|Devuelve el valor máximo entre los almacenados|
|🔲|`public void calcularMinimo()`|Devuelve el valor mínimo entre los almacenados|
|🔲|`public void sumar(double valor)`|Suma el valor al número en la última posición|
|🔲|`public void restar(double valor)`|Resta el valor al número en la última posición|
|🔲|`public void multiplicar(double valor)`|Multiplica el valor al número en la última posición|
|🔲|`public void dividir(double valor)`|Divide entre el valor al número en la última posición|
|🔲|`public void calcularPorcentaje(double valor)`|Calcula el porcentaje correspondiente a valor al número en la última posición|
|🔲|`public void intercambiar()`|Intercambia de posicion los dos últimos valores ingresados|
|🔲|`public void duplicarNumero()`|Duplica el último valor ingresado|
|🔲|`public void calcularRaizCuadrada()`|Calcula la raíz cuadrada del último valor|
|🔲|`public void calcularFactorial()`|Calcula el factorial del último valor|
|🔲|`public void calcularPotencia()`|Eleva el penúltimo valor al último (similar a elevar)|
|🔲|`public void calcularPotencia(double exponente)`|Eleva el último valor al exponente especificado|

### Comprobación de la implementación

El archivo `Cliente.java` es el que se usará junto con el archivo de scripting para la prueba automatizada. Le puede ser útil revisar su contenido para comprender cómo será utilizada la clase que va a implementar:

```java
package entregas;

import entregas.masiasManuel.reto003.Calculadora;

public class Cliente {
    public static void main(String[] args) {

        Calculadora calculadora = new Calculadora();
        calculadora.ingresarNumero(15);
        calculadora.ingresarNumero(15);
        calculadora.sumar();
        System.out.println(calculadora.mostrarTodo());

        (...)
        (...)
        (...)
    }
}
```

Si quiere usarlo para sus pruebas intermedias puede hacerlo, modificando el import para que apunte a su calculadora. Por ejemplo, si su apellido es "fernandezIbuprofeno", cambie la línea de import a:

```java
import entregas.fernandezIbuprofeno.reto003.Calculadora;
```

Este archivo está diseñado para probar una implementación estándar de la interfaz de Calculadora. Solo recuerde que no debe enviarlo al momento de hacer el pull-request (para esto, no lo incluya en los commits). El archivo Cliente.java original se mantendrá en el repositorio y no debe ser modificado en su versión final.

> **Nota importante:** Asegúrese de que su implementación funcione correctamente con el Cliente proporcionado, ya que este será el punto de entrada para la evaluación automatizada.

### Entrega

Completada la implementación, debe realizarse el pull request a la rama entrega-003 de repositorio de la asignatura. 

Solo se aceptarán:

- Entregas a la rama entrega-003, provenientes de la rama entrega-003
- Que contengan un único archivo
- Que el archivo se llame Calculadora.java
- Que el archivo esté en la ruta adecuada.
