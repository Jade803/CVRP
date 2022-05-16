import java.io.File;

public class Main {
    public static void main(String[] args) {
        System.out.println("Affichage du test A3205");
        Model model = new Model("A3205.txt");
        model.afficherSolution();

        System.out.println("Affichage générateur aléatoire");
        Model modelRadom = new Model("A3205.txt");
        modelRadom.generateurAleatoire();

        Graphique graph = new Graphique();
        graph.main(args);

    }
}
