package fi.haagahelia.hellostudents.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import fi.haagahelia.hellostudents.domain.Student;

@Controller
public class StudentController {

    @GetMapping("/hello")
    public String helloStudents(Model model) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Maab", "Osman"));
        students.add(new Student("Mark", "Smith"));
        students.add(new Student("Anna", "Brown"));

        model.addAttribute("message", "Welcome to Haaga-Helia!");
        model.addAttribute("students", students);

        return "studentlist";
    }}