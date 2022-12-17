package com.extra.model.vo;

import java.util.ArrayList;
import java.util.List;

import com.extra.common.Gender;

public class StudentDao {
	private static List<Student> students=new ArrayList();
	
	
	static {
		for(int i=0; i<100; i++) {
			students.add(Student.builder()
					.stdNo(i)
					.name("test"+i)
					.age((int)(Math.random()*50)+10)
					.height((Math.random()*(190-150)+150))
					.gender((i%2==0?Gender.M:Gender.F))
					.address("경기도 "+i)
					.build());
					
		}
	}
	public static List<Student> getStudents(){
		return StudentDao.students;
	}
	
}
