package com.market.project.onlinemarket.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchCriteria {
    private String fieldName;
    private Object value;
    private String operation;
    @JsonIgnore
    private String dataOption;

    public SearchCriteria(String fieldName, String operation, Object value) {
        this.fieldName = fieldName;
        this.operation = operation;
        this.value = value;

    }
}
