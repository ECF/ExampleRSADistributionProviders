/*******************************************************************************
 * Copyright (c) 2016 Composent, Inc. and others. All rights reserved. This
 * program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Composent, Inc. - initial API and implementation
 ******************************************************************************/
package org.eclipse.ecf.example1.internal.provider.dist.client;

import java.util.Map;

import org.eclipse.ecf.core.ContainerTypeDescription;
import org.eclipse.ecf.core.IContainer;
import org.eclipse.ecf.core.util.ECFException;
import org.eclipse.ecf.example1.provider.dist.common.Example1Namespace;
import org.eclipse.ecf.example1.provider.dist.common.ProviderConstants;
import org.eclipse.ecf.remoteservice.IRemoteService;
import org.eclipse.ecf.remoteservice.client.AbstractRSAClientContainer;
import org.eclipse.ecf.remoteservice.client.AbstractRSAClientService;
import org.eclipse.ecf.remoteservice.client.RemoteServiceClientRegistration;
import org.eclipse.ecf.remoteservice.provider.IRemoteServiceDistributionProvider;
import org.eclipse.ecf.remoteservice.provider.RemoteServiceContainerInstantiator;
import org.eclipse.ecf.remoteservice.provider.RemoteServiceDistributionProvider;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {

	private static BundleContext context;

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
				new RemoteServiceDistributionProvider.Builder().setName(ProviderConstants.CLIENT_PROVIDER_CONFIG_TYPE)
						.setInstantiator(
								new RemoteServiceContainerInstantiator(ProviderConstants.SERVER_PROVIDER_CONFIG_TYPE,
										ProviderConstants.CLIENT_PROVIDER_CONFIG_TYPE) {
									@Override
									public IContainer createInstance(ContainerTypeDescription description,
											Map<String, ?> parameters) {
										// Create and configure an instance of our client
										// container type (below)
										// This is called by RSA when a client container of this type
										// is needed (e.g. to import a discovered remote service)
										return new Example1ClientContainer();
									}
								})
						.build(),
				null);
	}

	class Example1ClientContainer extends AbstractRSAClientContainer {

		public Example1ClientContainer() {
			super(Example1Namespace.INSTANCE
					.createInstance(new Object[] { "uuid:" + java.util.UUID.randomUUID().toString() }));
		}

		@Override
		// This is called when when a remote service instance is actually needed by consumers
		// The remote service getProxy method will be called the first time the proxy is 
		// to be created for a given consumer
		protected IRemoteService createRemoteService(RemoteServiceClientRegistration registration) {
			return new AbstractRSAClientService(this, registration) {

				@Override
				public Object getProxy(ClassLoader cl, @SuppressWarnings("rawtypes") Class[] interfaces) throws ECFException {
					return super.getProxy(cl, interfaces);
				}
				
				@Override
				protected Object invokeAsync(RSARemoteCall remoteCall) throws ECFException {
					// TODO Auto-generated method stub
					return null;
				}
				// invokeSync will be called when a client needs to make a remote call on 
				// one of the proxy methods.
				@Override
				protected Object invokeSync(RSARemoteCall remoteCall) throws ECFException {
					// TODO Auto-generated method stub
					return null;
				}
			};
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
