package application;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

import javafx.beans.property.ReadOnlyStringProperty;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.print.PrinterJob;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.web.PopupFeatures;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebHistory;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class HomeController implements Initializable{

	@FXML private WebView webView;
	@FXML private ChoiceBox<String> searchChoice;
	@FXML private TextField searchBar;
	@FXML private Button facebook;
	@FXML private Button youtube;
	@FXML private Button twitter;
	@FXML private Button googledrive;
	@FXML private Button linkedin;
	@FXML private Button googlemap;
	@FXML private Button dropbox;
	@FXML private Button gmail;
	
	private Scene scene;
	private Stage stage;
	private Parent root;
	private String[] engine = {"Google", "DuckDuckGo", "Yahoo", "Bing"};
	private WebEngine browser;
	private WebHistory history;
	private String engineChoice;
	private String searchAddress;
	private ArrayList<WebRecord> records;
	private ArrayList<WebRecord> bookmarks = new ArrayList<WebRecord>();
	//List of websites users want to block
	private ArrayList<String> block = new ArrayList<String>();
	
	public void loadPage() {
		//If user doesn't choose search engine, then they can enter web address to go to website.
		//Otherwise, they enter what they want to search using the engine they choose
		if(engineChoice==null) {
			if(searchBar.getText().startsWith("http://")) {
				browser.load(searchBar.getText());
			}
			else {
				browser.load("http://"+searchBar.getText());
			}
			searchBar.setText(browser.getLocation());
		}
		else {
			getSearchEngineURL();
			browser.load(searchAddress+searchBar.getText());			
		}
		browser.locationProperty().addListener((obs, oldValue, newValue) -> {
			if(block.contains(newValue)) {
				browser.load("http://www.google.com");
			}
		});
		
	}
	
	public void loadPage(String url) {
		browser.load(url);
		searchBar.setText("");
	}
	
	public void loadDefaultPage() {
		browser.load("https://www.google.com//");
		searchBar.setText("");
	}
	
	
	public void getEngine(ActionEvent event) {
		engineChoice = searchChoice.getValue();	
	}
	
	public void getSearchEngineURL() {
		switch(engineChoice) {
		case "Google":
			searchAddress = "https://www.google.com//search?q=";
			break;
		case "DuckDuckGo":
			searchAddress = "https://duckduckgo.com//?q=";
			break;
		case "Bing":
			searchAddress = "http://www.bing.com//search?q=";
			break;
		case "Yahoo":
			searchAddress = "https://search.yahoo.com//search?q=";
			break;
		}
	}
	
	public void getHistory() {
		history = browser.getHistory();
	}
	
	public void refreshPage() {
		browser.reload();
	}
	
	public void forward() {
		browser.executeScript("history.forward()");
	}
	
	public void back() {
		browser.executeScript("history.back()");
	}
	
	public void zoomIn() {
		webView.setZoom(webView.getZoom() + 0.1);
	}
	
	public void zoomOut() {
		webView.setZoom(webView.getZoom() - 0.1);
	}

	
	public void bookmark() {
		WebRecord h = new WebRecord(browser.getLocation(), new Date());
		bookmarks.add(h);
		h.insertIntoDB();

	}
	
	public void importBookmark() throws IOException{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Bookmark.fxml"));
		root = loader.load();
		BookmarkController s = loader.getController();
		s.loadRecord();
		Scene scene = new Scene(root,800,600);
		Stage stage = new Stage();
		stage.setTitle("Import Bookmark");		
		stage.setScene(scene);
		stage.show();
	}
	
	public void loadBookmark() throws IOException{	
		FXMLLoader loader = new FXMLLoader(getClass().getResource("History.fxml"));
		root = loader.load();
		HistoryController s = loader.getController();
		s.setHistory(bookmarks);
		s.display();
		Scene scene = new Scene(root,800,600);
		Stage stage = new Stage();
		stage.setTitle("Bookmark");		
		stage.setScene(scene);
		stage.show();
	}
	
	public void loadHistory() throws IOException{
		getHistory();
		setHistoryRecord();		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("History.fxml"));
		root = loader.load();
		HistoryController s = loader.getController();
		s.setHistory(records);
		s.display();
		Scene scene = new Scene(root,800,600);
		Stage stage = new Stage();
		stage.setTitle("History");		
		stage.setScene(scene);
		stage.show();
	}
	
	public void setHistoryRecord() {
		records = new ArrayList<WebRecord>();
		ObservableList<WebHistory.Entry> entries = history.getEntries();
		for(WebHistory.Entry entry: entries) {
			WebRecord h = new WebRecord(entry.getUrl(), entry.getLastVisitedDate());
			records.add(h);
		}
	}
	
	public void learnJS() throws IOException{
		Parent root = FXMLLoader.load(getClass().getResource("JS.fxml"));
		Scene scene = new Scene(root,800,600);
		Stage stage = new Stage();
		stage.setTitle("JavaScript code runner");		
		stage.setScene(scene);
		stage.show();
	}
	
	public void learnHTML() throws IOException{
		Parent root = FXMLLoader.load(getClass().getResource("HTML.fxml"));
		Scene scene = new Scene(root,800,600);
		Stage stage = new Stage();
		stage.setTitle("HTML editor");		
		stage.setScene(scene);
		stage.show();
	}
	
	public void print() {
		PrinterJob printerJob = PrinterJob.createPrinterJob();
        if(printerJob != null)
        {
        	browser.print(printerJob);
            printerJob.endJob();
        } 
	}
	
	public void addBlock() {
		String url = browser.getLocation();
		block.add(url);
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		browser = webView.getEngine();
		searchChoice.getItems().addAll(engine);
		searchChoice.setOnAction(this::getEngine);
		facebook.setOnAction(a -> loadPage("https://www.facebook.com/"));
		twitter.setOnAction(a -> loadPage("https://www.twitter.com"));
		linkedin.setOnAction(a -> loadPage("https://www.linkedin.com/"));
		dropbox.setOnAction(a -> loadPage("https://www.dropbox.com"));
		gmail.setOnAction(a -> loadPage("https://www.gmail.com"));
		googledrive.setOnAction(a -> loadPage("https://www.google.com/drive/"));
		googlemap.setOnAction(a -> loadPage("https://www.google.com/maps"));
		youtube.setOnAction(a -> loadPage("https://www.youtube.com/"));		
		

	}
	
}
