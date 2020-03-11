package source;

import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.streaming.api.functions.source.SourceFunction;


public class DemoSource implements SourceFunction<Tuple2<Long,Long>> {

    private boolean flag=true;
    private Long amount=1L;
    @Override
    public void run(SourceContext<Tuple2<Long, Long>> ctx) throws Exception {
        while (flag){
            ctx.collect(Tuple2.of(1L,amount));
            amount ++;
            Thread.sleep(2000);
        }
    }

    @Override
    public void cancel() {
       flag=false;
    }
}
