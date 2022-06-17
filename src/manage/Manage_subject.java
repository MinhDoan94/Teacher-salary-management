package manage;

import MainRun.Mainrun;
import entity.Teacher;

import entity.Subject;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Manage_subject {
    public static void inputNumber() {
        System.out.println("Nhập số môn học:");
        int s = 0;
        try {
            s = new Scanner(System.in).nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Mời nhập lại: ");
        }
        for (int i = 0; i < s; i++) {
            Subject subject = new Subject();
            subject.inputInfomation();
            saveSubject(subject);
            System.out.println(subject);
        }
    }

    public static void saveSubject(Subject subject) {
        for (int i = 0; i < Mainrun.subjects.length; i++) {
            if (Mainrun.subjects[i] == null) {
                Mainrun.subjects[i] = subject;
                return;
            }
        }
    }

    public static void showList() {
        for (int i = 0; i < Mainrun.subjects.length; i++) {
            if (Mainrun.subjects[i] == null) {
                continue;
            }
            System.out.println(Mainrun.subjects[i].toString());
        }
    }

    public static Subject findSubject(int id) {
        Subject subject = null;
        for (int i = 0; i < Mainrun.subjects.length; i++) {
            if (Mainrun.subjects[i] != null && Mainrun.subjects[i].getId() == id) {
                subject = Mainrun.subjects[i];
                return subject;
            }
        }
        return null;
    }
}