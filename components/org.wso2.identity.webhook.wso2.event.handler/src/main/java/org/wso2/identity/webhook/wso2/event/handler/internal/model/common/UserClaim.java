/*
 * Copyright (c) 2024-2025, WSO2 LLC. (http://www.wso2.com).
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

package org.wso2.identity.webhook.wso2.event.handler.internal.model.common;

/**
 * User claim class.
 */
public class UserClaim {

    private String uri;
    private Object value;

    public UserClaim(Builder builder) {

        this.uri = builder.uri;
        this.value = builder.value;
    }

    public String getUri() {

        return uri;
    }

    public Object getValue() {

        return value;
    }

    public static class Builder {

        private String uri;
        private Object value;

        public Builder uri(String uri) {

            this.uri = uri;
            return this;
        }

        public Builder value(String value) {

            this.value = value;
            return this;
        }

        public Builder value(String[] value) {

            this.value = value;
            return this;
        }

        public UserClaim build() {

            return new UserClaim(this);
        }
    }
}
