package com.cyril


import com.cyril.service.HelloServiceImpl
import com.twitter.finagle.ThriftMux
import com.twitter.util.Await



/**
  * Created by liaochangyu on 1/12/16.
  */
object Server extends App {

  val forum = "zk!10.10.76.176:2281!/mux/calc!0"
  val server = ThriftMux.serveIface(":*", new HelloServiceImpl)
  server.announce(forum)
  Await.ready(server)

}
