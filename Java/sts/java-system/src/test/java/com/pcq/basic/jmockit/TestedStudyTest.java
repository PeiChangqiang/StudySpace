package com.pcq.basic.jmockit;

import org.testng.Assert;
import org.testng.annotations.Test;

import mockit.Expectations;
import mockit.Injectable;
import mockit.Tested;

public class TestedStudyTest {

	@Tested
	BusinessServiceImpl service;//需要测试的对象，我们要测试它的doBusiness方法。JMockit会实例化它
	
	//测试对象依赖的两个接口，JMockit依然会帮我们实例化它们，并且注入到我们要测试对象的属性中。
	@Injectable
	IVerifyService verifyService;
	
	@Injectable
	ISendMsgService sendMsgService;
	@Test
	public void testDoBusiness() {
		new Expectations() {//这里并不需要真的去验证，真的去发送消息。因此录制，假设验证成功，消息也发送没问题。
			{
				verifyService.verify();
				result = true;
				sendMsgService.sendMsg();
			}
		};
		Assert.assertTrue(service.doBusiness());//测试真正想要测试的代码
	}
	
}


class BusinessServiceImpl implements IBusinessService {

	private IVerifyService verifyService;
	
	private ISendMsgService sendMsgService;
	
	public boolean doBusiness() {
		// TODO Auto-generated method stub
		if(!verifyService.verify()) {
			return false;
		}
		//doBusiness业务逻辑
		System.out.println("处理业务逻辑。。。。");
		
		//业务逻辑处理完后发送消息
		sendMsgService.sendMsg();
		return true;
	}
	
}

//业务逻辑接口
interface IBusinessService {
	boolean doBusiness();
}

//验证接口
interface IVerifyService {
	boolean verify();
}

//发送消息接口
interface ISendMsgService {
	void sendMsg();
}