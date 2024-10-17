package com.labs.healthify;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class DocDetActivity extends AppCompatActivity {

    private String[][] doctor_details1 =
    {
        {"Doctor Name : Prof. Dr. Muhammad Mahbub Hussain", "Hospital Address : Rangpur Medical College & Hospital", "Exp : 5yrs", "Mobile No: 4553452255425", "600"},
        {"Doctor Name : Dr. Md. Hasanuzzaman", "Hospital Address : Dhaka Medical College & Hospital", "Exp : 15yrs", "Mobile No:45898988", "900"},
        {"Doctor Name : Dr. Md. Mosharaf Hossain Palash", "Hospital Address : National Institute of Cancer Research & Hospital", "Exp : 8yrs", "Mobile No:8898989898" ,"300"},
        {"Doctor Name : Deepak Deshmukh", "Hospital Address : Ministry of Health and Family Welfare (MoHFW)", "Exp : 6yrs", "Mobile No:9898800000", "500"},
        {"Doctor Name : Dr. Muhammad Abdur Razzak", "Hospital Address : 250 Bed General Hospital, Manikganj", "Exp : 7yrs", "Mobile No:7798989898", "800"}
    };


    private String[][] doctor_details2 =
            {
                    {"Doctor Name : Dr. Istajul Khan", "Hospital Address : Bangabandhu Sheikh Mujib Medical University Hospital", "Exp : 5yrs", "Mobile No: 9898989898", "600"},
                    {"Doctor Name : Dr. Fahmida Khanam Shammi", "Hospital Address : 250 Bedded General Hospital, Pabna", "Exp : 15yrs", "Mobile No:7898989898", "900"},
                    {"Doctor Name : Dr. Md. Ashekin Abir", "Hospital Address : 250 Bedded General Hospital, Pabna", "Exp : 8yrs", "Mobile No:8898989898" ,"300"},
                    {"Doctor Name : Deepak Deshmukh", "Hospital Address : Bangabandhu Sheikh Mujib Medical University Hospital", "Exp : 6yrs", "Mobile No:9898800000", "500"},
                    {"Doctor Name : Ashok Panda", "Hospital Address : Marine City Medical College & Hospital", "Exp : 7yrs", "Mobile No:7798989898", "800"}
            };


    private String[][] doctor_details3 =
            {
                    {"Doctor Name : Dr. S. M. Shahidul Islam", "Hospital Address : General Secretary of Bangladesh Acupuncture Association", "Exp : 5yrs", "Mobile No: 9898989898", "600"},
                    {"Doctor Name : Dr. SMA Alim", "Hospital Address : Central Police Hospital", "Exp : 15yrs", "Mobile No:7898989898", "900"},
                    {"Doctor Name : Dr. Md. Mosharaf Hossain Palash", "Hospital Address : National Institute of Cancer Research & Hospital", "Exp : 8yrs", "Mobile No:8898989898" ,"300"},
                    {"Doctor Name : Deepak Deshmukh", "Hospital Address : Chinchwad", "Exp : 6yrs", "Mobile No:9898800000", "500"},
                    {"Doctor Name : Dr. Md. Mazharul Alam", "Hospital Address : Bangladesh Korea Friendship Government Hospital", "Exp : 7yrs", "Mobile No:7798989898", "800"}
            };


    private String[][] doctor_details4 =
            {
                    {"Doctor Name : Prof. Dr. Moinul Hossain", "Hospital Address : Bangabandhu Sheikh Mujib Medical University Hospital", "Exp : 5yrs", "Mobile No: 9898989898", "600"},
                    {"Doctor Name : Dr. Muhammad Shamsul Arefin", "Hospital Address : National Institute of Neurosciences & Hospital", "Exp : 15yrs", "Mobile No:7898989898", "900"},
                    {"Doctor Name : Prof. Dr. Jonaid Shafiq", "Hospital Address : Japan Bangladesh Friendship Hospital", "Exp : 8yrs", "Mobile No:8898989898" ,"300"},
                    {"Doctor Name : Brig. Gen. Prof. Dr. MHM Delwar Hossain", "Hospital Address : Combined Military Hospital, Dhaka", "Exp : 6yrs", "Mobile No:9898800000", "500"},
                    {"Doctor Name : Prof. Dr. AKM Akhtaruzzaman", "Hospital Address : Bangabandhu Sheikh Mujib Medical University Hospital", "Exp : 7yrs", "Mobile No:7798989898", "800"}
            };


    private String[][] doctor_details5 =
            {
                    {"Doctor Name : Dr. A.K.M. Asaduzzaman", "Hospital Address : Dhaka Medical College & Hospital", "Exp : 5yrs", "Mobile No: 9898989898", "600"},
                    {"Doctor Name : Prof. Dr. Md. Rezaul Hoque", "Hospital Address : Ibn Sina Medical College & Hospital", "Exp : 15yrs", "Mobile No:7898989898", "900"},
                    {"Doctor Name : Prof. Dr. Md. Mahbubul Hasan Monir", "Hospital Address : Square Hospital, Dhaka", "Exp : 8yrs", "Mobile No:8898989898" ,"300"},
                    {"Doctor Name : Dr. Lutful Aziz", "Hospital Address : Bangladesh Medical College & Hospital", "Exp : 6yrs", "Mobile No:9898800000", "500"},
                    {"Doctor Name : Dr. Shukha Ranjan Das", "Hospital Address : Evercare Hospital, Dhaka", "Exp : 7yrs", "Mobile No:7798989898", "800"}
            };

    TextView tv;
    Button btn;
    HashMap<String,String> item;
    ArrayList list;
    SimpleAdapter sa;
    String[][] doctor_detail = {};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doc_det);

        tv = findViewById(R.id.textViewDDTitle);
        btn = findViewById(R.id.buttonDDBack);
        Intent it = getIntent();
        String title = it.getStringExtra("title");
        tv.setText(title);

        if(title.compareTo("Family Physician")==0)
            doctor_detail=doctor_details1;
        else

        if(title.compareTo("Dietitian")==0)
        doctor_detail=doctor_details2;
        else

        if(title.compareTo("Dentist")==0)
            doctor_detail=doctor_details3;
        else

        if(title.compareTo("Surgeon")==0)
            doctor_detail=doctor_details4;
        else
            doctor_detail=doctor_details5;


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DocDetActivity.this,FinDocActivity.class));
            }
        });

        list = new ArrayList();

        for(int i=0;i<doctor_detail.length;i++){
            item = new HashMap<String,String>();
            item.put("Line1",doctor_detail[i][0]);
            item.put("Line2",doctor_detail[i][1]);
            item.put("Line3",doctor_detail[i][2]);
            item.put("Line4",doctor_detail[i][3]);
            item.put("Line5","Cons Fees : "+doctor_detail[i][4]+"/-");
            list.add(item);
        }
        sa = new SimpleAdapter(this,list,
                R.layout.multi_lines,
                new String[]{"Line1","Line2","Line3","Line4","Line5"},
                new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e});
        ListView lst = findViewById(R.id.listViewDD);
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(DocDetActivity.this ,BookAppointActivity.class);
                it.putExtra("text1",title);
                it.putExtra("text2",doctor_detail[i][0]);
                it.putExtra("text3",doctor_detail[i][1]);
                it.putExtra("text4",doctor_detail[i][3]);
                it.putExtra("text5",doctor_detail[i][4]);
                startActivity(it);
            }
        });
    }
}