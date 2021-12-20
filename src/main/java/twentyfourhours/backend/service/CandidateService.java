package twentyfourhours.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import twentyfourhours.backend.dtos.CandidateDTO;
import twentyfourhours.backend.repo.CandidateRepository;

import java.util.List;

@Service
public class CandidateService {
    @Autowired
    CandidateRepository candidateRepository;

    public List<CandidateDTO> getAllCandidates() {
        return CandidateDTO.candidatesToCandidateDTOS(candidateRepository.findAll());
    }
    public List<CandidateDTO> getCandidatesByPartyName(String partyName){
        return CandidateDTO.candidatesToCandidateDTOS(candidateRepository.getCandidateByPartyName(partyName));
    }

}
