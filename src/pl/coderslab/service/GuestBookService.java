package pl.coderslab.service;

import java.util.List;

import pl.coderslab.DAO.GuestBookDao;
import pl.coderslab.entities.GuestBookEntry;

public class GuestBookService {
	private GuestBookDao guestBookDao;
	public GuestBookService() {
		guestBookDao = new GuestBookDao();
	}

	public void insertIntoDB (GuestBookEntry guestBookEntry, String connection, String user,String password){
		guestBookDao.insertIntoGuestBook(guestBookEntry, connection, user, password);
	}
	public List<GuestBookEntry> allEntry(String connection, String user, String password) {
		return guestBookDao.allEntry(connection, user, password);
	}
}
