# BYTE TECH - Aplicación web con Servlets y JSP

Proyecto académico para la evidencia AA2-EV02. Aplicación web de una empresa ficticia dedicada a computadores, componentes y accesorios.

## Tecnologías
- Java 21
- Apache Tomcat 10.1.x (Jakarta Servlet 6.0)
- Maven
- HTML5, CSS3, JSP y Java Servlets
- Git y GitHub para control de versiones

## Funcionalidades implementadas
1. Página de inicio en JSP.
2. Catálogo de productos servido por `ProductoServlet` mediante GET.
3. Búsqueda de productos mediante parámetro GET `buscar`.
4. Formulario de contacto/registro en JSP enviado mediante POST.
5. `ClienteServlet` procesa y valida los datos mediante `doPost`.
6. Resultado dinámico en `resultado.jsp`.

## Requisitos previos
- JDK 21 instalado y `JAVA_HOME` configurado.
- Apache Tomcat 10.1.x.
- Maven 3.9 o superior.

## Ejecutar desde VS Code o terminal
Desde la carpeta que contiene `pom.xml`:

```bash
mvn clean package
```

Se genera `target/BYTE_TECH.war`. Copia ese archivo a la carpeta `webapps` de Tomcat 10.1. Inicia Tomcat y abre:

`http://localhost:8080/BYTE_TECH/`

Si se ejecuta desde un servidor configurado en VS Code, despliega el proyecto WAR en Tomcat 10.1.

## Rutas principales
- `/` o `/index.jsp`: inicio.
- `/productos`: catálogo (GET); admite `?buscar=portatil`.
- `/clientes`: muestra el formulario (GET) y procesa el envío (POST).

## Nota sobre persistencia
Esta versión de demostración procesa la solicitud y muestra el resultado, pero no guarda clientes en una base de datos. La evidencia solicita Servlets, formularios HTML, GET/POST y JSP; la persistencia puede añadirse en una siguiente fase si el diseño del proyecto lo requiere.
