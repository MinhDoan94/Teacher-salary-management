package entity;


import java.util.InputMismatchException;
import java.util.Scanner;

public class Teacher extends Person implements Inputable {
    private static final String GS = "GS-TS";
    private static final String PGS = "PGS-TS";
    private static final String GVC = "Giáo viên chính";
    private static final String TS = "Thạc sĩ";


    private static int idnumber = 100;
    private int id;
    private String level;

    private static Scanner scanner = new Scanner(System.in);

    public Teacher(int id, String level) {
        this.id = id;
        this.level = level;
    }

    public Teacher(String name, String address, String phone, int id, String level) {
        super(name, address, phone);
        this.id = id;
        this.level = level;
    }

    public Teacher() {

    }

    public static int getIdnumber() {
        return idnumber;
    }

    public static void setIdnumber(int idnumber) {
        Teacher.idnumber = idnumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public static Scanner getScanner() {
        return scanner;
    }

    public static void setScanner(Scanner scanner) {
        Teacher.scanner = scanner;
    }

    @Override
    public void inputInfomation() {
        this.id = Teacher.idnumber++;

        System.out.println("Nhập họ tên :");
        super.setName(scanner.nextLine());

        System.out.println("Nhập địa chỉ : ");
        super.setAddress(scanner.nextLine());

        System.out.println("Nhâp số điện thoại :");
        super.setPhone(scanner.nextLine());

        System.out.println("Nhập trình độ: ");
        levelLecturers();
    }

    @Override
    public String toString() {
        return "Lecturers{" +
                "id=" + id +
                super.toString() +
                ", level='" + level + '\'' +
                '}';
    }

    public void levelLecturers() {
        int nhap = 0;
        boolean cont = false;
        do {
            System.out.println("1. GS-TS");
            System.out.println("2. PGS-TS");
            System.out.println("3. Giáo viên chính");
            System.out.println("4. Thạc sĩ");
            try {
                Scanner scanner = new Scanner(System.in);
                nhap = scanner.nextInt();
                if (nhap >= 1 && nhap <= 4) {
                    cont = true;
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Mời bạn nhập lại: ");
            }
            System.out.println("Mời bạn nhập lại: ");
        } while (cont = true);
        switch (nhap) {
            case 1:
                this.level = Teacher.GS;
                break;
            case 2:
                this.level = Teacher.PGS;
                break;
            case 3:
                this.level = Teacher.GVC;
                break;
            case 4:
                this.level = Teacher.TS;
                break;
        }
    }
}
