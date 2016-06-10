package com.example.iningke.ciwu.fragment.factory;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

/**
 * Created by iningke on 2016/6/4.
 */

public class FragmentFactory  {

    public <T extends Fragment> void showFragment(Class<T> clzz, FragmentManager fm, int layId) {
        Fragment fragment = fm.findFragmentById(layId);
        try {
            if (fragment == null) {
                fm.beginTransaction().add(layId, clzz.newInstance(), clzz.getSimpleName()).commit();
            } else {
                fm.beginTransaction().replace(layId, clzz.newInstance(), clzz.getSimpleName()).commit();
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }




}
