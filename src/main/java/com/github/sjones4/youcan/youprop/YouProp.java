/*
 * Copyright 2013 Steve Jones. All Rights Reserved.
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
package com.github.sjones4.youcan.youprop;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.github.sjones4.youcan.youprop.model.DescribePropertiesRequest;
import com.github.sjones4.youcan.youprop.model.DescribePropertiesResult;
import com.github.sjones4.youcan.youprop.model.ModifyPropertyValueRequest;
import com.github.sjones4.youcan.youprop.model.ModifyPropertyValueResult;

/**
 *
 */
public interface YouProp {

  DescribePropertiesResult describeProperties( ) throws AmazonServiceException, AmazonClientException;

  DescribePropertiesResult describeProperties( DescribePropertiesRequest describePropertiesRequest ) throws AmazonServiceException, AmazonClientException;

  ModifyPropertyValueResult modifyPropertyValue( ModifyPropertyValueRequest modifyPropertyRequest ) throws AmazonServiceException, AmazonClientException;
}
