package com.example.dao;

import com.example.dominio.*;
import java.sql.*;

public class EmprestimoDAO {
    private Connection connection;

    public EmprestimoDAO(Connection connection) {
        this.connection = connection;
    }

    public void adicionarEmprestimo(Emprestimo emprestimo) throws SQLException {
        String sql = "INSERT INTO emprestimos (livro_id, usuario_id, data_emprestimo, data_devolucao) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, emprestimo.getLivro()); 
            stmt.setInt(2, emprestimo.getUsuario()); 
            stmt.setString(3, emprestimo.getDataEmprestimo()); 
            stmt.setDate(4, new java.sql.Date(emprestimo.getDataDevolucao().getTime())); 
            stmt.executeUpdate();
        }
    }
}

