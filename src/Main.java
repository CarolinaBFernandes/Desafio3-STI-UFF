import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        Map<Integer, Aluno> alunos = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader("notas.csv"))) {

            String linha = br.readLine(); // pula cabeçalho

            while ((linha = br.readLine()) != null) {

                if (linha.isEmpty()) continue;

                String[] dados = linha.split(",");

                int matricula = Integer.parseInt(dados[0]);
                String disciplina = dados[1];
                int curso = Integer.parseInt(dados[2]);
                double nota = Double.parseDouble(dados[3]);
                int carga = Integer.parseInt(dados[4]);

                alunos.putIfAbsent(matricula, new Aluno(matricula, curso));

                alunos.get(matricula)
                        .adicionarDisciplina(new Disciplina(disciplina, carga, nota));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("------- O CR dos alunos é: --------");

        Map<Integer, Double> somaCursos = new HashMap<>();
        Map<Integer, Integer> qtdCursos = new HashMap<>();

        for (Aluno aluno : alunos.values()) {

            double cr = aluno.calcularCR();

            System.out.println(aluno.getId() + " - " + String.format(Locale.US,"%.2f", cr));

            int curso = aluno.getCurso();

            somaCursos.put(curso, somaCursos.getOrDefault(curso, 0.0) + cr);
            qtdCursos.put(curso, qtdCursos.getOrDefault(curso, 0) + 1);
        }

        System.out.println("-----------------------------------");
        System.out.println("----- Média de CR dos cursos ------");

        for (Integer curso : somaCursos.keySet()) {

            double media = somaCursos.get(curso) / qtdCursos.get(curso);

            System.out.println(curso + " - " + String.format(Locale.US,"%.2f", media));
        }

        System.out.println("-----------------------------------");
    }
}