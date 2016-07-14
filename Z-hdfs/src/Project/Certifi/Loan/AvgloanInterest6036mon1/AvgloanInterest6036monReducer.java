package Project.Certifi.Loan.AvgloanInterest6036mon1;

import java.io.IOException;
import java.util.Iterator;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reducer;
import org.apache.hadoop.mapred.Reporter;

public class AvgloanInterest6036monReducer extends MapReduceBase implements Reducer <Text,Text, Text, Text>{

///totalCount =65 ---> Total percetage 	
	float Avgper60=0, Avgper30=0; 
	@Override
	public void reduce(Text key, Iterator<Text> value,
			OutputCollector<Text, Text> output, Reporter report) throws IOException {
		String [] line60 = key.toString().split("=");
		String [] line30 =value.toString().split("=");
		
		int counter60= Integer.parseInt(line60[0].trim());
	    float percet60=Integer.parseInt(line60[1].trim());
	    int counter30=Integer.parseInt(line30[0].trim());
	    float percent30= Integer.parseInt(line30[1].trim());
	    if (percet60!=0){
	    	Avgper60 = percet60/counter60 ;
	    }
	    else if (percent30!=0){
	    	Avgper30 =percent30/counter30;
	    }
		
	    output.collect(new Text ("avg per for 60 month -->"+String.valueOf(Avgper60)), new Text("Avg per for 30 mob"+String.valueOf(Avgper30)));
	}

}
