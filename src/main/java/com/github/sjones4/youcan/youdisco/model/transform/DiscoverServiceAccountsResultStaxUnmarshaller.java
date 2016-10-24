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
package com.github.sjones4.youcan.youdisco.model.transform;

import javax.xml.stream.events.XMLEvent;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;
import com.github.sjones4.youcan.youdisco.model.DiscoverServiceAccountsResult;

/**
 *
 */
public class DiscoverServiceAccountsResultStaxUnmarshaller implements Unmarshaller<DiscoverServiceAccountsResult, StaxUnmarshallerContext> {

  public DiscoverServiceAccountsResult unmarshall(StaxUnmarshallerContext context) throws Exception {
    DiscoverServiceAccountsResult discoverServiceAccountsResult = new DiscoverServiceAccountsResult();
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 2;


    if (context.isStartOfDocument()) targetDepth += 1;

    while (true) {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) return discoverServiceAccountsResult;

      if (xmlEvent.isAttribute() || xmlEvent.isStartElement()) {
        if (context.testExpression("ServiceAccounts/member", targetDepth)) {
          discoverServiceAccountsResult.getServiceAccounts().add( ServiceAccountStaxUnmarshaller.getInstance().unmarshall(context));
          continue;
        }
      } else if (xmlEvent.isEndElement()) {
        if (context.getCurrentDepth() < originalDepth) {
          return discoverServiceAccountsResult;
        }
      }
    }
  }

  private static DiscoverServiceAccountsResultStaxUnmarshaller instance = new DiscoverServiceAccountsResultStaxUnmarshaller();
  public static DiscoverServiceAccountsResultStaxUnmarshaller getInstance() {
    return instance;
  }
}
