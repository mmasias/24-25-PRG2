#!/bin/bash

BASE_DIR="/home/manuel/misRepos/24-25-PRG2"
CLIENTE_JAVA="$BASE_DIR/entregas/Cliente.java"
RESULTADOS_DIR="$BASE_DIR/resultados_correcciones"

mkdir -p "$RESULTADOS_DIR"

# Recorrer cada carpeta de estudiante en entregas
for ESTUDIANTE_DIR in "$BASE_DIR/entregas/"*/; do
    # Obtener nombre del estudiante (nombre de la carpeta)
    ESTUDIANTE=$(basename "$ESTUDIANTE_DIR")
    
    # Comprobar si existe una implementación de Calculadora
    CALCULADORA="$ESTUDIANTE_DIR/reto003/Calculadora.java"
    if [ -f "$CALCULADORA" ]; then
        echo "Corrigiendo implementación de $ESTUDIANTE..."
        
        # Crear/inicializar archivo de resultados
        RESULTADO_FILE="$RESULTADOS_DIR/$ESTUDIANTE.txt"
        echo "===== CORRECCIÓN PARA $ESTUDIANTE =====" > "$RESULTADO_FILE"
        echo "Fecha: $(date)" >> "$RESULTADO_FILE"
        echo "" >> "$RESULTADO_FILE"
        
        # Hacer backup del archivo Cliente.java original
        cp "$CLIENTE_JAVA" "$CLIENTE_JAVA.bak"
        
        # Modificar la línea de import en Cliente.java
        sed -i "s|import entregas\.[^.]*\.reto003\.Calculadora;|import entregas.$ESTUDIANTE.reto003.Calculadora;|" "$CLIENTE_JAVA"
        
        # Compilar y guardar resultados de compilación
        echo "Compilando..."
        echo "===== RESULTADOS DE COMPILACIÓN =====" >> "$RESULTADO_FILE"
        cd "$BASE_DIR"
        javac entregas/Cliente.java 2>> "$RESULTADO_FILE"
        
        # Verificar si la compilación fue exitosa
        if [ $? -eq 0 ]; then
            echo "Compilación exitosa para $ESTUDIANTE." >> "$RESULTADO_FILE"
            echo "" >> "$RESULTADO_FILE"
            
            # Ejecutar y guardar resultado
            echo "Ejecutando..."
            echo "===== RESULTADOS DE EJECUCIÓN =====" >> "$RESULTADO_FILE"
            java -cp "$BASE_DIR" entregas.Cliente >> "$RESULTADO_FILE" 2>&1
            
            echo "" >> "$RESULTADO_FILE"
            echo "===== FIN DE LA CORRECCIÓN =====" >> "$RESULTADO_FILE"
            echo "Corrección de $ESTUDIANTE completada. Resultados en $RESULTADO_FILE"
        else
            echo "" >> "$RESULTADO_FILE"
            echo "ERROR: La compilación falló. No se ejecutó el código." >> "$RESULTADO_FILE"
            echo "===== FIN DE LA CORRECCIÓN =====" >> "$RESULTADO_FILE"
            echo "Error de compilación para $ESTUDIANTE. No se ejecutó el código. Ver detalles en $RESULTADO_FILE"
        fi
        
        # Restaurar Cliente.java original
        mv "$CLIENTE_JAVA.bak" "$CLIENTE_JAVA"
        
        echo "---------------------------------------------"
    fi
done

echo "Proceso de corrección finalizado."