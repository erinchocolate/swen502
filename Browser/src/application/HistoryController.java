package application;

import java.util.ArrayList;
import java.util.Date;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.web.WebHistory;

public class HistoryController {
	private ArrayList<WebRecord> record;
	@FXML private TableView<WebRecord> historyTable;
	@FXML private TableColumn<WebRecord, String> urlColumn;
	@FXML private TableColumn<WebRecord, Date> dateColumn;
	
	public void setHistory(ArrayList<WebRecord> record) {
		this.record = record;
	}
	
	public void display() {
		urlColumn.setCellValueFactory(new PropertyValueFactory<WebRecord, String>("url"));
		dateColumn.setCellValueFactory(new PropertyValueFactory<WebRecord, Date>("date"));
		
		ObservableList<WebRecord> records = FXCollections.observableArrayList();
		for(WebRecord h: record) {
			records.add(h);		
		}	
		
		historyTable.setItems(records);
	}
	
	
	
	
}
