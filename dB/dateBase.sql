SELECT * FROM DBA_USERS;
-- 실습을 위한 사용자 계정만들기
-- SYSTEM(관리자 계정)으로 생성을 해줘야한다
-- CREATE USER 사용자명 IDENTIFIED BY 비밀번호 DEFAULT TABLESPACE USERS QUOTA UNLIMITED ON USERS;
-- 18C 버전부터는 사용자명에 ##을 부여하게 되어있음 -> 해제할 수 있음, 해제해서 사용하자
ALTER SESSION SET "_ORACLE_SCRIPT"=TRUE;
CREATE USER BS IDENTIFIED BY BS DEFAULT TABLESPACE USERS QUOTA UNLIMITED ON USERS;
-- 생성된 계정 확인하기
SELECT * FROM DBA_USERS; --데이터베이스에 등록된 계정을 조회하는 명령어


-- 생성된 계정으로 접속하기 -> 접속만들기 -> 접속
-- 생성된 계정으로 접속이 금지되어있음 -> 권한이 없음
-- 관리자 계정으로 사용자에게 접속권한 부여해주기 -> CONNECT권한 부여
-- GRANT 권한명||ROLE이름 TO 계정
GRANT CONNECT TO BS;


-- BS계정으로 접속해서 명령어 실행해보기
SELECT * FROM TAB; -- BS계정이 가지고 있는 테이블(데이터를 저장하는 공간) 조회하기
-- 저장공간 생성해보기
-- 샘플로 TEST이름의 저장공간을 생성하는 구문
-- 기본적으로 저장공간을 생성할 수 있는 권한은 부여되어 있지않다 -> SYSTEM계정으로 부여를 해줘야함
CREATE TABLE TEST(
    TEST_NAME VARCHAR2(200)
);

-- 저장공간생성하는 권한 부여하기 -> 부여하고 상단 CREATE 실행
GRANT RESOURCE TO BS;

-- 사용자가 생성한 테이블 조회
SELECT * FROM TAB;

-- 새로운 계정을 생성을 하게 되면 SYSTEM계정으로 알맞는 권한을 부여해줘야한다
-- 기본적으로 RESOURCE, CONNECT권한을 부여한다

-- BS계정에 추가된 데이터 확인하기
-- 추가된 테이블(저장공간) 확인하기
SELECT * FROM TAB;
-- EMPLOYEE : 사원정보 저장테이블
SELECT * FROM EMPLOYEE;
-- DEPARTMENT : 부서정보 저장테이블
SELECT * FROM DEPARTMENT;
-- JOB : 직책정보 저장테이블
SELECT * FROM JOB;
-- LOCATION : 부서지역정보 저장테이블
SELECT * FROM LOCATION;
-- NATIONAL : 국가정보 저장테이블
SELECT * FROM NATIONAL;
-- SAL_GRADE : 급여수준 저장테이블
SELECT * FROM SAL_GRADE;


-- SELECT문 활용하기
-- 기본 SELECT문
-- SCLECT 컬럼명, 컬럼명, ....(컬럼을 선택)
-- FROM 테이블명


-- EMPLOYEE 테이블의 EMP_ID, EMP_NAME, SALARY 컬럼을 조회하기
SELECT EMP_ID, EMP_NAME, SALARY
FROM EMPLOYEE;

-- DEPARTMENT테이블의 DEPT_TITLE 조회하기
SELECT DEPT_TITLE
FROM DEPARTMENT;

-- EMPOLYEE테이블에 있는 전체 칼럼을 조회하기
-- SELECT문에 컬럼을 설정부분에 * 을 사용하면 된다
SELECT *
FROM EMPLOYEE;

-- DEPARTMENT테이블에 있는 전체 칼럼을 조회하기
SELECT * FROM DEPARTMENT;

-- 계정에 저장되어있는 테이블과 칼럼 확인하기
-- 테이블조회
SELECT * FROM TAB;
-- 테이블의 컬럼명 조회하기
DESC DEPARTMENT;


-- SELECT문을 이용해서 산술연산 처리결과를 확인할 수 있음
SELECT 1+10 FROM EMPLOYEE;
-- 테스트용 기본 테이블 제공 -> DUAL테이블
-- 간단한 계산, 오라클제공함수 실행할 때 사용
SELECT 1+10, 5*3, 10/2 FROM DUAL;
-- 계산결과를 출력해주는 컬럼 -> 가상컬럼이라고 함
-- 데이터가 있는 테이블의 컬럼과 산술연산이 가능
-- EMPLOYEE테이블의 SALARY에 100더하기
SELECT EMP_NAME, SALARY, SALARY+100
FROM EMPLOYEE;


-- 각 사원의 이름, 월급 연봉을 조회하기
SELECT EMP_NAME, SALARY, SALARY*12
FROM EMPLOYEE;

-- 컬럼값이 NULL인 경우 산술연산이 불가능 -> 함수를 이용해서 NULL일때 대체값을 지정할 수 있음
SELECT * FROM EMPLOYEE;
--SELECT EMP_NAME, BONUS, BONUS+0.5
SELECT EMP_NAME, BONUS, NVL(BONUS,0)+0.5
FROM EMPLOYEE;

-- 칼럼과 산수연산을 할 경우 칼럼의 타입이 숫자형이여야 한다
SELECT EMP_NAME+100
FROM EMPLOYEE; -- 계산안됨

-- FROM절에서 사용한 테이블에 있는 컬럼만 조회가 가능하다
SELECT DEPT_ID, DEPT_TITLE --EMP_NAME(이거 추가하면 오류나옴)
FROM DEPARTMENT;

-- 컬럼명을 새롭게 지정할 수 있음 -> 별칭부여하기
SELECT EMP_ID, EMP_NAME, EMAIL
FROM EMPLOYEE;
-- 컬럼을 선택하고 AS예약어를 이용해서 별칭을 부여
SELECT EMP_ID AS 사원번호, EMP_NAME AS 사원명, EMAIL AS 이메일
FROM EMPLOYEE;
-- 가상컬럼에 별칭을 부여하는 경우가 많음
SELECT EMP_ID, EMP_NAME, SALARY, SALARY*12 AS YEAR_SALARY
FROM EMPLOYEE;
-- 별칭은 **을 이용해서 띄어쓰기를 할 수 있다
SELECT EMP_ID AS "사원 번호", EMP_NAME AS "이%름"
FROM EMPLOYEE;

-- 중복데이터(ROW)를 제거 조회하기 
-- DISTINCT예약어를 사용해서 조회를 한다
SELECT DISTINCT DEPT_CODE
FROM EMPLOYEE;

-- DISTINCT는 SELECT 예약어 다음에만 사용이 가능
SELECT EMP_NAME, DISTINCT DEPT_CODE
FROM EMPLOYEE; --안됨

SELECT DISTINCT DEPT_CODE, JOB_CODE -- DISTINCT 뒤에가 하나로 묶여서 중복값제거
FROM EMPLOYEE;

-- 문자열을 결합해주는 연산처리하기
-- || -> 문자열을 결합
-- 오라클에서 문자열 리터럴표시 -> ''
SELECT '여러분 '||'점심맛있게 먹엇나요?' AS MSG
FROM DUAL;

