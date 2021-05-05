SKAPABOOKING
===============================
![java ci workflow](https://github.com/aitorcavia/skapaBooking/actions/workflows/java-ci.yml/badge.svg) [![codecov](https://codecov.io/gh/aitorcavia/skapaBooking/branch/master/graph/badge.svg?token=BII2KWC71L)](https://app.codecov.io/gh/aitorcavia/skapaBooking/)

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
Las clases de datos deben ser procesadas antes de generar las tablas con el comando 

    mvn datanucleus:enhance
    
Para la creación de las tablas se debe ejecutar el comando de maven

    mvn compile datanucleus:schema-create


**Datos de prueba**

Se pueden introducir datos de prueba en la aplicación utilizando el comando de maven

    mvn -Pdatos exec:java

**Teses de integracion**

Los teses de integracion se ejecutaran utilizando en comando

    mvn verify -Pintegracion

**Inicio de la aplicación**

La aplicación se inicializa utilizando el comando

    mvn exec:java
    
**Construcción y prueba**

Se puede construir el proyecto y lanzar las pruebas unitarias con el comando

    mvn test       
    
    
    
    
    
**Pasos a seguir en la interfaz**






**Iniciar Sesión y Registro**    
La primera ventana que nos aparecerá sera la ventana iniciar sesión.
Para poder acceder tendremos que realizar un registro (Para acceder al registro hay un botón en la parte inferior derecha)




**Ventana Principal**

Una vez inicies sesión llegaras a la ventana principal en ella podrás seleccionar diferentes fechas y destinos y realizar busquedas.
Si clicka en el botón Entrar se le abrira una nueva ventana donde visualizará una descripción de los distintos apartados del apartamento y en un futuro una imagen.
Dentro de esta ventana visualizará un botón reserva que le dirigirá a una nueva ventana en la que selecionará el método de pago.
Una de las opciones seria el pago con tarjeta que guardaria los datos de una tarjeta de un usuario y se visualizaría en un panel(Se crea pero no se visualiza).
La otra opción es la de contrarembolso. 
En esa misma ventana en la parte inferior derecha habrá un botón (contacta con nosotros) donde accederas a toda la funcionalidad de contacto que hemos realizado.




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

Opinión : Con este botón se mostrará las diferentes opiniones de un usuario acerca de múltiples apartamentos además le dara la opción de crear una nueva opinión(Botón Publicar).

Chat:

Primero hay que ejecutar el Chat.S y luego Chat.C

En estas dos ventanas se simulara un chat mediante sockets.

Una vez terminada la simulación podrás volver acceder a la ventana Contacto con un botón llamado Contacto

Una vez finalizada toda la parte de contacto podrás volver a la ventana principal para continuar con la interfaz(Botón Ventana Principal).


**Todas las ventanas relacionadas con el contacto tienen un botón volver ("<")**


**Perfil de usuario**

Una vez posicionado en la ventana Principal presionas un botón en la parte superior derecha para poder acceder en el perfil de usuario(Botón perfil).

Visualizarás todos los apartados de la ventana perfil usuario.

Una vez finalizado podrás presionar un botón volver para regresar a la ventana principal.


