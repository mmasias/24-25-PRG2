#!/bin/bash

# Directorio base del proyecto
BASE_DIR="/home/manuel/misRepos/24-25-PRG2"
# Archivo del cliente que modificaremos
CLIENTE_JAVA="$BASE_DIR/entregas/Cliente.java"
# Directorio donde guardaremos los resultados
RESULTADOS_DIR="$BASE_DIR/resultados_correcciones"

# Crear directorio de resultados si no existe
mkdir -p "$RESULTADOS_DIR"

# Recorrer cada carpeta de estudiante en entregas
for ESTUDIANTE_DIR in "$BASE_DIR/entregas/"*/; do
    # Obtener nombre del estudiante (nombre de la carpeta)
    ESTUDIANTE=$(basename "$ESTUDIANTE_DIR")
    
    # Comprobar si existe una implementación de Calculadora
    CALCULADORA="$ESTUDIANTE_DIR/reto003/Calculadora.java"
    if [ -f "$CALCULADORA" ]; then
        echo "Corrigiendo implementación de $ESTUDIANTE..."
        
        # Hacer backup del archivo Cliente.java original
        cp "$CLIENTE_JAVA" "$CLIENTE_JAVA.bak"
        
        # Modificar la línea de import en Cliente.java
        sed -i "s|import entregas\.[^.]*\.reto003\.Calculadora;|import entregas.$ESTUDIANTE.reto003.Calculadora;|" "$CLIENTE_JAVA"
        
        # Compilar - Importante: compilar desde el directorio raíz para que coincida con la estructura de paquetes
        echo "Compilando..."
        cd "$BASE_DIR"
        javac entregas/Cliente.java
        
        # Ejecutar y guardar resultado
        echo "Ejecutando..."
        java -cp "$BASE_DIR" entregas.Cliente > "$RESULTADOS_DIR/$ESTUDIANTE.txt" 2>&1
        
        # Restaurar Cliente.java original
        mv "$CLIENTE_JAVA.bak" "$CLIENTE_JAVA"
        
        echo "Corrección de $ESTUDIANTE completada. Resultados en $RESULTADOS_DIR/$ESTUDIANTE.txt"
        echo "---------------------------------------------"
    fi
done

echo "Proceso de corrección finalizado."