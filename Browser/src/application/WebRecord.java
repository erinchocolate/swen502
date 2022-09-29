package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

public class WebRecord {
	private String url;
	private Date date;
	
	public WebRecord(String url) {
		setUrl(url);
	}
	
	public WebRecord(String url, Date date) {
		setUrl(url);
		setDate(date);
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public String getUrl() {
		return url;
	}
	
	public Date getDate() {
		return date;
	}
	
	public void insertIntoDB() {
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		try {
			conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/bookmark", "root", "qb686994");
			
			String sql = "INSERT INTO records (url)" + "VALUES (?)";
			
			preparedStatement = conn.prepareStatement(sql);
			
			preparedStatement.setString(1, url);
			
			preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
