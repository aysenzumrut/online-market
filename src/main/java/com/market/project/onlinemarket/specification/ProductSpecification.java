package com.market.project.onlinemarket.specification;

import com.market.project.onlinemarket.dto.SearchCriteria;
import com.market.project.onlinemarket.entity.Product;
import com.market.project.onlinemarket.enums.SearchOperation;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ProductSpecification implements Specification<Product> {

    private final SearchCriteria searchCriteria;

    public ProductSpecification(SearchCriteria searchCriteria) {
        this.searchCriteria = searchCriteria;
    }

    @Override
    public Predicate toPredicate(Root<Product> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        String strToSearch = searchCriteria.getValue().toString();
        switch (Objects.requireNonNull(SearchOperation.getSimpleOperation(searchCriteria.getOperation()))) {
            case EQUAL -> {
                return criteriaBuilder.equal(root.get(searchCriteria.getFieldName()), strToSearch);
            }
            case NOT_EQUAL -> {
                return criteriaBuilder.notEqual(root.get(searchCriteria.getFieldName()), strToSearch);
            }
            case LESS_THAN -> {
                return criteriaBuilder.lessThan(root.get(searchCriteria.getFieldName()), strToSearch);
            }
            case GREATER_THAN -> {
                return criteriaBuilder.greaterThan(root.get(searchCriteria.getFieldName()), strToSearch);
            }
            case BETWEEN -> {
                if (searchCriteria.getValue().toString().split(",").length == 2) {
                    List<String> tempList = Arrays.asList(searchCriteria.getValue().toString().split(","));
                    return criteriaBuilder.between(root.get(searchCriteria.getFieldName()), tempList.get(0), tempList.get(1));
                }
            }
            case LESS_THAN_EQUAL -> {
                return criteriaBuilder.lessThanOrEqualTo(root.get(searchCriteria.getFieldName()), strToSearch);
            }
            case GREATER_THAN_EQUAL -> {
                return criteriaBuilder.greaterThanOrEqualTo(root.get(searchCriteria.getFieldName()), strToSearch);
            }
            case BEGINS_WITH -> {
                return criteriaBuilder.like(root.get(searchCriteria.getFieldName()), strToSearch + "%");
            }
            case END_WITH -> {
                return criteriaBuilder.like(root.get(searchCriteria.getFieldName()), "%" + strToSearch);
            }
            case CONTAINS -> {
                return criteriaBuilder.like(root.get(searchCriteria.getFieldName()), "%" + strToSearch + "%");
            }
            case LIST_IN -> {
                List<String> tempList;
                tempList = Arrays.asList(searchCriteria.getValue().toString().split(","));
                return root.get(searchCriteria.getFieldName()).in(tempList);
            }
            case LIST_NOT_IN -> {
                List<String> tempList;
                tempList = Arrays.asList(searchCriteria.getValue().toString().split(","));
                return criteriaBuilder.not(root.get(searchCriteria.getFieldName()).in(tempList));
            }
            case NULL -> {
                return criteriaBuilder.isNull(root.get(searchCriteria.getFieldName()));
            }
            case NOT_NULL -> {
                return criteriaBuilder.isNotNull(root.get(searchCriteria.getFieldName()));
            }

        }
        return null;
    }
}
