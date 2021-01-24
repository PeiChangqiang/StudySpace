package com.pcq.basic.jmockit;

import org.testng.Assert;
import org.testng.annotations.Test;

import mockit.Expectations;
import mockit.Injectable;
import mockit.Tested;

public class TestedStudyTest {

	@Tested
	BusinessServiceImpl service;//��Ҫ���ԵĶ�������Ҫ��������doBusiness������JMockit��ʵ������
	
	//���Զ��������������ӿڣ�JMockit��Ȼ�������ʵ�������ǣ�����ע�뵽����Ҫ���Զ���������С�
	@Injectable
	IVerifyService verifyService;
	
	@Injectable
	ISendMsgService sendMsgService;
	@Test
	public void testDoBusiness() {
		new Expectations() {//���ﲢ����Ҫ���ȥ��֤�����ȥ������Ϣ�����¼�ƣ�������֤�ɹ�����ϢҲ����û���⡣
			{
				verifyService.verify();
				result = true;
				sendMsgService.sendMsg();
			}
		};
		Assert.assertTrue(service.doBusiness());//����������Ҫ���ԵĴ���
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
		//doBusinessҵ���߼�
		System.out.println("����ҵ���߼���������");
		
		//ҵ���߼������������Ϣ
		sendMsgService.sendMsg();
		return true;
	}
	
}

//ҵ���߼��ӿ�
interface IBusinessService {
	boolean doBusiness();
}

//��֤�ӿ�
interface IVerifyService {
	boolean verify();
}

//������Ϣ�ӿ�
interface ISendMsgService {
	void sendMsg();
}