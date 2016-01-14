/**
 * The contents of this file are subject to the OpenMRS Public License
 * Version 1.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 * http://license.openmrs.org
 *
 * Software distributed under the License is distributed on an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * License for the specific language governing rights and limitations
 * under the License.
 *
 * Copyright (C) OpenMRS, LLC.  All Rights Reserved.
 */
package org.openmrs.module.chuong.api;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.openmrs.api.context.Context;
import org.openmrs.module.chuong.chuongModel;
import org.openmrs.test.BaseModuleContextSensitiveTest;

/**
 * Tests {@link ${chuongServiceService}}.
 */
public class  chuongServiceServiceTest extends BaseModuleContextSensitiveTest {

	protected static chuongServiceService chuongService = null;

	protected static final String PROGRAM_TEST_OUTCOMES =
			"src/test/resources/chuongModel.xml";

	@Before
	public void runBeforeAllTests() throws Exception {
		if (chuongService ==null) {
			chuongService = Context.getService(chuongServiceService.class);
		}
		executeDataSet(PROGRAM_TEST_OUTCOMES );

	}

	/*
	This test is running for service class testing to check if the context of class is available in Spring context
	 */
	@Test
	public void shouldSetupContext() {
		assertNotNull(Context.getService(chuongServiceService.class));
	}

	/*
	This test is running for model testing
	 */
	@Test
	public void shouldReturnFriendName(){
		chuongModel object = new chuongModel();
		object.setFriend("sagar");

		assertEquals("Can return Friend's Name", object.getFriend(), "sagar");
	}

	@Test
	public void shouldReturnFriendName_FromDB(){
		assertEquals("Can return Friend's Name as chuong", chuongService.getAllFriend().get(0).getFriend(), "chuong");
	}
}
