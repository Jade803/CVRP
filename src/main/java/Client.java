public class Client {
    private int id;
    private int x;
    private int y;
    private int quantite;

    /**
     *
     * @param id : identifiant du client
     * @param x : coordonnée horizontale
     * @param y : coordonnée vertiale
     * @param q : quantité de marchandise à livrer
     */
    public Client(int id, int x, int y, int q){
        this.id = id;
        this.x = x;
        this.y = y;
        this.quantite = q;
    }

    public int getQuantite() {
        return quantite;
    }

    public void afficherClient(){
        System.out.print(id+"- ("+x+","+y+") ["+quantite+"]");
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }
}
