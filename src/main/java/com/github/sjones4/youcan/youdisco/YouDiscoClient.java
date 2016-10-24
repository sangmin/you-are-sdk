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
package com.github.sjones4.youcan.youdisco;

import java.util.ArrayList;
import java.util.List;
import org.w3c.dom.Node;
import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.AmazonWebServiceClient;
import com.amazonaws.AmazonWebServiceRequest;
import com.amazonaws.ClientConfiguration;
import com.amazonaws.Request;
import com.amazonaws.Response;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AnonymousAWSCredentials;
import com.amazonaws.http.DefaultErrorResponseHandler;
import com.amazonaws.http.ExecutionContext;
import com.amazonaws.http.StaxResponseHandler;
import com.amazonaws.internal.StaticCredentialsProvider;
import com.amazonaws.transform.LegacyErrorUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.AWSRequestMetrics;
import com.github.sjones4.youcan.youdisco.model.DiscoverServiceAccountsRequest;
import com.github.sjones4.youcan.youdisco.model.DiscoverServiceAccountsResult;
import com.github.sjones4.youcan.youdisco.model.transform.DiscoverServiceAccountsRequestMarshaller;
import com.github.sjones4.youcan.youdisco.model.transform.DiscoverServiceAccountsResultStaxUnmarshaller;

/**
 *
 */
public class YouDiscoClient extends AmazonWebServiceClient implements YouDisco {

  private AWSCredentialsProvider awsCredentialsProvider;

  protected final List<Unmarshaller<AmazonServiceException, Node>> exceptionUnmarshallers = new ArrayList<>();

  public YouDiscoClient( ) {
    this( new ClientConfiguration( ) );
  }

  public YouDiscoClient( final ClientConfiguration clientConfiguration) {
    super( clientConfiguration );
    this.awsCredentialsProvider = new StaticCredentialsProvider( new AnonymousAWSCredentials( ) );
    init( );
  }

  private void init() {
    exceptionUnmarshallers.add(new LegacyErrorUnmarshaller());
    setEndpoint("http://localhost:8773/services/Discovery/");
  }

  private <X, Y extends AmazonWebServiceRequest> Response<X> invoke(
      final Request<Y> request,
      final Unmarshaller<X, StaxUnmarshallerContext> unmarshaller,
      final ExecutionContext executionContext
  ) {
    request.setEndpoint(endpoint);
    request.setTimeOffset(timeOffset);
    AmazonWebServiceRequest originalRequest = request.getOriginalRequest();

    AWSCredentials credentials = awsCredentialsProvider.getCredentials();
    if (originalRequest.getRequestCredentials() != null) {
      credentials = originalRequest.getRequestCredentials();
    }

    executionContext.setCredentials(credentials);

    StaxResponseHandler<X> responseHandler = new StaxResponseHandler<X>(unmarshaller);
    DefaultErrorResponseHandler errorResponseHandler = new DefaultErrorResponseHandler(exceptionUnmarshallers);
    return client.execute(request, responseHandler, errorResponseHandler, executionContext);
  }

  @Override
  public DiscoverServiceAccountsResult discoverServiceAccounts( ) throws AmazonClientException {
    return discoverServiceAccounts( new DiscoverServiceAccountsRequest( ) );
  }

  @Override
  public DiscoverServiceAccountsResult discoverServiceAccounts(
      final DiscoverServiceAccountsRequest discoverServiceAccountsRequest
  ) throws AmazonClientException {
    ExecutionContext executionContext = createExecutionContext(discoverServiceAccountsRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    Request<DiscoverServiceAccountsRequest> request = null;
    Response<DiscoverServiceAccountsResult> response = null;
    awsRequestMetrics.startEvent( AWSRequestMetrics.Field.ClientExecuteTime );
    try {
      request = new DiscoverServiceAccountsRequestMarshaller().marshall(discoverServiceAccountsRequest);
      // Binds the request metrics to the current request.
      request.setAWSRequestMetrics(awsRequestMetrics);
      response = invoke(request, new DiscoverServiceAccountsResultStaxUnmarshaller(), executionContext);
      return response.getAwsResponse();
    } finally {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
}
