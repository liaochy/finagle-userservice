package com

import com.twitter.finagle.zipkin.thrift.ZipkinTracer
import com.twitter.finagle.stats.DefaultStatsReceiver

/**
  * Created by liaochangyu on 3/28/16.
  */
package object cyril {
  val zipkinTracer = ZipkinTracer.mk(host = "10.16.12.137", port = 1463,statsReceiver=DefaultStatsReceiver, sampleRate = 1.0f)
}
