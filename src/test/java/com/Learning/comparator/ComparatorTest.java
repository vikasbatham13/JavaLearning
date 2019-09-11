package com.Learning.comparator;

import com.Learning.comparator.dao.player.Player;
import com.Learning.comparator.dao.player.PlayerBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class ComparatorTest {

    List<Player> playerList;

    @BeforeEach
    void setUp() {

        playerList = Arrays.asList(new Player(15, "john", 28),
                new Player(1, "john", 28),
                new Player(15, "john", 24),
                new Player(10, "test", 20),
                new Player(15, "carry", 21),
                new Player(15, "carry", 19),
                new Player(15, "mina", 24),
                new Player(15, "mina", 23),
                new Player(15, "zang", 45),
                new Player(15, "zang", 23)
        );

    }

    @Test
    public void testComparingName() {

        Comparator<Player> compareByName = Comparator.comparing(Player::getName);
        System.out.println("Inside TestComparing 1 - > " + playerList);
        Collections.sort(playerList, compareByName);
        System.out.println("After - > " + playerList);
        assertNotNull(playerList);
    }

    @Test
    public void testComparingNamebyDesc() {

        Comparator<Player> compareByNamedesc = Comparator.comparing(Player::getName, (s1, s2) -> {
            return s2.compareTo(s1);
        });
        System.out.println("Inside TestComparing 2 - > " + playerList);
        Collections.sort(playerList, compareByNamedesc);
        System.out.println("After - > " + playerList);
        assertNotNull(playerList);
    }

    @Test
    public void testComparingAge() {

        System.out.println("Inside TestComparing 3 - > " + playerList);
        Collections.sort(playerList, Comparator.comparing(Player::getAge));
        System.out.println("After - > " + playerList);
        assertNotNull(playerList);
    }

    @Test
    public void testComparingReversed() {

        System.out.println("Inside TestComparing 4 - > " + playerList);
        Comparator<Player> compareByName = Comparator.comparing(Player::getName);
        Comparator<Player> revrseComparator = compareByName.reversed();
        Collections.sort(playerList, revrseComparator);

        System.out.println("After - > " + playerList);
        assertNotNull(playerList);
    }

    @Test
    public void testComparingReversed2() {

        System.out.println("Inside TestComparing 5 - > " + playerList);
        Collections.sort(playerList, Comparator.comparing(Player::getAge).reversed());
        System.out.println("After - > " + playerList);
        assertNotNull(playerList);
    }

    @Test
    public void testComparingInt() {

        System.out.println("Inside TestComparing 6 - > " + playerList);
        Collections.sort(playerList, Comparator.comparingInt(Player::getAge));
        System.out.println("After - > " + playerList);
        Collections.sort(playerList, Comparator.comparingInt(Player::getAge).reversed());
        System.out.println("After reversed- > " + playerList);
        assertNotNull(playerList);
    }
}