import java.util.Properties;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

public class Producer {

  public static void main(String[] args) {
    Properties configs = new Properties();
    configs.put("bootstrap.servers", "localhost:9092");
    configs.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
    configs.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");

    KafkaProducer<String, String> producer = new KafkaProducer<>(configs);

    ProducerRecord<String, String> record = new ProducerRecord<>("click_log",
        "login"
    );

    producer.send(record);

    producer.close();
  }
}
