package org.example;

public class Book {
    private String title, author, genre, language;
    private int id, publicationYear, pageCount, weight, price;

    public Book(int id, String title, String author, String genre, String language,
                int publicationYear, int pageCount, int weight, int price) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.language = language;
        this.publicationYear = publicationYear;
        this.pageCount = pageCount;
        this.weight = weight;
        this.price = price;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ( (obj == null) || (! (obj instanceof Book))) {
            return false;
        }
        Book other = (Book) obj;

        return ((other.title == this.title) && (other.author == this.author) &&
                (other.language == this.language) && (other.pageCount == this.pageCount));
    }
    @Override
    public String toString() {
        String book = new String(this.title + ", wrote by " + this.author + ", year of publication - "
                + this.publicationYear + " has " + this.pageCount + " pages.");
        return book;
    }

    public int getId(){
        return id;
    }

    public void setid(int id){
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
