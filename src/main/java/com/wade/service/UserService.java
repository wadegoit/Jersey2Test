package com.wade.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.wade.domain.User;

/**
 * 测试注解 数据类型、参数类型等
 * @author wade
 *
 */
@Path("/users" )
public class UserService {
    
    //定义静态变量，服务器每接收一个请求都会重新加载类，因此如果需要计数，必须将相关变量设置为static
	private Logger logger = LoggerFactory.getLogger(getClass());
	
    private static Integer index = 0;   
    private static Map<Integer, User> users = new HashMap<Integer, User>();
    
    public UserService() {
    	System.out.println("init...........");
         if(users .size() == 0) {
             users.put(index , new User(index++, "user01", "123456" ));
             users.put(index , new User(index++, "user02", "654321" ));
        }
    }
    
//  @Path("/list")  path的格式
  @GET
  @Path("/")
  @Produces({MediaType. APPLICATION_JSON,MediaType.APPLICATION_XML}) //支持两种格式返回,默认XML优先;Postman显示正常，soupUI只显示JSon格式数据，Firefox默认显示XML
//  @Produces({"application/json; qs=.9","application/xml; qs=.5"}) // 增加质量因素
//  @Produces(MediaType.APPLICATION_XML) //返回XML;Postman只显示xml，soupUI只显示XML格式数据，Firefox默认显示XML
//  @Produces(MediaType.APPLICATION_JSON) //返回Json;Postman只显示xml/json/text，soupUI只显示JSon格式数据，Firefox默认显示Json
  public List<User> getAllUsers(){
       logger.info("浏览器获取了所有用户信息" );
      List<User> userList = new ArrayList<User>();
       userList.addAll(users.values());
       return userList ;
  }
    
    @GET
    @Path("{userid}")
    @Produces({MediaType. APPLICATION_JSON,MediaType.APPLICATION_XML})
    public User getUser( @PathParam("userid" ) Integer userID) {
         if(users .containsKey(userID)){
             logger.info("浏览器获取了ID为" + userID + "的用户信息" );
             return users .get(userID);
        } else return null;
    }

    
    @POST
    @Path("/addition")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED )
//    @Consumes(MediaType. APPLICATION_FORM_URLENCODED )
//    @Produces(MediaType. TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
    public String addUser( @FormParam("userName" ) String userName, @FormParam ("passWord" ) String passWord) {
         users.put(index , new User(index++, userName, passWord ));
         logger.info("addition 添加新的用户信息，该用户ID为：" + (index-1)+" userName:"+userName +" passWord:"+passWord);
         return String.valueOf( index-1);
//         return "<result>success</result>";
    }
    
    /**
     * @HeaderParam SoupUI测试时，选择的参数类型Header
     * 
     * @param userName
     * @param passWord
     * @return
     */
    @POST
    @Path("/addition2")
    @Consumes(MediaType. APPLICATION_FORM_URLENCODED )
    @Produces(MediaType. TEXT_PLAIN)
    public String addUser2( @HeaderParam("userName" ) String userName, @HeaderParam ("passWord" ) String passWord) {
         users.put(index , new User(index++, userName, passWord ));
         logger.info("addition2 添加新的用户信息，该用户ID为： " + (index-1)+" userName:"+userName +" passWord:"+passWord);
         return String.valueOf( index-1);
    }
    
    
    
    @PUT
    @Path("update")
//    @Consumes(MediaType.APPLICATION_XML)
//    @Produces(MediaType. TEXT_PLAIN)
    @Produces({MediaType. APPLICATION_JSON,MediaType.APPLICATION_XML})
    public String updateUser(@QueryParam("userName" ) String userName, @QueryParam ("passWord" ) String passWord, @QueryParam ("userID" ) Integer userID){
        logger.info("updateUser:"+userID);
        System.out.println("updateUser...:"+userID);
    	if(!users .containsKey(userID)) {
             logger.info("浏览器访问了不存在的用户" );
             return "不存在该用户" ;
        } else {
            User user = users .get(userID);
             user.setUserName(userName);
             user.setPassWord(passWord);
             logger.info("浏览器修改了用户ID为：" + userID + "的信息" );
             return "修改成功" ;
        }
    }
    
    @PUT
    @Path("update2")
//    @Produces(MediaType. TEXT_PLAIN)
    @Produces({MediaType. APPLICATION_JSON,MediaType.APPLICATION_XML,MediaType. TEXT_PLAIN})
    public String updateUser2(@HeaderParam("userName" ) String userName, @HeaderParam ("passWord" ) String passWord, @HeaderParam ("userID" ) Integer userID){
        logger.info("updateUser2:"+userID); 
    	if(!users .containsKey(userID)) {
             logger.info("浏览器访问了不存在的用户" );
             return "不存在该用户" ;
        } else {
            User user = users .get(userID);
             user.setUserName(userName);
             user.setPassWord(passWord);
             logger.info("浏览器修改了用户ID为：" + userID + "的信息" );
             return "修改成功" ;
        }
    }
//    
    @PUT
    @Path("update3")
    @Consumes(MediaType.APPLICATION_XML) 
    @Produces({MediaType. APPLICATION_JSON,MediaType.APPLICATION_XML,MediaType. TEXT_PLAIN})
    public String updateUser3(User user){
    	Integer userID = user.getUserID();
        logger.info("updateUser3:"+userID); 
    	if(!users .containsKey(userID)) {
             logger.info("浏览器访问了不存在的用户" );
             return "不存在该用户" ;
        } else {
            User user2 = users .get(userID);
             user2.setUserName(user.getUserName());
             user2.setPassWord(user.getPassWord());
             logger.info("浏览器修改了用户ID为：" + userID + "的信息" );
             return "修改成功" ;
        }
    }
    
    @DELETE
    @Path("delete/{userID}")
    @Produces(MediaType. TEXT_PLAIN)
    public String deleteUser(@PathParam("userID" ) Integer userID) {
         if(users .containsKey(userID)) {
             users.remove(userID );
             logger.info("浏览器删除了ID为：" + userID +"的用户" );
             return "删除成功" ;
        } else {
             logger.info("浏览器访问了不存在的用户" );
             return "用户不存在，删除失败" ;
        }
    }
}