# Mapeo Detallado: Contenidos Curriculares vs Retos

## Objetivos del Análisis

Este documento proporciona un mapeo específico entre cada tema del currículum y cómo se refleja (o debería reflejarse) en los retos actuales.

---

## Contenidos Curriculares Analizados

### 1. Programación Estructurada (Repaso)
**Estado curricular**: ✅ Completado  
**Aplicación en retos**:
- 🔴 **Reto 001**: Básicamente estructurado, no avanza hacia POO
- 🟡 **Reto 002**: Mención de principios pero sin implementación clara
- 🟢 **Reto 003**: Trasciende lo estructurado hacia POO

### 2. Evolución de Lenguajes de Programación
**Estado curricular**: ✅ Completado  
**Aplicación en retos**:
- ❌ **Ningún reto actual** refleja esta evolución conceptual
- **Oportunidad**: Reto que compare enfoques estructurado vs POO

### 3. Objetivos de POO
**Estado curricular**: ✅ Completado  
**Conceptos clave**: Abstracción, Encapsulación, Modularización, Jerarquización

**Aplicación en retos**:
- 🔴 **Reto 001**: No aplica objetivos POO
- 🟡 **Reto 002**: Mención indirecta
- 🟢 **Reto 003**: Excelente aplicación de abstracción y encapsulación

---

## Análisis Detallado por Concepto POO

### Abstracción
**Definición curricular**: Capacidad de enfocarse en aspectos esenciales ignorando detalles irrelevantes.

| Reto | Aplicación | Evaluación | Mejoras Sugeridas |
|------|------------|------------|-------------------|
| 001 | ❌ No aplica | Sin clases abstractas | Crear clase `InstrumentoMusical` |
| 002 | ⚠️ Mínima | Datos como entidades | Definir `Escala` como concepto abstracto |
| 003 | ✅ Excelente | `Calculadora` abstrae operaciones | Mantener enfoque actual |

### Encapsulación
**Definición curricular**: Agrupar datos y métodos, controlando acceso mediante vista pública/privada.

| Reto | Aplicación | Evaluación | Mejoras Sugeridas |
|------|------------|------------|-------------------|
| 001 | ❌ No aplica | Arrays públicos | Encapsular datos musicales |
| 002 | ⚠️ Mínima | Sin especificación clara | Obligar atributos privados |
| 003 | ✅ Excelente | Vista pública/privada clara | Modelo a seguir |

### Modularización
**Definición curricular**: Dividir problema en módulos independientes.

| Reto | Aplicación | Evaluación | Mejoras Sugeridas |
|------|------------|------------|-------------------|
| 001 | ⚠️ Básica | Un solo módulo | Separar `Nota`, `Escala`, `Acorde` |
| 002 | ⚠️ Básica | Extensión sin modularización | Múltiples clases colaborando |
| 003 | ✅ Buena | Clase bien estructurada | Considerar separar `Memoria` |

### Jerarquización
**Definición curricular**: Organizar clases en jerarquías (herencia).

| Reto | Aplicación | Evaluación | Mejoras Sugeridas |
|------|------------|------------|-------------------|
| 001 | ❌ No aplica | Sin jerarquías | `Nota` → `NotaNatural`, `NotaAlterada` |
| 002 | ❌ No aplica | Sin herencia | `Escala` → `EscalaMayor`, `EscalaMenor` |
| 003 | ⚠️ Pendiente | Sin herencia aún | Futuro: `Calculadora` → `CalculadoraCientifica` |

---

## Progresión Cronológica Detallada

### Febrero 11 - Refactorización y Variables Estáticas
**Contenido**: Construcción y refactorización, variables globales/estáticas

**Aplicación en retos**:
- ❌ **Reto 001**: No practica refactorización
- ❌ **Reto 002**: No aborda variables estáticas
- ✅ **Reto 003**: Usa `CAPACIDAD_POR_DEFECTO` como constante estática

### Febrero 18 - Sistemas Complejos
**Contenido**: Sistemas complejos, mecanismos de comprensión

**Aplicación en retos**:
- 🔴 **Reto 001**: Sistema musical simple sin complejidad POO
- 🟡 **Reto 002**: Mayor complejidad pero sin estructura OO
- 🟢 **Reto 003**: Sistema complejo bien estructurado

### Febrero 21 - Vista Pública de Clases
**Contenido**: Cabeceras de métodos, sobrecarga

