package twentyfourhours.backend.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import twentyfourhours.backend.dtos.PartyDTO;
import twentyfourhours.backend.entity.Party;
import twentyfourhours.backend.service.CandidateService;
import twentyfourhours.backend.service.PartyService;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/parties")
public class PartyController {
    @Autowired
    PartyService partyService;
    @Autowired
    CandidateService candidateService;
    @GetMapping()
    public List<PartyDTO> getAllParties(){
        return partyService.getAllParty();
    }

}
