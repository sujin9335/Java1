package com.inter.main;

import com.inter.common.animal.inter.FlyAble;
import com.inter.common.animal.inter.MoveAble;
import com.inter.common.animal.inter.WaterMove;
import com.inter.model.vo.Animal;
import com.inter.model.vo.Dog;
import com.inter.model.vo.Pigeon;
import com.inter.model.vo.Whale;

public class AnimalRun {

	public static void main(String[] args) {
//		Animal[] animals= {
				Dog d=new Dog("바둑이",1,1,"강아지","육지");
				Pigeon p=new Pigeon("닭둘기",10,10, "조류","하늘");
				Whale w=new Whale("고순이",100,100,"물고기","바다");
//		};
		
		fly(p);
		System.out.println(d.getX()+":"+d.getY());
		move(d,100,100);
		System.out.println(d.getX()+":"+d.getY());
		swim(w);
		System.out.println(p.getX()+":"+p.getY());
		move(p,200,200);
		System.out.println(p.getX()+":"+p.getY());
		
		MoveAble[] move= {p,d};
		
		
		
		
	}
	
	public static void fly(FlyAble fly) {
		fly.fly();
	}
	public static void move(MoveAble move, int x, int y) {
		move.move(x, y);
	}
	public static void swim(WaterMove w) {
		w.swim();
	}
	
	
}
