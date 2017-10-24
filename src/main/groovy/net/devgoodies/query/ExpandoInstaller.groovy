package net.devgoodies.query

@Singleton
class ExpandoInstaller {
    static void install() {
        expandForSqlLiteral()
        expandForSortCondition()
    }

    private static expandForSqlLiteral() {
        String.metaClass.asSqlLiteral = { ->
            return "'${delegate}'"
        }
    }

    private static expandForSortCondition() {
        String.metaClass.asc = { ->
            def condition = new SortCondition(delegate, true)
            new SortConditionArray(condition)
        }            

        String.metaClass.desc = { ->
            def condition = new SortCondition(delegate, false)
            new SortConditionArray(condition)
        }
    }
}

