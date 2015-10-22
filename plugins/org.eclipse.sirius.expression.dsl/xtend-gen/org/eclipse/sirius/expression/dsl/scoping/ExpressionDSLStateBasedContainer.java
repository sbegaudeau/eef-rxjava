package org.eclipse.sirius.expression.dsl.scoping;

import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.containers.IContainerState;
import org.eclipse.xtext.resource.containers.StateBasedContainer;

@SuppressWarnings("all")
public class ExpressionDSLStateBasedContainer extends StateBasedContainer {
  public ExpressionDSLStateBasedContainer(final IResourceDescriptions descriptions, final IContainerState state) {
    super(descriptions, state);
  }
  
  @Override
  protected Iterable<IEObjectDescription> filterByURI(final Iterable<IEObjectDescription> unfiltered) {
    return unfiltered;
  }
}
