package uz.pdp.online.pdp_online_module_4.student;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {


    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @PostMapping
    public Student save(@RequestBody Student student) {
        return studentRepository.save(student);
    }

    @PutMapping
    public boolean update(@RequestBody Student student) {
        return studentRepository.update(student);
    }

    @GetMapping
    public Student findById(@RequestParam String id) {
        return studentRepository.findById(id);
    }

    @GetMapping("/name")
    public Student findByName(@RequestParam String name) {
        return studentRepository.findByName(name);
    }

    @GetMapping("/age")
    public List<Student> findByAge(@RequestParam int age) {
        return studentRepository.findByAge(age);
    }

    @GetMapping("/group")
    public List<Student> searchByGroupId(@RequestParam String groupId) {
        return studentRepository.searchByGroupId(groupId);
    }

    @DeleteMapping
    public void delete(@RequestParam String id) {
        studentRepository.delete(id);
    }
}
