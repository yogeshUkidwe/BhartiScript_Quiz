package com.example.bhartiscript_quiz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Typeface;

import java.util.ArrayList;

import androidx.annotation.Nullable;
import androidx.core.content.res.ResourcesCompat;

public class quizDbSupport extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "BharatiQuiz1.db";
    private static final int DATABASE_VERSION = 1;
    private SQLiteDatabase db;
    public quizDbSupport(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db = db;
        //For Quiz 1
        final String SQL_CREATE_QUESTIONS_TABLEQ1 = "CREATE TABLE " +
                quiz_store.QuestionsTable.TABLE_NAME1 + " ( " +
                quiz_store.QuestionsTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                quiz_store.QuestionsTable.COLUMN_QUESTION + " TEXT, " +
                quiz_store.QuestionsTable.COLUMN_OPTION1 + " TEXT, " +
                quiz_store.QuestionsTable.COLUMN_OPTION2 + " TEXT, " +
                quiz_store.QuestionsTable.COLUMN_OPTION3 + " TEXT, " +
                quiz_store.QuestionsTable.COLUMN_OPTION4 + " TEXT, " +
                quiz_store.QuestionsTable.COLUMN_ANSWER + " INTEGER" +
                ")";


        //For Quiz 2
        final String SQL_CREATE_QUESTIONS_TABLEQ2 = "CREATE TABLE " +
                quiz_store.QuestionsTable.TABLE_NAME2 + " ( " +
                quiz_store.QuestionsTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                quiz_store.QuestionsTable.COLUMN_QUESTION + " TEXT, " +
                quiz_store.QuestionsTable.COLUMN_OPTION1 + " TEXT, " +
                quiz_store.QuestionsTable.COLUMN_OPTION2 + " TEXT, " +
                quiz_store.QuestionsTable.COLUMN_OPTION3 + " TEXT, " +
                quiz_store.QuestionsTable.COLUMN_OPTION4 + " TEXT, " +
                quiz_store.QuestionsTable.COLUMN_ANSWER + " INTEGER" +
                ")";

        //For quiz3
        final String SQL_CREATE_QUESTIONS_TABLEQ3 = "CREATE TABLE " +
                quiz_store.QuestionsTable.TABLE_NAME3 + " ( " +
                quiz_store.QuestionsTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                quiz_store.QuestionsTable.COLUMN_QUESTION + " TEXT, " +
                quiz_store.QuestionsTable.COLUMN_OPTION1 + " TEXT, " +
                quiz_store.QuestionsTable.COLUMN_OPTION2 + " TEXT, " +
                quiz_store.QuestionsTable.COLUMN_OPTION3 + " TEXT, " +
                quiz_store.QuestionsTable.COLUMN_OPTION4 + " TEXT, " +
                quiz_store.QuestionsTable.COLUMN_ANSWER + " INTEGER" +
                ")";

        //For Quiz4
        final String SQL_CREATE_QUESTIONS_TABLEQ4 = "CREATE TABLE " +
                quiz_store.QuestionsTable.TABLE_NAME4 + " ( " +
                quiz_store.QuestionsTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                quiz_store.QuestionsTable.COLUMN_QUESTION + " TEXT, " +
                quiz_store.QuestionsTable.COLUMN_OPTION1 + " TEXT, " +
                quiz_store.QuestionsTable.COLUMN_OPTION2 + " TEXT, " +
                quiz_store.QuestionsTable.COLUMN_OPTION3 + " TEXT, " +
                quiz_store.QuestionsTable.COLUMN_OPTION4 + " TEXT, " +
                quiz_store.QuestionsTable.COLUMN_ANSWER + " INTEGER" +
                ")";

        //for Quiz5
        final String SQL_CREATE_QUESTIONS_TABLEQ5 = "CREATE TABLE " +
                quiz_store.QuestionsTable.TABLE_NAME5 + " ( " +
                quiz_store.QuestionsTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                quiz_store.QuestionsTable.COLUMN_QUESTION + " TEXT, " +
                quiz_store.QuestionsTable.COLUMN_OPTION1 + " TEXT, " +
                quiz_store.QuestionsTable.COLUMN_OPTION2 + " TEXT, " +
                quiz_store.QuestionsTable.COLUMN_OPTION3 + " TEXT, " +
                quiz_store.QuestionsTable.COLUMN_OPTION4 + " TEXT, " +
                quiz_store.QuestionsTable.COLUMN_ANSWER + " INTEGER" +
                ")";

        final String SQL_CREATE_QUESTIONS_TABLEQ6 = "CREATE TABLE " +
                quiz_store.QuestionsTable.TABLE_NAME6 + " ( " +
                quiz_store.QuestionsTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                quiz_store.QuestionsTable.COLUMN_QUESTION + " TEXT, " +
                quiz_store.QuestionsTable.COLUMN_OPTION1 + " TEXT, " +
                quiz_store.QuestionsTable.COLUMN_OPTION2 + " TEXT, " +
                quiz_store.QuestionsTable.COLUMN_OPTION3 + " TEXT, " +
                quiz_store.QuestionsTable.COLUMN_OPTION4 + " TEXT, " +
                quiz_store.QuestionsTable.COLUMN_ANSWER + " INTEGER" +
                ")";
        db.execSQL(SQL_CREATE_QUESTIONS_TABLEQ1);
        db.execSQL(SQL_CREATE_QUESTIONS_TABLEQ2);
        db.execSQL(SQL_CREATE_QUESTIONS_TABLEQ3);
        db.execSQL(SQL_CREATE_QUESTIONS_TABLEQ4);
        db.execSQL(SQL_CREATE_QUESTIONS_TABLEQ5);
        db.execSQL(SQL_CREATE_QUESTIONS_TABLEQ6);

       QuestionsTableQ1();
       QuestionsTableQ2();
       QuestionsTableQ3();
       QuestionsTableQ4();
       QuestionsTableQ5();
       QuestionsTableQ6();
    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + quiz_store.QuestionsTable.TABLE_NAME1);
        db.execSQL("DROP TABLE IF EXISTS " + quiz_store.QuestionsTable.TABLE_NAME2);
        db.execSQL("DROP TABLE IF EXISTS " + quiz_store.QuestionsTable.TABLE_NAME3);
        db.execSQL("DROP TABLE IF EXISTS " + quiz_store.QuestionsTable.TABLE_NAME4);
        db.execSQL("DROP TABLE IF EXISTS " + quiz_store.QuestionsTable.TABLE_NAME5);
        db.execSQL("DROP TABLE IF EXISTS " + quiz_store.QuestionsTable.TABLE_NAME6);

        onCreate(db);
    }

    private void QuestionsTableQ1() {
      //  String a="क",b="ख",c="ग",d="घ",e="च",f="ज",g="झ",h="ट",i="ठ",k="ड",l="ढ",m="ण",n="त",o="थ",p="द",q="ध",r="न",s="प",t="फ",u="ब",v="भ",x="म",y="य",z="र",a1="ल",a2="ळ",a3="व",a4="ह",a5="श",a6="ष",a7="स";
        String[] QuestionsQ1 ={ "क","ख","ग","घ","च","ज","झ","ट","ठ","ड","ढ","ण","त","थ","द","ध","न","प","फ","ब","भ","म","य","र","ल","ळ","व","ह","श","ष","स","आ","उ","अ","ए","इ","ई", "ओ","अः"};
        int inc=0;
        for(int i=1;i<=QuestionsQ1.length-1;i++){

            //0,1,2,3,4
            if(i%10==0){
                inc+=1;
            }

            //abc(a[8],  a[7],a[8],a[9],a[10],2)      abc(a[16],  a[14],a[15],a[16],a[17],3),  abc(a[24],  a[21],a[22],a[23],a[24], 4)
            Question_data q= new Question_data(QuestionsQ1[i], QuestionsQ1[i-inc], QuestionsQ1[i+1-inc], QuestionsQ1[i+2-inc], QuestionsQ1[i+3-inc], 1+inc);
            addQuestionQ1(q);
        }

    }
    private void QuestionsTableQ2() {

        String[] QuestionsQ2 ={ "र्क","ख्य","ग्य","र्घ्य","श्च","ज्र","प्त","त्प","ल्क","क्ल","स्व","स्म","ह्म","र्ष","ध्य","द्घो","ज्ज","म्म","प्प","स्टि","श्र", "स्रो","द्र","न्सी","र्गि","र्मि","र्ति"};
        int inc=0;
        for(int i=1;i<=QuestionsQ2.length-1;i++){

            //0,1,2,3,4
            if(i%8==0){
                inc+=1;
            }

            //abc(a[8],  a[7],a[8],a[9],a[10],2)      abc(a[16],  a[14],a[15],a[16],a[17],3),  abc(a[24],  a[21],a[22],a[23],a[24], 4)
            Question_data q= new Question_data(QuestionsQ2[i], QuestionsQ2[i-inc], QuestionsQ2[i+1-inc], QuestionsQ2[i+2-inc], QuestionsQ2[i+3-inc], 1+inc);
            addQuestionQ2(q);
        }

    }

    private void QuestionsTableQ3() {
        //  String a="क",b="ख",c="ग",d="घ",e="च",f="ज",g="झ",h="ट",i="ठ",k="ड",l="ढ",m="ण",n="त",o="थ",p="द",q="ध",r="न",s="प",t="फ",u="ब",v="भ",x="म",y="य",z="र",a1="ल",a2="ळ",a3="व",a4="ह",a5="श",a6="ष",a7="स";
        String[] QuestionsQ3 = { "का","खि","ही","घि","चि","जु","झा","तो","थो","दु","धि","ते","तु","थै","दो","धौ","फी","बु","भः","मी","यु","रा","लो","पो","वा","हा","शी","को","सु"};
        int inc=0;
        for(int i=1;i<=QuestionsQ3.length-1;i++){

            //0,1,2,3,4
            if(i%8==0){
                inc+=1;
            }

            //abc(a[8],  a[7],a[8],a[9],a[10],2)      abc(a[16],  a[14],a[15],a[16],a[17],3),  abc(a[24],  a[21],a[22],a[23],a[24], 4)
            Question_data q= new Question_data(QuestionsQ3[i], QuestionsQ3[i-inc], QuestionsQ3[i+1-inc], QuestionsQ3[i+2-inc], QuestionsQ3[i+3-inc], 1+inc);
            addQuestionQ3(q);
        }

    }
    private void QuestionsTableQ4() {
        //  String a="क",b="ख",c="ग",d="घ",e="च",f="ज",g="झ",h="ट",i="ठ",k="ड",l="ढ",m="ण",n="त",o="थ",p="द",q="ध",r="न",s="प",t="फ",u="ब",v="भ",x="म",y="य",z="र",a1="ल",a2="ळ",a3="व",a4="ह",a5="श",a6="ष",a7="स";
        String[] QuestionsQ4 ={ "कम","खर","गम","घर","चरण","मज","झप","टर","ठप","डर","ढ्ग","पण","मत","रथ","कद","मध","मन","पर","फल","बर","भय","मगध","यम","कर","चल","फिर","वर","हम","शक","शत","सम","चार","महा","जोर","रवि","लीला","बाल","शिव","पूजा","देव","हीरा","वीर","शुर",};
        int inc=0;
        for(int i=1;i<=QuestionsQ4.length-1;i++){

            //0,1,2,3,4
            if(i%11==0){
                inc+=1;
            }

            //abc(a[8],  a[7],a[8],a[9],a[10],2)      abc(a[16],  a[14],a[15],a[16],a[17],3),  abc(a[24],  a[21],a[22],a[23],a[24], 4)
            Question_data q= new Question_data(QuestionsQ4[i], QuestionsQ4[i-inc], QuestionsQ4[i+1-inc], QuestionsQ4[i+2-inc], QuestionsQ4[i+3-inc], 1+inc);
            addQuestionQ4(q);
        }

    }
    private void QuestionsTableQ5() {
        //  String a="क",b="ख",c="ग",d="घ",e="च",f="ज",g="झ",h="ट",i="ठ",k="ड",l="ढ",m="ण",n="त",o="थ",p="द",q="ध",r="न",s="प",t="फ",u="ब",v="भ",x="म",y="य",z="र",a1="ल",a2="ळ",a3="व",a4="ह",a5="श",a6="ष",a7="स";
        String[] QuestionsQ5 ={ "कमाल","खरोच","गणित","महान","दीवार","बाहर","रहीम","गुरूजी","औरत","च्यवन","उत्तम","उन्नति","विशेष","विषय","भोपाल","नगर","मालूम","साधना","अवश्य","तुरंत","पालन","सत्संग","प्रार्थना","लाहोर","नेपाल","भूटान"};
        int inc=0;
        for(int i=1;i<=QuestionsQ5.length-1;i++){

            //0,1,2,3,4
            if(i%8==0){
                inc+=1;
            }

            //abc(a[8],  a[7],a[8],a[9],a[10],2)      abc(a[16],  a[14],a[15],a[16],a[17],3),  abc(a[24],  a[21],a[22],a[23],a[24], 4)
            Question_data q= new Question_data(QuestionsQ5[i], QuestionsQ5[i-inc], QuestionsQ5[i+1-inc], QuestionsQ5[i+2-inc], QuestionsQ5[i+3-inc], 1+inc);
            addQuestionQ5(q);
        }

    }

    private void QuestionsTableQ6() {
        //  String a="क",b="ख",c="ग",d="घ",e="च",f="ज",g="झ",h="ट",i="ठ",k="ड",l="ढ",m="ण",n="त",o="थ",p="द",q="ध",r="न",s="प",t="फ",u="ब",v="भ",x="म",y="य",z="र",a1="ल",a2="ळ",a3="व",a4="ह",a5="श",a6="ष",a7="स";
        String[] QuestionsQ6 = {"मात्रा","गुर्ग","कर्म","व्रज","यात्रा","अप्पा","उत्पल","शास्त्र", "पुत्रा","चाणक्य","गुस्सा","क्षमा","मौसम","प्रवेश","धात्रि","वशिष्ट","ग्रहण","आश्चर्य","अद्भुत","अध्यपक","पूज्य", "भविष्य","महाकाव्","प्रसन्न","महात्मा", "आनंदपूर्ण","आशीर्वाद","प्रदान"};
        int inc=0;
        for(int i=1;i<=QuestionsQ6.length-1;i++){

            //0,1,2,3,4
            if(i%8==0){
                inc+=1;
            }

            //abc(a[8],  a[7],a[8],a[9],a[10],2)      abc(a[16],  a[14],a[15],a[16],a[17],3),  abc(a[24],  a[21],a[22],a[23],a[24], 4)
            Question_data q= new Question_data(QuestionsQ6[i], QuestionsQ6[i-inc], QuestionsQ6[i+1-inc], QuestionsQ6[i+2-inc], QuestionsQ6[i+3-inc], 1+inc);
            addQuestionQ6(q);
        }

    }


    private void addQuestionQ1(Question_data question) {
        ContentValues cv = new ContentValues();
        cv.put(quiz_store.QuestionsTable.COLUMN_QUESTION, question.getQuestion());
        cv.put(quiz_store.QuestionsTable.COLUMN_OPTION1, question.getOption1());
        cv.put(quiz_store.QuestionsTable.COLUMN_OPTION2, question.getOption2());
        cv.put(quiz_store.QuestionsTable.COLUMN_OPTION3, question.getOption3());
        cv.put(quiz_store.QuestionsTable.COLUMN_OPTION4, question.getOption4());
        cv.put(quiz_store.QuestionsTable.COLUMN_ANSWER, question.getAnswer());
        db.insert(quiz_store.QuestionsTable.TABLE_NAME1, null, cv);
    }
    private void addQuestionQ2(Question_data question) {

        ContentValues cv = new ContentValues();
        cv.put(quiz_store.QuestionsTable.COLUMN_QUESTION, question.getQuestion());
        cv.put(quiz_store.QuestionsTable.COLUMN_OPTION1, question.getOption1());
        cv.put(quiz_store.QuestionsTable.COLUMN_OPTION2, question.getOption2());
        cv.put(quiz_store.QuestionsTable.COLUMN_OPTION3, question.getOption3());
        cv.put(quiz_store.QuestionsTable.COLUMN_OPTION4, question.getOption4());
        cv.put(quiz_store.QuestionsTable.COLUMN_ANSWER, question.getAnswer());
        db.insert(quiz_store.QuestionsTable.TABLE_NAME2, null, cv);
    }
    private void addQuestionQ3(Question_data question) {

        ContentValues cv = new ContentValues();
        cv.put(quiz_store.QuestionsTable.COLUMN_QUESTION, question.getQuestion());
        cv.put(quiz_store.QuestionsTable.COLUMN_OPTION1, question.getOption1());
        cv.put(quiz_store.QuestionsTable.COLUMN_OPTION2, question.getOption2());
        cv.put(quiz_store.QuestionsTable.COLUMN_OPTION3, question.getOption3());
        cv.put(quiz_store.QuestionsTable.COLUMN_OPTION4, question.getOption4());
        cv.put(quiz_store.QuestionsTable.COLUMN_ANSWER, question.getAnswer());
        db.insert(quiz_store.QuestionsTable.TABLE_NAME3, null, cv);
    }
    private void addQuestionQ4(Question_data question) {

        ContentValues cv = new ContentValues();
        cv.put(quiz_store.QuestionsTable.COLUMN_QUESTION, question.getQuestion());
        cv.put(quiz_store.QuestionsTable.COLUMN_OPTION1, question.getOption1());
        cv.put(quiz_store.QuestionsTable.COLUMN_OPTION2, question.getOption2());
        cv.put(quiz_store.QuestionsTable.COLUMN_OPTION3, question.getOption3());
        cv.put(quiz_store.QuestionsTable.COLUMN_OPTION4, question.getOption4());
        cv.put(quiz_store.QuestionsTable.COLUMN_ANSWER, question.getAnswer());
        db.insert(quiz_store.QuestionsTable.TABLE_NAME4, null, cv);
    }
    private void addQuestionQ5(Question_data question) {

        ContentValues cv = new ContentValues();
        cv.put(quiz_store.QuestionsTable.COLUMN_QUESTION, question.getQuestion());
        cv.put(quiz_store.QuestionsTable.COLUMN_OPTION1, question.getOption1());
        cv.put(quiz_store.QuestionsTable.COLUMN_OPTION2, question.getOption2());
        cv.put(quiz_store.QuestionsTable.COLUMN_OPTION3, question.getOption3());
        cv.put(quiz_store.QuestionsTable.COLUMN_OPTION4, question.getOption4());
        cv.put(quiz_store.QuestionsTable.COLUMN_ANSWER, question.getAnswer());
        db.insert(quiz_store.QuestionsTable.TABLE_NAME5, null, cv);
    }
    private void addQuestionQ6(Question_data question) {

        ContentValues cv = new ContentValues();
        cv.put(quiz_store.QuestionsTable.COLUMN_QUESTION, question.getQuestion());
        cv.put(quiz_store.QuestionsTable.COLUMN_OPTION1, question.getOption1());
        cv.put(quiz_store.QuestionsTable.COLUMN_OPTION2, question.getOption2());
        cv.put(quiz_store.QuestionsTable.COLUMN_OPTION3, question.getOption3());
        cv.put(quiz_store.QuestionsTable.COLUMN_OPTION4, question.getOption4());
        cv.put(quiz_store.QuestionsTable.COLUMN_ANSWER, question.getAnswer());
        db.insert(quiz_store.QuestionsTable.TABLE_NAME6, null, cv);
    }

    public ArrayList<Question_data> getAllQuestionsQ1() {
        ArrayList<Question_data> questionList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + quiz_store.QuestionsTable.TABLE_NAME1, null);
        if (c.moveToFirst()) {
            do {
                Question_data question = new Question_data();
                question.setQuestion(c.getString(c.getColumnIndex(quiz_store.QuestionsTable.COLUMN_QUESTION)));
                question.setOption1(c.getString(c.getColumnIndex(quiz_store.QuestionsTable.COLUMN_OPTION1)));
                question.setOption2(c.getString(c.getColumnIndex(quiz_store.QuestionsTable.COLUMN_OPTION2)));
                question.setOption3(c.getString(c.getColumnIndex(quiz_store.QuestionsTable.COLUMN_OPTION3)));
                question.setOption4(c.getString(c.getColumnIndex(quiz_store.QuestionsTable.COLUMN_OPTION4)));
                question.setAnswer(c.getInt(c.getColumnIndex(quiz_store.QuestionsTable.COLUMN_ANSWER)));
                questionList.add(question);
            } while (c.moveToNext());
        }
        c.close();
        return questionList;
    }
    public ArrayList<Question_data> getAllQuestionsQ2() {
        ArrayList<Question_data> questionList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + quiz_store.QuestionsTable.TABLE_NAME2, null);
        if (c.moveToFirst()) {
            do {
                Question_data question = new Question_data();
                question.setQuestion(c.getString(c.getColumnIndex(quiz_store.QuestionsTable.COLUMN_QUESTION)));
                question.setOption1(c.getString(c.getColumnIndex(quiz_store.QuestionsTable.COLUMN_OPTION1)));
                question.setOption2(c.getString(c.getColumnIndex(quiz_store.QuestionsTable.COLUMN_OPTION2)));
                question.setOption3(c.getString(c.getColumnIndex(quiz_store.QuestionsTable.COLUMN_OPTION3)));
                question.setOption4(c.getString(c.getColumnIndex(quiz_store.QuestionsTable.COLUMN_OPTION4)));
                question.setAnswer(c.getInt(c.getColumnIndex(quiz_store.QuestionsTable.COLUMN_ANSWER)));
                questionList.add(question);
            } while (c.moveToNext());
        }
        c.close();
        return questionList;
    }
    public ArrayList<Question_data> getAllQuestionsQ3() {
        ArrayList<Question_data> questionList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + quiz_store.QuestionsTable.TABLE_NAME3, null);
        if (c.moveToFirst()) {
            do {
                Question_data question = new Question_data();
                question.setQuestion(c.getString(c.getColumnIndex(quiz_store.QuestionsTable.COLUMN_QUESTION)));
                question.setOption1(c.getString(c.getColumnIndex(quiz_store.QuestionsTable.COLUMN_OPTION1)));
                question.setOption2(c.getString(c.getColumnIndex(quiz_store.QuestionsTable.COLUMN_OPTION2)));
                question.setOption3(c.getString(c.getColumnIndex(quiz_store.QuestionsTable.COLUMN_OPTION3)));
                question.setOption4(c.getString(c.getColumnIndex(quiz_store.QuestionsTable.COLUMN_OPTION4)));
                question.setAnswer(c.getInt(c.getColumnIndex(quiz_store.QuestionsTable.COLUMN_ANSWER)));
                questionList.add(question);
            } while (c.moveToNext());
        }
        c.close();
        return questionList;
    }
    public ArrayList<Question_data> getAllQuestionsQ4() {
        ArrayList<Question_data> questionList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + quiz_store.QuestionsTable.TABLE_NAME4, null);
        if (c.moveToFirst()) {
            do {
                Question_data question = new Question_data();
                question.setQuestion(c.getString(c.getColumnIndex(quiz_store.QuestionsTable.COLUMN_QUESTION)));
                question.setOption1(c.getString(c.getColumnIndex(quiz_store.QuestionsTable.COLUMN_OPTION1)));
                question.setOption2(c.getString(c.getColumnIndex(quiz_store.QuestionsTable.COLUMN_OPTION2)));
                question.setOption3(c.getString(c.getColumnIndex(quiz_store.QuestionsTable.COLUMN_OPTION3)));
                question.setOption4(c.getString(c.getColumnIndex(quiz_store.QuestionsTable.COLUMN_OPTION4)));
                question.setAnswer(c.getInt(c.getColumnIndex(quiz_store.QuestionsTable.COLUMN_ANSWER)));
                questionList.add(question);
            } while (c.moveToNext());
        }
        c.close();
        return questionList;
    }
    public ArrayList<Question_data> getAllQuestionsQ5() {
        ArrayList<Question_data> questionList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + quiz_store.QuestionsTable.TABLE_NAME5, null);
        if (c.moveToFirst()) {
            do {
                Question_data question = new Question_data();
                question.setQuestion(c.getString(c.getColumnIndex(quiz_store.QuestionsTable.COLUMN_QUESTION)));
                question.setOption1(c.getString(c.getColumnIndex(quiz_store.QuestionsTable.COLUMN_OPTION1)));
                question.setOption2(c.getString(c.getColumnIndex(quiz_store.QuestionsTable.COLUMN_OPTION2)));
                question.setOption3(c.getString(c.getColumnIndex(quiz_store.QuestionsTable.COLUMN_OPTION3)));
                question.setOption4(c.getString(c.getColumnIndex(quiz_store.QuestionsTable.COLUMN_OPTION4)));
                question.setAnswer(c.getInt(c.getColumnIndex(quiz_store.QuestionsTable.COLUMN_ANSWER)));
                questionList.add(question);
            } while (c.moveToNext());
        }
        c.close();
        return questionList;
    }
    public ArrayList<Question_data> getAllQuestionsQ6() {
        ArrayList<Question_data> questionList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + quiz_store.QuestionsTable.TABLE_NAME6, null);
        if (c.moveToFirst()) {
            do {
                Question_data question = new Question_data();
                question.setQuestion(c.getString(c.getColumnIndex(quiz_store.QuestionsTable.COLUMN_QUESTION)));
                question.setOption1(c.getString(c.getColumnIndex(quiz_store.QuestionsTable.COLUMN_OPTION1)));
                question.setOption2(c.getString(c.getColumnIndex(quiz_store.QuestionsTable.COLUMN_OPTION2)));
                question.setOption3(c.getString(c.getColumnIndex(quiz_store.QuestionsTable.COLUMN_OPTION3)));
                question.setOption4(c.getString(c.getColumnIndex(quiz_store.QuestionsTable.COLUMN_OPTION4)));
                question.setAnswer(c.getInt(c.getColumnIndex(quiz_store.QuestionsTable.COLUMN_ANSWER)));
                questionList.add(question);
            } while (c.moveToNext());
        }
        c.close();
        return questionList;
    }

}