-- 문자열 컬럼을 결합하여 출력할때도 사용
SELECT EMP_NAME||'님의 이메일은'||EMAIL
FROM EMPLOYEE;

SELECT * FROM EMPLOYEE;
-- 데이터(ROW)를 필터하기 -> 조건에 맞는 데이터 조회하기
-- WHERE 예약어를 사용
-- 사용
-- SELECT * ||컬럼명,컬럼명...
-- FROM 테이블명
-- WHERE 조건문(비교연산(=,>=,<=,!=), 논리연산(AND, OR))
-- EMPLOYEE 테이블에서 월급이 300만원 이상인 사원을 조회하자
SELECT EMP_NAME, SALARY
FROM EMPLOYEE
WHERE SALARY>=3000000;

-- EMPLOYEE 테이블에서 DEPT_CODE가 D5인 사원을 조회하기
SELECT * FROM EMPLOYEE
WHERE DEPT_CODE='D5';

-- EMPLOYEE 테이블에서 JOB_CODE가 J2인 사원의 이름,급여,직책코드 조회하기
SELECT EMP_NAME, SALARY, JOB_CODE
FROM EMPLOYEE
WHERE JOB_CODE='J2';

-- EMPLOYEE 테이블에서 부서코드가 D5가 아닌 사원의 이름,부서코드 조회하기
SELECT EMP_NAME, DEPT_CODE
FROM EMPLOYEE
WHERE DEPT_CODE != 'D5';

-- EMPLOYEE 테이블에서 부서코드가 D5이고 월급이 300만원이상인 사원의 전체컬럼조회하기
SELECT * FROM EMPLOYEE
WHERE DEPT_CODE='D5' AND SALARY>=3000000;

-- EMPLOYEE 테이블에서 부서코드가 D5이거나 월급이 300만원 이하인 사원의 전체컬럼 조회하기
SELECT *
FROM EMPLOYEE
WHERE DEPT_CODE='D5' OR SALARY<=3000000;

-- 날짜형 데이터도 대소비교가 가능하다
-- 날짜표시는 문자열로 패턴에 맞춰서 표현 -> 'YYYY/MM/DD' 'YY/MM/DD'
-- EMPLOYEE테이블에서 입사일(HIRE_DATE)이 2000년도 이전인 사원을 구하기
SELECT *
FROM EMPLOYEE
WHERE HIRE_DATE < '00/01/01';


-- 특정범위를 조회하는 구문
-- AND 연결하여 사용, BETWEEN AND를 사용해서 처리하는 방법
-- EMPLOYEE테이블에서 월급을 200만원 이상 300만원 이하로 받는 사원의 이름, 급여, 보너스, 입사일 조회하기
SELECT EMP_NAME, SALARY, BONUS, HIRE_DATE
FROM EMPLOYEE
--WHERE SALARY>=2000000 AND SALARY<=3000000;
WHERE SALARY BETWEEN 2000000 AND 30000000;

--EMPLOYE테이블에서 입사일이 00년대인 사원을 조회하기
SELECT *
FROM EMPLOYEE
--WHERE HIRE_DATE>='00/01/01' AND HIRE_DATE<='00/12/31';
WHERE HIRE_DATE BETWEEN '00/01/01' AND '00/12/31';


-- LIKE연산자 이용하기
-- 문자열 데이터를 패턴으로 비교하는 연산 -> 부분일치, 패턴에 맞는 문자열을 찾을때 사용
-- 이메일 'EA'가 있는 사원, 성이 김씨인 사원, 주민번호에 32가 있는 사원
-- 컬럼명 LIKE '비교할문자패턴'
-- % : 문자가 0개이상 아무문자나 허용
--예) '%강%' : 강이 있는 포함된 문자열 한강(O), 강사(O), 강하라(O), 강강술래(O), 김강우(O), ㅁㄴㅇㄻ강ㅁㅇㄻ(O)
--    '강%' : 강으로 시작되는 문자열

-- _ : 문자가 1개 아무문자나 허용
--예) '_강_' : 3글자 문자열 중간에 강이 있는것
--예) '_유%' : 2글자이상 문자열 두번째 글자가 '유'인 문자열

-- 사원 중 유씨성을 가진 사원의 사원명, 월급, 부서코드 조회하기
SELECT EMP_NAME, SALARY, DEPT_CODE
FROM EMPLOYEE
--WHERE EMP_NAME LIKE '유%';
WHERE EMP_NAME LIKE '유__';
-- EMAIL에 YO를 포함하고 있는 사원의 이름, 이메일을 조회하기
SELECT EMP_NAME, EMAIL
FROM EMPLOYEE
WHERE EMAIL LIKE '%y%';

-- LIKE부정연산하기
-- 사원의 성이 유가 아닌 사원들 조회하기
SELECT * FROM EMPLOYEE
WHERE EMP_NAME NOT LIKE '유%';

-- 이메일주소에 _앞글자가 3글자인 사원의 사원명, 이메일 조회하기
SELECT EMP_NAME, EMAIL
FROM EMPLOYEE
WHERE EMAIL LIKE '___*_%' ESCAPE '*'; -- '*'을 문자열로 봐라

-- NULL값 비교하기
-- 기본적으로 NULL값은 비교연산 처리를 할 수 없다
-- NULL값을 처리하기 위한 연산자를 만들어 놓음
-- IS NULL / IS NOT NULL
-- 사원중 보너스를 받는 사원의 이름, 급여, 보너스를 조회하기
SELECT * FROM EMPLOYEE
WHERE BONUS IS NOT NULL;

-- 사원중 매니저가 지정되지않은 사원을 조회하기
SELECT * FROM EMPLOYEE
WHERE MANAGER_ID IS NULL;

-- 부서가 없는 사원 조회하기
-- 부서코드에 인턴으로 작성하기 (NVL)
SELECT E.*, NVL(DEPT_CODE, '인턴') 
FROM EMPLOYEE E
WHERE DEPT_CODE IS NULL;

-- 다중값 동등비교하기
-- OR로 연결해서 처리하기 IN을 활용하기
-- 사원중 부서가 D5이거나 D6인 사원의 사원명, 부서코드를 조회하기
SELECT EMP_NAME, DEPT_CODE
FROM EMPLOYEE
--WHERE DEPT_CODE='D5' OR DEPT_CODE='D6';
--WHERE DEPT_CODE IN ('D5','D6');
WHERE DEPT_CODE IN (SELECT DEPT_CODE FROM EMPLOYEE WHERE EMP_NAME IN('심봉선', '송종기'));

-- 심봉선, 송종기 사원과 같은 부서인 사원구하기
SELECT DEPT_CODE FROM EMPLOYEE
WHERE EMP_NAME IN('심봉선', '송종기');

-- NOT IN ()사용하기
-- D5, D6이 아닌 사원 조회하기
SELECT *
FROM EMPLOYEE
WHERE DEPT_CODE NOT IN ('D5','D6');

