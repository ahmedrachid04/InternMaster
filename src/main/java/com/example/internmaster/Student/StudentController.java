package com.example.internmaster.Student;

import com.example.internmaster.Application.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {

    @Autowired
    private final StudentService studentService;
    @Autowired
    private final ApplicationService applicationService;

    public StudentController(StudentService studentService, ApplicationService applicationService){this.studentService=studentService; this.applicationService=applicationService;}

    @GetMapping(path = "api/students")
    public List<StudentModel> getStudents(){return studentService.getAllStudents();}

    @GetMapping(path = "student/{studentId}")
    public ResponseEntity<StudentModel> getById(@PathVariable("studentId") Long studentId){
        Optional<StudentModel> student=studentService.getStudentById(studentId);
        return ResponseEntity.ok(student.get());
    }

    @GetMapping(path = "/offercandidates/{offerId}")
    public ResponseEntity<List<StudentModel>> getOfferCandidates(@PathVariable("offerId") Long offerId) {
        List<StudentModel> students = studentService.getOffersCandidates(offerId);
        return ResponseEntity.ok(students);
    }

}
