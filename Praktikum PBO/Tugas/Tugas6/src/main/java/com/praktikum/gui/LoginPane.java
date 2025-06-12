package main.java.com.praktikum.gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import main.java.com.praktikum.main.LoginSystem;
import main.java.com.praktikum.users.Admin;
import main.java.com.praktikum.users.Mahasiswa;
import main.java.com.praktikum.users.User;

public class LoginPane extends VBox {
    private ComboBox<String> roleBox;
    private TextField usernameField;
    private PasswordField passwordField;
    private Label messageLabel;
    private Label test;

    public LoginPane() {
        setSpacing(10);
        setPadding(new Insets(20));
        setAlignment(Pos.CENTER);
        setPrefSize(800, 500);

        Label title = new Label("Login Sistem Lost & Found");
        roleBox = new ComboBox<>();
        roleBox.getItems().addAll("Mahasiswa", "Admin");
        roleBox.setValue("Mahasiswa");

        usernameField = new TextField();
        usernameField.setPromptText("Username");
        passwordField = new PasswordField();
        passwordField.setPromptText("Password");

        Button loginBtn = new Button("Login");
        messageLabel = new Label();

        Button test = new Button("test");
        HBox test1 = new HBox(loginBtn, test);
        test1.setAlignment(Pos.CENTER);

        loginBtn.setOnAction(e -> handleLogin());

        getChildren().addAll(title, roleBox, usernameField, passwordField, test1, messageLabel);
    }

    private void handleLogin() {
        String role = roleBox.getValue();
        String user = usernameField.getText();
        String pass = passwordField.getText();

        if (role.equals("Admin") && user.equals("admin") && pass.equals("admin")) {
            main.java.com.praktikum.main.LoginSystem.setScene(
                new javafx.scene.Scene(new AdminDashboard(new main.java.com.praktikum.users.Admin("Administrator", "admin", "admin")), 800, 500)
            );
            return;
        }

        User loginUser = main.java.com.praktikum.data.DataStore.loadUsers().stream()
            .filter(u -> u.getUsername().equals(user) && u.getPassword().equals(pass) &&
                (role.equals("Mahasiswa") && u instanceof Mahasiswa))
            .findFirst().orElse(null);

        if (loginUser != null) {
            main.java.com.praktikum.main.LoginSystem.setScene(
                new javafx.scene.Scene(new MahasiswaDashboard((Mahasiswa) loginUser), 800, 500)
            );
        } else {
            messageLabel.setText("Login gagal! Username atau Password salah.");
        }
    }
}
