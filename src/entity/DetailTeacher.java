package entity;

import entity.Teacher;
import entity.Subject;
import MainRun.Mainrun;

import java.util.Arrays;

public class DetailTeacher {
    private Teacher teacher;
    private DetailSubject[] detailSubjects;

    public DetailTeacher(Teacher teacher, DetailSubject[] detailSubjects) {
        this.teacher = teacher;
        this.detailSubjects = detailSubjects;
    }

    public DetailTeacher() {

    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public DetailSubject[] getDetailSubjects() {
        return detailSubjects;
    }

    public void setDetailSubjects(DetailSubject[] detailSubjects) {
        this.detailSubjects = detailSubjects;
    }

    @Override
    public String toString() {
        return "DetailTeacher{" +
                "Teacher=" + teacher +
                ", detailSubjects=" + Arrays.toString(detailSubjects) +
                '}';
    }
}
