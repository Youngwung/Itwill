package com.itwill.prac_contact06;

import java.util.ArrayList;
import java.util.List;

public class ContactDaoImpl implements ContactDao{
	List<Contact> contacts = new ArrayList<Contact>();

	@Override
	public int create(Contact contact) {
		contacts.add(contact);
		return 1;
	}

	@Override
	public List<Contact> read() {
		return contacts;
	}

	@Override
	public Contact read(int index) {
		return contacts.get(index);
	}

	@Override
	public int update(int index, Contact contact) {
		contacts.set(index, contact);
		return 1;
	}

	@Override
	public int delete(int index) {
		// TODO Auto-generated method stub
		return 0;
	}

}
