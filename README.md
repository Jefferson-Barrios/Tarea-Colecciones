# Sistema de Gestión de Productos (CRUD) con ArrayList

## Enunciado del Proyecto

**Objetivo:** Desarrollar una aplicación de consola en Java que implemente un sistema CRUD (Crear, Leer, Actualizar, Eliminar) para gestionar un inventario de productos utilizando la colección `ArrayList`.

**Tiempo de desarrollo estimado:** 1 día.
**Tiempo de evaluación:** 2 minutos por pareja (1 minuto por estudiante).

### Requerimientos Funcionales

La aplicación debe cumplir con las siguientes operaciones utilizando un menú en consola:

1. **Crear:** Permitir el registro de un nuevo producto solicitando su ID (único), nombre y precio.
2. **Leer:** Mostrar por pantalla la lista completa de todos los productos registrados actualmente en el sistema.
3. **Actualizar:** Solicitar el ID de un producto existente y permitir modificar su precio. Si el producto no existe, informar al usuario.
4. **Eliminar:** Solicitar el ID de un producto y eliminarlo completamente del inventario.

### Restricciones y Arquitectura

- Debes guiarte estrictamente por el diagrama de clases adjunto (`diagrams/diagrama_clases.puml`).
- Es obligatorio el uso de la colección `ArrayList<Producto>` para almacenar y gestionar los datos de manera dinámica en memoria.
- Todo el código fuente (paquetes y clases como `Producto`, `GestorProductos` y `Main`) debe ubicarse ordenadamente dentro de la carpeta `src`.

### Metodología de Evaluación

La evaluación consistirá en una sustentación rápida de máximo **2 minutos** por pareja. El docente hará **una sola pregunta técnica** a cada estudiante relacionada al código desarrollado para validar su comprensión del manejo del `ArrayList`.
