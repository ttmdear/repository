// POST Request
// Let's look at a simple POST request where we build a RequestBody to send the
// parameters “username” and “password”:

@Test
public void whenSendPostRequest_thenCorrect()
  throws IOException {
    RequestBody formBody = new FormBody.Builder()
      .add("username", "test")
      .add("password", "test")
      .build();

    Request request = new Request.Builder()
      .url(BASE_URL + "/users")
      .post(formBody)
      .build();

    Call call = client.newCall(request);
    Response response = call.execute();

    assertThat(response.code(), equalTo(200));
}

// Our article A Quick Guide to Post Requests with OkHttp has more examples of
// POST requests with OkHttp.

// Upload a File
// in this example, we'll see how to upload a file. we’ll upload the “test.ext”
// file using multipartbody.builder:

@Test
public void whenUploadFile_thenCorrect() throws IOException {
    RequestBody requestBody = new MultipartBody.Builder()
      .setType(MultipartBody.FORM)
      .addFormDataPart("file", "file.txt",
        RequestBody.create(MediaType.parse("application/octet-stream"),
          new File("src/test/resources/test.txt")))
      .build();

    Request request = new Request.Builder()
      .url(BASE_URL + "/users/upload")
      .post(requestBody)
      .build();

    Call call = client.newCall(request);
    Response response = call.execute();

    assertThat(response.code(), equalTo(200));
}

// Get File Upload Progress
// Finally, let’s see how to get the progress of a File upload. We'll extend
// RequestBody to gain visibility into the upload process.  First, here’s the
// upload method:

@Test
public void whenGetUploadFileProgress_thenCorrect()
  throws IOException {
    RequestBody requestBody = new MultipartBody.Builder()
      .setType(MultipartBody.FORM)
      .addFormDataPart("file", "file.txt",
        RequestBody.create(MediaType.parse("application/octet-stream"),
          new File("src/test/resources/test.txt")))
      .build();

    ProgressRequestWrapper.ProgressListener listener
      = (bytesWritten, contentLength) -> {
        float percentage = 100f * bytesWritten / contentLength;
        assertFalse(Float.compare(percentage, 100) > 0);
    };

    ProgressRequestWrapper countingBody
      = new ProgressRequestWrapper(requestBody, listener);

    Request request = new Request.Builder()
      .url(BASE_URL + "/users/upload")
      .post(countingBody)
      .build();

    Call call = client.newCall(request);
    Response response = call.execute();

    assertThat(response.code(), equalTo(200));
}

// Here is the interface ProgressListener that enables us to observe the upload progress:

public interface ProgressListener {
    void onRequestProgress(long bytesWritten, long contentLength);
}

// Here is the ProgressRequestWrapper which is the extended version of RequestBody:

public class ProgressRequestWrapper extends RequestBody {

    @Override
    public void writeTo(BufferedSink sink) throws IOException {
        BufferedSink bufferedSink;

        countingSink = new CountingSink(sink);
        bufferedSink = Okio.buffer(countingSink);

        delegate.writeTo(bufferedSink);

        bufferedSink.flush();
    }
}

// Finally, here is the CountingSink which is the extended version of ForwardingSink :

protected class CountingSink extends ForwardingSink {

    private long bytesWritten = 0;

    public CountingSink(Sink delegate) {
        super(delegate);
    }

    @Override
    public void write(Buffer source, long byteCount)
      throws IOException {
        super.write(source, byteCount);

        bytesWritten += byteCount;
        listener.onRequestProgress(bytesWritten, contentLength());
    }
}

// When extending ForwardingSink to “CountingSink”, we are overriding the
// write() method to count the written (transferred) bytes When extending
// RequestBody to “ProgressRequestWrapper “, we are overriding the writeTo()
// method to use our “ForwardingSink”

// Setting a Custom Header

// Setting a Header on a Request To set any custom header on a Request we can
// use a simple addHeader call:

@Test
public void whenSetHeader_thenCorrect() throws IOException {
    Request request = new Request.Builder()
      .url(SAMPLE_URL)
      .addHeader("Content-Type", "application/json")
      .build();

    Call call = client.newCall(request);
    Response response = call.execute();
    response.close();
}
9.2. Setting a Default Header
In this example, we will see how to configure a default header on the Client itself, instead of setting it on each and every request.

// For example, if we want to set a content type “application/json” for every
// request we need to set an interceptor for our client. Here is the method:

@Test
public void whenSetDefaultHeader_thenCorrect()
  throws IOException {

    OkHttpClient client = new OkHttpClient.Builder()
      .addInterceptor(
        new DefaultContentTypeInterceptor("application/json"))
      .build();

    Request request = new Request.Builder()
      .url(SAMPLE_URL)
      .build();

    Call call = client.newCall(request);
    Response response = call.execute();
    response.close();
}

// And here is the DefaultContentTypeInterceptor which is the extended version of Interceptor:

