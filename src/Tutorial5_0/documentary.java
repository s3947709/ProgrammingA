package Tutorial5_0;

abstract class Documentary extends Movie {
    private String subject;

    public Documentary (String subject, String title, String director, int year, double rating){
        super(title,director,year,rating);
        this.subject = subject;
    }

    public String toString(){
        return MovieString() + " \n Subject: " +subject;
    }
}
