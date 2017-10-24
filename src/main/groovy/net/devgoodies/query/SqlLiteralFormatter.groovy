package net.devgoodies.query

class SqlLiteralFormatter {
    static String format(ValueList valueList) {
        List list = []
        valueList.collection.each {
            list << format(it)
        }

        StringBuilder builder = new StringBuilder()
        builder.append('(')
        builder.append(list.join(', '))
        builder.append(')')
        return builder.toString()
    }

    static String format(String str) {
        String replaced = str.replaceAll("'", "''")
        return "'${replaced}'"
    }

    static String format(boolean aBoolean) {
        return aBoolean ? 'TRUE' : 'FALSE'
    }

    static String format(Number num) {
        return num.toString()
    }

    static String format(aValue) {
        return aValue.toString()
    }
}
