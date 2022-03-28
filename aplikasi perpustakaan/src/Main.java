import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;

// buat class mahasiswa
class Mahasiswa{
    String nama;
    String NPM;
    int angkatan;
    Prodi prodi;
    int peminjamanBuku = 0;
    int pengembalianBuku = 0;

    // constractor
    Mahasiswa(String nama, String NPM, int angkatan){
        this.nama = nama;
        this.NPM = NPM;
        this.angkatan = angkatan;
    }

    // join prodi
    void prodi(Prodi prodi){
        this.prodi = prodi;
    }

    // get nama
    String getNama(){
        return this.nama;
    }

    // get NPM
    String getNPM(){
        return this.NPM;
    }

    // display mahasiswa
    void display(){
        System.out.println("nama : " + this.nama);
        System.out.println("NPM : " + this.NPM);
        System.out.println("angkatan : " + this.angkatan);
        prodi.display();
    }

    // mahasiswa melakukan absensi
    String absensi(){
        System.out.println(this.nama + " berhasil melakukan absensi");
        return this.nama;
    }

    // mahasiswa melakukan peminjaman buku
    int melakukanPeminjaman(){
        return peminjamanBuku++;
    }

    // mahasiswa melakukan pengembalian buku
    int melakukanPengembalian(){
        return pengembalianBuku++;
    }

}

// buat class prodi
class Prodi{
    String nama;

    Prodi(String nama){
        this.nama = nama;
    }

    void display(){
        System.out.println("prodi : " + this.nama + "\n");
    }
}

// class buku
class Buku{
    String judul;
    String penulis;
    String penerbit;
    int tahunTerbit;
    Mahasiswa mahasiswa; 
    Boolean cekStatus;
    int peminjaman = 0;

    Buku(String judul, String penulis, String penerbit, int tahunTerbit){
        this.judul = judul;
        this.penulis = penulis;
        this.penerbit = penerbit;
        this.tahunTerbit = tahunTerbit;
    }

    // fungsi buku dipinjam mahasiswa 
    void dipinjam(Mahasiswa mahasiswa){
        if(this.cekStatus == null){
            this.mahasiswa = mahasiswa;
            this.cekStatus = true;
            mahasiswa.melakukanPeminjaman();
            System.out.println("buku berhasil dipinjam");
        }else{
            System.out.println("buku sudah dipinjam");
        }
    }

    // mengembalikan buku
    void kembalikan(Mahasiswa mahasiswa){
        if(cekStatus == null){
            System.out.println("buku belum dipinjam");
        }else if(this.mahasiswa!=mahasiswa){
            System.out.println("anda bukan peminjam buku ini");
        }else{
            this.mahasiswa = null;
            this.cekStatus = null; 
            mahasiswa.melakukanPengembalian();
            System.out.println("buku berhasil dikembalikan");
        }
    }

    // tampilkan status buku
    void display(){
        if(this.cekStatus == null){
            System.out.println(this.judul);
        }else{
            System.out.println(this.judul + " - telah dipinjam oleh : " + mahasiswa.getNama());

        }
    }

}

