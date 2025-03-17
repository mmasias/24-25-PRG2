# Una calculadora

<div align=center>

|[Calculadora.java](Calculadora.java)|[App.java](../ClienteCalculadora.java)|
|-|-|
|Clase principal|Clase que consume (utiliza) la calculadora|

</div>

## Vista pública de la clase - vInicial

| |Firma del método|Descripción|
|-|-|-|
|✅|`public Calculadora()`|Constructor por defecto que inicializa una calculadora con capacidad para 10 números|
|✅|`public Calculadora(int capacidad)`|Constructor que inicializa una calculadora con la capacidad especificada|
|✅|`public Calculadora(double valorInicial)`|Constructor que inicializa una calculadora e ingresa un valor inicial|
|✅|`public Calculadora(double[] valoresIniciales)`|Constructor que inicializa una calculadora con un arreglo de valores iniciales|
|✅|`public void ingresarNumero(double valor)`|Ingresa un número a la calculadora|
|✅|`public String mostrar()`|Devuelve el último valor ingresado o el mensaje de error|
|✅|`public String mostrarTodo()`|Devuelve todos los valores almacenados o el mensaje de error|
|✅|`public void limpiar()`|Reinicia la calculadora, eliminando valores y errores|
|✅|`public void sumar()`|Suma los dos últimos valores ingresados|
|✅|`public void restar()`|Resta el último valor del penúltimo|
|✅|`public void multiplicar()`|Multiplica los dos últimos valores ingresados|
|✅|`public void dividir()`|Divide el penúltimo valor por el último|
|✅|`public void invertir()`|Cambia el signo del último valor ingresado|
|✅|`public void calcularPorcentaje()`|Calcula el porcentaje del penúltimo valor según el último|
|✅|`public void calcularFactorial()`|Calcula el factorial del último valor|
|✅|`public void calcularMedia()`|Calcula la media de todos los valores almacenados|
|✅|`public void calcularSumatoria()`|Calcula la suma de todos los valores almacenados|
|✅|`public void calcularMaximo()`|Devuelve el valor máximo entre los almacenados|
|✅|`public void calcularMinimo()`|Devuelve el valor mínimo entre los almacenados|
|✅|`public void sumar(double valor)`|Suma el valor al número en la última posición|
|✅|`public void restar(double valor)`|Resta el valor al número en la última posición|
|✅|`public void multiplicar(double valor)`|Multiplica el valor al número en la última posición|
|✅|`public void dividir(double valor)`|Divide entre el valor al número en la última posición|
|✅|`public void intercambiar()`|Intercambia de posicion los dos últimos valores ingresados|
|✅|`public void duplicarNumero()`|Duplica el último valor ingresado|
|✅|`public void calcularPotencia()`|Eleva el penúltimo valor al último (similar a elevar)|
|✅|`public void calcularPotencia(double exponente)`|Eleva el último valor al exponente especificado|
|✅|`public void ingresarPI()`|Ingresa el valor de Pi|
|✅|`public void ingresarE()`|Ingresa el valor de e (constante de Euler)|
