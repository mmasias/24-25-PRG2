# 👨‍💻 Programación II - RAMA DE ENTREGAS

Usamos esta rama para las entregas, tal y como lo especificamos con más detalle en el artículo de [flujoGIT](/documentos/flujoGIT.md) y afinamos en el documento del reto / trabajo correspondiente.

## Una fracción

### Interfaz pública a implementar

|||
|-|-|
|`public Fraccion(int numerador, int denominador)`|
|`public Fraccion(int numerador)`|
|`public Fraccion()`|Crea la fraccion con valor cero
|`public Fraccion sumar(Fraccion fraccion)`|
|`public Fraccion sumar(int entero)`|
|`public Fraccion oponer()`|
|`public Fraccion restar(Fraccion fraccion)`|
|`public Fraccion restar(int entero)`|
|`public Fraccion multiplicar(Fraccion fraccion)`|
|`public Fraccion multiplicar(int entero)`|
|`public Fraccion invertir()`|
|`public Fraccion dividir(Fraccion fraccion)`|
|`public Fraccion dividir(int entero)`|
|`public Fraccion elevar(int exponente)`|
|`public int numerador()`|
|`public int denominador()`|
|`public boolean esMenor(Fraccion fraccion)`|
|`public boolean esMayor(Fraccion fraccion)`|
|`public boolean esIgual(Fraccion fraccion)`|
|`public double valueOf()`|Devuelve el valor del objeto como un número de tipo double
|`public int compareTo(Fraccion fraccion)`|Devuelve 0 si ambas fracciones son iguales, 1 si la fraccion es mayor que la que se pasa como parámetro y -1 en caso contrario.
|`public String toString()`|Devuelve el objeto en formato String
|`public Fraccion clone()`|

### Tester

> [ClienteFraccion.java](/entregas/ClienteFraccion.java)

#### Salida esperada del tester:

```console
Constructor & .toString(): 2/3
Numerador:   [2]
Denominador: [3]
Sumar: 4/3
11/3
Oponer: -2/3
Restar: 0
-1/3
Multiplicar: 4/9
4/3
Invertir: 3/2
Dividir: 1
2/9
Elevar: 8/27
Es mayor: false
Es menor: false
Es igual: true
Es igual: 0
valueOf(): 0.6666666666666666
clone(): 2/3
```

## Clase Fecha

|||
|-|-|
|`Fecha(int año, int mes, int dia)`|Constructor con validación de parámetros|
|`equals(Fecha fecha)`|Compara si dos fechas son iguales |
|`antesQue(Fecha fecha)`|Verifica si esta fecha es anterior a otra |
|`despuesDe(Fecha date)`|Verifica si esta fecha es posterior a otra |
|`compareTo(Fecha date)`|Compara fechas y devuelve -1, 0 o 1 |
|`siguiente()`|Retorna la fecha del día siguiente |
|`toString()`|public | Devuelve representación en texto de la fecha |
|`esMesValido(int mes)`|Valida si un mes está entre 1 y 12 |
|`esDiaValido(int dia)`|Valida si un día está entre 1 y 30 |

## Clase Tiempo

|||
|-|-|
| `Tiempo(int horas, int minutos, int segundos)`|Constructor con validación de parámetros |
| `equals(Tiempo tiempo)`|Compara si dos tiempos son iguales |
| `antesQue(Tiempo tiempo)`|Verifica si este tiempo es anterior a otro |
| `despuesDe(Tiempo tiempo)`|Verifica si este tiempo es posterior a otro |
| `compareTo(Tiempo tiempo)`|Compara tiempos y devuelve -1, 0 o 1 |
| `next()`|Retorna el tiempo del segundo siguiente |
| `toString()`|Devuelve representación en texto del tiempo |
| `sumar(Tiempo tiempo)`|Suma dos tiempos y devuelve el resultado |
| `esHoraValida(int hora)`|Valida si una hora está entre 0 y 24 |
| `esMinutoValido(int minuto)`|Valida si un minuto está entre 0 y 60 |
| `esSegundoValido(int segundo)`|Valida si un segundo está entre 0 y 60 |