package net.devgoodies.query

class WhereConditionBuilder {
    List<String> expressions = []

    String toString() {
        this.expressions.collect { "(${it})"}.join(' AND ')
    }

    void where(String expression) {
        this.expressions << expression
    }

    void where(boolean aBoolean) {
        this.expressions << SqlLiteralFormatter.format(aBoolean)
    }

    void where(String expression, String operator, value) {
        String sqlLiteral = SqlLiteralFormatter.format(value)
        this.expressions << "${expression} ${operator} ${sqlLiteral}" 
    }

    void whereEquals(String expression, value) {
        this.where(expression, '=', value)
    }

    void whereNotEquals(String expression, value) {
        this.where(expression, '<>', value)
    }

    void whereIn(String expression, values) {
        def valueList = ValueList.withAll(values)
        this.where(expression, 'IN', valueList)
    }

    void whereNotIn(String expression, values) {
        def valueList = ValueList.withAll(values)
        this.where(expression, 'NOT IN', valueList)
    }

    void whereIlike(String expression, value) {
        this.where(expression, 'ILIKE', value)
    }

    void whereLike(String expression, value) {
        this.where(expression, 'LIKE', value)
    }

    void whereNotIlike(String expression, value) {
        this.where(expression, 'NOT ILIKE', value)
    }

    void whereNotLike(String expression, value) {
        this.where(expression, 'NOT LIKE', value)
    }

    void whereIsNull(String expression) {
        this.expressions << "${expression} IS NULL"
    }

    void whereIsNotNull(String expression) {
        this.expressions << "${expression} IS NOT NULL"
    }
}

