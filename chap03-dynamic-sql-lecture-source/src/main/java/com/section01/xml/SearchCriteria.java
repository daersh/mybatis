package com.section01.xml;

public class SearchCriteria {
    /*검색 기준을 위한 클래스 */
    private String condition;   //설명. 검색 조건
    private String value;       //설명. 검색어

    public SearchCriteria() {
    }

    public SearchCriteria(String condition, String value) {
        this.condition = condition;
        this.value = value;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "SearchCriteria{" +
                "condition='" + condition + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
