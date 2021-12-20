package twentyfourhours.backend.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import twentyfourhours.backend.entity.Candidate;
import twentyfourhours.backend.entity.Party;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class PartyDTO {
    private long id;
    private String name;

    public PartyDTO(String name) {
        this.name = name;
    }
    public PartyDTO(Party party){
        this.name = party.getName();
        this.id = party.getId();
    }

    public static List<PartyDTO> partyToPartyDTOs(Iterable<Party> parties){
        List<PartyDTO> partYDTOList = new ArrayList<>();
        for(Party party:parties){
            PartyDTO pDTO = new PartyDTO(party);
            partYDTOList.add(pDTO);
        }
        return partYDTOList;
    }


    public static Party partyFromPartyDTO(PartyDTO partyDTO){
        return new Party(partyDTO.getName());
    }
}
