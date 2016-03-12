package org.eclipse.ecf.example1.internal.provider.dist.server;

import java.util.Map;

import org.eclipse.ecf.core.identity.ID;
import org.eclipse.ecf.remoteservice.AbstractRSAContainer;
import org.eclipse.ecf.remoteservice.RSARemoteServiceContainerAdapter.RSARemoteServiceRegistration;

/**
 * Instances of this class are created via the container instantiator specified
 * by the RemoteServiceDistributionProvider whiteboard service in the Activator.
 * @see Activator#start(org.osgi.framework.BundleContext)
 * 
 */
public class Example1ServerContainer extends AbstractRSAContainer {

	/**
	 * Create an Example1ServerContainer.  The given id must not be null,
	 * and should be created using the Example1Namespace.  The server's ID
	 * will then be automatically used to provide the ecf.endpoint.id to
	 * remote service clients via the RSA-created EndpointDescription.
	 * @param id
	 */
	public Example1ServerContainer(ID id) {
		super(id);
	}

	 
	@Override
	/**
	 * When the ECF RSA impl is requested to export a remote service and 
	 * this container instance is selected, a remote service registration will be
	 * created by RSA and this method will then be called to actually export the given
	 * registration via some communications transport.  This should trigger the appropriate 
	 * networking initialization (e.g. opening listener on socket), given the info in the
	 * registration.
	 * The given registration will not be <code>null</code>.
	 * If the transport would like to insert properties into the EndpointDescription
	 * for this endpoint, a Map of name (String) -> Object map should be returned.  All
	 * the values in the Map should be Serializable.   This provides a mechanism for
	 * distribution providers to include arbitrary private properties for use by 
	 * clients.
	 * 
	 * Note that keys for the Map should be unique to avoid conflicting with any other properties.
	 * 
	 * If values are provided for either OSGI RemoteConstants or ECF Remote Services Constants
	 * then these new values will <b>override</b> the default values in the EndpointDescription.
	 *
	 */
	protected Map<String, Object> exportRemoteService(RSARemoteServiceRegistration registration) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	/**
	 * When this remote service is unregistered, this method will be called by ECF RSA
	 * to allow the underlying transport to unregister the remote service given
	 * by the registration.  Necessary clean-up/shutdown of transport should be completed
	 * before returning.
	 */
	protected void unexportRemoteService(RSARemoteServiceRegistration registration) {
		// TODO Auto-generated method stub
	}
}