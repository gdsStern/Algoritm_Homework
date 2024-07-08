package pro.sky.algoritm1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pro.sky.algoritm1.exceptions.IncorrectIndexException;
import pro.sky.algoritm1.exceptions.ItemIsNullException;

import java.sql.Array;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class IntegerListTest {

    private IntegerList integerList;

    @BeforeEach
    public void beforeEach() {
        integerList = new IntegerListImpl(5);
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);
        integerList.add(4);
    }

    @Test
    public void addTest() {
        Integer text = integerList.add(4);
        Integer text1 = integerList.get(3);
        assertThat(text).isEqualTo(text1);
        assertThat(integerList.size()).isEqualTo(5);
    }

    @Test
    public void add2Test() {
        Integer text = integerList.add(2,4);
        Integer text1 = integerList.get(2);
        assertThat(text).isEqualTo(text1);
    }

    @Test
    public void addNegativeTest() {
        assertThatExceptionOfType(ItemIsNullException.class)
                .isThrownBy(() -> integerList.add(null));

        assertThatExceptionOfType(IncorrectIndexException.class)
                .isThrownBy(() -> integerList.add(6,5));
    }

    @Test
    public void removeTest() {
        Integer text = integerList.remove(1);
        assertThat(integerList.size()).isEqualTo(3);
        assertThat(text).isEqualTo(2);
    }

    @Test
    public void remove2Test() {
        Integer text = integerList.remove(3);
        assertThat(integerList.size()).isEqualTo(3);
        assertThat(text).isEqualTo(4);
    }

    @Test
    public void setTest() {
        Integer text = integerList.set(3,8);
        assertThat(integerList.get(3)).isEqualTo(text);
    }

    @Test
    public void containsTest() {
        assertThat(integerList.contains(2)).isEqualTo(true);
        assertThat(integerList.contains(6)).isEqualTo(false);
    }

    @Test
    public void indexOfTest() {
        assertThat(integerList.indexOf(3)).isEqualTo(2);
        assertThat(integerList.indexOf(7)).isEqualTo(-1);
    }

    @Test
    public void lastIndexOfTest() {
        assertThat(integerList.indexOf(4)).isEqualTo(3);
        assertThat(integerList.indexOf(7)).isEqualTo(-1);
    }

    @Test
    public void equalsTest() {
        IntegerList stringList2 = new IntegerListImpl(5);
        stringList2.add(1);
        stringList2.add(2);
        stringList2.add(3);
        stringList2.add(4);

        assertThat(integerList.equals(stringList2)).isEqualTo(true);
        stringList2.remove(3);
        assertThat(integerList.equals(stringList2)).isEqualTo(false);

    }

    @Test
    public void getTest() {
        assertThat(integerList.get(3)).isEqualTo(4);
    }

    @Test
    public void sizeTest() {
        assertThat(integerList.size()).isEqualTo(4);
        integerList.remove(2);
        assertThat(integerList.size()).isEqualTo(3);
    }

    @Test
    public void isEmptyTest() {
        assertThat(integerList.isEmpty()).isEqualTo(false);
        integerList.clear();
        assertThat(integerList.isEmpty()).isEqualTo(true);
    }

    @Test
    public void clearTest() {
        integerList.clear();
        assertThat(integerList.size()).isEqualTo(0);
        assertThat(integerList.isEmpty()).isEqualTo(true);
    }

    @Test
    public void toArrayTest() {
        Integer[] strings1 = new Integer[]{1,2,3,4};
        assertThat(integerList.toArray()).isEqualTo(strings1);
    }
}
