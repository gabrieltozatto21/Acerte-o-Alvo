package AcerteOAlvo;

import static AcerteOAlvo.Alvo.*;
import java.util.Scanner;

public class alvoAPP {
    
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        AlvoVetor vetorAlvos = new AlvoVetor(15);
       
        int opcao;
		do{
			System.out.print("\tOpcoes de conversao\n"
					+ "1 - Jogar\n"
					
					+ "3 - Sair\n"
					
					+ "Digite a opcao: ");
			opcao = scan.nextInt();

			switch(opcao){
			case 1:
                            formaAlvos(vetorAlvos);
                            //exibiAlvos(vetorAlvos);
                            jogar(vetorAlvos);
                            break;
                        case 2:
                            break;
			case 3:
                            System.out.println("Ate mais");
                            break;
			}
		}while(opcao != 3);
    }
    
    
    private static void formaAlvos(AlvoVetor vetorAlvos){        
       int i=0;
       do{
           Alvo alvo = new Alvo();
           alvo.setCor('B');
           vetorAlvos.insere(alvo);
           i++;
       }while(i<3);
       
       i=0;
       do{
           Alvo alvo = new Alvo();
           alvo.setCor('P');
           vetorAlvos.insere(alvo);
           i++;
       }while(i<12);
    }
    
    private static void  exibiAlvos(AlvoVetor vetorAlvos){
        for(int i=0; i<vetorAlvos.getnElem();i++){
            System.out.println(vetorAlvos.getVetAlvo(i));
        }
    }
    
    private static void jogar(AlvoVetor atirar) {
        int x=-1, y=-1, tiros=10;
        char acerto;
        
        System.out.println("Para Jogar voce deve inserir uma coordenada para X e Y"
                    + "\nAs coordenadas vão de 1 á 5 para cada uma, boa sorte!"+ "\n");
        while(tiros != 0 && vida!=0){
            do{         
                System.out.print("Digite a coordenada de X: ");
                x = scan.nextInt();
            }while(x < 1 || x > 5 );

            do{
                System.out.print("Digite a coordenada de Y: ");
                y = scan.nextInt();
            }while(y < 1 || y > 5 );
            acerto = atirar.atira(x, y);
            if(acerto == 'B'){                
                tiros--;
                System.out.println("Você acertou um alvo branco é o destruiu, ganhou uma vida"
                        + "\nVidas: "+vida
                        + "\nTiros restantes: "+ tiros + "\n");
                //exibiAlvos(atirar);

            }else if (acerto == 'P'){     
                tiros--;
                 System.out.println("Você acertou um alvo preto e o deslocou de posição, perdeu uma vida!"
                        + "\nVidas: "+vida
                        + "\nTiros restantes: "+ tiros + "\n");
                 //exibiAlvos(atirar);
            }else{
                tiros--;
                System.out.println("Você nao acertou nenhum alvo, Continue!"
                                    + "\nTiros restantes: "+ tiros + "\n");
            }
        }
        if(vida==0){
            System.out.println("Parabéns você zerou as vidas e venceu o jogo!");
        }else{
            System.out.println("Game Over!"
                    + "você não zerou as vidas e seus tiros acabaram voce perdeu o jogo!");
        
        }
       
    }
    
    
}