-- 논리연산사용시 연산자 우선순위에 유의하자
-- 직책이 J7이거나 J2인 사원 중 급여가 200만원 이상인 사원을 조회
SELECT EMP_NAME, JOB_CODE, SALARY
FROM EMPLOYEE
WHERE (JOB_CODE='J7' OR JOB_CODE='J2') AND SALARY>=2000000;

-- WHERE 절에도 산술연산을 사용할 수 있다
SELECT *
FROM EMPLOYEE
WHERE SALARY > SALARY*12;



-- 오라클에서 제공하는 함수를 사용해보자
-- 함수를 사용할때는 SELECT문에서 사용을 한다
-- SELECT문의 컬럼쓰는 곳이나 WHERE에 사용을 할 수 있다

-- 단일행함수 선택한 테이블에 있는 모든 ROW에 결과를 출력해주는 함수
-- 문자열 처리함수
-- LENGTH() : 매개변수로 전달된 컬럼이나 리터럴의 길이를 출력해주는 함수
SELECT LENGTH('유병승') FROM DUAL;
-- 이메일 길이 확인하기
SELECT LENGTH(EMAIL), EMAIL FROM EMPLOYEE;

-- 이메일의 길이가 13이상인 사원
SELECT EMAIL
FROM EMPLOYEE
WHERE LENGTH(EMAIL)>=13;

-- LENGTHB()

-- INSTR() : JAVA INDEXOF() 메소드와 유사
-- 문자열의 인덱스 위치를 반환해주는 함수
-- INSTR(대상문자열||컬럼, 찾을문자열[, 검색시작위치]) : 찾은 문자열의 인덱스번호를 반환
SELECT INSTR('메가스터디IT', 'IT'), INSTR('메가스터디IT', '메가')
FROM DUAL;

SELECT EMAIL, INSTR(EMAIL, 'j')
FROM EMPLOYEE
WHERE INSTR(EMAIL, 'j')=0;

SELECT INSTR('메가 스터디 메가스터디 IT 메가 스터디 미용', '메가', 4),
INSTR('메가 스터디 메가스터디 IT 메가 스터디 미용', '메가', 1,3)
FROM DUAL;

-- LPAD/RPAD : 지정한 길이에 문자열이 채워지지 않았을때 특정문자로 채워주는 함수
-- LPAD||RPAD(문자열||컬럼명, 길이, 공백시채워줄문자)
SELECT LPAD('메가',10,'*'), RPAD('메가',10,'*')--*6개, 메가 2개(2BYTE)
FROM DUAL;

SELECT RPAD(EMP_NAME, 8, '남')
FROM EMPLOYEE;

-- LTRIM/RTRIM : 공백 또는 특정 문자를 삭제해주는 기능
SELECT '    유병승', LTRIM('    유병승'), '1111병승', LTRIM('1111병승','1'), LTRIM('11211병승','1')
FROM DUAL;

-- TRIM : 양쪽의 값을 제거하는 함수, 기본 : 공백, 설정한 값을 제거
SELECT '     병승     ', TRIM('     병승     '),
TRIM('Z' FROM 'ZZZZZ병승ZZZZZ'),
TRIM(LEADING 'Z' FROM 'ZZZZZ병승ZZZZZ'),
TRIM(TRAILING 'Z' FROM 'ZZZZZ병승ZZZZZ'),
TRIM(BOTH 'Z' FROM 'ZZZZZ병승ZZZZZ')
FROM DUAL;

-- SUBSTR : JAVA SUBSTRING메소드와 유사한 함수
-- SUBSTR(대상문자열, 시작인덱스[,끝인덱스])
SELECT EMP_NAME, SUBSTR(EMP_NAME,1,1)
FROM EMPLOYEE;

SELECT DISTINCT SUBSTR(EMP_NAME,1,1) --DISTINCT 중복제거
FROM EMPLOYEE;

SELECT * FROM EMPLOYEE;
SELECT SUBSTR(EMP_NO,1,2) AS 년도, SUBSTR(EMP_NO,8,1) AS 성별
FROM EMPLOYEE;

SELECT *
FROM EMPLOYEE
WHERE SUBSTR(EMP_NO,1,2) BETWEEN 80 AND 89;

SELECT *
FROM EMPLOYEE
WHERE SUBSTR(EMP_NO,8,1) IN ('2','4');

-- 사원의 이메일에서 아이디만 출력하기
SELECT EMAIL, SUBSTR(EMAIL,1, INSTR(EMAIL,'@')-1)
FROM EMPLOYEE;

SELECT EMAIL, SUBSTR(EMAIL,1, INSTR(EMAIL,'@')-1)
FROM EMPLOYEE
WHERE LENGTH(SUBSTR(EMAIL,1, INSTR(EMAIL,'@')-1))>=7;

-- 영문자를 처리하는 함수
-- UPPER, LOWER, INITCAP
SELECT LOWER('Welcome to oRACLE world'),
UPPER('Welcome to oRACLE world'),
INITCAP('Welcome to oRACLE world')
FROM DUAL;

SELECT *
FROM EMPLOYEE
WHERE DEPT_CODE = UPPER('d5');

-- REPLACE : 대상문에서 지정문자를 찾아서 대체문자로 변경해주는 함수
-- REPLACE(문자열||컬럼명, '찾을문자', '대체문자')
SELECT EMAIL, REPLACE(EMAIL, 'SU.or.kr', 'BS.or.kr')
FROM EMPLOYEE;
UPDATE EMPLOYEE SET EMAIL=REPLACE(EMAIL, 'SU.or.kr', 'BS.or.kr');
SELECT * FROM EMPLOYEE;
COMMIT;

-- 숫자처리함수
-- 소숫점에 대한 처리, 계산에 대한 처리도 있다...
-- ABS : 절대값
SELECT ABS(-10), ABS(10)
FROM DUAL;

-- MOD() : 나머지구하는 함수 -> %
SELECT MOD(3,2)
FROM DUAL;

SELECT E.*, MOD(SALARY, 3)
FROM EMPLOYEE E;

-- 소숫점을 처리하는 함수
-- ROUND(반올림), FLOOR(소숫점버림), TRUNC(소숫점버림, 버리는 자리수 정함), CEIL(무조건 올림)
SELECT ROUND(125.556), FLOOR(125.567), TRUNC(125.567,2), CEIL(125.567)
FROM DUAL;

-- 보너스를 포함한 월급구하기
SELECT EMP_NAME, SALARY, FLOOR(SALARY+(SALARY*NVL(BONUS,0)-(SALARY*0.03))) AS SALARY
FROM EMPLOYEE;

-- 날짜처리함수
-- 오라클에서 날짜를 출력할때 두가지
-- SYSDATE예약어를 사용 -> 오늘날짜출력(DB서버컴퓨터에 설정한 날짜)
-- SYSTIMESTAMP예약어 사용 날짜, 시간을 동시출력
SELECT SYSDATE, SYSTIMESTAMP FROM DUAL;

-- 날짜는 연산이 가능함. +, - 일수를 계산
SELECT SYSDATE, SYSDATE+3, SYSDATE-10
FROM DUAL;
--NEXT_DAY : 인자로 전달된 요일중 가장 가까운 다음날짜를 출력
SELECT NEXT_DAY(SYSDATE, '화'), NEXT_DAY(SYSDATE, '금')
FROM DUAL;

