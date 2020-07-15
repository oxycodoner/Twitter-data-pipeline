import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.spark.SparkConf
import org.apache.spark.streaming.kafka010.{ConsumerStrategies, KafkaUtils, LocationStrategies}
import org.apache.spark.streaming.{Seconds, StreamingContext}
import org.apache.kafka.common.serialization.StringDeserializer


case class Event(event_name: String, event_id: Long, time: Long)
case class GroupTopic(urlkey: String, topic_name: String)
case class Group(group_topics: List[GroupTopic], group_city: String, group_country: String,
                 group_id: Long, group_name: String, group_state: String)
case class Member(member_id: Long, member_name: String)
case class Venue(venue_name: String, lon: Double, lat: Double, venue_id: Long)
case class Message(venue: Venue, visibility: String, response: String, guests: Long,
                   member: Member, rsvp_id: Long, mtime: Long, event: Event,
                   group: Group)

object Test {
  def main(args: Array[String]) {
    System.setProperty("hadoop.home.dir", "C:\\winutil\\")

    val brokers = "kafkaserver:9092"
    val groupid = "GRP1"
    val topics = "data_test"

    val sparkConf = new SparkConf()
      .setMaster("local[*]")
      .setAppName("TestStreaming")

    val ssc = new StreamingContext(sparkConf, Seconds(5))

    val sc = ssc.sparkContext
    sc.setLogLevel("OFF")

    val kafkaParam = Map[String, Object](
      ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG -> brokers,
      ConsumerConfig.GROUP_ID_CONFIG -> groupid,
      ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG -> classOf[StringDeserializer],
      ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG -> classOf[StringDeserializer]
    )

    val topicSet = Array("data_test")

    val messages = KafkaUtils.createDirectStream[String, String](
      ssc, LocationStrategies.PreferConsistent, ConsumerStrategies.Subscribe[String, String](
        topicSet, kafkaParam
      )
    )

    messages.map(record=>(record.value().toString)).print

    ssc.start()
    ssc.awaitTermination()
  }
}
