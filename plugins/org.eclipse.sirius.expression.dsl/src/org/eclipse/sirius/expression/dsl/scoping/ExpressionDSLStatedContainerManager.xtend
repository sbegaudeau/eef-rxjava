package org.eclipse.sirius.expression.dsl.scoping

import org.eclipse.xtext.resource.IResourceDescriptions
import org.eclipse.xtext.resource.containers.FlatResourceSetBasedAllContainersState
import org.eclipse.xtext.resource.containers.StateBasedContainerManager

class ExpressionDSLStatedContainerManager extends StateBasedContainerManager {	
	
	override protected createContainer(String handle, IResourceDescriptions resourceDescriptions) {
		val state = getState(resourceDescriptions);
		val containerState = new ExpressionDSLContainerState(handle, state);
		val result = new ExpressionDSLStateBasedContainer(resourceDescriptions, containerState);
		if (state instanceof FlatResourceSetBasedAllContainersState)
			result.setUriToDescriptionCacheEnabled(false);
		return result;
	}
	
}

