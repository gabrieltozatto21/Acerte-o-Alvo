package JogoAlvoC1;

public class Alvo {
    static int vida=3;
    private int posX, posY;
    private char cor;
    
    public void Alvo(){
        this.setPosX(0);
        this.setPosY(0);
        this.setCor(' ');    
    }
    
    public int getVida(){
        return vida;
    }

    /**
     * @return the posX
     */
    public int getPosX() {
        return posX;
    }

    /**
     * @param posX the posX to set
     */
    public void setPosX(int posX) {
        this.posX = posX;
    }

    /**
     * @return the posY
     */
    public int getPosY() {
        return posY;
    }

    /**
     * @param posY the posY to set
     */
    public void setPosY(int posY) {
        this.posY = posY;
    }

    /**
     * @return the cor
     */
    public char getCor() {
        return cor;
    }

    /**
     * @param cor the cor to set
     */
    public void setCor(char cor) {
        this.cor = cor;
    }

    /**
     *
     * @return
     */
    
    @Override
    public String toString(){
        return "Posição X: "+ this.posX+
               "\nPosição Y: "+ this.posY+
               "\nCor: "+ this.cor+"\n";
    }
    
    
    
}
