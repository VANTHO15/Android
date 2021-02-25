package com.nguyenvantho.maytrotho.View.TrangChu;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.ViewCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;

import com.facebook.AccessToken;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginManager;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.tabs.TabLayout;
import com.nguyenvantho.maytrotho.Adapter.ExpandAdapter;
import com.nguyenvantho.maytrotho.Adapter.ViewpagerAdapter;
import com.nguyenvantho.maytrotho.Model.DangNhap_DangKy.ModelDangNhap;
import com.nguyenvantho.maytrotho.Model.ObjectClass.LoaiSanPham;
import com.nguyenvantho.maytrotho.Model.TrangChu.XuLyMenu.PresenterLogicXuLyMenu;
import com.nguyenvantho.maytrotho.Presenter.TrangChu.ViewXuLyMenu;
import com.nguyenvantho.maytrotho.R;
import com.nguyenvantho.maytrotho.View.DangNhap_DangKy.DangNhapActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class TrangChuActivity extends AppCompatActivity implements ViewXuLyMenu, GoogleApiClient.OnConnectionFailedListener , AppBarLayout.OnOffsetChangedListener {

   Toolbar toolbar;
   TabLayout tabLayout;
   ViewPager viewPager;
   DrawerLayout drawerLayout;
   ActionBarDrawerToggle drawerToggle;
   ExpandableListView expandableListView;
    PresenterLogicXuLyMenu logicXuLyMenu;
    String tennguoidung="";
    AccessToken accessToken;
    Menu menu;
    MenuItem iTemDangNhap,menuItemDangXuat;

    ModelDangNhap modelDangNhap;
    GoogleApiClient mGoogleApiClient;
    GoogleSignInResult googleSignInResult;
    CollapsingToolbarLayout collapsingToolbarLayout;
    AppBarLayout appBarLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());

        setContentView(R.layout.trangchu_layout);

        toolbar= this.<Toolbar>findViewById(R.id.tollbar);
        tabLayout= this.<TabLayout>findViewById(R.id.tabs);
        viewPager= this.<ViewPager>findViewById(R.id.viewpager);
        drawerLayout= this.<DrawerLayout>findViewById(R.id.drawerlayout);
        expandableListView= this.<ExpandableListView>findViewById(R.id.epMenu);
        collapsingToolbarLayout= this.<CollapsingToolbarLayout>findViewById(R.id.collapsing_toolbar);
        appBarLayout= this.<AppBarLayout>findViewById(R.id.appbar);

        toolbar.setTitle("");
        setSupportActionBar(toolbar);

        drawerToggle= new ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.clode);
        drawerLayout.addDrawerListener(drawerToggle);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        drawerToggle.syncState();

        ViewpagerAdapter adapter= new ViewpagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        logicXuLyMenu= new PresenterLogicXuLyMenu(this);

        modelDangNhap= new ModelDangNhap();

        logicXuLyMenu.LayDanhSachMenu();
        logicXuLyMenu.LayTenNguoiDungFacebook();
        mGoogleApiClient= modelDangNhap.LayGoogleApiClient(this,this);

        appBarLayout.addOnOffsetChangedListener(this);

    }
    // menu 3 chấm
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menutrangchu,menu);
        this.menu= menu;
        iTemDangNhap= menu.findItem(R.id.itDangNhap);
         menuItemDangXuat= menu.findItem(R.id.itDangXuat);

         accessToken=logicXuLyMenu.LayTenNguoiDungFacebook();
        googleSignInResult=modelDangNhap.LayThongTinDangNhapGoogle(mGoogleApiClient);
         if(accessToken!=null)
         {
             GraphRequest graphRequest= GraphRequest.newMeRequest(accessToken, new GraphRequest.GraphJSONObjectCallback() {
                 @Override
                 public void onCompleted(JSONObject object, GraphResponse response) {
                     try {
                         tennguoidung=object.getString("name");
                         iTemDangNhap.setTitle(tennguoidung);
                         Log.d("token",tennguoidung);
                     } catch (JSONException e) {
                         e.printStackTrace();
                     }
                 }
             });
             Bundle parammeters= new Bundle();
             parammeters.putString("fields","name");
             graphRequest.setParameters(parammeters);
             graphRequest.executeAsync();
         }

         if(googleSignInResult!=null)
         {
             iTemDangNhap.setTitle(googleSignInResult.getSignInAccount().getDisplayName());
         }

         String tennv= modelDangNhap.LayCachedsDangNhap(this);
         if(!tennv.equals(""))
         {
             iTemDangNhap.setTitle(tennv);
         }


        if(accessToken!=null || googleSignInResult !=null  || !tennv.equals(""))
        {
            menuItemDangXuat.setVisible(true);
        }

        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(drawerToggle.onOptionsItemSelected(item))
        {
            return  true;
        }

        int id= item.getItemId();
        switch (id)
        {
            case R.id.itDangNhap:
            {
                if(accessToken == null && googleSignInResult==null && modelDangNhap.LayCachedsDangNhap(this).equals(""))
                {
                    Intent iDangNhap=new Intent(this, DangNhapActivity.class);
                    startActivity(iDangNhap);
                }
                break;
            }
            case R.id.itDangXuat:
            {
               if (accessToken!=null)
               {
                   LoginManager.getInstance().logOut();
                   this.menu.clear();
                   this.onCreateOptionsMenu(this.menu);
               }

               if(googleSignInResult!=null)
               {
                   Auth.GoogleSignInApi.signOut(mGoogleApiClient);
                   this.menu.clear();
                   this.onCreateOptionsMenu(this.menu);
               }
               if(!modelDangNhap.LayCachedsDangNhap(this).equals(""))
               {
                    modelDangNhap.CapNhatCachedDangNhap(this,"");
                   this.menu.clear();
                   this.onCreateOptionsMenu(this.menu);
               }

            }
        }
        return true;
    }

    @Override
    public void HienThiDanhSachMenu(List<LoaiSanPham> loaiSanPhamList) {
        ExpandAdapter expandAdapter= new ExpandAdapter(this,loaiSanPhamList);
        expandableListView.setAdapter(expandAdapter);
        expandAdapter.notifyDataSetChanged();
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    @Override
    public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
        if(collapsingToolbarLayout.getHeight()+verticalOffset<= 1.5*ViewCompat.getMinimumHeight(collapsingToolbarLayout))
        {
            LinearLayout linearLayout= appBarLayout.<LinearLayout>findViewById(R.id.LNsearch);
            linearLayout.animate().alpha(0).setDuration(500);
        }
        else
        {
            LinearLayout linearLayout= appBarLayout.<LinearLayout>findViewById(R.id.LNsearch);
            linearLayout.animate().alpha(1).setDuration(500);
        }
    }
    // end menu 3 chấm
}
