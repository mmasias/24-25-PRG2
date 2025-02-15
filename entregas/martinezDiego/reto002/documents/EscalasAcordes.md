#  Escalas y acordes

Este programa está diseñado para permitir al usuario seleccionar una nota y una escala, luego generar la escala correspondiente a partir de la nota elegida y construir un acorde basado en esa escala. A continuación, se explica cómo funciona cada parte del programa.

## 1. **Inicialización de las notas y escalas**

El programa comienza con la definición de dos arreglos:

- **`notas[]`**: contiene las notas musicales disponibles (desde "do" hasta "si" con sus alteraciones como sostenidos).
  
- **`escalas[]`**: un conjunto de números que representan diferentes tipos de escalas musicales.

Es importante destacar que los arreglos utilizan diferentes tipos de datos: las notas están representadas por cadenas de texto (como "do", "re", etc.), lo que facilita que el usuario las ingrese de manera intuitiva. En cambio, las escalas se representan con números, ya que son más fáciles de manejar y procesar de esta forma. Luego, al momento de imprimir las escalas, estos números se convierten a cadenas de texto para que el usuario las pueda leer correctamente.

## 2. **Entrada del usuario**

- El programa muestra las notas disponibles y las escalas disponibles.
- El usuario debe seleccionar una nota de las opciones listadas y luego elegir un número de escala de las opciones disponibles.

## 3. **Búsqueda de la nota seleccionada**

- La función **`buscarNota()`** recibe la nota elegida por el usuario (por ejemplo, "do", "re#", etc.), y busca el índice de esa nota en el arreglo **`notas[]`**.
- Si la nota no se encuentra, devuelve **-1**, indicando que la nota no es válida.

## 4. **Construcción de la escala**

- La función **`construirEscala()`** toma como parámetros el arreglo de **notas[]**, la **nota seleccionada** y el **número de escala** elegido por el usuario.
  
- **Proceso de construcción**:
  1. La función comienza buscando el índice de la nota seleccionada mediante **`buscarNota()`**.
  2. Luego, selecciona el patrón de la escala correspondiente mediante la función **`seleccionarEscala()`** que devuelve un arreglo con los intervalos entre las notas de la escala (por ejemplo, tono, semitono, etc.).
  3. Con la nota base y el patrón de intervalos, la escala es construida iterando sobre los intervalos y calculando la posición de cada nota en el arreglo de **notas[]**.
  4. La escala es retornada como un arreglo con los índices de las notas correspondientes.

## 5. **Construcción del acorde**

- La función **`construirAcorde()`** genera un acorde a partir de la escala construida.
  
- **Proceso de construcción del acorde**:
  1. El acorde se basa en la primera, tercera y quinta nota de la escala.
  2. Las notas para el acorde son seleccionadas según sus posiciones en la escala construida.
  
  - El acorde mayor se construye con una **tercera mayor** (4 semitonos) y una **quinta perfecta** (7 semitonos) desde la nota base de la escala.
  
- Finalmente, el acorde es retornado como un arreglo con los índices de las notas correspondientes.

## 6. **Impresión de la escala y acorde**

- Una vez que se construyen la **escala** y el **acorde**, el programa imprime las notas correspondientes en formato de texto.
- Se usa un bucle para recorrer los índices de las notas en la escala y acorde y se imprimen los nombres de las notas obtenidas en el arreglo **`notas[]`**.

## 7. **Funciones Auxiliares**

- **`seleccionarEscala()`**: Recibe el número de la escala seleccionada y devuelve el patrón de intervalos correspondiente a esa escala.
- **`convertirNumero()`**: Convierte el número de la escala en su nombre completo (por ejemplo, "1" a "Escala Mayor").
- **`imprimirNotas()` y `imprimirEscalas()`**: Se encargan de mostrar las opciones de notas y escalas disponibles para el usuario.

## 8. **Explicación de las escalas**

Cada número de escala corresponde a un tipo de escala musical:

- **Escala Mayor**: Es la típica escala mayor con la estructura de tonos y semitonos estándar.
- **Escala Menor Natural, Armónica y Melódica**: Variantes de la escala menor, cada una con diferencias en los intervalos entre sus notas.
- **Escala Pentatónica**: Escalas con cinco notas, tanto mayores como menores.
- **Escalas Dórico, Frigia, Lidia, Mixolidia, Locria**: Son diferentes modos musicales que se derivan de las escalas mayores y menores.
- **Escala por Tonos**: Una escala construida completamente de tonos enteros.


