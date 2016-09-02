package com.fhmou.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;

import com.fhmou.base.AppApplication;

import java.util.Set;

/**
 * package com.fhmou.utils
 * functional describe:
 *
 * @version 1.0 16-9-1 上午10:13
 * @auther luyanliang [765673481@qq.com]
 */
public class SPBase {

    protected static int INIT_METHOD_1 = 1;
    protected static int INIT_METHOD_2 = 2;
    protected static int INIT_METHOD_DEFAULT = INIT_METHOD_1;
    protected static final String USER_PREFERENCE_FILE_NAME = "user_preferences";
    private static volatile SharedPreferences mSP;

    public static boolean clear() {
        return getSharedPreferences().edit().clear().commit();
    }

    public static boolean getBoolean(String var1, boolean var2) {
        if (var1 == null) {
            return var2;
        }
        return getSharedPreferences().getBoolean(var1, var2);
    }

    public static double getDouble(String var1, double var2) {
        if (var1 == null) {
            return var2;
        }
        try {
            double d = Double.parseDouble(getSharedPreferences().getString(var1, String.valueOf(var2)));
            return d;
        } catch (Exception e) {
        }
        return var2;
    }

    public static float getFloat(String var1, float var2) {
        if (var1 == null) {
            return var2;
        }
        return getSharedPreferences().getFloat(var1, var2);
    }

    public static int getInt(String var1, int var2) {
        if (var1 == null) {
            return var2;
        }
        return getSharedPreferences().getInt(var1, var2);
    }

    public static long getLong(String var1, long var2) {
        if (var1 == null) {
            return var2;
        }
        return getSharedPreferences().getLong(var1, var2);
    }

    public static String getString(String var1, String var2) {
        if (var1 == null) {
            return var2;
        }
        return getSharedPreferences().getString(var1, var2);
    }

    @SuppressLint({"NewApi"})
    public static Set<String> getStringSet(String var1, Set<String> var2) {
        if (var1 == null) {
            return var2;
        }
        return getSharedPreferences().getStringSet(var1, var2);
    }

    public static SharedPreferences getSharedPreferences() {
        if (mSP == null) {
            initDefault(AppApplication.getInstance());
        }
        return mSP;
    }

    protected static void initDefault(Context context) {
        if (INIT_METHOD_DEFAULT == INIT_METHOD_1) {
            initSP(context);
            return;
        }
        initSP(context, USER_PREFERENCE_FILE_NAME);
    }

    protected static void initSP(Context context) {
        initSP(context, context.getPackageName());
    }

    protected static void initSP(Context context, String name) {
        if (mSP == null) {
            mSP = context.getApplicationContext().getSharedPreferences(name, Context.MODE_PRIVATE);            
        }
    }

    public static boolean putBoolean(String var1, boolean var2) {
        if (var1 == null) {
            return false;
        }
        return getSharedPreferences().edit().putBoolean(var1, var2).commit();
    }

    public static boolean putDouble(String var1, double var2) {
        return putString(var1, String.valueOf(var2));
    }

    public static boolean putFloat(String var1, float var2) {
        if (var1 == null) {
            return false;
        }
        return getSharedPreferences().edit().putFloat(var1, var2).commit();
    }

    public static boolean putInt(String var1, int var2) {
        if (var1 == null) {
            return false;
        }
        return getSharedPreferences().edit().putInt(var1, var2).commit();
    }

    public static boolean putLong(String var1, long var2) {
        if (var1 == null) {
            return false;
        }
        return getSharedPreferences().edit().putLong(var1, var2).commit();
    }

    public static boolean putString(String var1, String var2) {
        if (var1 == null) {
            return false;
        }
        return getSharedPreferences().edit().putString(var1, var2).commit();
    }

    @SuppressLint({"NewApi"})
    public static boolean putStringSet(String var1, Set<String> var2) {
        if (var1 == null) {
            return false;
        }
        return getSharedPreferences().edit().putStringSet(var1, var2).commit();
    }

    public static boolean remove(String var1) {
        if (var1 == null) {
            return false;
        }
        return getSharedPreferences().edit().remove(var1).commit();
    }
}
