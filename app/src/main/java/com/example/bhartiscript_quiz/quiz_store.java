package com.example.bhartiscript_quiz;

import android.provider.BaseColumns;

public class quiz_store {
    public quiz_store() {
    }

    public static class QuestionsTable implements BaseColumns {
        public static final String TABLE_NAME1 = "quiz1_questions";
        public static final String TABLE_NAME2 = "quiz2_questions";
        public static final String TABLE_NAME3 = "quiz3_questions";
        public static final String TABLE_NAME4 = "quiz4_questions";
        public static final String TABLE_NAME5 = "quiz5_questions";
        public static final String TABLE_NAME6 = "quiz6_questions";
        public static final String COLUMN_QUESTION = "question";
        public static final String COLUMN_OPTION1 = "option1";
        public static final String COLUMN_OPTION2 = "option2";
        public static final String COLUMN_OPTION3 = "option3";
        public static final String COLUMN_OPTION4 = "option4";
        public static final String COLUMN_ANSWER = "answer";
    }
}
