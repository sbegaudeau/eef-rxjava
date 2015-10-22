package org.eclipse.sirius.expression.dsl.scoping;

import java.util.Collection;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.resource.containers.IAllContainersState;
import org.eclipse.xtext.resource.containers.IContainerState;

@SuppressWarnings("all")
public class ExpressionDSLContainerState implements IContainerState {
  private String root;
  
  private IAllContainersState globalState;
  
  public ExpressionDSLContainerState(final String root, final IAllContainersState state) {
    this.root = root;
    this.globalState = state;
  }
  
  @Override
  public boolean contains(final URI uri) {
    Collection<URI> _contents = this.getContents();
    return _contents.contains(uri);
  }
  
  @Override
  public Collection<URI> getContents() {
    return this.globalState.getContainedURIs(this.root);
  }
  
  @Override
  public boolean isEmpty() {
    return this.globalState.isEmpty(this.root);
  }
  
  @Override
  public String toString() {
    return ((("container \'" + this.root) + "\' from ") + this.globalState);
  }
}
