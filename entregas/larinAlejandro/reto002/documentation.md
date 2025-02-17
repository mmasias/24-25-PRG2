# Explicación del Código: Generación de Escalas y Acordes Musicales en Java

## **Introducción**
Este programa en Java solicita al usuario una nota musical inicial y una escala musical para generar tanto la escala completa como un acorde basado en dicha escala.

---

## **Componentes Principales**

### 1. **Constantes Musicales**
- `NOTES`: Un array que representa las 12 notas de la escala cromática.
- `SEMI_TONE`, `TONE`, `TONE_AND_HALF`: Representan los intervalos musicales en semitonos.
- `INTERVALE_*`: Arrays que definen los patrones de intervalos para varias escalas (mayor, menor, pentatónica, etc.).
- `INTERVALE_CHORD`: Define las posiciones para formar un acorde (tónica, tercera y quinta).

---

### 2. **Selección de Nota y Escala**
- `askScale()`: Muestra las escalas disponibles y solicita al usuario elegir una. Utiliza `scanner.nextInt()` para leer el valor y `scanner.nextLine()` para limpiar el buffer.
- `askNote()`: Muestra las notas disponibles y solicita al usuario ingresar una nota inicial.

---

### 3. **Generación de Escala**
- `getStartNote()`: Busca el índice de la nota inicial en el array `NOTES`.
- `getScale()`: Genera la escala completa usando la nota inicial y el patrón de intervalos seleccionado:
  - Empieza desde la nota inicial y recorre el array de intervalos.
  - Cada nueva nota se calcula sumando el intervalo al índice de la nota anterior y utilizando el módulo para mantener el ciclo dentro de las 12 notas.

---

### 4. **Generación de Acorde**
- `getChord()`: Toma las posiciones definidas en `INTERVALE_CHORD` y extrae las notas correspondientes de la escala generada, formando así el acorde (tónica, tercera y quinta).

---

### 5. **Salida en Consola**
- `showIntervals()`: Muestra en consola las escalas disponibles, la escala generada y el acorde resultante.

---

## **Solución al Problema del Scanner**
- El `Scanner` se declara como un objeto global para evitar múltiples instancias.
- Después de usar `scanner.nextInt()` en `askScale()`, se utiliza `scanner.nextLine()` para consumir el carácter de nueva línea (`\n`) restante, evitando errores al leer la siguiente entrada con `scanner.nextLine()` en `askNote()`.

---

## **Flujo del Programa**
1. Muestra las escalas disponibles.
2. Lee la selección de escala y la nota inicial.
3. Genera la escala usando los intervalos de la escala seleccionada.
4. Genera un acorde a partir de la escala.
5. Muestra la escala y el acorde resultante en consola.

---

## **Ejemplo de Salida:**

Available Scales:

```bash
1. Major...
.
.
.
12. By Tone
Select a scale (1-13): 1 
Notes: C C# D D# E F F# G G# A A# B 
Enter a starting note: C 
Scale: C D E F G A B 
Chord: C E G
```
