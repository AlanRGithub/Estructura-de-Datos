"""
- Tarea 2.- Programar el ADT Array2D -

Alumno: Martínez Martínez Alan Rafael.
Asignatura: Estructura de Datos.
Grupo: 1359.
Profesor: Hernández Cabrera Jesús.
Fecha de Entrega: 05/09/2025
"""
from typing import Any, List

class Array2D:
    def __init__(self, ren: int, col: int, fill_value: Any=None) -> None:
        if ren <= 0 or col <= 0:
            raise ValueError("ren y col deben ser > 0")
        self._ren = ren
        self._col = col
        self._data: List[List[Any]] = [[fill_value for _ in range(col)] for _ in range(ren)]

    def limpiar(self, dato: Any) -> None:
        for r in range(self._ren):
            for c in range(self._col):
                self._data[r][c] = dato

    def getRowSize(self) -> int:
        return self._ren

    def getColSize(self) -> int:
        return self._col

    def _check_bounds(self, ren: int, col: int) -> None:
        if not (0 <= ren < self._ren and 0 <= col < self._col):
            raise IndexError(f"Índices fuera de rango: (ren={ren}, col={col})")

    def setElemento(self, ren: int, col: int, dato: Any) -> None:
        self._check_bounds(ren, col)
        self._data[ren][col] = dato

    def getElemento(self, ren: int, col: int) -> Any:
        self._check_bounds(ren, col)
        return self._data[ren][col]

    def toString(self) -> str:
        filas = []
        for r in range(self._ren):
            filas.append("[" + ", ".join(str(self._data[r][c]) for c in range(self._col)) + "]")
        return "[\n  " + ",\n  ".join(filas) + "\n]"

    def __str__(self) -> str:
        return self.toString()

    def __repr__(self) -> str:
        return f"Array2D(ren={self._ren}, col={self._col})"
