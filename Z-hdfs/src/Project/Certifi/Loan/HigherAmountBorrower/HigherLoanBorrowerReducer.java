package Project.Certifi.Loan.HigherAmountBorrower;

import java.io.IOException;
import java.util.Iterator;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reducer;
import org.apache.hadoop.mapred.Reporter;

public class HigherLoanBorrowerReducer extends MapReduceBase implements Reducer<IntWritable , IntWritable, Text, IntWritable>{

	@Override
	public void reduce(IntWritable key, Iterator<IntWritable> value,
			OutputCollector<Text, IntWritable> output, Reporter report)
			throws IOException {
	
		int k =Integer.parseInt(key.toString().trim());
		
		int counter =0;
		while (value.hasNext()){
			int a =(value.next()).get();
			if (a < 1000){
			counter++;
			}
			output.collect(new Text("Borrower who Borrow more than 10,000-->"+k), new IntWritable(counter));
		}
	}

}
