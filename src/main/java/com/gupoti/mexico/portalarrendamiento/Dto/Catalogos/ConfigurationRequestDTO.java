package com.gupoti.mexico.portalarrendamiento.Dto.Catalogos;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class ConfigurationRequestDTO  {

     @JsonIgnore
     private Long id;
     @NotNull(message = "this field is not null") 
     @NotEmpty(message = "this field isn't empty")
     @NotBlank(message = "this field isn't blank") 
     @Size(min = 1, max =30, message ="the max length 30")
     @Pattern(regexp = "^[A-Z]*$", message = "Country must be in uppercase")
     private String country;

     @NotNull(message = "this field is not null") 
     @NotEmpty(message = "this field isn't empty")
     @NotBlank(message = "this field isn't blank") 
     @Size(min = 1, max =30, message ="the max length 30")
     @Pattern(regexp = "^[A-Z]*$", message = "This field must contain only uppercase letters")
     private String primaryBook;

     @NotNull(message = "this field is not null") 
     @NotEmpty(message = "this field isn't empty")
     @NotBlank(message = "this field isn't blank") 
     @Size(min = 1, max =30, message ="the max length 30")
     @Pattern(regexp = "^[A-Z]*$", message = "This field must contain only uppercase letters")
     private String secondBook;

     @NotNull(message = "this field is not null") 
     @NotEmpty(message = "this field isn't empty")
     @NotBlank(message = "this field isn't blank") 
     @Size(min = 1, max =30, message ="the max length 30")
     @Pattern(regexp = "^[A-Z]*$", message = "This field must contain only uppercase letters")
     private String operationalUnit;

     @NotNull(message = "this field is not null") 
     @NotEmpty(message = "this field isn't empty")
     @NotBlank(message = "this field isn't blank") 
     @Size(min = 1, max =5, message ="the max length 5")
     @Pattern(regexp = "^[A-Z]*$", message = "This field must contain only uppercase letters")
     private String divisa;

     @NotNull(message = "this field is not null") 
     @NotEmpty(message = "this field isn't empty")
     @NotBlank(message = "this field isn't blank") 
     @Size(min = 1, max =48, message ="the max length 48")
     @Pattern(regexp = "^[A-Z0-9]*$", message = "This field must contain only uppercase letters and digits")
     private String passiveAcount;
      
   
}