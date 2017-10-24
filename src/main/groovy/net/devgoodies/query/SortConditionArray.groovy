package net.devgoodies.query

class SortConditionArray {
    List<SortCondition> conditions = []
    String prefix = ''

    SortConditionArray() {
    }

    SortConditionArray(SortCondition condition) {
        this.addCondition(condition)
    }

    SortConditionArray plus(SortConditionArray other) {
        def newArray = new SortConditionArray()

        this.conditions.each { newArray.addCondition(it) }
        other.conditions.each { newArray.addCondition(it) }

        return newArray        
    }

    void addCondition(SortCondition condition) {
        this.conditions << condition
    }

    void nullsFirst() {
        this.conditions.first().isNullsFirst = true
    }

    void nullsLast() {
        this.conditions.first().isNullsFirst = false        
    }

    String toOrderByString() {
        this.conditions.collect { 
            def builder = new StringBuilder()
            builder.append(this.prefix + it.sortKey)
            builder.append(' ')
            builder.append((it.isAsc ? 'ASC' : 'DESC'))
            builder.toString()
        }.join(', ')
    }
}
