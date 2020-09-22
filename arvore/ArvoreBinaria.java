package arvore;

public class ArvoreBinaria {

	private NoArvore raiz;
	
	
	public ArvoreBinaria() {
		raiz = null;
		// TODO Auto-generated constructor stub
	}

	public void inserir(long valor) {
	    NoArvore novo = new NoArvore();        // cria um novo Nó
	    novo.item = valor;                     // atribui o valor recebido ao item de dados do Nó
	    novo.direita = null;
	    novo.esquerda = null;

	    if (raiz == null) 
	    	raiz = novo;
	    
	    else  {                                // se nao for a raiz
	      NoArvore atual = raiz;
	      NoArvore anterior;
	      
	      
	      while(true) {
	        anterior = atual;
	        if (valor <= atual.item) {   
	        	                                  // ir para esquerda
	          atual = atual.esquerda; 
	          
	          if (atual == null) {
	            anterior.esquerda = novo;
	            return;
	          } 
	        }                                      // fim da condição ir a esquerda
	        
	        else {                                // ir para direita
	           atual = atual.direita;
	           if (atual == null) {
	             anterior.direita = novo;
	             return;
	           }
	        }                                       
	      }                                           
	    } 

	  }
	
	 public NoArvore buscar(long chave) {
		    if (raiz == null) 
		    	return null;                               // se arvore vazia
		    NoArvore atual = raiz;                        // começa a procurar desde raiz
		    while (atual.item != chave) {                 // enquanto nao encontrou
		      if(chave < atual.item ) 
		    	   atual = atual.esquerda;               // caminha para esquerda
		      else atual = atual.direita;                // caminha para direita
		      if (atual == null) 
		    	   return null;                         // encontrou uma folha -> sai
		    }                                           // fim laço while
		    return atual; // terminou o laço while e chegou aqui é pq encontrou item
		  }


		  public boolean remover(long valor) {
		    if (raiz == null) 
		    	return false; // se arvore vazia

		    NoArvore atual = raiz;
		    NoArvore pai = raiz;
		    boolean filhoEsquerda = true;
		    
		    

		    // ****** Buscando o valor **********
		    while (atual.item != valor) {                 // enquanto nao encontrou
		      pai = atual;
		      if(valor < atual.item ) {                   // caminha para esquerda
		        atual = atual.esquerda;
		        filhoEsquerda = true;                      // é filho a esquerda? sim
		      }
		      else {                                    // caminha para direita
		        atual = atual.direita; 
		        filhoEsquerda = false;                  // é filho a esquerda? NAO
		      }
		      if (atual == null) 
		    	  return false;                        // encontrou uma folha -> sai
		    }                                           

		   
		    
		    

		    // Se nao possui nenhum filho (é uma folha), elimine-o
		   
		    if (atual.esquerda == null && atual.direita == null) {
		      if (atual == raiz )
		    	  raiz = null;                         // se raiz
		      else if (filhoEsquerda) 
		    	  pai.esquerda = null;                 // se for filho a esquerda do pai
		           else pai.direita = null;                // se for filho a direita do pai
		    }

		    // Se é pai e nao possui um filho a direita, substitui pela subarvore a direita
		    else if (atual.direita == null) {
		       if (atual == raiz) 
		    	   raiz = atual.esquerda; // se raiz
		       else if (filhoEsquerda) pai.esquerda = atual.esquerda;   // se for filho a esquerda do pai
		            else pai.direita = atual.esquerda;                  // se for filho a direita do pai
		    }
		    
		    // Se é pai e nao possui um filho a esquerda, substitui pela subarvore a esquerda
		    else if (atual.esquerda == null) {
		       if (atual == raiz) 
		    	   raiz = atual.direita; // se raiz
		       else if (filhoEsquerda) pai.esquerda = atual.direita;  // se for filho a esquerda do pai
		            else pai.direita = atual.direita;                 // se for  filho a direita do pai
		    }

		    // Se possui mais de um filho, se for um avô ou outro grau maior de parentesco
		    else {
		      NoArvore sucessor = noSucessor(atual);
		      // Usando sucessor que seria o Nó mais a esquerda da subarvore a direita do No que deseja-se remover
		      if (atual == raiz) 
		    	  raiz = sucessor;                              // se raiz
		      else if(filhoEsquerda) 
		    	  pai.esquerda = sucessor;                     // se for filho a esquerda do pai
		           else pai.direita = sucessor;                // se for filho a direita do pai
		      sucessor.esquerda = atual.esquerda;             // acertando o ponteiro a esquerda do sucessor agora que ele assumiu 
		                                                       // a posição correta na arvore   
		    }

		    return true;
		  }
		  
		  
		  
