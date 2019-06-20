package com.vic.permanent.fastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Test {

	public static void main(String[] args) {
		
		User u1 = new User(1, "u1");
		
		/**
		 * 对象转换为json字符串
		 */
		String jsonString = JSON.toJSONString(u1);
//		System.out.println(jsonString);
		
		/**
		 * 对象转换为json对象
		 */
//		System.out.println(JSON.toJSON(u1));
		
		/**
		 * json字符串转换为指定对象
		 */
		User user = JSON.parseObject(jsonString, User.class);
//		System.out.println(user);
		
		/**
		 * 将json字符串解析为JSONObject(key/value数据格式)
		 */
		JSONObject jsonObject = JSON.parseObject(jsonString);
		
		Integer id = jsonObject.getInteger("id");
		Integer id1 = (Integer)jsonObject.get("id");
//		System.out.println(id);
//		System.out.println(id1);
		
		/**
		 * put操作
		 */
		jsonObject.put("age", 18);
		Integer age = jsonObject.getInteger("age");
//		System.out.println(age);
		
		
		List<User> userList = new ArrayList<User>();
		userList.add(new User(1, "u1"));
		userList.add(new User(2, "u2"));
		
		/**
		 * 集合转换为json对象
		 */
//		System.out.println(JSON.toJSON(userList));
		
		/**
		 * 集合转换为json字符串
		 */
//		System.out.println(JSON.toJSONString(userList));
		
		/**
		 * 
		 */
		
		String str = "[{\"id\":1,\"name\":\"u1\"},{\"id\":2,\"name\":\"u2\"}]";
		JSONArray parseArray = JSON.parseArray(str);
//		System.out.println(parseArray.toJSONString());
		
		List<User> uList = JSON.parseArray(str, User.class);
//		System.out.println(uList);
		
		/**
		 * 对象包含对象
		 */
		
		List<User> userList2 = new ArrayList<User>();
		userList2.add(new User(1, "u1"));
		userList2.add(new User(2, "u2"));
		
		Group group = new Group();
		group.setId(1);
		group.setName("g1");
		group.setUserList(userList2);
		
//		System.out.println(JSON.toJSONString(group));
		
		//{"id":1,"name":"g1","userList":[{"id":1,"name":"u1"},{"id":2,"name":"u2"}]}
//		String groupStr = "{\"id\":1,\"name\":\"g1\",\"userList\":[{\"id\":1,\"name\":\"u1\"},{\"id\":2,\"name\":\"u2\"}]}";
		
//		Group g = JSON.parseObject(groupStr, Group.class);
		
//		System.out.println(g);
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("create_time", "2018-05-31 13:59:33");
		map.put("id", "1");
		map.put("name", "张三");
		
		String jsonStr = JSON.toJSONString(map);
		
//		System.out.println(jsonStr);
		
		User user1 = JSON.parseObject(jsonStr, User.class);
		
//		System.out.println(user1);


		String a = "{\"code\":\"000\",\"msg\":\"上传成功\",\"result\":{\"id_card_number\":\"411421199105116029\",\"name\":\"江淑敏\"}}";
		System.out.println(JSON.toJSONString(a));
		
	}

}
