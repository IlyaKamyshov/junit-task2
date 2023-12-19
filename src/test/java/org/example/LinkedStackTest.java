package org.example;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class LinkedStackTest {

    @Test
    void testToString() {
        LinkedStack stack = new LinkedStack();
        assertThat(stack.toString(), equalToIgnoringCase("empty"));
        stack.push(5);
        assertThat(stack.toString(), is("5"));
        stack.push(15);
        assertThat(stack.toString(), is("15 -> 5"));
        stack.push(25);
        assertThat(stack.toString(), is("25 -> 15 -> 5"));
        assertThat(stack.pop(), is(25));
        assertThat(stack.toString(), is("15 -> 5"));
        assertThat(stack.pop(), is(15));
        assertThat(stack.toString(), is("5"));
        assertThat(stack.pop(), is(5));
        assertThat(stack.toString(), equalToIgnoringCase("empty"));
    }

}