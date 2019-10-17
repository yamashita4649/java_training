package ch04.ex03;

public interface ListInterface {


    /**
     * count番目のvalueを取得するメソッド
     * 存在しない番号はnullを返す
     * */
    public Object getValue(int count);

    /**
     * リスト数を返すメソッド
     * */
    public int getListSize();


}
