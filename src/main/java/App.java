import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.stage.Stage;

public class App extends Application {
    @Override
    public void start(Stage stage) {
        ObservableList<String> list = FXCollections.observableArrayList();

        for (int i = 0; i < 20_000; i++) {
            list.add(String.format("%06d", i));
        }

        ListView<String> listView = new ListView<>(list);
        listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        stage.setScene(new Scene(listView));
        stage.show();
    }
}
