package Codility;

public class StudentScore {
    int id;
    String name;
    int score;

    public StudentScore(int id, String name, int score) {
        this.id = id;
        this.name = name;
        this.score = score;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public int getScore() {
        return this.score;
    }
}
