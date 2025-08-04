/*
 * Copyright (c) 2025, WSO2 LLC. (http://www.wso2.com).
 *
 * WSO2 LLC. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.wso2.identity.webhook.common.event.handler.api.util;

import org.mockito.MockitoAnnotations;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.wso2.identity.webhook.common.event.handler.internal.util.EventHookHandlerUtils;
import org.wso2.identity.webhook.common.event.handler.util.TestUtils;

import static org.testng.Assert.assertEquals;
import static org.wso2.identity.webhook.common.event.handler.util.TestUtils.closeMockedServiceURLBuilder;

/**
 * Unit test class for EventPayloadUtils.
 */
public class EventPayloadUtilsTest {

    @BeforeClass
    public void setup() {

        MockitoAnnotations.openMocks(this);
    }

    @AfterMethod
    public void tearDown() {

        TestUtils.closeMockedServiceURLBuilder();
        TestUtils.closeMockedIdentityTenantUtil();
    }

    @Test
    public void constructFullURLWithEndpointReturnsCorrectURL() {

        String endpoint = "/api/events";
        String expectedURL = "https://localhost:9443/api/events";

        TestUtils.mockServiceURLBuilder();
        String fullURL = constructFullURLWithEndpoint(endpoint);
        assertEquals(fullURL, expectedURL, "Full URL should be correctly constructed.");
        closeMockedServiceURLBuilder();
    }

    @Test
    public void constructFullURLWithEndpointHandlesEmptyEndpoint() {

        String endpoint = "";
        String expectedURL = "https://localhost:9443";

        TestUtils.mockServiceURLBuilder();
        String fullURL = constructFullURLWithEndpoint(endpoint);
        assertEquals(fullURL, expectedURL, "Full URL should handle empty endpoint correctly.");
        closeMockedServiceURLBuilder();
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void constructFullURLWithEndpointThrowsExceptionForNullEndpoint() {

        TestUtils.mockServiceURLBuilder();
        constructFullURLWithEndpoint(null);
        closeMockedServiceURLBuilder();
    }

    private static String constructFullURLWithEndpoint(String endpoint) {

        if (endpoint == null) {
            throw new IllegalArgumentException("Endpoint cannot be null.");
        }
        endpoint = EventHookHandlerUtils.constructBaseURL() + endpoint;
        return endpoint;
    }
}
