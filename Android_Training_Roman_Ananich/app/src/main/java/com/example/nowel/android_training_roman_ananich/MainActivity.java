package com.example.nowel.android_training_roman_ananich;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static android.icu.lang.UCharacter.toLowerCase;


public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private static User user;
    private static ViewPager viewPager;
    private static TabLayout tabLayout;
    private static ArrayList<Lesson> cartList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        // Sets the Toolbar to act as the ActionBar for this Activity window.
        // Make sure the toolbar exists in the activity and is not null
        setSupportActionBar(toolbar);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(this.getSupportFragmentManager());
        adapter.addFrag(new FirstFragment(), "ONE");
        adapter.addFrag(new SecondFragment(), "TWO");
        adapter.addFrag(new ThirdFragment(), "THREE");
        viewPager.setAdapter(adapter);
    }

    public static void addToCart(Lesson lesson) {
        cartList.add(lesson);
    }



    public static void newUser(String login,String pass,String name) {
        user=new User(login,pass,name);
    }


    public static ArrayList<Lesson> getCart() {
        return cartList;
    }

    //View Pager fragments setting adapter class
    class ViewPagerAdapter extends FragmentPagerAdapter {
        private List<Fragment> mFragmentList = new ArrayList<>();//fragment arraylist
        private List<String> mFragmentTitleList = new ArrayList<>();//title arraylist

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        //adding fragments and title method
        public void addFrag(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }



        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }


         /*   // Menu icons are inflated just as they were with actionbar
            @Override
            public boolean onCreateOptionsMenu(Menu menu) {
                // Inflate the menu; this adds items to the action bar if it is present.
                getMenuInflater().inflate(R.menu.menu_main, menu);

                final SearchView searchView = (SearchView) MenuItemCompat.getActionView(menu.findItem(R.id.action_search));
                SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
                searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
                searchView.setMaxWidth(Integer.MAX_VALUE);

                SearchView.OnQueryTextListener queryTextListener = new SearchView.OnQueryTextListener() {
                    public boolean onQueryTextChange(String newText) {
                        // This is your adapter that will be filtered
                        Toast.makeText(getApplicationContext(), "textChanged :" + newText, Toast.LENGTH_LONG).show();

                        return true;
                    }

                    public boolean onQueryTextSubmit(String query) {
                        // **Here you can get the value "query" which is entered in the icon_search box.**
                        String text =query;
                        Toast.makeText(getApplicationContext(), "searchvalue :" + query, Toast.LENGTH_LONG).show();
                        return true;
                    }
                };
                searchView.setOnQueryTextListener(queryTextListener);

                return true;
            }
*/
            @Override
            public boolean onOptionsItemSelected(MenuItem item) {
                // Handle action bar item clicks here. The action bar will
                // automatically handle clicks on the Home/Up button, so long
                // as you specify a parent activity in AndroidManifest.xml.
                int id = item.getItemId();

                //noinspection SimplifiableIfStatement
                if (id == R.id.action_search) {
                    onSearchRequested();
                    return true;
                }

                if (id == R.id.action_profile) {
                    Toast toast = Toast.makeText(getApplicationContext(), "Profile", Toast.LENGTH_SHORT);
                    toast.show();
                    return true;
                }

                if (id == R.id.action_cart) {
                    Toast toast = Toast.makeText(getApplicationContext(), "Cart", Toast.LENGTH_SHORT);//delete
                    toast.show();
                    return true;
                }

                return super.onOptionsItemSelected(item);
            }

        }
