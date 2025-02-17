/**
 * Copyright 2017 Yahoo Inc. Licensed under the Apache License, Version 2.0
 * See accompanying LICENSE file.
 */
package kafka.manager.model

import org.scalatest.FunSuite

/**
  * @author fuji-151a
  */
class KafkaVersionTest extends FunSuite {

  private val kafkaVersionMap: Map[String, KafkaVersion] = Map(
    "0.8.1.1" -> Kafka_0_8_1_1,
    "0.8.2-beta" -> Kafka_0_8_2_0,
    "0.8.2.0" -> Kafka_0_8_2_0,
    "0.8.2.1" -> Kafka_0_8_2_1,
    "0.8.2.2" -> Kafka_0_8_2_2,
    "0.9.0.0" -> Kafka_0_9_0_0,
    "0.9.0.1" -> Kafka_0_9_0_1,
    "0.10.0.0" -> Kafka_0_10_0_0,
    "0.10.0.1" -> Kafka_0_10_0_1,
    "0.10.1.0" -> Kafka_0_10_1_0,
    "0.10.1.1" -> Kafka_0_10_1_1,
    "0.10.2.0" -> Kafka_0_10_2_0,
    "0.10.2.1" -> Kafka_0_10_2_1,
    "0.11.0.0" -> Kafka_0_11_0_0,
    "0.11.0.2" -> Kafka_0_11_0_2,
    "1.0.0" -> Kafka_1_0_0,
    "1.0.1" -> Kafka_1_0_1,
    "1.1.0" -> Kafka_1_1_0,
    "1.1.1" -> Kafka_1_1_1,
    "2.0.0" -> Kafka_2_0_0,
    "2.1.0" -> Kafka_2_1_0,
    "2.1.1" -> Kafka_2_1_1,
    "2.2.0" -> Kafka_2_2_0,
    "2.2.1" -> Kafka_2_2_1,
    "2.2.2" -> Kafka_2_2_2,
    "2.3.0" -> Kafka_2_3_0,
    "2.3.1" -> Kafka_2_3_1,
    "2.4.0" -> Kafka_2_4_0,
    "2.4.1" -> Kafka_2_4_1,
    "2.5.0" -> Kafka_2_5_0,
    "2.5.1" -> Kafka_2_5_1,
    "2.6.0" -> Kafka_2_6_0,
    "2.7.0" -> Kafka_2_7_0,
    "2.8.0" -> Kafka_2_8_0,
    "2.8.1" -> Kafka_2_8_1,
    "3.0.0" -> Kafka_3_0_0,
    "3.1.0" -> Kafka_3_1_0,
    "3.1.1" -> Kafka_3_1_1,
    "3.2.0" -> Kafka_3_2_0,
    "3.3.0" -> Kafka_3_3_0
  )

  test("apply method: supported version.") {
    kafkaVersionMap.foreach(v => assertResult(v._2)(KafkaVersion(v._1)))
  }

  test("apply method: Not supported version.") {
    val expected: String = "0.7.0.0"
    intercept[IllegalArgumentException] {
      KafkaVersion(expected)
    }
  }

  test("check supportedVersions") {
    assertResult(kafkaVersionMap)(KafkaVersion.supportedVersions)
  }

  test("Sort formSelectList") {
    val expected: IndexedSeq[(String,String)] = Vector(
      ("0.8.1.1","0.8.1.1"),
      ("0.8.2.0","0.8.2.0"),
      ("0.8.2.1","0.8.2.1"),
      ("0.8.2.2","0.8.2.2"),
      ("0.9.0.0","0.9.0.0"),
      ("0.9.0.1","0.9.0.1"),
      ("0.10.0.0","0.10.0.0"),
      ("0.10.0.1","0.10.0.1"),
      ("0.10.1.0","0.10.1.0"),
      ("0.10.1.1","0.10.1.1"),
      ("0.10.2.0","0.10.2.0"),
      ("0.10.2.1","0.10.2.1"),
      ("0.11.0.0","0.11.0.0"),
      ("0.11.0.2","0.11.0.2"),
      ("1.0.0","1.0.0"),
      ("1.0.1","1.0.1"),
      ("1.1.0","1.1.0"),
      ("1.1.1","1.1.1"),
      ("2.0.0","2.0.0"),
      ("2.1.0","2.1.0"),
      ("2.1.1","2.1.1"),
      ("2.2.0","2.2.0"),
      ("2.2.1","2.2.1"),
      ("2.2.2","2.2.2"),
      ("2.3.0","2.3.0"),
      ("2.3.1","2.3.1"),
      ("2.4.0","2.4.0"),
      ("2.4.1","2.4.1"),
      ("2.5.0","2.5.0"),
      ("2.5.1","2.5.1"),
      ("2.6.0","2.6.0"),
      ("2.7.0","2.7.0"),
      ("2.8.0","2.8.0"),
      ("2.8.1","2.8.1"),
      ("3.0.0","3.0.0"),
      ("3.1.0","3.1.0"),
      ("3.1.1","3.1.1"),
      ("3.2.0","3.2.0"),
      ("3.3.0","3.3.0")
    )
    assertResult(expected)(KafkaVersion.formSelectList)
  }

  test("unapply") {
    kafkaVersionMap.filterNot(_._1.contains("beta")).foreach(v => assertResult(Some(v._1))(KafkaVersion.unapply(v._2)))
  }
}
