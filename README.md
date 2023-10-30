# Tarea1-Aspect
Funcionalidad adicional:

* En el aspecto cambioColor se activa cada vez que se pulse uno de los botones. Eso nos permite hacer un registro de todos los cambios por lo que ha pasada la ventana y en que momento. El uso de aspecto para el registro permite una mayor escalabilidad que si fuese hecho con clases e interfaces pues el pointcut es llamado cada vez que cambie de color la ventana (setBackground(Color)) entonces, se pueden crear nuevos botones sin tener repetir métodos para registrar cambios.
  
* En el aspect Notificacion se esta interceptando por medio de pointcut llamado NumeroObserver() al metodo notificacionObserver() de la clase Principal donde el advice luego del punto de corte de ejecutara y la funcion que realizara es la imprimir por consola el numero de Observadores que se han creado hasta el momento.
  
* El siguiente punto de corte pointcut llamado AvisoCreacionObserver() lo que hara es interceptar el metodo agregarObserver para que luego el advice realice su respectiva tarea la cual es de crear un archivo de texto llamado EstadoVentana.txt en la cual escribira el dia, la hora y el color en el cual la ventana se ha modificado o en este caso cambiado de color. Ademas este pointcut AvisoCreacionObserver() tambien muestra por pantalla un mensaje diciendo "se ha creado un nuevo observer" cada vez que la persona le da click a un boton.

Estos Aspectos proporcionan la funcionalidad adicional necesaria para la persistencia de archivos en la clase Principal, permitiendo guardar el estado de la ventana desde un archivo.
