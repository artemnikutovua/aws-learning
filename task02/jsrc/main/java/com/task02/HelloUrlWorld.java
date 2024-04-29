package com.task02;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.syndicate.deployment.annotations.lambda.LambdaUrlConfig;
import com.syndicate.deployment.annotations.lambda.LambdaHandler;
import com.syndicate.deployment.model.RetentionSetting;

import java.util.HashMap;
import java.util.Map;

@LambdaHandler(lambdaName = "hello_world",
        roleName = "Hello_URL_World-role",
        isPublishVersion = true,
        logsExpiration = RetentionSetting.SYNDICATE_ALIASES_SPECIFIED

)
@LambdaUrlConfig
public class HelloUrlWorld implements RequestHandler<Object, Map<String, Object>> {

    public Map<String, Object> handleRequest ( Object request, Context context ) {
        Map<String,String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        System.out.println("Hello from lambda");
        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("isBase64Encoded", false);
        resultMap.put("headers", headers);
       // resultMap.put("statusCode", 200);
        resultMap.put("statusCode", 200);
        resultMap.put("message", "Hello from Lambda");
        return resultMap;
    }
}
