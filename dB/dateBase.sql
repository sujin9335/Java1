SELECT * FROM DBA_USERS;
-- �ǽ��� ���� ����� ���������
-- SYSTEM(������ ����)���� ������ ������Ѵ�
-- CREATE USER ����ڸ� IDENTIFIED BY ��й�ȣ DEFAULT TABLESPACE USERS QUOTA UNLIMITED ON USERS;
-- 18C �������ʹ� ����ڸ� ##�� �ο��ϰ� �Ǿ����� -> ������ �� ����, �����ؼ� �������
ALTER SESSION SET "_ORACLE_SCRIPT"=TRUE;
CREATE USER BS IDENTIFIED BY BS DEFAULT TABLESPACE USERS QUOTA UNLIMITED ON USERS;
-- ������ ���� Ȯ���ϱ�
SELECT * FROM DBA_USERS; --�����ͺ��̽��� ��ϵ� ������ ��ȸ�ϴ� ��ɾ�


-- ������ �������� �����ϱ� -> ���Ӹ���� -> ����
-- ������ �������� ������ �����Ǿ����� -> ������ ����
-- ������ �������� ����ڿ��� ���ӱ��� �ο����ֱ� -> CONNECT���� �ο�
-- GRANT ���Ѹ�||ROLE�̸� TO ����
GRANT CONNECT TO BS;


-- BS�������� �����ؼ� ��ɾ� �����غ���
SELECT * FROM TAB; -- BS������ ������ �ִ� ���̺�(�����͸� �����ϴ� ����) ��ȸ�ϱ�
-- ������� �����غ���
-- ���÷� TEST�̸��� ��������� �����ϴ� ����
-- �⺻������ ��������� ������ �� �ִ� ������ �ο��Ǿ� �����ʴ� -> SYSTEM�������� �ο��� �������
CREATE TABLE TEST(
    TEST_NAME VARCHAR2(200)
);

-- ������������ϴ� ���� �ο��ϱ� -> �ο��ϰ� ��� CREATE ����
GRANT RESOURCE TO BS;

-- ����ڰ� ������ ���̺� ��ȸ
SELECT * FROM TAB;

-- ���ο� ������ ������ �ϰ� �Ǹ� SYSTEM�������� �˸´� ������ �ο�������Ѵ�
-- �⺻������ RESOURCE, CONNECT������ �ο��Ѵ�

-- BS������ �߰��� ������ Ȯ���ϱ�
-- �߰��� ���̺�(�������) Ȯ���ϱ�
SELECT * FROM TAB;
-- EMPLOYEE : ������� �������̺�
SELECT * FROM EMPLOYEE;
-- DEPARTMENT : �μ����� �������̺�
SELECT * FROM DEPARTMENT;
-- JOB : ��å���� �������̺�
SELECT * FROM JOB;
-- LOCATION : �μ��������� �������̺�
SELECT * FROM LOCATION;
-- NATIONAL : �������� �������̺�
SELECT * FROM NATIONAL;
-- SAL_GRADE : �޿����� �������̺�
SELECT * FROM SAL_GRADE;


-- SELECT�� Ȱ���ϱ�
-- �⺻ SELECT��
-- SCLECT �÷���, �÷���, ....(�÷��� ����)
-- FROM ���̺��


-- EMPLOYEE ���̺��� EMP_ID, EMP_NAME, SALARY �÷��� ��ȸ�ϱ�
SELECT EMP_ID, EMP_NAME, SALARY
FROM EMPLOYEE;

-- DEPARTMENT���̺��� DEPT_TITLE ��ȸ�ϱ�
SELECT DEPT_TITLE
FROM DEPARTMENT;

-- EMPOLYEE���̺� �ִ� ��ü Į���� ��ȸ�ϱ�
-- SELECT���� �÷��� �����κп� * �� ����ϸ� �ȴ�
SELECT *
FROM EMPLOYEE;

-- DEPARTMENT���̺� �ִ� ��ü Į���� ��ȸ�ϱ�
SELECT * FROM DEPARTMENT;

-- ������ ����Ǿ��ִ� ���̺�� Į�� Ȯ���ϱ�
-- ���̺���ȸ
SELECT * FROM TAB;
-- ���̺��� �÷��� ��ȸ�ϱ�
DESC DEPARTMENT;


-- SELECT���� �̿��ؼ� ������� ó������� Ȯ���� �� ����
SELECT 1+10 FROM EMPLOYEE;
-- �׽�Ʈ�� �⺻ ���̺� ���� -> DUAL���̺�
-- ������ ���, ����Ŭ�����Լ� ������ �� ���
SELECT 1+10, 5*3, 10/2 FROM DUAL;
-- ������� ������ִ� �÷� -> �����÷��̶�� ��
-- �����Ͱ� �ִ� ���̺��� �÷��� ��������� ����
-- EMPLOYEE���̺��� SALARY�� 100���ϱ�
SELECT EMP_NAME, SALARY, SALARY+100
FROM EMPLOYEE;


-- �� ����� �̸�, ���� ������ ��ȸ�ϱ�
SELECT EMP_NAME, SALARY, SALARY*12
FROM EMPLOYEE;

-- �÷����� NULL�� ��� ��������� �Ұ��� -> �Լ��� �̿��ؼ� NULL�϶� ��ü���� ������ �� ����
SELECT * FROM EMPLOYEE;
--SELECT EMP_NAME, BONUS, BONUS+0.5
SELECT EMP_NAME, BONUS, NVL(BONUS,0)+0.5
FROM EMPLOYEE;

-- Į���� ��������� �� ��� Į���� Ÿ���� �������̿��� �Ѵ�
SELECT EMP_NAME+100
FROM EMPLOYEE; -- ���ȵ�

-- FROM������ ����� ���̺� �ִ� �÷��� ��ȸ�� �����ϴ�
SELECT DEPT_ID, DEPT_TITLE --EMP_NAME(�̰� �߰��ϸ� ��������)
FROM DEPARTMENT;

-- �÷����� ���Ӱ� ������ �� ���� -> ��Ī�ο��ϱ�
SELECT EMP_ID, EMP_NAME, EMAIL
FROM EMPLOYEE;
-- �÷��� �����ϰ� AS���� �̿��ؼ� ��Ī�� �ο�
SELECT EMP_ID AS �����ȣ, EMP_NAME AS �����, EMAIL AS �̸���
FROM EMPLOYEE;
-- �����÷��� ��Ī�� �ο��ϴ� ��찡 ����
SELECT EMP_ID, EMP_NAME, SALARY, SALARY*12 AS YEAR_SALARY
FROM EMPLOYEE;
-- ��Ī�� **�� �̿��ؼ� ���⸦ �� �� �ִ�
SELECT EMP_ID AS "��� ��ȣ", EMP_NAME AS "��%��"
FROM EMPLOYEE;

-- �ߺ�������(ROW)�� ���� ��ȸ�ϱ� 
-- DISTINCT���� ����ؼ� ��ȸ�� �Ѵ�
SELECT DISTINCT DEPT_CODE
FROM EMPLOYEE;

-- DISTINCT�� SELECT ����� �������� ����� ����
SELECT EMP_NAME, DISTINCT DEPT_CODE
FROM EMPLOYEE; --�ȵ�

SELECT DISTINCT DEPT_CODE, JOB_CODE -- DISTINCT �ڿ��� �ϳ��� ������ �ߺ�������
FROM EMPLOYEE;

-- ���ڿ��� �������ִ� ����ó���ϱ�
-- || -> ���ڿ��� ����
-- ����Ŭ���� ���ڿ� ���ͷ�ǥ�� -> ''
SELECT '������ '||'���ɸ��ְ� �Ծ�����?' AS MSG
FROM DUAL;

