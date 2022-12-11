package com.file.run;

import com.file.controller.FileController;
import com.file.controller.FileStreamController;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileController fc=new FileController();
//		fc.basicFile();
//		fc.fileManage();
		FileStreamController fsc=new FileStreamController();
//		fsc.fileSave();
//		fsc.loadFile();
//		fsc.saveFileStr();
//		fsc.loadFileStr();
//		fsc.memoFile();
//		fsc.memoLoad();
//		fsc.changeStream();
//		fsc.dataTypeWriter("김수진", 19, '남', 175.5);
//		fsc.dataTypeReader();
		fsc.objectSave();
		fsc.ovjectLoad();
	}

}
