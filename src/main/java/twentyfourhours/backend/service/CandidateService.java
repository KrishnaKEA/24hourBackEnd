package twentyfourhours.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import twentyfourhours.backend.dtos.CandidateDTO;
import twentyfourhours.backend.entity.Candidate;
import twentyfourhours.backend.entity.Party;
import twentyfourhours.backend.repo.CandidateRepository;
import twentyfourhours.backend.repo.PartyRepository;

import java.util.List;

@Service
public class CandidateService {
    @Autowired
    CandidateRepository candidateRepository;
    @Autowired
    PartyRepository partyRepository;

    public List<CandidateDTO> getAllCandidates() {
        return CandidateDTO.candidatesToCandidateDTOS(candidateRepository.findAll());
    }
    public List<CandidateDTO> getCandidatesByPartyName(String partyName){
        return CandidateDTO.candidatesToCandidateDTOS(candidateRepository.getCandidateByPartyName(partyName));
    }
    public CandidateDTO addCandidate(CandidateDTO candidateDTO){
        Candidate c = CandidateDTO.candidateFromCanditateDTO(candidateDTO);
        Party p = partyRepository.findPartyByName(candidateDTO.getPartyname());
        c.setParty(p);
        candidateRepository.save(c);
        CandidateDTO cDTO = new CandidateDTO(c);
        cDTO.setPartyname(candidateDTO.getPartyname());
        return cDTO;
    }

    public CandidateDTO editCandidate(CandidateDTO candidateToEdit, long id){
        Candidate candidateBeforeEdit = candidateRepository.getById(id);
        candidateBeforeEdit.setParty(partyRepository.findPartyByName(candidateToEdit.getPartyname()));
        candidateBeforeEdit.setName(candidateToEdit.getName());
        candidateBeforeEdit.setPosition(candidateToEdit.getPosition());
        CandidateDTO cd = new CandidateDTO(candidateRepository.save(candidateBeforeEdit));
        cd.setPartyname(candidateToEdit.getPartyname());
       return cd;
    }
    public void removeCandidate(long id){
        candidateRepository.deleteById(id);
    }

}
