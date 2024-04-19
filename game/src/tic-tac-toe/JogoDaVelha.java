package tarefaModulo1;

import java.util.Arrays;

public class JogoDaVelha {
	private char[][] tabuleiro;
	private int tamanho, linha, coluna;
	private char ultimaJogada;

	public JogoDaVelha(int tamanho) {
		this.tabuleiro = new char[tamanho][tamanho];
	}

	public boolean realizaJogada(int linha, int coluna, char ultimaJogada) {
		if (linha >= 0 && linha < tabuleiro.length && coluna >= 0 && coluna < tabuleiro[0].length) {
			if (tabuleiro[linha][coluna] == '◻') {
				tabuleiro[linha][coluna] = ultimaJogada;
				return true;
			}
		}
		return false;
	}

	public boolean verificaGanhador() {
		// Diagonal primária
		boolean encontrouDiagonal = true;
		for (int i = 0; i < tabuleiro.length; i++) {
			if (tabuleiro[i][i] != ultimaJogada) {
				encontrouDiagonal = false;
				break;
			}
		}
		if (encontrouDiagonal) {
			return true;
		}

		// Diagonal secundária
		encontrouDiagonal = true;
		for (int i = 0; i < tabuleiro.length; i++) {
			if (tabuleiro[i][tabuleiro.length - i - 1] != ultimaJogada) {
				encontrouDiagonal = false;
				break;
			}
		}
		if (encontrouDiagonal) {
			return true;
		}

		// Horizontal
		for (int i = 0; i < tabuleiro.length; i++) {
			char primeiro = tabuleiro[i][0];
			boolean linhaCompleta = true;
			for (int j = 1; j < tabuleiro[i].length; j++) {
				if (tabuleiro[i][j] != primeiro || tabuleiro[i][j] == '◻') {
					linhaCompleta = false;
					break;
				}
			}
			if (linhaCompleta) {
				return true;
			}
		}

		// Vertical
		for (int i = 0; i < tabuleiro.length; i++) {
			char primeiro = tabuleiro[0][i];
			boolean colunaCompleta = true;
			for (int j = 1; j < tabuleiro.length; j++) {
				if (tabuleiro[j][i] != primeiro || tabuleiro[j][i] == '◻') {
					colunaCompleta = false;
					break;
				}
			}
			if (colunaCompleta) {
				return true;
			}
		}
		return false;
	}

	public boolean verificaEmpate() {
		for (int linha = 0; linha < tabuleiro.length; linha++) {
			for (int coluna = 0; coluna < tabuleiro[linha].length; coluna++) {
				if (tabuleiro[linha][coluna] == '◻') {
					return false;
				}
			}
		}
		return true;

	}

	public void imprimirTabuleiro() {
		System.out.println("\nTABULEIRO:\n");
		for (int i = 0; i < tabuleiro.length; i++) {
			for (int j = 0; j < tabuleiro[i].length; j++) {
				System.out.print(tabuleiro[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	public void iniciaTabuleiro() {
		for (linha = 0; linha < tabuleiro.length; linha++)
			for (coluna = 0; coluna < tabuleiro[linha].length; coluna++)
				tabuleiro[linha][coluna] = '◻';
	}

	public char[][] getTabuleiro() {
		return tabuleiro;
	}

	public void setTabuleiro(char[][] tabuleiro) {
		this.tabuleiro = tabuleiro;
	}

	public int getTamanho() {
		return tamanho;
	}

	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}

	public int getLinha() {
		return linha;
	}

	public void setLinha(int linha) {
		this.linha = linha;
	}

	public int getColuna() {
		return coluna;
	}

	public void setColuna(int coluna) {
		this.coluna = coluna;
	}

	public char getUltimaJogada() {
		return ultimaJogada;
	}

	public void setUltimaJogada(char ultimaJogada) {
		this.ultimaJogada = ultimaJogada;
	}

	@Override
	public String toString() {
		return "JogoDaVelha [tabuleiro=" + Arrays.toString(tabuleiro) + ", tamanho=" + tamanho + ", linha=" + linha
				+ ", coluna=" + coluna + ", ultimaJogada=" + ultimaJogada + "]";
	}

}
