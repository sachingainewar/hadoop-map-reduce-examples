package Project.Certifi.Loan.HigherPaidBorrower1;

import java.io.IOException;
import java.util.Iterator;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reducer;
import org.apache.hadoop.mapred.Reporter;

public class HigerInterestPaidBorrowerReducer extends MapReduceBase implements Reducer<IntWritable , IntWritable, Text, IntWritable> {

	@Override
	public void reduce(IntWritable key, Iterator<IntWritable> value,
			OutputCollector<Text, IntWritable> output, Reporter report)
			throws IOException {
		// TODO Auto-generated method stub
		
		
			int 	Counter = 0;
			while (value.hasNext()){
				int a =value.next().get();
				if (a < 100){
					Counter++;
					
				}
			}
			output.collect(new Text("Borrower who paid interest more than 1000 -->"+key), new IntWritable (Counter));
		
	}

}
