public class Arvore {
	private int valor;
	private Arvore noEsquerdo;
	private Arvore noDireito;

	//Construtor
	public Arvore(int valor) {
		this.valor = valor;
		this.noDireito = null;
		this.noEsquerdo = null;
	}
	
	//Montando á arvore
	public static void InserirNo(Arvore novo, Arvore arvore) {
		if(arvore == null) {
			arvore = novo;
		} else {
			
			if (novo.valor < arvore.valor) {
				
				if (arvore.noEsquerdo == null) {
					arvore.noEsquerdo = novo;
				} else {
					InserirNo(novo, arvore.noEsquerdo);
				}
				
			} else { 
					if (arvore.noDireito == null) {
						arvore.noDireito = novo;
					} else {
						InserirNo(novo, arvore.noDireito);
					}
			}
			
		}
	}
	
	//Método de Busca em Arvore binária
	public static boolean BuscarNo(Arvore arvore, int valor) {
		boolean existe = false;
		
		if (arvore == null) {
			existe = false; //Nó vazio
		} else if (arvore.valor == valor) {
			existe = true; //Valor encontrado na Raiz
		} else {
			if (arvore.valor > valor) { //Percorre a sub-arvore a esquerda
				existe = BuscarNo(arvore.noEsquerdo, valor);
			} else {	//Percorre a sub-arvore a direita
				existe = BuscarNo(arvore.noDireito, valor);
			}
		}
		return existe;
	}
	
	//Removeção de Nó
	public static void removerNo(Arvore arvore, int valor) {
		if (arvore.valor == valor) {
			arvore = null;
		} else if (arvore.valor > valor) {
			if (arvore.noEsquerdo.valor == valor) {
				removerNoEsquerdo(arvore);
			} else {
				removerNo(arvore.noEsquerdo, valor);
			}
		} else {
			if (arvore.noDireito.valor == valor) {
				removerNoDireito(arvore);
			} else {
				removerNo(arvore.noDireito, valor);
			}
		}
	}
	
	public static void removerNoEsquerdo(Arvore noPai) {
		int filhos = 0;
		Arvore noRemover = null;
		noRemover = noPai.noEsquerdo;
		filhos = totalFilhos(noRemover);
		if (filhos == 0) {
			removerSemFilhos(noPai, "E");
		} else if (filhos == 1) {
			removerUmFilhoEsquerda(noPai, "E");
		} else if (filhos == 2) {
			removerUmFilhoEsquerda(noPai, "D");
		} else if (filhos == 3) {
			
		}
	}
	
	public static void removerNoDireito(Arvore noPai) {
		int filhos = 0;
		Arvore noRemover = null;
		noRemover = noPai.noDireito;
		filhos = totalFilhos(noRemover);
		if (filhos == 0) {
			removerSemFilhos(noPai, "E");
		} else if (filhos == 1) {
			removerUmFilhoDireito(noPai, "E");
		} else if (filhos == 2) {
			removerUmFilhoDireito(noPai, "D");
		} else if (filhos == 3) {
			
		}
	}
	
	public static void removerUmFilhoEsquerda(Arvore noPai, String subarvore) {
		if (subarvore.equals("E")) {
			noPai.noEsquerdo = noPai.noEsquerdo.noEsquerdo;
		} else {
			noPai.noEsquerdo = noPai.noEsquerdo.noDireito;
		}
	}
	
	public static void removerUmFilhoDireito(Arvore noPai, String subarvore) {
		if (subarvore.equals("E")) {
			noPai.noDireito = noPai.noDireito.noEsquerdo;
		} else {
			noPai.noDireito = noPai.noDireito.noDireito;
		}
	}
	
	public static int totalFilhos(Arvore no) {
		//0 sem filhos | 1 só filho esquerda | 2 só filhos direita | 3 filhos nos dois nós
		int total = 0;
		
		if (no.noEsquerdo != null) {
			total += 1;
		} 
		if (no.noDireito != null) {
			total += 2;
		}
		return total;
	}
	
	public static void removerSemFilhos(Arvore noPai, String subarvore) {
		if (subarvore.equals("E")) {
			noPai.noEsquerdo = null;
		} else {
			noPai.noDireito = null;
		}
	}
	public static void imprimirPreOrdem(Arvore a) {
		System.out.println(a.valor + " ");
		if (a.noEsquerdo != null) {
			imprimirPreOrdem(a.noEsquerdo);
		}
		if (a.noDireito != null) {
			imprimirPreOrdem(a.noDireito);
		}	
	}
	
}