package com.aiden.andmodule.model;

/**
 * My 단어
 */
public class MyEditWord {
    public int id;
    public String word_eng;// 영어 단어
    public String word_kor;// 한글 뜻

    public boolean isSelect() {
        return isSelect;
    }

    public void setSelect(boolean select) {
        isSelect = select;
    }

    boolean isSelect=false;
}
