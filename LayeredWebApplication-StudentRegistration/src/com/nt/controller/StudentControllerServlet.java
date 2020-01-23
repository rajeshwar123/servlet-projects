package com.nt.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nt.dto.StudentDTO;
import com.nt.service.StudentService;
import com.nt.vo.StudentVO;
@WebServlet("/controller")
public class StudentControllerServlet extends HttpServlet{
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		StudentVO vo=null;
		String name=null;
		int age=20;
		String sno=null,sname=null,m1=null,m2=null,m3=null;
		String result=null;
		StudentDTO dto=null;
		StudentService service =null;
		PrintWriter pw=null;
		//ServeltOutputStream sos=null;
		//read form data
		sno=req.getParameter("sno");
		sname=req.getParameter("sname");
		m1=req.getParameter("m1");
		m2=req.getParameter("m2");
		m3=req.getParameter("m3");
		//create VO class obj having form data
		vo=new StudentVO();
		vo.setSno(sno);
		vo.setSname(sname);
		vo.setM1(m1);
		vo.setM2(m2);
		vo.setM3(m3);
		//convert vo class obj into DTO class  object
		dto= new StudentDTO();
		dto.setSno(Integer.parseInt(vo.getSno()));
		dto.setSname(vo.getSname());
		dto.setM1(Integer.parseInt(vo.getM1()));
		dto.setM2(Integer.parseInt(vo.getM2()));
		dto.setM3(Integer.parseInt(vo.getM3()));
		//use service class
		service=new StudentService();
		result=service.generateResult(dto);
		
		//display result
		//sos=res.getOutputStream();
		pw=res.getWriter();
		res.setContentType("text/html");
		pw.println("<h1>Result: "+result+"</h1>");
		//pw.println("<h1>Result: "++"</h1>");
		//add hyperlink
		pw.println("<a href='input.html'>home </a>");
		//close stream
		pw.close();
	}//doGet()

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req,res);
	}
	}