-- ���ڿ� �÷��� �����Ͽ� ����Ҷ��� ���
SELECT EMP_NAME||'���� �̸�����'||EMAIL
FROM EMPLOYEE;

SELECT * FROM EMPLOYEE;
-- ������(ROW)�� �����ϱ� -> ���ǿ� �´� ������ ��ȸ�ϱ�
-- WHERE ���� ���
-- ���
-- SELECT * ||�÷���,�÷���...
-- FROM ���̺��
-- WHERE ���ǹ�(�񱳿���(=,>=,<=,!=), ������(AND, OR))
-- EMPLOYEE ���̺��� ������ 300���� �̻��� ����� ��ȸ����
SELECT EMP_NAME, SALARY
FROM EMPLOYEE
WHERE SALARY>=3000000;

-- EMPLOYEE ���̺��� DEPT_CODE�� D5�� ����� ��ȸ�ϱ�
SELECT * FROM EMPLOYEE
WHERE DEPT_CODE='D5';

-- EMPLOYEE ���̺��� JOB_CODE�� J2�� ����� �̸�,�޿�,��å�ڵ� ��ȸ�ϱ�
SELECT EMP_NAME, SALARY, JOB_CODE
FROM EMPLOYEE
WHERE JOB_CODE='J2';

-- EMPLOYEE ���̺��� �μ��ڵ尡 D5�� �ƴ� ����� �̸�,�μ��ڵ� ��ȸ�ϱ�
SELECT EMP_NAME, DEPT_CODE
FROM EMPLOYEE
WHERE DEPT_CODE != 'D5';

-- EMPLOYEE ���̺��� �μ��ڵ尡 D5�̰� ������ 300�����̻��� ����� ��ü�÷���ȸ�ϱ�
SELECT * FROM EMPLOYEE
WHERE DEPT_CODE='D5' AND SALARY>=3000000;

-- EMPLOYEE ���̺��� �μ��ڵ尡 D5�̰ų� ������ 300���� ������ ����� ��ü�÷� ��ȸ�ϱ�
SELECT *
FROM EMPLOYEE
WHERE DEPT_CODE='D5' OR SALARY<=3000000;

-- ��¥�� �����͵� ��Һ񱳰� �����ϴ�
-- ��¥ǥ�ô� ���ڿ��� ���Ͽ� ���缭 ǥ�� -> 'YYYY/MM/DD' 'YY/MM/DD'
-- EMPLOYEE���̺��� �Ի���(HIRE_DATE)�� 2000�⵵ ������ ����� ���ϱ�
SELECT *
FROM EMPLOYEE
WHERE HIRE_DATE < '00/01/01';


-- Ư�������� ��ȸ�ϴ� ����
-- AND �����Ͽ� ���, BETWEEN AND�� ����ؼ� ó���ϴ� ���
-- EMPLOYEE���̺��� ������ 200���� �̻� 300���� ���Ϸ� �޴� ����� �̸�, �޿�, ���ʽ�, �Ի��� ��ȸ�ϱ�
SELECT EMP_NAME, SALARY, BONUS, HIRE_DATE
FROM EMPLOYEE
--WHERE SALARY>=2000000 AND SALARY<=3000000;
WHERE SALARY BETWEEN 2000000 AND 30000000;

--EMPLOYE���̺��� �Ի����� 00����� ����� ��ȸ�ϱ�
SELECT *
FROM EMPLOYEE
--WHERE HIRE_DATE>='00/01/01' AND HIRE_DATE<='00/12/31';
WHERE HIRE_DATE BETWEEN '00/01/01' AND '00/12/31';


-- LIKE������ �̿��ϱ�
-- ���ڿ� �����͸� �������� ���ϴ� ���� -> �κ���ġ, ���Ͽ� �´� ���ڿ��� ã���� ���
-- �̸��� 'EA'�� �ִ� ���, ���� �达�� ���, �ֹι�ȣ�� 32�� �ִ� ���
-- �÷��� LIKE '���ҹ�������'
-- % : ���ڰ� 0���̻� �ƹ����ڳ� ���
--��) '%��%' : ���� �ִ� ���Ե� ���ڿ� �Ѱ�(O), ����(O), ���϶�(O), ��������(O), �谭��(O), ����������������(O)
--    '��%' : ������ ���۵Ǵ� ���ڿ�

-- _ : ���ڰ� 1�� �ƹ����ڳ� ���
--��) '_��_' : 3���� ���ڿ� �߰��� ���� �ִ°�
--��) '_��%' : 2�����̻� ���ڿ� �ι�° ���ڰ� '��'�� ���ڿ�

-- ��� �� �������� ���� ����� �����, ����, �μ��ڵ� ��ȸ�ϱ�
SELECT EMP_NAME, SALARY, DEPT_CODE
FROM EMPLOYEE
--WHERE EMP_NAME LIKE '��%';
WHERE EMP_NAME LIKE '��__';
-- EMAIL�� YO�� �����ϰ� �ִ� ����� �̸�, �̸����� ��ȸ�ϱ�
SELECT EMP_NAME, EMAIL
FROM EMPLOYEE
WHERE EMAIL LIKE '%y%';

-- LIKE���������ϱ�
-- ����� ���� ���� �ƴ� ����� ��ȸ�ϱ�
SELECT * FROM EMPLOYEE
WHERE EMP_NAME NOT LIKE '��%';

-- �̸����ּҿ� _�ձ��ڰ� 3������ ����� �����, �̸��� ��ȸ�ϱ�
SELECT EMP_NAME, EMAIL
FROM EMPLOYEE
WHERE EMAIL LIKE '___*_%' ESCAPE '*'; -- '*'�� ���ڿ��� ����

-- NULL�� ���ϱ�
-- �⺻������ NULL���� �񱳿��� ó���� �� �� ����
-- NULL���� ó���ϱ� ���� �����ڸ� ����� ����
-- IS NULL / IS NOT NULL
-- ����� ���ʽ��� �޴� ����� �̸�, �޿�, ���ʽ��� ��ȸ�ϱ�
SELECT * FROM EMPLOYEE
WHERE BONUS IS NOT NULL;

-- ����� �Ŵ����� ������������ ����� ��ȸ�ϱ�
SELECT * FROM EMPLOYEE
WHERE MANAGER_ID IS NULL;

-- �μ��� ���� ��� ��ȸ�ϱ�
-- �μ��ڵ忡 �������� �ۼ��ϱ� (NVL)
SELECT E.*, NVL(DEPT_CODE, '����') 
FROM EMPLOYEE E
WHERE DEPT_CODE IS NULL;

-- ���߰� ������ϱ�
-- OR�� �����ؼ� ó���ϱ� IN�� Ȱ���ϱ�
-- ����� �μ��� D5�̰ų� D6�� ����� �����, �μ��ڵ带 ��ȸ�ϱ�
SELECT EMP_NAME, DEPT_CODE
FROM EMPLOYEE
--WHERE DEPT_CODE='D5' OR DEPT_CODE='D6';
--WHERE DEPT_CODE IN ('D5','D6');
WHERE DEPT_CODE IN (SELECT DEPT_CODE FROM EMPLOYEE WHERE EMP_NAME IN('�ɺ���', '������'));

-- �ɺ���, ������ ����� ���� �μ��� ������ϱ�
SELECT DEPT_CODE FROM EMPLOYEE
WHERE EMP_NAME IN('�ɺ���', '������');

