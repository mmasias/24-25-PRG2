# Guía de Implementación: Retos Mejorados

## Introducción

Esta guía proporciona implementaciones concretas para mejorar la alineación de los retos con los contenidos curriculares, incluyendo código de ejemplo y especificaciones detalladas.

---

## Reto 001 Rediseñado: "Sistema Musical Orientado a Objetos"

### Objetivos de Aprendizaje
- Aplicar conceptos básicos de POO
- Diseñar clases con responsabilidades claras
- Practicar encapsulación y métodos de acceso
- Introducir colaboración simple entre objetos

### Especificación Técnica

#### Clase `Nota`
```java
package entregas.apellidoNombre.reto001;

/**
 * Representa una nota musical con nombre y posición cromática
 */
public class Nota {
    private String nombre;
    private int semitonos; // Posición en la escala cromática (0-11)
    
    public Nota(String nombre, int semitonos) {
        this.nombre = nombre;
        this.semitonos = (semitonos % 12 + 12) % 12; // Normalizar a 0-11
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public int getSemitonos() {
        return semitonos;
    }
    
    public Nota transponer(int intervalos) {
        int nuevosSemitonos = (this.semitonos + intervalos) % 12;
        String nuevoNombre = obtenerNombrePorSemitonos(nuevosSemitonos);
        return new Nota(nuevoNombre, nuevosSemitonos);
    }
    
    @Override
    public String toString() {
        return nombre;
    }
    
    // Método privado para demostrar vista privada
    private String obtenerNombrePorSemitonos(int semitonos) {
        String[] nombres = {"Do", "Do#", "Re", "Re#", "Mi", "Fa", 
                           "Fa#", "Sol", "Sol#", "La", "La#", "Si"};
        return nombres[semitonos];
    }
}
```

#### Clase `Escala`
```java
package entregas.apellidoNombre.reto001;

/**
 * Representa una escala musical con una secuencia específica de intervalos
 */
public class Escala {
    private Nota tonica;
    private Nota[] notas;
    private String tipoEscala;
    private int[] intervalos;
    
    public Escala(Nota tonica, int[] intervalos, String tipo) {
        this.tonica = tonica;
        this.intervalos = intervalos;
        this.tipoEscala = tipo;
        this.notas = generarNotas();
    }
    
    // Constructor para escala mayor (patrón común)
    public Escala(Nota tonica) {
        this(tonica, new int[]{2, 2, 1, 2, 2, 2, 1}, "Mayor");
    }
    
    public Nota[] getNotas() {
        return notas.clone(); // Proteger estado interno
    }
    
    public Nota getTonica() {
        return tonica;
    }
    
    public String getTipo() {
        return tipoEscala;
    }
    
    public void mostrarEscala() {
        System.out.print("Escala " + tipoEscala + " de " + tonica.getNombre() + ": ");
        for (int i = 0; i < notas.length; i++) {
            System.out.print(notas[i]);
            if (i < notas.length - 1) System.out.print("-");
        }
        System.out.println();
    }
    
    // Método privado para generar las notas de la escala
    private Nota[] generarNotas() {
        Nota[] resultado = new Nota[intervalos.length + 1];
        resultado[0] = tonica;
        
        Nota notaActual = tonica;
        for (int i = 0; i < intervalos.length; i++) {
            notaActual = notaActual.transponer(intervalos[i]);
            resultado[i + 1] = notaActual;
        }
        
        return resultado;
    }
}
```

#### Clase `ClienteMusical` (para pruebas)
```java
package entregas.apellidoNombre.reto001;

public class ClienteMusical {
    public static void main(String[] args) {
        // Crear nota tónica
        Nota doMayor = new Nota("Do", 0);
        
        // Crear escala mayor de Do
        Escala escalaDo = new Escala(doMayor);
        escalaDo.mostrarEscala();
        
        // Crear escala menor natural
        int[] intervalosmenor = {2, 1, 2, 2, 1, 2, 2};
        Escala escalaDoMenor = new Escala(doMayor, intervalosmenor, "Menor Natural");
        escalaDoMenor.mostrarEscala();
        
        // Probar transposición
        Nota sol = doMayor.transponer(7);
        Escala escalaSol = new Escala(sol);
        escalaSol.mostrarEscala();
    }
}
```

### Rúbrica de Evaluación Reto 001

