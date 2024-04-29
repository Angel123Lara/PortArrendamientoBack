package com.gupoti.mexico.portalarrendamiento.Dto.Catalogos;
import lombok.Data;
import java.util.Date;

@Data
public class ConceptDTO{
	
	private Long id;
    private String portal_concept;
    private String ebs_concept;
    private Date inactivation_date;
    private boolean enable;

}
