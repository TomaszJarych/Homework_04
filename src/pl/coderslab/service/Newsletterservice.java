package pl.coderslab.service;

import pl.coderslab.DAO.NewsletterDao;

public class Newsletterservice {
	private NewsletterDao newsletterDao;
	
	public Newsletterservice() {
		newsletterDao = new NewsletterDao();
	}

	public void savePerson(String name, String email) {
		newsletterDao.insertData(name, email);
	}
}
