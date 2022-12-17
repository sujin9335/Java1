package com.extra.controller;

import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.extra.common.Gender;
import com.extra.model.vo.Student;
import com.extra.model.vo.StudentDao;

public class StreamController {

	public static void main(String[] args) {
		//Stream 이용해서 데이터 정제하기
		//Collection에 저장된 데이터를 가지고 활용을 많이 함
		List<Student> students=StudentDao.getStudents();
		System.out.println(students.size());
		for(Student s : students) {
			System.out.println(s);
		}
		
		//남학생조회하기
		List<Student> menStudent=new ArrayList();
		for(Student s : students) {
			if(s.getGender()==Gender.M) {
				menStudent.add(s);
			}
		}
		System.out.println("======남학생 조회======");
		menStudent.forEach(s->System.out.println(s));
		
		//Stream 이용해서 처리하기
		//filter()메소드를 이용하면됨
		System.out.println("stream 이용 남학생 조회");
		menStudent=students.stream().filter(s->s.getGender()==Gender.M)
									.filter(s->s.getAge()>40)
									.sorted((pre,next)->pre.getAge()-next.getAge())
									.limit(3)
									.collect(Collectors.toList());
		menStudent.forEach(s->System.out.println(s));
		
		
		//Predicate<T>
		//여학생을 나이가 30세 이상인 학생의 이름만 조회
		//Map()메소드 : 반환하는 데이터를 종합
		System.out.println("======여학생 30세이상======");
		List<String> womenList=students.stream()
				.filter(s->s.getGender()==Gender.F&&s.getAge()>=30)
				.map(s->s.getName())
				.collect(Collectors.toList());
		womenList.forEach(s->System.out.println(s));
		
//		java.util.function.Function
		
		//학생 나이 평균
		double ageAvg=students.stream()
				.collect(Collectors.averagingDouble(s->s.getAge()));
		System.out.println("나이 평균: "+ageAvg);
		//학생 키 평균
		double heightAvg=students.stream()
				.collect(Collectors.averagingDouble(s->s.getHeight()));
		System.out.println("키 평균: "+heightAvg);
		
		//나이에 대한 합계, 평균, 갯수 구하는 메소드
		//Collectors.summarizingInt()
		IntSummaryStatistics iss=students.stream()
				.collect(Collectors.summarizingInt(s->s.getAge()));
		System.out.println("나이 평균: "+iss.getAverage());
		System.out.println("나이 합계: "+iss.getSum());
		System.out.println("나이 최대값: "+iss.getMax());
		System.out.println("나이 최소값: "+iss.getMin());
		System.out.println("사람수: "+iss.getCount());
		
		//데이터를 그룹별로 종합
		//학생을 나이대별 집계하기
		Map<String,List<Student>> studentGroup=students.stream()
				.collect(Collectors.groupingBy(s->{
					if(s.getAge()>=10&&s.getAge()<20) return "10대";
					else if(s.getAge()>=20&&s.getAge()<30) return "20대";
					else if(s.getAge()>=30&&s.getAge()<40) return "30대";
					else if(s.getAge()>=40&&s.getAge()<50) return "40대";
					else if(s.getAge()>=50&&s.getAge()<60) return "50대";
					else return "고령자";
				}));
		
		for(Map.Entry<String, List<Student>> entry:studentGroup.entrySet()) {
			System.out.println(entry.getKey());
//			System.out.println(entry.getValue());
			if(entry.getKey().contains("30")) {
				for(Student s : entry.getValue()) {
					System.out.println(s);
				}
			}
		}
		
		//병렬처리하기
//		students.parallelStream()
		
	}
}
