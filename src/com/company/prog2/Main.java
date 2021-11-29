package com.company.prog2;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        ArrayList<Pessoa> ListaClientes = new ArrayList<>();
        ArrayList<Banco> ListaBancos = new ArrayList<>();
        boolean opcaoValida = false;

        System.out.println("==== Sistema do banco iniciado ====");

        while (!opcaoValida) {
            System.out.println("");
            System.out.println("Escolha uma das opções abaixo:");
            System.out.println("");
            System.out.println("1 - Cadastrar Cliente");
            System.out.println("2 - Cadastrar Banco");
            System.out.println("3 - Cadastrar Nova Conta");
            System.out.println("4 - Listar Clientes");
            System.out.println("5 - Listar Bancos");
            System.out.println("6 - Listar Contas");
            System.out.println("7 - Encerar conta");
            System.out.println("8 - Fazer saque");
            System.out.println("9 - Fazer Depósito");
            System.out.println("0 - Sair");

            int menu = teclado.nextInt();

            switch (menu) {
                case 1: {
                    System.out.println("Entrando no cadastro de clientes!");
                    String nome, sobrenome, cpf;
                    int idade;
                    Pessoa pessoa;
                    System.out.println("Digite o nome do cliente: ");
                    teclado.nextLine();
                    nome = teclado.nextLine();
                    System.out.println("Digite o sobrenome do cliente: ");
                    sobrenome = teclado.nextLine();
                    System.out.println("Digite a idade do cliente: ");
                    idade = teclado.nextInt();
                    System.out.println("Digite o CPF do cliente: ");
                    teclado.nextLine();
                    cpf = teclado.nextLine();

                    pessoa = new Pessoa(nome, sobrenome, idade, cpf);
                    ListaClientes.add(pessoa);
                    System.out.println("");
                    System.out.println("Cliente cadastrado com sucesso!");
                    pessoa.Info();
                    continue;
                }
                case 2: {
                    System.out.println("Entrando no cadastro de bancos!");
                    String nome, cnpj;
                    int nrobanco;
                    Banco banco;
                    System.out.println("Digite o nome do banco: ");
                    teclado.nextLine();
                    nome = teclado.nextLine();
                    System.out.println("Digite o CNPJ do banco: ");
                    cnpj = teclado.nextLine();
                    System.out.println("Digite o número do banco: ");
                    nrobanco = teclado.nextInt();

                    banco = new Banco(nome, cnpj, nrobanco);
                    ListaBancos.add(banco);
                    System.out.println("");
                    System.out.println("Banco cadastrado com sucesso!");
                    banco.InfoBanco();
                    continue;
                }
                case 3: {
                    System.out.println("Entrando no cadastro de conta corrente...");
                    if (!ListaBancos.isEmpty()) {
                        System.out.println("Digite o numero do banco: ");
                        int numeroBanco = teclado.nextInt();
                        int i;
                        for (i = 0; i < ListaBancos.size(); i++){
                            if (ListaBancos.get(i).getNroBanco() == numeroBanco){
                                Banco banco = ListaBancos.get(i);
                                banco.CriarConta();
                                continue;
                            } else {
                                System.out.println("Banco não encontrado!");
                            }
                        }
                        continue;
                    } else {
                        System.out.println("Nenhum Banco cadastrado. Cadastre um banco para continuar!");
                        continue;
                    }
                }
                case 4: {
                    System.out.println("Entrando na lista de clientes!");
                    if (!ListaClientes.isEmpty()) {
                        int i;
                        for (i = 0; i < ListaClientes.size(); i++) {
                            ListaClientes.get(i).Info();
                            System.out.println(" ");
                        }
                    } else {
                        System.out.println("Nenhum cliente cadastrado!");
                    }
                    continue;
                }
                case 5: {
                    System.out.println("Entrando na lista de bancos!");
                    if (!ListaBancos.isEmpty()) {
                        int i;
                        for (i = 0; i < ListaBancos.size(); i++) {
                            ListaBancos.get(i).InfoBanco();
                            System.out.println(" ");
                        }
                    } else {
                        System.out.println("Nenhum banco cadastrado!");
                    }
                    continue;
                }
                case 6: {
                    System.out.println("Entrando na lista de contas!");
                    if (!ListaBancos.isEmpty()) {
                        Banco banco = ListaBancos.get(0);
                        banco.InfoContas();
                    } else {
                        System.out.println("Nenhum Banco cadastrado. Cadastre um banco para continuar!");
                    }
                    continue;
                }
                case 7: {
                    System.out.println("Entrando no sistema de fechamento de contas...");
                    if (!ListaBancos.isEmpty()) {
                        Banco banco = ListaBancos.get(0);
                        banco.FecharConta();
                        continue;
                    } else {
                        System.out.println("Nenhum Banco cadastrado. Cadastre um banco para continuar!");
                    }
                }
                case 8: {
                    System.out.println("Entrando na opção de saque...");
                    if (!ListaBancos.isEmpty()) {
                        Banco banco = ListaBancos.get(0);
                        if (banco.ContasBancarias.isEmpty()) {
                            System.out.println("Nenhuma conta encontrada!");
                            continue;
                        } else {
                            System.out.println("Digite o número da conta: ");
                            int nrocontasaque = teclado.nextInt();
                            int i;
                            for (i = 0; i < banco.ContasBancarias.size(); i++) {
                                if (banco.ContasBancarias.get(i).NroConta == nrocontasaque) {
                                    banco.ContasBancarias.get(i).Saque();
                                    continue;
                                } else {
                                    System.out.println("Conta não encontrada!");
                                    continue;
                                }
                            }
                        }
                    } else {
                        System.out.println("Nenhum banco cadastrado");
                        continue;
                    }
                    continue;
                }
                case 9: {
                    System.out.println("Entrando na opção de depósito: ");
                    if (!ListaBancos.isEmpty()) {
                        Banco banco = ListaBancos.get(0);
                        if (banco.ContasBancarias.isEmpty()) {
                            System.out.println("Nenhuma conta encontrada!");
                            continue;
                        } else {
                            System.out.println("Digite o número da conta: ");
                            int nrocontasaque = teclado.nextInt();
                            int i;
                            for (i = 0; i < banco.ContasBancarias.size(); i++) {
                                if (banco.ContasBancarias.get(i).NroConta == nrocontasaque) {
                                    banco.ContasBancarias.get(i).Deposito();
                                    continue;
                                } else {
                                    System.out.println("Conta não encontrada!");
                                    continue;
                                }
                            }
                        }
                    } else {
                        System.out.println("Nenhum banco cadastrado");
                        continue;
                    }
                    continue;
                }
                case 0: {
                    opcaoValida = true;
                    System.out.println("Saindo do sistema!");
                    break;
                }
                default: {
                    opcaoValida = false;
                    System.out.println("Opção inválida. Tente novamente");
                }
            }
        }
    }
}
