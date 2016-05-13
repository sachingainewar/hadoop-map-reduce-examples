package Tempareture;

import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;

public class HotdayColdDayMap extends MapReduceBase implements Mapper<Text ,Text , IntWritable , Text  >{

	
	IntWritable dat = new IntWritable();
	@Override
	public void map(Text key, Text value,
			OutputCollector<IntWritable, Text> Output, Reporter report)
			throws IOException {
		// TODO Auto-generated method stub
		String line = value.toString();
		
		// Example of Input 
		  //         Date                              Max     Min 
		  // 25380 20130101  2.514 -135.69   58.43     8.3     1.1     4.7     4.9     5.6     0.01 C     1.0    -0.1     0.4    97.3    36.0    69.4 -99.000 -99.000 -99.000 -99.000 -99.000 -9999.0 -9999.0 -9999.0 -9999.0 -9999.0
			
		
			
					
					String date = line.substring(6, 14).trim();
					 int date1 =Integer.parseInt(date);
					// dat.set(date1);
					
					String Hotday = line.substring(42,45).trim();
					Float hotTemp = Float.parseFloat(Hotday);
					if (hotTemp > 40){
						System.out.println("Day is Hotday ");
						Output.collect(new IntWritable(date1), new Text ("Day is Hot "+ hotTemp));
					}
					String Coolday = line.substring(50, 53).trim();
					Float coolTemp =Float.parseFloat(Coolday);
					
					if (coolTemp< 10){
						System.out.println("Day is coolDay ");
						Output.collect(new IntWritable(date1), new Text ("Day is Cold "+ coolTemp));

					}

			
		
	}

}
