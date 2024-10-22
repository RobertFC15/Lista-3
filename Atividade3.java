/*Robert Franklin C. Coelho
 * Desenvolvimento de Aplicações
 * Turma C
 */

import java.util.Random;
import java.util.Scanner;

public class Atividade3 {
    private static char[][] tabuleiro = new char[3][3];
    private static final char JOGADOR = 'X';
    private static final char COMPUTADOR = 'O';
    private static final char VAZIO = ' ';
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("Escolha a dificuldade:");
            System.out.println("1. Normal");
            System.out.println("2. Difícil");
            System.out.print("Opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); 

            inicializarTabuleiro();
            boolean jogoEmAndamento = true;

            while (jogoEmAndamento) {
                exibirTabuleiro();
                jogadorFazJogada(scanner);

                if (verificarVencedor(JOGADOR)) {
                    exibirTabuleiro();
                    System.out.println("Você venceu!");
                    jogoEmAndamento = false;
                } else if (verificarEmpate()) {
                    exibirTabuleiro();
                    System.out.println("Empate!");
                    jogoEmAndamento = false;
                } else {
                    if (opcao == 1) {
                        computadorFazJogadaAleatoria();
                    } else {
                        computadorFazJogadaDificil();
                    }

                    if (verificarVencedor(COMPUTADOR)) {
                        exibirTabuleiro();
                        System.out.println("O computador venceu!");
                        jogoEmAndamento = false;
                    } else if (verificarEmpate()) {
                        exibirTabuleiro();
                        System.out.println("Empate!");
                        jogoEmAndamento = false;
                    }
                }
            }

            System.out.print("Deseja começar um novo jogo? (s/n): ");
        } while (scanner.nextLine().equalsIgnoreCase("s"));
        
        scanner.close();
    }

    private static void inicializarTabuleiro() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tabuleiro[i][j] = VAZIO;
            }
        }
    }

    private static void exibirTabuleiro() {
        System.out.println("Tabuleiro:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(tabuleiro[i][j]);
                if (j < 2) System.out.print("|");
            }
            System.out.println();
            if (i < 2) System.out.println("-----");
        }
    }

    private static void jogadorFazJogada(Scanner scanner) {
        int linha, coluna;
        do {
            System.out.print("Digite a linha (0-2) e a coluna (0-2) da sua jogada: ");
            linha = scanner.nextInt();
            coluna = scanner.nextInt();
        } while (linha < 0 || linha > 2 || coluna < 0 || coluna > 2 || tabuleiro[linha][coluna] != VAZIO);
        
        tabuleiro[linha][coluna] = JOGADOR;
    }

    private static void computadorFazJogadaAleatoria() {
        Random random = new Random();
        int linha, coluna;

        do {
            linha = random.nextInt(3);
            coluna = random.nextInt(3);
        } while (tabuleiro[linha][coluna] != VAZIO);

        tabuleiro[linha][coluna] = COMPUTADOR;
    }

    private static void computadorFazJogadaDificil() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tabuleiro[i][j] == VAZIO) {
                    tabuleiro[i][j] = COMPUTADOR;
                    if (verificarVencedor(COMPUTADOR)) return;
                    tabuleiro[i][j] = VAZIO;
                }
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tabuleiro[i][j] == VAZIO) {
                    tabuleiro[i][j] = JOGADOR;
                    if (verificarVencedor(JOGADOR)) {
                        tabuleiro[i][j] = COMPUTADOR;
                        return;
                    }
                    tabuleiro[i][j] = VAZIO;
                }
            }
        }

        computadorFazJogadaAleatoria();
    }

    private static boolean verificarVencedor(char jogador) {
        for (int i = 0; i < 3; i++) {
            if ((tabuleiro[i][0] == jogador && tabuleiro[i][1] == jogador && tabuleiro[i][2] == jogador) ||
                (tabuleiro[0][i] == jogador && tabuleiro[1][i] == jogador && tabuleiro[2][i] == jogador)) {
                return true;
            }
        }
        return (tabuleiro[0][0] == jogador && tabuleiro[1][1] == jogador && tabuleiro[2][2] == jogador) ||
               (tabuleiro[0][2] == jogador && tabuleiro[1][1] == jogador && tabuleiro[2][0] == jogador);
    }

    private static boolean verificarEmpate() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tabuleiro[i][j] == VAZIO) return false;
            }
        }
        return true;
    }
}
