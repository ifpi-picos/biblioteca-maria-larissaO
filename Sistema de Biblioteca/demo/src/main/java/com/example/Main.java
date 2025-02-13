package com.example;

import com.example.dao.*;
import com.example.dominio.*;
import com.example.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            System.out.println("Conexão com o banco de dados estabelecida!");

            // Teste de inserção de um livro
            LivroDAO livroDAO = new LivroDAO(connection);
            Livro livro = new Livro("Autor Teste", "Título Teste", "Editora Teste", 2023);
            livroDAO.adicionarLivro(livro);
            System.out.println("Livro adicionado com sucesso!");

            // Teste de inserção de um usuário
            UsuarioDAO usuarioDAO = new UsuarioDAO(connection);
            Usuario usuario = new Usuario("Usuário Teste", "123.456.789-00", "teste@example.com", "E-mail");
            usuarioDAO.adicionarUsuario(usuario);
            System.out.println("Usuário adicionado com sucesso!");

            // Teste de empréstimo
            EmprestimoDAO emprestimoDAO = new EmprestimoDAO(connection);
            Emprestimo emprestimo = new Emprestimo(livro, usuario, new java.util.Date(), new java.util.Date());
            emprestimoDAO.adicionarEmprestimo(emprestimo);
            System.out.println("Empréstimo registrado com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao conectar ou executar operações no banco de dados.");
        }
    }
}

// package com.example;

// import com.example.dao.*;
// import com.example.dominio.*;
// import com.example.util.DatabaseConnection;

// import java.sql.Connection;


// public class Main {

//     public static void main(String[] args) {
//         try (Connection connection = DatabaseConnection.getConnection()) {
//             LivroDAO livroDAO = new LivroDAO(connection);
//             UsuarioDAO usuarioDAO = new UsuarioDAO(connection);
//             EmprestimoDAO emprestimoDAO = new EmprestimoDAO(connection);

//             // Exemplo de uso
//             Livro livro = new Livro("Autor", "Título", "Editora", 2021);
//             livroDAO.adicionarLivro(livro);

//             Usuario usuario = new Usuario("Nome", "CPF", "email@example.com", "E-mail");
//             usuarioDAO.adicionarUsuario(usuario);

//             // Biblioteca biblioteca = new Biblioteca();
//             // biblioteca.exibirMenu();
//         } catch (Exception e) {
//             e.printStackTrace();
//         }
//     }
// }
   
