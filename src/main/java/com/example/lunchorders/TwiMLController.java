package com.example.lunchorders;

import com.twilio.twiml.MessagingResponse;
import com.twilio.twiml.messaging.Body;
import com.twilio.twiml.messaging.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TwiMLController {
    private LunchList lunchOrdersList;
    @Autowired
    public TwiMLController(LunchList lunchOrdersList) {
        this.lunchOrdersList = lunchOrdersList;
    }

    @PostMapping(value="/sms", produces="application/xml")
    public String sendTwiML(@RequestParam("Body") String msg) {
// add to article
        String responseMsg;
        if (msg.equals("list"))
        {
            responseMsg = lunchOrdersList.getLunchOrderList().toString();
        }
        else {
            lunchOrdersList.addItem(msg);
            responseMsg = "Order received!";
        }
        Body body = new Body
                .Builder(responseMsg)
                .build();
        Message sms = new Message
                .Builder()
                .body(body)
                .build();
        MessagingResponse twiml = new MessagingResponse
                .Builder()
                .message(sms)
                .build();
        return twiml.toXml();
        ///
    }
}
