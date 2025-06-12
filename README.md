# 👨‍💻 Programación II - Final

## 🧾 Descripción

Este proyecto simula una universidad donde se puede:

- Crear una **Universidad**.
- Crear y asignar una **Asignatura** a un **Profesor**.
- Pedirle al profesor que **cree un examen** (con 3 preguntas) para su asignatura.
- Asignar otro profesor para **vigilar el examen** (siempre que no tenga asignaturas).
- Entregar el examen al profesor vigilante.
- Finalmente, **imprimir** toda la información organizada.

## ⚠️ Cambios realizados

### ✅ Clase `Cliente`
- Faltaba el parámetro `Universidad` en el método `Examen.iniciar()`. Ya corregido.

### ✅ Clase `Universidad`
- Se añadió el método `organizarExamen`, **clave para la lógica** del flujo del programa.
- Este método permite usar varios métodos internos en orden correcto y mantener la coherencia de roles y asignaciones.

### ✅ Clase `Examen`
- El atributo `Asignatura` **no era realmente necesario**, ya que el profesor que crea el examen ya tiene una asignatura asociada.
- Podría eliminarse en futuras versiones para reducir redundancia.

## 💡 Reflexión

> Abusé del uso de **getters y setters** por miedo a que hicieran falta.  
> En la mayoría de los casos **no eran necesarios**, lo cual ensucia el código más de lo debido.  
> La clave es encontrar un equilibrio entre encapsulación y limpieza de código.

