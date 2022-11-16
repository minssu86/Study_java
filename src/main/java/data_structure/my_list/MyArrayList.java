package data_structure.my_list;

import data_structure.my_interface.MyList;

import java.util.Arrays;

public class MyArrayList<E> implements MyList {


    private static final int DEFAULT_CAPACITY = 10; // 배열이 생성 될 때의 최초 할당 크기
    private static final Object[] EMPTY_ARRAY = {}; // 빈배열
    private int size; // 요소 개수
    Object[] array; // 요소를 담을 배열

    // 초기 공간 할당 없음
    public MyArrayList() {
        this.array = EMPTY_ARRAY;
        this.size = 0;
    }

    // 초기 공간 할당 (capacity)
    public MyArrayList(int capacity){
        this.array = new Object[capacity];
        this.size = 0;
    }

    // 동적할당을 위한 resize 메소드
    private void resize(){
        int arrayCapacity = array.length;

        // array 의 크기가 0 일 경우
        if(Arrays.equals(array, EMPTY_ARRAY)){
            array = new Object[DEFAULT_CAPACITY];
            return;
        }

        // 배열의 크기가 꽉 찰 경우
        if (size == arrayCapacity){
            int newCapacity = arrayCapacity * 2;

            // copy
            array = Arrays.copyOf(array, newCapacity);
            return;
        }

        // 배열의 크기가 절반 미만으로 차지하고 있을 경우
        if (size < (arrayCapacity / 2)) {
            int newCapacity = arrayCapacity / 2;

            // copy
            array = Arrays.copyOf(array, Math.max(newCapacity, DEFAULT_CAPACITY));
        }

    }


    @Override
    public boolean add(Object value) {
        // 배열이 꽉 차있는 상태라면 크기 재할당
        if (size == array.length){
            resize();
        }
        array[size] = value;
        size++;
        return true;
    }

    @Override
    public void add(int index, Object value) {

        // 범위를 벗어난 경우 예외 처리
        if (index > size || index < 0 ){
            throw new IndexOutOfBoundsException();
        }
        // 인덱스가 마지막 위치일 경우
        if (index == size){
            add(value);
        }

        // index 기준 뒤에 있는 요소들 한 칸씩 뒤로 밀기
        for (int i = size; i > index; i--){
            array[i] = array[i - 1];
        }

        array[index] = value;
        size++;

    }

    @SuppressWarnings("unchecked")
    @Override
    public E remove(int index) {
        // 범위를 벗어난 경우 예외 처리
        if (index >= size || index <0 ){
            throw new IndexOutOfBoundsException();
        }
        E element = (E) array[index];
        array[index] = null;
        // 삭제한 요소 뒤에 있는 모든 요소들 한칸씩 전진
        for (int i = index; i < size - 1; i++){
            array[i] = array[i+1];
            array[i + 1] = null;
        }
        size--;
        resize();
        return element;
    }

    @Override
    public boolean remove(Object value) {
        // 삭제할려는 요소의 인덱스 찾기
        int index = indexOf(value);
        if(index == -1){
            return false;
        }
        remove(index);
        return true;
    }

    @Override
    public boolean contains(Object value) {
        // 0 이상이면 요소가 존재함
        return indexOf(value) >= 0;
    }

    @Override
    public int size() {
        return size;
    }

    @SuppressWarnings("unchecked")
    @Override
    public E get(int index) {
        // 범위를 벗어난 경우 예외 처리
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        // Object 타입에서 E 타입으로 캐스팅 후 반환
        return (E) array[index];
    }

    @Override
    public void set(int index, Object value) {
        // 범위를 벗어난 경우 예외 처리
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        } else {
            array[index] = value;
        }
    }

    @Override
    public boolean isEmpty() {
        return size ==0;
    }

    @Override
    public int indexOf(Object value) {

        // value 와 같은 객체일 경우 i 반환
        for (int i = 0; i < size; i++){
            if (array[i].equals(value)){
                return i;
            }
        }
        // 일치하는 것이 없을 경우
        return -1;
    }

    public int lastIndexOf(Object value){
        for (int i = size-1; i >= 0; i--){
            if (array[i].equals(value)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++){
            array[i] = null;
        }
        size = 0;
        resize();
    }

    @Override
    public Object clone() throws CloneNotSupportedException{

        // 새로운 객체 생성
        MyArrayList<?> cloneList = (MyArrayList<?>) super.clone();

        // 새로운 객체의 배열 생성
        cloneList.array = new Object[size];

        // 배열의 값 복사
        System.arraycopy(array, 0, cloneList.array, 0, size);

        return cloneList;
    }

    public Object[] toArray(){
        return Arrays.copyOf(array, size);
    }

    public <T> T[] toArray(T[] a){
        if(a.length < size){
            return (T[]) Arrays.copyOf(array, size, a.getClass());
        }
        System.arraycopy(array, 0, a, 0, size);
        return a;
    }

}
