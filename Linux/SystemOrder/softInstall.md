# Linux�µ������װ

### һ��Դ������밲װ

?	���͵�Դ����밲װ����Ĺ��̣�
	1.����configure����ϱ�Ҫ��������Makefile��
	2.����make��������ģ���������
	3.make install�����Ҫ���ļ����Ƶ���װĿ¼�С�
	ע��������������Ҫ�������Ŀ¼�ĸ�Ŀ¼�����С�

Դ������밲װApacheʾ����
	1.�ٷ��ҵ����°汾��apache����·������һ��Դ���������/usr/local/srcĿ¼�£�
	2.�������wget http://mirror.bit.edu.cn/apache/httpd/httpd-2.4.33.tar.gz
	3.��ѹ:tar zxvf httpd-2.4.33.tar.gz �������ѹ���Ŀ¼ cd httpd-2.4.33
	4.��������./concigure --prefix=/usr/local/apache/ --enable-modules=most   //--prefixָ����װ·����һ�㽨�鰲װ��/usr/local/�£� �������þ��󲿷�ģ��
	5.�������˳������������Makefile�ļ���Ȼ��ִ��make && make install
	ע�����ڰ�װ��ʱ����Ĳ����� APR not found.  Please read the documentation��������Ϊ������û��APR����ʱ��Ҫ��װAPR��

### ����RPM��װ���

?	RPM�Ǽ������ļ����������汾���ƵĹ��ߡ�
	RPM��Ϊ���ࣺ

?		1����Ԥ������������������Ҫ�������ļ�������������������װ�ð�ʱ�����ļ���ѹ���Ҹ��Ƶ��ض���Ŀ¼��ȥ��
		2��RMPԴ�����ϣ���Զ������������������������ư�װ����ʱ��ʹ�á�

1.RPM����������rpm:ʵ�����кܶలװ������ʵ����Ҫ���ʹ�ã������г���������ʹ�÷���
		1����װ�����:rpm -ivh package-version.rpm��
		2�����԰�װ�������������ʵ�İ�װ:rpm -ivh --test package-version.rpm
		3����װ����������¶��尲װ·��: rpm -ivh --relocate /=/usr.../package-version.rpm
		4��ǿ�а�װ�����������������ϵ��rpm -ivh package-version.rpm  --force --nodeps
		5�������������rpm -Uvh package-version.rpm
		6��




