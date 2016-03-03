/*******************************************************************************
 * Copyright (c) 2016 Composent, Inc. and others. All rights reserved. This
 * program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Composent, Inc. - initial API and implementation
 ******************************************************************************/
package org.eclipse.ecf.example1.provider.dist.common;

import org.eclipse.ecf.core.identity.URIID.URIIDNamespace;

public class Example1Namespace extends URIIDNamespace {

	private static final long serialVersionUID = 2460015768559081873L;

	public static final String NAME = "ecf.example1.namespace";
	public static final String SCHEME = "ecf.example1";
	public static Example1Namespace INSTANCE;
	
	public Example1Namespace() {
		super(NAME, "Example 1 Namespace");
		INSTANCE = this;
	}

	@Override
	public String getScheme() {
		return SCHEME;
	}
}
