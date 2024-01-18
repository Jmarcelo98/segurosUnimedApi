package com.example.api.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FilterDTO {

    private String name;

    private String email;

    private String gender;
    
    private String locality;
    
    private String uf;
}
