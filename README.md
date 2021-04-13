SKAPABOOKING + Jersey + JDO
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
