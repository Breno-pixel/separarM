import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Pessoa> pessoas = new ArrayList<>();

        System.out.println("Digite os dados das pessoas (nome e gênero separados por vírgula, ou 'sair' para finalizar):");
        while (true) {
            System.out.print("Entrada: ");
            String entrada = scanner.nextLine();

            if (entrada.equalsIgnoreCase("sair")) {
                break;
            }

            String[] dados = entrada.split(",");
            if (dados.length == 2) {
                String nome = dados[0].trim();
                String genero = dados[1].trim().toLowerCase(); // Normaliza para evitar erros de maiúsculas/minúsculas

                // Adiciona pessoa à lista
                pessoas.add(new Pessoa(nome, genero));
            } else {
                System.out.println("Entrada inválida! Digite no formato: nome,gênero");
            }
        }

        List<Pessoa> mulheres = pessoas.stream()
                .filter(pessoa -> "feminino".equalsIgnoreCase(pessoa.getGenero()))
                .collect(Collectors.toList());

        // Exibição dos resultados
        System.out.println("\nLista completa de pessoas:");
        pessoas.forEach(System.out::println);

        System.out.println("\nLista de mulheres:");
        mulheres.forEach(System.out::println);

        scanner.close();
    }
}

class Pessoa {
    private String nome;
    private String genero;

    public Pessoa(String nome, String genero) {
        this.nome = nome;
        this.genero = genero;
    }

    public String getNome() {
        return nome;
    }

    public String getGenero() {
        return genero;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ", Gênero: " + genero;
    }
}
