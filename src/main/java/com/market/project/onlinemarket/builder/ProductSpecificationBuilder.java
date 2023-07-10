package com.market.project.onlinemarket.builder;

import com.market.project.onlinemarket.dto.SearchCriteria;
import com.market.project.onlinemarket.entity.Product;
import com.market.project.onlinemarket.enums.SearchOperation;
import com.market.project.onlinemarket.specification.ProductSpecification;
import lombok.Data;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

@Data
public class ProductSpecificationBuilder {

    private final List<SearchCriteria> params;

    public ProductSpecificationBuilder() {
        this.params = new ArrayList<>();
    }

    public final ProductSpecificationBuilder with(String key, String operation, Object value) {
        params.add(new SearchCriteria(key, operation, value));
        return this;
    }

    public final ProductSpecificationBuilder with(SearchCriteria searchCriteria) {
        params.add(searchCriteria);
        return this;
    }

    public Specification<Product> build() {
        if (params.size() == 0) {
            return null;
        }
        Specification<Product> result = new ProductSpecification(params.get(0));
        for (int idx = 1; idx < params.size(); idx++) {
            SearchCriteria field = params.get(idx);
            result = SearchOperation.getDataOption(field.getDataOption()) == SearchOperation.ALL ?
                    Specification.where(result).and(new ProductSpecification(field)) :
                    Specification.where(result).or(new ProductSpecification(field));
        }
        return result;
    }
}
