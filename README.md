# Java SQL ResultSet Mapper
A simple light weight way to map your pojo to a java sql resultset.

### @TableColumn Annotation

Simply add the TableColumn annotation to the properties of your pojo, and specify the column name it will map to in your resultset.

```
public class Person {

	@TableColumn("fname")
	private String firstName;

	@TableColumn("lname")
	private String lastName;
  
}
```

Then in your code, call the static map method passing your pojo and the resultset. 
```
Person person = (Person) ResultSetMapper.map(new Person(), resultSet);
```
