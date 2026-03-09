
public class Disciplina {

    private String nome;
    private int cargaHoraria;
    private double nota;

    public Disciplina(String nome, int cargaHoraria, double nota) {
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
        this.nota = nota;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public double getNota() {
        return nota;
    }
}
