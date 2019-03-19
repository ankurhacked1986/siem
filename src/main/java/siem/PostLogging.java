package siem;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;

public class PostLogging implements Processor{

	public void process(Exchange exchange) throws Exception {
		Message in = exchange.getIn();
        String msg = in.getBody(String.class);
        System.out.println(msg);
		
	}

}
