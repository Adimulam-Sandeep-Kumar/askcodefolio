package com.sandeep.portfolio.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Achievement {
    private String icon;
    private String description;
    private String category;
}
