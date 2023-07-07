package com.market.project.onlinemarket.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.market.project.onlinemarket.entity.Category;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductDTO {
    private String name;
    private Integer price;
    private Integer stock;
    private String salesType;
    private Long categoryId;
}
