import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.charset.StandardCharsets;

public class PruebasPilas {

    private static boolean estaBalanceado(String fuente) {
        PilaADT<Character> pila = new PilaADT<>();
        boolean enCadena = false;
        boolean enCaracter = false;
        boolean enComentarioLinea = false;
        boolean enComentarioBloque = false;
        boolean escape = false;

        for (int i = 0; i < fuente.length(); i++) {
            char c = fuente.charAt(i);
            char nxt = i + 1 < fuente.length() ? fuente.charAt(i + 1) : '\0';

            if (enComentarioLinea) {
                if (c == '\n') enComentarioLinea = false;
                continue;
            }

            if (enComentarioBloque) {
                if (c == '*' && nxt == '/') {
                    enComentarioBloque = false;
                    i++;
                }
                continue;
            }

            if (enCadena) {
                if (escape) {
                    escape = false;
                } else {
                    if (c == '\\') escape = true;
                    else if (c == '"') enCadena = false;
                }
                continue;
            }

            if (enCaracter) {
                if (escape) {
                    escape = false;
                } else {
                    if (c == '\\') escape = true;
                    else if (c == '\'') enCaracter = false;
                }
                continue;
            }

            if (c == '/' && nxt == '/') {
                enComentarioLinea = true;
                i++;
                continue;
            }

            if (c == '/' && nxt == '*') {
                enComentarioBloque = true;
                i++;
                continue;
            }

            if (c == '"') {
                enCadena = true;
                continue;
            }

            if (c == '\'') {
                enCaracter = true;
                continue;
            }

            if (c == '{') {
                pila.push('{');
                continue;
            }

            if (c == '}') {
                if (pila.isEmpty()) return false;
                pila.pop();
            }
        }

        return pila.isEmpty() && !enCadena && !enCaracter && !enComentarioBloque;
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            String ejemplo = "class A { String s = \"{ no cuenta }\"; /* { } */ char c='}'; void m(){ if(true){ } } }";
            boolean ok = estaBalanceado(ejemplo);
            System.out.println(ok ? "Balanceado" : "No balanceado");
            return;
        }

        try {
            String fuente = Files.readString(Path.of(args[0]), StandardCharsets.UTF_8);
            boolean ok = estaBalanceado(fuente);
            System.out.println(ok ? "Balanceado" : "No balanceado");
        } catch (Exception e) {
            System.out.println("Error leyendo el archivo: " + e.getMessage());
        }
    }
}
