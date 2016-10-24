/*
 * Copyright 2016 Steve Jones. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 *
 *  http://aws.amazon.com/apache2.0
 *
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */
package com.github.sjones4.youcan.youdisco.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import com.amazonaws.internal.ListWithAutoConstructFlag;

/**
 *
 */
public class DiscoverServiceAccountsResult implements Serializable {
  private static final long serialVersionUID = 1L;

  private ListWithAutoConstructFlag<ServiceAccount> serviceAccounts;

  public List<ServiceAccount> getServiceAccounts() {
    if ( serviceAccounts == null) {
      serviceAccounts = new ListWithAutoConstructFlag<>();
      serviceAccounts.setAutoConstruct(true);
    }
    return serviceAccounts;
  }

  public void setServiceAccounts( Collection<ServiceAccount> serviceAccounts ) {
    if ( serviceAccounts == null) {
      this.serviceAccounts = null;
      return;
    }
    ListWithAutoConstructFlag<ServiceAccount> serviceAccountsCopy = new ListWithAutoConstructFlag<>( serviceAccounts.size());
    serviceAccountsCopy.addAll( serviceAccounts );
    this.serviceAccounts = serviceAccountsCopy;
  }

  public DiscoverServiceAccountsResult withServiceAccounts( ServiceAccount... serviceAccounts) {
    setServiceAccounts( Arrays.asList( serviceAccounts ) );
    return this;
  }

  public DiscoverServiceAccountsResult withServiceAccounts( Collection<ServiceAccount> serviceAccounts) {
    setServiceAccounts( serviceAccounts );
    return this;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if ( getServiceAccounts() != null) sb.append("ServiceAccounts: " + getServiceAccounts() );
    sb.append("}");
    return sb.toString();
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int hashCode = 1;

    hashCode = prime * hashCode + (( getServiceAccounts() == null) ? 0 : getServiceAccounts().hashCode());
    return hashCode;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;

    if (obj instanceof DiscoverServiceAccountsResult == false) return false;
    DiscoverServiceAccountsResult other = (DiscoverServiceAccountsResult)obj;

    if (other.getServiceAccounts() == null ^ this.getServiceAccounts() == null) return false;
    if (other.getServiceAccounts() != null && other.getServiceAccounts().equals(this.getServiceAccounts()) == false) return false;
    return true;
  }
}
