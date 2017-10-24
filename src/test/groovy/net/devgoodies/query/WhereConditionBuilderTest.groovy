package net.devgoodies.query

class WhereConditionBuilderTest extends GroovyTestCase {
    void testWhereTrue() {
        def builder = new WhereConditionBuilder()
        builder.where(true)

        assert builder.toString() == '(TRUE)'
    }

    void testWhereFalse() {
        def builder = new WhereConditionBuilder()
        builder.where(false)

        assert builder.toString() == "(FALSE)"
    }

    void testWhereNumber() {
        def builder = new WhereConditionBuilder()
        builder.whereEquals('abc', 100)

        assert builder.toString() == "(abc = 100)"
    }

    void testWhereString() {
        def builder = new WhereConditionBuilder()
        builder.whereEquals('name', 'foo')

        assert builder.toString() == "(name = 'foo')"
    }

    void testWhereIn() {
        def builder = new WhereConditionBuilder()
        builder.whereIn('id', [1, 3, 5])

        assert builder.toString() == "(id IN (1, 3, 5))"
    }

    void testCombine() {
        def builder = new WhereConditionBuilder()
        builder.whereEquals('name', 'foo')
        builder.whereIn('id', [1, 3, 5])

        assert builder.toString() == "(name = 'foo') AND (id IN (1, 3, 5))"
    }

}