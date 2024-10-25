package desafiosupremo;

import java.util.Scanner;

public class DesafioSupremo {

    public static void entrarNoGame() {

        System.out.println("|-------------------------------------|");
        System.out.println("|--------------Bem vindo--------------|");
        System.out.println("|-------------------------------------|");

        System.out.println("Espero que se divirta!");
    }

    public static int sortearNumero() {
        return (int) (Math.random() * 100) + 1;
    }

    public static String verificarPalpite(int numSorte, int tentativa) {

        if (tentativa == numSorte) {
            System.out.println("Parabéns! Você acertou!");
            return "Acertou!";
        } else if (tentativa > numSorte) {
            System.out.println("Xiii! Errou. O número da sorte é menor que isso!");
        } else {
            System.out.println("Vish... O número da sorte é maior que isso.");
        }
        return "Errou!";
    }

    public static void mostrarPontuacao(int tentativas) {
        int pontos = 99 - tentativas;
        System.out.println("Você fez " + pontos + " pontos.");
    }

    public static int duplicarAposta(int aposta, String resultado) {

        if (resultado.equals("Acertou!")) {
            return aposta * 2;
        }
        return aposta;
    }

    public static int apostarTudo(int aposta, int palpite, int numSorteFinal) {

        if (palpite == numSorteFinal) {
            return aposta *= 5;
        }
        return aposta = 0;
    }

    public static void main(String[] args) {

        Scanner ler = new Scanner(System.in);
        String resultado = "Acertou!";
        int continuar = 1, tentativas = 0, aposta, again = 1, numSorte = 0, cont = 0;

        entrarNoGame();
        System.out.println("Deseja apostar qual valor? A cada acerto o valor atual será dobrado!");
        aposta = ler.nextInt();

        while (continuar != 2) {

            while (again == 1) {

                if (resultado.equals("Acertou!")) {
                    numSorte = sortearNumero();
                }

                System.out.println("tentativa: ");
                tentativas = ler.nextInt();
                resultado = verificarPalpite(numSorte, tentativas);
                cont++;

                if (resultado.equals("Acertou!")) {
                    mostrarPontuacao(cont);
                    again = 2;
                }
            }

            aposta = duplicarAposta(aposta, resultado);
            System.out.println("aposta:>" + aposta);
            System.out.println("Deseja jogar de novo? (1 p/ sim e 2 p/ não)");
            continuar = ler.nextInt();
            if (continuar == 1) {
                again = 1;
                resultado = "Acertou!";
            }

        }

        System.out.println("Quer ter a ultima chance de aumentar a banca?");

        System.out.println("Proponho um último jogo: Penso em número de 1 a 3, "
                + "caso acerte iremos QUINTUPLICAR a banca, porém caso erre perderá tudo!");

        System.out.println("1 para sim e 2 para não. ");

        int desafioFinal = ler.nextInt();

        if (desafioFinal != 1) {
            System.out.println("Obrigado por participar!");
        } else {

            if (desafioFinal == 1) {
                int numSorteFinal = (int) (Math.random() * 3) + 1;
                System.out.println("Qual será teu número sorteado?? Lembrando que é de 1 a 3!");
                int palpite = ler.nextInt();
                aposta = apostarTudo(aposta, palpite, numSorteFinal);
                if (aposta != 0) {
                    System.out.println("Quintuplicou tudo! Ta rico!");
                    System.out.println("Saldo final: " + aposta);
                } else {
                    System.out.println("Perdeu tudinho.");
                    System.out.println("Saldo final: " + aposta);
                }
            }
            System.out.println("Obrigado por jogar até o fim!");
        }

    }

}
