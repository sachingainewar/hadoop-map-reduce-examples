package Project.Certifi.Loan.HighestBorrowerDetails;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;

public class HighestBorrowerDetailsMapper extends MapReduceBase implements Mapper <LongWritable, Text,IntWritable,Text>{

///id	member_id 	loan_amnt 	funded_amnt 	funded_amnt_inv 	term	int_rate 	installment	grade 	sub_grade 	emp_title 	emp_length 	home_ownership 	annual_inc 	is_inc_v 	issue_d 	loan_status 	pymnt_plan 	url 	desc 	purpose 	title 	zip_code 	addr_state 	dti 	delinq_2yrs 	earliest_cr_line 	inq_last_6mths 	mths_since_last_delinq 	mths_since_last_record 	open_acc 	pub_rec 	revol_bal 	revol_util 	total_acc 	initial_list_status 	out_prncp 	out_prncp_inv 	total_pymnt 	total_pymnt_inv 	total_rec_prncp40	total_rec_int 	total_rec_late_fee 	recoveries 	collection_recovery_fee 	last_pymnt_d 	last_pymnt_amnt 	next_pymnt_d 	last_credit_pull_d 	collections_12_mths_ex_med 	mths_since_last_major_derog 	policy_code 
//	0	1			2				3				4				5			6			7			8		9		10				11		12					13			14			15		16					17		18		19		20			21		22			23			24		25					26				27					28						29						30		31			32			33			34				35						36			37				38			39						40					41				42					43			44						45					46				47				48						49							50							51														
	
	Map <Integer , Integer> borrowerDit= new HashMap<Integer,Integer>();
	int loan =0, id=0 , Income=0;
	@Override
	public void map(LongWritable key, Text value,
			OutputCollector<IntWritable, Text> Output, Reporter report)
			throws IOException {
		
		String [] line= value.toString().split(",");
		int temp = Integer.parseInt(line[2].trim()) ;
		 if (loan < temp ){
					 loan = temp ;
					 borrowerDit.put(Integer.parseInt(line[0].trim()), Integer.parseInt(line[13].trim()));
		 		}	
		 		Output.collect(new IntWritable(loan), new Text(borrowerDit.toString()));
		 	}
	}


