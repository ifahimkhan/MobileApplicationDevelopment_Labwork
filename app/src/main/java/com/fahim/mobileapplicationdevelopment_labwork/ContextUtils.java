package com.fahim.mobileapplicationdevelopment_labwork;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.LocaleList;

import java.util.Locale;

public class ContextUtils extends ContextWrapper {

    public ContextUtils(Context base) {
        super(base);
    }

    public static ContextUtils updateLocale(Context context, Locale localeToSwitchTo) {
        Resources resources = context.getResources();
        Configuration configuration = resources.getConfiguration(); // 1

        LocaleList localeList = new LocaleList(localeToSwitchTo); // 2
        LocaleList.setDefault(localeList); // 3
        configuration.setLocales(localeList); // 4

        Context updatedContext = context.createConfigurationContext(configuration); // 5

        return new ContextUtils(updatedContext);
    }
}