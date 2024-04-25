package com.gupoti.mexico.portalarrendamiento.Dto.Catalogos;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ConceptRequestDTO{
	
	
    
    @NotNull(message="this fiels isnt't null")
    @NotEmpty(message="this fiels isnt't empty")
    @NotBlank(message="this fiels isnt't blanck")
    @Size(min =1, max= 30, message="the max length is 30")
    private String portal_concept;

    @NotNull(message="this fiels isnt't null")
    @NotEmpty(message="this fiels isnt't empty")
    @NotBlank(message="this fiels isnt't blanck")
    @Size(min =1, max= 30, message="the max length is 30")
    private String EBS_concept;
   
}
