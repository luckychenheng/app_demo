package microResource.util;

import static graphql.schema.GraphQLFieldDefinition.newFieldDefinition;
import static graphql.schema.GraphQLObjectType.newObject;

import graphql.Scalars;
import graphql.schema.GraphQLObjectType;

public class GraphQLObject {

	public static GraphQLObjectType user = newObject().name("user")
			.field(newFieldDefinition().name("id").type(Scalars.GraphQLInt).build())
			.field(newFieldDefinition().name("username").type(Scalars.GraphQLString).build())
			.field(newFieldDefinition().name("password").type(Scalars.GraphQLString).build()).build();
	public static GraphQLObjectType info = newObject().name("info")
			.field(newFieldDefinition().name("id").type(Scalars.GraphQLInt).build())
			.field(newFieldDefinition().name("truename").type(Scalars.GraphQLString).build())
			.field(newFieldDefinition().name("address").type(Scalars.GraphQLString).build())
			.field(newFieldDefinition().name("user").type(user).build()).build();

}
