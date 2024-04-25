package com.gupoti.mexico.portalarrendamiento.Service.Catalogos;

import java.util.List;
import com.gupoti.mexico.portalarrendamiento.Dto.Catalogos.CurrencyDTO;
import com.gupoti.mexico.portalarrendamiento.Dto.Catalogos.CurrencyRequestDTO;

public interface CurrencyService {
    
    CurrencyDTO save(CurrencyRequestDTO data);

    List<CurrencyDTO> findAll();
}
