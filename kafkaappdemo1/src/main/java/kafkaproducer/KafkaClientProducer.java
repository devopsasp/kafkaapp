package kafkaproducer;
import java.util.Scanner;
import java.util.Properties;
import org.apache.kafka.clients.producer.*;
public class KafkaClientProducer {
	public KafkaClientProducer()
	{
		
		Properties properties =new Properties();
		properties.put("bootstrap.servers", "localhost:9092,localhost:9093");
		/*the key and value has to be serialized to be sent to console consumer*/
		properties.put("key.serializer","org.apache.kafka.common.serialization.StringSerializer");
		properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		KafkaProducer producer=new KafkaProducer(properties);
		while(true)
		{
			try {
				Scanner sc=new Scanner(System.in);
				System.out.println("enter key and value");
				String key=sc.nextLine();
				String value=sc.nextLine();
				ProducerRecord record=new ProducerRecord("myjavatopic1",key,value);
				producer.send(record);
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
	}

}