SELECT * FROM V$NLS_PARAMETERS; --위에 요일 한글은 여기서 KOREA로 설정되있어서 가능
ALTER SESSION SET NLS_LANGUAGE='KOREAN'; --나라변경가능 (DBA로 바꿔야댐)

-- LAST_DAY : 그달의 마지막날을 출력해주는 함수
SELECT LAST_DAY(SYSDATE)
FROM EMPLOYEE;

SELECT NEXT_DAY(HIRE_DATE, '토'), LAST_DAY(HIRE_DATE)
FROM EMPLOYEE;

-- 개월수를 계산해주는 (더해주는) 함수
-- ADD_MONTHS()
SELECT ADD_MONTHS(SYSDATE, -3), ADD_MONTHS(SYSDATE, 3)
FROM DUAL;

-- 두 날짜의 개월수차이를 출력해주는 함수
-- MONTHS_BETWEEN(날짜, 날짜)
SELECT FLOOR(MONTHS_BETWEEN(SYSDATE, '22/01/01'))
FROM DUAL;

-- 날짜의 년도, 월, 일을 따로 출력해주는 함수
-- EXTRACT(YEAR||MONTH||DAY FROM 날짜) : 숫자
SELECT EXTRACT(YEAR FROM SYSDATE), EXTRACT(MONTH FROM SYSDATE), EXTRACT(DAY FROM SYSDATE)
FROM DUAL;

SELECT EXTRACT(YEAR FROM SYSDATE)-1992
FROM DUAL;

--사원중 12월에 입사한 사원 조회하기
SELECT *
FROM EMPLOYEE
WHERE EXTRACT(MONTH FROM HIRE_DATE)=12;

--사원중 2000년대 입사한 사원 조회하기
SELECT *
FROM EMPLOYEE
WHERE EXTRACT(YEAR FROM HIRE_DATE) BETWEEN 2000 AND 2009;

-- 오늘부로 태훈씨가 군대로 끌려가게 되었습니다 ㅠㅠ 잘가 태훈씨, 군대복무기간은 1년6개월로
-- 전역일자를 구하고, 복무일수, 전역때까지 먹는 짬밥갯수(3)를 구하기
SELECT SYSDATE, ADD_MONTHS(SYSDATE, 18) AS 전역일, ADD_MONTHS(SYSDATE, 18)-SYSDATE AS 복무일수, (ADD_MONTHS(SYSDATE, 18)-SYSDATE)*3 AS 짬밥
FROM DUAL;

-- 형변환 함수 -> (자료형), parse000, string.valueOf
-- 오라클은 자동형변환이 잘 작동
-- 강제적 형변환을 이용해서 처리할 수 있음
-- 숫자 : NUMBER
-- 문자 : VARCHAR2
-- 날짜 : DATE, TIMESTAMP

-- TO_CHAR : 숫자, 날짜를 문자형으로 변경해주는 함수
-- 날짜형을 문자형으로 변경하기
-- 날짜를 기호로 표시해서 문자형으로 변경함
-- Y:년, M:월, D:일, H:시, MI:분, SS:초
SELECT SYSDATE, TO_CHAR(SYSDATE, 'YYYY-MM-DD'),
TO_CHAR(SYSDATE, 'YY.MM.DD'), TO_CHAR(SYSDATE, 'YY.MM.DD HH:MI:SS')
FROM DUAL;

-- 숫자를 문자로 변환하기
-- 패턴에 맞춰서 변환 -> 자리수에 대한 패턴을 설정
-- 0 : 변환하는 값이 해당자리에 없으면 0으로 표시,  자리에 값이 있으면 그 숫자로 표현
-- 9 : 변환하는 값이 해당자리에 없으면 표시 생략, 자리에 값이 있으면 그 숫자로 표현 
-- 통화를 표시하려면 L표시함
SELECT 12345678, TO_CHAR(12345678,'999,999,999'), 
TO_CHAR(12345678,'000,000,000'),
TO_CHAR(12345678,'L999,999,999'),
TO_CHAR(180.5, 'FM999.99'),--FM 자릿수 맞춰서 소숫점 표시
TO_CHAR(180.5, 'FM000.00')
FROM DUAL;

SELECT EMP_NAME, SALARY, TO_CHAR(SALARY,'L999,999,999') AS CONVERT
FROM EMPLOYEE;

-- 문자열을 숫자형으로 변경하는 함수
-- TO_NUMBER()
-- 패턴으로 변경
SELECT '1,000,000', TO_CHAR(TO_NUMBER('1,000,000', '999,999,999')+100, 'L999,999,999')
FROM DUAL;

-- 문자, 숫자를 날짜형으로 변경해주는 함수
-- TO_DATE() 날짜패턴으로 날짜형으로 변환
-- Y, M, D 기본날짜패턴 : YY/MM/DD
SELECT TO_DATE('22/12/25', 'YY/MM/DD')-SYSDATE, TO_DATE('221225', 'YYMMDD'),
    TO_DATE(221225, 'YYMMDD'), TO_DATE(20230108, 'YYYYMMDD'), 
    TO_DATE(TO_CHAR(001225, '009999'), 'YYMMDD') --앞자리 년도가 0이면 TO_CHAR로 변환 한번해줘야됨
FROM DUAL;

-- NULL 값을 처리해주는 함수
-- NVL() : 특정컬럼값이 NULL인 경우 대체값으로 출력해주는것
SELECT EMP_NAME, DEPT_CODE, NVL(DEPT_CODE, '인턴'), BONUS, NVL(BONUS, 0)
FROM EMPLOYEE
WHERE NVL(DEPT_CODE, '인턴')='인턴';
-- NVL2() : NULL값일때 값, NULL값이 아닐때 값을 설정
SELECT EMP_NAME, DEPT_CODE, NVL2(DEPT_CODE, '정규직', '인턴')
FROM EMPLOYEE;

-- 조건에 따라 출력값을 변경해주는 함수
-- 1. DECODE 
-- DECODE(컬럼명||문자열, '동등비교할값', '같았을때 출력할값', '동등비교할값', '같았을때 출력할값')
SELECT EMP_NAME, JOB_CODE, DECODE(JOB_CODE, 'J1', '대표', 'J2', '부사장', 'J3', '부장', '사원') --맨끝 사원은 DEFRALT 값이 되서 나머지 출력(사원)
FROM EMPLOYEE;
-- 성별을 남,여로 출력하는 컬럼만들기
SELECT EMP_NAME, SALARY, DECODE(SUBSTR(EMP_NO,8,1), '1', '남', '2', '여') AS GENDER
FROM EMPLOYEE
WHERE DECODE(SUBSTR(EMP_NO,8,1), '1', '남', '2', '여')='남';

