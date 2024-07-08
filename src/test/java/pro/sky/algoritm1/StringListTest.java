package pro.sky.algoritm1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pro.sky.algoritm1.exceptions.IncorrectIndexException;
import pro.sky.algoritm1.exceptions.ItemIsNullException;

import java.sql.Array;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class StringListTest {

    private StringList stringList;

    @BeforeEach
    public void beforeEach() {
        stringList = new StringListImpl(5);
        stringList.add("1");
        stringList.add("2");
        stringList.add("3");
        stringList.add("4");
    }

    @Test
    public void addTest() {
        String text = stringList.add("4");
        String text1 = stringList.get(3);
        assertThat(text).isEqualTo(text1);
        assertThat(stringList.size()).isEqualTo(5);
    }

    @Test
    public void add2Test() {
        String text = stringList.add(2,"4");
        String text1 = stringList.get(2);
        assertThat(text).isEqualTo(text1);
    }

    @Test
    public void addNegativeTest() {
        assertThatExceptionOfType(ItemIsNullException.class)
                .isThrownBy(() -> stringList.add(null));

        assertThatExceptionOfType(IncorrectIndexException.class)
                .isThrownBy(() -> stringList.add(6,"5"));
    }

    @Test
    public void removeTest() {
        String text = stringList.remove(1);
        assertThat(stringList.size()).isEqualTo(3);
        assertThat(text).isEqualTo("2");
    }

    @Test
    public void remove2Test() {
        String text = stringList.remove("4");
        assertThat(stringList.size()).isEqualTo(3);
        assertThat(text).isEqualTo("4");
    }

    @Test
    public void setTest() {
        String text = stringList.set(3,"8");
        assertThat(stringList.get(3)).isEqualTo(text);
    }

    @Test
    public void containsTest() {
        assertThat(stringList.contains("2")).isEqualTo(true);
        assertThat(stringList.contains("6")).isEqualTo(false);
    }

    @Test
    public void indexOfTest() {
        assertThat(stringList.indexOf("3")).isEqualTo(2);
        assertThat(stringList.indexOf("7")).isEqualTo(-1);
    }

    @Test
    public void lastIndexOfTest() {
        assertThat(stringList.indexOf("4")).isEqualTo(3);
        assertThat(stringList.indexOf("7")).isEqualTo(-1);
    }

    @Test
    public void equalsTest() {
        StringList stringList2 = new StringListImpl(5);
        stringList2.add("1");
        stringList2.add("2");
        stringList2.add("3");
        stringList2.add("4");

        assertThat(stringList.equals(stringList2)).isEqualTo(true);
        stringList2.remove(1);
        assertThat(stringList.equals(stringList2)).isEqualTo(false);

    }

    @Test
    public void getTest() {
        assertThat(stringList.get(3)).isEqualTo("4");
    }

    @Test
    public void sizeTest() {
        assertThat(stringList.size()).isEqualTo(4);
        stringList.remove(2);
        assertThat(stringList.size()).isEqualTo(3);
    }

    @Test
    public void isEmptyTest() {
        assertThat(stringList.isEmpty()).isEqualTo(false);
        stringList.clear();
        assertThat(stringList.isEmpty()).isEqualTo(true);
    }

    @Test
    public void clearTest() {
        stringList.clear();
        assertThat(stringList.size()).isEqualTo(0);
        assertThat(stringList.isEmpty()).isEqualTo(true);
    }

    @Test
    public void toArrayTest() {
        String[] strings1 = new String[]{"1","2","3","4"};
        assertThat(stringList.toArray()).isEqualTo(strings1);
    }
}
