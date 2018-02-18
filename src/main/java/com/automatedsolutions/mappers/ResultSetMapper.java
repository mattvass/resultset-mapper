package com.automatedsolutions.mappers;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;

import org.apache.log4j.Logger;
import org.springframework.util.ReflectionUtils;

import com.automatedsolutions.annotations.TableColumn;
import com.automatedsolutions.constants.ErrorMessages;

/**
 * 
 * @author Matthew Vass Created: February 17, 2018
 *
 */
public class ResultSetMapper {

	private static final Logger log = Logger.getLogger(ResultSetMapper.class.getName());

	/**
	 * Maps the result set to the annotated class
	 * 
	 * @param obj
	 *            your class with the annotated fields
	 * @param resultSet
	 *            your resultset from your datasource
	 * @return Object with values
	 */
	public static Object map(final Object obj, final ResultSet resultSet) {

		ReflectionUtils.doWithFields(obj.getClass(), new ReflectionUtils.FieldCallback() {

			public void doWith(Field field) throws IllegalArgumentException, IllegalAccessException {

				if (field.isAnnotationPresent(TableColumn.class)) {
					String column = field.getAnnotation(TableColumn.class).value();

					try {
						field.setAccessible(true);
						if (resultSet.findColumn(column) > 0) {
							if (field.getType().isAssignableFrom(String.class)) {
								field.set(obj, resultSet.getString(column));
							} else if (field.getType().isAssignableFrom(Integer.class)) {
								field.set(obj, resultSet.getInt(column));
							} else if (field.getType().isAssignableFrom(Boolean.class)) {
								field.set(obj, resultSet.getBoolean(column));
							} else if (field.getType().isAssignableFrom(Double.class)) {
								field.set(obj, resultSet.getDouble(column));
							} else if (field.getType().isAssignableFrom(BigDecimal.class)) {
								field.set(obj, resultSet.getBigDecimal(column));
							} else if (field.getType().isAssignableFrom(Date.class)) {
								field.set(obj, resultSet.getDate(column));
							} else if (field.getType().isAssignableFrom(Time.class)) {
								field.set(obj, resultSet.getTime(column));
							} else if (field.getType().isAssignableFrom(Timestamp.class)) {
								field.set(obj, resultSet.getTimestamp(column));
							} else if (field.getType().isAssignableFrom(Long.class)) {
								field.set(obj, resultSet.getLong(column));
							} else if (field.getType().isAssignableFrom(Short.class)) {
								field.set(obj, resultSet.getShort(column));
							}
						}
					} catch (SQLException e) {
						log.error(String.format(ErrorMessages.COLUMN_DOES_NOT_EXIST, column, e.getMessage()));
					} finally {
						field.setAccessible(false);
					}
				}
			}
		});

		return obj;
	}
}
