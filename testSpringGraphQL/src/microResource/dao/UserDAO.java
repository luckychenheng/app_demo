package microResource.dao;

import java.util.List;

import microResource.model.Info;
import microResource.model.User;

public interface UserDAO {
	public void save(User u);
	
	public List<User> getUser(int id);
	
	public Info getUserInfo(int id);
	

}
