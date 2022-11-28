package rest.service;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;
import rest.dto.StudentDto;
import rest.persistence.entity.Student;
import rest.persistence.repository.StudentRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository userRepository) {
        this.studentRepository = userRepository;
    }

    public List<StudentDto> createStudent(StudentDto studentDto) {
        Student student = new Student();
        student.setId(UUID.randomUUID());
        student.setNumber(studentDto.getNumber());
        student.setName(studentDto.getName());
        student.setBirthDate(studentDto.getBirthDate());

        studentRepository.save(student);

        return getAllStudents();
    }

    public List<StudentDto> getAllStudents() {
        List<Student> students = studentRepository.findAllStudents();
        List<StudentDto> resultList = new ArrayList<>();
        for (Student student : students) {
            StudentDto studentDto = new StudentDto();
            studentDto.setId(student.getId().toString());
            studentDto.setNumber(student.getNumber());
            studentDto.setName(student.getName());
            studentDto.setBirthDate(student.getBirthDate());
            resultList.add(studentDto);
        }

        return resultList;
    }

    public void removeStudentById(UUID id) {
        studentRepository.deleteById(id);
    }
}
