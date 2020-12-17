# topsecret
# Top Secret Challenge

## Introduction

Proyecto en Spring Boot para desafio MeLi

## Tecnologias

En el proyecto se utilizo

Spring Boot como framework
H2 como base de datos embebida
Lombook como motor de anotaciones
JPA como framework de consultas
Gradle como constructor

## Installation

Para que el proyecto funcione de manera local hay que correr en consola el comando

gradlew clean build -> para compilar

gradlew bootRun -> para ejecutar

Se uso el IDE Intellij para realizar el desarrollo.

Cuando el proyecto se encuentra corriendo dirigirse a

http://localhost:8080/h2-console/

con los datos:

JDBC URL: jdbc:h2:mem:test
User Name: sa

y realizar los inserts que se encuentran en resources/schema.sql en la tabla SATELLITES