public class Main {
    public static void main(String[] args) {
        // declaration input scanner
        Scanner input = new Scanner(System.in);

        // data prodi
        Prodi TI = new Prodi("Teknik Informatika");
        Prodi TE = new Prodi("Teknik Elektro");

        // data mahasiswa 
        Mahasiswa mhs1 = new Mahasiswa("farhan", "2065061002", 20 );
        Mahasiswa mhs2 = new Mahasiswa("fajar", "2065061003", 20 );
        Mahasiswa mhs3 = new Mahasiswa("irgi", "2065061004", 20 );
        Mahasiswa mhs4 = new Mahasiswa("yusuf", "2065061005", 21 );
        Mahasiswa mhs5 = new Mahasiswa("wildan", "2065061006", 21 );

        // mahasiswa join prodi
        mhs1.prodi(TI);
        mhs2.prodi(TI);
        mhs3.prodi(TI);
        mhs4.prodi(TE);
        mhs5.prodi(TE);

        // data buku
        Buku buku1 = new Buku("Koleksi Lengkap Software Hacking", "Dedik Kurniawan", "Elex Media", 2013);
        Buku buku2 = new Buku("Panduan Menjadi Teknisi Komputer Laptop Dan Jaringan", "Ahmad Yani", "Mediakita", 2012);
        Buku buku3 = new Buku("Energy Myths and Realities: Bringing Science to the Energy Policy Debate", "Vaclav Smil", "Elex Media", 2010);
        Buku buku4 = new Buku("Teknologi Kendaraan Berbahan Bakar LPG", "Muji Setiyo & Suyitno", "Deepublish", 2019);
        Buku buku5 = new Buku("Sustainable Energy without the hot air", "David MacKay", "Elex Media", 2008);

        // main
        int pilihan;
        do {     
            System.out.println("\npilih tindakan");
            System.out.println("1 . Absensi");
            System.out.println("2 . Tampilkan Rekapan Absensi");
            System.out.println("3 . exit");
            System.out.print("pilihan : ");
            pilihan = input.nextInt();
            switch(pilihan){
                case 1 :
                    System.out.print("\nmasukkan NPM : ");
                    String NPM = input.next();
                    if (NPM.equals(mhs1.getNPM())){
                        String nama = mhs1.absensi();
                        dataAbsensi(nama);

                        int pilih;
                        do {
                            System.out.println("\npilih tindakan");
                            System.out.println("1. pinjam buku");
                            System.out.println("2. kembalikan buku");
                            System.out.println("3. minta surat bebas perpus");
                            System.out.println("4. kembali");
                            System.out.print("pilih : ");
                            pilih = input.nextInt();
                            switch (pilih) {
                                // pinjam buku
                                case 1:
                                    System.out.println("\nbuku yang tersedia : ");
                                    System.out.print("1-"); buku1.display();
                                    System.out.print("2-"); buku2.display();
                                    System.out.print("3-"); buku3.display();
                                    System.out.print("4-"); buku4.display();
                                    System.out.print("5-"); buku5.display();
    
                                    String pinjamLagi;
                                    do {
                                        System.out.print("\npinjam buku no: ");
                                        int pinjam = input.nextInt();
                                        switch (pinjam) {
                                            case 1:
                                                buku1.dipinjam(mhs1);
                                                break;
                                            case 2:
                                                buku2.dipinjam(mhs1);
                                                break;
                                            case 3:
                                                buku3.dipinjam(mhs1);
                                                break;
                                            case 4:
                                                buku4.dipinjam(mhs1);
                                                break;
                                            case 5:
                                                buku5.dipinjam(mhs1);
                                                break;
                                            default:
                                                break;
                                        }
                                        System.out.print("\napakah ingin meminjam buku yang lain(y/n) : ");
                                        pinjamLagi = input.next();
                                    } while (pinjamLagi.equals("Y") || pinjamLagi.equals("y"));
                                    break;
                                // kembalikan buku
                                case 2:
                                    System.out.println("\nbuku yang tersedia : ");
                                    System.out.print("1-"); buku1.display();
                                    System.out.print("2-"); buku2.display();
                                    System.out.print("3-"); buku3.display();
                                    System.out.print("4-"); buku4.display();
                                    System.out.print("5-"); buku5.display();

                                    String kembalikanBukuLain;
                                    do {
                                        System.out.print("\nkembalikan buku no: ");
                                        int kembalikan = input.nextInt();
                                        switch (kembalikan) {
                                            case 1:
                                                buku1.kembalikan(mhs1);
                                                break;
                                            case 2:
                                                buku2.kembalikan(mhs1);
                                                break;
                                            case 3:
                                                buku3.kembalikan(mhs1);
                                                break;
                                            case 4:
                                                buku4.kembalikan(mhs1);
                                                break;
                                            case 5:
                                                buku5.kembalikan(mhs1);
                                                break;
                                            default:
                                                break;
                                        }
                                        System.out.print("\napakah ingin mengembalikan buku yang lain(y/n) : ");
                                        kembalikanBukuLain = input.next();
                                    } while (kembalikanBukuLain.equals("Y") || kembalikanBukuLain.equals("y"));
                                    break;
                                // minta surat bebas perpustakaan
                                case 3: 
                                    if(mhs1.melakukanPeminjaman()==mhs1.melakukanPengembalian()){
                                        System.out.println("mahasiswa tidak memiliki buku yang harus dikembalikan");
                                        System.out.println("mahasiswa bisa mendapat surat bebas perpustakaan");
                                    }else{
                                        System.out.println("mahasiswa masih memiliki buku yang belum dikembalikan");
                                        System.out.println("silahkan kembalikan buku terlebih dahulu");
                                    }
                                    break;
                                default:
                                    break;
                            }
                        } while (pilih == 1 || pilih == 2 || pilih == 3);
                    }else if(NPM.equals(mhs2.getNPM())){
                        String nama = mhs2.absensi();
                        dataAbsensi(nama);

                        int pilih;
                        do {
                            System.out.println("\npilih tindakan");
                            System.out.println("1. pinjam buku");
                            System.out.println("2. kembalikan buku");
                            System.out.println("3. minta surat bebas perpus");
                            System.out.println("4. kembali");
                            System.out.print("pilih : ");
                            pilih = input.nextInt();
                            switch (pilih) {
                                // pinjam buku
                                case 1:
                                    System.out.println("\nbuku yang tersedia : ");
                                    System.out.print("1-"); buku1.display();
                                    System.out.print("2-"); buku2.display();
                                    System.out.print("3-"); buku3.display();
                                    System.out.print("4-"); buku4.display();
                                    System.out.print("5-"); buku5.display();
    
                                    String pinjamLagi;
                                    do {
                                        System.out.print("\npinjam buku no: ");
                                        int pinjam = input.nextInt();
                                        switch (pinjam) {
                                            case 1:
                                                buku1.dipinjam(mhs2);
                                                break;
                                            case 2:
                                                buku2.dipinjam(mhs2);
                                                break;
                                            case 3:
                                                buku3.dipinjam(mhs2);
                                                break;
                                            case 4:
                                                buku4.dipinjam(mhs2);
                                                break;
                                            case 5:
                                                buku5.dipinjam(mhs2);
                                                break;
                                            default:
                                                break;
                                        }
                                        System.out.print("\napakah ingin meminjam buku yang lain(y/n) : ");
                                        pinjamLagi = input.next();
                                    } while (pinjamLagi.equals("Y") || pinjamLagi.equals("y"));
                                    break;
                                // kembalikan buku
                                case 2:
                                    System.out.println("\nbuku yang tersedia : ");
                                    System.out.print("1-"); buku1.display();
                                    System.out.print("2-"); buku2.display();
                                    System.out.print("3-"); buku3.display();
                                    System.out.print("4-"); buku4.display();
                                    System.out.print("5-"); buku5.display();

                                    String kembalikanBukuLain;
                                    do {
                                        System.out.print("\nkembalikan buku no: ");
                                        int kembalikan = input.nextInt();
                                        switch (kembalikan) {
                                            case 1:
                                                buku1.kembalikan(mhs2);
                                                break;
                                            case 2:
                                                buku2.kembalikan(mhs2);
                                                break;
                                            case 3:
                                                buku3.kembalikan(mhs2);
                                                break;
                                            case 4:
                                                buku4.kembalikan(mhs2);
                                                break;
                                            case 5:
                                                buku5.kembalikan(mhs2);
                                                break;
                                            default:
                                                break;
                                        }
                                        System.out.print("\napakah ingin mengembalikan buku yang lain(y/n) : ");
                                        kembalikanBukuLain = input.next();
                                    } while (kembalikanBukuLain.equals("Y") || kembalikanBukuLain.equals("y"));
                                    break;
                                // minta surat bebas perpus
                                case 3: 
                                    if(mhs2.melakukanPeminjaman()==mhs2.melakukanPengembalian()){
                                        System.out.println("mahasiswa tidak memiliki buku yang harus dikembalikan");
                                        System.out.println("mahasiswa bisa mendapat surat bebas perpustakaan");
                                    }else{
                                        System.out.println("mahasiswa masih memiliki buku yang belum dikembalikan");
                                        System.out.println("silahkan kembalikan buku terlebih dahulu");
                                    }
                                    break;
                                default:
                                    break;
                            }
                        } while (pilih == 1 || pilih == 2 || pilih == 3);
                    }else if(NPM.equals(mhs3.getNPM())){
                        String nama = mhs3.absensi();
                        dataAbsensi(nama);

                        int pilih;
                        do {
                            System.out.println("\npilih tindakan");
                            System.out.println("1. pinjam buku");
                            System.out.println("2. kembalikan buku");
                            System.out.println("3. minta surat bebas perpus");
                            System.out.println("4. kembali");
                            System.out.print("pilih : ");
                            pilih = input.nextInt();
                            switch (pilih) {
                                // pinjam buku
                                case 1:
                                    System.out.println("\nbuku yang tersedia : ");
                                    System.out.print("1-"); buku1.display();
                                    System.out.print("2-"); buku2.display();
                                    System.out.print("3-"); buku3.display();
                                    System.out.print("4-"); buku4.display();
                                    System.out.print("5-"); buku5.display();
    
                                    String pinjamLagi;
                                    do {
                                        System.out.print("\npinjam buku no: ");
                                        int pinjam = input.nextInt();
                                        switch (pinjam) {
                                            case 1:
                                                buku1.dipinjam(mhs3);
                                                break;
                                            case 2:
                                                buku2.dipinjam(mhs3);
                                                break;
                                            case 3:
                                                buku3.dipinjam(mhs3);
                                                break;
                                            case 4:
                                                buku4.dipinjam(mhs3);
                                                break;
                                            case 5:
                                                buku5.dipinjam(mhs3);
                                                break;
                                            default:
                                                break;
                                        }
                                        System.out.print("\napakah ingin meminjam buku yang lain(y/n) : ");
                                        pinjamLagi = input.next();
                                    } while (pinjamLagi.equals("Y") || pinjamLagi.equals("y"));
                                    break;
                                // kembalikan buku
                                case 2:
                                    System.out.println("\nbuku yang tersedia : ");
                                    System.out.print("1-"); buku1.display();
                                    System.out.print("2-"); buku2.display();
                                    System.out.print("3-"); buku3.display();
                                    System.out.print("4-"); buku4.display();
                                    System.out.print("5-"); buku5.display();

                                    String kembalikanBukuLain;
                                    do {
                                        System.out.print("\nkembalikan buku no: ");
                                        int kembalikan = input.nextInt();
                                        switch (kembalikan) {
                                            case 1:
                                                buku1.kembalikan(mhs3);
                                                break;
                                            case 2:
                                                buku2.kembalikan(mhs3);
                                                break;
                                            case 3:
                                                buku3.kembalikan(mhs3);
                                                break;
                                            case 4:
                                                buku4.kembalikan(mhs3);
                                                break;
                                            case 5:
                                                buku5.kembalikan(mhs3);
                                                break;
                                            default:
                                                break;
                                        }
                                        System.out.print("\napakah ingin mengembalikan buku yang lain(y/n) : ");
                                        kembalikanBukuLain = input.next();
                                    } while (kembalikanBukuLain.equals("Y") || kembalikanBukuLain.equals("y"));
                                    break;
                                // minta surat bebas perpus
                                case 3: 
                                    if(mhs3.melakukanPeminjaman()==mhs3.melakukanPengembalian()){
                                        System.out.println("mahasiswa tidak memiliki buku yang harus dikembalikan");
                                        System.out.println("mahasiswa bisa mendapat surat bebas perpustakaan");
                                    }else{
                                        System.out.println("mahasiswa masih memiliki buku yang belum dikembalikan");
                                        System.out.println("silahkan kembalikan buku terlebih dahulu");
                                    }
                                    break;
                                default:
                                    break;
                            }
                        } while (pilih == 1 || pilih == 2 || pilih == 3);
                    }else if(NPM.equals(mhs4.getNPM())){
                        String nama = mhs4.absensi();
                        dataAbsensi(nama);

                        int pilih;
                        do {
                            System.out.println("\npilih tindakan");
                            System.out.println("1. pinjam buku");
                            System.out.println("2. kembalikan buku");
                            System.out.println("3. minta surat bebas perpus");
                            System.out.println("4. kembali");
                            System.out.print("pilih : ");
                            pilih = input.nextInt();
                            switch (pilih) {
                                // pinjam buku
                                case 1:
                                    System.out.println("\nbuku yang tersedia : ");
                                    System.out.print("1-"); buku1.display();
                                    System.out.print("2-"); buku2.display();
                                    System.out.print("3-"); buku3.display();
                                    System.out.print("4-"); buku4.display();
                                    System.out.print("5-"); buku5.display();
    
                                    String pinjamLagi;
                                    do {
                                        System.out.print("\npinjam buku no: ");
                                        int pinjam = input.nextInt();
                                        switch (pinjam) {
                                            case 1:
                                                buku1.dipinjam(mhs4);
                                                break;
                                            case 2:
                                                buku2.dipinjam(mhs4);
                                                break;
                                            case 3:
                                                buku3.dipinjam(mhs4);
                                                break;
                                            case 4:
                                                buku4.dipinjam(mhs4);
                                                break;
                                            case 5:
                                                buku5.dipinjam(mhs4);
                                                break;
                                            default:
                                                break;
                                        }
                                        System.out.print("\napakah ingin meminjam buku yang lain(y/n) : ");
                                        pinjamLagi = input.next();
                                    } while (pinjamLagi.equals("Y") || pinjamLagi.equals("y"));
                                    break;
                                // kembalikan buku
                                case 2:
                                    System.out.println("\nbuku yang tersedia : ");
                                    System.out.print("1-"); buku1.display();
                                    System.out.print("2-"); buku2.display();
                                    System.out.print("3-"); buku3.display();
                                    System.out.print("4-"); buku4.display();
                                    System.out.print("5-"); buku5.display();

                                    String kembalikanBukuLain;
                                    do {
                                        System.out.print("\nkembalikan buku no: ");
                                        int kembalikan = input.nextInt();
                                        switch (kembalikan) {
                                            case 1:
                                                buku1.kembalikan(mhs4);
                                                break;
                                            case 2:
                                                buku2.kembalikan(mhs4);
                                                break;
                                            case 3:
                                                buku3.kembalikan(mhs4);
                                                break;
                                            case 4:
                                                buku4.kembalikan(mhs4);
                                                break;
                                            case 5:
                                                buku5.kembalikan(mhs4);
                                                break;
                                            default:
                                                break;
                                        }
                                        System.out.print("\napakah ingin mengembalikan buku yang lain(y/n) : ");
                                        kembalikanBukuLain = input.next();
                                    } while (kembalikanBukuLain.equals("Y") || kembalikanBukuLain.equals("y"));
                                    break;
                                // minta surat bebas perpus
                                case 3: 
                                    if(mhs4.melakukanPeminjaman()==mhs4.melakukanPengembalian()){
                                        System.out.println("mahasiswa tidak memiliki buku yang harus dikembalikan");
                                        System.out.println("mahasiswa bisa mendapat surat bebas perpustakaan");
                                    }else{
                                        System.out.println("mahasiswa masih memiliki buku yang belum dikembalikan");
                                        System.out.println("silahkan kembalikan buku terlebih dahulu");
                                    }
                                    break;
                                default:
                                    break;
                            }
                        } while (pilih == 1 || pilih == 2 || pilih == 3);
                    }else if(NPM.equals(mhs5.getNPM())){
                        String nama = mhs5.absensi();
                        dataAbsensi(nama);

                        int pilih;
                        do {
                            System.out.println("\npilih tindakan");
                            System.out.println("1. pinjam buku");
                            System.out.println("2. kembalikan buku");
                            System.out.println("3. minta surat bebas perpus");
                            System.out.println("4. kembali");
                            System.out.print("pilih : ");
                            pilih = input.nextInt();
                            switch (pilih) {
                                // pinjam buku
                                case 1:
                                    System.out.println("\nbuku yang tersedia : ");
                                    System.out.print("1-"); buku1.display();
                                    System.out.print("2-"); buku2.display();
                                    System.out.print("3-"); buku3.display();
                                    System.out.print("4-"); buku4.display();
                                    System.out.print("5-"); buku5.display();
    
                                    String pinjamLagi;
                                    do {
                                        System.out.print("\npinjam buku no: ");
                                        int pinjam = input.nextInt();
                                        switch (pinjam) {
                                            case 1:
                                                buku1.dipinjam(mhs5);
                                                break;
                                            case 2:
                                                buku2.dipinjam(mhs5);
                                                break;
                                            case 3:
                                                buku3.dipinjam(mhs5);
                                                break;
                                            case 4:
                                                buku4.dipinjam(mhs5);
                                                break;
                                            case 5:
                                                buku5.dipinjam(mhs5);
                                                break;
                                            default:
                                                break;
                                        }
                                        System.out.print("\napakah ingin meminjam buku yang lain(y/n) : ");
                                        pinjamLagi = input.next();
                                    } while (pinjamLagi.equals("Y") || pinjamLagi.equals("y"));
                                    break;
                                // kembalikan buku
                                case 2:
                                    System.out.println("\nbuku yang tersedia : ");
                                    System.out.print("1-"); buku1.display();
                                    System.out.print("2-"); buku2.display();
                                    System.out.print("3-"); buku3.display();
                                    System.out.print("4-"); buku4.display();
                                    System.out.print("5-"); buku5.display();

                                    String kembalikanBukuLain;
                                    do {
                                        System.out.print("\nkembalikan buku no: ");
                                        int kembalikan = input.nextInt();
                                        switch (kembalikan) {
                                            case 1:
                                                buku1.kembalikan(mhs5);
                                                break;
                                            case 2:
                                                buku2.kembalikan(mhs5);
                                                break;
                                            case 3:
                                                buku3.kembalikan(mhs5);
                                                break;
                                            case 4:
                                                buku4.kembalikan(mhs5);
                                                break;
                                            case 5:
                                                buku5.kembalikan(mhs5);
                                                break;
                                            default:
                                                break;
                                        }
                                        System.out.print("\napakah ingin mengembalikan buku yang lain(y/n) : ");
                                        kembalikanBukuLain = input.next();
                                    } while (kembalikanBukuLain.equals("Y") || kembalikanBukuLain.equals("y"));
                                    break;
                                // minta surat bebas perpus
                                case 3: 
                                    if(mhs5.melakukanPeminjaman()==mhs5.melakukanPengembalian()){
                                        System.out.println("mahasiswa tidak memiliki buku yang harus dikembalikan");
                                        System.out.println("mahasiswa bisa mendapat surat bebas perpustakaan");
                                    }else{
                                        System.out.println("mahasiswa masih memiliki buku yang belum dikembalikan");
                                        System.out.println("silahkan kembalikan buku terlebih dahulu");
                                    }
                                    break;
                                default:
                                    break;
                            }
                        } while (pilih == 1 || pilih == 2 || pilih == 3);
                    }else{
                        System.out.println("mahasiswa belum terdaftar");
                    }
                    break;
                case 2 :
                    display();
                    break;
                default:
            }
        } while (pilihan == 1 || pilihan == 2);

    }

    // deklarasi variabel data absensi
    static String absensi[] = new String[100];
    static int i = 0;

    // simpan data absensi
    static void dataAbsensi(String nama){
        Date date = new Date();
        SimpleDateFormat simpleDate = new SimpleDateFormat(" dd-MM-yyyy hh:mm ");
        String dateNow = simpleDate.format(date);
        absensi[i] = "-" + dateNow + "-" + nama ;
        i++;
    }

    // tampilkan data absensi
    static void display(){
        System.out.println("\nData Absensi Perpustakaan : ");
        for(int j = 0; j < i; j++){
            System.out.println(j+1 + absensi[j]);
        }
    }
}