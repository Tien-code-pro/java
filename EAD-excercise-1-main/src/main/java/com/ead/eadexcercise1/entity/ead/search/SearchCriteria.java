package com.ead.eadexcercise1.entity.ead.search;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SearchCriteria {
    private String key;
    private SearchCriteriaOperator operator;
    private Object value;
}
