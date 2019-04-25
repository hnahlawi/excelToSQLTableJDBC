package p1;
import java.util.ArrayList;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;


public class Converter {
	public String excelpath = "src/job applications.xlsx";
	public Sheet sheet;
	public Integer numRows;
	public Integer numFields;
	
	public Converter() throws InvalidFormatException, IOException{
		InputStream excelfile = new FileInputStream(excelpath);
	    Workbook workbook = WorkbookFactory.create(excelfile);
		this.sheet = workbook.getSheetAt(0);
		this.numRows = this.sheet.getPhysicalNumberOfRows();
	}	
	
	
	public void createWorkbook() throws InvalidFormatException, IOException{
		
		Row row = this.sheet.getRow(0);
		System.out.println(row.getCell(2));
	    
	}
	
	public ArrayList<String> getColumns(){
		ArrayList<String> columns = new ArrayList();
		
		int i = 0;
		Row columnRow = this.sheet.getRow(0);
		while (columnRow.getCell(i) != null) {
			
			columns.add(columnRow.getCell(i).toString().replace(" ", "_"));
			i += 1;
			
		}
		this.numFields = i;
		return columns;
		
	}
	
	public ArrayList<Entry> getRows() {
		
		ArrayList<Entry> rows = new ArrayList();
			
		for (int i = 1; i < this.numRows; i++) {
			ArrayList<String> rowArray = new ArrayList();
			Row row = this.sheet.getRow(i);
			
			for (int j = 0; j < this.numFields; j++) {
				Cell cell = row.getCell(j);
				
				if (cell != null) {
				rowArray.add(cell.toString().replace("'", "''"));
				}
				else {
					rowArray.add(null);
				}
			}
			Entry rowEntry = new Entry(rowArray);
			rows.add(rowEntry);
		}
		
		return rows;
		
	}

	public static void main(String[] args) {
		System.out.println("This program takes an excel file and turns it into a SQL table");
		try {
		
		Converter converter = new Converter();
		ArrayList<String> columns = converter.getColumns();
		ArrayList<Entry> rows = converter.getRows();
		Database data = new Database();
		data.createTable(columns);
		data.addRows(rows);
		
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.print("Error occurred");
		}
		
		
		
	}

}
