# Tarea 8.- Ejemplo HashMap Java

**Alumno**: Martínez Martínez Alan Rafael
**Asignatura**: Estructura de Datos
**Grupo**: 1359
**Profesor**: Hernández Cabrera Jesús
**Fecha de Entrega**: 24/10/2025

**Objetivo**: Implementar en Java un catálogo de videojuegos usando la clase `HashMap` de la API Collections que:
- Defina una clase propia `Videojuego` con `titulo`, `estudio`, `anio` e `id`.
- Inserte 10 objetos `Videojuego` en un `HashMap<String, Videojuego>` usando `put`.
- Muestre el contenido completo del mapa por consola.
- Obtenga el valor de dos elementos previamente insertados con `get`.
- Elimine dos elementos a elección con `remove`.
- Vuelva a mostrar el contenido del mapa para comprobar los cambios.

> Nota: Si se desea mantener el **orden de inserción** en la impresión, puede usarse `LinkedHashMap` en lugar de `HashMap` sin cambiar la lógica del programa.

## Estructura
- `App.java`
  Contiene:
  - Clase estática `Videojuego` (modelo de datos).
  - Método `imprimir(Map<String, Videojuego>)` para listar pares clave–valor.
  - Método `main` que crea el mapa, inserta los 10 videojuegos, consulta dos, elimina dos y muestra el catálogo antes y después.

## Ejecución
```bash
java App.java