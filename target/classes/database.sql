CREATE DATABASE skapaDB;
USE skapaDB;
CREATE USER IF NOT EXISTS 'spq'@'localhost' IDENTIFIED BY 'spq';
GRANT ALL ON skapadb.* TO 'spq'@'localhost';