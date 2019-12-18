package com.sanjeep.jms.util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.springframework.stereotype.Component;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.sanjeep.jms.model.Reservation;

@Component
public class PDFGenerator {

	public void generateItenary(Reservation reservation, String filePath) {
	Document document=new Document();
	try {
		PdfWriter.getInstance(document, new FileOutputStream(filePath));
		document.open();
		
		document.add(generateTable(reservation));
		document.close();
	} catch (FileNotFoundException | DocumentException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

	private PdfPTable generateTable(Reservation reservation) {
		PdfPTable table=new PdfPTable(2);
		PdfPCell cell;
		
		cell=new PdfPCell(new Phrase("flight Itenary"));
		cell.setColspan(2);
		table.addCell(cell);
		
		cell=new PdfPCell(new Phrase("flight Details"));
		cell.setColspan(2);
		table.addCell(cell);
		
		table.addCell("Airline");
		table.addCell(reservation.getFlight().getOperatingAirlines());
		
		table.addCell("Departure City");
		table.addCell(reservation.getFlight().getDepartureCity());
		
		table.addCell("Departure City");
		table.addCell(reservation.getFlight().getDepartureCity());
		
		table.addCell("Arrival  City");
		table.addCell(reservation.getFlight().getArrivalCity());
		
		table.addCell("Flight Number");
		table.addCell(reservation.getFlight().getFlightNumber());
		
		
		table.addCell("Departure Time");
		table.addCell(reservation.getFlight().getDateofDeparture().toString());
		
		cell=new PdfPCell(new Phrase("Passenger Details"));
		cell.setColspan(2);
		table.addCell(cell);
		
		table.addCell("First Name");
		table.addCell(reservation.getPassenger().getFirstName());
		
		table.addCell("Last Name");
		table.addCell(reservation.getPassenger().getLastName());
		
		table.addCell("Email");
		table.addCell(reservation.getPassenger().getEmail());
		
		table.addCell("Phone");
		table.addCell(reservation.getPassenger().getPhone());
		
		return table;
}
}
