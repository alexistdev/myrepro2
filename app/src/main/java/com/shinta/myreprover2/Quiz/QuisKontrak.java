package com.shinta.myreprover2.Quiz;

import android.provider.BaseColumns;

public final class QuisKontrak {

    private QuisKontrak() {}

    public static class QuestionsTable implements BaseColumns {
        public static final String TABLE_NAME = "quiz_questions";
        public static final String COLUMN_QUESTION = "question";
        public static final String COLUMN_QUESTION2 = "question2";
        public static final String COLUMN_OPTION1 = "option1";
        public static final String COLUMN_OPTION2 = "option2";
        public static final String COLUMN_OPTION3 = "option3";
        public static final String COLUMN_OPTION4 = "option4";
        public static final String COLUMN_OPTION5 = "option5";
        public static final String COLUMN_STATUS_PR = "status_pr";
        public static final String COLUMN_ANSWER_NR = "answer_nr";
    }
}
