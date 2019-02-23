package com.nt.service;
import com.nt.bo.StudentBO;
import com.nt.dao.StudentDAO;
import com.nt.dto.StudentDTO;

public class StudentService {
	public String generateResult(StudentDTO dto){
	int total=0;
	double avg=0.0;
	String result =null;
	StudentBO bo  =null;
	StudentDAO dao=null;
	int cnt=0;
	//Use b.logic to calculate total,avg,results
	total=dto.getM1()+dto.getM2()+dto.getM3();
	avg=total/3;
	System.out.println(avg);
	if(dto.getM1()>35&& dto.getM2()>35&& dto.getM2()>35){
	if(avg<35)
		result="fail";
	else
		result="Pass";
	}
	else {
		result="fail";
	}
	//Prepare BO class object havaing persistable data
	bo=new StudentBO();
	bo.setSno(dto.getSno());
	bo.setSname(dto.getSname());
	bo.setTotal(total);
	bo.setAvg(avg);
	bo.setResult(result);
	//Use DAO
	dao=new StudentDAO();
	cnt=dao.insert(bo);
	if(cnt==0)
		return "registration Failed";
	else
		return "Registration Succeded and Result:: "+result;
}//generateResult()
}//classs