-- NOT IN ()����ϱ�
-- D5, D6�� �ƴ� ��� ��ȸ�ϱ�
SELECT *
FROM EMPLOYEE
WHERE DEPT_CODE NOT IN ('D5','D6');

-- ��������� ������ �켱������ ��������
-- ��å�� J7�̰ų� J2�� ��� �� �޿��� 200���� �̻��� ����� ��ȸ
SELECT EMP_NAME, JOB_CODE, SALARY
FROM EMPLOYEE
WHERE (JOB_CODE='J7' OR JOB_CODE='J2') AND SALARY>=2000000;

-- WHERE ������ ��������� ����� �� �ִ�
SELECT *
FROM EMPLOYEE
WHERE SALARY > SALARY*12;



-- ����Ŭ���� �����ϴ� �Լ��� ����غ���
-- �Լ��� ����Ҷ��� SELECT������ ����� �Ѵ�
-- SELECT���� �÷����� ���̳� WHERE�� ����� �� �� �ִ�

-- �������Լ� ������ ���̺� �ִ� ��� ROW�� ����� ������ִ� �Լ�
-- ���ڿ� ó���Լ�
-- LENGTH() : �Ű������� ���޵� �÷��̳� ���ͷ��� ���̸� ������ִ� �Լ�
SELECT LENGTH('������') FROM DUAL;
-- �̸��� ���� Ȯ���ϱ�
SELECT LENGTH(EMAIL), EMAIL FROM EMPLOYEE;

-- �̸����� ���̰� 13�̻��� ���
SELECT EMAIL
FROM EMPLOYEE
WHERE LENGTH(EMAIL)>=13;

-- LENGTHB()

-- INSTR() : JAVA INDEXOF() �޼ҵ�� ����
-- ���ڿ��� �ε��� ��ġ�� ��ȯ���ִ� �Լ�
-- INSTR(����ڿ�||�÷�, ã�����ڿ�[, �˻�������ġ]) : ã�� ���ڿ��� �ε�����ȣ�� ��ȯ
SELECT INSTR('�ް����͵�IT', 'IT'), INSTR('�ް����͵�IT', '�ް�')
FROM DUAL;

SELECT EMAIL, INSTR(EMAIL, 'j')
FROM EMPLOYEE
WHERE INSTR(EMAIL, 'j')=0;

SELECT INSTR('�ް� ���͵� �ް����͵� IT �ް� ���͵� �̿�', '�ް�', 4),
INSTR('�ް� ���͵� �ް����͵� IT �ް� ���͵� �̿�', '�ް�', 1,3)
FROM DUAL;

-- LPAD/RPAD : ������ ���̿� ���ڿ��� ä������ �ʾ����� Ư�����ڷ� ä���ִ� �Լ�
-- LPAD||RPAD(���ڿ�||�÷���, ����, �����ä���ٹ���)
SELECT LPAD('�ް�',10,'*'), RPAD('�ް�',10,'*')--*6��, �ް� 2��(2BYTE)
FROM DUAL;

SELECT RPAD(EMP_NAME, 8, '��')
FROM EMPLOYEE;

-- LTRIM/RTRIM : ���� �Ǵ� Ư�� ���ڸ� �������ִ� ���
SELECT '    ������', LTRIM('    ������'), '1111����', LTRIM('1111����','1'), LTRIM('11211����','1')
FROM DUAL;

-- TRIM : ������ ���� �����ϴ� �Լ�, �⺻ : ����, ������ ���� ����
SELECT '     ����     ', TRIM('     ����     '),
TRIM('Z' FROM 'ZZZZZ����ZZZZZ'),
TRIM(LEADING 'Z' FROM 'ZZZZZ����ZZZZZ'),
TRIM(TRAILING 'Z' FROM 'ZZZZZ����ZZZZZ'),
TRIM(BOTH 'Z' FROM 'ZZZZZ����ZZZZZ')
FROM DUAL;

-- SUBSTR : JAVA SUBSTRING�޼ҵ�� ������ �Լ�
-- SUBSTR(����ڿ�, �����ε���[,���ε���])
SELECT EMP_NAME, SUBSTR(EMP_NAME,1,1)
FROM EMPLOYEE;

SELECT DISTINCT SUBSTR(EMP_NAME,1,1) --DISTINCT �ߺ�����
FROM EMPLOYEE;

SELECT * FROM EMPLOYEE;
SELECT SUBSTR(EMP_NO,1,2) AS �⵵, SUBSTR(EMP_NO,8,1) AS ����
FROM EMPLOYEE;

SELECT *
FROM EMPLOYEE
WHERE SUBSTR(EMP_NO,1,2) BETWEEN 80 AND 89;

SELECT *
FROM EMPLOYEE
WHERE SUBSTR(EMP_NO,8,1) IN ('2','4');

-- ����� �̸��Ͽ��� ���̵� ����ϱ�
SELECT EMAIL, SUBSTR(EMAIL,1, INSTR(EMAIL,'@')-1)
FROM EMPLOYEE;

SELECT EMAIL, SUBSTR(EMAIL,1, INSTR(EMAIL,'@')-1)
FROM EMPLOYEE
WHERE LENGTH(SUBSTR(EMAIL,1, INSTR(EMAIL,'@')-1))>=7;

-- �����ڸ� ó���ϴ� �Լ�
-- UPPER, LOWER, INITCAP
SELECT LOWER('Welcome to oRACLE world'),
UPPER('Welcome to oRACLE world'),
INITCAP('Welcome to oRACLE world')
FROM DUAL;

SELECT *
FROM EMPLOYEE
WHERE DEPT_CODE = UPPER('d5');

-- REPLACE : ��󹮿��� �������ڸ� ã�Ƽ� ��ü���ڷ� �������ִ� �Լ�
-- REPLACE(���ڿ�||�÷���, 'ã������', '��ü����')
SELECT EMAIL, REPLACE(EMAIL, 'SU.or.kr', 'BS.or.kr')
FROM EMPLOYEE;
UPDATE EMPLOYEE SET EMAIL=REPLACE(EMAIL, 'SU.or.kr', 'BS.or.kr');
SELECT * FROM EMPLOYEE;
COMMIT;

-- ����ó���Լ�
-- �Ҽ����� ���� ó��, ��꿡 ���� ó���� �ִ�...
-- ABS : ���밪
SELECT ABS(-10), ABS(10)
FROM DUAL;

-- MOD() : ���������ϴ� �Լ� -> %
SELECT MOD(3,2)
FROM DUAL;

SELECT E.*, MOD(SALARY, 3)
FROM EMPLOYEE E;

-- �Ҽ����� ó���ϴ� �Լ�
-- ROUND(�ݿø�), FLOOR(�Ҽ�������), TRUNC(�Ҽ�������, ������ �ڸ��� ����), CEIL(������ �ø�)
SELECT ROUND(125.556), FLOOR(125.567), TRUNC(125.567,2), CEIL(125.567)
FROM DUAL;

-- ���ʽ��� ������ ���ޱ��ϱ�
SELECT EMP_NAME, SALARY, FLOOR(SALARY+(SALARY*NVL(BONUS,0)-(SALARY*0.03))) AS SALARY
FROM EMPLOYEE;

-- ��¥ó���Լ�
-- ����Ŭ���� ��¥�� ����Ҷ� �ΰ���
-- SYSDATE���� ��� -> ���ó�¥���(DB������ǻ�Ϳ� ������ ��¥)
-- SYSTIMESTAMP����� ��� ��¥, �ð��� �������
SELECT SYSDATE, SYSTIMESTAMP FROM DUAL;

