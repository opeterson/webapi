# DefaultApi

All URIs are relative to *https://localhost:8080/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getServerStatus**](DefaultApi.md#getServerStatus) | **GET** /web/status | 



## getServerStatus

> ApiServerStatusResponse getServerStatus()



Gets the current status of the server.

### Example

```java
// Import classes:
import ca.owenpeterson.web.api.client.invoker.ApiClient;
import ca.owenpeterson.web.api.client.invoker.ApiException;
import ca.owenpeterson.web.api.client.invoker.Configuration;
import ca.owenpeterson.web.api.client.invoker.models.*;
import ca.owenpeterson.web.api.client.api.DefaultApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://localhost:8080/v1");

        DefaultApi apiInstance = new DefaultApi(defaultClient);
        try {
            ApiServerStatusResponse result = apiInstance.getServerStatus();
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling DefaultApi#getServerStatus");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters

This endpoint does not need any parameter.

### Return type

[**ApiServerStatusResponse**](ApiServerStatusResponse.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | the status of the server. |  -  |
| **0** | Default error payload |  -  |

