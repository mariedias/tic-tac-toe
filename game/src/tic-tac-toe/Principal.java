package tarefaModulo1;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.*;

public class Principal {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		boolean continuar = true;

		System.out.println("Digite o nome do primeiro jogador: ");
		String nomeJogador1 = scanner.nextLine();
		Jogador j1 = new Jogador(nomeJogador1);

		System.out.println("Digite o nome do segundo jogador: ");
		String nomeJogador2 = scanner.nextLine();
		Jogador j2 = new Jogador(nomeJogador2);

		int tam = 0;
		System.out.println("Digite o tamanho do tabuleiro: ");
		boolean entradaValida = false;
		do {
			try {
				tam = scanner.nextInt();
				if (tam <= 0) {
					System.out.println("Por favor, digite um número válido para o tamanho do tabuleiro: ");
				} else {
					entradaValida = true;
				}
			} catch (InputMismatchException e) {
				System.out.println("Por favor, digite um número válido para o tamanho do tabuleiro: ");
				scanner.next();
			}
		} while (!entradaValida);
		JogoDaVelha j = new JogoDaVelha(tam);

		do {
			j.iniciaTabuleiro();
			j.imprimirTabuleiro();
			do {

				try {
					System.out.println(j1.getNome() + ", digite a linha referente à posição da sua jogada: ");
					j.setLinha(scanner.nextInt());
				} catch (InputMismatchException e) {
					System.out.println("Entrada inválida! Por favor, digite um número inteiro válido.");
					scanner.next();
				}
				try {
					System.out.println(j1.getNome() + ", digite a coluna referente à posição da sua jogada: ");
					j.setColuna(scanner.nextInt());
				} catch (InputMismatchException e) {
					System.out.println("Entrada inválida! Por favor, digite um número inteiro válido.");
					scanner.next();
				}
				j.setUltimaJogada('X');
				if (j.realizaJogada(j.getLinha(), j.getColuna(), j.getUltimaJogada())) {
					System.out.println("Jogada do jogador 1 realizada com sucesso!");
					if (j.verificaGanhador()) {
						System.out.println("Jogador 1 venceu!");
						j1.incrementaPontos();
						break;
					} else if (j.verificaEmpate()) {
						System.out.println("O jogo empatou!");
						break;
					}
				} else {
					do {
						System.out.println("Erro ao realizar a jogada do jogador 1 :(");
						System.out.println(j1.getNome() + ", faça uma nova jogada!");
						try {
							System.out.println("Digite a linha referente à posição da sua jogada: ");
							j.setLinha(scanner.nextInt());
						} catch (InputMismatchException e) {
							System.out.println("Entrada inválida! Por favor, digite um número inteiro válido.");
							scanner.next();
						}
						try {
							System.out.println("Digite a coluna referente à posição da sua jogada: ");
							j.setColuna(scanner.nextInt());
						} catch (InputMismatchException e) {
							System.out.println("Entrada inválida! Por favor, digite um número inteiro válido.");
							scanner.next();
						}
					} while (!j.realizaJogada(j.getLinha(), j.getColuna(), j.getUltimaJogada()));
				}

				j.imprimirTabuleiro();

				try {
					System.out.println(j2.getNome() + ", digite a linha referente à posição da sua jogada: ");
					j.setLinha(scanner.nextInt());
				} catch (InputMismatchException e) {
					System.out.println("Entrada inválida! Por favor, digite um número inteiro válido.");
					scanner.next();
				}
				try {
					System.out.println(j2.getNome() + ", digite a coluna referente à posição da sua jogada: ");
					j.setColuna(scanner.nextInt());
				} catch (InputMismatchException e) {
					System.out.println("Entrada inválida! Por favor, digite um número inteiro válido.");
					scanner.next();
				}
				j.setUltimaJogada('O');
				if (j.realizaJogada(j.getLinha(), j.getColuna(), j.getUltimaJogada())) {
					System.out.println("Jogada do jogador 2 realizada com sucesso!");
					if (j.verificaGanhador()) {
						System.out.println("Jogador 2 venceu!");
						j2.incrementaPontos();
						break;
					} else if (j.verificaEmpate()) {
						System.out.println("O jogo empatou!");
						break;
					}
				} else {
					do {
						System.out.println("Erro ao realizar a jogada do jogador 2 :(");
						System.out.println(j2.getNome() + ", faça uma nova jogada!");
						try {
							System.out.println("Digite a linha referente à posição da sua jogada: ");
							j.setLinha(scanner.nextInt());
						} catch (InputMismatchException e) {
							System.out.println("Entrada inválida! Por favor, digite um número inteiro válido.");
							scanner.next();
						}
						try {
							System.out.println("Digite a coluna referente à posição da sua jogada: ");
							j.setColuna(scanner.nextInt());
						} catch (InputMismatchException e) {
							System.out.println("Entrada inválida! Por favor, digite um número inteiro válido.");
							scanner.next();
						}
					} while (!j.realizaJogada(j.getLinha(), j.getColuna(), j.getUltimaJogada()));
				}

				j.imprimirTabuleiro();

			} while (true);

			if (j.verificaGanhador() == true || j.verificaEmpate() == true) {
				System.out.println("Deseja continuar jogando? (S/N)");
				char opcao = scanner.next().charAt(0);
				if (opcao == 'S' || opcao == 's') {
					continuar = true;
				} else {
					System.out.println(
							"As informações sobre o resultado do jogo foram armazenadas no documento 'resultados.txt'");
					System.out.println("Finalizando jogo...");
					String ganhador;
					if (j1.getQuantPontos() == j2.getQuantPontos()) {
						ganhador = "Sem ganhador - Empate";
					} else {
						ganhador = (j1.getQuantPontos() < j2.getQuantPontos()) ? j2.getNome() : j1.getNome();
					}
					try {
						File f = new File("resultado.txt");
						FileWriter fr = new FileWriter(f);
						try (PrintWriter out = new PrintWriter(fr)) {
							out.println("::::::::::RESULTADOS::::::::::\n\nNome do ganhador: " + ganhador
									+ "\nPontos do ganhador: "
									+ ((ganhador.equals(j1.getNome())) ? j1.getQuantPontos() : j2.getQuantPontos()));
						}
					} catch (IOException e) {
						System.out.println("Erro ao escrever arquivo.");
					}
					continuar = false;
					break;
				}
			}
		} while (continuar);

		scanner.close();
	}
}
