package com.example;

import com.example.service.Biblioteca;

public class App {
    public static void main(String[] args) {
        System.out.println("Iniciando o sistema...");
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.exibirMenu();
        System.out.println("Sistema finalizado.");
    }
}