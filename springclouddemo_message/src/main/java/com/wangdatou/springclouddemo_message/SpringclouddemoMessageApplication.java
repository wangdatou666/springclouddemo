package com.wangdatou.springclouddemo_message;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.wangdatou.springclouddemo_common.common.utils.JsonUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Map;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class SpringclouddemoMessageApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringclouddemoMessageApplication.class, args);
	}

	@Value("${aliyun.accessKeyId}")
	private String accessKeyId;
	@Value("${aliyun.accessKeySecret}")
	private String accessKeySecret;
	@Value("${aliyun.regionId}")
	private String regionId;
	@Value("${aliyun.domain}")
	private String domain;
	@Value("${aliyun.version}")
	private String version;
	@Value("${aliyun.action}")
	private String action;
	@Value("${aliyun.SignName}")
	private String signName;
	@Value("${aliyun.TemplateCode}")
	private String templateCode;

	@PostMapping("/sendMessage")
	public String sendMessage(@RequestBody Map<String,String> messageMap) {
        DefaultProfile profile = DefaultProfile.getProfile(regionId, accessKeyId, accessKeySecret);
        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();
        request.setMethod(MethodType.POST);
        request.setDomain(domain);
        request.setVersion(version);
        request.setAction(action);
        request.putQueryParameter("RegionId", regionId);
        request.putQueryParameter("PhoneNumbers", messageMap.get("PhoneNumbers"));
        request.putQueryParameter("SignName", signName);
        request.putQueryParameter("TemplateCode", templateCode);
        request.putQueryParameter("TemplateParam", messageMap.get("templateParam"));
        try {
            CommonResponse response = client.getCommonResponse(request);
            String data = response.getData();
			Map<String, Object> resultMap = JsonUtil.parseJSONToMap(data);
			if ("OK".equals(resultMap.get("Code"))){
				return "验证码发送成功";
			}else {
				return resultMap.get("Message").toString();
			}
		} catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
        return "未知错误";
	}

}
