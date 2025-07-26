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

package org.wso2.identity.webhook.common.event.handler.api.service;

import org.wso2.identity.webhook.common.event.handler.api.model.EventMetadata;

/**
 * This interface is responsible for managing the event profile.
 */
public interface EventProfileManager {

    /**
     * Resolves the event URI for the given event.
     *
     * @param event The event for which the URI needs to be resolved.
     * @return Event metadata containing the profile, channel and event information.
     */
    EventMetadata resolveEventMetadata(String event);
}
