package microResource.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import static graphql.schema.GraphQLFieldDefinition.newFieldDefinition;
import static graphql.schema.GraphQLObjectType.newObject;
import static graphql.schema.GraphQLArgument.newArgument;
import graphql.ExecutionResult;
import graphql.GraphQL;
import graphql.Scalars;
import graphql.schema.GraphQLFieldDefinition;
import graphql.schema.GraphQLObjectType;
import graphql.schema.GraphQLSchema;
import microResource.dao.UserDAO;
import microResource.dao.impl.UserDAOImpl;
import microResource.model.Info;
import microResource.model.User;
import microResource.service.UserSerivce;
import microResource.util.GraphQLObject;
import net.sf.json.JSONObject;

@Service
public class UserServiceImpl implements UserSerivce {

	private UserDAO userDAO;

	public UserDAO getUserDAO() {
		return userDAO;
	}

	@Resource
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public void add(User u) {
		userDAO.save(u);
	}

	public List<User> getUser(int id) {
		UserDAO userDAO1 = new UserDAOImpl();
		return userDAO1.getUser(id);
	}

	@Override
	public Map<String, Object> getUserInfo(String ghql) {

		GraphQLFieldDefinition findforid = GraphQLFieldDefinition.newFieldDefinition().name("info")
				.argument(// 这里用GraphQL些查询语句时传入的参数
						newArgument().name("id")// 参数名为id
								.type(Scalars.GraphQLInt)// 参数类型
								.build())
				.type(GraphQLObject.info)// 绑定GraphQL的一个结构，就是上面的那段代码
				.dataFetcher(environment -> {
					// 获取查询参数
					int id = environment.getArgument("id");
					return userDAO.getUserInfo(id);
				}).build();

		GraphQLSchema schema = GraphQLSchema.newSchema().query(newObject().name("_123").field(findforid).build())
				.build();

		// "{info(id:1){id,truename,address,user{id,username,password}}}";

		ExecutionResult re = new GraphQL(schema).execute(ghql);
		Map<String, Object> result = (Map<String, Object>) re.getData();

		System.out.println(result);

		return result;
	}
}
