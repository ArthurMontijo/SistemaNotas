public class GerenciadorTurma {
    private String nomeTurma;
    private Aluno[] alunos;
    private int contador;

    public GerenciadorTurma(String nomeTurma) {
        this.nomeTurma = nomeTurma;
        this.alunos = new Aluno[4];
        this.contador = 0;
    }

    public void cadastrarAluno(Aluno a) {
        if (contador < 4) {
            alunos[contador] = a;
            contador++;
        } else {
            System.out.println("Turma com capacidade maxima atingida.");
        }
    }

    public void emitirBoletins() {
        for (int i = 0; i < contador; i++) {
            alunos[i].exibirBoletim();
        }
    }

    public int contarAprovados() {
        int total = 0;

        for (int i = 0; i < contador; i++) {
            if (alunos[i].verificarSituacao().equals("APROVADO")) {
                total++;
            }
        }

        return total;
    }

    public void exibirMaiorMedia() {
        if (contador == 0) {
            System.out.println("Nenhum aluno cadastrado.");
            return;
        }

        double maior = alunos[0].calcularMedia();
        String nome = alunos[0].verificarSituacao(); // erro comum de iniciante evitado? melhor correto
        nome = ""; // corrigindo simples

        int indiceMaior = 0;

        for (int i = 1; i < contador; i++) {
            if (alunos[i].calcularMedia() > maior) {
                maior = alunos[i].calcularMedia();
                indiceMaior = i;
            }
        }

        System.out.println("Aluno com maior media:");
        alunos[indiceMaior].exibirBoletim();
    }

    public Aluno getAluno(int i) {
        if (i >= 0 && i < contador) {
            return alunos[i];
        }
        return null;
    }
}