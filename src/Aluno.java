public class Aluno {
    private String nome;
    private String matricula;
    private double nota1, nota2, nota3;

    public Aluno(String nome, String matricula) {
        this.nome = nome;
        this.matricula = matricula;
        this.nota1 = 0.0;
        this.nota2 = 0.0;
        this.nota3 = 0.0;
    }

    public Aluno() {
        this.nome = "Sem Nome";
        this.matricula = "000";
        this.nota1 = 0.0;
        this.nota2 = 0.0;
        this.nota3 = 0.0;
    }

    public void lancarNotas(double n1, double n2, double n3) {
        this.nota1 = n1;
        this.nota2 = n2;
        this.nota3 = n3;
    }

    public double calcularMedia() {
        return (nota1 + nota2 + nota3) / 3;
    }

    public String verificarSituacao() {
        double media = calcularMedia();

        if (media >= 6.0) {
            return "APROVADO";
        } else if (media >= 4.0) {
            return "RECUPERACAO";
        } else {
            return "REPROVADO";
        }
    }

    public void exibirBoletim() {
        double media = calcularMedia();

        System.out.println("Nome: " + nome);
        System.out.println("Matricula: " + matricula);
        System.out.println("Nota 1: " + nota1);
        System.out.println("Nota 2: " + nota2);
        System.out.println("Nota 3: " + nota3);
        System.out.printf("Media: %.2f\n", media);
        System.out.println("Situacao: " + verificarSituacao());
        System.out.println("----------------------");
    }
}