package com.example.hotel;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class PesananController {

    public ChoiceBox<String> namaHotel;
    public ChoiceBox<Integer> nomorKamar;
    public Label alert;

    public void initialize() {
        for (Object namaHotel:kamarPesanan.getNamaHotel()) {
            this.namaHotel.getItems().add((String) namaHotel);
        }
        namaHotel.getSelectionModel().selectFirst();
        nomorKamar.getItems().setAll(kamarPesanan.getKamarYangDipesan(this.namaHotel.getValue()));
        nomorKamar.getSelectionModel().selectFirst();
    }

    public void delete() {
        System.out.println("Dapat");
        if(nomorKamar.getValue() == null) {
            alert.setText("Gagal");
        } else {


            int nomorkmr = nomorKamar.getValue();
            kamarPesanan.deleteKamaryangDipesan(namaHotel.getValue(), nomorkmr);
            nomorKamar.getItems().remove((Integer) nomorkmr);
            nomorKamar.getSelectionModel().selectFirst();
            alert.setText("Berhasil");
        }
        Function.setTimeout(() -> {
            alert.setText("");
        }, 1000);
    }
    public void changeHotel() {
        nomorKamar.getItems().setAll(kamarPesanan.getKamarYangDipesan(this.namaHotel.getValue()));
        nomorKamar.getSelectionModel().selectFirst();
    }
    public void setScene() throws IOException {
        Scene scene2 = new Scene(new FXMLLoader(HotelApp.class.getResource("Hotel.fxml")).load(), 600, 400);
        Stage stage = (Stage) nomorKamar.getScene().getWindow();
        stage.setScene(scene2);
    }

    public void logout(ActionEvent actionEvent) throws IOException {
        Scene scene2 = new Scene(new FXMLLoader(HotelApp.class.getResource("Login.fxml")).load(), 600, 400);
        Stage stage = (Stage) nomorKamar.getScene().getWindow();
        stage.setScene(scene2);
    }
}