-- ��¥�� ������ ������. +, - �ϼ��� ���
SELECT SYSDATE, SYSDATE+3, SYSDATE-10
FROM DUAL;
--NEXT_DAY : ���ڷ� ���޵� ������ ���� ����� ������¥�� ���
SELECT NEXT_DAY(SYSDATE, 'ȭ'), NEXT_DAY(SYSDATE, '��')
FROM DUAL;

SELECT * FROM V$NLS_PARAMETERS; --���� ���� �ѱ��� ���⼭ KOREA�� �������־ ����
ALTER SESSION SET NLS_LANGUAGE='KOREAN'; --���󺯰氡�� (DBA�� �ٲ�ߴ�)

-- LAST_DAY : �״��� ���������� ������ִ� �Լ�
SELECT LAST_DAY(SYSDATE)
FROM EMPLOYEE;

SELECT NEXT_DAY(HIRE_DATE, '��'), LAST_DAY(HIRE_DATE)
FROM EMPLOYEE;

-- �������� ������ִ� (�����ִ�) �Լ�
-- ADD_MONTHS()
SELECT ADD_MONTHS(SYSDATE, -3), ADD_MONTHS(SYSDATE, 3)
FROM DUAL;

-- �� ��¥�� ���������̸� ������ִ� �Լ�
-- MONTHS_BETWEEN(��¥, ��¥)
SELECT FLOOR(MONTHS_BETWEEN(SYSDATE, '22/01/01'))
FROM DUAL;

-- ��¥�� �⵵, ��, ���� ���� ������ִ� �Լ�
-- EXTRACT(YEAR||MONTH||DAY FROM ��¥) : ����
SELECT EXTRACT(YEAR FROM SYSDATE), EXTRACT(MONTH FROM SYSDATE), EXTRACT(DAY FROM SYSDATE)
FROM DUAL;

SELECT EXTRACT(YEAR FROM SYSDATE)-1992
FROM DUAL;

--����� 12���� �Ի��� ��� ��ȸ�ϱ�
SELECT *
FROM EMPLOYEE
WHERE EXTRACT(MONTH FROM HIRE_DATE)=12;

--����� 2000��� �Ի��� ��� ��ȸ�ϱ�
SELECT *
FROM EMPLOYEE
WHERE EXTRACT(YEAR FROM HIRE_DATE) BETWEEN 2000 AND 2009;

-- ���úη� ���ƾ��� ����� �������� �Ǿ����ϴ� �Ф� �߰� ���ƾ�, ���뺹���Ⱓ�� 1��6������
-- �������ڸ� ���ϰ�, �����ϼ�, ���������� �Դ� «�䰹��(3)�� ���ϱ�
SELECT SYSDATE, ADD_MONTHS(SYSDATE, 18) AS ������, ADD_MONTHS(SYSDATE, 18)-SYSDATE AS �����ϼ�, (ADD_MONTHS(SYSDATE, 18)-SYSDATE)*3 AS «��
FROM DUAL;

-- ����ȯ �Լ� -> (�ڷ���), parse000, string.valueOf
-- ����Ŭ�� �ڵ�����ȯ�� �� �۵�
-- ������ ����ȯ�� �̿��ؼ� ó���� �� ����
-- ���� : NUMBER
-- ���� : VARCHAR2
-- ��¥ : DATE, TIMESTAMP

-- TO_CHAR : ����, ��¥�� ���������� �������ִ� �Լ�
-- ��¥���� ���������� �����ϱ�
-- ��¥�� ��ȣ�� ǥ���ؼ� ���������� ������
-- Y:��, M:��, D:��, H:��, MI:��, SS:��
SELECT SYSDATE, TO_CHAR(SYSDATE, 'YYYY-MM-DD'),
TO_CHAR(SYSDATE, 'YY.MM.DD'), TO_CHAR(SYSDATE, 'YY.MM.DD HH:MI:SS')
FROM DUAL;

-- ���ڸ� ���ڷ� ��ȯ�ϱ�
-- ���Ͽ� ���缭 ��ȯ -> �ڸ����� ���� ������ ����
-- 0 : ��ȯ�ϴ� ���� �ش��ڸ��� ������ 0���� ǥ��,  �ڸ��� ���� ������ �� ���ڷ� ǥ��
-- 9 : ��ȯ�ϴ� ���� �ش��ڸ��� ������ ǥ�� ����, �ڸ��� ���� ������ �� ���ڷ� ǥ�� 
-- ��ȭ�� ǥ���Ϸ��� Lǥ����
SELECT 12345678, TO_CHAR(12345678,'999,999,999'), 
TO_CHAR(12345678,'000,000,000'),
TO_CHAR(12345678,'L999,999,999'),
TO_CHAR(180.5, 'FM999.99'),--FM �ڸ��� ���缭 �Ҽ��� ǥ��
TO_CHAR(180.5, 'FM000.00')
FROM DUAL;

SELECT EMP_NAME, SALARY, TO_CHAR(SALARY,'L999,999,999') AS CONVERT
FROM EMPLOYEE;

-- ���ڿ��� ���������� �����ϴ� �Լ�
-- TO_NUMBER()
-- �������� ����
SELECT '1,000,000', TO_CHAR(TO_NUMBER('1,000,000', '999,999,999')+100, 'L999,999,999')
FROM DUAL;

-- ����, ���ڸ� ��¥������ �������ִ� �Լ�
-- TO_DATE() ��¥�������� ��¥������ ��ȯ
-- Y, M, D �⺻��¥���� : YY/MM/DD
SELECT TO_DATE('22/12/25', 'YY/MM/DD')-SYSDATE, TO_DATE('221225', 'YYMMDD'),
    TO_DATE(221225, 'YYMMDD'), TO_DATE(20230108, 'YYYYMMDD'), 
    TO_DATE(TO_CHAR(001225, '009999'), 'YYMMDD') --���ڸ� �⵵�� 0�̸� TO_CHAR�� ��ȯ �ѹ�����ߵ�
FROM DUAL;

-- NULL ���� ó�����ִ� �Լ�
-- NVL() : Ư���÷����� NULL�� ��� ��ü������ ������ִ°�
SELECT EMP_NAME, DEPT_CODE, NVL(DEPT_CODE, '����'), BONUS, NVL(BONUS, 0)
FROM EMPLOYEE
WHERE NVL(DEPT_CODE, '����')='����';
-- NVL2() : NULL���϶� ��, NULL���� �ƴҶ� ���� ����
SELECT EMP_NAME, DEPT_CODE, NVL2(DEPT_CODE, '������', '����')
FROM EMPLOYEE;

-- ���ǿ� ���� ��°��� �������ִ� �Լ�
-- 1. DECODE 
-- DECODE(�÷���||���ڿ�, '������Ұ�', '�������� ����Ұ�', '������Ұ�', '�������� ����Ұ�')
SELECT EMP_NAME, JOB_CODE, DECODE(JOB_CODE, 'J1', '��ǥ', 'J2', '�λ���', 'J3', '����', '���') --�ǳ� ����� DEFRALT ���� �Ǽ� ������ ���(���)
FROM EMPLOYEE;
-- ������ ��,���� ����ϴ� �÷������
SELECT EMP_NAME, SALARY, DECODE(SUBSTR(EMP_NO,8,1), '1', '��', '2', '��') AS GENDER
FROM EMPLOYEE
WHERE DECODE(SUBSTR(EMP_NO,8,1), '1', '��', '2', '��')='��';

