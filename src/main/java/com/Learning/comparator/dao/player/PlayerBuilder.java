package com.Learning.comparator.dao.player;

public class PlayerBuilder {
    private int ranking;
    private String name;
    private int age;

    public PlayerBuilder setRanking(int ranking) {
        this.ranking = ranking;
        return this;
    }

    public PlayerBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PlayerBuilder setAge(int age) {
        this.age = age;
        return this;
    }

    public Player createPlayer() {
        return new Player(ranking, name, age);
    }
}