# Mi Diario — Inside Out

## Descripción

**Mi Diario** es una aplicación de consola desarrollada en Java que permite al usuario gestionar los momentos vividos a lo largo del tiempo, cada uno asociado a una emoción y a una fecha concreta. El usuario puede añadir nuevos momentos, consultar la lista completa, eliminar un momento existente y filtrar los momentos registrados por emoción o por mes.

El proyecto sigue una arquitectura **MVC + Repository**, con persistencia en memoria mediante el patrón **Singleton**, y ha sido desarrollado siguiendo la metodología **TDD** (Test Driven Development), aplicando principios **SOLID** a lo largo de todo el diseño.

Cada momento vivido tiene un identificador, un título, una descripción, una emoción, la fecha del momento, la fecha de creación y la fecha de modificación.

### Listado de emociones
1. Alegría
2. Tristeza
3. Ira
4. Asco
5. Miedo
6. Ansiedad
7. Envidia
8. Vergüenza
9. Aburrimiento
10. Nostalgia

## Pre-requisitos

Para ejecutar este proyecto es necesario tener instalado:

- **Java 21** (JDK)
- **Maven** (3.6.3 o superior)
- **Git**

## Pasos para la instalación

1. Clona el repositorio (o tu fork) en tu equipo:
```bash
   git clone https://github.com/AndreaVaGo/project-java-consoleapp-inside-out.git
```

2. Entra en la carpeta del proyecto:
```bash
   cd project-java-consoleapp-inside-out
```

3. Instala las dependencias con Maven:
```bash
   mvn install
```

4. Ejecuta el programa:
```bash
   mvn compile exec:java -Dexec.mainClass="org.factoriaf5.project_inside_out.App"
```

## Ejecución de los tests

Para ejecutar todos los tests del proyecto:

```bash
mvn test
```

Esto también genera un informe detallado de cobertura en `target/site/jacoco/index.html`.

### Cobertura de tests

![Cobertura de tests](assets/cobertura-tests.png)

Cobertura total alcanzada: **83% de instrucciones**, **60% de ramas** — superando el mínimo del 70% exigido.

## Diagramas

### Diagrama de casos de uso
![Diagrama de casos de uso](assets/diagrama-casos-uso.drawio.png)

### Diagrama de clases
![Diagrama de clases](assets/diagrama-clases.drawio.png)

### Diagrama de secuencia
![Diagrama de secuencia](assets/diagrama-secuencia.drawio.png)

## Autores

- Andrea (AndreaVaGo)
