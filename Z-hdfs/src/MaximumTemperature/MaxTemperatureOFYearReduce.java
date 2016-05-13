package MaximumTemperature;

import java.io.IOException;
import java.util.Iterator;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reducer;
import org.apache.hadoop.mapred.Reporter;

public class MaxTemperatureOFYearReduce extends MapReduceBase implements Reducer<IntWritable,IntWritable,IntWritable,IntWritable >{

	@Override
	public void reduce(IntWritable key, Iterator<IntWritable> value,
			OutputCollector<IntWritable, IntWritable> Output, Reporter report)
			throws IOException {

			int Sum =0;
			while (value.hasNext()){
				int a = (value.next()).get();
			    if (a>Sum) {
			    	Sum=a;
			    }

			}
			Output.collect(key, new IntWritable (Sum));
			
	}

}
