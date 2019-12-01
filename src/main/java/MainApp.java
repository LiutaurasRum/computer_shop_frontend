import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import com.google.gson.Gson;


public class MainApp extends Application {
    private static final String ADDRESS = "localhost";
    private static final String PORT = "8080";
    private static final String API_INFO = "api/info";

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("scene.fxml"));

        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
        
        stage.setTitle("JavaFX and Gradle");
        stage.setScene(scene);
        stage.show();

        HttpClient httpClient = new HttpClient(ADDRESS, PORT);
        Info[] info = new Gson().fromJson(httpClient.get(API_INFO), Info[].class);
        for (int i = 0; i < info.length; i++) {
            System.out.println("name: " + info[i].getName() + " model: " + info[i].getModel() + " count: " + Integer.valueOf(info[i].getCount()));
        }

    }

    public static void main(String[] args) {
        launch(args);
    }

}
