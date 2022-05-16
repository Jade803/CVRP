import java.util.ArrayList;

public class Tournee {
    private ArrayList<Client> listClients;
    private int numeroVehicule;

    public Tournee(ArrayList<Client> c, int n){
        this.listClients = c;
        this.numeroVehicule = n;
    }

    public void ajouterClient(Client c){
        listClients.add(c);
    }

    public int getNumeroVehicule() {
        return numeroVehicule;
    }

    public void afficherTournee(){
        for(Client client: listClients){
            client.afficherClient();
            System.out.print(" // ");
        }
    }
}
