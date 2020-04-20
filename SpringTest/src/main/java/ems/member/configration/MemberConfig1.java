package ems.member.configration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import ems.member.dao.StudentDao;
import ems.member.service.StudentAllSelectService;
import ems.member.service.StudentDeleteService;
import ems.member.service.StudentModifyService;
import ems.member.service.StudentRegisterService;
import ems.member.service.StudentSelectService;

@Configuration // 스프링 설정파일로 적용 가능함
@Import({MemberConfig2.class, MemberConfig3.class}) // 2개의 클래스 파일을 import하여 xml을 용도별로 분리하는 것처럼 사용 가능하다
public class MemberConfig1 {
	
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
}