| Criterio | Excelente (9-10) | Bueno (7-8) | Suficiente (5-6) | Insuficiente (0-4) |
|----------|------------------|-------------|------------------|-------------------|
| **Encapsulación** | Todos los atributos privados, métodos de acceso adecuados | Mayoría privados, algunos métodos de acceso | Algunos atributos privados | Sin encapsulación |
| **Constructores** | Múltiples constructores, validación | Constructor básico funcional | Constructor mínimo | Sin constructor o no funciona |
| **Métodos** | Métodos públicos y privados, responsabilidades claras | Métodos básicos implementados | Algunos métodos funcionan | Métodos no implementados |
| **Colaboración** | Objetos interactúan correctamente | Interacción básica | Poca interacción | Sin colaboración |

---

## Reto 002 Mejorado: "Sistema Musical Colaborativo"

### Objetivos de Aprendizaje
- Profundizar colaboración entre objetos
- Practicar métodos que reciben/devuelven objetos
- Aplicar principios de reutilización
- Introducir conceptos de composición

### Nueva Clase: `Acorde`
```java
package entregas.apellidoNombre.reto002;

import entregas.apellidoNombre.reto001.Nota;
import entregas.apellidoNombre.reto001.Escala;

/**
 * Representa un acorde musical formado por notas específicas
 */
public class Acorde {
    private Nota[] notas;
    private String tipoAcorde;
    private Nota fundamental;
    
    public Acorde(Nota fundamental, int[] intervalos, String tipo) {
        this.fundamental = fundamental;
        this.tipoAcorde = tipo;
        this.notas = construirAcorde(intervalos);
    }
    
    // Constructor para acorde mayor básico (1-3-5)
    public Acorde(Nota fundamental) {
        this(fundamental, new int[]{0, 4, 7}, "Mayor");
    }
    
    // Método estático para crear acorde desde escala
    public static Acorde formarDesdeEscala(Escala escala, int... grados) {
        Nota[] notasEscala = escala.getNotas();
        Nota[] notasAcorde = new Nota[grados.length];
        
        for (int i = 0; i < grados.length; i++) {
            if (grados[i] > 0 && grados[i] <= notasEscala.length) {
                notasAcorde[i] = notasEscala[grados[i] - 1];
            }
        }
        
        String tipo = determinarTipoAcorde(notasAcorde);
        Acorde acorde = new Acorde(notasAcorde[0]);
        acorde.notas = notasAcorde;
        acorde.tipoAcorde = tipo;
        return acorde;
    }
    
    public void mostrarAcorde() {
        System.out.print("Acorde " + tipoAcorde + " de " + fundamental.getNombre() + ": ");
        for (int i = 0; i < notas.length; i++) {
            System.out.print(notas[i]);
            if (i < notas.length - 1) System.out.print("-");
        }
        System.out.println();
    }
    
    public Nota[] getNotas() {
        return notas.clone();
    }
    
    public String getTipo() {
        return tipoAcorde;
    }
    
    // Método privado para construir acorde
    private Nota[] construirAcorde(int[] intervalos) {
        Nota[] resultado = new Nota[intervalos.length];
        
        for (int i = 0; i < intervalos.length; i++) {
            resultado[i] = fundamental.transponer(intervalos[i]);
        }
        
        return resultado;
    }
    
    // Método privado para determinar tipo de acorde
    private static String determinarTipoAcorde(Nota[] notas) {
        if (notas.length >= 3) {
            int intervalo1 = (notas[1].getSemitonos() - notas[0].getSemitonos() + 12) % 12;
            int intervalo2 = (notas[2].getSemitonos() - notas[0].getSemitonos() + 12) % 12;
            
            if (intervalo1 == 4 && intervalo2 == 7) return "Mayor";
            if (intervalo1 == 3 && intervalo2 == 7) return "Menor";
            if (intervalo1 == 3 && intervalo2 == 6) return "Disminuido";
            if (intervalo1 == 4 && intervalo2 == 8) return "Aumentado";
        }
        return "Indeterminado";
    }
}
```

### Cliente Mejorado
```java
package entregas.apellidoNombre.reto002;

import entregas.apellidoNombre.reto001.*;

public class ClienteMusicalAvanzado {
    public static void main(String[] args) {
        // Crear escalas diversas
        Nota do = new Nota("Do", 0);
        Escala escalaMayor = new Escala(do);
        
        // Formar acordes desde escalas
        Acorde primergrado = Acorde.formarDesdeEscala(escalaMayor, 1, 3, 5);
        Acorde cuartogrado = Acorde.formarDesdeEscala(escalaMayor, 4, 6, 8);
        Acorde quintogrado = Acorde.formarDesdeEscala(escalaMayor, 5, 7, 9);
        
        // Mostrar progresión I-IV-V
        System.out.println("Progresión I-IV-V en Do Mayor:");
        primergrado.mostrarAcorde();
        cuartogrado.mostrarAcorde();
        quintogrado.mostrarAcorde();
        
        // Probar con escalas modales
        int[] intervalosDorico = {2, 1, 2, 2, 2, 1, 2};
        Escala doDorico = new Escala(do, intervalosDorico, "Dórico");
        
        Acorde acordeDorico = Acorde.formarDesdeEscala(doDorico, 1, 3, 5);
        acordeDorico.mostrarAcorde();
    }
}
```

