package com.tinkerpop.gremlin.groovy

import com.tinkerpop.blueprints.pgm.Graph
import com.tinkerpop.blueprints.pgm.impls.tg.TinkerGraphFactory
import com.tinkerpop.gremlin.test.ComplianceTest

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
class UtilitiesTest extends com.tinkerpop.gremlin.test.UtilitiesTest {
    Graph g = TinkerGraphFactory.createTinkerGraph();
    static {
        Gremlin.load();
    }

    public void testCompliance() {
        ComplianceTest.testCompliance(this.getClass());
    }

    public void test_g_v1_out_toList() {
        super.test_g_v1_out_toList(g.v(1).out.toList());
    }

    public void test_g_v1_out_nextX1X() {
        super.test_g_v1_out_nextX1X(g.v(1).out.next(1));
    }

    public void test_g_v1_out_fillXlistX() {
        super.test_g_v1_out_fillXlistX(g.v(1).out().fill([]));
    }
}
