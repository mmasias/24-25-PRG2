# Una calculadora

<div align=center>

|[Calculadora.java](Calculadora.java)|[App.java](App.java)|
|-|-|
|Clase principal|Clase que consume (utiliza) la calculadora|

</div>

## Vista pública de la clase - vInicial

| |Firma del método|Descripción|
|-|-|-|
|✅|`public Calculadora()`|Constructor por defecto que inicializa una calculadora con capacidad para 10 números|
|✅|`public Calculadora(int capacidad)`|Constructor que inicializa una calculadora con la capacidad especificada|
|✅|`public void ingresarNumero(double valor)`|Ingresa un número a la calculadora|
|✅|`public String mostrar()`|Devuelve el último valor ingresado o el mensaje de error|
|✅|`public String mostrarTodo()`|Devuelve todos los valores almacenados o el mensaje de error|
|✅|`public void limpiar()`|Reinicia la calculadora, eliminando valores y errores|
|✅|`public void sumar()`|Suma los dos últimos valores ingresados|
|✅|`public void restar()`|Resta el último valor del penúltimo|
|✅|`public void multiplicar()`|Multiplica los dos últimos valores ingresados|
|✅|`public void dividir()`|Divide el penúltimo valor por el último|
|✅|`public void invertir()`|Cambia el signo del último valor ingresado|
|🔲|`public void calcularPorcentaje()`|Calcula el porcentaje del penúltimo valor según el último|
|🔲|`public void calcularFactorial()`|Calcula el factorial del último valor|
|✅|`public void calcularMedia()`|Calcula la media de todos los valores almacenados|
|✅|`public void calcularSumatoria()`|Calcula la suma de todos los valores almacenados|
|🔲|`public void calcularMaximo()`|Devuelve el valor máximo entre los almacenados|
|🔲|`public void calcularMinimo()`|Devuelve el valor mínimo entre los almacenados|
