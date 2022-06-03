package com.example.hotel;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class HotelController {

    @FXML
    public Label alert;
    public ChoiceBox<String> namaHotel;
    public Label maxKamar;
    @FXML
    private Spinner<Integer> nomorKamar;

    @FXML
    private void pesan() {
        if(kamarPesanan.checkifcontained(namaHotel.getValue(), nomorKamar.getValue())) {
           alert.setText("Kamar di hotel ini sudah dipesan");
        } else {
            kamarPesanan.addingKamarPesanan(namaHotel.getValue(), nomorKamar.getValue());
            alert.setText("Berhasil memesan kamar di hotel ini");
        }
        Function.setTimeout(() -> {
            alert.setText("");
        }, 1000);

    }



    @FXML
    public void initialize() {
        this.namaHotel.getItems().clear();
        for (Object namaHotel: kamarPesanan.getNamaHotel()) {
            this.namaHotel.getItems().add((String) namaHotel);
        }
        this.namaHotel.getSelectionModel().selectFirst();
        this.maxKamar.setText("Max : "+kamarPesanan.getJumlahKamar(namaHotel.getValue()));
    }
    @FXML
    public void changejumlahkamar() {

        this.nomorKamar.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, kamarPesanan.getJumlahKamar(namaHotel.getValue())));
        this.nomorKamar.getEditor().setText("1");
        this.maxKamar.setText("Max : "+kamarPesanan.getJumlahKamar(namaHotel.getValue()));
    }

    @FXML
    private void nomorkamar(KeyEvent ev) {

        switch (ev.getCode()) {
            case UP -> nomorKamar.increment(1);
            case DOWN -> nomorKamar.decrement(1);
        }
    }


    public void setScene() throws IOException {
        Scene scene2 = new Scene(new FXMLLoader(HotelApp.class.getResource("deletePesanan.fxml")).load(), 600, 400);
        Stage stage = (Stage) nomorKamar.getScene().getWindow();
        stage.setScene(scene2);
    }

    public void logout(ActionEvent actionEvent) throws IOException {
        Scene scene2 = new Scene(new FXMLLoader(HotelApp.class.getResource("Login.fxml")).load(), 600, 400);
        Stage stage = (Stage) nomorKamar.getScene().getWindow();
        stage.setScene(scene2);
    }
}