-- 2. CASE WHEN THEN
-- CASE
--  WHEN 조건문 THEN 실행내용(출력구문)
--  WHEN 조건문 THEN 실행내용(출력구문)
--  WHEN 조건문 THEN 실행내용(출력구문)
--  ELSE 실행내용
-- END
SELECT EMP_NAME, JOB_CODE,
    CASE
        WHEN JOB_CODE='J1' THEN '대표'
        WHEN JOB_CODE='J2' THEN '부사장'
        WHEN JOB_CODE='J3' THEN '부장'
        WHEN JOB_CODE='J4' THEN '과장'
        ELSE '사원'
    END AS 직책,
    CASE
        WHEN SALARY>=30000000 THEN '고액월급'
        WHEN SALARY<=30000000 THEN '기본'
    END AS 비고
FROM EMPLOYEE;
        
-- 사원테이블에서 현재나이구하기
-- 오라클에서 년도를 표시하는 패턴값은 2가지 Y, R
SELECT EMP_NAME, EXTRACT(YEAR FROM SYSDATE)-EXTRACT(YEAR FROM TO_DATE(SUBSTR(EMP_NO,1,2), 'RR')),
    EXTRACT(YEAR FROM TO_DATE(SUBSTR(EMP_NO,1,2), 'YY')) AS YY, --YY로하면 지금 현재 세기인 20이 붙음
    EXTRACT(YEAR FROM TO_DATE(SUBSTR(EMP_NO,1,2), 'RR')) AS RR
FROM EMPLOYEE;

-- RR로 년도를 출력할때
-- 현재년도     입력년도       계산년도
-- 00~49        00~49       현세기
-- 00~49        50~99       전세기
-- 50~99        00~49       다음세기
-- 50~99        50~99       현세기

-- 그룹함수 활용하기
-- 테이블의 데이터를 종합해서 하나의 ROW로 결과를 출력하는 함수 -> 결과가 한개만 나옴
-- 컬럼값에 대한 합계, 평균, 갯수 구할때 사용
-- 그룹함수를 이용하면 SELECT문에서 컬럼의 사용이 제한 * 그룹함수에서 사용한 컬럼만 사용이 가능
-- 종류
-- SUM : 컬럼값에 대한 합계를 출력해주는 함수
-- AVG : 컬럼값에 대한 평균을 출력해주는 함수
-- COUNT : 테이블의 ROW수를 출력해주는 함수 * 컬럼값을 기준
-- MIN : 컬럼값의 가장 작은값을 출력해주는 함수
-- MAX : 컬럼값의 가장 큰값을 출력해주는 함수

-- 사원테이블에서 사원이 받는 급여의 합계를 조회하기
SELECT *
FROM EMPLOYEE;

SELECT SUM(SALARY) FROM EMPLOYEE;
-- 사원이 받는 급여의 평균을 조회
SELECT FLOOR(AVG(SALARY)) FROM EMPLOYEE;
SELECT SUM(SALARY), FLOOR(AVG(SALARY)) FROM EMPLOYEE;

--부서가 D5인 사원의 급여 합계, 평균을 구해라
SELECT SUM(SALARY) AS 합계, AVG(SALARY) AS 평균
FROM EMPLOYEE
WHERE DEPT_CODE='D5';

-- SUM, AVG이용시 NULL값이 있는 경우? -> 연산에서 빼버림
SELECT TRUNC(AVG(BONUS),3), TRUNC(AVG(NVL(BONUS,0)),3)
FROM EMPLOYEE;

-- ROW의 갯수를 출력해주는 함수
SELECT COUNT(*) FROM EMPLOYEE;
-- D5부서의 사원수 구하기
SELECT COUNT(*) 
FROM EMPLOYEE
WHERE DEPT_CODE='D9';

-- 400만원 이상 급여를 받는 사원수
SELECT COUNT(*)
FROM EMPLOYEE
WHERE SALARY>=4000000;

-- 현재 보너스를 받고 있는 사원수
SELECT COUNT(*)
FROM EMPLOYEE
WHERE BONUS IS NOT NULL;

-- 부서가 D6,D5,D9인 사원의 수, 급여평균, 급여합계 조회하기
SELECT COUNT(*) AS 수, TRUNC(AVG(SALARY),-2) AS 평균, SUM(SALARY) AS 합계
FROM EMPLOYEE
WHERE DEPT_CODE IN('D6','D5','D9') AND SALARY >=3000000;

-- COUNT(*) VS COUNT(컬럼명)
SELECT COUNT(*), COUNT(DEPT_CODE), COUNT(BONUS)
FROM EMPLOYEE;

-- MIN/MAX
SELECT MAX(SALARY), MIN(SALARY)
FROM EMPLOYEE;

-- 그룹함수는 WHERE에서 사용이 불가능함
SELECT *
FROM EMPLOYEE
WHERE MAX(SALARY)=SALARY; --불가능

-- GROUP BY 절 이용하기
-- GROUP BY 는 특정컬럼의 값을 기준으로 묶어서 결과값을 출력하는 명령어
-- 부서별 급여의 합계, 평균
SELECT DEPT_CODE, SUM(SALARY), AVG(SALARY)
FROM EMPLOYEE
WHERE DEPT_CODE IS NOT NULL
GROUP BY DEPT_CODE;

-- 직책별 급여의 합계, 평균
SELECT JOB_CODE, SUM(SALARY), AVG(SALARY)
FROM EMPLOYEE
GROUP BY JOB_CODE;

-- 부서별 인원 조회하기
SELECT DEPT_CODE, COUNT(DEPT_CODE)
FROM EMPLOYEE
WHERE DEPT_CODE IS NOT NULL
GROUP BY DEPT_CODE;

-- GROUP BY 절에은 다수의 컬럼을 사용할 수 있음
-- GROUP BY 컬럼, 컬럼....
SELECT DEPT_CODE, JOB_CODE, COUNT(*), SUM(SALARY), AVG(SALARY)
FROM EMPLOYEE
GROUP BY DEPT_CODE, JOB_CODE;

-- 부서별 최고급여, 최소급여 조회하기
SELECT DEPT_CODE, MAX(SALARY), MIN(SALARY)
FROM EMPLOYEE
GROUP BY DEPT_CODE;

-- 그룹함수를 조건으로 사용할때는 HAVING절을 이용하자
-- 각부서별 인원수가 4명이상인 부서 
SELECT DEPT_CODE, COUNT(*)
FROM EMPLOYEE
GROUP BY DEPT_CODE
HAVING COUNT(*)>=4;

-- 매니저가 관리하는 사원이 2명 이상인 매니저 조회하기
SELECT * FROM EMPLOYEE;
SELECT MANAGER_ID, COUNT(*)
FROM EMPLOYEE
WHERE MANAGER_ID IS NOT NULL
GROUP BY MANAGER_ID
HAVING COUNT(*)>=3;

SELECT *
FROM EMPLOYEE
WHERE EMP_ID IN(SELECT MANAGER_ID FROM EMPLOYEE GROUP BY MANAGER_ID HAVING COUNT(*)>=2);

