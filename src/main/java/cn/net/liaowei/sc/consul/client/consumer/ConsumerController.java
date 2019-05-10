package cn.net.liaowei.sc.consul.client.consumer;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * @author LiaoWei
 */
@RestController
@RequestMapping("/consumer")
@Api(tags = "/consumer", description = "服务消费")
public class ConsumerController {
    private RestTemplate restTemplate;

    public ConsumerController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/zone")
    public Map<String, String> consumerZone() {
        String name = restTemplate.getForObject("http://consul-client/zone/name", String.class);
        Map<String, String> result = new HashMap<String, String>();
        result.put("zone", name);
        return result;
    }
}
