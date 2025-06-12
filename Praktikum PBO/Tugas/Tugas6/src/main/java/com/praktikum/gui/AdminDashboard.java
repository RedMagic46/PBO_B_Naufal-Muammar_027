package main.java.com.praktikum.gui;

import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.*;
import javafx.collections.*;
import main.java.com.praktikum.users.*;
import main.java.com.praktikum.data.*;
import main.java.com.praktikum.main.LoginSystem;
import javafx.scene.Scene;

public class AdminDashboard extends VBox {
    private TableView<Item> laporanTable;
    private TableView<Mahasiswa> mahasiswaTable;
    private TextField namaField, nimField;
    private Admin admin;

    public AdminDashboard(Admin admin) {
        this.admin = admin;
        setSpacing(10);
        setPadding(new Insets(20));
        setPrefSize(800, 500);

        laporanTable = itemTable();
        Button claimedBtn = new Button("Tandai Claimed");
        claimedBtn.setOnAction(e -> handleClaimed());
        VBox left = new VBox(5, new Label("Halo, Administrator " + admin.getName()), new Label("Laporan Barang"), laporanTable, claimedBtn);
        left.setPrefWidth(350);
        VBox.setVgrow(laporanTable, Priority.ALWAYS);

        mahasiswaTable = mahasiswaTable();
        VBox right = new VBox(5, new Label("Data Mahasiswa"), mahasiswaTable);
        VBox.setVgrow(mahasiswaTable, Priority.ALWAYS);

        HBox tablesBox = new HBox(10, left, right);
        HBox.setHgrow(left, Priority.ALWAYS);
        HBox.setHgrow(right, Priority.ALWAYS);
        VBox.setVgrow(tablesBox, Priority.ALWAYS);

        namaField = new TextField(); namaField.setPromptText("Nama Mahasiswa");
        nimField = new TextField(); nimField.setPromptText("NIM");
        Button tambahBtn = new Button("Tambah");
        Button hapusBtn = new Button("Hapus");
        tambahBtn.setOnAction(e -> handleTambah());
        hapusBtn.setOnAction(e -> handleHapus());
        HBox manageBox = new HBox(5, namaField, nimField, tambahBtn, hapusBtn);
        manageBox.setAlignment(Pos.CENTER_LEFT);

        Button logoutBtn = new Button("Logout");
        logoutBtn.setOnAction(e -> LoginSystem.setScene(new Scene(new LoginPane(), 800, 500)));
        HBox bottomBox = new HBox(10, manageBox, logoutBtn);
        bottomBox.setAlignment(Pos.CENTER_RIGHT);

        getChildren().addAll(tablesBox, bottomBox);
        refreshLaporan();
        refreshMahasiswa();
    }

    private TableView<Item> itemTable() {
        TableView<Item> table = new TableView<>();
        TableColumn<Item, String> namaCol = new TableColumn<>("Nama");
        namaCol.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getName()));
        TableColumn<Item, String> lokasiCol = new TableColumn<>("Lokasi");
        lokasiCol.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getLokasi()));
        TableColumn<Item, String> statusCol = new TableColumn<>("Status");
        statusCol.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getStatus()));
        table.getColumns().addAll(namaCol, lokasiCol, statusCol);
        table.setPrefHeight(250);
        return table;
    }

    private TableView<Mahasiswa> mahasiswaTable() {
        TableView<Mahasiswa> table = new TableView<>();
        TableColumn<Mahasiswa, String> namaCol = new TableColumn<>("Nama");
        namaCol.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getName()));
        TableColumn<Mahasiswa, String> nimCol = new TableColumn<>("NIM");
        nimCol.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getNim()));
        table.getColumns().addAll(namaCol, nimCol);
        table.setPrefHeight(200);
        return table;
    }

    private void handleClaimed() {
        Item selected = laporanTable.getSelectionModel().getSelectedItem();
        if (selected != null && !selected.getStatus().equals("Claimed")) {
            ObservableList<Item> items = FXCollections.observableArrayList(DataStore.loadItems());
            for (Item i : items) {
                if (i.getName().equals(selected.getName()) && i.getLokasi().equals(selected.getLokasi())) {
                    i.setStatus("Claimed");
                }
            }
            DataStore.saveItems(items);
            refreshLaporan();
        }
    }

    private void handleTambah() {
        String nama = namaField.getText().trim();
        String nim = nimField.getText().trim();
        if (!nama.isEmpty() && !nim.isEmpty()) {
            Mahasiswa mhs = new Mahasiswa(nama, nim, nim, nim);
            java.util.List<User> users = DataStore.loadUsers();
            users.add(mhs);
            DataStore.saveUsers(users);
            refreshMahasiswa();
            namaField.clear(); nimField.clear();
        }
    }

    private void handleHapus() {
        Mahasiswa selected = mahasiswaTable.getSelectionModel().getSelectedItem();
        if (selected != null) {
            java.util.List<User> users = DataStore.loadUsers();
            users.removeIf(u -> u instanceof Mahasiswa && ((Mahasiswa) u).getNim().equals(selected.getNim()));
            DataStore.saveUsers(users);
            refreshMahasiswa();
        }
    }

    private void refreshLaporan() {
        ObservableList<Item> items = FXCollections.observableArrayList(DataStore.loadItems());
        laporanTable.setItems(items);
    }

    private void refreshMahasiswa() {
        ObservableList<Mahasiswa> mhs = FXCollections.observableArrayList();
        for (User u : DataStore.loadUsers()) {
            if (u instanceof Mahasiswa) mhs.add((Mahasiswa) u);
        }
        mahasiswaTable.setItems(mhs);
    }
}