---

## Reto 004 Nuevo: "Figuras Geométricas - Herencia"

### Objetivos de Aprendizaje
- Aplicar herencia por extensión
- Practicar métodos abstractos
- Implementar polimorfismo básico
- Comprender override de métodos

### Jerarquía de Clases
```java
package entregas.apellidoNombre.reto004;

/**
 * Clase abstracta base para todas las figuras geométricas
 */
public abstract class Figura {
    protected String color;
    protected double posicionX;
    protected double posicionY;
    
    public Figura(String color, double x, double y) {
        this.color = color;
        this.posicionX = x;
        this.posicionY = y;
    }
    
    // Métodos abstractos que deben implementar las subclases
    public abstract double calcularArea();
    public abstract double calcularPerimetro();
    public abstract void dibujar();
    
    // Métodos concretos compartidos
    public String getColor() {
        return color;
    }
    
    public void setColor(String color) {
        this.color = color;
    }
    
    public void mover(double deltaX, double deltaY) {
        this.posicionX += deltaX;
        this.posicionY += deltaY;
    }
    
    public String getPosicion() {
        return "(" + posicionX + ", " + posicionY + ")";
    }
    
    // Método toString común
    @Override
    public String toString() {
        return getClass().getSimpleName() + " " + color + 
               " en " + getPosicion() + 
               " - Área: " + String.format("%.2f", calcularArea()) +
               " - Perímetro: " + String.format("%.2f", calcularPerimetro());
    }
}
```

```java
package entregas.apellidoNombre.reto004;

/**
 * Implementación específica para círculos
 */
public class Circulo extends Figura {
    private double radio;
    
    public Circulo(String color, double x, double y, double radio) {
        super(color, x, y);
        this.radio = radio > 0 ? radio : 1.0;
    }
    
    public Circulo(double radio) {
        this("Azul", 0, 0, radio);
    }
    
    @Override
    public double calcularArea() {
        return Math.PI * radio * radio;
    }
    
    @Override
    public double calcularPerimetro() {
        return 2 * Math.PI * radio;
    }
    
    @Override
    public void dibujar() {
        System.out.println("Dibujando círculo " + color + 
                          " con radio " + radio + " en " + getPosicion());
    }
    
    public double getRadio() {
        return radio;
    }
    
    public void setRadio(double radio) {
        if (radio > 0) {
            this.radio = radio;
        }
    }
}
```

```java
package entregas.apellidoNombre.reto004;

/**
 * Implementación específica para rectángulos
 */
public class Rectangulo extends Figura {
    private double ancho;
    private double alto;
    
    public Rectangulo(String color, double x, double y, double ancho, double alto) {
        super(color, x, y);
        this.ancho = ancho > 0 ? ancho : 1.0;
        this.alto = alto > 0 ? alto : 1.0;
    }
    
    public Rectangulo(double ancho, double alto) {
        this("Rojo", 0, 0, ancho, alto);
    }
    
    @Override
    public double calcularArea() {
        return ancho * alto;
    }
    
    @Override
    public double calcularPerimetro() {
        return 2 * (ancho + alto);
    }
    
    @Override
    public void dibujar() {
        System.out.println("Dibujando rectángulo " + color + 
                          " " + ancho + "x" + alto + " en " + getPosicion());
    }
    
    public double getAncho() {
        return ancho;
    }
    
    public double getAlto() {
        return alto;
    }
}
```

### Cliente con Polimorfismo
```java
package entregas.apellidoNombre.reto004;

public class ClienteFiguras {
    public static void main(String[] args) {
        // Crear array polimórfico
        Figura[] figuras = {
            new Circulo("Azul", 10, 10, 5),
            new Rectangulo("Rojo", 20, 20, 8, 6),
            new Circulo(3),
            new Rectangulo(4, 7)
        };
        
        // Polimorfismo en acción
        System.out.println("=== FIGURAS CREADAS ===");
        for (Figura figura : figuras) {
            figura.dibujar();
            System.out.println(figura);
            System.out.println();
        }
        
        // Calcular área total
        double areaTotal = calcularAreaTotal(figuras);
        System.out.println("Área total de todas las figuras: " + 
                          String.format("%.2f", areaTotal));
        
        // Mover todas las figuras
        System.out.println("\n=== DESPUÉS DE MOVER ===");
        for (Figura figura : figuras) {
            figura.mover(5, 5);
            System.out.println(figura.getClass().getSimpleName() + 
                             " movida a " + figura.getPosicion());
        }
    }
    
    // Método que demuestra polimorfismo
    public static double calcularAreaTotal(Figura[] figuras) {
        double total = 0;
        for (Figura figura : figuras) {
            total += figura.calcularArea(); // Polimorfismo
        }
        return total;
    }
}
```

