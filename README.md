# Tarea1-Aspect
Funcionalidad adicional:
En el aspecto cambioColor se activa cada vez que se pulse uno de los botones. Eso nos permite hacer un registro de todos los cambios por lo que ha pasada la ventana y en que momento. El uso de aspecto para el registro permite una mayor escalabilidad que si fuese hecho con clases e interfaces pues el pointcut es llamado cada vez que cambie de color la ventana (setBackground(Color)) entonces, se pueden crear nuevos botones sin tener repetir métodos para registrar cambios.
