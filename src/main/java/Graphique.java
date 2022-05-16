import javafx.application.Application;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.awt.*;
import java.util.ArrayList;

public class Graphique extends Application {
    @Override
    public void start(Stage stage) throws Exception {

        //axe pour graphe
        NumberAxis x = new NumberAxis();
        x.setLabel("Abscisses");
        NumberAxis y = new NumberAxis();
        y.setLabel("Ordonnées");
        LineChart graph = new LineChart<>(x, y);

        // données
        Model model = new Model("A3205.txt");
        XYChart.Series series = new XYChart.Series();

        for (Client c : model.getClients()) {
            series.getData().add(new XYChart.Data(c.getX(), c.getY()) );
        }

        graph.getData().add(series);

        VBox vbox = new VBox(graph);

        //Group root = new Group();
        Scene scene = new Scene(vbox, 600, 300);
        stage.setTitle("Graphique du projet");
        stage.setScene(scene);

        stage.show();
    }

    public void main(String... args){
        launch(args);
    }
}
