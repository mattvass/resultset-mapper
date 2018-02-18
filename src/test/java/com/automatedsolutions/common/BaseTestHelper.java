package com.automatedsolutions.common;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * 
 * @author Matthew Vass Created: February 17, 2018
 *
 */
@RunWith(MockitoJUnitRunner.class)
public abstract class BaseTestHelper {
	protected final static String FEATURE_LOCATION = "features";

	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}
}