public class DefaultContentTypeInterceptor implements Interceptor {

    public Response intercept(Interceptor.Chain chain)
      throws IOException {

        Request originalRequest = chain.request();
        Request requestWithUserAgent = originalRequest
          .newBuilder()
          .header("Content-Type", contentType)
          .build();

        return chain.proceed(requestWithUserAgent);
    }
}

// Note that the interceptor adds the header to the original request.

// Do Not Follow Redirects

// In this example, we'll see how to configure the OkHttpClient to stop
// following redirects.
//
// By default, if a GET request is answered with an HTTP 301 Moved Permanently
// the redirect is automatically followed. In some use cases, that may be
// perfectly fine, but there are certainly use cases where that’s not desired.
//
// To achieve this behavior, when we build our client, we need to set
// followRedirects to false.
//
// Note that the response will return an HTTP 301 status code:

@Test
public void whenSetFollowRedirects_thenNotRedirected()
  throws IOException {

    OkHttpClient client = new OkHttpClient().newBuilder()
      .followRedirects(false)
      .build();

    Request request = new Request.Builder()
      .url("http://t.co/I5YYd9tddw")
      .build();

    Call call = client.newCall(request);
    Response response = call.execute();

    assertThat(response.code(), equalTo(301));
}

// If we turn on the redirect with a true parameter (or remove it completely),
// the client will follow the redirection and the test will fail as the return
// code will be an HTTP 200.

// Timeouts

// Use timeouts to fail a call when its peer is unreachable. Network failures
// can be due to client connectivity problems, server availability problems, or
// anything between. OkHttp supports connect, read, and write timeouts.

// In this example, we built our client with a readTimeout of 1 seconds, while
// the URL is served with 2 seconds of delay:

@Test
public void whenSetRequestTimeout_thenFail()
  throws IOException {
    OkHttpClient client = new OkHttpClient.Builder()
      .readTimeout(1, TimeUnit.SECONDS)
      .build();

    Request request = new Request.Builder()
      .url(BASE_URL + "/delay/2")
      .build();

    Call call = client.newCall(request);
    Response response = call.execute();

    assertThat(response.code(), equalTo(200));
}

// Note as the test will fail as the client timeout is lower than the resource response time.

// Canceling a Call

// Use Call.cancel() to stop an ongoing call immediately. If a thread is
// currently writing a request or reading a response, an IOException will be
// thrown.
// Use this to conserve the network when a call is no longer necessary; for
// example when your user navigates away from an application:

@Test(expected = IOException.class)
public void whenCancelRequest_thenCorrect()
  throws IOException {
    ScheduledExecutorService executor
      = Executors.newScheduledThreadPool(1);

    Request request = new Request.Builder()
      .url(BASE_URL + "/delay/2")
      .build();

    int seconds = 1;
    long startNanos = System.nanoTime();

    Call call = client.newCall(request);

    executor.schedule(() -> {
        logger.debug("Canceling call: "
            + (System.nanoTime() - startNanos) / 1e9f);

        call.cancel();

        logger.debug("Canceled call: "
            + (System.nanoTime() - startNanos) / 1e9f);

    }, seconds, TimeUnit.SECONDS);

    logger.debug("Executing call: "
      + (System.nanoTime() - startNanos) / 1e9f);

    Response response = call.execute();

    logger.debug(Call was expected to fail, but completed: "
      + (System.nanoTime() - startNanos) / 1e9f, response);
}

// Response Caching
//
// To create a Cache, we'll need a cache directory that we can read and write
// to, and a limit on the cache's size.
// The client will use it to cache the response:

@Test
public void  whenSetResponseCache_thenCorrect()
  throws IOException {
    int cacheSize = 10 * 1024 * 1024;

    File cacheDirectory = new File("src/test/resources/cache");
    Cache cache = new Cache(cacheDirectory, cacheSize);

    OkHttpClient client = new OkHttpClient.Builder()
      .cache(cache)
      .build();

    Request request = new Request.Builder()
      .url("http://publicobject.com/helloworld.txt")
      .build();

    Response response1 = client.newCall(request).execute();
    logResponse(response1);

    Response response2 = client.newCall(request).execute();
    logResponse(response2);
}

// After launching the test, the response from the first call will not have
// been cached. A call to the method cacheResponse will return null, while a
// call to the method networkResponse will return the response from the
// network.
//
// Also, the cache folder will be filled with the cache files.
//
// The second call execution will produce the opposite effect, as the response
// will have already been cached. This means that a call to networkResponse
// will return null while a call to cacheResponse will return the response from
// the cache.
//
// To prevent a response from using the cache, use CacheControl.FORCE_NETWORK.
// To prevent it from using the network, use CacheControl.FORCE_CACHE.
//
// Be warned: if you use FORCE_CACHE and the response requires the network,
// OkHttp will return a 504 Unsatisfiable Request response.
