

##### �ˡ�ʹ�ú�����������

?	1.��������
		1����ȡ�ַ���:Oracle->substr(); Mysql->substring();
		2����������ת����Oracle�ж��������Mysql->convert();
		3����ȡ��ǰ���ڣ�Oracle->sysdate,Mysql->curdate();
	ע�����ڲ�ͬ��DBMSϵͳ��ʹ�õĺ�����ͬ����������ֲ�Դ��������㡣�������ʹ�ú����������Ӵ���ע�͡�

	2.�ı�������
		1��trim()������ո�
		2��upper()��ת���ɴ�д;   lower()��ת����Сд
		3��ltrim()��ȥ���ַ�����ߵĿո�;   rtrim()��ȥ���ַ����ұߵĿո�
		4��soundex()�������ַ�����soundexֵ�����ֵ��������ʾ����ĸ����ģʽ���㷨��
		5��length()�������ַ����ĳ���
	3.ʱ������ڴ���������ֲ����
		1��year();month();day();�ֱ���ȡ�����ա�ex:select year(curdate()) from dual;
	4.��ֵ������
		1��ABS():���ؾ���ֵ  EXP():����ָ��ֵ
		2��PI()������Բ����  SQRT()������ƽ����
		3��SIN()����������  COS()����������   TAN()����������



##### �š���������

?	1.�ۼ�����
		1��avg();count();max();min();sum();
		2������sum�������Լ���ĳһ�еĺͣ������ԺϼƼ���ֵ�����������������˺������еĺ͡�
	ע��avgֻ���ڵ����У����Һ�����ֵΪnull���С�count(*)������null��ֵ����count(column)����nullֵ��
	2.�ۼ���ֵͬ��distinct��
		1��select avg(distinct prod_price) from Products where vend_id='';
	ע��Distinct��������count(*)��ֻ������count()ָ��������select count(distinct prod_price) from Products;
	

##### ʮ���������ݣ�group by��

?	1.group by�Ӿ���ÿһ�ж������Ǽ����л�����Ч�ı��ʽ��+-*/�����������Ǿۼ�������
	2.group by������where֮��order by ֮ǰ��
	3.���˾ۼ����������⣬select�е�ÿһ�ж�������group by�Ӿ��и�������˼��group by����б�����ڵ���select�е��С���Ϊ�ȷ����select��ֻ�з������ܹ�select�С�
	4.���˷���(having�Ӿ�)
		����Է��������ݽ��й��ˡ�
		ע��having��where������where�ڷ���ǰ���ˣ�having�ڷ������ˡ�...from table where ...group by .. having...����˼����where���˺����������з��飬Ȼ��ͨ��having�ڹ��˷��������ݡ�
		�����ʹ��group by ����where��having��Ч����ͬ������havingӦ�ý��group by��whereӦ�����ڱ�׼���м����ˡ�
	5.���������
		����������group by����Ӧ��ʹ��order by��
	

	6.SELECT�Ӿ��˳�� select from where group by having order by���������д��˳�򣬲��������ݿ��ִ��˳��

##### ʮһ��ʹ���Ӳ�ѯ

?	
?		
?		

##### ʮ�š�ʹ�ô洢����

?	1.
	

---

[^account]: Product Code��4t46t6vydkvsxekkvf3fjnpzy5wbuhphqz;  serial Number��601769; password��xs374ca 