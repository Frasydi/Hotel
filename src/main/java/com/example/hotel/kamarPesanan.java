package com.example.hotel;

import java.util.ArrayList;
import java.util.HashMap;

public class kamarPesanan {

    private static int login = 0;
    private static boolean isCreated = false;
    private static final ArrayList<Akun> akun = new ArrayList<>();
    private static final HashMap<String, Integer> hotel = new HashMap<>();

    private static final HashMap<String, ArrayList<Integer>> allhotel = new HashMap<>();
    private static final String[] nama_hotel = {"Losari Beach Hotel", "Grand Asia Hotel", "Amaris", "Merapi Merbabu Hotel", "Novotel Jakarta Cikini", "Aston Kartika Grogol Hotel",
            "Ozone Hotel", "Discovery Ancol", "Hotel Zuri Express"};

    static void createhotel() {
        if(isCreated) {
            return;
        }
        int[] kamar = {
          120,136,240,177,170,273,94,203,99
        };
        for (int i = 0; i <kamar.length; i++) {
            hotel.put(nama_hotel[i], kamar[i]);
            allhotel.put(nama_hotel[i], new ArrayList<>());
        }
        isCreated = true;
        System.out.println("Berhasil meniginialis");
    }
    static void createAccount(String username, String password) {
        akun.add(new Akun(username, password));
        for (String nama : nama_hotel) {
            akun.get(akun.size()-1).hotelYangdipesan.put(nama, new ArrayList<>());
        }
        System.out.println(akun.get(akun.size()-1).username);
    }
    static boolean login(String username, String password) {
        for (int i = 0; i < akun.size(); i++) {
            if(akun.get(i).username.equals(username) && akun.get(i).password.equals(password)) {
                login = i;

                return true;
            }
        }
        return false;
    }
    static boolean checkifcontained(String namaHotel, int kamar) {
        return allhotel.get(namaHotel).contains(kamar);
    }
    static void addingKamarPesanan(String namaHotel, int kamar) {
        allhotel.get(namaHotel).add(kamar);
        akun.get(login).addKamar(namaHotel, kamar);
    }
    static Object[] getNamaHotel() {
        return hotel.keySet().toArray();
    }
    static int getJumlahKamar(String namaHotel) {
       return hotel.get(namaHotel);
    }
    static ArrayList<Integer> getKamarYangDipesan(String namaHotel) {
        return akun.get(login).getKamarYangDipesan(namaHotel);
    }
    static void deleteKamaryangDipesan(String namaHotel, int nomor) {
        allhotel.get(namaHotel).remove((Integer) nomor);
        akun.get(login).deleteKamar(namaHotel, nomor);
    }


} class Akun {

    String username;
    String password;
    HashMap<String, ArrayList<Integer>> hotelYangdipesan = new HashMap<>();
    Akun(String username, String password) {
        this.username = username;
        this.password = password;
    }
    public void addKamar(String namaHotel, int kamar) {
        hotelYangdipesan.get(namaHotel).add(kamar);
    }
    public ArrayList<Integer> getKamarYangDipesan(String namaHotel) {
         return hotelYangdipesan.get(namaHotel);
    }
    public void deleteKamar(String nama, int nomor) {
        hotelYangdipesan.get(nama).remove((Integer) nomor);
    }
}
