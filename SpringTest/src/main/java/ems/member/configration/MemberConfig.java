package ems.member.configration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ems.member.DataBaseConnectionInfo;
import ems.member.dao.StudentDao;
import ems.member.service.EMSInformationService;
import ems.member.service.StudentAllSelectService;
import ems.member.service.StudentDeleteService;
import ems.member.service.StudentModifyService;
import ems.member.service.StudentRegisterService;
import ems.member.service.StudentSelectService;

@Configuration // 스프링 설정파일로 적용 가능함
public class MemberConfig {
	
	// <bean id="studentDao" class="ems.member.dao.StudentDao"/>
	@Bean
	public StudentDao studentDao() { // StudentDao - class, studentDao - id
		return new StudentDao();
	}
	
	/*<bean id="registerService" class="ems.member.service.StudentRegisterService>
	 * 	<constructor-arg ref="studentDao"></constructor-arg>
	 * </bean>
	 * */
	@Bean
	public StudentRegisterService registerService() {
		return new StudentRegisterService(studentDao());
	}
	
	/*
	 * <bean id="modifyService" class="ems.member.service.StudentModifyService">
	 * <constructor-arg ref="studentDao" ></constructor-arg> </bean>
	 */
	@Bean
	public StudentModifyService modifyService() {
		return new StudentModifyService(studentDao());
	}

	/*<bean id="deleteService" class="ems.member.service.StudentDeleteService">
	<constructor-arg ref="studentDao" ></constructor-arg>
	</bean>*/
	@Bean
	public StudentDeleteService deleteService() {
		return new StudentDeleteService(studentDao());
	}
	
	/*
	 * <bean id="selectService" class="ems.member.service.StudentSelectService">
	 * <constructor-arg ref="studentDao" ></constructor-arg> </bean>
	 */
	@Bean
	public StudentSelectService selectService() {
		return new StudentSelectService(studentDao());
	}

	/*
	 * <bean id="allSelectService" class="ems.member.service.StudentAllSelectService">
	 * <constructor-arg ref="studentDao" ></constructor-arg>
	 * </bean>
	 */
	@Bean
	public StudentAllSelectService selectAllService() {
		return new StudentAllSelectService(studentDao());
	}
	
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
