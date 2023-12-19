package org.example;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class TreeTest {

    @Test
    void isNamePyramid() {
        // given:
        Tree ll1 = new Tree("Александа");
        Tree lr1 = new Tree("Владимир");
        Tree l1 = new Tree("Борис");
        l1.setLeft(ll1);
        l1.setRight(lr1);
        Tree rl1 = new Tree("Иннокентий");
        Tree rr1 = new Tree("Пантелеймон");
        Tree r1 = new Tree("Константин");
        r1.setLeft(rl1);
        r1.setRight(rr1);
        Tree root1 = new Tree("Зоя");
        root1.setLeft(l1);
        root1.setRight(r1);

        Tree ll2 = new Tree("Александа");
        Tree lr2 = new Tree("Владимир");
        Tree l2 = new Tree("Борис");
        l2.setLeft(ll2);
        l2.setRight(lr2);
        Tree rl2 = new Tree("Иннокентий");
        Tree rr2 = new Tree("Павел");
        Tree r2 = new Tree("Константин");
        r2.setLeft(rl2);
        r2.setRight(rr2);
        Tree root2 = new Tree("Зоя");
        root2.setLeft(l2);
        root2.setRight(r2);
        // when:
        boolean expectedTrue = root1.isNamePyramid();
        boolean expectedFalse = root2.isNamePyramid();
        // then:
        assertThat(true, allOf(is(expectedTrue), not(expectedFalse)));

    }
}