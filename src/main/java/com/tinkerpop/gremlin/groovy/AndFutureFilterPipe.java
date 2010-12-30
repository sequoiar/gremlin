package com.tinkerpop.gremlin.groovy;

import com.tinkerpop.pipes.AbstractPipe;
import com.tinkerpop.pipes.Pipe;
import com.tinkerpop.pipes.SingleIterator;
import com.tinkerpop.pipes.filter.FilterPipe;

import java.util.Arrays;
import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class AndFutureFilterPipe<S>  extends AbstractPipe<S, S> implements FilterPipe<S> {

    private final List<Pipe<S, ?>> pipes;

    public AndFutureFilterPipe(final Pipe<S, ?>... pipes) {
        this.pipes = Arrays.asList(pipes);
    }

    public AndFutureFilterPipe(final List<Pipe<S, ?>> pipes) {
        this.pipes = pipes;
    }

    public S processNextStart() {
        while (true) {
            S s = this.starts.next();
            boolean and = true;
            for (Pipe<S, ?> pipe : this.pipes) {
                pipe.setStarts(new SingleIterator<S>(s));
                if (!pipe.hasNext()) {
                    and = false;
                    break;
                } else {
                    pipe.next();
                }
            }
            if (and)
                return s;
        }
    }

}