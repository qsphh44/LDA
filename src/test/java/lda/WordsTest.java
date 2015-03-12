package lda;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class WordsTest {
    Words sut;
    @Before
    public void setUp() throws Exception {
        List<Vocabulary> list = Arrays.asList(new Vocabulary(1, "a"),
                                              new Vocabulary(2, "b"),
                                              new Vocabulary(3, "c"));
        sut = new Words(list);
    }
    
    @Test
    public void get_0_returns_1_a() throws Exception {
        assertThat(sut.get(0).id(), is(1));
        assertThat(sut.get(0).toString(), is("a"));
    }
    
    @Test
    public void get_2_returns_3_c() throws Exception {
        assertThat(sut.get(2).id(), is(3));
        assertThat(sut.get(2).toString(), is("c"));
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void get_minus_1_throws_IllegalArgumentException() throws Exception {
        sut.get(-1);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void get_3_throws_IllegalArgumentException() throws Exception {
        sut.get(3);
    }
}