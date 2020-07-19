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
//         Pertanyaan q9 = new Pertanyaan("Bacalah pernyataan berikut ini !<br><br><ul><li>1.Beberapa organ wanita akan mengalami perubahan pasca melahirkan, seperti rahim yang bengkak dan kendur karena menampung bayi selama 9 bulan. Selain itu serviks, vagina dan vulva juga akan mengalami pembengkakan karena dilalui oleh bayi ketika bayi dilahirkan.</li><li>2.Daun sirih merupakan tanaman yang dapat digunakan untuk vaginal steaming. Berdasarkan penelitian daun sirih mengandung minyak atsiri dan zat anti mikroba yang berfungsi untuk mengerutkan luka dan mempercepat menyembuhan luka.</li></ul><br>Simpulan yang tepat untuk kedua wacana tersebut adalah….",""," A.Vaginal steaming merupakan cara yang tepat untuk mengobati luka pada organ intim wanita pasca melahirkan"," B.Daun siri mampu mengobati luka pada rahim"," C.Daun sirih yang diguaakan untuk vaginal steaming dapat memilihkan kondisi organ wanita karena mengandung minyak atsiri dan zat antimikroba"," D.Minyak atsiri dan zat antimikroba daun sirih dapat mengencangkan vagina"," E.Daun sirih digunakan untuk vaginal steaming karena mengandung antimikroba",2,3);
//         masukkanPertanyaan(q9);
//         Pertanyaan q10 = new Pertanyaan("Ibu Lulu merupakan seorang ibu muda yang memberikan ASI ekslusif kepada bayinya. Pemberian ASI ekslusif sangat baik untuk perkembangan dan pertumbuhan bayi. ASI yang terbentuk pertama kali dari kelenjar susu ibu yaitu kolostrum. Kolostrum wajib diberikan kepada bayi yang baru lahir. Alasan yang tepat mengapa kolostrum harus diberikan kepada bayi yang baru lahir adalah….",""," A.Kolostrum dapat membentuk antibodi pada bayi"," B.Kolostrum dapat membentuk tulang dan gigi pada bayi"," C.Kolostrum dapat membentuk sel tubuh pada bayi"," D.Kolostrum dapat membentuk enzim pertumbuhan pada bayi"," E.Kolostrum dapat meningkatkan sel darah pada bayi",2,1);
//         masukkanPertanyaan(q10);
//         Pertanyaan q11 = new Pertanyaan("gametogenesis5","Gambar tersebut merupakan bagan proses oogenesis. Berikut ini simpulan yang tepat mengenai oogenesis berdasarkan gambar tersebut adalah…."," A. Proses pembelahan pada oogenesis terjadi proses meiosis tanpa pembelahan mitosis"," B.Ootid yang terbentuk akibat proses pembelahan mitosis sebelum menjadi ovum"," C.Ovum yang terbentuk berasal dari ootid yang dibentuk pada proses meiosis II"," D.Oosit mengalami pembelahan meiosis pertama dan menjadi ootid"," E.Oogonium mengalami pembelahan mitosis menjadi oosit primer.",3,5);
//         masukkanPertanyaan(q11);
//         Pertanyaan q12 = new Pertanyaan("Rika adalah seorang ibu muda berusia 26 tahun yang akan melahirkan anak pertamanya. Pada saat akan melahirkan, ia sangat terlihat kesakitan. Ternyata tulang vaginanya sangat kecil sehingga Rika terlihat kesakitan. Setelah beberapa lama akhirnya bayi dapat keluar dari tulang vagina yang sempit karena adanya pengaruh hormon, hormon yang mempengaruhinya adalah….",""," A. LH"," B. FSH"," C. Progesteron"," D. Oksitosin"," E. Esterogen",2,4);
//         masukkanPertanyaan(q12);
//         Pertanyaan q13 = new Pertanyaan("ASI sangat baik untuk bayi yang baru lahir karena memiliki antibodi yang dapat mecegah penyakit, menurut anda, pernyataan yang tidak benar tentang ASI dibawah ini adalah….",""," A. ASI meningkatkan kasing sayang antara ibu dan anak"," B. ASI lebih steril dibandingkan dengan susu formula"," C. ASI mengandung antibodi yang baik bagi tubih bayi"," D. ASI mampu membunuh kuman penyakit yang masuk"," E.ASI lebih mahal dibandingkan dengan susu formula",2,5);
//         masukkanPertanyaan(q13);
//         Pertanyaan q14 = new Pertanyaan("<i>Vaginal steaming</i> selain untuk mengembalikan kondisi rahim juga dipercaya mampu mengembalikan stamina seksual. Stamina seksual pada setiap manusia dapat mengalami penurunan. Faktor penyebab terjadinya penurunan stamina seksual adalah….",""," A.Usia, diabetes, hipertensi, kadar kolestrol tinggi, mengidap HIV"," B.Usia, hipertensi, kolestrol rendah dan sering olahraga"," C.Kebugaran tubuh, ketikdakseimbangan testosteron dan hipertensi"," D.Usia, daya tahan tubuh yang baik dan diabetes"," E.Pengidap penyakit jantung, daya tahan tubuh yang baik dan kurang berolahraga",2,1);
//         masukkanPertanyaan(q14);
//         Pertanyaan q15 = new Pertanyaan("Fertilisasi, merupakan peroses bertemunya sel sperma dengan sel ovum. Menurut anda pernyataan yang tepat mengenai fertilisasi adalah…",""," A. Hialuronidase, enzim yang dapat melarutkan senyawa hialuronid pada korona radiata"," B.Akrosin, protease yang dapat menghancurkan glikoprotein pada zona pelusida "," C.Antifertilisin, antigen terhadap oosit sekunder sehingga sperma dapat melekat pada oosit sekunder"," D.Zona pelusida merupakan lapisan disebelah luar korona radiata"," E.Sel granulosit mengeluarkan senyawa tertentu sehingga zona pellusida tidak ditembus sperma lain",2,4);
//        masukkanPertanyaan(q15);
//         Pertanyaan q16 = new Pertanyaan("Rempah-rempah seperti kunyit, daun sirih dan temulawak dipercaya mampu mengatasi masalah keputihan pada wanita. Secara ilmiah ketiga tanaman tersebut dapat mengatasi masalah keputihan karena mengandung….",""," A.Kurkumin yang mampu membersihkan keputihan"," B. Zat antimikroba yang mampu melawan mikroba penyebab keputihan"," C.Serat, karbohidrat dan lemak yang mampu membunuh mikroba penyebab keputihan"," D.Minyak atsiri yang mampu membersihkan organ intim"," E.Tannin yang mampu mengusir mikroba penyebab keputihan",2,2);
//         masukkanPertanyaan(q16);
//         Pertanyaan q17 = new Pertanyaan("Kanker prostat merupakan kanker yang berkembang pada kelenjar prostat yang terdapat pada sistem reproduksi laki- laki. Di Indonesia insiden kanker prostat terjadi peningkatan hampir tiga kali lipat per tahunnya. Salah satu pengobatan kanker dengan menggunakan bahan herbal ialah dengan daun sirsak. Daun sirsak diyakini merupakan salah satu tanaman yang diyakini sebagai obat kanker. Secara ilmiah daun sirsak dapat mengobati kanker karena….",""," A.Daun sirsak mengandung senyawa acetogenin yang merupakan fitokimia yang efektif melawan sel-sel kanker"," B.Daun sirsak mengandung karbohidrat dan lemak yang mampu menghilangkan sel kanker"," C.Daun sirsak kaya dengan kalium, kalsium dan fosfor yang mampu menghilangkan sel kanker"," D.Daun sirsak mengandung senyawa tannin yang mampu membunuh sel kanker"," E.Daun sirsak mengandung senyawa antimikroba yang mampu",2,1);
//         masukkanPertanyaan(q17);
//         Pertanyaan q18 = new Pertanyaan("Sepasang suami istri pergi ke dokter untuk periksa karena sering mengalami nyeri pada punggung, nyeri haid yang sangat menyakitkan dan rasa sakit pada saat berhubungan seks. Setelah diperiksakan ternyata sang istri menderita endometriosis. Tindakan yang harus dilakukan oleh sang istri ialah….",""," A.Pengangkatan rahim"," B.Mengonsumsi asiklovir"," C.Berobat tradisonal"," D.Pengangkatan oviduk"," E.Penanganan secara periodik",2,5);
//         masukkanPertanyaan(q18);
//         Pertanyaan q19 = new Pertanyaan("Ketika seorang wanita mengalami menstruasi, ada beberapa larangan yang tidak boleh dilakukan oleh wanita haid salah satunya berhubungan seksual dengan suaminya, jika dikaji secara biologis dampak negatifnya menyebabkan….",""," A.Herpes genitalis"," B.Endometrium"," C.Endometriosis"," D.Infeksi dan luka mulut Rahim"," E.Kanker leher Rahim",2,4);
//         masukkanPertanyaan(q19);
//         Pertanyaan q20 = new Pertanyaan("Selama mengalami kehamilan, ibu Tuti dianjurkan untuk mengajak anak yang dikandungnya untuk berinteraksi dengan berbicara, mendengarkan musik, dan membacakan doa. Secara ilmiah pemberian rangsangan berupa suara kepada bayi dalam kandungan dapat….",""," A.Bayi dalam kandungan akan stres dan frekuensi detak jantung meningkat"," B.Bayi dalam kandungan akan bergerak aktif ketika mendengar suara dari luar"," C.Bayi dalam kandungan akan merasa nyaman dan membuat detak jantung bayi lebih tenang"," Bayi dalam kandungan diam saja dan tidak merespon karena suara dari luar tidak terdengar"," E.Membuat bayi kebisingan karena suara dari luar",2,3);
//         masukkanPertanyaan(q20);
//         Pertanyaan q21 = new Pertanyaan("Ukuran normal rahim seorang wanita diperkirakan sebesar buah pir, namun dapat membesar ratusan kali dari ukuran normalnya. Pasca melahirkan rahim dapat membengkak. Kondisi tersebut dapat dipulihkan dengan metode vaginal steaming. Berikut ini simpulan yang paling tepat dari wacana diatas adalah….",""," A.Rahim bisa berukuran lebih besar dari ukuran normal"," B.Vaginal steaming dapat mengencangkan rahim yang bengkak"," C.Kondisi rahim tidak akan cepat kembali keukuran normal apabila tidak melakukan vaginal steaming"," D.Rahim dalam keadaan bengkak tidak akan kembali ke keadaan normal"," E.Vaginal steaming dapat mempercepat pemulihan rahim yang bengkak",2,5);
//         masukkanPertanyaan(q21);
         Pertanyaan q22 = new Pertanyaan("Lusi adalah seorang remaja yang telah melewati masa pubertasnya. Tetapi diantara teman sebayanya, tanda sifat-sifat kelamin sekundernya belum nampak. Dari pernyataan tersebut, yang terjadi pada Lusi kemungkinan….",""," A.Kekurangan hormon esterogen dan progesteron"," B.Kelebihan hormon esterogen dan progesteron"," C.Kekurangan hormon esterogen dan gastrin"," option4"," option5",2,2);
         masukkanPertanyaan(q22);

        // Pertanyaan q6 = new Pertanyaan("soal1","teks"," option1"," option2"," option3"," option4"," option5",2,2);
////        masukkanPertanyaan(q6);


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
