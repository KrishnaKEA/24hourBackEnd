package twentyfourhours.backend.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import twentyfourhours.backend.dtos.CandidateDTO;
import twentyfourhours.backend.entity.Candidate;
import twentyfourhours.backend.service.CandidateService;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/")
public class CandidateController {
    @Autowired
    CandidateService candidateService;
    @GetMapping("candidates")
    public List<CandidateDTO> getAllCandidates(){
        return candidateService.getAllCandidates();
    }
    @GetMapping("candidates/{partyName}")
    public List<CandidateDTO> getCandidateByPartyName(@PathVariable String partyName){
        return candidateService.getCandidatesByPartyName(partyName);
    }


}
