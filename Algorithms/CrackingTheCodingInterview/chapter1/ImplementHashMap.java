package chapter1;

import java.util.ArrayList;

class ImplementHashMap {
	
	ArrayList<String>[] hashMap = new ArrayList[11];

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
		for (int i = 0; i < hashMap.length; i++) {

			if (hashMap[i] != null && hashMap[i].get(0).equals(keyToHash)) {
				System.out.println("Duplicate key. Enter an unique one");
				System.exit(-1);
			}
		}

		int hash = generateHash(keyToHash);
		int index = hash % hashMap.length;

		ArrayList<String> element = new ArrayList<String>();
		element.add(keyToHash);
		element.add(value);
		// Unique hash check
		if (hashMap[index] == null) {
			hashMap[index] = element;

		} else {
			System.out.println("Duplicate index");
			System.exit(-1);
		}

	}

	public void get(String keyToHash) {
		int hash = generateHash(keyToHash);
		int index = hash % hashMap.length;

		if (hashMap[index] != null) {

			System.out.println(hashMap[index].get(0) + "\t:   "
					+ hashMap[index].get(1));

		} else
			System.out.println("Key does not exist in the hashtable");

	}
	
	public void remove(String keyToHash)
	{
		int hash = generateHash(keyToHash);
		int index = hash % hashMap.length;
		if (hashMap[index] != null && hashMap[index].get(0).equals(keyToHash)) {
			hashMap[index] = null;
		}
	}

	public void displayHashMap() {
		for (int i = 0; i < hashMap.length; i++) {

			if (hashMap[i] != null) {
				System.out.println(hashMap[i].get(0) + "\t:   "
						+ hashMap[i].get(1));
			}
		}
		System.out.println("____________________________________");

	}

	public static void main(String[] args) {
		ImplementHashMap h = new ImplementHashMap();
		h.put("gowri", "9");
		h.put("vineet", "12");
		h.displayHashMap();
		
		
		//h.get("vineet");
		
		h.remove("vineet");

		h.displayHashMap();
		
	}

}