# ProyectoIntegración --> Juego Web RPG cartas

_Viendo el mercado actual de juegos nos dimos cuenta de que no existe ningún juego de cartas de rol-playing-game (RPG) para pc, así que haremos un juego propio mezclando algunas de las reglas con las que cuentan juegos físicos como el Munchkin y el No Game Over y añadiendo alguna regla propia nuestra._

_El objetivo del proyecto es crear ese juego mencionado para que funcione en una página web, para que los usuarios no tengan que hacer ningún tipo de instalación y puedan disfrutar de unas partidas con sus amigos._

_En este repositorio se irán guardando todos los archivos del proyecto conforme se vaya desarrollando y validando._

## Comenzando 🚀

_Estas instrucciones te permitirán obtener una copia del proyecto en funcionamiento en tu máquina local para propósitos de desarrollo y pruebas._

### Pre-requisitos 📋

_Todo lo que necesitas para este proyecto:_

- Java 11+ --> [Instalacion](https://ubunlog.com/instalacion-de-oracle-java-11-en-ubuntu-18-10-y-derivados/#Como_instalar_Oracle_Java_11_en_Ubuntu_1810_y_sus_derivados)
  
    ```
    sudo add-apt-repository ppa:linuxuprising/java

    sudo apt-get update

    sudo apt install oracle-java11-installer
    ```

- Spring - Spring Tool Suite 4 --> [Instalacion](http://javadesde0.com/instalando-spring-tool-suite-4-ide/)


- Node.js --> [Instalacion](https://www.hostinger.es/tutoriales/instalar-node-js-ubuntu/)
  
    ```
    sudo apt install nodejs

    sudo apt install npm

    nodejs -v
    ```

- TypeScript --> [Instalacion](typescriptlang.org/download)****

    ```
    npm install -g typescript
    ```
  
- Angular --> [Instalacion](https://dev.to/sandymarmolejo/instalacion-de-angular-10-17e1)

  ```
  Ejecutar este comando una vez instalado el paquete npm de node.js:

    npm install -g @angular/cli
    ```

- Visual Studio Code --> [Descarga](https://code.visualstudio.com/download)

- Docker --> [Instalacion](https://www.hostinger.es/tutoriales/como-instalar-y-usar-docker-en-ubuntu/)

### Instalación 🔧
_Los documenttos de la instalación del entorno de desarrollo los puedes encontrar dentro de la carpeta resources del proyecto._

_Ahi encontraremos como instalar la base de datos y su script de creación y como instalar el servidor y levantarlo para poder utilizarlo correctamente._

## Ejecutando las pruebas ⚙️

_Realizaremos pruebas y test y test unitarios utilizando **Mockito** y **JUnit** en el back, esto nos permitirá realizar test tanto para funciones concretas como de integración sin tener que levantar todo el contexto del proyecto._

_Esa forma de realizar test se basa en la metodología  BDD(Behaviour Driven Development), por lo que los test deben realizarse antes de desarrollar el código, esto hace que nuestro código esté mejor estructurado desde un principio y vaya directo a conseguir los objetivos principales planteados en las historias de usuario._

_En cuanto al front utilizaremos **Jasmine** y **Karma** para la realización de los test y la automatización de los mismos, aunque estamos pendiente de formación en esos aspectos._

### Y las pruebas de estilo de codificación ⌨️

_Estas prueban verifican la calidad de nuestro código para desarrollar de una forma más óptima y legible tanto para nosotros como para otras personas_

_Para ello utilizaremos **Sonar** que es una herramienta que analiza nuestro código y nos ayuda a mejorarlo_

## Despliegue 📦

_El deploy está pendiente_

## Construido con 🛠️

- [Angular](https://angular.io/docs) → El framework web SPA.
- [Spring](https://spring.io/why-spring) → Framework de desarrollo.
- [Spring --> Spring-Tools](https://spring.io/tools) → Herramienta para Spring.
- [Docker](https://www.docker.com/) → Contenedor para la base de datos.
- [MySQL Workbench](https://www.mysql.com/products/workbench/) → Para el manejo de la base de datos.
- [Visual Studio Code](https://code.visualstudio.com/) → Editor utilizado.

## Autores ✒️

_Aqui tenemos a todos los participantes en este proyecto:_

* **David Cebrian** - [GitHub](https://github.com/davidcebrian)
* **Ruben Daza** - [GitHub](https://github.com/rudahee)
* **Abraham Romero** - [GitHub](https://github.com/Abrahamrc94)

