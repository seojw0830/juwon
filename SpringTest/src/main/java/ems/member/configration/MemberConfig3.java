package ems.member.configration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ems.member.DataBaseConnectionInfo;
import ems.member.service.EMSInformationService;

@Configuration // 스프링 설정파일로 적용 가능함
public class MemberConfig3 {
	
	@Autowired
	private DataBaseConnectionInfo dbInfo;
	
	@Bean
	public EMSInformationService informationService() {
		EMSInformationService info = new EMSInformationService();
		
		info.setInfo("test");
		info.setCopyRight("2015");
		info.setVer("1.0");
		info.setsYear(2015);
		
		ArrayList<String> developers = new ArrayList<String>();
		developers.add("a");
		developers.add("b");
		developers.add("c");
		developers.add("d");
		info.setDevelopers(developers);
		
		Map<String, String> administrators = new HashMap<String, String>();
		administrators.put("a", "test");
		administrators.put("b", "test");
		info.setAdministrators(administrators);
		
		
		return info;
	}
}
