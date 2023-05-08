import java.util.Arrays;

public class MovieManager {
    private Movie[] movies;
    private int limit;

    public MovieManager() {
        this.limit = 5;
        this.movies = new Movie[0];
    }

    public MovieManager(int limit) {
        this.limit = limit;
        this.movies = new Movie[0];
    }

    public void addMovie(Movie movie) {
        Movie[] newMovies = new Movie[movies.length + 1];
        System.arraycopy(movies, 0, newMovies, 0, movies.length);
        newMovies[movies.length] = movie;
        movies = newMovies;
    }

    public Movie[] findAll() {
        return movies;
    }

    public Movie[] findLast() {
        int resultLength;
        if (limit <= movies.length) {
            resultLength = limit;
        } else {
            resultLength = movies.length;
        }
        Movie[] result = new Movie[resultLength];
        for (int i = 0; i < resultLength; i++) {
            result[i] = movies[movies.length - i - 1];
        }
        return result;
    }

    public static void main(String[] args) {
        MovieManager manager = new MovieManager(5);
        manager.addMovie(new Movie("Movie 1"));
        manager.addMovie(new Movie("Movie 2"));
        manager.addMovie(new Movie("Movie 3"));
        manager.addMovie(new Movie("Movie 4"));
        manager.addMovie(new Movie("Movie 5"));
        manager.addMovie(new Movie("Movie 6"));

        Movie[] allMovies = manager.findAll();
        System.out.println(Arrays.toString(allMovies));

        Movie[] lastMovies = manager.findLast();
        System.out.println(Arrays.toString(lastMovies));
    }
}
