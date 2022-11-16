package data_structure.my_interface;

public interface MyList<E> {

    /**
     * 리스트에 요소 추가
     * @param value 추가하려는 요소
     * @return 중복을 허용하지 않을 경우에는 리스트에 이미 중복 요소가 있을 경우 false 반환,
     *          중복되는 요소가 없을 경우 true 반환
     */
    boolean add(E value);

    /**
     * 리스트의 특정 인덱스에 요소 추가
     * 특정 위치 및 그 이후 요소들은 한 칸씩 뒤로 밀림
     * @param index 추가하려는 특정 인덱스
     * @param value 추가하려는 요소
     * @return
     */
    void add(int index, E value);

    /**
     * 특정 인덱스의 요소 삭제
     * @param index 삭제할 인덱스
     * @return 삭제된 요소 반환
     */
    E remove(int index);

    /**
     * 특정 요소 삭제, 동일한 요소가 여럿일경우 가장 처음 발견한 요소만 삭제
     * @param value 삭제할 요소
     * @return 리스트에 삭제할 요소가 없거나 실패할 경우 false 반환, 성공시 true 반환
     */
    boolean remove(Object value);

    /**
     * 리스트에 특정 요소가 있는지 확인
     * @param value 확인할려고 하는 요소
     * @return 리스트에 있을 경우 ture, 없을 경우 false
     */
    boolean contains(Object value);

    /**
     * 리스트의 요소 갯수 반환
     * @return
     */
    int size();

    /**
     * 특정 인덱스의 요소 반환
     * @param index 반환할 요소의 인덱스
     * @return 해당 인덱스의 요소 반환
     */
    E get(int index);

    /**
     * 특정 인덱스의 요소 변경
     * @param index 변경할 요소의 인덱스
     * @param value 변결할 요소의 새로운 값
     */
    void set(int index, E value);

    /**
     * 리스트의 요소가 비어있느지 확인
     * @return 비어있으면 true, 요소가 있을 경우 false
     */
    boolean isEmpty();

    /**
     * 해당 요소가 위치한 인데스 값 반환
     * @param value 찾기 위한 요소
     * @return 리스트에서 처음으로 일치하는 인덱스 값 반환, 없으면 -1 반환
     */
    int indexOf(Object value);

    /**
     * 리스트의 모든 요소 삭제
     */
    void clear();

    /**
     * 리스트 복제
     */
    Object clone() throws CloneNotSupportedException;

}