---

## Reto 005 Nuevo: "Sistema de Empleados - Interfaces"

### Objetivos de Aprendizaje
- Implementar interfaces
- Combinar herencia e interfaces
- Aplicar principio de inversión de dependencias
- Practicar múltiples implementaciones

### Estructura con Interfaces
```java
package entregas.apellidoNombre.reto005;

/**
 * Interface que define el comportamiento de un trabajador
 */
public interface Trabajador {
    double calcularSalario();
    void trabajar();
    String getDescripcionTrabajo();
}

/**
 * Interface para empleados que pueden ser promovidos
 */
public interface Promocionable {
    void promover();
    boolean esElegibleParaPromocion();
    String getSiguienteNivel();
}

/**
 * Clase abstracta base para todos los empleados
 */
public abstract class Empleado implements Trabajador {
    protected String nombre;
    protected String id;
    protected double salarioBase;
    protected int antiguedad;
    
    public Empleado(String nombre, String id, double salarioBase) {
        this.nombre = nombre;
        this.id = id;
        this.salarioBase = salarioBase;
        this.antiguedad = 0;
    }
    
    // Métodos comunes
    public String getNombre() { return nombre; }
    public String getId() { return id; }
    public double getSalarioBase() { return salarioBase; }
    public int getAntiguedad() { return antiguedad; }
    
    public void incrementarAntiguedad() {
        this.antiguedad++;
    }
    
    // Implementación base de trabajar (puede ser override)
    @Override
    public void trabajar() {
        System.out.println(nombre + " está trabajando como " + 
                          getDescripcionTrabajo());
    }
    
    @Override
    public String toString() {
        return getDescripcionTrabajo() + ": " + nombre + 
               " (ID: " + id + ", Salario: $" + 
               String.format("%.2f", calcularSalario()) + ")";
    }
}
```

### Implementaciones Concretas
```java
package entregas.apellidoNombre.reto005;

/**
 * Programador que puede ser promovido
 */
public class Programador extends Empleado implements Promocionable {
    private String lenguajePrincipal;
    private int proyectosCompletados;
    private String nivel; // Junior, Senior, Lead
    
    public Programador(String nombre, String id, double salarioBase, 
                      String lenguaje) {
        super(nombre, id, salarioBase);
        this.lenguajePrincipal = lenguaje;
        this.proyectosCompletados = 0;
        this.nivel = "Junior";
    }
    
    @Override
    public double calcularSalario() {
        double bonus = proyectosCompletados * 100;
        double bonusAntiguedad = antiguedad * 200;
        double bonusNivel = nivel.equals("Senior") ? 500 : 
                           nivel.equals("Lead") ? 1000 : 0;
        return salarioBase + bonus + bonusAntiguedad + bonusNivel;
    }
    
    @Override
    public String getDescripcionTrabajo() {
        return "Programador " + nivel + " de " + lenguajePrincipal;
    }
    
    @Override
    public void trabajar() {
        super.trabajar();
        System.out.println("Desarrollando código en " + lenguajePrincipal);
    }
    
    @Override
    public void promover() {
        if (esElegibleParaPromocion()) {
            if (nivel.equals("Junior")) {
                nivel = "Senior";
                salarioBase += 1000;
            } else if (nivel.equals("Senior")) {
                nivel = "Lead";
                salarioBase += 1500;
            }
            System.out.println(nombre + " ha sido promovido a " + nivel);
        }
    }
    
    @Override
    public boolean esElegibleParaPromocion() {
        return (nivel.equals("Junior") && proyectosCompletados >= 3 && antiguedad >= 1) ||
               (nivel.equals("Senior") && proyectosCompletados >= 8 && antiguedad >= 3);
    }
    
    @Override
    public String getSiguienteNivel() {
        if (nivel.equals("Junior")) return "Senior";
        if (nivel.equals("Senior")) return "Lead";
        return "Máximo nivel alcanzado";
    }
    
    public void completarProyecto() {
        proyectosCompletados++;
        System.out.println(nombre + " completó un proyecto. Total: " + 
                          proyectosCompletados);
    }
}
```

