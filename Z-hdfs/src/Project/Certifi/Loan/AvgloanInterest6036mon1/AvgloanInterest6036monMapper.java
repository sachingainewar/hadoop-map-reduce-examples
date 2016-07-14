package Project.Certifi.Loan.AvgloanInterest6036mon1;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;

public class AvgloanInterest6036monMapper extends MapReduceBase implements Mapper<LongWritable, Text,Text,Text >{

	//0..-->10119590	11971211	11500	11500	11500	 60 months	22.90%	323.54	E	E4	Secretary	4 years	RENT	32760	Verified	13-Dec	Current	n	https://www.lendingclub.com/browse/loanDetail.action?loan_id=10119590	  Borrower added on 12/31/13 > This loan is for debt consolidation - to close credit cards, pay off other debt, finally make a dent in my total debt amount. I already have plans to close all but 2 of my credit cards, and to pay a collection I didn't know about. I want my credit clean with one easy payment.<br>	debt_consolidation	Debt Killer	937xx	CA	27.06	0	Mar-99	0			12	0	9996	70.90%	17	f	10365.14	10365.14	3235.28	3235.28	1134.86	2100.42	0	0	0	14-Nov	323.54	15-Jan	14-Nov	0		1
		//	0			1			2		3		4		5				6	7		8	9	10			11		12		13		
		
		 int IntCount60=0, IntCount30=0;
	float percent30=0;
	float percent60=0;
	@Override
	public void map(LongWritable key, Text value,
			OutputCollector<Text, Text> Output, Reporter report)
			throws IOException {
			String[] line = value.toString().split(",");
			
				
			float percent= Float.parseFloat((line[6].substring(0, line[6].length()-1)).trim()); 
			System.out.println(line[5]);
			String [] months = (line[5].trim()).split(" ");
			int loanTerm =	Integer.parseInt(months[0].trim());
				
			if (loanTerm!=0 && loanTerm ==60){
				IntCount60 ++;
				percent60  = percent60 +percent;
			}
			else if(loanTerm!=0 && loanTerm ==30){
				IntCount30 ++;
				percent30  =percent30+percent;
				
			}
			
		Output.collect(new Text(IntCount60+"="+percent60),new  Text(IntCount30+"="+percent30));
	}

}
