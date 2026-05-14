# ADR-001: Uso de Arquitectura Hexagonal (Ports and Adapters)

## Estado
Aceptado

## Fecha
2026-05-14

## Contexto
El proyecto requiere una estructura que permita separar claramente la lógica de negocio (Gestión de Cuentas y Transferencias) de las tecnologías externas (Base de Datos, APIs REST, Notificaciones por Consola).

## Decisión
Se decidió implementar Arquitectura Hexagonal para desacoplar el dominio de las dependencias externas.

## Alternativas Consideradas
1. Arquitectura por Capas Tradicional (Controller -> Service -> Repository).
2. Arquitectura Hexagonal - **ELEGIDA**.

## Consecuencias
### Positivas
- Facilidad para realizar pruebas unitarias sobre el dominio sin mocks complejos.
- Flexibilidad para cambiar la base de datos o el canal de notificación sin tocar la lógica de negocio.
- Estructura organizada que facilita el trabajo en equipo paralelo (Clientes vs Cuentas).

### Negativas
- Mayor cantidad de archivos y clases (Mappers, Ports, Adapters).
- Curva de aprendizaje inicial más elevada para el equipo.