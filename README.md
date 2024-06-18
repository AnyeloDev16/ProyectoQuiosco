# ProyectoQuiosco

Proyecto desarrollado para el curso de Base de Datos 2 del quinto ciclo.

## Descripción del Proyecto

El ProyectoQuiosco tiene como objetivo desarrollar un sistema de gestión para un quiosco, este proyecto se realiza en el contexto del curso de Base de Datos 2 del quinto ciclo.

## Tecnologías Utilizadas

- **SQL Server**
  - Procedimientos Almacenados
  - Triggers
  - Indices
- **Java**
  
  **Librerias:**
  - BCrypt
  - MSSqlserver
  - FlatLab
 
  **Arquitectura:**
  - MVC (Modelo-Vista-Controlador)

## Avance del Proyecto

### Primera Semana de Desarrollo

- **Desarrollo de la BD en SQL Server:** Creación y configuración de la base de datos.
- **Estructuración de la arquitectura del sistema en MVC:** Definición de los componentes y la organización del proyecto.
- **Interfaz de Usuario:**
  - **Login:** **TERMINADO**
    - Funcionalidad de ingreso de sesión para cada usuario con su respectiva cuenta.
  - **Administrador:** **EN PROCESO**
    - **Apartado de Empleados:** **TERMINADO**
      - Funcionalidad para registrar nuevos empleados. **SEMITERMINADO** (Falta hacer dinámica la asignación de roles).
      - Capacidad de hashear contraseñas utilizando la librería "BCrypt".
      - Funcionalidad para cerrar sesión y regresar al login.
