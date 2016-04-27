package com.cyril


import java.net.InetSocketAddress

import com.cyril.service.HelloServiceImpl
import com.twitter.finagle.builder.ServerBuilder
import com.twitter.finagle.thrift.ThriftServerFramedCodec
import com.twitter.finagle.tracing.{ServerTracingFilter, Trace}
import com.twitter.server.TwitterServer
import com.twitter.util.Await
import org.apache.thrift.protocol.TBinaryProtocol.Factory

import com.cyril.thriftscala.Hello


/**
  * Created by liaochangyu on 1/12/16.
  */
object Server extends TwitterServer {


  def main() {

    val processor = new HelloServiceImpl

    val service = new Hello.FinagledService(processor, new Factory())


    val port = 0
    val server = ServerBuilder().bindTo(new InetSocketAddress("10.2.24.239", port))
      .tracer(zipkinTracer)
      .codec(ThriftServerFramedCodec())
      .name("HelloService")
      .build(service)

    val forum = "zk!10.10.76.176:2281!/mux/calc!0"

    server.announce(forum)

    onExit {
      server.close()
    }

    Await.ready(server)

  }
}
