package com.src.jpa.sample;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.src.jpa.sample.entities.Student;
import com.src.jpa.sample.entities.Subject;
import com.src.jpa.sample.repositories.InstructorRepository;
import com.src.jpa.sample.repositories.StudentRepository;
import com.src.jpa.sample.repositories.StudentSubjectRepository;
import com.src.jpa.sample.repositories.SubjectRepository;

@SpringBootApplication
public class SampleApplication {

	@Autowired
	private InstructorRepository instructorRepo;

	@Autowired
	private StudentRepository studentRepo;

	@Autowired
	private SubjectRepository subjectRepo;

	@Autowired
	private StudentSubjectRepository studSubRepo;

	public static void main(String[] args) {
		SpringApplication.run(SampleApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo() {
		return (args) -> {
//			Student stud1 = new Student();
//
//			Address address = new Address();
//			address.setBarangay("");
//			address.setCity("");
//			address.setStreet("");
//			address.setZipCode("");
//			stud1.setAddress(address);
//
//			LocalDate birthdate = LocalDate.of(1999, Month.FEBRUARY, 1);
//			stud1.setBirthdate(birthdate);
//
//			stud1.setCourse("");
//			stud1.setDepartment("");
//			stud1.setEmail("");
//			stud1.setFirstname("");
//			stud1.setGender("");
//			stud1.setLastname("");
//			stud1.setLevel(4);
//			stud1.setMobileNumber("");
//
//			Subject sub1 = new Subject();
//			sub1.setDescription("");
//			sub1.setName("");
//			sub1.setUnit(3);
//
//			Subject sub2 = new Subject();
//			sub2.setDescription("");
//			sub2.setName("");
//			sub2.setUnit(5);
//
//			subjectRepo.saveAndFlush(sub1);
//			subjectRepo.saveAndFlush(sub2);
//
//			studentRepo.saveAndFlush(stud1);

//			Optional<Student> stud = studentRepo.findById(3L);
//			Optional<Subject> sub1 = subjectRepo.findById(1L);
//			Optional<Subject> sub2 = subjectRepo.findById(2L);
//
//			StudentSubject studSub1 = new StudentSubject();
//			studSub1.setStudent(stud.get());
//			studSub1.setSubject(sub1.get());
//
//			StudentSubject studSub2 = new StudentSubject();
//			studSub2.setStudent(stud.get());
//			studSub2.setSubject(sub2.get());
//
//			studSubRepo.saveAndFlush(studSub1);
//			studSubRepo.saveAndFlush(studSub2);

			Optional<Student> stud = studentRepo.findById(3L);
			System.out.println(stud.get().getFirstname());

			List<Subject> subjects = stud.get().getSubjects();
			for (Subject sub : subjects) {
				System.out.println(sub.getName() + " = " + sub.getDescription());
			}
		};
	}
}
