package com.poly.main;

import java.util.Scanner;

import com.poly.model.vo.Archer;
import com.poly.model.vo.Knight;
import com.poly.model.vo.Wizard;
import com.poly.model.vo.Character;

public class GameMain {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("===== 다형성 게임 =====");
		System.out.println("===== 캐릭터 선택 =====");
		System.out.println("1.기사");
		System.out.println("2.궁수");
		System.out.println("3.법사");
		System.out.print("선택: ");
		int cho=sc.nextInt();
		
//		Knight k=null;
//		Archer a=null;
//		Wizard w=null;
		
		Character c=null;
		
		switch(cho) {
		case 1 : c=new Knight(200,"BS기사",10,"나무칼");break;
		case 2 : c=new Archer(100,"BS궁수",10,"나무활",10);break;
		case 3 : c=new Wizard(80,200,"BS법사","파이어볼");break;
		
		
		
		}
		c.attack();
//		if(c instanceof Knight) {
//			((Knight)c).attackKnigth();
//		}else if(c instanceof Archer){
//			((Archer)c).attackArcher();
//		}else if(c instanceof Wizard){
//			((Wizard)c).attackWizard();
//		}	
		
		
	}
}
