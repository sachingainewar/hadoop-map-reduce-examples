package Project.Certifi.Loan.HighestBorrowerGrade1;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reducer;
import org.apache.hadoop.mapred.Reporter;

public class HighestBorrowerGradeReducer extends MapReduceBase implements Reducer<Text, IntWritable, Text, IntWritable>{

	@Override
	public void reduce(Text key, Iterator<IntWritable> value,
			OutputCollector<Text, IntWritable> Output, Reporter report)
			throws IOException {
		
		Entry<String, Integer> MaxEntry =null;

		
//{D=10044000, E=103430, F=400000, G=500000, A=100000, B=120000, C=104000}
// Convertion of string into HashMap		
		String line = key.toString().substring(1, key.toString().length()-1); /// Convert into string 
		String [] keyValuePair =line.split(",");   // Split with , 
		
		Map<String , Integer> GradeLoanAmt = new HashMap <String , Integer >();  // initialized Map 
		for (int i=0; i < keyValuePair.length ; i++){
			String [] a = keyValuePair[i].split("=");
			
			GradeLoanAmt.put(a[0].trim(), Integer.parseInt(a[1].trim()));
		}
		
		
/// Finding Key of hightest value in HashMap
		
		Integer maxLoan= Collections.max(GradeLoanAmt.values());  // find a highest value from HashMap
		
		for (Entry<String,Integer> entry : GradeLoanAmt.entrySet()){     // for loop to check all values from hashmap
			
				Integer Amt= entry.getValue();
				
			 if (Amt!=null && Amt==maxLoan){
				 MaxEntry =entry;
				}
			}
			Output.collect(new Text("Highest Loan taken by Grade --> "+MaxEntry.getKey().toString()),new IntWritable(MaxEntry.getValue()));
	}

}
