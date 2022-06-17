package manage;

import entity.DetailTeacher;
import entity.DetailSubject;
import entity.Teacher;
import entity.Subject;
import MainRun.Mainrun;

import java.util.Scanner;

public class Manage_declaration {
    public static void registerTeach() {
        int inputNumberTeacher = 0;
        try {
            System.out.println("Số lượng giáo viên muốn nhập: ");
            inputNumberTeacher = new Scanner(System.in).nextInt();
        } catch (Exception e) {
            System.out.println("Mời bạn nhập lại:");
        }
        ;

        for (int i = 0; i < inputNumberTeacher; i++) {
            boolean cont = false;
            do {
                Teacher teacher = inputIdTeacher(i);
                DetailSubject[] detailSubjects = inputDetailSubjects();
                DetailTeacher detailTeacher = new DetailTeacher(teacher, detailSubjects);
                saveDeTailTeacher(detailTeacher);
                if (totalLesson(detailTeacher) > 200) {
                    System.out.println("Sô tiết vượt qua 200 tiết. ");
                    System.out.println("Mời nhập lại: ");
                } else {
                    saveDeTailTeacher(detailTeacher);
                    cont = true;
                    break;
                }
            } while (cont);
        }
    }

    public static Teacher inputIdTeacher(int id) {
        Teacher teacher = null;
        do {
            try {
                System.out.println("Mời nhập mã giảng viên viên: ");
                int idTeacher = new Scanner(System.in).nextInt();
                if (Manage_teachers.findTeacher(idTeacher) != null) {
                    teacher = Manage_teachers.findTeacher(idTeacher);
                    System.out.println(teacher);
                    break;
                }
            } catch (Exception e) {
                System.out.println("Mời nhập lại: ");
            }
        } while (true);
        return teacher;
    }

    public static DetailSubject[] inputDetailSubjects() {
        System.out.println("Nhập số môn muốn dậy: ");
        int numberSubject = new Scanner(System.in).nextInt();
        DetailSubject[] detailSubjects = new DetailSubject[numberSubject];

        for (int i = 0; i < numberSubject; i++) {
            Subject subject = null;
            boolean count = false;
            do {
                try {
                    System.out.println("Mời nhập mã môn học: ");
                    int idSubject = new Scanner(System.in).nextInt();
                    for (int j = 0; j < Mainrun.subjects.length; j++) {
                        if (Mainrun.subjects[i] != null && Mainrun.subjects[i].getId() == idSubject) {
                            subject = Mainrun.subjects[i];
                            System.out.println(subject);
                            break;
                        }
                    }
                } catch (Exception e) {
                    System.out.println("Mời nhập lại: ");
                }
            } while (count);
            boolean cont = false;
            int numberClass = 0;
            do {
                try {
                    System.out.println("Mời nhập số lớp:");
                    numberClass = new Scanner(System.in).nextInt();
                    if (numberClass > 0 && numberClass < 4) {
                        cont = true;
                        break;
                    }
                    System.out.print("Mời nhập lại: ");
                } catch (Exception e) {
                    System.out.println(e);
                }
            } while (cont);
            DetailSubject detailSubject = new DetailSubject(subject, numberClass);
            for (int j = 0; j < detailSubjects.length; j++) {
                if (detailSubjects[j] == null) {
                    detailSubjects[j] = detailSubject;
                    break;
                }
            }
        }
        return detailSubjects;
    }

    public static void saveDeTailTeacher(DetailTeacher detailTeacher) {
        for (int j = 0; j < Mainrun.detailTeachers.length; j++) {
            if (Mainrun.detailTeachers[j] == null) {
                Mainrun.detailTeachers[j] = detailTeacher;
                break;
            }
        }
    }

    public static void showList() {
        for (int i = 0; i < Mainrun.detailTeachers.length; i++) {
            if (Mainrun.detailTeachers[i] != null) {
                System.out.println(Mainrun.detailTeachers[i]);
            }
        }
    }

    public static int totalLesson(DetailTeacher detailTeacher) {
        int sum = 0;
        for (int i = 0; i < detailTeacher.getDetailSubjects().length; ++i) {
            if (detailTeacher.getDetailSubjects() != null) {
                int subject = detailTeacher.getDetailSubjects()[i].getSubject().getTotalLessons();
                int quantity = detailTeacher.getDetailSubjects()[i].getNumberClass();
                sum += subject * quantity;
                System.out.println("Tổng tiết:" + sum);
            }
        }
        return sum;
    }

    public static void xapXep() {
        int nhap = 0;
        do {
            try {
                System.out.println("Sắp xếp danh sách kê khai giảng dạy: ");
                System.out.println("1. Sắp xếp Sắp xếp danh sách kê khai giảng dạy. ");
                System.out.println("2. Sắp xếp Theo số tiết giảng dạy mỗi môn (giảm dần). ");
                nhap = new Scanner(System.in).nextInt();
                if (nhap == 1 || nhap == 2) {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Mời nhập lại: ");
            }
        } while (true);
        if (nhap == 1) {
            for (int i = 0; i < Mainrun.detailTeachers.length - 1; i++) {
                if (Mainrun.detailTeachers[i] == null) {
                    continue;
                }
                for (int j = i + 1; j < Mainrun.teachers.length; j++) {
                    if (Mainrun.teachers[j] == null) {
                        continue;
                    }
                    if (Mainrun.detailTeachers[i].getTeacher().getName().compareTo(Mainrun.detailTeachers[j].getTeacher().getName()) > 0) {
                        DetailTeacher detailTeacher = Mainrun.detailTeachers[i];
                        Mainrun.detailTeachers[i] = Mainrun.detailTeachers[j];
                        Mainrun.detailTeachers[j] = detailTeacher;
                    }
                }
                showList();
                break;
            }
        } else if (nhap == 2) {
            int tem;
            for (int i = 0; i < Mainrun.detailTeachers.length; i++) {
                if (Mainrun.detailTeachers[i] == null) {
                    continue;
                }
                for (int j = i + 1; j < Mainrun.detailTeachers.length; j++) {
                    if (Mainrun.detailTeachers[j] == null) {
                        continue;
                    }
                    if (Mainrun.detailTeachers[i].getDetailSubjects()[i].getSubject().getTotalLessons() < Mainrun.detailTeachers[j].getDetailSubjects()[j].getSubject().getTotalLessons()) {
                        tem = Mainrun.detailTeachers[i].getDetailSubjects()[i].getSubject().getTotalLessons();
                        Mainrun.detailTeachers[i].getDetailSubjects()[i].getSubject().setTotalLessons(Mainrun.detailTeachers[j].getDetailSubjects()[j].getSubject().getTotalLessons());
                        Mainrun.detailTeachers[j].getDetailSubjects()[j].getSubject().setTotalLessons(tem);
                    }
                }
            }
            showList();
        }
    }
}
