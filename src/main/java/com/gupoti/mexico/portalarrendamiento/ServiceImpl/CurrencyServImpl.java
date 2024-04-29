package com.gupoti.mexico.portalarrendamiento.ServiceImpl;

import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import com.gupoti.mexico.portalarrendamiento.Dto.Catalogos.CurrencyDTO;
import com.gupoti.mexico.portalarrendamiento.Dto.Catalogos.CurrencyRequestDTO;
import com.gupoti.mexico.portalarrendamiento.Model.Catalogos.CurrencyModel;
import com.gupoti.mexico.portalarrendamiento.Repositories.Catalogos.CurrencyRepository;
import com.gupoti.mexico.portalarrendamiento.Service.Catalogos.CurrencyService;

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
        CurrencyModel entity = new CurrencyModel(data.getCurrencyCode(), data.getDivisa(), true);
        CurrencyModel responseDB = repository.save(entity);
        return new CurrencyDTO(responseDB.getId(),responseDB.getCurrencyCode(), responseDB.getDivisa(), responseDB.getEnabled());
    };

    public List<CurrencyDTO> findAll()
    {
        return repository.findAll().stream()
                .map(CurrencyModel -> modelMapper.map(CurrencyModel, CurrencyDTO.class))
                     .collect(Collectors.toList());

    } 
}