-- 2. CASE WHEN THEN
-- CASE
--  WHEN ���ǹ� THEN ���೻��(��±���)
--  WHEN ���ǹ� THEN ���೻��(��±���)
--  WHEN ���ǹ� THEN ���೻��(��±���)
--  ELSE ���೻��
-- END
SELECT EMP_NAME, JOB_CODE,
    CASE
        WHEN JOB_CODE='J1' THEN '��ǥ'
        WHEN JOB_CODE='J2' THEN '�λ���'
        WHEN JOB_CODE='J3' THEN '����'
        WHEN JOB_CODE='J4' THEN '����'
        ELSE '���'
    END AS ��å,
    CASE
        WHEN SALARY>=30000000 THEN '��׿���'
        WHEN SALARY<=30000000 THEN '�⺻'
    END AS ���
FROM EMPLOYEE;
        
-- ������̺��� ���糪�̱��ϱ�
-- ����Ŭ���� �⵵�� ǥ���ϴ� ���ϰ��� 2���� Y, R
SELECT EMP_NAME, EXTRACT(YEAR FROM SYSDATE)-EXTRACT(YEAR FROM TO_DATE(SUBSTR(EMP_NO,1,2), 'RR')),
    EXTRACT(YEAR FROM TO_DATE(SUBSTR(EMP_NO,1,2), 'YY')) AS YY, --YY���ϸ� ���� ���� ������ 20�� ����
    EXTRACT(YEAR FROM TO_DATE(SUBSTR(EMP_NO,1,2), 'RR')) AS RR
FROM EMPLOYEE;

-- RR�� �⵵�� ����Ҷ�
-- ����⵵     �Է³⵵       ���⵵
-- 00~49        00~49       ������
-- 00~49        50~99       ������
-- 50~99        00~49       ��������
-- 50~99        50~99       ������

-- �׷��Լ� Ȱ���ϱ�
-- ���̺��� �����͸� �����ؼ� �ϳ��� ROW�� ����� ����ϴ� �Լ� -> ����� �Ѱ��� ����
-- �÷����� ���� �հ�, ���, ���� ���Ҷ� ���
-- �׷��Լ��� �̿��ϸ� SELECT������ �÷��� ����� ���� * �׷��Լ����� ����� �÷��� ����� ����
-- ����
-- SUM : �÷����� ���� �հ踦 ������ִ� �Լ�
-- AVG : �÷����� ���� ����� ������ִ� �Լ�
-- COUNT : ���̺��� ROW���� ������ִ� �Լ� * �÷����� ����
-- MIN : �÷����� ���� �������� ������ִ� �Լ�
-- MAX : �÷����� ���� ū���� ������ִ� �Լ�

-- ������̺��� ����� �޴� �޿��� �հ踦 ��ȸ�ϱ�
SELECT *
FROM EMPLOYEE;

SELECT SUM(SALARY) FROM EMPLOYEE;
-- ����� �޴� �޿��� ����� ��ȸ
SELECT FLOOR(AVG(SALARY)) FROM EMPLOYEE;
SELECT SUM(SALARY), FLOOR(AVG(SALARY)) FROM EMPLOYEE;

--�μ��� D5�� ����� �޿� �հ�, ����� ���ض�
SELECT SUM(SALARY) AS �հ�, AVG(SALARY) AS ���
FROM EMPLOYEE
WHERE DEPT_CODE='D5';

-- SUM, AVG�̿�� NULL���� �ִ� ���? -> ���꿡�� ������
SELECT TRUNC(AVG(BONUS),3), TRUNC(AVG(NVL(BONUS,0)),3)
FROM EMPLOYEE;

-- ROW�� ������ ������ִ� �Լ�
SELECT COUNT(*) FROM EMPLOYEE;
-- D5�μ��� ����� ���ϱ�
SELECT COUNT(*) 
FROM EMPLOYEE
WHERE DEPT_CODE='D9';

-- 400���� �̻� �޿��� �޴� �����
SELECT COUNT(*)
FROM EMPLOYEE
WHERE SALARY>=4000000;

-- ���� ���ʽ��� �ް� �ִ� �����
SELECT COUNT(*)
FROM EMPLOYEE
WHERE BONUS IS NOT NULL;

-- �μ��� D6,D5,D9�� ����� ��, �޿����, �޿��հ� ��ȸ�ϱ�
SELECT COUNT(*) AS ��, TRUNC(AVG(SALARY),-2) AS ���, SUM(SALARY) AS �հ�
FROM EMPLOYEE
WHERE DEPT_CODE IN('D6','D5','D9') AND SALARY >=3000000;

-- COUNT(*) VS COUNT(�÷���)
SELECT COUNT(*), COUNT(DEPT_CODE), COUNT(BONUS)
FROM EMPLOYEE;

-- MIN/MAX
SELECT MAX(SALARY), MIN(SALARY)
FROM EMPLOYEE;

-- �׷��Լ��� WHERE���� ����� �Ұ�����
SELECT *
FROM EMPLOYEE
WHERE MAX(SALARY)=SALARY; --�Ұ���

-- GROUP BY �� �̿��ϱ�
-- GROUP BY �� Ư���÷��� ���� �������� ��� ������� ����ϴ� ��ɾ�
-- �μ��� �޿��� �հ�, ���
SELECT DEPT_CODE, SUM(SALARY), AVG(SALARY)
FROM EMPLOYEE
WHERE DEPT_CODE IS NOT NULL
GROUP BY DEPT_CODE;

-- ��å�� �޿��� �հ�, ���
SELECT JOB_CODE, SUM(SALARY), AVG(SALARY)
FROM EMPLOYEE
GROUP BY JOB_CODE;

-- �μ��� �ο� ��ȸ�ϱ�
SELECT DEPT_CODE, COUNT(DEPT_CODE)
FROM EMPLOYEE
WHERE DEPT_CODE IS NOT NULL
GROUP BY DEPT_CODE;

-- GROUP BY ������ �ټ��� �÷��� ����� �� ����
-- GROUP BY �÷�, �÷�....
SELECT DEPT_CODE, JOB_CODE, COUNT(*), SUM(SALARY), AVG(SALARY)
FROM EMPLOYEE
GROUP BY DEPT_CODE, JOB_CODE;

-- �μ��� �ְ�޿�, �ּұ޿� ��ȸ�ϱ�
SELECT DEPT_CODE, MAX(SALARY), MIN(SALARY)
FROM EMPLOYEE
GROUP BY DEPT_CODE;

-- �׷��Լ��� �������� ����Ҷ��� HAVING���� �̿�����
-- ���μ��� �ο����� 4���̻��� �μ� 
SELECT DEPT_CODE, COUNT(*)
FROM EMPLOYEE
GROUP BY DEPT_CODE
HAVING COUNT(*)>=4;

-- �Ŵ����� �����ϴ� ����� 2�� �̻��� �Ŵ��� ��ȸ�ϱ�
SELECT * FROM EMPLOYEE;
SELECT MANAGER_ID, COUNT(*)
FROM EMPLOYEE
WHERE MANAGER_ID IS NOT NULL
GROUP BY MANAGER_ID
HAVING COUNT(*)>=3;

SELECT *
FROM EMPLOYEE
WHERE EMP_ID IN(SELECT MANAGER_ID FROM EMPLOYEE GROUP BY MANAGER_ID HAVING COUNT(*)>=2);

-- ROLLUPM CUBE �̿��ϱ�
-- �׷캰 �������� �� �������� ������ִ� �Լ�
-- �÷��� �Ѱ��� ���������� ROLLUP�� CUBE�� ����
-- �÷��� ������ ���������� ROLLUP -> ���ʿ��ִ� �÷��� �������� ����, �� ����
--                       CUBE -> ����� �÷��� �������� ����(�ΰ���), �� ����
--ROLLUP
SELECT NVL(DEPT_CODE,'�Ѱ�'), SUM(SALARY)
FROM EMPLOYEE
WHERE DEPT_CODE IS NOT NULL
GROUP BY ROLLUP(DEPT_CODE);
--CUBE
SELECT NVL(DEPT_CODE,'�Ѱ�'), SUM(SALARY)
FROM EMPLOYEE
WHERE DEPT_CODE IS NOT NULL
GROUP BY CUBE(DEPT_CODE);

