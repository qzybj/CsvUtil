package com.brady.csvutil;

import com.brady.coreframe.FastApplication;
import com.brady.libutil.UtilsManager;

/**
 * Created by Clair
 *
 * @date 2017/8/9
 * @description
 */
public class CApplication extends FastApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        UtilsManager.init(this);
    }
}
