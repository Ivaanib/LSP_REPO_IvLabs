package org.howard.edu.lsp.midterm.question2;

public class Book {
	
	/**
	 * Ivan Ibhawoh
	 * @param args
	 */
    private String title;
    private String author;
    private String ISBN;
    private int yearPublished;
    /**
     * Constructs a Book with the specified attributes.
     * @param title the title of the book
     * @param author the author of the book
     * @param ISBN the ISBN of the book
     * @param yearPublished the year the book was published
     */

    
    
    public Book(String title, String author, String ISBN, int yearPublished) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.yearPublished = yearPublished;
    }

 // Getters
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getISBN() { return ISBN; }
    public int getYearPublished() { return yearPublished; }

 // Setters
    public void setTitle(String title) { this.title = title; }
    public void setAuthor(String author) { this.author = author; }
    public void setISBN(String ISBN) { this.ISBN = ISBN; }
    public void setYearPublished(int yearPublished) { this.yearPublished = yearPublished; }

    /**
     * Checks if this Book is equal to another object based on ISBN and author.
     * @param obj the object to compare with
     * @return true if the ISBN and author match, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Book)) return false;
        Book other = (Book) obj;
        return this.ISBN.equals(other.ISBN) && this.author.equals(other.author);
    }

    /**
     * Returns a string representation of the Book.
     * @return a formatted string with title, author, ISBN, and year published
     */
    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author + ", ISBN: " + ISBN + ", Year Published: " + yearPublished;
    }
}



