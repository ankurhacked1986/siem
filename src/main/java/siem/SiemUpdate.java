package siem;

import java.util.Map;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;
import org.json.JSONObject;

public class SiemUpdate implements Processor{

	public void process(Exchange exchange) throws Exception {
		@SuppressWarnings("unchecked")
		Map<String, String> row = exchange.getIn().getBody(Map.class);
        exchange.getIn().setHeader("mito_inc", row.get("mito_incident_id"));
        exchange.getIn().setHeader("new_status", row.get("status"));
		exchange.getIn().setBody("");
	}

}