-- �ΰ��÷� �̻��� CROUP���� ���� ������ ó���ϴ°� �ٸ�
SELECT DEPT_CODE, JOB_CODE, SUM(SALARY)
FROM EMPLOYEE
WHERE DEPT_CODE IS NOT NULL
GROUP BY ROLLUP(DEPT_CODE, JOB_CODE);

SELECT DEPT_CODE, JOB_CODE, SUM(SALARY)
FROM EMPLOYEE
WHERE DEPT_CODE IS NOT NULL
GROUP BY CUBE(DEPT_CODE, JOB_CODE);

-- GROUPING() : ����� �÷��� Ȯ�����ִ� �Լ�
SELECT JOB_CODE, DEPT_CODE, COUNT(*), 
    CASE
        WHEN GROUPING(JOB_CODE)=1 AND GROUPING(DEPT_CODE)=0 THEN '�μ����ο�'
        WHEN GROUPING(JOB_CODE)=0 AND GROUPING(DEPT_CODE)=1 THEN '��å���ο�'
        WHEN GROUPING(JOB_CODE)=0 AND GROUPING(DEPT_CODE)=0 THEN '�׷캰�ο�'
        WHEN GROUPING(JOB_CODE)=1 AND GROUPING(DEPT_CODE)=1 THEN '���ο�'
    END AS ���
FROM EMPLOYEE
WHERE DEPT_CODE IS NOT NULL
GROUP BY CUBE(JOB_CODE, DEPT_CODE);

-- ��ȸ�� �����͸� �����ϱ�
-- ORDER BY �� ���
-- SELECT �÷�,�÷�
-- FROM ���̺�
-- [WHERE ���ǽ�]
-- [GROUP BY �÷���]
-- [HAVING �׷��Լ��̿� ����]
-- [ORDER BY �÷��� ���ɿɼ�(DESC,ASC:DEFAULT)]
-- ��ü����� �޿� ���� �޴� ������ �����ؼ� ��ȸ�ϱ�
SELECT *
FROM EMPLOYEE
ORDER BY SALARY DESC;

-- ����� �̸������� ��ü��� ��ȸ�ϱ�
SELECT * 
FROM EMPLOYEE
ORDER BY EMP_NAME DESC;

-- ORDER BY ������ �Ѱ��̻��� �÷��� ����� �� ����
SELECT *
FROM EMPLOYEE
ORDER BY DEPT_CODE DESC, SALARY DESC;
-- DESC, ASC : NULL��
-- DESC : NULL���� �ֻ������
-- ASC : NULL���� ���ϴ�����
-- NULLS FIRST||LAST�ɼ��� �̿��ϸ� NULL �����ġ�� ������ �� ����
SELECT BONUS
FROM EMPLOYEE
ORDER BY BONUS NULLS FIRST;

-- ORDER BY �÷��� �ε�����ȣ�� ��ü�� �� �ִ�
SELECT * FROM EMPLOYEE;
SELECT *
FROM EMPLOYEE
ORDER BY 6 DESC NULLS LAST, 9;

-- ���տ�����
-- �������� SELECT���� �Ѱ��� ����� ������ִ°�
-- ù��° SELECT���� �÷����� �� ���� SELECT���� �÷����� ���ƾ� ��, �� �÷��� TYPE�� ���ƾ���
-- UNION
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE='D5'
UNION
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY>=3000000;
--UNION ALL --�ߺ����� ������
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE='D5'
UNION ALL
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY>=3000000;

-- SELECT���� ������ �÷��� ���� �ٸ��� -> ����ȵ�
SELECT EMP_ID, EMP_NAME, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE='D5'
UNION
SELECT EMP_ID, EMP_NAME, 0 --�÷� ���� ������� ������ ��||�÷� �־�ߵ�
FROM EMPLOYEE
WHERE SALARY>=3000000;

-- SELECT���� �÷����� ������ TYPE�� �ٸ� ���
SELECT EMP_ID, EMP_NAME, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE='D5'
UNION
SELECT EMP_ID, EMP_NAME, EMAIL --�÷�Ÿ�� ������ߵ�
FROM EMPLOYEE
WHERE SALARY>=3000000;

-- ���տ����� �ٸ����̺�� ����
SELECT EMP_ID, EMP_NAME
FROM EMPLOYEE
WHERE JOB_CODE='J5'
UNION
SELECT DEPT_ID, DEPT_TITLE
FROM DEPARTMENT
UNION
SELECT JOB_CODE, JOB_NAME
FROM JOB;

-- MINUS, INTERSECT
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE='D5'
MINUS -- ��ø�Ȱ� ����
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY>=3000000;

SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE='D5'
INTERSECT -- ��ø�ȰŸ� ����
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY>=3000000;

-- JOIN�� ���� �˾ƺ���
-- �ΰ��̻��� ���̺��� Ư�� ���ذ����� �������ִ� ���(ROW�� ����)
-- JOIN ����
-- INNER JOIN : Ư�����ذ��� ��ġ�ϴ� ROW�� ���
-- OUTER JOIN : �������̺��� �����ؼ� �������̺��� ���ROW�� ����ϰ��ϴ� JOIN -> �����Ǵ� �����Ͱ� ����

-- INNER JOIN�� ����غ���
-- EMPLOYEE, DEPARTMENT ���̺� �����ϱ�
SELECT * FROM EMPLOYEE;
SELECT * FROM DEPARTMENT;

SELECT EMP_NAME, DEPT_TITLE, SALARY, BONUS
FROM EMPLOYEE JOIN DEPARTMENT ON DEPT_CODE=DEPT_ID;

-- �μ��� �ѹ����� ��� ��ȸ�ϱ�
SELECT *
FROM EMPLOYEE JOIN DEPARTMENT ON DEPT_CODE=DEPT_ID
WHERE DEPT_TITLE='�ѹ���';

-- ����� �̸�, ��å��, ���� ���ʽ��� ��ȸ�ϱ�
SELECT EMP_NAME, JOB.JOB_CODE, JOB_NAME
--FROM EMPLOYEE E JOIN JOB J ON E.JOB_CODE=J.JOB_CODE;
FROM EMPLOYEE JOIN JOB ON EMPLOYEE.JOB_CODE=JOB.JOB_CODE;
--FROM EMPLOYEE JOIN JOB USING(JOB_CODE); -- �����̺� ������ �̸��� �÷�
-- USING�� ����ϸ� ���̺� ��Ī�� �ο����� ����

-- JOIN�� ���̺� WHERE, GROUP BY, HAVING, ORDER BY ��� ����� ����

-- �μ��� �ο��� �޿� ����� ������ �μ���,�ο���,���
SELECT DEPT_TITLE AS �μ���, COUNT(*) AS �ο���, AVG(SALARY) AS ���
FROM EMPLOYEE JOIN DEPARTMENT ON DEPT_CODE=DEPT_ID
GROUP BY DEPT_TITLE;

-- ��å�� ������ ����� �̸�, ��å��, ��å�ڵ�, ������ ��ȸ�ϱ�
SELECT EMP_NAME, JOB_NAME, JOB_CODE, SALARY
FROM EMPLOYEE JOIN JOB USING(JOB_CODE)
WHERE JOB_NAME='����';

