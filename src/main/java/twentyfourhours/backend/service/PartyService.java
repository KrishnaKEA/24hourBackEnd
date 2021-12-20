package twentyfourhours.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import twentyfourhours.backend.dtos.PartyDTO;
import twentyfourhours.backend.entity.Party;
import twentyfourhours.backend.repo.PartyRepository;

import java.util.List;

@Service
public class PartyService {
    @Autowired
    PartyRepository partyRepository;
    public List<PartyDTO> getAllParty(){
        return PartyDTO.partyToPartyDTOs(partyRepository.findAll());
    }
    public Party findPartyByName(String partyName){
        return partyRepository.findPartyByName(partyName);
    }

}
