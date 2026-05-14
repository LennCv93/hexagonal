# hexagonal
Sistema de Gestión Bancaria - Trabajo Final Modulo 2
Este proyecto implementa un sistema de gestión de cuentas y transferencias bancarias aplicando Arquitectura Hexagonal y patrones de diseño estructurales para garantizar un código desacoplado y mantenible.

🏗️ Patrones de Diseño Implementados
Para cumplir con los requisitos de la tarea, se han aplicado los siguientes patrones:

1. Patrón Adaptador (Adapter)
   Es la base de nuestra Arquitectura Hexagonal. Permite que la lógica de negocio no dependa de tecnologías externas.

Input Adapters: El AccountController actúa como adaptador de entrada, transformando peticiones HTTP/JSON en acciones del dominio.

Output Adapters: El AccountPersistenceAdapter traduce las operaciones de nuestro dominio a instrucciones específicas de PostgreSQL mediante JPA.

2. Patrón Singleton
   Utilizamos este patrón para la gestión eficiente de recursos y componentes.

Implementación: Gracias al contenedor de inversión de control (IoC) de Spring Boot, componentes como AccountService, AccountMapper y los controladores se manejan como instancias únicas (Singletons) en toda la aplicación, optimizando el uso de memoria y garantizando un punto único de acceso a la lógica.

3. Patrón Mapper
   Utilizado para mantener la pureza de cada capa.

Uso de MapStruct: Implementamos mappers para transformar objetos entre capas:

Request → Domain

Domain → Entity

Domain → Response

Esto evita que la capa de base de datos o la capa web contaminen el corazón del negocio (Dominio).

🛠️ Tecnologías y Persistencia
Lenguaje: Kotlin

Framework: Spring Boot

Base de Datos: PostgreSQL (Persistencia real y soporte para transacciones ACID).

Documentación: ADR (Architectural Decision Records) incluidos en la carpeta docs/adr/.

📋 Funcionalidades Principales
Creación de Cuentas: Registro con saldo inicial.

Consulta de Saldos: Visualización del estado actual de la cuenta.

Transferencias: Operación entre cuentas con validación de saldo suficiente (Punto crítico de la lógica de negocio).

Notificaciones: Alertas automáticas por consola al finalizar cada operación.

🚀 Instrucciones de Ejecución
Sigue estos pasos para levantar el proyecto localmente:

1. Requisitos Previos
   Java 17 o superior instalado.

PostgreSQL corriendo localmente o mediante Docker.

Una base de datos creada llamada bank_db

2. Configuración de Base de Datos
   spring.datasource.url=jdbc:postgresql://localhost:5432/bank_db
   spring.datasource.username=tu_usuario
   spring.datasource.password=tu_contrasena

3. Ejecutar la Aplicación
      Puedes correr el proyecto desde tu IDE (IntelliJ IDEA) o por terminal situándote en la raíz del proyecto:
    # Si usas Maven
    ./mvnw spring-boot:run
    # Si usas Gradle
    ./gradlew bootRun

4. Pruebas de Endpoints
   Una vez que la aplicación esté corriendo en el puerto 8080, puedes usar Postman o cURL para probar:
    Crear Cuenta: POST /api/bank/accounts
    Consultar Saldo: GET /api/bank/accounts/{id}
    Transferencia: POST /api/bank/accounts/transfer

