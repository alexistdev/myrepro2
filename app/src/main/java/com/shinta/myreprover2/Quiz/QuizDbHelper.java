package com.shinta.myreprover2.Quiz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.shinta.myreprover2.Quiz.QuisKontrak.*;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class QuizDbHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "Myrepro.db";
    private static final int DATABASE_VERSION = 1;

    private SQLiteDatabase db;

    public QuizDbHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db = db;

        final String SQL_CREATE_QUESTIONS_TABLE = "CREATE TABLE " +
                QuestionsTable.TABLE_NAME + "(" +
                QuestionsTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuestionsTable.COLUMN_QUESTION + " TEXT, " +
                QuestionsTable.COLUMN_QUESTION2 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION1 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION2 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION3 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION4 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION5 + " TEXT, " +
                QuestionsTable.COLUMN_STATUS_PR + " INTEGER, " +
                QuestionsTable.COLUMN_ANSWER_NR + " INTEGER" +
                ")";
        db.execSQL(SQL_CREATE_QUESTIONS_TABLE);
        //fillQuestionsTable();
        buatTablePertanyaan();
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + QuestionsTable.TABLE_NAME);
        onCreate(db);
    }

    private void buatTablePertanyaan(){
//        Pertanyaan q1 = new Pertanyaan("Testis merupakan alat kelamin pria bagian dalam. Letaknya menggantung dan terbungkus oleh kantung yang disebut skrotum yang berfungsi sebagai pengatur suhu.  Testis berfungsi dalam pembentukan sperma. Pernyataan yang tepat adalah….","" ," A.Testis membutuhkan suhu khusus untuk pembentukan sperma", " B.Adanya skrotum dapat mempengaruhi letak testis", " C.Skrotum berfungsi sebagai kulit yang melindungi testis", " D.Testis membutuhkan suhu hangat untuk pembentukan sperma"," E.Skrotum berfungsi untuk mengalirkan darah",2, 1);
//        masukkanPertanyaan(q1);
//        Pertanyaan q2 = new Pertanyaan("Ovarium merupakan organ reproduksi wanita yang berfungsi sebagai tempat pembentukan sel telur yang disebut oogenesis. Proses oogenesis terjadi di dalam ovarium karena….","" ," A.Karena ovarium memiliki suhu yang cocok dalam pembentukan sel telur", " B.Karena di dalam ovarium terdapat oogonium diploid yang merupakan bakal dari sel telur", " C.Karena ovarium terdiri dari kortek dan medulla", " D.Karena ovarium terletak di sebelah kanan dan kiri rongga perut bagian bawah"," E .Karena ovarium mengandung bahan pembentuk sel yang disebut oosit primer", 2,2);
//        masukkanPertanyaan(q2);
//        Pertanyaan q3 = new Pertanyaan("gametogenesis2","Gambar tersebut merupakan bagan pembentukan sperma atau spermatogenesis. Pernyataan dibawah ini tentang spermatogenesis yang tidak benar adalah…."," A. Spermatosit primer berkembang menjadi spermatosit sekunder"," B.Spermatosit primer mengalami pembelahan meiosis pertama menjadi spermatid"," C.Spermatid kehilangan sitoplasma, berkembang ekor dan kemudian dikenal sebagai sel sperma"," D.Spermatosit sekunder berkembang menjadi spermatid yang akan menjadi sperma"," E.Proses pembelahan terjadi dua kali, yaitu meiosis I dan meiosis II",3,2);
//        masukkanPertanyaan(q3);
//        Pertanyaan q4 = new Pertanyaan("gametogenesis2","Simpulan yang tepat dari gambar bagan spermatogenesis tersebut adalah…."," A.Spematosit primer mengalami pembelahan meiosis pertama menjadi spermatid"," B.Proses pembelahan pada spermatogenesis terjadi proses meiosis tanpa pembelahan mitosis"," C.Sperma yang terbentuk berasal dari spermatid yang dibentuk pada proses meiosis II"," D.Spermatogonium mengalami pembelahan menjadi spermatosit sekunder"," E.Spermatid terbentuk akibat mengalami proses pembelahan mitosis sebelum menjadi sperma",3,3);
//        masukkanPertanyaan(q4);
//        Pertanyaan q5 = new Pertanyaan("Perhatikan pernyataan dibawah ini : <br><br> 1. Sel telur mengalami ovulasi <br> 2.estrogen dan progesterone rendah <br> 3.FSH dan LH meningkat <br> 4.Dinding endometrium meluruh <br><br> Berdasarkan pernyataan diatas, dapat disimpulkan bahwa….",""," A.Terjadinya fertilisasi dan kehamilan karena ovulasi dengan estrogen dan progesterone rendah"," B.Terjadinya menstruasi karena dinding rahim menebal akibat estrogen dan progesterone rendah"," C.Terjadinya perubahan karena ovarium mengalami ovulasi dengan keluarnya ovum dan bertemu dengan sperma"," D.Terjadinya proses implantasi janin yang terjadi di endometrium karena dipengaruhi FSH dan LH"," E.Terjadinya menstruasi karena FSH dan LH mempengaruhi ovarium mengalami ovulasi  dan mengeluarkan ovum",2,2);
//        masukkanPertanyaan(q5);
//        Pertanyaan q6 = new Pertanyaan("Sel telur dan sperma melebur membentuk zigot. Kevin berpendapat bahwa zigot terbentuk di oviduk sedangkan Doni berpendapat bahwa zigot terbentuk di rahim. Dari kedua pendapat tersebut, manakah uang kamu yakini ?",""," A.Pembentukan zigot terjadi pada endometrium"," B.Pembuahan sel telur dan sperma terjadi di rahim"," C.Zigot terbentuk dirahim, lalu tertanam di endometrium rahim"," D.Sel telur dan sperma melebur di oviduk"," E.Fertilisasi umumnya terjadi di rahim",2,3);
//        masukkanPertanyaan(q6);
//        Pertanyaan q7 = new Pertanyaan("Suket gajahan (<i>Artemisia vulgaris L.</i>) sering digunakan untuk menghentikan pendarahan setelah terdinya persalinan. Pendarahan akibat persalinan terjadi karena….",""," A.Proses persalinan berlangsung lama, pembuluh darah rahim robek"," B.Melahirkan bayi yang besar sehingga menyebabkan robeknya vagina"," C.Terjadi luka pada rahim dan pinggul yang sempit"," D.Ukuran bayi yang besar, proses persalinan lama dan panggul yang sempit"," E.Vagina robek, panggul kecil dan proses yang lama",2,1);
//        masukkanPertanyaan(q7);
//        Pertanyaan q8 = new Pertanyaan("testpack","Gambar tersebut merupakan tes pack hasil tes pada urin pada wanita yang seorang wanita, sehingga muncul tanda positif (+), tanda positif (+) pada  tes pack tersebut menunjukkan bahwa wanita tersebut sedang hamil. Munculnya tanda positif (+) pada tes pack setelah dicelupkan pada urin wanita hamil disebabkan oleh…."," A.Kadar hormon progesterone pada urin sangat tinggi"," B.Adanya hormon estrogen pada urin"," C.Kadar hormon LH pada urin rendah"," D.Adanya hormon HCG pada urin"," E.Adanya hormon FSH pada urin",3,4);
//        masukkanPertanyaan(q8);
         Pertanyaan q9 = new Pertanyaan("Bacalah pernyataan berikut ini !<br><br><ul><li>1.Beberapa organ wanita akan mengalami perubahan pasca melahirkan, seperti rahim yang bengkak dan kendur karena menampung bayi selama 9 bulan. Selain itu serviks, vagina dan vulva juga akan mengalami pembengkakan karena dilalui oleh bayi ketika bayi dilahirkan.</li><li>2.Daun sirih merupakan tanaman yang dapat digunakan untuk vaginal steaming. Berdasarkan penelitian daun sirih mengandung minyak atsiri dan zat anti mikroba yang berfungsi untuk mengerutkan luka dan mempercepat menyembuhan luka.</li></ul><br>Simpulan yang tepat untuk kedua wacana tersebut adalah….",""," option 1"," option 2"," option 3"," option 4"," option 5",2,2);
        masukkanPertanyaan(q9);
        // Pertanyaan q6 = new Pertanyaan("soal1","teks"," option 1"," option 2"," option 3"," option 4"," option 5",2,2);
//        masukkanPertanyaan(q6);

    }
    private void masukkanPertanyaan(Pertanyaan pertanyaan) {
        ContentValues cv = new ContentValues();
        cv.put(QuestionsTable.COLUMN_QUESTION, pertanyaan.getQuestion());
        cv.put(QuestionsTable.COLUMN_QUESTION2, pertanyaan.getQuestion2());
        cv.put(QuestionsTable.COLUMN_OPTION1, pertanyaan.getOption1());
        cv.put(QuestionsTable.COLUMN_OPTION2, pertanyaan.getOption2());
        cv.put(QuestionsTable.COLUMN_OPTION3, pertanyaan.getOption3());
        cv.put(QuestionsTable.COLUMN_OPTION4, pertanyaan.getOption4());
        cv.put(QuestionsTable.COLUMN_OPTION5, pertanyaan.getOption5());
        cv.put(QuestionsTable.COLUMN_STATUS_PR, pertanyaan.getStatusPr());
        cv.put(QuestionsTable.COLUMN_ANSWER_NR, pertanyaan.getAnswerNr());
        db.insert(QuestionsTable.TABLE_NAME,null,cv);
    }

    public List<Pertanyaan> getAllQuestions() {
        List<Pertanyaan> questionList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + QuestionsTable.TABLE_NAME, null);
        if(c.moveToFirst()) {
            do {
               Pertanyaan question = new Pertanyaan();
               question.setQuestion(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_QUESTION)));
               question.setQuestion2(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_QUESTION2)));
               question.setOption1(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION1)));
               question.setOption2(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION2)));
               question.setOption3(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION3)));
               question.setOption4(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION4)));
               question.setOption5(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION5)));
               question.setStatusPr(c.getInt(c.getColumnIndex(QuestionsTable.COLUMN_STATUS_PR)));
               question.setAnswerNr(c.getInt(c.getColumnIndex(QuestionsTable.COLUMN_ANSWER_NR)));
               questionList.add(question);
            } while (c.moveToNext());
        }
        c.close();
        return questionList;
    }
}
