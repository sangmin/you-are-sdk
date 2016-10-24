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

/**
 *
 */
public class ServiceAccount implements Serializable {
  private static final long serialVersionUID = 1L;

  private String alias;
  private String account;
  private String canonicalId;

  public String getAlias( ) {
    return alias;
  }

  public void setAlias( final String alias ) {
    this.alias = alias;
  }

  public String getAccount( ) {
    return account;
  }

  public void setAccount( final String account ) {
    this.account = account;
  }

  public String getCanonicalId( ) {
    return canonicalId;
  }

  public void setCanonicalId( final String canonicalId ) {
    this.canonicalId = canonicalId;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getAlias() != null) sb.append("Alias: " + getAlias() + ",");
    if (getAccount() != null) sb.append("Account: " + getAccount() + ",");
    if (getCanonicalId() != null) sb.append("CanonicalId: " + getCanonicalId() + ",");
    sb.append("}");
    return sb.toString();
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int hashCode = 1;

    hashCode = prime * hashCode + ((getAlias() == null) ? 0 : getAlias().hashCode());
    hashCode = prime * hashCode + ((getAccount() == null) ? 0 : getAccount().hashCode());
    hashCode = prime * hashCode + ((getCanonicalId() == null) ? 0 : getCanonicalId().hashCode());
    return hashCode;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;

    if (obj instanceof ServiceAccount == false) return false;
    ServiceAccount other = (ServiceAccount)obj;

    if (other.getAlias() == null ^ this.getAlias() == null) return false;
    if (other.getAlias() != null && other.getAlias().equals(this.getAlias()) == false) return false;
    if (other.getAccount() == null ^ this.getAccount() == null) return false;
    if (other.getAccount() != null && other.getAccount().equals(this.getAccount()) == false) return false;
    if (other.getCanonicalId() == null ^ this.getCanonicalId() == null) return false;
    if (other.getCanonicalId() != null && other.getCanonicalId().equals(this.getCanonicalId()) == false) return false;
    return true;
  }
}
