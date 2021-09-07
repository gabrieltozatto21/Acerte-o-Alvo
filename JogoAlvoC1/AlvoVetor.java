package AcerteOAlvo;

import static AcerteOAlvo.Alvo.*;
import java.util.Random;

public class AlvoVetor {
   private Alvo[] vetAlvo;
   private int nElem;
   
   
   public AlvoVetor(int tam){
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
    
    public Alvo getVetAlvo(int pos){
        return this.vetAlvo[pos];
    }
    
    public int insere(Alvo novoAlvo) {
		if (this.nElem == this.vetAlvo.length) {
			return -1;
		}else {
                        do{
                            novoAlvo.setPosX(this.gerarNumero());
                            novoAlvo.setPosY(this.gerarNumero()); 
                        }while(pesquisarPos(novoAlvo.getPosX(), novoAlvo.getPosY()) != -1 );
			this.vetAlvo[this.nElem] = novoAlvo;
			this.nElem++;
			return 0;
		}
	}
   
   
   public int gerarNumero() {
	int aleat;
	Random aleatorio = new Random();
	aleat = aleatorio.nextInt(5)+1;
	return aleat;
    }
   
   public int pesquisarPos(int posX, int posY){
       for (int i=0; i<this.nElem; i++) {
            if (this.vetAlvo[i].getPosX()== posX && this.vetAlvo[i].getPosY()== posY) {
                return i;
            }           
	}
        return -1;
   }
     
    
   public char atira(int x, int y){
       int novoAlvoX, novoAlvoY;
       int pos = this.pesquisarPos(x,y);
            if(pos == -1){
                return 'N';
            }else{
                Alvo alvo = this.vetAlvo[pos];
                if(alvo.getCor()=='P'){                
                do{
                    novoAlvoX = this.gerarNumero();
                    novoAlvoY = this.gerarNumero();
                }while(pesquisarPos(novoAlvoX, novoAlvoY) != -1);
                alvo.setPosX(novoAlvoX);
                alvo.setPosY(novoAlvoY);
                vida--;                
                return 'P';
                }else {              
                    this.vetAlvo[pos] = this.vetAlvo[this.nElem-1];
                    this.nElem--;
                    vida++;
                    return 'B';
                }
            }
        
    }
   
}