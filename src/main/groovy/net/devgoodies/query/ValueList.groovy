package net.devgoodies.query

class ValueList {
    def collection

    static ValueList with(aValue) {
        return ValueList.withAll([aValue])
    }

    static ValueList withAll(valueCollection) {
        def list = new ValueList()
        list.collection = valueCollection
        return list
    }
}
