package siem;

import java.util.Map;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;
import org.json.JSONObject;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

public class Logging implements Processor {

	public void process(Exchange exchange) throws Exception {
		Message in = exchange.getIn();
        String msg = in.getBody(String.class);
        String description = null;
        int id = 0;
        int severity = 0;
        String requestType = "incident";
        String status = "NEW";
        String submitter = "siem";
        int priority = 0;
        ObjectMapper mapper = new ObjectMapper();
        
        try {
        	
        	@SuppressWarnings("unchecked")
			Map<String, Object> row = exchange.getIn().getBody(Map.class);
        	description = (String) row.get("description");
        	id = (Integer) row.get("id");
        	severity = (Integer) row.get("severity");
        	
        	if(severity == 7 || severity == 8)
        		priority = 1;
        	else
        		priority = 2;
        	
        	SiemMapper sm = new SiemMapper(description,requestType,status,priority,submitter);
        	String jsonString = new Gson().toJson(sm);
        	System.out.println(jsonString);
        	exchange.getIn().setHeader("siem_occurence_id", id);
        	exchange.getIn().setBody(jsonString);
        	
        	
        }
        
        catch(Exception e)
        {
        	System.out.println(e.getStackTrace());
        }
		
	}

}
