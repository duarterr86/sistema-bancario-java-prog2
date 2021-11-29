package com.company.prog2;

import java.util.ArrayList;

public class Pessoa {
    String nome;
    String sobrenome;
    int idade;
    private String cpf;
    ArrayList<ContaBancaria> ContasBancarias = new ArrayList<ContaBancaria>();

    public String getCpf() {
        return cpf;
    }

    public Pessoa(String nome, String sobrenome, int idade, String cpf) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.idade = idade;
        this.cpf = cpf;
    }

    public void Info() {
        System.out.println("=== Informações do cliente: ");
        System.out.println("Nome completo: " + this.nome + " " + this.sobrenome);
        System.out.println("Idade: " + this.idade);
        System.out.println("CPF: " + this.cpf);
    }

    public void InfoContas() {
        if (ContasBancarias.isEmpty()){
            System.out.println("Nenhuma conta cadastrada!");
        } else {
            int i;
            for(i = 0; i < ContasBancarias.size(); i++){
                System.out.println(" ");
                System.out.println("Número da conta: " + ContasBancarias.get(i).NroConta);
                System.out.println("Nome do cliente: " + ContasBancarias.get(i).Titular.nome +
                        " " + ContasBancarias.get(i).Titular.sobrenome);
                System.out.println("Saldo: " + ContasBancarias.get(i).Saldo);
                System.out.println(" ");
            }
        }
    }
}
