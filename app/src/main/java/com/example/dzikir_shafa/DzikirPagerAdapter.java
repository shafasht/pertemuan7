package com.example.dzikir_shafa;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.List;

public class DzikirPagerAdapter extends FragmentPagerAdapter {

    private List<DzikirModel> dzikirList;

    public DzikirPagerAdapter( FragmentManager fm, List<DzikirModel> dzikirList) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        this.dzikirList = dzikirList;
    }


    @Override
    public Fragment getItem(int position) {
        return DzikirFragment.newInstance(dzikirList.get(position));
    }

    @Override
    public int getCount() {
        return dzikirList.size();
    }
}