-- ROLLUPM CUBE 이용하기
-- 그룹별 집계결과와 총 집계결과를 출력해주는 함수
-- 컬럼을 한개만 지정했을때 ROLLUP과 CUBE가 동일
-- 컬럼을 여러개 지정했을때 ROLLUP -> 왼쪽에있는 컬럼을 기준으로 집계, 총 집계
--                       CUBE -> 선언된 컬럼을 기준으로 집계(두개다), 총 집계
--ROLLUP
SELECT NVL(DEPT_CODE,'총계'), SUM(SALARY)
FROM EMPLOYEE
WHERE DEPT_CODE IS NOT NULL
GROUP BY ROLLUP(DEPT_CODE);
--CUBE
SELECT NVL(DEPT_CODE,'총계'), SUM(SALARY)
FROM EMPLOYEE
WHERE DEPT_CODE IS NOT NULL
GROUP BY CUBE(DEPT_CODE);

-- 두개컬럼 이상을 CROUP으로 연결 했을때 처리하는게 다름
SELECT DEPT_CODE, JOB_CODE, SUM(SALARY)
FROM EMPLOYEE
WHERE DEPT_CODE IS NOT NULL
GROUP BY ROLLUP(DEPT_CODE, JOB_CODE);

SELECT DEPT_CODE, JOB_CODE, SUM(SALARY)
FROM EMPLOYEE
WHERE DEPT_CODE IS NOT NULL
GROUP BY CUBE(DEPT_CODE, JOB_CODE);

-- GROUPING() : 집계된 컬럼을 확인해주는 함수
SELECT JOB_CODE, DEPT_CODE, COUNT(*), 
    CASE
        WHEN GROUPING(JOB_CODE)=1 AND GROUPING(DEPT_CODE)=0 THEN '부서별인원'
        WHEN GROUPING(JOB_CODE)=0 AND GROUPING(DEPT_CODE)=1 THEN '직책별인원'
        WHEN GROUPING(JOB_CODE)=0 AND GROUPING(DEPT_CODE)=0 THEN '그룹별인원'
        WHEN GROUPING(JOB_CODE)=1 AND GROUPING(DEPT_CODE)=1 THEN '총인원'
    END AS 비고
FROM EMPLOYEE
WHERE DEPT_CODE IS NOT NULL
GROUP BY CUBE(JOB_CODE, DEPT_CODE);

-- 조회한 데이터를 정렬하기
-- ORDER BY 절 사용
-- SELECT 컬럼,컬럼
-- FROM 테이블
-- [WHERE 조건식]
-- [GROUP BY 컬럼명]
-- [HAVING 그룹함수이용 조건]
-- [ORDER BY 컬럼명 정령옵션(DESC,ASC:DEFAULT)]
-- 전체사원을 급여 많이 받는 순으로 정렬해서 조회하기
SELECT *
FROM EMPLOYEE
ORDER BY SALARY DESC;

-- 사원의 이름순으로 전체사원 조회하기
SELECT * 
FROM EMPLOYEE
ORDER BY EMP_NAME DESC;

-- ORDER BY 절에도 한개이상의 컬럼을 사용할 수 있음
SELECT *
FROM EMPLOYEE
ORDER BY DEPT_CODE DESC, SALARY DESC;
-- DESC, ASC : NULL값
-- DESC : NULL값이 최상단으로
-- ASC : NULL값이 최하단으로
-- NULLS FIRST||LAST옵션을 이용하면 NULL 출력취치를 변경할 수 있음
SELECT BONUS
FROM EMPLOYEE
ORDER BY BONUS NULLS FIRST;

-- ORDER BY 컬럼은 인덱스번호로 대체할 수 있다
SELECT * FROM EMPLOYEE;
SELECT *
FROM EMPLOYEE
ORDER BY 6 DESC NULLS LAST, 9;

-- 집합연산자
-- 여러개의 SELECT문을 한개의 결과로 출력해주는것
-- 첫번째 SELECT문의 컬럼수와 그 이후 SELECT문의 컬럼수가 같아야 함, 각 컬럼의 TYPE도 같아야함
-- UNION
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE='D5'
UNION
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY>=3000000;
--UNION ALL --중복값도 보여줌
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE='D5'
UNION ALL
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY>=3000000;

-- SELECT문의 선택한 컬럼의 수가 다를때 -> 실행안됨
SELECT EMP_ID, EMP_NAME, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE='D5'
UNION
SELECT EMP_ID, EMP_NAME, 0 --컬럼 갯수 맞출려고 임의의 값||컬럼 넣어야됨
FROM EMPLOYEE
WHERE SALARY>=3000000;

-- SELECT문의 컬럼수는 같은데 TYPE이 다른 경우
SELECT EMP_ID, EMP_NAME, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE='D5'
UNION
SELECT EMP_ID, EMP_NAME, EMAIL --컬럼타입 맞춰줘야됨
FROM EMPLOYEE
WHERE SALARY>=3000000;

-- 집합연산은 다른테이블과 연결
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
MINUS -- 중첩된게 빠짐
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY>=3000000;

SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE='D5'
INTERSECT -- 중첩된거만 나옴
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY>=3000000;

-- JOIN에 대해 알아보자
-- 두개이상의 테이블을 특정 기준값으로 연결해주는 기능(ROW를 연결)
-- JOIN 종류
-- INNER JOIN : 특정기준값이 일치하는 ROW만 출력
-- OUTER JOIN : 기준테이블을 설정해서 기준테이블의 모든ROW를 출력하게하는 JOIN -> 누락되는 데이터가 없다

-- INNER JOIN을 사용해보자
-- EMPLOYEE, DEPARTMENT 테이블 연결하기
SELECT * FROM EMPLOYEE;
SELECT * FROM DEPARTMENT;

SELECT EMP_NAME, DEPT_TITLE, SALARY, BONUS
FROM EMPLOYEE JOIN DEPARTMENT ON DEPT_CODE=DEPT_ID;

-- 부서가 총무부인 사원 조회하기
SELECT *
FROM EMPLOYEE JOIN DEPARTMENT ON DEPT_CODE=DEPT_ID
WHERE DEPT_TITLE='총무부';

-- 사원의 이름, 직책명, 월급 보너스를 조회하기
SELECT EMP_NAME, JOB.JOB_CODE, JOB_NAME
--FROM EMPLOYEE E JOIN JOB J ON E.JOB_CODE=J.JOB_CODE;
FROM EMPLOYEE JOIN JOB ON EMPLOYEE.JOB_CODE=JOB.JOB_CODE;
--FROM EMPLOYEE JOIN JOB USING(JOB_CODE); -- 두테이블에 동일한 이름의 컬럼
-- USING을 사용하면 테이블에 별칭을 부여하지 못함

-- JOIN한 테이블에 WHERE, GROUP BY, HAVING, ORDER BY 모두 사용이 가능

-- 부서별 인원과 급여 평균을 구하자 부서명,인원수,평균
SELECT DEPT_TITLE AS 부서명, COUNT(*) AS 인원수, AVG(SALARY) AS 평균
FROM EMPLOYEE JOIN DEPARTMENT ON DEPT_CODE=DEPT_ID
GROUP BY DEPT_TITLE;

