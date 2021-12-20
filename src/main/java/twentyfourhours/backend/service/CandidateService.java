package twentyfourhours.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import twentyfourhours.backend.entity.Candidate;
import twentyfourhours.backend.repo.CandidateRepository;

import java.util.List;

@Service
public class CandidateService {
    @Autowired
    CandidateRepository candidateRepository;

    public List<Candidate> getAllStudent(){
        return candidateRepository.findAll();
    }
    public Candidate addStudent(Candidate candidate){
        return candidateRepository.save(candidate);
    }
}
