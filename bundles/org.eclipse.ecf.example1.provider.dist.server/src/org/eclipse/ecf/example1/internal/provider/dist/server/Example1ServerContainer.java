package org.eclipse.ecf.example1.internal.provider.dist.server;

import java.util.Map;

import org.eclipse.ecf.core.identity.ID;
import org.eclipse.ecf.remoteservice.AbstractRSAContainer;
import org.eclipse.ecf.remoteservice.RSARemoteServiceContainerAdapter.RSARemoteServiceRegistration;

public class Example1ServerContainer extends AbstractRSAContainer {

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