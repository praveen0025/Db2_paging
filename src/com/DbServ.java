package com;

import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.Cursor;
import com.google.appengine.api.datastore.QueryResultIterable;
import com.google.appengine.api.datastore.QueryResultIterator;
import com.google.appengine.repackaged.com.google.gson.Gson;
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.util.QueryResultIteratorWrapper;
public class DbServ extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	Gson gson=new Gson();
// TODO Auto-generated method stub	//super.doPost(req, resp);	//String sname=req.getParameter("name");
	/*	Table values Insertion
	    System.out.println("hello1");
		Student s1=new Student();Student s2=new Student();Student s3=new Student();		
		s1.setStd_name("agile");s2.setStd_name("barzile");s3.setStd_name("crocodile");
		s1.setAge(25);s2.setAge(29);s3.setAge(31);
		s1.setBaranch("e");s2.setBaranch("E");s3.setBaranch("CSE");
		ofy.put(s1);ofy.put(s2);ofy.put(s3);
	*/	
		String req_cursor=req.getParameter("cursor");
		String check_backword=req.getParameter("back");
		System.out.println("cursor :"+req_cursor+"  back:"+check_backword);
		Student s = new Student();
				try{
					ObjectifyService.register(Student.class);
					}
				catch(Exception e){}		
		Objectify ofy = ObjectifyService.begin();
		if(check_backword=="")
		{				com.googlecode.objectify.Query<Student> query=ofy.query(Student.class).limit(5);
						if (req_cursor == null)				
					         query.startCursor(Cursor.fromWebSafeString(""));
						else
							{ query.startCursor(Cursor.fromWebSafeString(req_cursor));}
						QueryResultIterator<Student> iterator = query.iterator();
						List <Student> student_list= new ArrayList<Student>();
							while(iterator.hasNext())
									{
									student_list.add(iterator.next());
									}
						Cursor cursor=iterator.getCursor();
						String new_cursor=cursor.toWebSafeString();
						s.setNewcursor(new_cursor);
						student_list.add(s);						
							String json = gson.toJson(student_list);	
							resp.setContentType("text/json");
							resp.getWriter().println(json);		
							//System.out.println("ended"+json);
		}
		else{ 	/*	
				com.googlecode.objectify.Query<Student> query=ofy.query(Student.class).limit(5);
					if (req_cursor == null)				
							query.startCursor(Cursor.fromWebSafeString(""));
					else{ query.startCursor(Cursor.fromWebSafeString(req_cursor));}		
					
					QueryResultIterator<Student> iterator = query.iterator();
						List <Student> student_list= new ArrayList<Student>();
							while((() iterator).hasPrevious())
									{
									student_list.add(iterator.previous());
									}
						Cursor cursor=iterator.getCursor();
						String new_cursor=cursor.toWebSafeString();
						s.setNewcursor(new_cursor);
						student_list.add(s);						
							String json = gson.toJson(student_list);	
							resp.setContentType("text/json");
							resp.getWriter().println(json);		*/
			}
	}	
}