-- OUTER JOIN Ȱ���ϱ�
-- �������̺� ������ �����ؼ� ������ �� ���̺��� ��� �����͸� ����ϰ� �ϴ°�
-- ������̺��� ����
-- LEFT||RTGHT JOIN
SELECT *
FROM EMPLOYEE LEFT OUTER JOIN DEPARTMENT ON DEPT_CODE=DEPT_ID
--FROM EMPLOYEE RIGHT OUTER JOIN DEPARTMENT ON DEPT_CODE=DEPT_ID;
WHERE DEPT_TITLE IS NULL;


-- CROSS JOIN
-- ���������� �������� �ʾ� ��� ROW�� ���� ������ �Ǵ� ���̺� ����
SELECT EMP_NAME, DEPT_TITLE
FROM EMPLOYEE CROSS JOIN DEPARTMENT
ORDER BY 1, 2;

-- SELF JOIN
-- ���������̺� �Ѱ��� ������ �ΰ��� ���̺�ó�� �����ϴ� JOIN
-- �����̺� ������ �����͸� ������ �÷��� �־���Ѵ�
SELECT * FROM EMPLOYEE;
-- MANAGER�� �ִ� ������̸�, �Ŵ��� �̸�, �����ȣ�� ��ȸ
SELECT E.EMP_NAME, E.EMP_ID, E.MANAGER_ID, M.EMP_NAME, M.EMP_ID
FROM EMPLOYEE E JOIN EMPLOYEE M ON E.MANAGER_ID=M.EMP_ID;
-- MANAGER�� ���� ����� �̸��� '����' ���
SELECT E.EMP_NAME, E.EMP_ID, E.MANAGER_ID, NVL(M.EMP_NAME,'����'), M.EMP_ID
FROM EMPLOYEE E LEFT JOIN EMPLOYEE M ON E.MANAGER_ID=M.EMP_ID;

-- ��������
-- �ΰ��̻��� ���̺� �����ؼ� ��ȸ�ϱ�
-- ����� �̸�,  �μ���, ��å��, �޿�, ���ʽ��� ��ȸ�ϱ�
SELECT EMP_NAME, DEPT_TITLE, JOB_NAME, SALARY, BONUS
FROM EMPLOYEE 
    LEFT JOIN DEPARTMENT ON DEPT_CODE=DEPT_ID
    JOIN JOB USING(JOB_CODE);

-- ����� �����, �μ���, ��å��, �ٹ�������(LOCALNAME) ��ȸ�ϱ�
SELECT * FROM LOCATION;
SELECT * FROM DEPARTMENT;

SELECT EMP_NAME, DEPT_TITLE, JOB_NAME, LOCATION_ID, LOCAL_NAME
FROM EMPLOYEE
    JOIN JOB USING(JOB_CODE)
    LEFT JOIN DEPARTMENT ON DEPT_ID=DEPT_CODE
    LEFT JOIN LOCATION ON LOCATION_ID=LOCAL_CODE;

-- �񵿵����� Ȱ���ϱ�
-- ������ ���� ROW�� �����ϴ� JOIN���
-- ������ ��Ÿ���� �÷��� ������ ���̺��� �־����
SELECT * FROM SAL_GRADE;
-- ����Ʈ�� ȸ����޼���, ������ ���� ��ǰ���¼���
SELECT *
FROM EMPLOYEE
    JOIN SAL_GRADE ON SALARY BETWEEN MIN_SAL AND MAX_SAL;


-- �������� -> SELECT�� �ȿ� �Ǵٸ� SELECT���� �ۼ��ϴ� ��
-- MAIN QURRY -> ���������� ���ΰ� �ִ� SELECT��
-- SUB QURRY -> MAIN QURRY���ο� �ִ� SELECT��
-- ������ ����� �Ŵ����� ������ ����ϱ�
SELECT MANAGER_ID FROM EMPLOYEE WHERE EMP_NAME='������';
SELECT * FROM EMPLOYEE WHERE EMP_ID='214';
-- �������� �̿��ؼ� ó���ϱ�
SELECT *
FROM EMPLOYEE
WHERE EMP_ID=(SELECT MANAGER_ID FROM EMPLOYEE WHERE EMP_NAME='������');

- D5�μ��� ��ձ޿����� ���� �޴� ��� ��ȸ�ϱ�
SELECT AVG(SALARY) FROM EMPLOYEE WHERE DEPT_CODE='D5';
SELECT *
FROM EMPLOYEE
WHERE SALARY>=(SELECT AVG(SALARY) FROM EMPLOYEE WHERE DEPT_CODE='D5');

-- 1. ������ ��������
-- SELECT���� ����� 1�� �÷�, 1�� ROW���� ��
-- WHERE��, SELECT�÷��� ���� ���
-- ������� �޿� ��պ��� ���� �޿��� �޴� ��� �̸�, �޿�, �μ��ڵ� ��ȸ
SELECT EMP_NAME, SALARY, DEPT_CODE, FLOOR((SELECT AVG(SALARY) FROM EMPLOYEE)) AS ��ձ޿�
FROM EMPLOYEE
WHERE SALARY>=(SELECT AVG(SALARY) FROM EMPLOYEE);
 
 -- �μ��� �ѹ����� ����� ��ȸ�ϱ�
 SELECT *
 FROM EMPLOYEE
 WHERE DEPT_CODE=(SELECT DEPT_ID FROM DEPARTMENT WHERE DEPT_TITLE='�ѹ���');
 
 SELECT *
 FROM EMPLOYEE JOIN DEPARTMENT ON DEPT_CODE=DEPT_ID
 WHERE DEPT_TITLE='�ѹ���';
 
 -- ������ ��������
 -- RESULT SET SELECT���� ����� �ټ� ROW�� ��µǴ� ��
 -- ��å�� ����, ������ ����� ��ȸ�ϱ�
 SELECT JOB_CODE FROM JOB WHERE JOB_NAME IN('����', '����');
 SELECT *
 FROM EMPLOYEE
 WHERE JOB_CODE IN (SELECT JOB_CODE FROM JOB WHERE JOB_NAME IN('����', '����'));
 
 -- ���߱�, �ڳ���� ���� �ٹ��ϴ� ��� �����ϱ�
 SELECT *
 FROM EMPLOYEE
 WHERE DEPT_CODE IN (SELECT DEPT_CODE FROM EMPLOYEE WHERE EMP_NAME IN('���߱�', '�ڳ���'));
 
 -- �μ��� �ְ�޿��� �޴� ��� ���ϱ�
 SELECT *
 FROM EMPLOYEE
 WHERE SALARY IN(SELECT MAX(SALARY) FROM EMPLOYEE GROUP BY DEPT_CODE);
 
 -- ������ ��Һ��ϱ�
 -- ANY, ALL �Լ��� �̿��Ͽ� ó��
 -- ANY : �� �ټ��� �� �ϳ��� ���̸� ��
 -- �÷�>(=) ANY(���߰�) : ���߰� �� �ϳ��� �÷����� ������ �� -> ���߰��� �ּҰ����� ũ�� ��
 -- �÷�<(=) ANY(���߰�) : ���߰� �� �ϳ��� �÷����� ũ�� �� -> ���߰��� �ִ밪���� ������ ��
 SELECT *
 FROM EMPLOYEE
