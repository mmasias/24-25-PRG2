# Vista privada de las clases

## Definición de Atributos

- **Datos constantes**
- **Variables de tipos primitivos**
- **Referencias a objetos y/o vectores de objetos**

Se declaran variables y/o constantes de tipos primitivos, referencias a objetos o vectores de éstos, anteponiendo la palabra **private**

En cualquer punto de la implementación de la clase pero lo lógico es **al principio de la declaración de la clase**.

```java
    class <class> {

        private <declaration>
        private <declaration>
        ...
    }
```

```java
    class Calculadora {

        private double[] numeros;
        private int posicionActual;
        private boolean error;
        private String mensajeError;        

    }
```

## Definición de constructores

### Inicialización de los atributos de la clase

Reservado para las tareas de inicialización de los atributos del objeto, evitando la creación de objetos incosistentes

A falta de inicialización explícita, **no recomendado**, se inicializan a valores por defecto, dependiendo de su tipo (0 para tipos numéricos, *false* para el tipo *boolean*, *caracter nulo* para tipo *char* y *null* para referencias);

```java
    class Calculadora {
            
        private double[] numeros;
        private int posicionActual;
        private boolean error;
        private String mensajeError;  

        public Calculadora(int capacidad) {
            numeros = new double[capacidad];
            posicionActual = 0;
            error = false;
            mensajeError = "";
        }

        public Calculadora() {
            this(10);
        }

            ...
    }

```

## Definición de Métodos

### Operaciones con sentencias secuenciales, alternativos, iterativas, expresiones (asignación) y/o de retorno

En cualquier punto de la implementación de la clase, se define el cuerpo de las cabeceras de los métodos acompañándolos de una sentencia secuencial que contiene las declaraciones locales y sentencias que se consideren oportunas

Dentro del cuerpo del método se tiene acceso a los atributos, los parámetros del método y a las declaraciones locales desde las expresiones de la anidación jerárquica de sentencias

La notación punto para el paso de mensajes sirve también para acceder a los atributos de un objeto de la misma clase

```java
    clase <class> {

        public <methodHeader> <sequentialSentence>
        public <methodHeader> <sequentialSentence>
        ...
    }
```

Si el tipo devuelto no es_ void, se determinará el valor devuelto por el método con la siguiente sentencia:

```java

  return <expression>;

```

```java
    class Calculadora {

        public void ingresarNumero(double valor) {
            if (posicionActual < numeros.length) {
                numeros[posicionActual] = valor;
                posicionActual++;
            } else {
                error = true;
                mensajeError = "MEMORIA LLENA!!!";
            }
        }

        public void sumar() {
            if (verificarOperandos(2)) {
                double[] operandos = extraerOperandos(2);
                ingresarNumero(operandos[0] + operandos[1]);
            }
        }

        ...
    }
```

## Referencia this

### Para la resolución de colisión de identificadores y reutilización de métodos dentro de la clase

***this*** es una referencia constante que guarda la dirección del objeto que recibe el mensaje correspondiente al método que se está definiendo, implícitamente existe en todas las clases:

```java

  private final <class> this;

```

### Para evitar la multiplicidad de identificadores innecesarios

Sirve para resolución de ambigüedades en la colisión de parámetros o declaraciones locales con el mismo nombre que los atributos;

```java

    public Interval(double min, double max) {
        this.min = min;
        this.max = max;
    }

```

### Para la reutilización de constructures

Sirve para la reutilización de contructores en la definición de otros constructores, siendo la primera sentencia del constructor, mediante la sintaxis:

```java

    this([ <expression> {, <expression> }]);

```

```java

    public Calculadora(int capacidad) {
        numeros = new double[capacidad];
        posicionActual = 0;
        error = false;
        mensajeError = "";
    }

    public Calculadora() {
        this(CAPACIDAD_POR_DEFECTO);
    }

```

### Para la reutilización de métodos

Sirve para la reutilización de métodos en la codificación de otros métodos

```java

    public boolean includes(Interval interval) {
        return this.includes(interval.min) && this.includes(interval.max);
    }

    public void escale(double escale) {
        final double newHalfLength = this.length()/2 * escale;
        final double middlePoint = this.middlePoint();
        this.min = middlePoint - newHalfLength;
        this.max = middlePoint + newHalfLength;
    }

```

## Métodos privados

### Para la reutilización de métodos dentro de la clase

Sirve para la reutilización de métodos en la codificación de otros métodos

Dado que puede ser conveniente disponer de métodos, que no han sido solicitados, para implementar otros métodos, cabe la posibilidad de definir métodos de ámbito privado que sólo se pueden usar en la implementación de la clase

```java

    class <class> {
        private <methodHeader> <sequentialSentence>
        private <methodHeader> <sequentialSentence>
        ...
    }

```

```java

        private double[] extraerOperandos(int numeroOperandos) {
            double[] operandos = new double[numeroOperandos];
            for (int i = 0; i < numeroOperandos; i++) {
                operandos[i] = extraeOperando();
            }
            return operandos;
        }

        private double extraeOperando(){
            posicionActual--;
            return numeros[posicionActual];        
        }

        private boolean verificarOperandos(int numeroOperandos) {
            if (posicionActual >= numeroOperandos) {
                return true;
            } else {
                error = true;
                mensajeError = "Faltan operandos!";
                return false;
            }
        }

```
