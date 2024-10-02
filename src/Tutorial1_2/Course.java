package Tutorial1_2;

class Course {
    private String code;
    private String title;
    private int weeks;

    //pulling the Tutor data from the Tutor.java file
    private Tutor tutor;

    public Course (String code, String title, int weeks){
        this.code = code;
        this.title = title;
        this.weeks = weeks;
    }

    public Tutor getTutor() {
        setTutor(tutor);
        return tutor;
    }

    public void setTutor(Tutor tutor){
        this.tutor = tutor;
    }

    public String toString(){
        return "The course " + title + " (" + code + ") goes for " + weeks + " weeks.\nTutor details: " + tutor;
    }
}
