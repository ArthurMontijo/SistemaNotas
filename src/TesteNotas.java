import java.util.Scanner;

public class TesteNotas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        GerenciadorTurma turma = new GerenciadorTurma("3o Ano A");

        Aluno a1 = new Aluno("Arthur", "001");
        Aluno a2 = new Aluno("Guilherme", "002");
        Aluno a3 = new Aluno();

        a1.lancarNotas(7, 8, 6);
        a2.lancarNotas(5, 4, 6);
        a3.lancarNotas(3, 4, 2);

        turma.cadastrarAluno(a1);
        turma.cadastrarAluno(a2);
        turma.cadastrarAluno(a3);

        int opcao;

        do {
            System.out.println("===== SISTEMA DE NOTAS – 3o Ano A =====");
            System.out.println("1 – Emitir boletins");
            System.out.println("2 – Quantidade de aprovados");
            System.out.println("3 – Maior media");
            System.out.println("4 – Lancar notas por indice");
            System.out.println("0 – Sair");
            System.out.print("Escolha: ");

            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    turma.emitirBoletins();
                    break;

                case 2:
                    System.out.println("Aprovados: " + turma.contarAprovados());
                    break;

                case 3:
                    turma.exibirMaiorMedia();
                    break;

                case 4:
                    System.out.print("Indice do aluno (0 a 2): ");
                    int i = sc.nextInt();

                    Aluno aluno = turma.getAluno(i);

                    if (aluno != null) {
                        System.out.print("Nota 1: ");
                        double n1 = sc.nextDouble();
                        System.out.print("Nota 2: ");
                        double n2 = sc.nextDouble();
                        System.out.print("Nota 3: ");
                        double n3 = sc.nextDouble();

                        aluno.lancarNotas(n1, n2, n3);
                        aluno.exibirBoletim();
                    } else {
                        System.out.println("Indice invalido.");
                    }
                    break;

                case 0:
                    System.out.println("Sistema encerrado.");
                    break;

                default:
                    System.out.println("Opcao invalida. Tente novamente.");
            }

        } while (opcao != 0);

        sc.close();
    }
}