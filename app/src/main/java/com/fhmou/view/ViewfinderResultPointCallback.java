package com.fhmou.view;

import com.google.zxing.ResultPoint;
import com.google.zxing.ResultPointCallback;

/**
 * package com.fhmou.view
 * functional describe:
 *
 * @version 1.0 16-8-26 下午12:41
 * @auther luyanliang [765673481@qq.com]
 */
public final class ViewfinderResultPointCallback implements ResultPointCallback {

    private final ViewfinderView viewfinderView;

    public ViewfinderResultPointCallback(ViewfinderView viewfinderView) {
        this.viewfinderView = viewfinderView;
    }

    public void foundPossibleResultPoint(ResultPoint point) {
        viewfinderView.addPossibleResultPoint(point);
    }

}
