package twentyfourhours.backend.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import twentyfourhours.backend.entity.Candidate;
import twentyfourhours.backend.service.CandidateService;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/")
public class HomeController {
    @Autowired
    CandidateService candidateService;

    @GetMapping("students")
    public List<Candidate> getStudentList(){
        return candidateService.getAllStudent();
    }
    @PostMapping("students")
    public Candidate addStudent(@RequestBody Candidate candidate){
        return candidateService.addStudent(candidate);
    }
}
