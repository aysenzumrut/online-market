package com.market.project.onlinemarket.enums;

public enum SearchOperation {
    //Arama Yapılırken kullanılabilecek kriterler

    EQUAL, NOT_EQUAL, LESS_THAN, GREATER_THAN, BETWEEN, LESS_THAN_EQUAL, GREATER_THAN_EQUAL, BEGINS_WITH, END_WITH, CONTAINS, LIST_IN, LIST_NOT_IN, NULL, NOT_NULL, ALL, ANY;

    public static final String[] SIMPLE_OPERATION_SET = {"eq", "ne", "lt", "gt", "btw", "lte", "gte", "bw", "ew", "cn", "in", "nin", "nu", "nn"};

    public static SearchOperation getDataOption(final String dataOption) {
        switch (dataOption) {
            case "all":
                return ALL;
            case "any":
                return ANY;
            default:
                return null;
        }
    }

    public static SearchOperation getSimpleOperation(final String input) {
        switch (input) {
            case "eq":
                return EQUAL;
            case "ne":
                return NOT_EQUAL;
            case "lt":
                return LESS_THAN;
            case "gt":
                return GREATER_THAN;
            case "btw":
                return BETWEEN;
            case "lte":
                return LESS_THAN_EQUAL;
            case "gte":
                return GREATER_THAN_EQUAL;
            case "bw":
                return BEGINS_WITH;
            case "ew":
                return END_WITH;
            case "cn":
                return CONTAINS;
            case "in":
                return LIST_IN;
            case "nin":
                return LIST_NOT_IN;
            case "nu":
                return NULL;
            case "nn":
                return NOT_NULL;
            default:
                return null;
        }
    }
}
