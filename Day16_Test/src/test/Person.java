package test;

public class Person {
    private String name;
    private String nickname;
    private String score="0";
    private String possWork;

    public Person() {
    }

    public Person(String name, String nickname, String possWork) {
        this.name = name;
        this.nickname = nickname;
        this.possWork = possWork;
    }

    public Person(String name, String nickname, String score, String possWork) {
        this.name = name;
        this.nickname = nickname;
        this.score = score;
        this.possWork = possWork;
    }

    public Person(String name, String possWork) {
        this.name = name;
        this.possWork = possWork;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }



    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPossWork() {
        return possWork;
    }

    public void setPossWork(String possWork) {
        this.possWork = possWork;
    }


}
