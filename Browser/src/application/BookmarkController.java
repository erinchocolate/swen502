package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class BookmarkController {
	@FXML private TableView<WebRecord> table;
	@FXML private TableColumn<WebRecord, String> urlColumn;
	
	public void loadRecord() {
		ObservableList<WebRecord> records = FXCollections.observableArrayList();
		urlColumn.setCellValueFactory(new PropertyValueFactory<WebRecord, String>("url"));
		Connection conn = null;
		Statement statement = null;
		ResultSet resultSet = null;
		
		try {
			conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/bookmark", "root", "qb686994");
			statement = conn.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM records");
			
			while (resultSet.next()) {
				WebRecord r = new WebRecord(resultSet.getString("url"));
				records.add(r);
			}
			
			table.getItems().addAll(records);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
}
