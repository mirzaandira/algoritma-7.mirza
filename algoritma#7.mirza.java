import java.util.Scanner;

public class QueueExample {
    private static final int MAX_SIZE = 10; // maksimal jumlah elemen dalam antrian
    private static String[] queue1 = new String[MAX_SIZE]; // antrian jalur 1
    private static String[] queue2 = new String[MAX_SIZE]; // antrian jalur 2
    private static int front1 = -1, rear1 = -1; // indeks front dan rear untuk antrian 1
    private static int front2 = -1, rear2 = -1; // indeks front dan rear untuk antrian 2

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Menu:");
            System.out.println("1. Tambah Data Antrian");
            System.out.println("2. Hapus Antrian Elemen Pertama");
            System.out.println("3. Hapus Antrian di Posisi Tertentu");
            System.out.println("4. Hapus Semua Elemen");
            System.out.println("5. Tampilkan Data");
            System.out.println("0. Keluar");
            System.out.print("Masukkan pilihan: ");
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    enqueue(input);
                    break;
                case 2:
                    dequeue();
                    break;
                case 3:
                    delete(input);
                    break;
                case 4:
                    clear();
                    break;
                case 5:
                    display();
                    break;
                case 0:
                    System.out.println("Terima kasih!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid, silahkan coba lagi!");
                    break;
            }
        } while (choice != 0);
    }

    // method untuk menambahkan elemen ke antrian
    private static void enqueue(Scanner input) {
        System.out.print("Masukkan nama: ");
        String name = input.next();

        System.out.print("Masukkan nomor antrian (1 atau 2): ");
        int queueNumber = input.nextInt();

        if (queueNumber == 1) {
            if (rear1 == MAX_SIZE - 1) {
                System.out.println("Antrian 1 penuh!");
            } else {
                if (front1 == -1) {
                    front1 = 0;
                }
                rear1++;
                queue1[rear1] = name;
                System.out.println("Data berhasil ditambahkan ke antrian 1");
            }
        } else if (queueNumber == 2) {
            if (rear2 == MAX_SIZE - 1) {
                System.out.println("Antrian 2 penuh!");
            } else {
                if (front2 == -1) {
                    front2 = 0;
                }
                rear2++;
                queue2[rear2] = name;
                System.out.println("Data berhasil ditambahkan ke antrian 2");
            }
        } else {
            System.out.println("Nomor antrian tidak valid!");
        }
    }

    // method untuk menghapus elemen pertama dari antrian
    private static void dequeue() {
        if (front1 == -1 && front2 == -1)
