# Carpintería Web Application

## Descripción

Este es un proyecto básico de una aplicación web para la gestión de una carpintería, desarrollado utilizando las siguientes tecnologías:

- **Java 17**
- **JSP** (Java Server Pages) para la interfaz de usuario.
- **JSTL** (JSP Standard Tag Library) para manejar las etiquetas en JSP.
- **JasperReports** para la generación de reportes.
- **MySQL 8** como base de datos.
- **Maven** para la gestión de dependencias.

## Requisitos previos

Antes de ejecutar este proyecto, asegúrate de tener instalados los siguientes componentes en tu entorno:

1. **Java 17**: El proyecto está basado en Java 17.
2. **Apache Tomcat 10** o superior: Para desplegar la aplicación web.
3. **MySQL 8**: Base de datos para el almacenamiento de datos de la aplicación.
4. **Maven**: Para gestionar las dependencias del proyecto.
5. **JasperReports**: Para generar reportes dentro de la aplicación.

## Configuración del proyecto

### 1. Configuración de la base de datos

- La base de datos **MySQL 8** debe ser configurada de acuerdo con los scripts SQL ubicados en la carpeta `data/`.
- Ejecuta los scripts en tu servidor MySQL para crear las tablas necesarias para la aplicación.

### 2. Configuración de JasperReports

Asegúrate de tener JasperReports configurado para la generación de reportes. Los archivos `.jasper` deben ser referenciados correctamente en el código Java correspondiente.

### 3. Configuración de Maven

El archivo `pom.xml` incluye todas las dependencias necesarias para el proyecto. Para instalar las dependencias:

```bash
mvn install
