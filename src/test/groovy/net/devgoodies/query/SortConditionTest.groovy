package net.devgoodies.query

class SortConditionTest extends GroovyTestCase {
    void testAsc() {
        def sortConditionArray = 'abc'.asc()
        assert sortConditionArray.toOrderByString() == 'abc ASC'
    }

    void testDesc() {
        def sortConditionArray = 'abc'.desc()
        assert sortConditionArray.toOrderByString() == 'abc DESC'
    }

    void testCombine() {
        def sortConditionArray = 'abc'.desc() + 'xyz'.asc()
        assert sortConditionArray.toOrderByString() == 'abc DESC, xyz ASC'
    }

    void setUp() {
        ExpandoInstaller.instance.install()
    }
}