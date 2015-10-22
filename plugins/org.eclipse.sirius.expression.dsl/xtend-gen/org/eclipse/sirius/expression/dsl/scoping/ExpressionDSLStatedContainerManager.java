package org.eclipse.sirius.expression.dsl.scoping;

import org.eclipse.sirius.expression.dsl.scoping.ExpressionDSLContainerState;
import org.eclipse.sirius.expression.dsl.scoping.ExpressionDSLStateBasedContainer;
import org.eclipse.xtext.resource.IContainer;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.containers.FlatResourceSetBasedAllContainersState;
import org.eclipse.xtext.resource.containers.IAllContainersState;
import org.eclipse.xtext.resource.containers.StateBasedContainerManager;

@SuppressWarnings("all")
public class ExpressionDSLStatedContainerManager extends StateBasedContainerManager {
  @Override
  protected IContainer createContainer(final String handle, final IResourceDescriptions resourceDescriptions) {
    final IAllContainersState state = this.getState(resourceDescriptions);
    final ExpressionDSLContainerState containerState = new ExpressionDSLContainerState(handle, state);
    final ExpressionDSLStateBasedContainer result = new ExpressionDSLStateBasedContainer(resourceDescriptions, containerState);
    if ((state instanceof FlatResourceSetBasedAllContainersState)) {
      result.setUriToDescriptionCacheEnabled(false);
    }
    return result;
  }
}