```java
package entregas.apellidoNombre.reto005;

/**
 * Consultor externo - implementa Trabajador pero no es Empleado
 */
public class Consultor implements Trabajador {
    private String nombre;
    private double tarifaPorHora;
    private int horasTrabajadas;
    private String especialidad;
    
    public Consultor(String nombre, double tarifa, String especialidad) {
        this.nombre = nombre;
        this.tarifaPorHora = tarifa;
        this.especialidad = especialidad;
        this.horasTrabajadas = 0;
    }
    
    @Override
    public double calcularSalario() {
        return tarifaPorHora * horasTrabajadas;
    }
    
    @Override
    public void trabajar() {
        horasTrabajadas += 8; // Día completo
        System.out.println(nombre + " trabajó 8 horas como consultor de " + 
                          especialidad);
    }
    
    @Override
    public String getDescripcionTrabajo() {
        return "Consultor de " + especialidad;
    }
    
    @Override
    public String toString() {
        return getDescripcionTrabajo() + ": " + nombre + 
               " ($" + tarifaPorHora + "/hora, " + horasTrabajadas + 
               " horas, Total: $" + String.format("%.2f", calcularSalario()) + ")";
    }
}
```

### Sistema de Gestión
```java
package entregas.apellidoNombre.reto005;

import java.util.ArrayList;
import java.util.List;

/**
 * Sistema que gestiona trabajadores usando interfaces
 */
public class SistemaGestionEmpleados {
    private List<Trabajador> trabajadores;
    private List<Promocionable> promocionables;
    
    public SistemaGestionEmpleados() {
        trabajadores = new ArrayList<>();
        promocionables = new ArrayList<>();
    }
    
    public void agregarTrabajador(Trabajador trabajador) {
        trabajadores.add(trabajador);
        
        // Si también es promocionable, agregarlo a esa lista
        if (trabajador instanceof Promocionable) {
            promocionables.add((Promocionable) trabajador);
        }
    }
    
    public void procesarNomina() {
        System.out.println("\n=== PROCESANDO NÓMINA ===");
        double totalNomina = 0;
        
        for (Trabajador trabajador : trabajadores) {
            double salario = trabajador.calcularSalario();
            totalNomina += salario;
            System.out.println(trabajador);
        }
        
        System.out.println("Total nómina: $" + String.format("%.2f", totalNomina));
    }
    
    public void hacerTrabajarATodos() {
        System.out.println("\n=== DÍA DE TRABAJO ===");
        for (Trabajador trabajador : trabajadores) {
            trabajador.trabajar();
        }
    }
    
    public void procesarPromociones() {
        System.out.println("\n=== REVISANDO PROMOCIONES ===");
        for (Promocionable empleado : promocionables) {
            if (empleado.esElegibleParaPromocion()) {
                System.out.println("Candidato para promoción: " + empleado);
                empleado.promover();
            }
        }
    }
    
    public static void main(String[] args) {
        SistemaGestionEmpleados sistema = new SistemaGestionEmpleados();
        
        // Agregar diferentes tipos de trabajadores
        Programador prog1 = new Programador("Ana García", "P001", 3000, "Java");
        Programador prog2 = new Programador("Luis Martín", "P002", 3000, "Python");
        Consultor cons1 = new Consultor("María Consultor", 50, "Bases de Datos");
        
        sistema.agregarTrabajador(prog1);
        sistema.agregarTrabajador(prog2);
        sistema.agregarTrabajador(cons1);
        
        // Simular trabajo
        sistema.hacerTrabajarATodos();
        sistema.procesarNomina();
        
        // Simular progreso
        prog1.completarProyecto();
        prog1.completarProyecto();
        prog1.completarProyecto();
        prog1.incrementarAntiguedad();
        
        cons1.trabajar();
        cons1.trabajar();
        
        sistema.procesarPromociones();
        sistema.procesarNomina();
    }
}
```

---

## Conclusiones de Implementación

### Beneficios de las Mejoras
1. **Progresión Clara**: Cada reto introduce conceptos específicos de forma incremental
2. **Aplicación Práctica**: Los ejemplos permiten ver POO en acción
3. **Evaluación Objetiva**: Rúbricas específicas por concepto
4. **Preparación Curricular**: Cada reto prepara para el siguiente

### Recursos Adicionales Creados
- Código completo para cada reto
- Clientes de prueba específicos
- Rúbricas detalladas
- Ejemplos de salida esperada

Esta guía proporciona una base sólida para implementar retos mejor alineados con los objetivos curriculares de POO.