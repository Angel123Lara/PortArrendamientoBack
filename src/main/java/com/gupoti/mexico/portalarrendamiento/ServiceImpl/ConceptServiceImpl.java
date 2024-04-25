package com.gupoti.mexico.portalarrendamiento.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gupoti.mexico.portalarrendamiento.Dto.Catalogos.ConceptDTO;
import com.gupoti.mexico.portalarrendamiento.Dto.Catalogos.ConceptRequestDTO;
import com.gupoti.mexico.portalarrendamiento.Model.Catalogos.ConceptModel;
import com.gupoti.mexico.portalarrendamiento.Repositories.Catalogos.ConceptRepository;
import com.gupoti.mexico.portalarrendamiento.Service.Catalogos.ConceptService;

@Service
public class ConceptServiceImpl implements ConceptService {

    @Autowired

   public ConceptRepository repository;

    public ConceptDTO save(ConceptRequestDTO data){
       
        ConceptModel entity = new ConceptModel();
        entity.setPortal_concept(data.getPortal_concept());
        entity.setEBS_concept(data.getEBS_concept());
        // entity.setEnable(true);
        ConceptModel responseDB = repository.save(entity);

        ConceptDTO conceptDTO = new ConceptDTO();
        conceptDTO.setId(responseDB.getId());
        conceptDTO.setPortal_concept(responseDB.getPortal_concept());
        conceptDTO.setEBS_concept(responseDB.getEBS_concept());
        // conceptDTO.setEnable(responseDB);
        
        return conceptDTO;

    };

 
    
}
