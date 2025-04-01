# Vista privada de objetos

| **Desencadenamiento de instanciaciones** | **Desencadenamiento de mensajes** |
|------------------------------------------|-----------------------------------|
| Se **crea un objeto** (instancia): | Se **envía un mensaje** a un objeto: |
| • Por lo que, se asigna memoria para los atributos definidos en la clase; | • Por lo que se crean las variables locales con su inicialización y se ejecuta el cuerpo del método correspondiente; |
| • Por lo que, se ejecuta la inicialización de los atributos con sus valores por defecto o explícitos, pudiendo provocar **creaciones de nuevos objetos**; | • Por lo que se pueden **enviar nuevos mensajes** a objetos que sean atributos de su clase, a objetos que sean argumentos del mensaje o a objetos que se crean durante su ejecución; |
| • Por lo que, se ejecuta el constructor del objeto, pudiendo provocar **creaciones de nuevos objetos**; ||
| • Donde, **recursivamente**, pueden crearse nuevos objetos de otras clases hasta llegar a objetos basados directamente en tipos primitivos del lenguaje. | • Donde, **recursivamente**, pueden enviarse nuevos mensajes en la implementación de sus respectivos métodos hasta llegar a métodos que operan directamente con tipos primitivos. |
| <hr/> |<hr/>|
|Puede provocar un desencadenamiento de mensajes a través de la ejecución de los constructores que pueden lanzar mensajes|Puede provocar un desencadenamiento de instanciaciones a través de la creación de objetos en la definición de los métodos.|
|• Los bloques de inicialización estáticos se ejecutan una sola vez cuando la clase se carga, antes de cualquier instanciación.|• El contexto de ejecución (this) se establece para cada invocación de método, permitiendo acceder a los atributos del objeto receptor.|
