import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {
    @Override
    public void start(Stage stage) {
        int itemsCount = 20_000;

        ObservableList<String> list = FXCollections.observableArrayList();

        for (int i = 0; i < itemsCount; i++) {
            list.add(String.format("%07d", i));
        }

        ListView<String> listView = new ListView<>(list);
        listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        Button button = new Button(String.format("Select %d items and measure selection time", itemsCount));
        button.setOnAction(actionEvent -> {
            long timestamp = System.currentTimeMillis();

            listView.getSelectionModel().selectRange(0, itemsCount - 1); // <== Here `selectRange` take a lot of time to select items

            String message = String.format("Selection time: %d seconds", (System.currentTimeMillis() - timestamp) / 1000);
            Alert alert = new Alert(Alert.AlertType.INFORMATION, message);
            alert.initOwner(stage);
            alert.showAndWait();
        });

        stage.setScene(new Scene(new VBox(listView, button)));
        stage.show();
    }
}
