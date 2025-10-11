from collections import deque
from dataclasses import dataclass

@dataclass
class Paciente:
    nombre: str
    edad: int
    estatura: float

class ColaPacientes:
    def __init__(self):
        self.cola = deque()

    def registrar(self, paciente: Paciente):
        self.cola.append(paciente)

    def atender(self):
        if self.esta_vacia():
            return None
        return self.cola.popleft()

    def mostrar(self):
        return list(self.cola)

    def esta_vacia(self):
        return len(self.cola) == 0

def pedir_entero(mensaje):
    while True:
        valor = input(mensaje).strip()
        if valor.isdigit():
            return int(valor)
        try:
            return int(float(valor))
        except:
            print("Ingresa un número válido.")

def pedir_float(mensaje):
    while True:
        valor = input(mensaje).strip().replace(",", ".")
        try:
            return float(valor)
        except:
            print("Ingresa un número válido.")

def pedir_nombre(mensaje):
    while True:
        nombre = input(mensaje).strip()
        if nombre:
            return nombre
        print("El nombre no puede estar vacío.")

def imprimir_estado(cola: ColaPacientes):
    if cola.esta_vacia():
        print("\nNo hay pacientes esperando.\n")
        return
    print("\nPacientes en espera:")
    for i, p in enumerate(cola.mostrar(), start=1):
        print(f"{i}. {p.nombre} (edad: {p.edad}, estatura: {p.estatura:.2f} m)")
    print()

def menu():
    print("\n--- Gestión de Cola de Pacientes ---")
    print("1) Registrar llegada de paciente")
    print("2) Atender paciente")
    print("3) Mostrar estado de la cola")
    print("4) Verificar si la cola está vacía")
    print("0) Salir")

def main():
    cola = ColaPacientes()
    while True:
        menu()
        opcion = input("Elige una opción: ").strip()
        if opcion == "1":
            nombre = pedir_nombre("Nombre del paciente: ")
            edad = pedir_entero("Edad del paciente: ")
            estatura = pedir_float("Estatura en metros (ej. 1.72): ")
            cola.registrar(Paciente(nombre, edad, estatura))
            print(f"Se registró a {nombre}.")
        elif opcion == "2":
            paciente = cola.atender()
            if paciente is None:
                print("No hay pacientes para atender.")
            else:
                print(f"Atendiendo a {paciente.nombre} | Edad: {paciente.edad} | Estatura: {paciente.estatura:.2f} m")
        elif opcion == "3":
            imprimir_estado(cola)
        elif opcion == "4":
            print("La cola está vacía." if cola.esta_vacia() else "Hay pacientes esperando.")
        elif opcion == "0":
            print("Saliendo...")
            break
        else:
            print("Opción no válida.")

if __name__ == "__main__":
    main()
