import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.util.Random;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    private void generateNewNumber() {
        targetNumber = random.nextInt(100) + 1;
    }

    private int targetNumber;
    private int attempts;
    private int min = 1;
    private int max = 100;
    private Random random = new Random();

    @Override
    public void start(Stage primaryStage) {
        Label titleLabel = new Label("🎯 Tebak Angka 1–100");
        titleLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        titleLabel.setTextFill(Color.DARKBLUE);

        Label instructionLabel = new Label("Masukkan tebakkanmu!");
        instructionLabel.setFont(Font.font("Arial", 16));

        TextField inputField = new TextField();
        inputField.setPromptText("Contoh: 42");
        inputField.setPrefWidth(100);

        Button actionButton = new Button("Tebak");
        actionButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white;");

        Label feedbackLabel = new Label("");
        feedbackLabel.setFont(Font.font(14));
        Label attemptsLabel = new Label("Jumlah percobaan: 0");

        Label rangeLabel = new Label("Tebak angka antara 1 - 100");

        HBox inputBox = new HBox(10, inputField, actionButton);
        inputBox.setAlignment(Pos.CENTER);

        VBox root = new VBox(15, titleLabel, instructionLabel, inputBox, feedbackLabel, attemptsLabel);
        root.setPadding(new Insets(20));
        root.setAlignment(Pos.CENTER);
        root.setStyle("-fx-background-color: #f0f8ff;");

        generateNewNumber();

        inputField.setOnAction(e -> actionButton.fire());

        actionButton.setOnAction(e -> {
            if (actionButton.getText().equals("🔄 Main Lagi")) {
                generateNewNumber();
                attempts = 0;
                min = 1;
                max = 100;
                feedbackLabel.setText("");
                inputField.clear();
                actionButton.setText("Tebak");
                attemptsLabel.setText("Jumlah percobaan: 0");
            } else {
                try {
                    int guess = Integer.parseInt(inputField.getText());
                    if (guess < min || guess > max) {
                        feedbackLabel.setText("Angka harus antara " + min + " dan " + max + "!");
                        return;
                    }
                    attempts++;
                    if (guess < targetNumber) {
                        feedbackLabel.setText("Terlalu kecil! Coba antara " + (guess + 1) + " - " + max);
                        min = guess + 1;
                    } else if (guess > targetNumber) {
                        feedbackLabel.setText("Terlalu besar! Coba antara " + min + " - " + (guess - 1));
                        max = guess - 1;
                    } else {
                        feedbackLabel.setText("🎉 Tebakan benar!");
                        actionButton.setText("🔄 Main Lagi");
                    }
                    inputField.clear();
                    attemptsLabel.setText("Jumlah percobaan: " + attempts);
                } catch (NumberFormatException ex) {
                    feedbackLabel.setText("Masukkan angka yang valid!");
                }
            }
        });

        Scene scene = new Scene(root, 420, 250);
        primaryStage.setTitle("Tebak Angka");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
