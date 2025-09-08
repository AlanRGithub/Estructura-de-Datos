"""
- Tarea 3.- Juego de la vida -

Alumno: Martínez Martínez Alan Rafael.
Asignatura: Estructura de Datos.
Grupo: 1359.
Profesor: Hernández Cabrera Jesús.
Fecha de Entrega: 09/09/2025
"""
from __future__ import annotations
from typing import Iterable, List, Tuple, Set
import time


class Array2D:

    def __init__(self, ren: int, col: int, fill: int = 0) -> None:
        if ren <= 0 or col <= 0:
            raise ValueError("Las dimensiones deben ser positivas")
        self._ren = ren
        self._col = col
        self._data: List[List[int]] = [[fill for _ in range(col)] for _ in range(ren)]

    def limpiar(self, dato: int) -> None:
        for r in range(self._ren):
            for c in range(self._col):
                self._data[r][c] = dato

    def getRowSize(self) -> int:
        return self._ren

    def getColSize(self) -> int:
        return self._col

    def setElemento(self, ren: int, col: int, dato: int) -> None:
        self._validar_indices(ren, col)
        self._data[ren][col] = dato

    def getElemento(self, ren: int, col: int) -> int:
        self._validar_indices(ren, col)
        return self._data[ren][col]

    def _validar_indices(self, ren: int, col: int) -> None:
        if not (0 <= ren < self._ren and 0 <= col < self._col):
            raise IndexError(f"Índices fuera de rango: ({ren}, {col})")

    def toString(self) -> str:
        filas = ["[" + ", ".join(str(x) for x in fila) + "]" for fila in self._data]
        return "[\n  " + ",\n  ".join(filas) + "\n]"

    def __str__(self) -> str:
        return self.toString()


class GameOfLife:

    VIVA = 1
    MUERTA = 0

    def __init__(self, filas: int, columnas: int, vivas_iniciales: Iterable[Tuple[int, int]] = ()) -> None:
        self.generation = 0
        self.grid = Array2D(filas, columnas, fill=self.MUERTA)
        for r, c in vivas_iniciales:
            if 0 <= r < filas and 0 <= c < columnas:
                self.grid.setElemento(r, c, self.VIVA)

    @property
    def filas(self) -> int:
        return self.grid.getRowSize()

    @property
    def columnas(self) -> int:
        return self.grid.getColSize()

    def _vecinos_vivos(self, r: int, c: int) -> int:
        conteo = 0
        for dr in (-1, 0, 1):
            for dc in (-1, 0, 1):
                if dr == 0 and dc == 0:
                    continue
                rr, cc = r + dr, c + dc
                if 0 <= rr < self.filas and 0 <= cc < self.columnas:
                    conteo += 1 if self.grid.getElemento(rr, cc) == self.VIVA else 0
        return conteo

    def paso(self) -> None:
        nueva = Array2D(self.filas, self.columnas, fill=self.MUERTA)
        for r in range(self.filas):
            for c in range(self.columnas):
                estado = self.grid.getElemento(r, c)
                vecinos = self._vecinos_vivos(r, c)
                if estado == self.VIVA:
                    # num 1: sobrevive con 2 o 3 vecinos
                    if vecinos in (2, 3):
                        nueva.setElemento(r, c, self.VIVA)
                    else:
                        # num 2 y 3: muere por soledad (<2) o sobrepoblación (>=4)
                        nueva.setElemento(r, c, self.MUERTA)
                else:
                    # num 4: Nace con exactamente 3 vecinos
                    if vecinos == 3:
                        nueva.setElemento(r, c, self.VIVA)
                    else:
                        nueva.setElemento(r, c, self.MUERTA)
        self.grid = nueva
        self.generation += 1

    def render(self) -> str:
        # "█" para viva y "·" para muerta
        filas_str: List[str] = []
        for r in range(self.filas):
            fila = []
            for c in range(self.columnas):
                fila.append("█" if self.grid.getElemento(r, c) == self.VIVA else "·")
            filas_str.append("".join(fila))
        return "\n".join(filas_str)


# ---------------------------------
# configuración inicial editable :D
# ---------------------------------

def configuracion_inicial() -> Set[Tuple[int, int]]:

    vivas: Set[Tuple[int, int]] = set()

    # Bloque 2x2 (estable)
    vivas.update({(5, 5), (5, 6), (6, 5), (6, 6)})

    # Parpadeador (blinker)
    vivas.update({(10, 10), (10, 11), (10, 12)})

    # Planeador (glider)
    glider = {(1, 2), (2, 3), (3, 1), (3, 2), (3, 3)}
    vivas.update(glider)

    return vivas


# --------------------------------
# main: muestra 10 generaciones :O
# --------------------------------

def main() -> None:
    filas, columnas = 15, 30  # Puedes ajustar el tamaño del tablero
    generaciones = 10         # La consigna pide mostrar 10 generaciones

    juego = GameOfLife(filas, columnas, configuracion_inicial())

    print(f"Generación {juego.generation}")
    print(juego.render())

    for _ in range(generaciones):
        juego.paso()
        print("\n" + "=" * columnas)
        print(f"Generación {juego.generation}")
        print(juego.render())


if __name__ == "__main__":
    main()
