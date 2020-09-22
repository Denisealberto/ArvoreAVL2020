package arvore;

import java.util.Scanner;


public class ArvoreBinariaTeste {

	public static void main(String[] args) {
		
	    Scanner le = new Scanner(System.in);
	    ArvoreBinaria arv = new ArvoreBinaria();
	    int opcao;
	    long x;
	    
	    System.out.print("\n ************** Implementando Árvore Binária *******************");
	    do {
	        System.out.print("\n___________________________________________________");
	        System.out.print("\nO que você quer fazer?");
		
	        System.out.print("\n ----1: Inserir");
		
	        System.out.print("\n ----2: Excluir");
		
	        System.out.print("\n ----3: Pesquisar");
		
	        System.out.print("\n ----4: Exibir");
		
	        System.out.print("\n ----5: Sair do programa");
		
	        System.out.print("\n___________________________________________________");
		
	        System.out.print("\n-> ");
		
	        opcao = le.nextInt();
		switch(opcao) {
		 	case 1: {
			       System.out.print("\n Informe um valor: ");
			       x = le.nextLong();
			       arv.inserir(x);
			       break;
			}
			case 2: {
			       System.out.print("\n Informe um valor: ");
			       x = le.nextLong();
			       if ( !arv.remover(x) )
	                          System.out.print("\n Valor não encontrado! Tente outra vez!");;
			       break;
			}
			case 3: {
			       System.out.print("\n Informe um valor: ");
	                       x = le.nextLong();
		      	       if( arv.buscar(x) != null )
			          System.out.print("\n Valor Encontrado");
			       else 
			          System.out.print("\n Valor não encontrado! Tente outra vez!");
			       break;
			}	 
			case 4: {
			      arv.caminhar();
			      break; 
			}
	        } // fim switch
	    } while(opcao != 5);

	  }
	}
	
	
	
	
	


