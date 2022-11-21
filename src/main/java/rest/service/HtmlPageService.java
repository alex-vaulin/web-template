package rest.service;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;
import rest.dto.StudentDto;

@Service
public class HtmlPageService {

    private final StudentService studentService;

    public HtmlPageService(StudentService studentService) {
        this.studentService = studentService;
    }

    public ModelAndView createStudentPage() {
        return studentService.getAllStudents();
    }

    public ModelAndView createStudent(StudentDto studentDto) {
        return studentService.createStudent(studentDto);
    }
}
