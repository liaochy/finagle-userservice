package com.cyril.service
import com.cyril.thriftscala.Hello
import com.twitter.util.Future

/**
  * Created by liaochangyu on 1/13/16.
  */
class HelloServiceImpl extends Hello.FutureIface {

  val name:String = java.lang.management.ManagementFactory.getRuntimeMXBean().getName();
  def hi(): Future[String]={

    print(name)
    Future.value(name)
  }
}
