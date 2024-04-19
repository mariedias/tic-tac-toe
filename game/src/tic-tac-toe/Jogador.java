package tarefaModulo1;

public class Jogador {
	private String nome;
	private int quantPontos;

	public Jogador(String nome) {
		this.nome = nome;
		this.quantPontos = 0;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getQuantPontos() {
		return quantPontos;
	}

	public void incrementaPontos() {
		this.quantPontos++;
	}

	@Override
	public String toString() {
		return "Jogador [nome=" + nome + ", quantPontos=" + quantPontos + "]";
	}

}
