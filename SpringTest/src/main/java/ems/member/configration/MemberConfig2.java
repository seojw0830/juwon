package ems.member.configration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ems.member.DataBaseConnectionInfo;

@Configuration // 스프링 설정파일로 적용 가능함
public class MemberConfig2 {
	
	
	/*
	 * <bean id="dataBaseConnectionInfoDev"
	 * class="ems.member.DataBaseConnectionInfo"> <property name="jdbcUrl"
	 * value="jdbc:oracle:thin:@localhost:1521:xe" /> <property name="userId"
	 * value="scott" /> <property name="userPw" value="tiger" /> </bean>
	 */
	@Bean
	public DataBaseConnectionInfo dataBaseConnectionInfoDev() {
		DataBaseConnectionInfo infoDev = new DataBaseConnectionInfo();
		infoDev.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:xe");
		infoDev.setUserId("scott");
		infoDev.setUserId("tiger");
		
		return infoDev;
	}
}
