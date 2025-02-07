package source.ai;

import cn.hutool.Hutool;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import okhttp3.*;

import java.io.IOException;

import static cn.hutool.http.ContentType.JSON;


public class DeepSeekTest {

    public static void main(String[] args) throws IOException {
        String body =
                "{\n" +
                        "    \"messages\": [\n" +
                        "        {\n" +
                        "            \"content\": \"我快下班了，怎么样，很棒吧\",\n" +
                        "            \"role\": \"user\"\n" +
                        "        }\n" +
                        "    ],\n" +
                        "    \"model\": \"deepseek-chat\",\n" +
                        "    \"stream\": false\n" +
                        "}";
        String response = HttpRequest.post("https://api.deepseek.com/chat/completions").header("Content-Type", "application/json")
                .header("Authorization", "Bearer sk-0083c8ea3e1b4fafb0cea16f191214d5").body(body).execute().body();
        // 使用格式化输出
        System.out.println(com.alibaba.fastjson.JSON.toJSONString(JSONObject.parse(response), true));
    }
}
