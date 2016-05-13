package charactersCount;

import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.JobClient;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.FileInputFormat;
import org.apache.hadoop.mapred.FileOutputFormat;
import org.apache.hadoop.util.Tool;

public class DriverCharacter extends Configured implements  Tool {

	/**
	 * @param args
	 */
	
	public static void main(String[] args) {

	}
	
	
	
	@Override
	public int run(String[] arg0) throws Exception {
		if (arg0.length < 2){
			System.out.println("Please give input and output directory properly");
			return -1;
			}
		
		JobConf conf= new JobConf(DriverCharacter.class);
		
		conf.setJobName("CountCharactersInWord");
		
		FileInputFormat.setInputPaths(conf, new Path(arg0[0]));
		FileOutputFormat.setOutputPath(conf, new Path(arg0[1]));
		
		conf.setMapperClass(CountCharactersMap.class);
		conf.setReducerClass(CountCharacterReduc.class);
		
		conf.setMapOutputKeyClass(Text.class);
		conf.setMapOutputValueClass(Text.class);
		conf.setOutputKeyClass(Text.class);
		conf.setOutputValueClass(Text.class);
		
		
		JobClient.runJob(conf);
		
		
		
		
		return 0;
	}

}
