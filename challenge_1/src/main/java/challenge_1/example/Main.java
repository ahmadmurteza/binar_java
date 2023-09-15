package challenge_1.example;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {

    private static int nasiGoreng = 15000;
    private static int mieGoreng = 13000;
    private static int nasiAyam = 18000;
    private static int esTehManis = 3000;
    private static int esJeruk = 5000;

    private static Scanner input = new Scanner(System.in);
    private static String option;
    private static int qty;

    // formating uang
    private static String formatPrint(int input) {
        return new DecimalFormat("#,###").format(input);
    }

    private static void tampilkanMenu(JumlahTotal object) {
        System.out.println("==========================");
        System.out.println("Selamat datang di BinarFud");
        System.out.println("==========================");
        System.out.println("");

        System.out.println("Silahkan pilih makanan : ");
        System.out.println("1. Nasi Goreng      | " + formatPrint(nasiGoreng));
        System.out.println("2. Mie Goreng       | " + formatPrint(mieGoreng));
        System.out.println("3. Nasi + Ayam      | " + formatPrint(nasiAyam));
        System.out.println("4. Es Teh Manis     | " + formatPrint(esTehManis));
        System.out.println("5. Es Jeruk         | " + formatPrint(esJeruk));
        System.out.println("99. Pesan dan Bayar");
        System.out.println("0. Keluar Aplikasi");
        
        System.out.printf("=> ");
        option = input.next();
        pesananInput(option, object);
    }

    private static void pesananInput(String option, JumlahTotal object) {
        switch (option) {
            case "1":
                penjumlahan("Nasi Goreng         | ", nasiGoreng,  object);
                break;
            case "2":
                penjumlahan("Mie Goreng          | ", mieGoreng, object);
                break;
            case "3":
                penjumlahan("Nasi + Ayam         | ", nasiAyam, object);
                break;
            case "4":                
                penjumlahan("Es Teh Manis        | ", esTehManis, object);
                break;   
            case "5":
                penjumlahan("Es Jeruk            | ", esJeruk, object);
                break; 
            case "99":
                pesanBayar(object);
                break;
            case "0":
                System.exit(0);
                break;
        
            default:
                System.out.println("Input Tidak Valid");
                break;
        }

    }

    private static void penjumlahan(String menu, int varInput, JumlahTotal object) {
        System.out.println("==========================");
        System.out.println("Berapa pesanan anda");
        System.out.println("==========================");
        System.out.println("");
        System.out.println(menu + formatPrint(varInput));
        System.out.println("");
        System.out.printf("qty => ");
        qty = input.nextInt();
        if (qty <= 0) {
            tampilkanMenu(object);
        } else {
            switch (varInput) {
                case 15000:
                    object.setJmlNasiGoreng(qty);
                    object.setTotalNasiGoreng(qty * varInput);
                    break;
                case 13000:
                    object.setJmlMieGoreng(qty);
                    object.setTotalMieGoreng(qty * varInput);
                    break;
                case 18000:
                    object.setJmlNasiAyam(qty);
                    object.setTotalNasiAyam(qty * varInput);
                    break;
                case 3000:
                    object.setJmlEsTehManis(qty);
                    object.setTotalEsTehManis(qty * varInput);
                    break;
                case 5000:
                    object.setJmlEsJeruk(qty);
                    object.setTotalEsJeruk(qty * varInput);
                    break;
            
                default:
                    break;
            }
            tampilkanMenu(object);

        }
    }

    private static void pesanBayar(JumlahTotal object) {
        System.out.println("==========================");
        System.out.println("Konfirmasi & pembayaran");
        System.out.println("==========================");
        System.out.println("");
        if (object.jmlNasiGoreng > 0) {
            System.out.println("Nasi Goreng     " + formatPrint(object.jmlNasiGoreng) +"       "+ formatPrint(object.totalNasiGoreng));
        } 
        if (object.jmlMieGoreng > 0) {
            System.out.println("Mie Goreng      " + formatPrint(object.jmlMieGoreng) +"       "+ formatPrint(object.totalMieGoreng));
        }
        if (object.jmlNasiAyam > 0) {
            System.out.println("Nasi + Ayam     " + formatPrint(object.jmlNasiAyam) +"       "+ formatPrint(object.totalNasiAyam));
        }
        if (object.jmlEsTehManis > 0) {
            System.out.println("Es Teh Manis    " + formatPrint(object.jmlEsTehManis) +"       "+ formatPrint(object.totalEsTehManis));
        }
        if (object.jmlEsJeruk > 0) {
            System.out.println("Es Jeruk        " + formatPrint(object.jmlEsJeruk) +"       "+ formatPrint(object.totalEsJeruk));
        }

        int jumlahPesanan = object.jmlNasiGoreng + object.jmlMieGoreng + object.jmlNasiAyam + object.jmlEsTehManis + object.jmlEsJeruk;
        int totalPembayaran = object.totalNasiGoreng + object.totalMieGoreng + object.totalNasiAyam + object.totalEsTehManis + object.totalEsJeruk;
        System.out.println("--------------------------------+");
        System.out.println("Total           " + formatPrint(jumlahPesanan) + "       " + formatPrint(totalPembayaran));

        System.out.println("");
        System.out.println("1. Konfirmasi Dan Bayar");
        System.out.println("2. Kembali ke menu utama");
        System.out.println("0. Keluar Aplikasi");
        System.out.println("");
        
        System.out.printf("=> ");
        option = input.next();
        switch (option) {
            case "1":
                if (jumlahPesanan <= 0 || totalPembayaran <= 0 ) {
                    System.out.println("\n");
                    System.out.println("Belum memesan menu sama sekali \n");
                    tampilkanMenu(object);
                }
                printStruk(object);
                break;
            case "2":
                tampilkanMenu(object);
                break;
            case "0":
                System.exit(0);
                break;
        
            default:
                break;
        }
    }

    private static void printStruk(JumlahTotal object) {
        Writer writer = null;
        try {
            writer = new BufferedWriter(new OutputStreamWriter(
            new FileOutputStream("challenge_1/struk.txt"), "utf-8"));

            writer.write("==========================\n");
            
            writer.write("BinarFud\n");
            writer.write("==========================\n");
            writer.write("\n");
            writer.write("Terima kasih sudah memesan\n");
            writer.write("di BinarFud\n");
            writer.write("\n");
            writer.write("Dibawah ini adalah pesanan anda \n");
            if (object.jmlNasiGoreng > 0) {
                writer.write("Nasi Goreng     " + object.jmlNasiGoreng +"       "+ object.totalNasiGoreng + "\n");
            } 
            if (object.jmlMieGoreng > 0) {
                writer.write("Mie Goreng      " + object.jmlMieGoreng +"       "+ object.totalMieGoreng + "\n");
            }
            if (object.jmlNasiAyam > 0) {
                writer.write("Nasi + Ayam     " + object.jmlNasiAyam +"       "+ object.totalNasiAyam + "\n");
            }
            if (object.jmlEsTehManis > 0) {
                writer.write("Es Teh Manis    " + object.jmlEsTehManis +"       "+ object.totalEsTehManis + "\n");
            }
            if (object.jmlEsJeruk > 0) {
                writer.write("Es Jeruk        " + object.jmlEsJeruk +"       "+ object.totalEsJeruk + "\n");
            }
            writer.write("\n");

            int jumlahPesanan = object.jmlNasiGoreng + object.jmlMieGoreng + object.jmlNasiAyam + object.jmlEsTehManis + object.jmlEsJeruk;
            int totalPembayaran = object.totalNasiGoreng + object.totalMieGoreng + object.totalNasiAyam + object.totalEsTehManis + object.totalEsJeruk;
            writer.write("--------------------------------+");
            writer.write("\n");
            writer.write("Total           " + formatPrint(jumlahPesanan) + "       " + formatPrint(totalPembayaran));
            writer.write("\n");
            writer.write("\n");

            writer.write("Pembayaran : BinarCash \n");
            writer.write("\n");

            writer.write("==========================\n");
            
            writer.write("Simpan struk ini sebagai\n");
            writer.write("bukti pembayaran\n");
            writer.write("==========================\n");
        } catch (IOException ex) {
            // Report
        } finally {
            try {writer.close();} catch (Exception ex) {/*ignore*/}
        }
        tampilkanMenu(object);
    }

    public static void main(String[] args) {

        JumlahTotal jumlahTotal = new JumlahTotal();
        
        tampilkanMenu(jumlahTotal);

        
    }
}

// test pr