# Tarea 7.- Balanceo de Código Fuente con Pila

**Alumno**: Martínez Martínez Alan Rafael  
**Asignatura**: Estructura de Datos  
**Grupo**: 1359  
**Profesor**: Hernández Cabrera Jesús  
**Fecha de Entrega**: 21/10/2025    

**Objetivo**: Implementar un verificador en Java basado en un autómata de pila vacía que:
- Revise que las llaves `{` y `}` en un archivo `.java` estén correctamente balanceadas.  
- Ignore llaves dentro de cadenas `"..."`, caracteres `'x'` y comentarios `//` y `/* ... */`.  
- Lea un archivo por ruta y muestre “Balanceado” o “No balanceado” en consola.  
- Maneje errores de lectura y evite operaciones inválidas sobre la pila.

## Estructura
- `PruebasPilas.java`  
- `PilaADT.java`  

## Ejecución
```bash
java PruebasPilas.java