package arvore;

public class NoAVL {

	
		
	private NoArvore esquerda;
	private NoArvore direita;
	private NoArvore pai;
	private int chave;
	private int balanceamento;

	public NoAVL(int k) {
		setEsquerda(setDireita(setPai(null)));
		setBalanceamento(0);
		setChave(k);
	}

	public String toString() {
		return Integer.toString(getChave());
	}

	public int getChave() {
		return chave;
	}

	public void setChave(int chave) {
		this.chave = chave;
	}

	public int getBalanceamento() {
		return balanceamento;
	}

	public void setBalanceamento(int balanceamento) {
		this.balanceamento = balanceamento;
	}

	public NoArvore getPai() {
		return pai;
	}

	public NoArvore setPai(NoArvore pai) {
		this.pai = pai;
		return pai;
	}

	public NoArvore getDireita() {
		return direita;
	}

	public NoArvore setDireita(NoArvore direita) {
		this.direita = direita;
		return direita;
	}

	public NoArvore getEsquerda() {
		return esquerda;
	}

	public void setEsquerda(NoArvore esquerda) {
		this.esquerda = esquerda;
	}

	

}
