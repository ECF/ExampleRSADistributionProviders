/*******************************************************************************
 * Copyright (c) 2016 Composent, Inc. and others. All rights reserved. This
 * program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Composent, Inc. - initial API and implementation
 ******************************************************************************/
package org.eclipse.ecf.example1.internal.provider.dist.server;

import java.util.Map;

import org.eclipse.ecf.core.ContainerTypeDescription;
import org.eclipse.ecf.core.IContainer;
import org.eclipse.ecf.core.identity.ID;
import org.eclipse.ecf.example1.provider.dist.common.ProviderConstants;
import org.eclipse.ecf.example1.provider.dist.common.Example1Namespace;
import org.eclipse.ecf.remoteservice.AbstractRSAContainer;
import org.eclipse.ecf.remoteservice.RSARemoteServiceContainerAdapter.RSARemoteServiceRegistration;
import org.eclipse.ecf.remoteservice.provider.IRemoteServiceDistributionProvider;
import org.eclipse.ecf.remoteservice.provider.RemoteServiceContainerInstantiator;
import org.eclipse.ecf.remoteservice.provider.RemoteServiceDistributionProvider;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {

	private static BundleContext context;

	public static final String SERVER_ID_PARAMETER = "id";
	public static final String SERVER_ID_PARAMETER_DEFAULT = "tcp://localhost:3333";

	static BundleContext getContext() {
		return context;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.
	 * BundleContext)
	 */
	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
		// register this remote service distribution provider
		context.registerService(IRemoteServiceDistributionProvider.class,
				new RemoteServiceDistributionProvider.Builder().setName(ProviderConstants.SERVER_PROVIDER_CONFIG_TYPE)
						.setInstantiator(new RemoteServiceContainerInstantiator(ProviderConstants.SERVER_PROVIDER_CONFIG_TYPE,
								ProviderConstants.CLIENT_PROVIDER_CONFIG_TYPE) {
							@Override
							public IContainer createInstance(ContainerTypeDescription description,
									Map<String, ?> parameters) {
								// Create and configure an instance of our server 
								// container type
								return new Example1ServerContainer(getIDParameterValue(Example1Namespace.INSTANCE, parameters,
										SERVER_ID_PARAMETER, SERVER_ID_PARAMETER_DEFAULT));
							}
						}).build(),
				null);
	}

	class Example1ServerContainer extends AbstractRSAContainer {

		public Example1ServerContainer(ID id) {
			super(id);
		}

		@Override
		protected Map<String, Object> registerEndpoint(RSARemoteServiceRegistration registration) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		protected void unregisterEndpoint(RSARemoteServiceRegistration registration) {
			// TODO Auto-generated method stub

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
	}

}
