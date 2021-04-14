SKAPABOOKING
===============================

Configuración
------------- 

**Base de datos**

Crear una base de datos llamada *skapadb* y dar permisos al usuario por defecto

    CREATE DATABASE skapaDB;
    USE skapaDB;
    CREATE USER IF NOT EXISTS 'spq'@'localhost' IDENTIFIED BY 'spq';
    GRANT ALL ON skapadb.* TO 'spq'@'localhost';

La configuración por defecto para la base de datos y los usuarios puede ser actualizada en el fichero *resources/datanucleus.properties*.

**Creación de las tablas**

Para la creación de las tablas se debe ejecutar el comando de maven

    mvn compile datanucleus:schema-create


**Datos de prueba**

Se pueden introducir datos de prueba en la aplicación utilizando el comando de maven

    mvn -Pdatos exec:java

**Inicio del servidor**

El servidor REST de la aplicación se lanza utilizando el comando

    mvn exec:java

**Inicio de la aplicación cliente**

La aplicación cliente puede iniciarse usando el comando

    mvn -Pcliente exec:java
    
    
    
    
    
    
**Pasos a seguir en la interfaz**






**Iniciar Sesión y Registro**    
La primera ventana que nos aparecerá sera la ventana iniciar sesión.
Para poder acceder tendremos que realizar un registro (Para acceder al registro hay un botón en la parte inferior derecha)




**Ventana Principal**

Una vez inicies sesión llegaras a la ventana principal en ella podrás seleccionar diferentes fechas pero no podrás realizar una busqueda.
En esa misma ventana habrá un botón contacto donde accederas a toda la funcionalidad de contacto que hemos realizado.






**Contacto**

**Todas las ventanas relacionadas con el contacto tienen un botón volver ("<")**


Una vez llegas a la ventana contacto veras distintos botones :


Redes sociales : Aparecerán nuestras redes sociales mediante botones en la parte inferior derecha de las imagenes.


Teléfono : Nuestros diferentes números de teléfono.


Botón (?) : Este botón es para las diferentes dudas más comunes de los usuarios en las que aparecen distintas preguntas con sus correspondientes preguntas  


COVID : Ventana con la diferente normativa covid que incluye un codigo qr que podemos visualizar con nuestro dispositivo que nos da la información global en cuanto al COVID-19


Correo : Nos lleva hacia una nueva ventana de gmail para poder enviar un correo electrónico.


Nuestro Correo: Aparece la información de nuestro correo electrónico


Videollamada : Este botón es una invitación a nuestro servidor(Discord) propio de SkapaBooking para que el usuario pueda realizar llamadas y videollamadas con nuestra empresa.


Chat:

Primero hay que ejecutar el Chat.S y luego Chat.C

En estas dos ventanas se simulara un chat mediante sockets.

Una vez terminada la simulación podrás volver acceder a la ventana Contacto con un botón llamado Contacto

Una vez finalizada toda la parte de contacto podras volver a la ventana principal para continuar con la interfaz(Botón Ventana Principal).


**Todas las ventanas relacionadas con el contacto tienen un botón volver ("<")**


**Perfil de usuario**

Una vez posicionado en la ventana Principal presionas un botón en la parte superior derecha para poder acceder en el perfil de usuario(Botón perfil).

Visualizarás todos los apartados de la ventana perfil usuario.

Una vez finalizado podrás presionar un botón volver para regresar a la ventana principal.


