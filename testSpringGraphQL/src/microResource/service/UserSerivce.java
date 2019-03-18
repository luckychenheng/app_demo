package microResource.service;

import java.util.List;
import java.util.Map;

import microResource.model.User;
import net.sf.json.JSONObject;

public interface UserSerivce {

	public void add(User u) ;
	
	public List<User> getUser(int id);

	public Map<String, Object> getUserInfo(String ghql);
}