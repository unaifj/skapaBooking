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
La primera ventana que nos aparecera sera la ventana iniciar sesión.
Para poder acceder tendremos que realiza un registro (Para acceder al registro hay un boton en la parte inferior derecha)
**Ventana Principal**
Una vez inicies sesión llegaras a la ventana principal en ella podras seleccionar diferentes fechas pero no podras realizar una busqueda.
En esa misma ventana habra un boton contacto donde accederas a toda la funcionalidad de contacto que hemos realizado.
**Contacto**
Una vez llegas a la ventana contacto veras distintos botones :
Redes sociales : Apareceran nuestras redes sociales mediante botones en la parte inferior derecha de las imagenes.
Teléfono : Nuestros diferentes numeros de telefono.
Botón (?) : Este boton es para las diferentes dudas más comunes de los usuarios en las que aparecen distintas preguntas con sus correspondientes preguntas  
COVID : Ventana con la diferente normativa covid que incluye un codigo qr que podemos visualizar con nuestro dispositivo que nos da la información global en cuanto al COVID-19
Correo : Nos lleva hacia una nueva ventana de gmail para poder enviar un correo electronico.
Nuestro Correo: Aparece la información de nuestro correo electrónico
Videollamada : Este botón es una invitación a nuestro servidor(Discord) propio de SkapaBooking para que el usuario pueda realizar llamadas y videollamadas con nuestra empresa.
Chat:
Primero hay que ejecutar el Chat.S y luego Chat.C
En estas dos ventanas se simulara un chat mediante sockets.
Una vez terminada la simulación podrás volver acceder a la ventana Contacto con un botón llamado Contacto
Una vez finalizada toda la parte de contacto podras volver a la ventana principal para continuar con la interfaz.
**Todas las ventanas relacionadas con el contacto tienen un botón volver ("<")**





