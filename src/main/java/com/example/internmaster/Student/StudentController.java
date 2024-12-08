package com.example.internmaster.Student;

import com.example.internmaster.Application.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(path = "api/student/{studentId}")
    public ResponseEntity<StudentModel> getById(@PathVariable("studentId") Long studentId) {
        return studentService.getStudentById(studentId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping(path = "api/offercandidates/{offerId}")
    public ResponseEntity<List<StudentModel>> getOfferCandidates(@PathVariable("offerId") Long offerId) {
        List<StudentModel> students = studentService.getOffersCandidates(offerId);
        return ResponseEntity.ok(students);
    }

    @PostMapping("api/addstudent")
    public ResponseEntity<String> addStudent(@RequestBody StudentModel studentModel){
        studentService.addStudent(studentModel);
        return ResponseEntity.ok("Student "+studentModel.getId()+" added successfully");
    }

    @PutMapping("api/putstudent/{id}")
    public ResponseEntity<String> updateStudent(@PathVariable("id") long id, @RequestBody StudentModel studentModel){
        try{
            studentService.updateStudent(id, studentModel);
            return ResponseEntity.ok("Student " + id + " updated successfully");
        }catch(IllegalArgumentException e){return ResponseEntity.notFound().build();}
    }

    @DeleteMapping("api/deletestudent/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") long id){
        try{
            studentService.deleteStudent(id);
            return ResponseEntity.ok("Student " + id + " deleted successfully");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

}
