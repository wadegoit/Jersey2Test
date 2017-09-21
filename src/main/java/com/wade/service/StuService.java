
package com.wade.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.wade.domain.Student;


/**
 * 基本的增删查改
 * @author wade
 *
 */
@Path("/students")
public class StuService
{
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	// 定义静态变量，服务器每接收一个请求都会重新加载类，因此如果需要计数，必须将相关变量设置为static
	private static Integer index = 0;
	
	private static Map<Integer, Student> students = new HashMap<Integer, Student>();
	
	public StuService()
	{
		logger.info("init..........StuService.");
		if (students.size() == 0)
		{
			students.put(index, new Student(index++, "stu1", "123456"));
			students.put(index, new Student(index++, "stu2", "654321"));
		}
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
//	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Student> getAllStudents()
	{
		logger.info("浏览器获取了所有student信息");
		List<Student> stuList = new ArrayList<Student>();
		stuList.addAll(students.values());
		return stuList;
	}
	
	@GET
	@Path("{userid}")
	@Produces(MediaType.APPLICATION_XML)
	public Student getStudent(@PathParam("userid") Integer userID)
	{
		if (students.containsKey(userID))
		{
			logger.info("浏览器获取了ID为" + userID + "的用户信息");
			return students.get(userID);
		}
		else
			return null;
	}
    
    @POST
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Student addStudent(Student student) {
         logger.info("addition 添加新的用户信息，该用户ID为：" + (student.getUserID())+" userName:"+student.getUserName() +" No:"+student.getUserNo());
         students.put(student.getUserID() ,student);
//         return String.valueOf(student.getUserID());
         return student;
    }
	
    @DELETE
    @Path("{userID}")
    @Produces(MediaType. TEXT_PLAIN)
    public String deleteStudent(@PathParam("userID" ) Integer userID) {
    	logger.info("deleteStudent >>"+userID);
         if(students .containsKey(userID)) {
        	 students.remove(userID );
             logger.info("浏览器删除了ID为：" + userID +"的用户" );
             return "删除成功" ;
        } else {
             logger.info("浏览器访问了不存在的用户" );
             return "用户不存在，删除失败" ;
        }
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_XML) 
    public String updateStudent(Student student){
    	Integer userID = student.getUserID();
        logger.info("updateUser3:"+userID); 
    	if(!students .containsKey(userID)) {
             logger.info("浏览器访问了不存在的用户" );
             return "不存在该用户" ;
        } else {
        	Student student2 = students .get(userID);
        	student2.setUserName(student.getUserName());
        	student2.setUserNo(student.getUserNo());
             logger.info("浏览器修改了用户ID为：" + userID + "的信息" );
             return "修改成功" ;
        }
    }
    
}