-- WHERE SALARY > ANY(SELECT MIN(SALARY) FROM EMPLOYEE GROUP BY DEPT_CODE);
 WHERE SALARY < ANY(SELECT MIN(SALARY) FROM EMPLOYEE GROUP BY DEPT_CODE); 
 
 -- ALL : ���߰� ��ΰ� ���϶� ��
 -- �÷�>(=) ALL(���߰�) : ���߰��� �ִ밪���� ũ�� ��
 -- �÷�<(=) ALL(���߰�) : ���߰��� �ּڰ����� ������ ��
 SELECT *
 FROM EMPLOYEE
 WHERE SALARY > ALL(SELECT MIN(SALARY) FROM EMPLOYEE GROUP BY DEPT_CODE);

-- 2000�� 1�� 1�� ������ �Ի����� 2000�� 1��1�� ���� �Ի��� ��� �� �޿��� ���� ���� �޴� ������� �׺��� ���� �����ȸ�ϱ�
SELECT * 
FROM EMPLOYEE
WHERE HIRE_DATE<'00/01/01'
--AND SALARY>(SELECT MAX(SALARY) FROM EMPLOYEE WHERE HIRE_DATE>'00/01/01');
AND SALARY> ALL(SELECT SALARY FROM EMPLOYEE WHERE HIRE_DATE>'00/01/01');

-- ���߿� �������� : ROW 1�� COLUMN ������
-- ������ ������� �����μ� ���� ���޿� �ش��ϴ� ��� ��ȸ�ϱ�
SELECT DEPT_CODE, JOB_CODE FROM EMPLOYEE WHERE ENT_YN='Y';

SELECT * 
FROM EMPLOYEE
WHERE (DEPT_CODE, JOB_CODE) IN (SELECT DEPT_CODE, JOB_CODE FROM EMPLOYEE WHERE ENT_YN='Y');

-- ����������̸鼭 �޿��� 200������ ����� �ִٰ� �Ѵ� �� ����� ������ ��ȸ�ϱ�
SELECT * -- �ȵ� Ȯ��
FROM EMPLOYEE
WHERE (DEPT_CODE, SALARY) IN (SELECT DEPT_CODE, SALARY
                            FROM EMPLOYEE JOIN DEPARTMENT ON DEPT_CODE=EMPT_ID
                            WHERE DEPT_TITLE='���������' AND SALARY=2000000);

-- ������ ���߿�
-- �ѹ����̸鼭 300���� �̻� �޿��� �޴� ���
SELECT EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE JOIN DEPARTMENT ON DEPT_CODE=DEPT_ID
WHERE DEPT_TITLE='�ѹ���' AND SALARY>=3000000;

SELECT EMP_NAME, DEPT_CODE, SALARY --�ȵ� Ȯ��
FROM EMPLOYEE 
WHERE (DEPT_CODE, SALARY) IN (SELECT DEPT_CODE, SALARY
                                FROM EMPLOYEE JOIN DEPARTMENT ON DEPT_CODE=DEPT+ID
                                WHERE DEPT_TITLE='�ѹ���' AND SALARY>=3000000);

-- �����������
-- ���������� �����Ҷ� ���������� ���� ������ ����ϰ� �����Ͽ� �������� ����� ������������ ������ �ް� ���������� �����
-- �������� ����� ������ ��ġ�ԵǴ� ����

-- �� ����� ���� �μ��� �ο��� ��ȸ�ϱ�
-- ��ø �ݺ����� �����ϴ°Ͱ� ���
SELECT EMP_NAME, DEPT_CODE, (SELECT COUNT(*) FROM EMPLOYEE WHERE DEPT_CODE=E.DEPT_CODE) AS �ο���
FROM EMPLOYEE E;
SELECT COUNT(*) FROM EMPLOYEE WHERE DEPT_CODE='D9';
SELECT COUNT(*) FROM EMPLOYEE WHERE DEPT_CODE='D6';

-- �ڽ��� ���� �μ��� ��ձ޿����� �޿��� ���� �޴� ����� ��ȸ�ϱ�
SELECT * FROM EMPLOYEE;
SELECT *
FROM EMPLOYEE E
WHERE SALARY > (SELECT AVG(SALARY) FROM EMPLOYEE WHERE DEPT_CODE=E.DEPT_CODE);
SELECT AVG(SALARY) FROM EMPLOYEE WHERE DEPT_CODE='D9';


-- FROM���� �������� ����ϱ�
-- INLINE VIEW -> ������ ���߿� ���������� ���
-- �����÷��� �߰��� SELECT���̳� ���տ����� ����� SELECT���� INLINE VIEW�� ���� ���
-- STORED VIEW -> ����Ŭ���� �����ϴ� �ϳ��� OBJECT
-- INLINE VIEW�� 1ȸ��
-- STORED VIEW�� Ư����Ī���� INLINE VIEW�� �����ؼ� ��� -> VIEWTABLE�̶�� ��
SELECT * 
FROM EMPLOYEE;
SELECT * 
FROM EMPLOYEE
WHERE SUBSTR(EMP_NO,8,1)='2';

SELECT *
FROM (SELECT E.*, DECODE(SUBSTR(EMP_NO,8,1),'1','��','2','��') AS GENDER FROM EMPLOYEE E)
WHERE GENDER='��';

--JOIN��
SELECT *
FROM (SELECT E.*,D.*,JOB_NAME,
        (SELECT TRUNC(AVG(SALARY),-1) FROM EMPLOYEE WHERE DEPT_CODE=E.DEPT_CODE) AS DEPT_SAL,
        (SELECT COUNT(*) FROM EMPLOYEE WHERE JOB_CODE=E.JOB_CODE) AS JOB_COUNT
        FROM EMPLOYEE E LEFT JOIN DEPARTMENT D ON DEPT_CODE=DEPT_ID
        JOIN JOB J ON E.JOB_CODE=J.JOB_CODE)
WHERE DEPT_SAL>3000000 AND JOB_COUNT=4;

-- INLINE VIEW�� ���������� INLINE VIEW���� ������ �÷��� �̿��� �� ����
SELECT *
FROM (SELECT EMP_NAME, SALARY, DEPT_CODE FROM EMPLOYEE)
WHERE DEPT_CODE='D5';

SELECT *
FROM (
    SELECT EMP_ID AS CODE, EMP_NAME AS NAME
    FROM EMPLOYEE
    UNION
    SELECT DEPT_ID, DEPT_TITLE
    FROM DEPARTMENT
    UNION
    SELECT JOB_CODE, JOB_NAME
    FROM JOB)
WHERE CODE LIKE '%1%';


-- �����͸� �������� ���� ����ϴ� ���� �ۼ��ϱ�
-- 2���� ���
-- 1. ����Ŭ���� �����ϴ� ROWNUM�÷��� �̿��ؼ� ���
-- SELECT���� ����Ǹ� �ڵ����� ����Ŭ�� �ο��ϴ� �����÷� SELECT���� ����ɶ� ROW�� ��ȣ�� �ο��� �÷�
SELECT ROWNUM, E.*
FROM EMPLOYEE E
WHERE ROWNUM BETWEEN 1 AND 3;
-- �޿��� ���� �޴� ��� 1�� 3����� ��ȸ�ϱ�
SELECT ROWNUM, E.*
FROM EMPLOYEE E
WHERE ROWNUM BETWEEN 1 AND 3
ORDER BY SALARY;

-- ROWNUM�� ����ؼ� �������� ������ ����Ϸ��� INLINE VIEW�� �̿��ؾ��Ѵ�
-- �߰������� ���� �����͸� ����� ���� ����
SELECT *
FROM(
    SELECT ROWNUM AS RNUM, E.*
    FROM (SELECT * FROM EMPLOYEE ORDER BY SALARY) E
    )
WHERE RNUM BETWEEN 5 AND 10;
    
-- 2. ����Ŭ���� �����ϴ� WINDOW�Լ��� �̿��ؼ� ����ϴ� ���




























