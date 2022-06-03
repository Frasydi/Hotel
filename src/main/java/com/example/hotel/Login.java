package com.example.hotel;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class Login {
    public Button left;
    public Button right;
    public TextField username;
    public TextField password;
    public Label title;
    public Label alert;

    private boolean isRegister = false;
    public void initialize() {
        kamarPesanan.createhotel();
    }
    public void kiri() {
        if(isRegister) {
            isRegister = false;
            title.setText("Login");
            left.setText("Login");
            right.setText("Register");
            return;
        }
        if(!kamarPesanan.login(username.getText(), password.getText())) {
            alert.setText("Tidak dapat menemukan username/password salah");
            System.out.println("Gagal Login");
            Function.setTimeout(() -> {
                alert.setText("");
            }, 1000);
            return;
        }

            System.out.println("Berhasil login");
            alert.setText("Berhasil login");
            Function.setTimeout(() -> {
                Scene scene2 = null;
                try {
                    scene2 = new Scene(new FXMLLoader(HotelApp.class.getResource("Hotel.fxml")).load(), 600, 400);
                    Stage stage = (Stage) right.getScene().getWindow();
                    stage.setScene(scene2);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }, 1000);


    }
    public void kanan() {
        if(!isRegister) {
            isRegister = true;
            title.setText("Register");
            left.setText("Back");
            right.setText("Register");
            return;
        }
        if(username.getText().equals("") || password.getText().equals("")) {
            System.out.println("Kosong");
            alert.setText("Anda harus mengisikan username dan password");
        } else {
            System.out.println("Isi");
            alert.setText("Berhasil membuat akun");
            kamarPesanan.createAccount(username.getText(), password.getText());
            isRegister = false;
            title.setText("Login");
            left.setText("Login");
            right.setText("Register");

        }
        Function.setTimeout(() -> {
            alert.setText("");
        }, 1000);
    }
}
