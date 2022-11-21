package rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import rest.service.HtmlPageService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Класс в котором описываются http методы (АПИ), методы вызываются с фронта
 * **/
@RestController
public class Controller {

    @Autowired
    private HtmlPageService htmlPageService;

    /**
     * Пример метода который будет вызываться по URL: http://localhost:8080
     * метод возвращает html страницу, "resources/templates/welcome.html"
     * **/
    @GetMapping(value = "/")
    public ModelAndView welcome() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("welcome"); // указываю какую страницу вернуть
        modelAndView.getModel().put("message", "ПРИВЕТ"); // иньекция значений на страницу
        return modelAndView;
    }

    /**
     * Пример метода который будет вызываться по URL: http://localhost:8080/select/{имя_таблицы_в_которой_хотите_посмотреть_данные}
     * метод возвращает html страницу, "resources/templates/show_table.html"
     * **/
    @GetMapping(value = "/all-students")
    public ModelAndView showStudents() {
        return htmlPageService.createStudentPage();
    }

    @GetMapping(value = "/add-student")
    public ModelAndView newStudent() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("new-student"); // указываю какую страницу вернуть
        return modelAndView;    }

    @PostMapping(value = "/add-student")
    public void addStudent(HttpServletResponse response) throws IOException {
        response.sendRedirect("/all-students");
    }
}