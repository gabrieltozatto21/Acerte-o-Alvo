package JogoAlvoC1;

import static JogoAlvoC1.Alvo.*;
import java.util.Random;

public class AlvoVetor {
   private Alvo[] vetAlvo;
   private int nElem;
   
   
   public void AlvoVetor(int tam){
       this.vetAlvo = new Alvo[tam];
       this.nElem=0;
   }
    /**
     * @return the nElem
     */
    public int getnElem() {
        return nElem;
    }

    /**
     * @param nElem the nElem to set
     */
    private void setnElem(int nElem) {
        this.nElem = nElem;
    }
   
   
   public int gerarNumero() {
	int aleat;
	Random aleatorio = new Random();
	aleat = aleatorio.nextInt(5);
	return aleat;
    }
   
   public Alvo pesquisar(int posX, int posY){
       for (int i=0; i<this.nElem; i++) {
            if (this.vetAlvo[i].getPosX()== posX && this.vetAlvo[i].getPosY()== posY) {
                return this.vetAlvo[i];
            }           
	}
        return null;
   }
   
   
   
    
   public char atira(int x, int y){
       int novoAlvoX, novoAlvoY;
       Alvo alvo = this.pesquisar(x,y);
            if(alvo.getCor() == 'B'){
                alvo = this.vetAlvo[this.nElem-1];
                this.nElem--;
                vida++;
                return 'B';
            }else if(alvo.getCor()=='P'){                
                do{
                    novoAlvoX = this.gerarNumero();
                    novoAlvoY = this.gerarNumero();
                }while(this.pesquisar(novoAlvoX, novoAlvoY) != null);
                alvo.setPosX(novoAlvoX);
                alvo.setPosY(novoAlvoY);
                vida--;                
                return 'P';
            }else{              
                return 'N';
            }
        
    }

   
}