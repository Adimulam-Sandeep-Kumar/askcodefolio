package com.sandeep.portfolio.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Developer {
    private String name;
    private String title;
    private String email;
    private String phone;
    private String linkedin;
    private String location;
    private String status;
}
