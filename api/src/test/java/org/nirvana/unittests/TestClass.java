package org.nirvana.unittests;

import org.nirvana.pub.client.ServiceClient;
import org.nirvana.unittests.server.SelfHostServer;
import com.squareup.okhttp.ResponseBody;
import lombok.Cleanup;
import org.junit.Test;
import retrofit.Response;

import java.io.IOException;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.setMaxLengthForSingleLineDescription;


public class TestClass extends TestBase {
    @Test
    public void test_server_starts() throws IOException {
        @Cleanup SelfHostServer selfHostServer = new SelfHostServer(Collections.emptyList());

        selfHostServer.start();

        ServiceClient client = ServiceClient.createClient(selfHostServer.getBaseUri().toString());

        Response<ResponseBody> foo = client.ping("foo").execute();

        assertThat(foo.body().string()).contains("foo");
    }
}
