import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class Model {
    private ArrayList<Tournee> tournees; // liste de toutes les tournées
    private ArrayList<Client> clients; // liste de tous les clients
    private ArrayList<Integer> ordre_id; // à voir
    private int nb_vehicule;
    private static final int C_MAX = 100; //capacité max

    // à partir d'un fichier
    public Model(String fileName){
        try {
            //lecture du fichier de test
            File file = new File("test/"+fileName);
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));

            //création tableau clients:
            clients = new ArrayList<>();

            //création tableau tournées:
            tournees = new ArrayList<>();

            String line = reader.readLine();
            //variables tempon (quantité et tournée)
            int qTemp = 0;
            Tournee tourneeTemp = new Tournee(new ArrayList<>(), 0);
            while((line = reader.readLine())!= null){
                String[] infosClient = line.split(";");
                Client clientAjoute = new Client(
                        Integer.parseInt(infosClient[0]),
                        Integer.parseInt(infosClient[1]),
                        Integer.parseInt(infosClient[2]),
                        Integer.parseInt(infosClient[3])
                );
                //ajoute les infos du client à la liste :
                clients.add(clientAjoute);
                //vérifie si l'on peut ajouter la commande du client au camion :
                if(qTemp + Integer.parseInt(infosClient[3]) <= C_MAX/2){
                    qTemp += Integer.parseInt(infosClient[3]);
                    tourneeTemp.ajouterClient(clientAjoute);
                }
                else{//sinon on ajoute la tournée et on réinitialise les variables tempons
                    tournees.add(tourneeTemp);
                    qTemp = 0;
                    tourneeTemp = new Tournee(new ArrayList<>(), tourneeTemp.getNumeroVehicule()+1);
                }
            }
            //si il reste une tournée non ajoutée:
            if(qTemp > 0){
                tournees.add(tourneeTemp);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Model(){
        this.clients = new ArrayList<>();
        this.tournees = new ArrayList<>();
        this.ordre_id = new ArrayList<>();
        this.nb_vehicule = 0;
    }

    // note : ne pas remplir le camion entier (facilite les opérations élémentaires)
    // Calculer le nombre de camions en fonction de la quantité total :
    // ex : 1000/100 = 10 camions minimum

    //générateur aléatoire de solution
    public void generateurAleatoire(){
        // capacité de 50% par camion
        ArrayList<Client> tempList = this.clients;
        //on vide la liste des tournée:
        this.tournees.clear();
        int capaTot = 0;
        int idTournee = 0;

        Random rand = new Random();

        while(tempList.size() != 0){
            ArrayList<Client> listPourTournee = new ArrayList<Client>();
            do{
                int random = rand.nextInt(tempList.size());
                Client c = tempList.get(random);
                capaTot += c.getQuantite();
                listPourTournee.add(c);
                tempList.remove(c);
            } while(capaTot < 50 && tempList.size() > 0);
            capaTot = 0;
            Tournee T = new Tournee(listPourTournee, idTournee);
            tournees.add(T);
            idTournee ++;
        }
        this.afficherSolution();
    }

    // fitness ?

    //méthode de descente

    //méthode tabou ou recuit simulé

    // implémentation des opérations élémentaires
    // - relocalisation - échange

    //afficher la solution:
    public void afficherSolution() {
        for (Tournee tournee : tournees) {
            System.out.println("Tournée n°" + tournee.getNumeroVehicule());
            tournee.afficherTournee();
            System.out.println();
        }
    }

    public ArrayList<Client> getClients(){
        return this.clients;
    }

}
