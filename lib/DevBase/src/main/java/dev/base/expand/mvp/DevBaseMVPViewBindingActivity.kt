package dev.base.expand.mvp

import android.os.Bundle
import androidx.viewbinding.ViewBinding
import dev.base.expand.viewbinding.DevBaseViewBindingActivity

/**
 * detail: MVP Activity ViewBinding 基类
 * @author Ttt
 */
abstract class DevBaseMVPViewBindingActivity<P : MVP.Presenter<out MVP.IView, out MVP.IModel>, VB : ViewBinding> :
    DevBaseViewBindingActivity<VB>() {

    // MVP Presenter
    lateinit var mPresenter: P

    override fun onCreate(savedInstanceState: Bundle?) {
        // 创建 MVP 模式的 Presenter
        mPresenter = createPresenter()
        // 初始化操作
        super.onCreate(savedInstanceState)
    }

    override fun onDestroy() {
        super.onDestroy()
        // 取消 MVP 各个模块间的关联
        mPresenter.detachView()
    }

    /**
     * 初始化创建 Presenter
     * @return [MVP.Presenter]
     */
    abstract fun createPresenter(): P
}