package com.nguyenvantho.a30tho_taoappbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ShareActionProvider;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.MenuItemCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements androidx.appcompat.widget.SearchView.OnQueryTextListener {
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        toolbar= this.<Toolbar>findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.my_menu,menu);
        MenuItem searchview=menu.findItem(R.id.itSeach);

        androidx.appcompat.widget.SearchView searchView= (androidx.appcompat.widget.SearchView) searchview.getActionView();
        searchView.setOnQueryTextListener( MainActivity.this);

        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item)
    {
        int id=item.getItemId();
        switch (id)
        {
            case R.id.itThem:
                Toast.makeText(MainActivity.this,"Thêm",Toast.LENGTH_SHORT).show();
                break;
            case R.id.itSua:
                Toast.makeText(MainActivity.this,"Sửa",Toast.LENGTH_SHORT).show();
                break;
            case R.id.itXoa:
                Toast.makeText(MainActivity.this,"Xóa",Toast.LENGTH_SHORT).show();
                break;
            case R.id.itSeach:
                Toast.makeText(MainActivity.this,"Search",Toast.LENGTH_SHORT).show();
        }
        return true;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {  // Khi người dùng submit
        return false;
    }
    @Override
    public boolean onQueryTextChange(String newText) { // khi người dùng nhập
        Toast.makeText(MainActivity.this,newText,Toast.LENGTH_SHORT).show();
        return false;
    }
}