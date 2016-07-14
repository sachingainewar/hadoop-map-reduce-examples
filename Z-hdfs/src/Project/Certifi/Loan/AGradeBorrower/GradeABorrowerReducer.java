package Project.Certifi.Loan.AGradeBorrower;

import java.io.IOException;
import java.util.Iterator;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reducer;
import org.apache.hadoop.mapred.Reporter;

public class GradeABorrowerReducer extends MapReduceBase implements Reducer<IntWritable , IntWritable, Text, IntWritable>{

	@Override
	public void reduce(IntWritable key, Iterator<IntWritable> value,
			OutputCollector<Text, IntWritable> output, Reporter report)
			throws IOException {

//10119590  -1,1,1,1,1
			int Counter = 0;
			while (value.hasNext()){
				int a =(value.next()).get();
				if (a < 100){
					Counter++;
					
				}
				output.collect(new Text("Borrower from Grade A-->"+key), new IntWritable(Counter));

			}
	}

}
