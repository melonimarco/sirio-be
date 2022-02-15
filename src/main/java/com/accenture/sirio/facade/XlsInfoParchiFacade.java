package com.accenture.sirio.facade;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.sirio.entityRTO.XlsInfoParchiRTO;
import com.accenture.sirio.service.ParcoNaturaleService;

@Service
public class XlsInfoParchiFacade {
	
	@Autowired
	private ParcoNaturaleService parcoNaturaleService;
	
	public void createXls() throws IOException {
		
		Workbook workbook = new XSSFWorkbook();

		Sheet sheet = workbook.createSheet("Parchi");
		sheet.setColumnWidth(0, 6000);
		sheet.setColumnWidth(1, 4000);

		Row header = sheet.createRow(0);

		CellStyle headerStyle = workbook.createCellStyle();
		headerStyle.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());
		headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

		XSSFFont font = ((XSSFWorkbook) workbook).createFont();
		font.setFontName("Arial");
		font.setFontHeightInPoints((short) 16);
		font.setBold(true);
		headerStyle.setFont(font);

		Cell headerCell = header.createCell(0);
		headerCell.setCellValue("ID PARCO");
		headerCell.setCellStyle(headerStyle);

		headerCell = header.createCell(1);
		headerCell.setCellValue("NOME");
		headerCell.setCellStyle(headerStyle);
		
		headerCell = header.createCell(2);
		headerCell.setCellValue("TIPOLOGIA");
		headerCell.setCellStyle(headerStyle);
		
		headerCell = header.createCell(3);
		headerCell.setCellValue("SPECIE");
		headerCell.setCellStyle(headerStyle);
		
		sheet.createFreezePane(0, 1);
		
		CellStyle style = workbook.createCellStyle();
		style.setWrapText(true);
		
		List<XlsInfoParchiRTO> listXlsInfoParchiAnimaliRTO = parcoNaturaleService.getInfoParchiAnimaliXls();
		
		List<XlsInfoParchiRTO> listXlsInfoParchiPianteRTO = parcoNaturaleService.getInfoParchiPianteXls();
		
		List<XlsInfoParchiRTO> listXlsInfoParchiRTO = new ArrayList<XlsInfoParchiRTO>();
		
		listXlsInfoParchiRTO.addAll(listXlsInfoParchiAnimaliRTO);
		listXlsInfoParchiRTO.addAll(listXlsInfoParchiPianteRTO);
		
		listXlsInfoParchiRTO.sort(Comparator.comparing(XlsInfoParchiRTO::getIdParco).thenComparing(XlsInfoParchiRTO::getTipologia));
		
		int cont = 1;
		
		Cell cell;
		
		for(XlsInfoParchiRTO info : listXlsInfoParchiRTO) {
			
			Row row = sheet.createRow(cont++);
			
				cell = row.createCell(0);
				cell.setCellValue(info.getIdParco());
				cell.setCellStyle(style);
				sheet.autoSizeColumn(0);
				
				cell = row.createCell(1);
				cell.setCellValue(info.getNomeParco());
				cell.setCellStyle(style);
				sheet.autoSizeColumn(1);
				
				cell = row.createCell(2);
				cell.setCellValue(info.getTipologia());
				cell.setCellStyle(style);
				sheet.autoSizeColumn(2);
				
				cell = row.createCell(3);
				cell.setCellValue(info.getSpecie());
				cell.setCellStyle(style);
				sheet.autoSizeColumn(3);
					
		}
		
		File currDir = new File(".");
		String path = currDir.getAbsolutePath();
		String fileLocation = path.substring(0, path.length() - 1) + "temp.xlsx";

		FileOutputStream outputStream = new FileOutputStream(fileLocation);
		workbook.write(outputStream);
		workbook.close();
		
	}
}


