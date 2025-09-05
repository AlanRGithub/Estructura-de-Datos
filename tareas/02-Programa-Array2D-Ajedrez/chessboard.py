"""
- Tarea 2.- Programar el ADT Array2D -

Alumno: Martínez Martínez Alan Rafael.
Asignatura: Estructura de Datos.
Grupo: 1359.
Profesor: Hernández Cabrera Jesús.
Fecha de Entrega: 05/09/2025
"""
from array2d import Array2D

PIEZAS = {
    "K": "♔", "Q": "♕", "R": "♖", "B": "♗", "N": "♘", "P": "♙",  # blancas
    "k": "♚", "q": "♛", "r": "♜", "b": "♝", "n": "♞", "p": "♟",  # negras
}

def crear_tablero_inicial():
    board = Array2D(8, 8, "·")
    orden = ["r", "n", "b", "q", "k", "b", "n", "r"]
    for c, pieza in enumerate(orden):
        board.setElemento(0, c, PIEZAS[pieza])
    for c in range(8):
        board.setElemento(1, c, PIEZAS["p"])
    for c in range(8):
        board.setElemento(6, c, PIEZAS["P"])
    orden_blancas = ["R", "N", "B", "Q", "K", "B", "N", "R"]
    for c, pieza in enumerate(orden_blancas):
        board.setElemento(7, c, PIEZAS[pieza])
    return board

def renderizar_tablero_texto(board: Array2D) -> str:
    cols = "   " + "  ".join(list("a b c d e f g h".split()))
    lineas = [cols]
    separador = "  +" + "---+"*8
    for r in range(8):
        fila_num = 8 - r
        lineas.append(separador)
        piezas = []
        for c in range(8):
            piezas.append(board.getElemento(r, c))
        lineas.append(f"{fila_num} | " + " | ".join(piezas) + " |")
    lineas.append(separador)
    lineas.append(cols)
    return "\n".join(lineas)

def demo():
    board = crear_tablero_inicial()
    print("Tablero inicial:\n")
    print(renderizar_tablero_texto(board))

if __name__ == "__main__":
    demo()
