import java.util.ArrayList;
import java.util.Scanner;

// Kelas IuranKas

/**
 * kelas iuran untuk mendapat inputan dari user
 */
class IuranKas {

    private String name;
    private int jumlah;

    /**
     * inputan nama dan jumlah setoran kas
     * @param nama
     * @param jumlah
     */
    public IuranKas(String nama, int jumlah) {
        this.name = nama;
        this.jumlah = jumlah;
    }

    public String getName() {
        return name;
    }

    public int getJumlah() {
        return jumlah;
    }

}

public class ProgramIuranKas {
    private ArrayList<IuranKas> daftarIuran;
    private Scanner scanner;

    public ProgramIuranKas() {
        daftarIuran = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    // Menambahkan iuran kas
    public void tambahIuran() {
        System.out.print("Masukkan nama: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan jumlah: ");
        int jumlah = scanner.nextInt();
        scanner.nextLine(); // untuk menghapus enter

        IuranKas iuran = new IuranKas(nama, jumlah);
        daftarIuran.add(iuran);
        System.out.println("Iuran kas berhasil ditambahkan!");
    }

    // Menghapus iuran kas
    public void hapusIuran() {
        System.out.print("Masukkan nama iuran kas yang ingin dihapus: ");
        String nama = scanner.nextLine();

        for (IuranKas iuran : daftarIuran) {
            if (iuran.getName().equals(nama)) {
                daftarIuran.remove(iuran);
                System.out.println("Iuran kas berhasil dihapus!");
                return;
            }
        }

        System.out.println("Iuran kas tidak ditemukan!");
    }

    // Menampilkan daftar iuran kas
    public void tampilkanDaftar() {
        System.out.println("Daftar Iuran Kas:");
        for (IuranKas iuran : daftarIuran) {
            System.out.println("Nama: " + iuran.getName() + ", Jumlah: " + iuran.getJumlah());
        }
    }

    public static void main(String[] args) {
        ProgramIuranKas program = new ProgramIuranKas();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Tambah Iuran Kas");
            System.out.println("2. Hapus Iuran Kas");
            System.out.println("3. Tampilkan Daftar Iuran Kas");
            System.out.println("4. Keluar");

            System.out.print("Pilih menu: ");
            int pilihan = scanner.nextInt();
            scanner.nextLine(); // untuk menghapus enter

            switch (pilihan) {
                case 1:
                    program.tambahIuran();
                    break;
                case 2:
                    program.hapusIuran();
                    break;
                case 3:
                    program.tampilkanDaftar();
                    break;
                case 4:
                    System.out.println("Terima kasih!");
                    return;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        }
    }
}