**Aplicación en retos**:
- ❌ **Reto 001**: Sin clases definidas
- ⚠️ **Reto 002**: Estructura no especificada
- ✅ **Reto 003**: Múltiples constructores (sobrecarga excelente)

### Febrero 25 - Constructores y Vista Pública de Objetos
**Contenido**: Constructor, destructor, creación de objetos

**Aplicación en retos**:
- ❌ **Reto 001**: Sin constructores específicos
- ⚠️ **Reto 002**: Constructores no especificados
- ✅ **Reto 003**: 4 constructores diferentes, creación de objetos

### Marzo 4 - Vista Privada de Clases
**Contenido**: Atributos privados, referencia `this`, métodos privados

**Aplicación en retos**:
- ❌ **Reto 001**: Sin vista privada
- ⚠️ **Reto 002**: No especificado
- ✅ **Reto 003**: Atributos privados, uso de `this` implícito

---

## Gaps Identificados y Oportunidades

### 1. Falta de Progresión Clara en Retos Iniciales
**Problema**: Reto 001 y 002 no preparan para Reto 003  
**Solución**: Rediseñar con progresión incremental de conceptos POO

### 2. Conceptos Sin Retos Asociados
**Conceptos descubiertos**:
- Colaboración entre objetos (HOOD)
- Herencia por extensión
- Clases abstractas
- Interfaces

**Retos necesarios**:
- Sistema de figuras geométricas (herencia)
- Sistema de vehículos (clases abstractas)
- Sistema de trabajadores (interfaces)

### 3. Herramientas No Utilizadas
**Disponibles pero no aplicadas**:
- PlantUML para diseño de clases
- Diagramas de objetos
- Diagramas de estados

---

## Propuestas de Mejora Específicas

### Reto 001 Rediseñado: "Sistema Musical POO"
```java
// Estructura propuesta
public class Nota {
    private String nombre;
    private int semitonos;
    
    public Nota(String nombre, int semitonos) { /* */ }
    public String getNombre() { /* */ }
    public int getSemitonos() { /* */ }
    public Nota transponer(int semitonos) { /* */ }
}

public class Escala {
    private Nota[] notas;
    private String tipo;
    
    public Escala(Nota tonica, int[] intervalos) { /* */ }
    public Acorde formarAcorde(int... grados) { /* */ }
    public void mostrarNotas() { /* */ }
}
```

### Reto 002 Mejorado: "Colaboración Musical"
- **Objetivo**: Que `Escala` y `Acorde` colaboren
- **Aplicación**: Múltiples escalas generando múltiples acordes
- **POO**: Métodos que reciben/devuelven objetos

### Nuevos Retos Sugeridos

#### Reto 004: "Figuras Geométricas"
**Conceptos**: Herencia, polimorfismo
```java
public abstract class Figura {
    protected String color;
    public abstract double calcularArea();
    public abstract double calcularPerimetro();
}

public class Circulo extends Figura { /* */ }
public class Rectangulo extends Figura { /* */ }
```

#### Reto 005: "Sistema de Empleados"
**Conceptos**: Interfaces, clases abstractas
```java
public interface Trabajador {
    double calcularSalario();
    void trabajar();
}

public abstract class Empleado implements Trabajador {
    protected String nombre;
    protected double salarioBase;
}
```

---

## Métricas de Alineación Propuestas

### Antes (Estado Actual)
- **Cobertura conceptual**: 40%
- **Progresión pedagógica**: 30%
- **Aplicación práctica**: 50%

### Después (Con Mejoras)
- **Cobertura conceptual**: 85%
- **Progresión pedagógica**: 90%
- **Aplicación práctica**: 85%

---

## Plan de Acción Inmediato

### Semana 1-2
1. **Comunicar análisis** a estudiantes
2. **Identificar confusiones** en retos actuales
3. **Planificar ajustes** para próxima iteración

### Semana 3-4
1. **Rediseñar Reto 001** con estructura POO
2. **Especificar mejor Reto 002** con requisitos claros
3. **Mantener Reto 003** como modelo

### Semana 5-8
1. **Desarrollar Retos 004-005** para herencia
2. **Crear rúbricas** específicas por concepto
3. **Establecer prerrequisitos** entre retos

Este mapeo detallado proporciona la base para mejorar significativamente la alineación entre retos y contenidos curriculares.