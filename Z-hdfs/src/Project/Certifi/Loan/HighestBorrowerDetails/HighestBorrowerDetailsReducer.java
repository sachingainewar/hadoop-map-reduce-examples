package Project.Certifi.Loan.HighestBorrowerDetails;

import java.io.IOException;
import java.util.Iterator;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reducer;
import org.apache.hadoop.mapred.Reporter;

public class HighestBorrowerDetailsReducer extends MapReduceBase implements Reducer <IntWritable, Text, IntWritable,Text>{

	@Override
	public void reduce(IntWritable key, Iterator<Text> value,
			OutputCollector<IntWritable, Text> output, Reporter result)
			throws IOException {
			
			String details= null;
			int loanAmt= 0;
			while(value.hasNext()){
				int a =value.next().getLength();
				if(a > 0){
					loanAmt = Integer.parseInt(key.toString());
					details = value.toString();

				}
				output.collect(new IntWritable (loanAmt),new  Text ("borrower details -> "+details ));
											
			}
				
			}
	}


