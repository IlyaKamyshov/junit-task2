package org.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class AlgoIntroTest {

    @ParameterizedTest
    @CsvSource(value = {
            "31, 0",
            "26, 2",
            "25, 2",
            "20, 8"
    })
    void countMore(int money, int expected) {
        // given:
        int[] prices = {13, 17, 19, 25, 25, 25, 25, 25, 25, 27, 30};
        // when:
        int actual = AlgoIntro.countMore(prices, money);
        // then:
        assertThat(actual, is(expected));
    }

}