-- 직책이 과장인 사원의 이름, 직책명, 직책코드, 월급을 조회하기
SELECT EMP_NAME, JOB_NAME, JOB_CODE, SALARY
FROM EMPLOYEE JOIN JOB USING(JOB_CODE)
WHERE JOB_NAME='과장';

-- OUTER JOIN 활용하기
-- 연결테이블에 기준을 설정해서 기준이 된 테이블의 모든 데이터를 출력하게 하는것
-- 기분테이블을 설정
-- LEFT||RTGHT JOIN
SELECT *
FROM EMPLOYEE LEFT OUTER JOIN DEPARTMENT ON DEPT_CODE=DEPT_ID
--FROM EMPLOYEE RIGHT OUTER JOIN DEPARTMENT ON DEPT_CODE=DEPT_ID;
WHERE DEPT_TITLE IS NULL;


-- CROSS JOIN
-- 연결조건을 설정하지 않아 모든 ROW가 전부 연결이 되는 테이블 생성
SELECT EMP_NAME, DEPT_TITLE
FROM EMPLOYEE CROSS JOIN DEPARTMENT
ORDER BY 1, 2;

-- SELF JOIN
-- 물리적테이블 한개를 가지고 두개의 테이블처럼 연결하는 JOIN
-- 한테이블 동일한 데이터를 가지는 컬럼이 있어야한다
SELECT * FROM EMPLOYEE;
-- MANAGER가 있는 사원의이름, 매니저 이름, 사원번호를 조회
SELECT E.EMP_NAME, E.EMP_ID, E.MANAGER_ID, M.EMP_NAME, M.EMP_ID
FROM EMPLOYEE E JOIN EMPLOYEE M ON E.MANAGER_ID=M.EMP_ID;
-- MANAGER가 없는 사원은 이름에 '없다' 출력
SELECT E.EMP_NAME, E.EMP_ID, E.MANAGER_ID, NVL(M.EMP_NAME,'없다'), M.EMP_ID
FROM EMPLOYEE E LEFT JOIN EMPLOYEE M ON E.MANAGER_ID=M.EMP_ID;

-- 다중조인
-- 두개이상의 테이블 조인해서 조회하기
-- 사원의 이름,  부서명, 직책명, 급여, 보너스를 조회하기
SELECT EMP_NAME, DEPT_TITLE, JOB_NAME, SALARY, BONUS
FROM EMPLOYEE 
    LEFT JOIN DEPARTMENT ON DEPT_CODE=DEPT_ID
    JOIN JOB USING(JOB_CODE);

-- 사원의 사원명, 부서명, 직책명, 근무지역명(LOCALNAME) 조회하기
SELECT * FROM LOCATION;
SELECT * FROM DEPARTMENT;

SELECT EMP_NAME, DEPT_TITLE, JOB_NAME, LOCATION_ID, LOCAL_NAME
FROM EMPLOYEE
    JOIN JOB USING(JOB_CODE)
    LEFT JOIN DEPARTMENT ON DEPT_ID=DEPT_CODE
    LEFT JOIN LOCATION ON LOCATION_ID=LOCAL_CODE;

-- 비동등조인 활용하기
-- 범위에 따라 ROW를 연결하는 JOIN방식
-- 범위를 나타내는 컬럼을 가지는 테이블이 있어야함
SELECT * FROM SAL_GRADE;
-- 포인트별 회원등급설정, 점수에 따른 제품상태설정
SELECT *
FROM EMPLOYEE
    JOIN SAL_GRADE ON SALARY BETWEEN MIN_SAL AND MAX_SAL;


-- 서브쿼리 -> SELECT문 안에 또다른 SELECT문을 작성하는 것
-- MAIN QURRY -> 서브쿼리를 감싸고 있는 SELECT문
-- SUB QURRY -> MAIN QURRY내부에 있는 SELECT문
-- 전지연 사원의 매니저의 정보를 출력하기
SELECT MANAGER_ID FROM EMPLOYEE WHERE EMP_NAME='전지연';
SELECT * FROM EMPLOYEE WHERE EMP_ID='214';
-- 서브쿼리 이용해서 처리하기
SELECT *
FROM EMPLOYEE
WHERE EMP_ID=(SELECT MANAGER_ID FROM EMPLOYEE WHERE EMP_NAME='전지연');

- D5부서의 평균급여보다 많이 받는 사원 조회하기
SELECT AVG(SALARY) FROM EMPLOYEE WHERE DEPT_CODE='D5';
SELECT *
FROM EMPLOYEE
WHERE SALARY>=(SELECT AVG(SALARY) FROM EMPLOYEE WHERE DEPT_CODE='D5');

-- 1. 단일행 서브쿼리
-- SELECT문의 결과가 1개 컬럼, 1개 ROW갖는 것
-- WHERE절, SELECT컬럼에 많이 사용
-- 사원들의 급여 평균보다 많이 급여를 받는 사원 이름, 급여, 부서코드 조회
SELECT EMP_NAME, SALARY, DEPT_CODE, FLOOR((SELECT AVG(SALARY) FROM EMPLOYEE)) AS 평균급여
FROM EMPLOYEE
WHERE SALARY>=(SELECT AVG(SALARY) FROM EMPLOYEE);
 
 -- 부서가 총무부인 사원을 조회하기
 SELECT *
 FROM EMPLOYEE
 WHERE DEPT_CODE=(SELECT DEPT_ID FROM DEPARTMENT WHERE DEPT_TITLE='총무부');
 
 SELECT *
 FROM EMPLOYEE JOIN DEPARTMENT ON DEPT_CODE=DEPT_ID
 WHERE DEPT_TITLE='총무부';
 
 -- 다중행 서브쿼리
 -- RESULT SET SELECT문의 결과가 다수 ROW로 출력되는 것
 -- 직책이 부장, 과장인 사원을 조회하기
 SELECT JOB_CODE FROM JOB WHERE JOB_NAME IN('과장', '부장');
 SELECT *
 FROM EMPLOYEE
 WHERE JOB_CODE IN (SELECT JOB_CODE FROM JOB WHERE JOB_NAME IN('과장', '부장'));
 
 -- 송중기, 박나라와 같이 근무하는 사원 조사하기
 SELECT *
 FROM EMPLOYEE
 WHERE DEPT_CODE IN (SELECT DEPT_CODE FROM EMPLOYEE WHERE EMP_NAME IN('송중기', '박나라'));
 
 -- 부서별 최고급여를 받는 사원 구하기
 SELECT *
 FROM EMPLOYEE
 WHERE SALARY IN(SELECT MAX(SALARY) FROM EMPLOYEE GROUP BY DEPT_CODE);
 
 -- 다중행 대소비교하기
 -- ANY, ALL 함수를 이용하여 처리
 -- ANY : 그 다수값 중 하나가 참이면 참
 -- 컬럼>(=) ANY(다중값) : 다중값 중 하나라도 컬럼보다 작으면 참 -> 다중값의 최소값보다 크면 참
 -- 컬럼<(=) ANY(다중값) : 다중값 중 하나라도 컬럼보다 크면 참 -> 다중값의 최대값보다 작으면 참
 SELECT *
 FROM EMPLOYEE
