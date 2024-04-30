package com.gupoti.mexico.portalarrendamiento.Dto.Catalogos;
import lombok.Data;
import java.util.Date;

@Data
public class ConceptDTO{
	
	private Long id;
    private String portalConcept;
    private String ebsConcept;
    private Date inactivationDate;
    private boolean enable;

}
