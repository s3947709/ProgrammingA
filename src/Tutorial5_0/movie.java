package Tutorial5_0;

abstract class Movie{
    private String title;
    private String director;
    private int year;
    private double rating;

    public Movie(String title, String director, int year, double rating){
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
    }

    public double getRating(){
        return rating;
    }

    public abstract void setMethod();

    public String MovieString(){
        return "Title: "+title + " Director: " + director + " Year: " + year + " Rating: " + rating;
    }
}