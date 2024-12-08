//package com.example.internmaster.Student;
//
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.Arrays;
//
//@Configuration
//public class StudentConfiguration {
//    @Bean
//    CommandLineRunner populateStudentTable(StudentRepository studentRepository) {
//        return args -> {
//            // Create sample students
//            StudentModel student1 = new StudentModel(
//                    "John",
//                    "Doe",
//                    "john.doe@example.com",
//                    "1234567890",
//                    "Computer Science",
//                    null,
//                    "Harvard University",
//                    "password123"
//            );
//
//            StudentModel student2 = new StudentModel(
//                    "Jane",
//                    "Smith",
//                    "jane.smith@example.com",
//                    "0987654321",
//                    "Information Technology",
//                    null,
//                    "MIT",
//                    "securepass"
//            );
//
//            // Save students to the database
//            studentRepository.saveAll(Arrays.asList(student1, student2));
//        };
//    }
//}