-- WHERE SALARY > ANY(SELECT MIN(SALARY) FROM EMPLOYEE GROUP BY DEPT_CODE);
 WHERE SALARY < ANY(SELECT MIN(SALARY) FROM EMPLOYEE GROUP BY DEPT_CODE); 
 
 -- ALL : 다중값 모두가 참일때 참
 -- 컬럼>(=) ALL(다중값) : 다중값의 최대값보다 크면 참
 -- 컬럼<(=) ALL(다중값) : 다중값의 최솟값보다 작으면 참
 SELECT *
 FROM EMPLOYEE
 WHERE SALARY > ALL(SELECT MIN(SALARY) FROM EMPLOYEE GROUP BY DEPT_CODE);

-- 2000년 1월 1일 이전에 입사자중 2000년 1월1일 이후 입사한 사원 중 급여를 가장 높게 받는 사원보다 그병가 많은 사원조회하기
SELECT * 
FROM EMPLOYEE
WHERE HIRE_DATE<'00/01/01'
--AND SALARY>(SELECT MAX(SALARY) FROM EMPLOYEE WHERE HIRE_DATE>'00/01/01');
AND SALARY> ALL(SELECT SALARY FROM EMPLOYEE WHERE HIRE_DATE>'00/01/01');

-- 다중열 서브쿼리 : ROW 1개 COLUMN 여러개
-- 퇴직한 여사원의 같은부서 같은 직급에 해당하는 사원 조회하기
SELECT DEPT_CODE, JOB_CODE FROM EMPLOYEE WHERE ENT_YN='Y';

SELECT * 
FROM EMPLOYEE
WHERE (DEPT_CODE, JOB_CODE) IN (SELECT DEPT_CODE, JOB_CODE FROM EMPLOYEE WHERE ENT_YN='Y');

-- 기술지원부이면서 급여가 200만원인 사원이 있다고 한다 그 사원의 정보를 조회하기
SELECT * -- 안됨 확인
FROM EMPLOYEE
WHERE (DEPT_CODE, SALARY) IN (SELECT DEPT_CODE, SALARY
                            FROM EMPLOYEE JOIN DEPARTMENT ON DEPT_CODE=EMPT_ID
                            WHERE DEPT_TITLE='기술지원부' AND SALARY=2000000);

-- 다중행 다중열
-- 총무부이면서 300만원 이상 급여를 받는 사원
SELECT EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE JOIN DEPARTMENT ON DEPT_CODE=DEPT_ID
WHERE DEPT_TITLE='총무부' AND SALARY>=3000000;

SELECT EMP_NAME, DEPT_CODE, SALARY --안됨 확인
FROM EMPLOYEE 
WHERE (DEPT_CODE, SALARY) IN (SELECT DEPT_CODE, SALARY
                                FROM EMPLOYEE JOIN DEPARTMENT ON DEPT_CODE=DEPT+ID
                                WHERE DEPT_TITLE='총무부' AND SALARY>=3000000);

-- 상관서브쿼리
-- 서브쿼리를 구성할때 메인쿼리에 값을 가져와 사용하게 구성하여 서브쿼리 결과가 메인쿼리값에 영향을 받고 서브쿼리의 결과가
-- 메인쿼리 결과에 영향을 미치게되는 쿼리

-- 각 사원이 속한 부서의 인원수 조회하기
-- 중첩 반복문이 실행하는것과 비슷
SELECT EMP_NAME, DEPT_CODE, (SELECT COUNT(*) FROM EMPLOYEE WHERE DEPT_CODE=E.DEPT_CODE) AS 인원수
FROM EMPLOYEE E;
SELECT COUNT(*) FROM EMPLOYEE WHERE DEPT_CODE='D9';
SELECT COUNT(*) FROM EMPLOYEE WHERE DEPT_CODE='D6';

-- 자신이 속한 부서의 평균급여보다 급여를 많이 받는 사원을 조회하기
SELECT * FROM EMPLOYEE;
SELECT *
FROM EMPLOYEE E
WHERE SALARY > (SELECT AVG(SALARY) FROM EMPLOYEE WHERE DEPT_CODE=E.DEPT_CODE);
SELECT AVG(SALARY) FROM EMPLOYEE WHERE DEPT_CODE='D9';


-- FROM절에 서브쿼리 사용하기
-- INLINE VIEW -> 다중행 다중열 서브쿼리를 사용
-- 가상컬럼이 추가된 SELECT문이나 집합연산을 사용한 SELECT문을 INLINE VIEW로 많이 사용
-- STORED VIEW -> 오라클에서 관리하는 하나의 OBJECT
-- INLINE VIEW는 1회용
-- STORED VIEW는 특정명칭으로 INLINE VIEW를 저장해서 사용 -> VIEWTABLE이라고 함
SELECT * 
FROM EMPLOYEE;
SELECT * 
FROM EMPLOYEE
WHERE SUBSTR(EMP_NO,8,1)='2';

SELECT *
FROM (SELECT E.*, DECODE(SUBSTR(EMP_NO,8,1),'1','남','2','여') AS GENDER FROM EMPLOYEE E)
WHERE GENDER='여';

--JOIN문
SELECT *
FROM (SELECT E.*,D.*,JOB_NAME,
        (SELECT TRUNC(AVG(SALARY),-1) FROM EMPLOYEE WHERE DEPT_CODE=E.DEPT_CODE) AS DEPT_SAL,
        (SELECT COUNT(*) FROM EMPLOYEE WHERE JOB_CODE=E.JOB_CODE) AS JOB_COUNT
        FROM EMPLOYEE E LEFT JOIN DEPARTMENT D ON DEPT_CODE=DEPT_ID
        JOIN JOB J ON E.JOB_CODE=J.JOB_CODE)
WHERE DEPT_SAL>3000000 AND JOB_COUNT=4;

-- INLINE VIEW를 생성했을때 INLINE VIEW에서 선언한 컬럼만 이용할 수 있음
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


-- 데이터를 기준으로 순위 출력하는 구문 작성하기
-- 2가지 방법
-- 1. 오라클에서 제공하는 ROWNUM컬럼을 이용해서 출력
-- SELECT문이 실행되면 자동으로 오라클이 부여하는 가상컬럼 SELECT문이 실행될때 ROW에 번호를 부여한 컬럼
SELECT ROWNUM, E.*
FROM EMPLOYEE E
WHERE ROWNUM BETWEEN 1 AND 3;
-- 급여를 많이 받는 사원 1등 3등까지 조회하기
SELECT ROWNUM, E.*
FROM EMPLOYEE E
WHERE ROWNUM BETWEEN 1 AND 3
ORDER BY SALARY;

-- ROWNUM을 사용해서 정상적인 순위를 출력하려면 INLINE VIEW를 이용해야한다
-- 중간순위에 대한 데이터를 출력할 수가 없다
SELECT *
FROM(
    SELECT ROWNUM AS RNUM, E.*
    FROM (SELECT * FROM EMPLOYEE ORDER BY SALARY) E
    )
WHERE RNUM BETWEEN 5 AND 10;
    
-- 2. 오라클에서 제공하는 WINDOW함수를 이용해서 출력하는 방법




























