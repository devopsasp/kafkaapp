package kafkaconsumer;
import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
public class KafkaConsumerClent {
	public static void main(String[] args)
	{
		
		String topic="myjavatopic1";
		String group="group1";
		Properties properties=new Properties();
		properties.put("bootstrap.servers", "localhost:9092,localhost:9093");
		properties.put("group.id",group);
		properties.put("enable.auto.commit", "true");
		properties.put("auto.commit.interval.ms","1000" );
		properties.put("session.timeout.ms", "300000");
		properties.put("key.deserializer","org.apache.kafka.common.serialization.StringDeserializer");
		properties.put("value.deserializer","org.apache.kafka.common.serialization.StringDeserializer");
		
		KafkaConsumer <String,String> consumer=new KafkaConsumer(properties);
		
		consumer.subscribe(Arrays.asList(topic));
		
		while(true)
		{
			ConsumerRecords<String ,String> record=consumer.poll(100);
			for(ConsumerRecord r:record)
			{
				System.out.println(r.offset());
				System.out.println(r.key());
				System.out.println(r.value());
			}
			
		}
		
	}

}
