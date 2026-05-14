# ADR-002: Sistema de Persistencia (PostgreSQL)

## Estado
Aceptado

## Fecha
2026-05-14

## Contexto
El sistema requiere gestionar transacciones financieras (transferencias y saldos) que exigen integridad de datos, soporte para transacciones ACID y persistencia a largo plazo. Dado que el modelo de dominio incluye relaciones claras entre Clientes y Cuentas, se requiere un motor de base de datos relacional robusto.

## Decisión
Se decidió utilizar **PostgreSQL** como el sistema de gestión de base de datos principal.

## Alternativas Consideradas
1. **H2 Database (In-Memory)**: Descartada debido a la volatilidad de los datos; los registros se pierden al reiniciar la aplicación, lo cual no es aceptable para un sistema bancario, incluso en etapa de desarrollo.
2. **PostgreSQL** - **ELEGIDA**: Provee persistencia real, soporte nativo para tipos de datos avanzados (como `BIGSERIAL`) y una gestión de concurrencia superior.

## Consecuencias
### Positivas
- **Persistencia de Datos:** Los saldos y registros de clientes se mantienen seguros incluso si el servidor de aplicaciones se detiene.
- **Integridad:** Uso de Constraints y Tipos de Datos específicos para asegurar que los datos financieros sean consistentes.
- **Escalabilidad:** Preparado para un entorno de producción real y compatible con herramientas de monitoreo profesionales.

### Negativas
- **Dependencia Externa:** Requiere tener un servidor de PostgreSQL o un contenedor de Docker corriendo para que la aplicación inicie.
- **Configuración:** Mayor complejidad en el `application.properties` (credenciales, URL de conexión y drivers).