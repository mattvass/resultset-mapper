package com.automatedsolutions.mappers;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.automatedsolutions.common.BaseTestHelper;
import com.automatedsolutions.pojos.Person;

import static org.mockito.Mockito.*;

/**
 * 
 * @author Matthew Vass Created: February 17, 2018
 *
 */
public class ResultSetMapperTest extends BaseTestHelper {

	private static final String FNAME = "Matthew";

	private static final String LNAME = "Vass";

	private static final String ADDRESS1 = "123 Fake Stree";

	private static final String CITY = "Nowhere";

	private static final Integer AGE = 39;

	private static final Integer ZIP = 19801;

	private static final Boolean ADULT = true;

	private static final Double SALARY = 150000.00;

	private static final Long LONG = 12345678910L;

	private static final Short SHORT = 123;

	private static final BigDecimal BIGDECIMAL = BigDecimal.TEN;

	@SuppressWarnings("deprecation")
	private static final Time TIME = new Time(10, 11, 12);

	private static final Timestamp TIMESTAMP = new Timestamp(LONG);

	private static final Date DATE = new Date(LONG);

	@Mock
	private ResultSet resultSet;

	@InjectMocks
	private ResultSetMapper resultMapper;

	@Test
	public void mapTest() throws SQLException {
		Person person = null;

		when(resultSet.findColumn(anyString())).thenReturn(1);
		when(resultSet.getString("fname")).thenReturn(FNAME);
		when(resultSet.getString("lname")).thenReturn(LNAME);
		when(resultSet.getInt("age")).thenReturn(AGE);
		when(resultSet.getString("address1")).thenReturn(ADDRESS1);
		when(resultSet.getString("city")).thenReturn(CITY);
		when(resultSet.getInt("zip")).thenReturn(ZIP);
		when(resultSet.getDouble("salary")).thenReturn(SALARY);
		when(resultSet.getBoolean("adult")).thenReturn(ADULT);
		when(resultSet.getDate("someDate")).thenReturn(DATE);
		when(resultSet.getTime("someTime")).thenReturn(TIME);
		when(resultSet.getTimestamp("someTimeStamp")).thenReturn(TIMESTAMP);
		when(resultSet.getLong("someLong")).thenReturn(LONG);
		when(resultSet.getShort("someShort")).thenReturn(SHORT);
		when(resultSet.getBigDecimal("someBigDecimal")).thenReturn(BIGDECIMAL);

		person = (Person) ResultSetMapper.map(new Person(), resultSet);

		Assert.assertNotNull(person);
		Assert.assertEquals(person.getFirstName(), FNAME);
		Assert.assertEquals(person.getLastName(), LNAME);
		Assert.assertEquals(person.getAge(), AGE);
		Assert.assertEquals(person.getStreetAddress(), ADDRESS1);
		Assert.assertEquals(person.getCity(), CITY);
		Assert.assertEquals(person.getZipCode(), ZIP);
		Assert.assertEquals(person.getIsAdult(), ADULT);
		Assert.assertEquals(person.getSalary(), SALARY);
		Assert.assertEquals(person.getSomeBigDecimal(), BIGDECIMAL);
		Assert.assertEquals(person.getSomeLong(), LONG);
		Assert.assertEquals(person.getSomeShort(), SHORT);
		Assert.assertEquals(person.getSomeDate(), DATE);
		Assert.assertEquals(person.getSomeTime(), TIME);
		Assert.assertEquals(person.getSomeTimeStamp(), TIMESTAMP);
	}

	@SuppressWarnings("unchecked")
	@Test
	public void mapTestFieldThrowsException() throws SQLException {
		Person person = null;

		when(resultSet.findColumn(anyString())).thenReturn(1);
		when(resultSet.getString("fname")).thenReturn(FNAME);
		when(resultSet.getString("lname")).thenReturn(LNAME);
		when(resultSet.getString("someFieldNotInResultSet")).thenThrow(SQLException.class);

		person = (Person) ResultSetMapper.map(new Person(), resultSet);

		Assert.assertNotNull(person);
		Assert.assertEquals(person.getFirstName(), FNAME);
		Assert.assertEquals(person.getLastName(), LNAME);
	}

	@Test
	public void mapTestFindColumn() throws SQLException {
		Person person = null;

		when(resultSet.findColumn(anyString())).thenReturn(1);
		when(resultSet.findColumn("someFieldNotInResultSet")).thenReturn(0);
		when(resultSet.getString("fname")).thenReturn(FNAME);
		when(resultSet.getString("lname")).thenReturn(LNAME);

		person = (Person) ResultSetMapper.map(new Person(), resultSet);

		Assert.assertNotNull(person);
		Assert.assertEquals(person.getFirstName(), FNAME);
		Assert.assertEquals(person.getLastName(), LNAME);
	}
}
