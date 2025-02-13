package com.example.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.example.dominio.*;
import com.example.util.ConverterData;


public class Biblioteca {
    private List<Livro> livros;
    private List<Emprestimo> emprestimos;
    private Scanner scanner;

    public Biblioteca() {
        livros = new ArrayList<>();
        emprestimos = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    // Cadastrar livro
    public void cadastrarLivro() {
        System.out.print("Digite o autor do livro: ");
        String autor = scanner.nextLine();
        System.out.print("Digite o título do livro: ");
        String titulo = scanner.nextLine();
        System.out.print("Digite a editora do livro: ");
        String editora = scanner.nextLine();
        System.out.print("Digite o ano de publicação: ");
        int ano = scanner.nextInt();
        scanner.nextLine(); 

        Livro livro = new Livro(autor, titulo, editora, ano);
        livros.add(livro);
        System.out.println("Livro cadastrado com sucesso!");
    }


    // Cadastrar usuário
    public void cadastrarUsuario() {
        System.out.print("Digite o nome do usuário: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o CPF do usuário: ");
        String cpf = scanner.nextLine();
        System.out.print("Digite o e-mail do usuário: ");
        String email = scanner.nextLine();
        String preferenciaNotificacao;

        while(true) {
            System.out.println("\nEscolha como deseja receber as suas notificações");
            System.out.println("1 - SMS");
            System.out.println("2 - E-mail");
            System.out.print("Opção: ");
            preferenciaNotificacao = scanner.nextLine().trim();
            if (email.isEmpty()){
                System.out.println("A preferência de notificações é obrigatório!");
                continue;
            }
            break;
        }

        List<Usuario> usuarios = new ArrayList<>();
                usuarios.add(new Usuario(nome, cpf, email, preferenciaNotificacao));
    }

    public void listarLivros() {
        if (livros.isEmpty()) {
            System.out.println("Nenhum livro cadastrado.");
        } else {
            for (Livro livro : livros) {
                System.out.println(livro);
            }
        }
    }

    // Cadastrar livros emprestados
    public void listarLivrosEmprestados() {
        boolean encontrou = false;
        for (Livro livro : livros) {
            if (livro.isEmprestado()) {
                System.out.println(livro);
                encontrou = true;
            }
        }
        if (!encontrou) {
            System.out.println("Não há livros emprestados no momento.");
        }
    }

    // Listar histórico de empréstimos
    public void listarHistoricoEmprestimos() {
        if (emprestimos.isEmpty()) {
            System.out.println("Nenhum empréstimo realizado.");
        } else {
            for (Emprestimo emprestimo : emprestimos) {
                System.out.println(emprestimo);
            }
        }
    }

    // Emprestar livro
    public void emprestarLivro() {
        System.out.print("Digite o título do livro que deseja emprestar: ");
        String titulo = scanner.nextLine();
        Livro livro = buscarLivroPorTitulo(titulo);

        if (livro != null && !livro.isEmprestado()) {
            System.out.print("Digite o nome do usuário: ");
            String nomeUsuario = scanner.nextLine();
            System.out.print("Digite o CPF do usuário: ");
            String cpfUsuario = scanner.nextLine();
            System.out.print("Digite o e-mail do usuário: ");
            String emailUsuario = scanner.nextLine();
            System.out.print("Digite a preferência de notificação do usuário: ");
            String preferenciaNotificacao = scanner.nextLine();

            //preferenciaNotificacao;
            Usuario usuario = new Usuario(nomeUsuario, cpfUsuario, emailUsuario, preferenciaNotificacao);
            System.out.print("Digite a data de devolução (formato: dd/MM/yyyy): ");
            String dataDevolucaoStr = scanner.nextLine();
            Date dataEmprestimo = new Date();
            Date dataDevolucao = ConverterData.converterParaData(dataDevolucaoStr);

            Emprestimo emprestimo = new Emprestimo(livro, usuario, dataEmprestimo, dataDevolucao);
            emprestimos.add(emprestimo);
            livro.setEmprestado(true);

            System.out.println("Empréstimo realizado com sucesso!");
        } else {
            System.out.println("Livro não disponível ou não encontrado.");
        }
    }

    // Devolver livro
    public void devolverLivro() {
        System.out.print("Digite o título do livro que deseja devolver: ");
        String titulo = scanner.nextLine();
        Livro livro = buscarLivroPorTitulo(titulo);

        if (livro != null && livro.isEmprestado()) {
            livro.setEmprestado(false);
            System.out.println("Livro devolvido com sucesso!");
        } else {
            System.out.println("Este livro não foi emprestado ou não existe.");
        }
    }

    // Buscar livro por título
    private Livro buscarLivroPorTitulo(String titulo) {
        for (Livro livro : livros) {
            if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                return livro;
            }
        }
        return null;
    }

    
    // Menu de opções
    public void exibirMenu() {
        while (true) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Cadastrar livro");
            System.out.println("2. Cadastrar usuário");
            System.out.println("3. Listar todos os livros");
            System.out.println("4. Listar livros emprestados");
            System.out.println("5. Listar histórico de empréstimos");
            System.out.println("6. Emprestar livro");
            System.out.println("7. Devolver livro");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();  

            switch (opcao) {
                case 1:
                    cadastrarLivro();
                    break;
                case 2:
                    cadastrarUsuario();
                    break;
                case 3:
                    listarLivros();
                    break;
                case 4:
                    listarLivrosEmprestados();
                    break;
                case 5:
                    listarHistoricoEmprestimos();
                    break;
                case 6:
                    emprestarLivro();
                    break;
                case 7:
                    devolverLivro();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
