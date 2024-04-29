package com.gupoti.mexico.portalarrendamiento.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;
import com.gupoti.mexico.portalarrendamiento.Dto.Catalogos.ConceptDTO;
import com.gupoti.mexico.portalarrendamiento.Dto.Catalogos.ConceptRequestDTO;
import com.gupoti.mexico.portalarrendamiento.Model.Catalogos.ConceptModel;
import com.gupoti.mexico.portalarrendamiento.Repositories.Catalogos.ConceptRepository;
import com.gupoti.mexico.portalarrendamiento.Service.Catalogos.ConceptService;
import java.util.stream.Collectors;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;




@Service
public class ConceptServiceImpl implements ConceptService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ConceptRepository repository;

    public ConceptDTO save(ConceptRequestDTO data){
       
        ConceptModel entity = new ConceptModel();
        entity.setPortal_concept(data.getPortal_concept());
        entity.setEBS_concept(data.getEBS_concept());
        entity.setEnabled(true);
        ConceptModel responseDB = repository.save(entity);

        ConceptDTO conceptDTO = new ConceptDTO();
        conceptDTO.setId(responseDB.getId());
        conceptDTO.setPortal_concept(responseDB.getPortal_concept());
        conceptDTO.setEBS_concept(responseDB.getEBS_concept());
        conceptDTO.setEnable(responseDB.getEnabled());
        
        return conceptDTO;

    };

  
    @Override
    public List<ConceptDTO> getConceptAll() {

        
        return repository.findAll().stream()
                .map(conceptModel -> modelMapper.map(conceptModel, ConceptDTO.class))
                     .collect(Collectors.toList());
    }

    

    @Override
    public ConceptDTO updateConcept(Long id, ConceptRequestDTO concepttDTO) {
       // Verifica si el registro que deseas actualizar existe en la base de datos
    Optional<ConceptModel> optionalEntity = repository.findById(id);
    
    if (optionalEntity.isPresent()) {
        ConceptModel existingEntity = optionalEntity.get();
        existingEntity.setPortal_concept(concepttDTO.getPortal_concept());
        existingEntity.setEBS_concept(concepttDTO.getEBS_concept());

         // Verifica si getEnabled() devuelve null y asigna un valor predeterminado en ese caso
         Boolean enabled = existingEntity.getEnabled() != null ? existingEntity.getEnabled() : Boolean.FALSE;
         existingEntity.setEnabled(enabled);
         
        
        // Guarda los cambios en la base de datos
        ConceptModel updatedEntity = repository.save(existingEntity);
        
        // Construye y retorna el DTO actualizado
        ConceptDTO updatedDTO = new ConceptDTO();
        updatedDTO.setId(updatedEntity.getId());
        updatedDTO.setPortal_concept(updatedEntity.getPortal_concept());
        updatedDTO.setEBS_concept(updatedEntity.getEBS_concept());
        updatedDTO.setEnable(updatedEntity.getEnabled());
        
        return updatedDTO;
    } else {
        // Si el registro no existe, puedes lanzar una excepción o manejarlo de alguna otra manera según tu lógica de negocio
        throw new NoSuchElementException("No se encontró ningún registro con el ID proporcionado: " + id);
    }
    }
 
    
}
