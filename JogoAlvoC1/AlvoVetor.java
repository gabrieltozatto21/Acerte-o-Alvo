package JogoAlvoC1;

import static JogoAlvoC1.Alvo.vida;
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
                            novoAlvo.setPosX(this.gerarNumero()+1);
                            novoAlvo.setPosY(this.gerarNumero()+1); 
                        }while(!verificaPos(novoAlvo.getPosX(), novoAlvo.getPosY()));
			this.vetAlvo[this.nElem] = novoAlvo;
			this.nElem++;
			return 0;
		}
	}
   
   
   public int gerarNumero() {
	int aleat;
	Random aleatorio = new Random();
	aleat = aleatorio.nextInt(5);
	return aleat;
    }
   
    public boolean verificaPos(int posX,int posY){   
       if(this.pesquisar(posX, posY) != null){
           return false;
       }else{
           return true;
       }
       
       
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
            if(alvo == null){
                return 'N';
            }else if(alvo.getCor()=='P'){                
                do{
                    novoAlvoX = this.gerarNumero();
                    novoAlvoY = this.gerarNumero();
                }while(!verificaPos(novoAlvoX, novoAlvoY));
                alvo.setPosX(novoAlvoX);
                alvo.setPosY(novoAlvoY);
                vida--;                
                return 'P';
            }else{              
                alvo = this.vetAlvo[this.nElem-1];
                this.nElem--;
                vida++;
                return 'B';
            }
        
    }
   
}