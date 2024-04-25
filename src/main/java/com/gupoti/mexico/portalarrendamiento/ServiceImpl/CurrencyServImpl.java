package com.gupoti.mexico.portalarrendamiento.ServiceImpl;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import com.gupoti.mexico.portalarrendamiento.Dto.Catalogos.CurrencyDTO;
import com.gupoti.mexico.portalarrendamiento.Dto.Catalogos.CurrencyRequestDTO;
import com.gupoti.mexico.portalarrendamiento.Model.Catalogos.CurrencyModel;
import com.gupoti.mexico.portalarrendamiento.Repositories.Catalogos.CurrencyRepository;
import com.gupoti.mexico.portalarrendamiento.Service.Catalogos.CurrencyService;

@Service
public class CurrencyServImpl implements CurrencyService{

    private CurrencyRepository repository;

    public CurrencyServImpl(CurrencyRepository repository){
        this.repository= repository;
    }
    
    public CurrencyDTO save(CurrencyRequestDTO data){
        // Check if the data field exists in the DB
        CurrencyModel existCurrenctCode = repository.findFirstByCurrencyCode(data.getCurrencyCode());
        if (existCurrenctCode != null){
            throw new DataIntegrityViolationException("El valor " + data.getCurrencyCode() + " ya existe y el campo solo permite valores únicos.");
        }
        CurrencyModel existCurrency = repository.findFirstByCurrency(data.getCurrency());
        if(existCurrency != null)
        {
            throw new DataIntegrityViolationException("El valor " + data.getCurrency() + " ya existe y el campo solo permite valores únicos");
        }
        //
        CurrencyModel entity = new CurrencyModel(data.getCurrencyCode(), data.getCurrency(), true);
        CurrencyModel responseDB = repository.save(entity);
        return new CurrencyDTO(responseDB.getId(),responseDB.getCurrencyCode(), responseDB.getCurrency(), responseDB.getEnabled());
    };
}
