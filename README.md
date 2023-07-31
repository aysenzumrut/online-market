# Online Market Project
## Purpose 

In this project, it is aimed to make an online shopping site for market products.

- Java 17
- Spring Boot 3.1.1
- Maven

## Features
- Customer
   *    Get All Customers
   *    Save or Update Customer
   *    Product Purchase with Customer
- Product
  * Get All Products
  * Save or Update Product
  * Delete Product By Id
  * Search Products with Criteria Builder
- Category
    * Get All Categories
    * Get Products By Category Id
    * Save or Update Categories
    * Delete Category By Id

## Criteria Builder

Criteria Builder was used to determine the Search Criteria. Search Criterias are kept in an Enum.

| SearchOperation | Mean |
| ------ | ------ |
| eq | EQUAL |
| ne | NOT_EQUAL |
| lt | LESS_THAN |
| gt | GREATER_THAN |
| btw | BETWEEN |
| lte | LESS_THAN_EQUAL 
| gte | GREATER_THAN_EQUAL |
| bw | BEGINS_WITH |
| ew | END_WITH |
| cn | CONTAINS |
| in | LIST_IN |
| nin | LIST_NOT_IN 
| nu | NULL |
| nn | NOT_NULL 

## Reference
> https://medium.com/@cmmapada/advanced-search-and-filtering-using-spring-data-jpa-specification-and-criteria-api-b6e8f891f2bf


