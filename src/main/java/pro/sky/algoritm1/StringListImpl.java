package pro.sky.algoritm1;

import pro.sky.algoritm1.exceptions.IncorrectCapacityException;
import pro.sky.algoritm1.exceptions.IncorrectIndexException;
import pro.sky.algoritm1.exceptions.ItemIsNullException;

import java.util.Arrays;
import java.util.Objects;

public class StringListImpl implements StringList {

    private final static int DEFAULT_CAPACITY = 10;
    private final String[] storage;
    private int size;

    public StringListImpl() {
        this(DEFAULT_CAPACITY);
    }

    public StringListImpl(int size) {
        if (size <= 0) {
            throw new IncorrectCapacityException();
        }
        storage = new String[size];
        this.size = 0;
    }

    @Override
    public String add(String item) {
        return add(size, item);
    }

    @Override
    public String add(int index, String item) {
        checkIsNull(item);
        if (size == storage.length) {
            throw new IncorrectIndexException();
        }
        checkIndex(index, false);
        if (index < size) {
            System.arraycopy(storage, 0, storage, index + 1, size - index);
        }
        storage[index] = item;
        size++;
        return item;
    }

    private void checkIsNull(String item) {
        if (Objects.isNull(item)) {
            throw new ItemIsNullException();
        }
    }

    private void checkIndex(int index, boolean include) {
        if (index < 0 || include ? index >= size : index > size) {
            throw new IncorrectIndexException();
        }
    }

    @Override
    public String set(int index, String item) {
        checkIsNull(item);
        checkIndex(index, true);
        storage[index] = item;
        return item;
    }

    @Override
    public String remove(String item) {
        return remove(indexOf(item));
    }

    @Override
    public String remove(int index) {
        checkIndex(index, true);
        String removed = storage[index];
        if (index < size - 1) {
            System.arraycopy(storage, index + 1, storage, index, size - index - 1);
        }
        storage[--size] = null;
        return removed;
    }

    @Override
    public boolean contains(String item) {
        checkIsNull(item);
        for (int i = 0; i < size; i++) {
            if (storage[i].equals(item)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(String item) {
        checkIsNull(item);
        for (int i = 0; i < size; i++) {
            if (storage[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        checkIsNull(item);
        for (int i = size -1; i >= 0; i--) {
            if (storage[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String get(int index) {
        checkIndex(index,true);
        return storage[index];
    }

    @Override
    public boolean equals(StringList otherList) {
        if(size()!=otherList.size()) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if(!storage[i].equals(otherList.get(i))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            storage[i] = null;
        }
        size = 0;
    }

    @Override
    public String[] toArray() {
        return Arrays.copyOf(storage, size);
    }
}
