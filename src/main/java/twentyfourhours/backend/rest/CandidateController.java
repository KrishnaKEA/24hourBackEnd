package twentyfourhours.backend.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import twentyfourhours.backend.dtos.CandidateDTO;
import twentyfourhours.backend.entity.Candidate;
import twentyfourhours.backend.entity.Party;
import twentyfourhours.backend.service.CandidateService;
import twentyfourhours.backend.service.PartyService;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class CandidateController {
    @Autowired
    CandidateService candidateService;
    @Autowired
    PartyService partyService;

    @GetMapping("/candidates")
    public List<CandidateDTO> getAllCandidates(){
        return candidateService.getAllCandidates();
    }
    @GetMapping("/candidates/{partyName}")
    public List<CandidateDTO> getCandidateByPartyName(@PathVariable String partyName){
        return candidateService.getCandidatesByPartyName(partyName);
    }
    @PostMapping("/candidates")
    public CandidateDTO createCandidate(@RequestBody CandidateDTO candidateDTO){
        return candidateService.addCandidate(candidateDTO);
    }

    @PutMapping("/candidates/{id}")
    public CandidateDTO editCandidate(@RequestBody CandidateDTO candidateDTO,@PathVariable long id ) throws Exception {
        return candidateService.editCandidate(candidateDTO,id);
    }

    @DeleteMapping("/candidates/{id}")
    void deleteCandidate(@PathVariable int id){
        candidateService.removeCandidate(id);

    }
}
