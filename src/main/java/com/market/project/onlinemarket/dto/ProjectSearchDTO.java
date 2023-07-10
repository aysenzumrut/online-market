package com.market.project.onlinemarket.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectSearchDTO {
    private List<SearchCriteria> searchCriteriaList;
    private String dataOption;
}
