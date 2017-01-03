package main;

import app.TextIndexer;

public class Main {

	public static void main(String[] args) {
		TextIndexer textIndexer = new TextIndexer();
		textIndexer.indexText("Some text need to be indexed");
	}

}
