
import java.util.ArrayList;
import java.util.List;

public class Aluno {

    private int id;
    private int curso;
    private List<Disciplina> disciplinas;

    public Aluno(int id, int curso) {
        this.id = id;
        this.curso = curso;
        this.disciplinas = new ArrayList<>();
    }

    public void adicionarDisciplina(Disciplina d) {
        disciplinas.add(d);
    }

    public int getCurso() {
        return curso;
    }

    public int getId() {
        return id;
    }

    public double calcularCR() {

        double soma = 0;
        int cargaTotal = 0;

        for (Disciplina d : disciplinas) {
            soma += d.getNota() * d.getCargaHoraria();
            cargaTotal += d.getCargaHoraria();
        }

        if (cargaTotal == 0) return 0;

        return soma / cargaTotal;
    }
}
