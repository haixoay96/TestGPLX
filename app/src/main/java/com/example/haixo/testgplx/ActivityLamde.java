package com.example.haixo.testgplx;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.BoolRes;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.example.haixo.testgplx.test.Key;
import com.example.haixo.testgplx.test.Piece;
import com.example.haixo.testgplx.test.Test;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class ActivityLamde extends AppCompatActivity  implements View.OnClickListener{
    private ArrayList<Button> buttonArrayListBig = new ArrayList<Button>();
    private ArrayList<Button> buttonArrayListSmall = new ArrayList<Button>();
    private int positionCurrent;// bien luu vi tri cu fragment hien tai
    private int diemCurrent;// bien luu diem hien tai cua bai lam
    private boolean[] booleen = new boolean[30];// bien luu xem nguoi xu dung da next qua bai chua
    private DrawerLayout drawerLayout;
    private Toolbar toolbar;
    private int timeCount = 1200;
    private int mintue = timeCount/60;
    private int second = timeCount%60;
    private ViewPager viewPager;
    private ArrayList<Fragment> fragmentArrayList;
    private Test test;
    private String title;
    private MenuItem menuDiem;
    public static TextView done_cau;
    public static int cau = 0;

    // hàm xử lý sự kiện
    public void sukienDrawer(){
        Button cau1 = (Button)findViewById(R.id.cau1);
        Button check1 = (Button) findViewById(R.id.check1);
        buttonArrayListBig.add(cau1);
        buttonArrayListSmall.add(check1);
        cau1.setOnClickListener(this);

        Button cau2 = (Button)findViewById(R.id.cau2);
        Button check2 = (Button) findViewById(R.id.check2);
        buttonArrayListBig.add(cau2);
        buttonArrayListSmall.add(check2);
        cau2.setOnClickListener(this);

        Button cau3 = (Button)findViewById(R.id.cau3);
        Button check3 = (Button) findViewById(R.id.check3);
        buttonArrayListBig.add(cau3);
        buttonArrayListSmall.add(check3);
        cau3.setOnClickListener(this);

        Button cau4 = (Button)findViewById(R.id.cau4);
        Button check4 = (Button) findViewById(R.id.check4);
        buttonArrayListBig.add(cau4);
        buttonArrayListSmall.add(check4);
        cau4.setOnClickListener(this);

        Button cau5 = (Button)findViewById(R.id.cau5);
        Button check5 = (Button) findViewById(R.id.check5);
        buttonArrayListBig.add(cau5);
        buttonArrayListSmall.add(check5);
        cau5.setOnClickListener(this);

        Button cau6 = (Button)findViewById(R.id.cau6);
        Button check6 = (Button) findViewById(R.id.check6);
        buttonArrayListBig.add(cau6);
        buttonArrayListSmall.add(check6);
        cau6.setOnClickListener(this);

        Button cau7 = (Button)findViewById(R.id.cau7);
        Button check7 = (Button) findViewById(R.id.check7);
        buttonArrayListBig.add(cau7);
        buttonArrayListSmall.add(check7);
        cau7.setOnClickListener(this);

        Button cau8 = (Button)findViewById(R.id.cau8);
        Button check8 = (Button) findViewById(R.id.check8);
        buttonArrayListBig.add(cau8);
        buttonArrayListSmall.add(check8);
        cau8.setOnClickListener(this);

        Button cau9 = (Button)findViewById(R.id.cau9);
        Button check9 = (Button) findViewById(R.id.check9);
        buttonArrayListBig.add(cau9);
        buttonArrayListSmall.add(check9);
        cau9.setOnClickListener(this);

        Button cau10 = (Button)findViewById(R.id.cau10);
        Button check10 = (Button) findViewById(R.id.check10);
        buttonArrayListBig.add(cau10);
        buttonArrayListSmall.add(check10);
        cau10.setOnClickListener(this);

        Button cau11 = (Button)findViewById(R.id.cau11);
        Button check11 = (Button) findViewById(R.id.check11);
        buttonArrayListBig.add(cau11);
        buttonArrayListSmall.add(check11);
        cau11.setOnClickListener(this);

        Button cau12 = (Button)findViewById(R.id.cau12);
        Button check12 = (Button) findViewById(R.id.check12);
        buttonArrayListBig.add(cau12);
        buttonArrayListSmall.add(check12);
        cau12.setOnClickListener(this);

        Button cau13 = (Button)findViewById(R.id.cau13);
        Button check13 = (Button) findViewById(R.id.check13);
        buttonArrayListBig.add(cau13);
        buttonArrayListSmall.add(check13);
        cau13.setOnClickListener(this);

        Button cau14 = (Button)findViewById(R.id.cau14);
        Button check14 = (Button) findViewById(R.id.check14);
        buttonArrayListBig.add(cau14);
        buttonArrayListSmall.add(check14);
        cau14.setOnClickListener(this);

        Button cau15 = (Button)findViewById(R.id.cau15);
        Button check15 = (Button) findViewById(R.id.check15);
        buttonArrayListBig.add(cau15);
        buttonArrayListSmall.add(check15);
        cau15.setOnClickListener(this);

        Button cau16 = (Button)findViewById(R.id.cau16);
        Button check16 = (Button) findViewById(R.id.check16);
        buttonArrayListBig.add(cau16);
        buttonArrayListSmall.add(check16);
        cau16.setOnClickListener(this);

        Button cau17 = (Button)findViewById(R.id.cau17);
        Button check17 = (Button) findViewById(R.id.check17);
        buttonArrayListBig.add(cau17);
        buttonArrayListSmall.add(check17);
        cau17.setOnClickListener(this);

        Button cau18 = (Button)findViewById(R.id.cau18);
        Button check18 = (Button) findViewById(R.id.check18);
        buttonArrayListBig.add(cau18);
        buttonArrayListSmall.add(check18);
        cau18.setOnClickListener(this);

        Button cau19 = (Button)findViewById(R.id.cau19);
        Button check19 = (Button) findViewById(R.id.check19);
        buttonArrayListBig.add(cau19);
        buttonArrayListSmall.add(check19);
        cau19.setOnClickListener(this);

        Button cau20 = (Button)findViewById(R.id.cau20);
        Button check20 = (Button) findViewById(R.id.check20);
        buttonArrayListBig.add(cau20);
        buttonArrayListSmall.add(check20);
        cau20.setOnClickListener(this);

        Button cau21 = (Button)findViewById(R.id.cau21);
        Button check21 = (Button) findViewById(R.id.check21);
        buttonArrayListBig.add(cau21);
        buttonArrayListSmall.add(check21);
        cau21.setOnClickListener(this);

        Button cau22 = (Button)findViewById(R.id.cau22);
        Button check22 = (Button) findViewById(R.id.check22);
        buttonArrayListBig.add(cau22);
        buttonArrayListSmall.add(check22);
        cau22.setOnClickListener(this);

        Button cau23 = (Button)findViewById(R.id.cau23);
        Button check23 = (Button) findViewById(R.id.check23);
        buttonArrayListBig.add(cau23);
        buttonArrayListSmall.add(check23);
        cau23.setOnClickListener(this);

        Button cau24 = (Button)findViewById(R.id.cau24);
        Button check24 = (Button) findViewById(R.id.check24);
        buttonArrayListBig.add(cau24);
        buttonArrayListSmall.add(check24);
        cau24.setOnClickListener(this);

        Button cau25 = (Button)findViewById(R.id.cau25);
        Button check25 = (Button) findViewById(R.id.check25);
        buttonArrayListBig.add(cau25);
        buttonArrayListSmall.add(check25);
        cau25.setOnClickListener(this);

        Button cau26 = (Button)findViewById(R.id.cau26);
        Button check26 = (Button) findViewById(R.id.check26);
        buttonArrayListBig.add(cau26);
        buttonArrayListSmall.add(check26);
        cau26.setOnClickListener(this);

        Button cau27 = (Button)findViewById(R.id.cau27);
        Button check27 = (Button) findViewById(R.id.check27);
        buttonArrayListBig.add(cau27);
        buttonArrayListSmall.add(check27);
        cau27.setOnClickListener(this);

        Button cau28 = (Button)findViewById(R.id.cau28);
        Button check28 = (Button) findViewById(R.id.check28);
        buttonArrayListBig.add(cau28);
        buttonArrayListSmall.add(check28);
        cau28.setOnClickListener(this);

        Button cau29 = (Button)findViewById(R.id.cau29);
        Button check29 = (Button) findViewById(R.id.check29);
        buttonArrayListBig.add(cau29);
        buttonArrayListSmall.add(check29);
        cau29.setOnClickListener(this);

        Button cau30 = (Button)findViewById(R.id.cau30);
        Button check30 = (Button) findViewById(R.id.check30);
        buttonArrayListBig.add(cau30);
        buttonArrayListSmall.add(check30);
        cau30.setOnClickListener(this);

        Button kethuc = (Button)findViewById(R.id.ketthuc);
        kethuc.setOnClickListener(this);
    }
    // hàm đếm ngược thời gian
    public void timeDown(){
        final TextView dongho = (TextView)findViewById(R.id.dongho);
        new CountDownTimer(timeCount*1000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeCount-=1;
                mintue = timeCount/60;
                second = timeCount%60;
                if(second<10){
                    dongho.setText(mintue+":"+"0"+second);
                }
                else {
                    dongho.setText(mintue + ":" + second);
                }


            }

            @Override
            public void onFinish() {
                finishTest();
            }
        }.start();
    }
    public void getData() {
        test = (Test) getIntent().getSerializableExtra("data");
        title = getIntent().getStringExtra("title");

    }
    public boolean isCheckPiece( ArrayList<CheckBox> checkBoxes){
        for(int i = 0; i<checkBoxes.size();i++){
            if(checkBoxes.get(i).isChecked()){
                return true;
            }
        }
        return false;

    }
    @Override
    public void onClick(View v) {
        int n = v.getId();
        switch (n){
            case R.id.cau1:
                viewPager.setCurrentItem(0);
                break;
            case R.id.cau2:
                viewPager.setCurrentItem(1);
                break;
            case R.id.cau3:
                viewPager.setCurrentItem(2);
                break;
            case R.id.cau4:
                viewPager.setCurrentItem(3);
                break;
            case R.id.cau5:
                viewPager.setCurrentItem(4);
                break;
            case R.id.cau6:
                viewPager.setCurrentItem(5);
                break;
            case R.id.cau7:
                viewPager.setCurrentItem(6);
                break;
            case R.id.cau8:
                viewPager.setCurrentItem(7);
                break;
            case R.id.cau9:
                viewPager.setCurrentItem(8);
                break;
            case R.id.cau10:
                viewPager.setCurrentItem(9);
                break;
            case R.id.cau11:
                viewPager.setCurrentItem(10);
                break;
            case R.id.cau12:
                viewPager.setCurrentItem(11);
                break;
            case R.id.cau13:
                viewPager.setCurrentItem(12);
                break;
            case R.id.cau14:
                viewPager.setCurrentItem(13);
                break;
            case R.id.cau15:
                viewPager.setCurrentItem(14);
                break;
            case R.id.cau16:
                viewPager.setCurrentItem(15);
                break;
            case R.id.cau17:
                viewPager.setCurrentItem(16);
                break;
            case R.id.cau18:
                viewPager.setCurrentItem(17);
                break;
            case R.id.cau19:
                viewPager.setCurrentItem(18);
                break;
            case R.id.cau20:
                viewPager.setCurrentItem(19);
                break;
            case R.id.cau21:
                viewPager.setCurrentItem(20);
                break;
            case R.id.cau22:
                viewPager.setCurrentItem(21);
                break;
            case R.id.cau23:
                viewPager.setCurrentItem(22);
                break;
            case R.id.cau24:
                viewPager.setCurrentItem(23);
                break;
            case R.id.cau25:
                viewPager.setCurrentItem(24);
                break;
            case R.id.cau26:
                viewPager.setCurrentItem(25);
                break;
            case R.id.cau27:
                viewPager.setCurrentItem(26);
                break;
            case R.id.cau28:
                viewPager.setCurrentItem(27);
                break;
            case R.id.cau29:
                viewPager.setCurrentItem(28);
                break;
            case R.id.cau30:
                viewPager.setCurrentItem(29);
                break;
            case R.id.ketthuc:
                finishTest();
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menulamde, menu);
        menuDiem = menu.findItem(R.id.menu_diem);
        menuDiem.setTitle("0");
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lam_de);
        cau = 0;
        timeDown();
        getData();
        done_cau = (TextView) findViewById(R.id.done_cau);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(title);
        initNavigationDrawer();
        sukienDrawer();
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        fragmentArrayList = new ArrayList<Fragment>();
        for (int i = 0; i < test.getPieceArrayList().size(); i++) {
            fragmentArrayList.add(new FragmentQuestion(test.getPieceArrayList().get(i), i + 1,buttonArrayListBig.get(i),buttonArrayListSmall.get(i)));

        }
        AdapterViewPager adapterViewPager = new AdapterViewPager(getSupportFragmentManager(), fragmentArrayList);
        viewPager.setAdapter(adapterViewPager);
       // viewPager.setCurrentItem(0);
        positionCurrent = 0;
        diemCurrent = 0;
        for(int i = 0; i<30;i++){
            booleen[i] = false;
        }


        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
             //   Toast.makeText(ActivityLamde.this,position+" "+viewPager.getCurrentItem(),Toast.LENGTH_SHORT).show();
                // do something
                Piece piece = test.getPieceArrayList().get(positionCurrent);
                Key key = piece.getPart_key();
                String answer = "";
                if(booleen[positionCurrent]==false) {
                    if (isCheckPiece(piece.getCheckBoxes())) {
                        for (int i = 0; i < piece.getCheckBoxes().size(); i++) {
                            if (piece.getCheckBoxes().get(i).isChecked()) {
                                answer += (i + 1);
                            }
                            piece.getCheckBoxes().get(i).setEnabled(false);
                        }
                        if (answer.equals(key.getKey())) {
                            diemCurrent++;
                            buttonArrayListSmall.get(positionCurrent).setBackgroundColor(Color.GREEN);
                            buttonArrayListBig.get(positionCurrent).setBackgroundColor(Color.GREEN);

                        } else {
                            buttonArrayListSmall.get(positionCurrent).setBackgroundColor(Color.RED);
                            buttonArrayListBig.get(positionCurrent).setBackgroundColor(Color.RED);
                        }
                        booleen[positionCurrent] = true;
                    }
                    menuDiem.setTitle(diemCurrent+"");


                }
                positionCurrent = position;

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


    }

    public boolean onOptionsItemSelected(MenuItem item) {

        int n = item.getItemId();
        switch (n){
            case R.id.check:
                finishTest();
        }
        return super.onOptionsItemSelected(item);
    }
    // hàm xử lý sau khi kết thúc bài
    public void finishTest(){
        int diem =0;
        ArrayList<String> stringArrayList = new ArrayList<String>();
        for(int i= 0; i< test.getPieceArrayList().size();i++){
            String key = "";
            for(int j = 0 ;j<test.getPieceArrayList().get(i).getCheckBoxes().size();j++){
                if(test.getPieceArrayList().get(i).getCheckBoxes().get(j).isChecked()){
                    key+= (j+1);
                }
            }

            stringArrayList.add(key);
        }

        for(int i =0;i<test.getPieceArrayList().size();i++){
            if(test.getPieceArrayList().get(i).getPart_key().getKey().equals(stringArrayList.get(i))){
                diem++;
            }
        }
        ArrayList<String> listKey = new ArrayList<String>();
        Intent intent = new Intent(this,ReviewResult.class);
        for(int i = 0; i<test.getPieceArrayList().size();i++){
            listKey.add(test.getPieceArrayList().get(i).getPart_key().getKey());

        }
        Test.test = test;
        intent.putExtra("timedo",1200-timeCount);
        intent.putExtra("title", title);
        intent.putExtra("key", listKey);
        intent.putExtra("dapan", stringArrayList);
        startActivity(intent);
        finish();

    }

    public void initNavigationDrawer() {

       /* NavigationView navigationView = (NavigationView)findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {

                int id = menuItem.getItemId();

                switch (id){
                    case R.id.home:
                        Toast.makeText(getApplicationContext(),"Home",Toast.LENGTH_SHORT).show();
                        drawerLayout.closeDrawers();
                        break;
                   *//* case R.id.settings:
                        Toast.makeText(getApplicationContext(),"Settings",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.trash:
                        Toast.makeText(getApplicationContext(),"Trash",Toast.LENGTH_SHORT).show();
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.logout:
                        finish();
*//*
                }
                return true;
            }
        });*/
        drawerLayout = (DrawerLayout)findViewById(R.id.drawer);

        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.drawer_open,R.string.drawer_close){

            @Override
            public void onDrawerClosed(View v){
                super.onDrawerClosed(v);
            }

            @Override
            public void onDrawerOpened(View v) {
               super.onDrawerOpened(v);
            }
        };
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
    }

}
