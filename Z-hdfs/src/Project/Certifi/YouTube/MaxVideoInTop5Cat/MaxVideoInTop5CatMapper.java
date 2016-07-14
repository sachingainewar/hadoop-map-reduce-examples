package Project.Certifi.YouTube.MaxVideoInTop5Cat;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;

public class MaxVideoInTop5CatMapper extends MapReduceBase implements Mapper <LongWritable , IntWritable,IntWritable,IntWritable> {

	
//video id 		uploader				Differ uploadingday & from extablishment	category		length of video	 	number of view		rating of v.	total rating count		comments count	related ID
//QuRYeRnAuXM	EvilSquirrelPictures	1135										Pets & Animals	252					1075				4.96			46						86				gFa1YMEJFag
//0 				1					2												3				4				5					6				7						8				9	
	@Override
	public void map(LongWritable key, IntWritable value,
			OutputCollector<IntWritable, IntWritable> output, Reporter report)
			throws IOException {
		
		String [] line= value.toString().split("\t");
		
	}

}