		  // O sucessor é o Nó mais a esquerda da subarvore a direita do No que foi passado como parametro do metodo
		 
		  public NoArvore noSucessor(NoArvore apaga) {          // O parametro é a referencia para o No que deseja-se apagar
		     NoArvore paidosucessor = apaga;
		     NoArvore sucessor = apaga;
		     NoArvore atual = apaga.direita;                   // vai para a subarvore a direita

		     while (atual != null) {                           // enquanto nao chegar no Nó mais a esquerda
		       paidosucessor = sucessor;
		       sucessor = atual;
		       atual = atual.esquerda;                         // caminha para a esquerda
		     } 
		    
		     
		     
		     
		     if (sucessor != apaga.direita) {                    // se sucessor nao é o filho a direita do Nó que deverá ser eliminado
		       paidosucessor.esquerda = sucessor.direita;                 // pai herda os filhos do sucessor que sempre serão a direita
		      

		       sucessor.direita = apaga.direita;                        // guardando a referencia a direita do sucessor para 
		                                                              // quando ele assumir a posição correta na arvore
		     }
		     return sucessor;
		  }
		  
		  public void caminhar() {
		    System.out.print("\n Exibindo em ordem: ");
		    inOrder(raiz);
		    
		    System.out.print("\n Exibindo em pos-ordem: ");
		    posOrder(raiz);
		   
		    System.out.print("\n Exibindo em pre-ordem: ");
		    preOrder(raiz);
		   
		    System.out.print("\n Altura da arvore: " + altura(raiz));
		    System.out.print("\n Quantidade de folhas: " + folhas(raiz));
		    System.out.print("\n Quantidade de Nós: " + contarNos(raiz));
		    if (raiz != null ) {                                             // se arvore nao esta vazia
		      
		       System.out.print("\n Valor minimo: " + menor().item);
		       System.out.println("\n Valor maximo: " + maior().item);
		    }
		  }

		  public void inOrder(NoArvore atual) {
		    if (atual != null) {
		      inOrder(atual.esquerda);
		      System.out.print(atual.item + " ");
		      inOrder(atual.direita);
		    }
		  }
		  
		  public void preOrder(NoArvore atual) {
		    if (atual != null) {
		      System.out.print(atual.item + " ");
		      preOrder(atual.esquerda);
		      preOrder(atual.direita);
		    }
		  }
		  
		  public void posOrder(NoArvore atual) {
		    if (atual != null) {
		      posOrder(atual.esquerda);
		      posOrder(atual.direita);
		      System.out.print(atual.item + " ");
		    }
		  }  
		  
		  public int altura(NoArvore atual) {
		     if(atual == null || (atual.esquerda == null && atual.direita == null))
		       return 0;
		    
		     else {
		   
		    	 if (altura(atual.esquerda) > altura(atual.direita))
		   	   return ( 1 + altura(atual.esquerda) );
		   
		    	 else
			
		    		 return ( 1 + altura(atual.direita) );
		     }
		  }
		  
		  public int folhas(NoArvore atual) {
		    if(atual == null) 
		    	return 0;
		   
		    if(atual.esquerda == null && atual.direita == null) 
		    	return 1;
		     return folhas(atual.esquerda) + folhas(atual.direita);
		  }
		  
		  public int contarNos(NoArvore atual) {
		  
			  if(atual == null)  
			   return 0;
		
			  else return ( 1 + contarNos(atual.esquerda) + contarNos(atual.direita));
		  }

		  public NoArvore menor() {
		    NoArvore atual = raiz;
		    NoArvore anterior = null;
		 
		    
		    while (atual != null) {
		      anterior = atual;
		      atual = atual.esquerda;
		    }
		    return anterior;
		  }

		  public NoArvore maior() {
		    NoArvore atual = raiz;
		    NoArvore anterior = null;
		    while (atual != null) {
		      anterior = atual;
		      atual = atual.direita;
		    }
		    return anterior;
		  }

		}
