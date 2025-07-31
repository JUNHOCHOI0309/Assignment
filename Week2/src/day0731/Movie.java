package day0731;

public class Movie {//과제 8
    private String title;
    private double rating;

    public Movie(String title, double rating) {
        this.title = title;
        this.rating = rating;
    }
    public String getTitle() {
        return title;
    }

    public double getRating() {
        return rating;
    }

    public static void main(String[] args) {
        Movie[] m = new Movie[3];
        m[0] = new Movie("spiderman", 9.5);
        m[1] = new Movie("avengers", 9.2);
        m[2] = new Movie("the avengers", 9.1);

        Movie bestMovie = m[0];

        for (Movie movie : m) {
            if (movie.rating > bestMovie.rating) {
                bestMovie = movie;
            }
        }
        System.out.println("최고 평점 영화: "+ bestMovie.getTitle()+ " (평점:"+ bestMovie.getRating()+")");
    }
}
