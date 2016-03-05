package org.eclipse.ecf.example1.internal.provider.dist.client;

import org.eclipse.ecf.core.util.ECFException;
import org.eclipse.ecf.example1.provider.dist.common.Example1Namespace;
import org.eclipse.ecf.remoteservice.IRemoteService;
import org.eclipse.ecf.remoteservice.client.AbstractRSAClientContainer;
import org.eclipse.ecf.remoteservice.client.AbstractRSAClientService;
import org.eclipse.ecf.remoteservice.client.RemoteServiceClientRegistration;

public class Example1ClientContainer extends AbstractRSAClientContainer {

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