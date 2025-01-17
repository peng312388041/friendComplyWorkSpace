package excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.WritableWorkbook;

public class Excel {

	public static void main(String[] args) throws BiffException, IOException {
		String file = "D:/source.xls";
		InputStream inputStream = null;
		Workbook workbook = null;
		
		
		String fileTarget = "D:/target.xls";
		OutputStream outputStream = null;
		WritableWorkbook workbookTarget = null;
		try {
			inputStream = new FileInputStream(new File(file));
			workbook = Workbook.getWorkbook(inputStream);
			int sheetCount = workbook.getSheets().length;
			Set<String> set = new HashSet<>();
			for (int i = 0; i < sheetCount; i++) {
				Sheet s = workbook.getSheet(i);

				for (Cell cell : s.getColumn(7)) {
					set.add(cell.getContents());
				}
			}
			for (String s : set) {
				for (int i = 0; i < sheetCount; i++) {
					Sheet sheet = workbook.getSheet(i);
					for (Cell cell : sheet.getColumn(7)) {
						if(s.equals(cell.getContents()))
						{
							Cell cell2[]=sheet.getRow(cell.getRow());
							for(Cell cell3:cell2)   //一个cell3就是一行数据
							{
								System.out.println(cell3.getContents());
								
								
								outputStream = new FileOutputStream(new File(fileTarget));
								workbookTarget = Workbook.createWorkbook(outputStream);
								
								
								
								
								
								
							}
						}
							 
						 
					}
					 

				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}
}
