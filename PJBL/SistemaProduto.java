package PJBL;

import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SistemaProduto {

    private static final String FILE_PATH = "src/PJBL/";
    private static final String FILE_NAME = FILE_PATH + "produtos.txt";

    public static List<String> carregarProdutos() throws LoginException {
        List<String> produtos = new ArrayList<>();
        File file = new File(FILE_NAME);

        if (!file.exists()) {
            try {
                if (file.createNewFile()) {
                    System.out.println("Arquivo de produtos criado com sucesso.");
                } else {
                    throw new LoginException("Erro ao criar o arquivo de produtos: motivo desconhecido.");
                }
            } catch (IOException e) {
                throw new LoginException("Erro ao criar o arquivo de produtos: " + e.getMessage());
            }
        }

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                produtos.add(linha);
            }
        } catch (IOException e) {
            throw new LoginException("Erro ao carregar produtos: " + e.getMessage());
        }

        return produtos;
    }

    public static void cadastrar(String produto) throws LoginException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            bw.newLine();
            bw.write(produto);
        } catch (IOException e) {
            throw new LoginException("Erro ao salvar produto: " + e.getMessage());
        }
    }

    public static void editarProduto(Scanner scanner, List<String> produtos) throws LoginException {
        System.out.println("-- Editar Produtos --");
        listarProdutos(produtos);

        System.out.println("Selecione o número do produto que deseja editar:");
        int produtoIndex = Integer.parseInt(scanner.nextLine()) - 1;

        if (produtoIndex >= 0 && produtoIndex < produtos.size()) {
            System.out.println("Selecione o que deseja editar:");
            System.out.println("1. Editar Nome");
            System.out.println("2. Editar Preço");
            int escolha = Integer.parseInt(scanner.nextLine());

            if (escolha == 1) {
                System.out.println("Digite o novo nome para o produto:");
                String novoNomeProduto = scanner.nextLine();
                String produto = produtos.get(produtoIndex);
                String[] partes = produto.split(",");
                partes[0] = novoNomeProduto;
                produtos.set(produtoIndex, String.join(",", partes));
                salvarProdutos(produtos);
                System.out.println("Nome do produto editado com sucesso.");
            } else if (escolha == 2) {
                System.out.println("Digite o novo preço para o produto:");
                double novoPrecoProduto = Double.parseDouble(scanner.nextLine());
                String produto = produtos.get(produtoIndex);
                String[] partes = produto.split(",");
                partes[1] = Double.toString(novoPrecoProduto);
                produtos.set(produtoIndex, String.join(",", partes));
                salvarProdutos(produtos);
                System.out.println("Preço do produto editado com sucesso.");
            } else {
                System.out.println("Opção inválida.");
            }
        } else {
            System.out.println("Número de produto inválido.");
        }
    }

    private static void listarProdutos(List<String> produtos) {
        System.out.println("Produtos Carregados:");
        for (int i = 0; i < produtos.size(); i++) {
            System.out.println((i + 1) + ". " + produtos.get(i));
        }
    }

    private static void salvarProdutos(List<String> produtos) throws LoginException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (String produto : produtos) {
                bw.write(produto);
                bw.newLine();
            }
        } catch (IOException e) {
            throw new LoginException("Erro ao salvar produtos: " + e.getMessage());
        }
    }

}
