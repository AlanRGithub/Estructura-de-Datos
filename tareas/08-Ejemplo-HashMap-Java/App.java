import java.util.LinkedHashMap;
import java.util.HashMap;
import java.util.Map;

public class App {
    static class Videojuego {
        private final String titulo;
        private final String estudio;
        private final int anio;
        private final String id;

        public Videojuego(String titulo, String estudio, int anio, String id) {
            this.titulo = titulo;
            this.estudio = estudio;
            this.anio = anio;
            this.id = id;
        }

        public String getId() {
            return id;
        }

        @Override
        public String toString() {
            return titulo + " | " + estudio + " | " + anio + " | " + id;
        }
    }

    public static void imprimir(Map<String, Videojuego> mapa) {
        if (mapa.isEmpty()) {
            System.out.println("(vacío)");
            return;
        }
        for (Map.Entry<String, Videojuego> e : mapa.entrySet()) {
            System.out.println(e.getKey() + " -> " + e.getValue());
        }
    }

    public static void main(String[] args) {
        Map<String, Videojuego> catalogo = new LinkedHashMap<>();

        Videojuego v1 = new Videojuego("The Legend of Zelda: Breath of the Wild", "Nintendo", 2017, "G1");
        Videojuego v2 = new Videojuego("God of War", "Santa Monica Studio", 2018, "G2");
        Videojuego v3 = new Videojuego("Hollow Knight", "Team Cherry", 2017, "G3");
        Videojuego v4 = new Videojuego("Red Dead Redemption 2", "Rockstar Games", 2018, "G4");
        Videojuego v5 = new Videojuego("Celeste", "Maddy Makes Games", 2018, "G5");
        Videojuego v6 = new Videojuego("Elden Ring", "FromSoftware", 2022, "G6");
        Videojuego v7 = new Videojuego("Stardew Valley", "ConcernedApe", 2016, "G7");
        Videojuego v8 = new Videojuego("Minecraft", "Mojang", 2011, "G8");
        Videojuego v9 = new Videojuego("Portal 2", "Valve", 2011, "G9");
        Videojuego v10 = new Videojuego("Super Mario Odyssey", "Nintendo", 2017, "G10");

        catalogo.put(v1.getId(), v1);
        catalogo.put(v2.getId(), v2);
        catalogo.put(v3.getId(), v3);
        catalogo.put(v4.getId(), v4);
        catalogo.put(v5.getId(), v5);
        catalogo.put(v6.getId(), v6);
        catalogo.put(v7.getId(), v7);
        catalogo.put(v8.getId(), v8);
        catalogo.put(v9.getId(), v9);
        catalogo.put(v10.getId(), v10);

        System.out.println("Contenido inicial del HashMap:");
        imprimir(catalogo);
        System.out.println();

        System.out.println("Consulta de dos videojuegos:");
        System.out.println("G3 -> " + catalogo.get("G3"));
        System.out.println("G6 -> " + catalogo.get("G6"));
        System.out.println();

        System.out.println("Eliminando G2 y G9...");
        catalogo.remove("G2");
        catalogo.remove("G9");
        System.out.println();

        System.out.println("Contenido final del HashMap:");
        imprimir(catalogo);
    }
}
