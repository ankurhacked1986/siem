package siem;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;
import org.json.JSONObject;

public class SiemPostProcessor implements Processor {

	public void process(Exchange exchange) throws Exception {
		
		Message in = exchange.getIn();
        String msg = in.getBody(String.class);
        JSONObject obj = new JSONObject(msg);
        exchange.getIn().setHeader("mito_incident_id", obj.get("data"));
        exchange.getIn().setHeader("success_code", obj.get("success"));
	}

}
