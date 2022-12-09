/*
 * Copyright (c) peter.braun@fhws.de
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package de.fhws.fiw.fds.sutton.client.utils;

import org.apache.commons.codec.binary.Base64;

public class HttpBasicAuthentication implements Authentication {
	private final String principal;

	private final String password;

	public HttpBasicAuthentication(final String principal, final String password) {
		this.principal = principal;
		this.password = password;
	}

	@Override
	public String authenticationHeader() {
		return "Basic " + codedCredentials();
	}

	private String codedCredentials() {
		final String credentials = this.principal + ":" + this.password;
		return Base64.encodeBase64String(credentials.getBytes());
	}
}