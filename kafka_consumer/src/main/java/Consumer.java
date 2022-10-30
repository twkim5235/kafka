import java.util.Arrays;
import java.util.Properties;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.protocol.types.Field.Array;
import org.apache.kafka.common.protocol.types.Field.Str;

public class Consumer {

  public static void main(String[] args) {
    Properties configs = new Properties();
    configs.put("bootstrap.servers", "localhost:9092");
    configs.put("group.id", "click_log_group");
    configs.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
    configs.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");

    KafkaConsumer<String, String> consumer = new KafkaConsumer<>(configs);

    consumer.subscribe(Arrays.asList("click_log"));

    while (true) {
      ConsumerRecords<String, String> records = consumer.poll(500);
      records.forEach(
          record -> System.out.println(record.value())
      );
    }

  }

}
