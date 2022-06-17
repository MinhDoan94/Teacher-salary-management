package manage;

import entity.Teacher;
import MainRun.Mainrun;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Manage_teachers {
    public static void inputNumber() {
        System.out.println("Nhập số giảng viên:");
        int s = 0;
        try {
            s = new Scanner(System.in).nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Xin mời nhập lại: ");
        }
        for (int i = 0; i < s; i++) {
            Teacher teachers = new Teacher();
            teachers.inputInfomation();
            saveTeachers(teachers);
            System.out.println(teachers);
        }
    }

    public static void saveTeachers(Teacher teachers) {
        for (int i = 0; i < Mainrun.teachers.length; i++) {
            if (Mainrun.teachers[i] == null) {
                Mainrun.teachers[i] = teachers;
                return;
            }
        }
    }

    public static void showList() {
        for (int i = 0; i < Mainrun.teachers.length; i++) {
            if (Mainrun.teachers[i] == null) {
                continue;
            }
            System.out.println(Mainrun.teachers[i]);
            System.out.println(Mainrun.detailTeachers[i]);
        }
    }

    public static Teacher findTeacher(int id) {
        Teacher teacher = null;
        for (int i = 0; i < Mainrun.teachers.length; i++) {
            if (Mainrun.teachers[i] != null && Mainrun.teachers[i].getId() == id) {
                teacher = Mainrun.teachers[i];
                return teacher;
            }
        }
        return null;
    }
}
