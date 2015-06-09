package chapter1;

import java.util.ArrayList;

class ImplementHashTable {
	
	ArrayList<String>[] timetable = new ArrayList[100];

	public int generateHash(String stringToHash) {
		if (!stringToHash.equals("")) {
			int hash = 0;
			for (int i = 0; i < stringToHash.length(); i++) {
				char c = stringToHash.charAt(i);
				int ascii = (int) c;
				hash = hash ^ ascii;
			}

			return hash;

		} else {
			System.out.println("Please enter a valid key");
			return -1;
		}

	}

	public void put(String keyToHash, String value) {
		
		// Unique key check
		for (int i = 0; i < timetable.length; i++) {

			if (timetable[i] != null && timetable[i].get(0).equals(keyToHash)) {
				System.out.println("Duplicate key. Enter an unique one");
				System.exit(-1);
			}
		}

		int hash = generateHash(keyToHash);
		int index = hash % timetable.length;

		ArrayList<String> element = new ArrayList<String>();
		element.add(keyToHash);
		element.add(value);
		// Unique hash check
		if (timetable[index] == null) {
			timetable[index] = element;

		} else {
			System.out.println("Duplicate index");
			System.exit(-1);
		}

	}

	public void get(String keyToHash) {
		int hash = generateHash(keyToHash);
		int index = hash % timetable.length;

		if (timetable[index] != null) {

			System.out.println(timetable[index].get(0) + "\t:   "
					+ timetable[index].get(1));

		} else
			System.out.println("Key does not exist in the hashtable");

	}
	
	public void deleteElement(String keyToHash)
	{
		int hash = generateHash(keyToHash);
		int index = hash % timetable.length;
		if (timetable[index] != null && timetable[index].get(0).equals(keyToHash)) {
			timetable[index] = null;
		}
	}

	public void displayHashTable() {
		for (int i = 0; i < timetable.length; i++) {

			if (timetable[i] != null) {
				System.out.println(timetable[i].get(0) + "\t:   "
						+ timetable[i].get(1));
			}
		}
		System.out.println("____________________________________");

	}

	public static void main(String[] args) {
		ImplementHashTable h = new ImplementHashTable();
		h.put("gowri", "9");
		h.put("vineet", "12");
		h.displayHashTable();
		
		
		//h.get("vineet");
		
		h.deleteElement("vineet");

		h.displayHashTable();
		
	}

}