package com.tinkerpop.gremlin.test.transform;

import com.tinkerpop.blueprints.pgm.Vertex;
import com.tinkerpop.pipes.Pipe;
import junit.framework.TestCase;

import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class SelectStepTest extends TestCase {

    public void testCompliance() {
        assertTrue(true);
    }

    public void test_g_v1_asXaX_outXknowsX_asXbX_select(final Pipe<Vertex, List> pipe) {
        int counter = 0;
        while (pipe.hasNext()) {
            counter++;
            List list = pipe.next();
            assertEquals(list.size(), 2);
            assertEquals(((Vertex) list.get(0)).getId().toString(), "1");
            assertTrue(((Vertex) list.get(1)).getId().toString().equals("2") || ((Vertex) list.get(1)).getId().toString().equals("4"));
        }
        assertEquals(counter, 2);
    }

    public void test_g_v1_asXaX_outXknowsX_asXbX_selectXnameX(final Pipe<Vertex, List> pipe) {
        int counter = 0;
        while (pipe.hasNext()) {
            counter++;
            List list = pipe.next();
            assertEquals(list.size(), 2);
            assertEquals(list.get(0).toString(), "marko");
            assertTrue(list.get(1).toString().equals("josh") || list.get(1).toString().equals("vadas"));
        }
        assertEquals(counter, 2);
    }

    public void test_g_v1_asXaX_outXknowsX_asXbX_selectXaX(final Pipe<Vertex, List> pipe) {
        int counter = 0;
        while (pipe.hasNext()) {
            counter++;
            List list = pipe.next();
            assertEquals(list.size(), 1);
            assertEquals(((Vertex) list.get(0)).getId().toString(), "1");
        }
        assertEquals(counter, 2);
    }

    public void test_g_v1_asXaX_outXknowsX_asXbX_selectXa_nameX(final Pipe<Vertex, List> pipe) {
        int counter = 0;
        while (pipe.hasNext()) {
            counter++;
            List list = pipe.next();
            assertEquals(list.size(), 1);
            assertEquals(list.get(0).toString(), "marko");
        }
        assertEquals(counter, 2);
    }
}