# Tarea 9.- Implementar el árbol binario de búsqueda (BST) de las diapositivas de árboles binarios 

**Alumno**: Martínez Martínez Alan Rafael  
**Asignatura**: Estructura de Datos  
**Grupo**: 1359  
**Profesor**: Hernández Cabrera Jesús  
**Fecha de Entrega**: 11/11/2025 

**Objetivo**:  
Crear un programa en Java que:
- Implemente un **árbol binario de búsqueda (BST)** conforme a las diapositivas.
- Cree una clase `BinarySearchTree` con las operaciones:
  - `BinarySearchTree()` (constructor).
  - `Insert(value)` para insertar un entero en su posición correspondiente (sin duplicados).
  - `remove(value)` para eliminar el nodo con dicho valor (hoja, un hijo o dos hijos).
  - `search(value)` que regresa el nodo si existe; en otro caso `null`.
  - `transversal(format)` para recorridos **preorden**, **inorden** y **postorden**.
- Mostrar el funcionamiento con inserciones, búsquedas, recorridos y una eliminación.

## Estructura
- `Recursividad.java`  
  Contiene:
  - Clase estática `BinarySearchTree` (nodo interno `Nodo` con `dato`, `izq`, `der`).
  - Métodos `Insert(int)`, `remove(int)`, `search(int)` y `transversal(String)` que devuelve `List<Integer>`.
  - Método `main` que inserta `{8, 3, 10, 1, 6, 14, 4, 7, 13, 6, 3, 10}`, muestra los tres recorridos, busca `7` y `2`, elimina `3` y vuelve a mostrar el inorden.

## Ejecución
```bash
java Recursividad.java