package com.example.internmaster.Student;

import com.example.internmaster.Application.ApplicationModel;
import com.example.internmaster.Application.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


//Business logic for the students

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    //added dependency to use the find by offer function to find all students that applied to an offer
    private final ApplicationRepository applicationRepository;
    @Autowired
    public StudentService(StudentRepository studentRepository, ApplicationRepository applicationRepository){this.studentRepository=studentRepository; this.applicationRepository=applicationRepository;}

    //adding one student
    public void addStudent(StudentModel studentModel){
        studentRepository.save(studentModel);
    }

    //Fetching ell studs
    public List<StudentModel> getAllStudents(){
        return studentRepository.findAll();
    }

    //fetch by id
    public Optional<StudentModel> getStudentById(long id){
        return studentRepository.findById(id);
    }

    //remove a student by his id
    public void deleteStudent(long id){
        if (studentRepository.existsById(id)) {
            studentRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Student with ID " + id + " does not exist.");
        }
    }

    //update a student
    public void updateStudent(long id, StudentModel newStudent){
        Optional<StudentModel> oldStudent=this.getStudentById(id);
        if(oldStudent.isPresent()){
            StudentModel student = oldStudent.get();
            student.setFirstName(newStudent.getFirstName());
            student.setLastName(newStudent.getLastName());
            student.setEmail(newStudent.getEmail());
            student.setPhoneNumber(newStudent.getPhoneNumber());
            student.setSpecialty(newStudent.getSpecialty());
            student.setProfilePicture(newStudent.getProfilePicture());
            student.setSchool(newStudent.getSchool());
            student.setPassword(newStudent.getPassword());
            studentRepository.save(student);
        }else{throw new IllegalArgumentException("Student with ID " + id + " does not exist.");}
    }

    public List<StudentModel> getOffersCandidates(long ofId){
        List<ApplicationModel> applications = applicationRepository.findByOffer_id(ofId);
        return applications.stream()
                .map(ApplicationModel::getStudent) // Extract the student from each application
                .distinct() // Ensure no duplicate students are returned
                .collect(Collectors.toList());
    }




}
