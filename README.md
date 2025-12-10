# Trendy
Proyecto en equipo realizado en las asignaturas de "Ingeniería del Software I" e "Ingeniería del Software II" de Ingeniería Informática en la Universidad Complutense de Madrid

Trendy es una aplicación de escritorio que implementa el acceso desde el frontend a una tienda de ropa, y el backend que esta tendría.

## Tecnologías
El proyecto se ha realizado en Java, usando Swing para la interfaz gráfica, MySQL como motor SQL, y IntelliJ (con las herramientas de DataGrip integradas) para la generación y administración del esquema de la base de datos en un servicio externo.

La base de datos esta hosteada en un proveedor 24/7 completamente gratuito llamado CleverCloud. Las credenciales de acceso total a la base de datos estan incluidas en el compilado y codigo fuente ya que es un proyecto no desplegado hecho para el enfoque de las asignaturas y no como una aplicación real, con el fin de que se pueda probar con facilidad la aplicación en un entorno real simulado.

## Ciclo de desarrollo

> Los enlaces llevan a la wiki del repositorio.

> La documentación se ha realicado en formato docx, la única que se ha traducido a markdown es la [SRS](https://github.com/RubizZ/Trendy/wiki/SRS-~-(IEEE-STD.-830%E2%80%901998)), los demás archivos se proporcionan en formato pdf.

> Los requisitos de la implementación en codigo no son los de la SRS inicial ya que tenía otro ambito, los requisitos reales que se implementan se pueden encontrar en la [Memoria del Proyecto](https://github.com/RubizZ/Trendy/wiki/Memoria-Entrega-Final)

### Plan de Proyecto y Requisitos

En Ingeniería del Software I empezamos la especificación de la aplicación. Esta fase consistió en la elaboración de un documento real cliente-desarrollador como [Plan de Proyecto (IEEE Std. 1058-1998)](https://github.com/RubizZ/Trendy/wiki/Plan-de-Proyecto-(IEEE-Std.-1058%E2%80%901998)). 
Este incluye diferentes planes, como los planes de proceso de gestión, de proceso técnico, o de soporte del proceso, relacionados con la ingeniería de software.

Además, elaboramos un documento [SRS (Software Requirements Specification) de acuerdo al estandar IEEE STD. 830-1998](https://github.com/RubizZ/Trendy/wiki/SRS-~-(IEEE-STD.-830%E2%80%901998)), en el que están definidas las diferentes interfaces de la aplicación, las funciones que esta cumple, y otros requisitos, definiendo los casos de uso de la aplicacion y haciendo una serie de diagramas UML.

### Patrones de diseño e implementación

Con el conocimiento de la primera asignatura, aplicamos la metodología de desarrollo RUP, y dividimos las tareas en diferentes iteraciones de desarrollo y las estructuramos en un diagrama de Gantt con GitHub Projects.

Adaptamos y redujimos los requisitos de la aplicación al marco de estudio de Ingeniería del Software II e implementamos la aplicación con una arquitectura de diseño J2EE (Java 2 Platform Enterprise Edition). En ella, aplicamos una gran cantidad de patrones de diseño GoF (Gang of Four) de entre ellos el patrón Builder, Facade, Factory, Singleton, Observer, Strategy, Bridge, Adapter, Decorator y Composite.

### Entrega final

Una vez terminamos toda la implementación y la documentación, realizamos los diagramas UML que el cliente (profesor) nos pidió hacer a la hora de la entrega final, de entre ellos el modelo de dominio, diagramas de actividades de secuencia,, de entidad-relacion y de clases.

Preparamos todo, hicimos revisiones de la documentación y del código, juntamos todo en la [Memoria del Proyecto](https://github.com/RubizZ/Trendy/wiki/Memoria-Entrega-Final) y voilà, hicimos la entrega final!

## Como ejecutar
- Descarga la ultima release desde GitHub directamente, y ejecuta el .jar. Para ello es necesario tener Java instalado
- También se puede ejecutar la clase Main del paquete launcher desde IntelliJ Idea o Eclipse IDE (este último no esta recomendado ya que el proyecto se desarrollo integramente en IntelliJ Idea)
- Una vez abierta, puedes interactuar con la tienda, sus productos, añadirlos a la cesta, etc. Necesitarás crear una cuenta y loguearte en caso de que quieras comprar, o usar todas las funciones que se ofrecen a los usuarios de la aplicación

## Colaboradores

- Rubén Hidalgo
- Javier del Olmo
- Irene Valverde
- Rocío Uñon
- Iván Arias
- Javier Martínez
- Ramiro Marcos
- Rocío Mercado
