package rest.service;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;
import rest.dto.StudentDto;
import rest.persistence.entity.Student;
import rest.persistence.repository.StudentRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository userRepository) {
        this.studentRepository = userRepository;
    }

    public ModelAndView getAllStudents() {
        List<Student> students = studentRepository.findAllStudents();
        List<StudentDto> resultList = new ArrayList<>();
        for (Student student : students) {
            StudentDto studentDto = new StudentDto();
            studentDto.setId(student.getId());
            studentDto.setName(student.getName());
            studentDto.setBirthDate(student.getBirthDate());
            resultList.add(studentDto);
        }

        return createAndFillModel(resultList);
    }

    private ModelAndView createAndFillModel(List<StudentDto> studentDtos) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.getModel().put("listStudents", studentDtos);
        modelAndView.setViewName("studets-page");
        return modelAndView;
    }
}
