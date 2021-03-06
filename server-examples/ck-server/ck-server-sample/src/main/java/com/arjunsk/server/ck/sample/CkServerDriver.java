package com.arjunsk.server.ck.sample;

import com.arjunsk.server.ck.CkHttpServer;
import com.arjunsk.server.ck.enums.HttpMethod;
import com.arjunsk.server.ck.sample.handlers.EchoGetHandler;
import com.arjunsk.server.ck.sample.handlers.EchoHeaderHandler;
import com.arjunsk.server.ck.sample.handlers.EchoPostHandler;
import com.arjunsk.server.ck.sample.handlers.RootHandler;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

public class CkServerDriver {

  public static void main(String[] args) {
    int port = 8080;
    CkHttpServer server = new CkHttpServer(new InetSocketAddress(port));

    server.addHandler("/", HttpMethod.GET, new RootHandler());
    server.addHandler("/echoHeader", HttpMethod.GET, new EchoHeaderHandler());
    server.addHandler("/echoGet", HttpMethod.GET, new EchoGetHandler());
    server.addHandler("/echoPost", HttpMethod.POST, new EchoPostHandler());

    server.setExecutor(Executors.newCachedThreadPool());

    server.start();
  }
}
