package Tutorial1_1;

class Movie {
    private String title;
    private String director;
    private int year;
    private int rating;

    public static final int MIN_RATING = 0;
    public static final int MAX_RATING = 10;

    public Movie (String title, String director, int year, int rating){
        this.title = title;
        this.director = director;
        this.year = year;
        setRating(rating);
    }

    public void setRating(int rating){
        if (rating <0 || rating >5){
            this.rating = 0;
        } else{
            this.rating=rating;
        }
    }

    public String toString() {
        return "The movie " + title + " was made in the year " + year + " by " + director + " and was given a rating of " + rating;
    }
}