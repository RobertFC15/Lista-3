/*Robert Franklin C. Coelho
 * Desenvolvimento de Aplicações
 * Turma C
 */
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Atividade1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer[] numeros = new Integer[10];

        System.out.println("Insira 10 números:");
        for (int i = 0; i < 10; i++) {
            System.out.print("Número " + (i + 1) + ": ");
            numeros[i] = scanner.nextInt();
        }

        System.out.println("Lista original: " + Arrays.toString(numeros));

        Arrays.sort(numeros);
        System.out.println("Lista ordenada em ordem crescente: " + Arrays.toString(numeros));

        Arrays.sort(numeros, Collections.reverseOrder());
        System.out.println("Lista ordenada em ordem decrescente: " + Arrays.toString(numeros));
        
        scanner.close();
    }
}
