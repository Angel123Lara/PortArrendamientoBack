package com.gupoti.mexico.portalarrendamiento.ServiceImpl;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;
import com.gupoti.mexico.portalarrendamiento.Dto.Catalogos.CurrencyDTO;
import com.gupoti.mexico.portalarrendamiento.Dto.Catalogos.CurrencyRequestDTO;
import com.gupoti.mexico.portalarrendamiento.Model.Catalogos.CurrencyModel;
import com.gupoti.mexico.portalarrendamiento.Repositories.Catalogos.CurrencyRepository;
import com.gupoti.mexico.portalarrendamiento.Service.Catalogos.CurrencyService;
import jakarta.persistence.EntityExistsException;

@Service
public class CurrencyServImpl implements CurrencyService{

    @Autowired
    private CurrencyRepository repository;

    @Autowired
    private ModelMapper modelMapper;
    
    public CurrencyDTO save(CurrencyRequestDTO data){
        // Check if the data field exists in the DB
        CurrencyModel existCurrenctCode = repository.findFirstByCurrencyCode(data.getCurrencyCode());
        if (existCurrenctCode != null){
            throw new DataIntegrityViolationException("El valor " + data.getCurrencyCode() + " ya existe y el campo solo permite valores únicos.");
        }
        //
        CurrencyModel entity = new CurrencyModel(data.getCurrencyCode(), data.getCurrency(), true);      
        entity.setCreationDate(new Date());
        CurrencyModel responseDB = repository.save(entity);
        return new CurrencyDTO(responseDB.getId(),responseDB.getCurrencyCode(), responseDB.getDivisa(), responseDB.getEnabled());
    };

    public List<CurrencyDTO> findAll()
    {
        return repository.findAll().stream()
                .map(CurrencyModel -> modelMapper.map(CurrencyModel, CurrencyDTO.class))
                     .collect(Collectors.toList());

    } 


    public CurrencyDTO enabledById(Long id)
    {
        CurrencyModel existEntity = repository.findById(id)
                                    .orElseThrow(()-> new DataIntegrityViolationException("No se encontro el registro con el id :"+ id ));
        
        if(existEntity.getEnabled() == null)
        {
            existEntity.setEnabled(true);
        }else{
        existEntity.setEnabled(!existEntity.getEnabled());
        }
        CurrencyModel responseDB = repository.save(existEntity);

        return new CurrencyDTO(responseDB.getId(),responseDB.getCurrencyCode(), responseDB.getDivisa(), responseDB.getEnabled());
   
        

    public CurrencyDTO update(Long id, CurrencyRequestDTO data)
    {
        CurrencyModel entityDB = repository.findById(id)
                                    .orElseThrow(()-> new DataIntegrityViolationException("El id " + id + 
                                    " no se encuentra en la base de datos."));
        CurrencyModel existData = repository.findFirstByCurrencyCode(data.getCurrencyCode());
        if(existData != null)
        {             
            throw new DataIntegrityViolationException(
                "El valor " + data.getCurrencyCode() + " ya existe y el campo solo permite valores únicos.");
                                                            }
        entityDB.setCurrency(data.getCurrency());
        entityDB.setCurrencyCode(data.getCurrencyCode());
        entityDB.setLastUpdateDate(new Date());
        CurrencyDTO response = modelMapper.map(repository.save(entityDB), CurrencyDTO.class);

        return response;


    }
}
