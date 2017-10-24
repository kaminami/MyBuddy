package net.devgoodies.query

class SortCondition {
    String sortKey
    boolean isAsc = true

    SortCondition(String sortKey, boolean isAsc) {
        this.sortKey = sortKey
        this.isAsc = isAsc
    } 
}

